package bigdata.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class MyProducer {
    public static void main(String[] args) throws InterruptedException {
        Properties props = new Properties();
        props.put("bootstrap.servers", "cdh2:9092,cdh3:9092,cdh4:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        String topic = "ztp-test";
        Producer<String, String> producer = new KafkaProducer<>(props);
        for (int i = 1; i <= 100000; i++) {
            String value = "str" + i;
            System.out.println(value);
            ProducerRecord<String, String> msg = new ProducerRecord<>(topic, value);
            producer.send(msg);
            Thread.sleep(1000/3);
        }
        producer.close();
    }
}
