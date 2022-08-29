<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">
	<form action="/auth/loginProc" method="post">
		<div class="form-group">
			<label for="username">아이디</label>
			<input name="username" type="text" class="form-control" placeholder="아이디" id="username">
		</div>

		<div class="form-group">
			<label for="password">비밀번호</label>
			<input name="password" type="password" class="form-control" placeholder="비밀번호" id="password">
		</div>

		<!-- <div class="form-group form-check">
			<label class="form-check-label">
			<input name="remember" class="form-check-input" type="checkbox"> 아이디저장하기
			</label>
		</div> -->

		<button id="btn-login" class="btn btn-primary">로그인</button>
		<!-- <a href="https://kauth.kakao.com/oauth/authorize?client_id=3f61157625ebef21dfe3dad1a27a239e&redirect_uri=http://localhost:8090/auth/kakao/callback&response_type=code"><img height="38px" src="/image/kakao_login_button.png"></a> -->
	</form>

</div>

<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp"%>
