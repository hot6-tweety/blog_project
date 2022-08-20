<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">

	<form>
		<div class="form-group">
			<label for="title">제목</label> <input type="text" class="form-control" placeholder="제목" id="title">
		</div>

		<div class="form-group">
			<label for="comment">내용</label>
			<textarea class="form-control" rows="5" id="content"></textarea>
		</div>

		<button id="btn-save" class="btn btn-primary">글쓰기 완료</button>
	</form>
</div>

<%@ include file="../layout/footer.jsp"%>
