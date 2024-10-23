<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.ssafy.hw.model.dto.*"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<style>
#nav-header {
	display: flex;
	justify-content: space-between;
}
.nav-search{
	width:50%;	
}

.nav-search span {
	margin-left: 10px;
	border: solid black 1px;
	padding: 5px;
}


</style>
<div id="nav-header">
	<%-- session에서 loginUser를 가져와서 존재 여부에 따라 로그인 폼 또는 사용자 정보를 출력한다. --%>
	<div class="nav-search">
		<form action="search" method="get" style="display: flex; align-items: center; gap: 10px;">
			<div>
		        <label for="searchByCondition">검색 조건:</label>
		        <select id="searchByCondition" name="key">
		            <option value="none">선택하세요</option>
		            <option value="name">이름</option>
		            <option value="email">이메일</option>
		        </select>
		    </div>

		    
		    <div>
		        <label for="orderBy">정렬 기준:</label>
		        <select id="orderBy" name="orderBy">
		            <option value="none">정렬하지 않음</option>
		            <option value="name">이름</option>
		            <option value="email">이메일</option>
		        </select>
		    </div>
		    
		    <div>
		        <label for="orderByDir">정렬 방향:</label>
		        <select id="orderByDir" name="orderByDir">
		            <option value="asc">오름차순</option>
		            <option value="desc">내림차순</option>
		        </select>
		    </div>
		    <div>
		        <label for="searchWord">검색어:</label>
		        <input type="text" id="searchWord" name="word" placeholder="검색어를 입력하세요" />
		    </div>
		    <button type="submit">검색</button>
		</form>
	</div>
	<div class="nav-login">
		<c:if test="${empty loginUser }">
		<form method="post" action="login">
		<input type="text" name="id" placeholder="아이디"> 
		<input type="password" name="password" placeholder="비밀번호"> 
		<input type="submit" value="로그인">
		</form>
		</c:if>
		<c:if test="${!empty loginUser }">
		<div>
			${loginUser.name }
			님 반갑습니다. <a href="./logout">로그아웃</a>
		</div>
		</c:if>
	</div>
</div>
<hr>
<script>
	// request 영역에 msg라는 이름의 attribute가 있다면 화면에 alert으로 출력한다.
	let msg = "${msg}";
	if (msg) {
		alert(msg)
	}
</script>
