package com.test.entelgy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import com.test.entelgy.dto.request.ExternalUserResponseDataDto;
import com.test.entelgy.dto.request.ExternalUserResponseDto;
import com.test.entelgy.dto.response.UserResponseDto;
import com.test.entelgy.service.UsersService;

import reactor.core.publisher.Mono;

import org.springframework.web.reactive.function.client.WebClient;

@Service
public class UserServiceImpl  implements UsersService{
	@Value("${entelgy.url}")
	private String url;
	
	public UserResponseDto getUsers() {
		UserResponseDto userResponseDto=new UserResponseDto();
		ExternalUserResponseDto externalUserResponseDto=getExternalUserList();
		String str="";
		List<String> dataResponse=new ArrayList<>();
		for(ExternalUserResponseDataDto data: externalUserResponseDto.getData()) {
			str="";
			str=str+data.getId()+"|"+data.getLastName()+"|"+data.getEmail();
			userResponseDto.setData(dataResponse);
		}
		return userResponseDto;
		
		
	}
	private ExternalUserResponseDto getExternalUserList() {
			WebClient webClient = WebClient.builder().baseUrl(url)
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();

		Mono<ExternalUserResponseDto> rs = webClient.get().uri("")
				.retrieve().bodyToMono(ExternalUserResponseDto.class);
		return rs.block();
	}

}
