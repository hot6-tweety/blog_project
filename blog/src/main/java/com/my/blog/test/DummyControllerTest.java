package com.my.blog.test;

import java.util.List;
import java.util.function.Supplier;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.my.blog.model.RoleType;
import com.my.blog.model.User;
import com.my.blog.repository.UserRepository;

@RestController
public class DummyControllerTest {
	
	@Autowired // 의존성 주입 (DI)
	private UserRepository userRepository;
	
	// save함순느 id를 전달하지 않으면 insert를 해주고
	// id를 전달하면 해당 id에 대한 데이터가 있으면 update를 해주고
	// id를 전달하면 해당 id에 대한 데이터가 없으면 insert를 한다.
	// email, password 수정
	
	@DeleteMapping("/dummy/user/{id}")
	public String delete(@PathVariable int id) {
		try {
			userRepository.deleteById(id);
		}catch(Exception e) {
			return "삭제에 실패하였습니다. 해당 아이디는 존재하지 않습니다. id: " +id;
		}
		return "삭제되었습니다. id: " +id;
	}
	
	@Transactional //함수 종료시에 자동 commit 이 됨.
	@PutMapping("/dummy/user/{id}")
	public User updateuser(@PathVariable int id, @RequestBody User requestUser) { //json 데이털르 요청 => JAVA Object(MessageConverter의 Jackson 라이브러리가 변호나해서 받아줌)
		System.out.println("id : " +id);
		System.out.println("password : " +requestUser.getPassword());
		System.out.println("email : " +requestUser.getEmail());
		
		User user = userRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("수정에 실패하였습니다.");
		});
		user.setPassword(requestUser.getPassword());
		user.setEmail(requestUser.getEmail());
//		userRepository.save(user);
		
		// 더티체킹하면 save 사용안해도 update 할 수 있다.
		return user;
	}
	
	@GetMapping("/dummy/users")
	public List<User> list(){
		return userRepository.findAll();
	}
	
	// 한페이지당 2건에 데이터를 리턴 받아 볼 예정
	@GetMapping("/dummy/user")
	public List<User> pageList(@PageableDefault(size=2, sort="id", direction = Sort.Direction.DESC) Pageable pageable){
		Page<User> pagingUser = userRepository.findAll(pageable);
	
		
		List<User> users = pagingUser.getContent();
		return users;
	}
	
	// {id} 주소로 파라미터를 전달 받을 수 있음.
	// http://localhost:8090/blog/dummy/user/3
	@GetMapping("/dummy/user/{id}")
	public User detail(@PathVariable int id) {
		
		
//		람다식
//		User user = userRepository.findById(id).orElseThrow(()->{
//			return new IllegalArgumentException("해당 사용자는 없습니다.");
//		});
		
		
		
		// .get() null 고려 안함 절때 null일리 없을 경우
		User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
			@Override
			public IllegalArgumentException get() {
				// TODO Auto-generated method stub
				return new IllegalArgumentException("해당 유저는 없습니다. id : " +id);
			}		
		});
		// 요청 : Web Browser
		// user 객체 = JAVA Object
		// 변환 ( 웹브라우저가 이해할 수 있는 데이터 ) -> json(Gson 라이브러리)
		// 스프링 부트 = MessageConverter라는 애가 응답시에 자동 작동
		// 만약에 자바 오브젝트를 리턴하게 되면 MessageConverter가 Jackson 라이브러리를 호출해서
		// user 오브젝트를 json 으로 변환해서 브라우저에게 던져줍니다.
		return user;
	}

	// http://localhost:8090/blog/dummy/join
	@PostMapping("/dummy/join")
	public String join(User user) {
		
		System.out.println("id : " +user.getId());
		System.out.println("username : " +user.getUsername());
		System.out.println("password : " +user.getPassword());
		System.out.println("email : " +user.getEmail());
		System.out.println("role : " +user.getRole());
		System.out.println("createDate : " +user.getCreateDate());
		

		user.setRole(RoleType.USER);
		userRepository.save(user);
		return "회원가입이 완료 되었습니다.";
	}

}
