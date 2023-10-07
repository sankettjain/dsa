package com.pratice.dsa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Stack;

@SpringBootApplication
public class DsaApplication {

	public static void main(String[] args) {
		Stack<Integer> a= new Stack<>();
		SpringApplication.run(DsaApplication.class, args);
	}

}
