package com.prowings;

import java.io.IOException;

import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


public class ApacheHttpClientDemo {
	
	public static void main(String[] args) throws IOException, ParseException {
	
	CloseableHttpClient client=HttpClients.createDefault(); 
	HttpGet get=new HttpGet("http://localhost:8080/customer/106");
	CloseableHttpResponse response= client.execute(get);
//	InputStream input =response.getEntity().getContent();
//	Scanner sc=new Scanner(input);
//	while(sc.hasNext()) {
//		System.out.println(sc.nextLine());
//	}
//another way calling from java code to api
	String res=EntityUtils.toString(response.getEntity());
	System.out.println(res);
	
	// for post method in 
 HttpPost post=new HttpPost("http://localhost:8080/customer");

 final String json = "{\"id\":107,\"name\":\"Sham\",\"address\":\"Mumbai\"}";
	final StringEntity entity = new StringEntity(json);//converting  string to entity
	post.setHeader("Content-type", "application/json");
	post.setEntity(entity);
	
	CloseableHttpResponse postResponse = client.execute(post);
	String postRes = EntityUtils.toString(postResponse.getEntity());
	System.out.println(postRes);

	
	
	
	
	}

}
