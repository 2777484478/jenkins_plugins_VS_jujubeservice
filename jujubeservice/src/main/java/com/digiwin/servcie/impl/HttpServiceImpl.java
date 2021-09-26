package com.digiwin.servcie.impl;
import java.io.IOException;
import java.util.Base64;
import java.util.Map;

import com.digiwin.servcie.HttpService;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;


@Service
public class HttpServiceImpl implements HttpService {


    @Override
    public int httpClientWithBasicAuth(String project) {
        try {
            // 创建HttpClientBuilder
            String username = "xxxx";
            String password = "xxxx";
            String uri = "http://xxxxxxx:8080/jenkins/job/" + project +"/buildWithParameters?token=xxxxxxxx";

            HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
            CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
            HttpPost httpPost = new HttpPost(uri);
            //添加http头信息
            httpPost.addHeader("Authorization", "Basic " + Base64.getUrlEncoder().encodeToString((username + ":" + password).getBytes()));

            MultipartEntityBuilder builder = MultipartEntityBuilder.create();



            HttpEntity postEntity = builder.build();
            httpPost.setEntity(postEntity);
            String result = "";
            HttpResponse httpResponse = null;
            HttpEntity entity = null;
            try {
                httpResponse = closeableHttpClient.execute(httpPost);
                entity = httpResponse.getEntity();
                if( entity != null ){
                    result = EntityUtils.toString(entity);
                }
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // 关闭连接
            closeableHttpClient.close();

            System.out.println(result);
        }catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
        return 0;
    }
}

