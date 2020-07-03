package jvm.data.area;


import java.io.File;
import java.lang.management.ClassLoadingMXBean;
import java.lang.management.ManagementFactory;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

/**
 * 对于HotSpot虚拟机而言，在JDK 1.8以前，方法区被实现为“永久代”（Permanent Generation），
 * 属于堆的逻辑组成部分，并提供了两个参数调节其大小，-XX:PermSize用于设定初始容量，-XX:MaxPermSize用于设定最大容量。
 * JDK 1.8之后，HotSpot不再有“永久代”的概念，类的元信息数据迁移到被称为“元空间”（Metaspace）的新区域，而静态变量、常量等则存储于堆中。
 * 
 * -Xms500m -Xmx500m -XX:MetaspaceSize=3m -XX:MaxMetaspaceSize=10m -XX:+PrintGCDetails -Xloggc:./gc.log -XX:+HeapDumpOnOutOfMemoryError
 */
public class JVMMethodArea {
    public static void main(String[] args) {
        try {
            //准备url  
            URL url = new File("/tmp/classes").toURI().toURL();
            URL[] urls = {url};
            //获取有关类型加载的JMX接口  
            ClassLoadingMXBean loadingBean = ManagementFactory.getClassLoadingMXBean();
            //用于缓存类加载器  
            List<ClassLoader> classLoaders = new ArrayList<ClassLoader>();
            while (true) {
                //加载类型并缓存类加载器实例  
                ClassLoader classLoader = new URLClassLoader(urls);
                classLoaders.add(classLoader);
                classLoader.loadClass("jvm.data.area.ClassA");
                //显示数量信息（共加载过的类型数目，当前还有效的类型数目，已经被卸载的类型数目）  
                System.out.println("total: " + loadingBean.getTotalLoadedClassCount());
                System.out.println("active: " + loadingBean.getLoadedClassCount());
                System.out.println("unloaded: " + loadingBean.getUnloadedClassCount());
                Thread.sleep(100);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
