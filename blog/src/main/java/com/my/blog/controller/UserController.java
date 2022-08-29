package com.my.blog.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.my.blog.config.auth.PrincipalDetail;
import com.my.blog.model.OAuthToken;


// 인증이 안된 사용자이 출입 가능한 경로는 /auth/** 허용
// 주소가 ' / ' 이면 index.jsp 허용
// static 이하에 있는 /js/**, /css/**, /image/**


@Controller
public class UserController {
	
	@GetMapping("auth/joinForm")
	public String joinForm() {
				
		return "user/joinForm";
	}
	
	
	@GetMapping("auth/loginForm")
	public String loginForm() {
		
		return "user/loginForm";
	}
	
//	@JsonIgnoreProperties(ignoreUnknown=true)
//	@GetMapping("auth/kakao/callback")
//	public @ResponseBody String kakaoCallback(String code) { //Data를 리턴해주는 컨트롤러 함수
//		
//		// POST방식으로 key=value 데이터를 요청 (카카오쪽으로)
//		// Retrofit2
//		// OkHttp
//		// RestTemplate
//		RestTemplate rt = new RestTemplate();
//		
//		// HttpHeaders 오브젝트 생성
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("Content-type","application/x-www-form-urlencoded;charset=utf-8");
//		
//		// HttpBody 오브젝트 생성
//		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
//		params.add("grant_type", "authorization_code");
//		params.add("client_id", "3f61157625ebef21dfe3dad1a27a239e");
//		params.add("redirect_uri", "http://localhost:8090/auth/kakao/callback");
//		params.add("code", code);
//		
//		// HttpHeaders와 HttpBody를 하나의 오브젝트에 담기
//		HttpEntity<MultiValueMap<String,String>> kakaoTokenRequest =new HttpEntity<>(params, headers);
//		
//		// Http 요청하기 - POST 방식으로 - response 변수의 응답 받음
//		ResponseEntity<String> response = rt.exchange(
//				"https://kauth.kakao.com/oauth/token",
//				HttpMethod.POST,
//				kakaoTokenRequest,
//				String.class
//		);
//		
//		// Gson, Json Simple, ObjectMapper
//		ObjectMapper objectMapper = new ObjectMapper();
//		OAuthToken oauthToken =null;
//		try {
//			oauthToken = objectMapper.readValue(response.getBody(), OAuthToken.class);
//		} catch (JsonMappingException e) {
//			e.printStackTrace();
//		} catch (JsonProcessingException e) {
//			e.printStackTrace();
//		}
//		
//		System.out.println("카카오 엑세스 토큰 : "+oauthToken.getAccess_token());
//		
//		RestTemplate rt2 = new RestTemplate();
//		
//		// HttpHeaders 오브젝트 생성
//		HttpHeaders headers2 = new HttpHeaders();
//		headers2.add("Authorization",  "Bearer" +oauthToken.getAccess_token());
//		headers2.add("Content-type","application/x-www-form-urlencoded;charset=utf-8");
//				
//		// HttpHeaders와 HttpBody를 하나의 오브젝트에 담기
//		HttpEntity<MultiValueMap<String,String>> kakaoProfileRequest2 =
//				new HttpEntity<>(headers2);
//		
//		// Http 요청하기 - POST 방식으로 - response 변수의 응답 받음
//		ResponseEntity<String> response2 = rt2.exchange(
//				"https://kapi.kakao.com/v2/user/me",
//				HttpMethod.POST,
//				kakaoProfileRequest2,
//				String.class
//		);
//		System.out.println(response2.getBody());
//		return response2.getBody();
//	}
	
	@GetMapping("user/updateForm")
	public String updateForm(@AuthenticationPrincipal PrincipalDetail principal) {
		
		return "user/updateForm";
	}
	
}
