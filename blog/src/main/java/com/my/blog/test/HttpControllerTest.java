package com.my.blog.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpControllerTest {
	
	private static final String TAG = "HttpControllerTest :";
	
//	http://localhost:8090/blog/http/lombok
	@GetMapping("/http/lombok")
	public String lombokTest() {
//		Member m = new Member(1, "admin", "a1234", "admin@gmail.com");
//		빌더패턴은 매개변수 순서 상관 x
		Member m = Member.builder().username("admin").password("a1234").email("admin@gmail.com").build();
		System.out.println(TAG+"getter : "+m.getId());
		m.setId(5000);
		System.out.println(TAG+"getter : "+m.getId());
		
		return "lombok test 완료";
	}
	
	@GetMapping("/http/get")
	public String getTest(Member m) {
		
		return "get 요청 :" +m.getId()+","+m.getUsername()+","+m.getPassword()+","+m.getEmail();
	}

}
