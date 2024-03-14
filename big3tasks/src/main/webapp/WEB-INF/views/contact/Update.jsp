<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
   
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>수정창</title>
   
    <link rel="stylesheet" href="/css_png/New.css">
    
    <script type="text/javascript">
    function getselect() {
        var select = document.getElementById('groups');
        var option = select.options[select.selectedIndex];

        document.getElementById('value').value = option.value;
        document.getElementById('text').value = option.text;
    	}
      </script>
</head>
<body>
    
    <div class="member">
        <!-- 1. 로고 -->
        <img class="logo" src="/css_png/logo.png" width = 180px>
        <!-- 2. 필드 -->
        <form action = "/contact/updatess/{member_id}" method = "post">
        
        <div class="field" align = "center">
      		<b>이름</b>
            		<div>
           				<input type="text" placeholder = "이름 입력" class = "bbb" name = "name"  value="${list.name}">
        			</div>
        		</div>
        			<div class="aa" align = "center">
        			<b >주소</b>
        			<div>
           				<input type="text"  placeholder = "주소 입력" class = "bbb" name = "address" value='${list.address}' >
           				
        			</div>
        			</div>
  						<div class="aa" align = "center">
            				<b >휴대전화</b>
                				<p align = "center"><input type="tel" placeholder="전화번호 입력" class = "bbb" name = "phone"  value="${list.phone}"></p>
        				</div>
        				
        			<div class="aa" align = "center">
        			<b align = "center">그룹설정</b>
						<p align = "center">
						<select  class = "bbb" name = "groups_id" id="groups" onChange="getselect()" >
 			 			<option value='' >-- 선택 --</option>
  						<option value='1'>친구</option>
  						<option value='2'>가족</option>
  						<option value='3'>회사</option>
  						<option value='4'>기타</option>
						</select>
						</p>
						</div>
						
        				<div class="aa" align = "center">
            				<b >이메일<small>(선택)</small></b>
            					<p align = "center"><input type="email" placeholder="선택입력" class = "bbb" name = "email" value="${list.email}" ></p>
        				</div>
        				<div class="aa" >
            		<b align = "center">생년월일</b>
                		<p align = "center"><input type="date" name="to" min="1901-01-01" max="2999-12-31" class = "bbb" name = "birthday" value="${list.birthday}"></p>
        			</div>
        <!-- 6.수정 버튼 -->
        <input type="submit" value="수정하기">
		</form>
        <!-- 7. 푸터 -->
        <div class="member-footer">
            <span><a href="#none">jong.s</a></span>
        </div>
    </div>

</body>
</html>