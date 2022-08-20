<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">
	<form>
		<div class="form-group">
			<label for="username">아이디</label>
			<input type="text" class="form-control" placeholder="아이디" id="username">
		</div>

		<div class="form-group">
			<label for="password">비밀번호</label>
			<input type="password" class="form-control" placeholder="비밀번호" id="password">
		</div>

		<div class="form-group">
			<label for="email">이메일</label>
			<input type="email" class="form-control" placeholder="이메일" id="email">
		</div>

		<div class="form-group form-check">
			<label class="form-check-label">
			<input class="form-check-input" type="checkbox"> 개인정보 제공 동의
			</label>
		</div>

	</form>

		<button id="btn-save" class="btn btn-primary">회원가입</button>
</div>
<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp"%>
