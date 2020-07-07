package caigou.service;

import com.alibaba.fastjson.JSONObject;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class CDHController {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/restart-cdh")
    @ResponseBody
    public List<String> restartCluster(@RequestParam(name="name", required=false, defaultValue="Stranger") String name) {
        HttpHeaders headers = new HttpHeaders();

        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        // 增加 basic 认证头
        String plainCredentials = "admin:admin";
        byte[] plainCredentialsBytes = plainCredentials.getBytes();
        byte[] base64CredentialsBytes = Base64.encodeBase64(plainCredentialsBytes);
        String base64Credentials = new String(base64CredentialsBytes);
        headers.add("Authorization", "Basic " + base64Credentials);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        String jsonHosts = restTemplate.exchange("http://cdh1:7180/api/v18/hosts", HttpMethod.GET, entity, String.class).getBody();
        JSONObject jsonObject = JSONObject.parseObject(jsonHosts);
        Object items = jsonObject.get("items");
        List<CDHHost> hosts = JSONObject.parseArray(jsonObject.get("items").toString(), CDHHost.class);

        List<String> hostsIP = new ArrayList<>();
        for (CDHHost host : hosts) {
            hostsIP.add(host.getIpAddress());
        }
        return hostsIP;
    }
}
