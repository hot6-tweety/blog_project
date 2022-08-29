<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">
<form>
<input type="hidden" id="id" value="${principal.user.id}"/>
</form>
	<form>
		<div class="form-group">
			<label for="username">아이디</label>
			<input type="text" value="${principal.user.username}" class="form-control" placeholder="아이디" id="username" readonly>
		</div>

		<div class="form-group">
			<label for="password">비밀번호</label>
			<input type="password" class="form-control" placeholder="비밀번호" id="password">
		</div>

		<div class="form-group">
			<label for="email">이메일</label>
			<input type="email" value="${principal.user.email}"class="form-control" placeholder="이메일" id="email">
		</div>

	</form>

		<button id="btn-update" class="btn btn-primary">회원수정완료</button>
</div>
<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp"%>
