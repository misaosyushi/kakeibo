package com.example.demo.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.domein.Payment;
import com.example.demo.domein.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AjaxService {

	/**
	 * JSON文字列→Userオブジェクト
	 * 
	 * @return
	 */
	public User jsonToUser(String json) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			User user = mapper.readValue(json, User.class);
			return user;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonToUser(json);
	}
	
	/**
	 * JSON文字列→Paymentオブジェクト
	 * 
	 * @return
	 */
	//TODO:date型で管理できるように
	public Payment jsonToPayment(String json) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			Payment payment = mapper.readValue(json, Payment.class);
			return payment;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonToPayment(json);
	}
	
	/**
	 * List<Payment>→JSON文字列
	 * 
	 * @return
	 */

	public String paymenrToJson(List<Payment> list) {
		String json = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			json = mapper.writeValueAsString(list);
			return json;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "json";
	}

	/**
	 * Userオブジェクト→JSON文字列
	 * 
	 * @return
	 */

	public String userToJson(String jsonUser) {
		User user = new User();
		ObjectMapper mapper = new ObjectMapper();
		try {
			jsonUser = mapper.writeValueAsString(user);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "jsonUser";
	}

}
