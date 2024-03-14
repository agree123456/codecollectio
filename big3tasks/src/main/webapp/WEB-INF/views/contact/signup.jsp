<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
   
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입 폼</title>
    <link rel="icon" href="../css_png/로고.png">
    <link rel="stylesheet" href="/css_png/New.css">
</head>
<body>
    <form action="/contact/add"></form>
    <div class="member">
        <!-- 1. 로고 -->
        <img class="logo" src="/logo.png" width = 180px>
        <!-- 2. 필드 -->
        <div class="field">
            <b>아이디</b>
            <span class="placehold-text"><input type="text"></span>
        </div>
        <div class="field">
            <b>비밀번호</b>
            <input class="userpw" type="password">
        </div>
        
        <div class="field">
            <b>이름</b>
            <input type="text">
        </div>
        
          <div class="field">
            <b>닉네임</b>
            <input type="text">
        </div>
        <b >주소</b>
        	<div>
           		<input type="text"  placeholder = "주소 입력" class = "bbb" >		
        	</div>
        <!-- 5. 전화번호_이메일 -->
      
        <div class="field tel-number">
            <b>휴대전화</b>
            <div>
                <input type="tel" placeholder="전화번호 입력">
            </div>
        <div class="field">
            <b>본인 확인 이메일<small>(선택)</small></b>
            <input type="email" placeholder="선택입력">
        </div>
          
        </div>
			<!-- 3. 필드(생년월일) -->
        <div class="field birth">
            <b>생년월일</b>
            <div>
              <input type="date" name="to" min="1901-01-01" max="2999-12-31">
            </div>
        </div>
        <!-- 6. 가입하기 버튼 -->
        <input type="submit" value="가입하기">

        <!-- 7. 푸터 -->
        <div class="member-footer">
            <span><a href="#none">jong.s</a></span>
        </div>
    </div>

</body>
</html>
