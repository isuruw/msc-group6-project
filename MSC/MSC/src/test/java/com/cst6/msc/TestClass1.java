package com.cst6.msc;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;


public class TestClass1 {

	public static void main(String[] args) {
		String url = "http://localhost:8080/TEST/XYZ.html";
		url = url.substring(url.lastIndexOf("TEST") + 1, url.length());
		
		
		System.out.println(url);
		
		
		String path = "/abc/def/ghfj.doc";
		// Split path into segments
		String segments[] = path.split("/");
		// Grab the last segment
		String document = segments[segments.length - 2];
		
		System.out.println(document);
		
		System.out.println(new Md5PasswordEncoder().encodePassword("123", "sas"));

	}

}
