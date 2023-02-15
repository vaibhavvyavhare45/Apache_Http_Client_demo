package com.prowings;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class Java11HttpClientDemo {
	public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

//		HttpRequest getReq = HttpRequest.newBuilder().uri(new URI("http://localhost:8080/customer/104")).build();
//
//		HttpClient client = HttpClient.newBuilder().build();
//
//		HttpResponse<String> response = client.send(getReq, BodyHandlers.ofString());
//
//		System.out.println(response.body());
//		System.out.println(response.statusCode());
//		
		HttpRequest postReq=HttpRequest.newBuilder()
				.uri(new URI("http://localhost:8080/customer"))
				.header("Content-type", "application/json")
				.POST(HttpRequest.BodyPublishers.ofString("{\"id\":109,\"name\":\"ramkrushna\",\"address\":\"nagpur\"}"))
				.build();
		HttpClient client1=HttpClient.newBuilder().build();
		HttpResponse<String> response1= client1.send(postReq, BodyHandlers.ofString());
		System.out.println(response1.body());
		System.out.println(response1.statusCode());

}

}
