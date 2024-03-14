<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  
  <style>
    
    * {
      margin: 0; padding: 0;
      box-sizing: border-box;
    }
    body {
      font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
      color: #58666e;
      background-color: write;
      -webkit-font-smoothing: antialiased;
      -webkit-text-size-adjus: 100%;  /* iphone font size 변경 방지 */
    }
    li { list-style: none; }
    a { text-decoration: none; }
    h1, h2, h3, h4, h5, h6, p {
      margin: 10px 5px;
    }
    h1 { font-size: 1.8em; }

    #wrap {
      width: 100%;
      /* margin-top = header height */
      margin-top: 60px;
    }

    /* Navigation bar */
    header {
      /* for sticky header */
      position: fixed;
      top: 0;

      width: 100%;
      height: 60px;
      z-index: 2000;
      background-color: #EBF7FF;
      box-shadow: 0 2px 2px rgba(0, 0, 0, 0.05), 0 1px 0 rgba(0, 0, 0, 0.05);
    }
    .logo {
      display: inline-block;
      height: 36px;
      margin: 12px 0 12px 25px;
    }
    .logo > img { height: 36px; }
    nav {
      float: right;
    }
    .nav-items {
      margin-right: 20px;
    }
    .nav-items > li {
      display: inline-block;  /* 가로정렬 */
    }
    .nav-items > li > a {
      /* for Vertical Centering */
      line-height: 60px;
      padding: 0 30px;
      color: rgba(0, 0, 0, 0.4);
    }
    .nav-items > li > a:hover {
      color: rgba(0, 0, 0, 0.8);
    }

    /* contents */
    /* clearfix */
    #content-wrap:after {
      content: "";
      display: block;
      clear: both;
    }
    aside {
      /* for fixed side bar */
      position: fixed;
      top: 60px;
      bottom: 0;
      width: 200px;  /* 너비 고정 */
      padding-top: 25px;
      background-color: #EBF7FF;
    }
    /* aside navigation */
    aside > ul {
      width: 200px;
    }
    aside > ul > li > a {
      display: block;
      color: black;
      padding: 10px 0 10px 20px;
    }
    aside > ul > li > a.active {
      background-color: #4CAF50;
    }
    aside > ul > li > a:hover:not(.active) {
      background-color: #555;
    }
    aside > h1 {
      padding: 20px 0 20px 20px;
      color: #fff;
    }
      
    /* Section */
    section {
      float: right;
      /* aside width */
      margin-left: 200px;
    }
    article {
      margin: 10px;
      padding: 25px;
      background-color: white;
    }
   
      button {
          background-color: write;
          padding: 5px 10px;
          border-radius: 4px;
          cursor: pointer;
        }

        .modal {
          position: fixed;
          top: 0;
          left: 0;
          width: 100%;
          height: 100%;
          display: flex;
          justify-content: center;
          align-items: center;
        }

        .modal .bg {
          width: 100%;
          height: 100%;
          background-color: rgba(0, 0, 0, 0.6);
        }

        .modalBox {
         
          position: absolute;
          background-color: #EBF7FF;
          width: 500px;
          height: 500px;
          padding: 15px;
        }
        .modalBox button {
          display: block;
         background-color: write;
          width: 50px;
          height : 32px;
        }  
        .hidden {
          display: none;
        }
        .title_purple{
  		margin: 0 8%;
  		margin-top: 20px;
 		 border-color : red;
 		 border-radius: 10px;
 		 border-style: hidden;
 		 border-collapse: collapse;
 		 box-shadow: 0 0 0 2px #EBF7FF;
		 background-color: #EBF7FF;
		}

		.list_purple{
  		margin: 0 8%;
  		margin-top: 20px;
 		border-color: #EBF7FF;
  		border-radius: 10px;
  		border-style: hidden;
  		border-collapse: collapse;
  		box-shadow: 0 0 0 2px #EBF7FF;
  		line-height: 2;
		}

		.table_name {
  		width: 1075px;
  		font-size: 17px;
  		display: flex;
		}

		.table_list{
 		 width: 1075px;
 		 font-size: 13px;
		}

		.input{
  		width: 95%;
  		border-style: hidden;
 		text-align: center;
		}		

		.input1{
  		width: 50%;
  		border-style: hidden;
  		text-align: center;
		}

		.date{
 		 margin-left: 9%;
		}
		
		.abc{
		 font-size: 50px;
		 		}
		 		
		 .find-btn{
			text-align: right;
			position: absolute;
  			top: 400px;
  			right: 10px;
  			padding: 20px;
			}
		.find-btn1{
			display :inline-block;
			}
		.closeBtn {
 		 position: relative;
 		 top: 10px; /* 원하는 위치값으로 변경 */
  		left: 10px; /* 원하는 위치값으로 변경 */
		}
        <link rel="stylesheet" href="../css_png/list.css">
        .bb{
        width :25px;
        height:25px;
        font-size:10px;
        }	
        
       .member b{
    	/* border: 1px solid #000; */
    	display: block; /*수직 정렬하기 */
    	margin-bottom: 5px;
		}
	
  </style>
  <script type="text/javascript">
  function confirm1(){
		
		if(confirm("로그아웃하시겠습니까?")=true){
			console.log("정상적으로 로그아웃.");
			}else{
				console.log("로그인상태유지");
			}
		} 
  function getselect() {
    var select = document.getElementById('country');
    var option = select.options[select.selectedIndex];

    document.getElementById('value').value = option.value;
    document.getElementById('text').value = option.text;
	}
  </script>
 

</head>
<body>
  <div id="wrap">
    <header>
      <a class="logo" href="#home"><img src="../contact/로고.png"></a>
      <nav>
        <ul class="nav-items">
          <li><a href="#home">설명서</a></li>
          <li><a href="#news">회원정보</a></li>
          <li><a href="#contact">로그인</a></li>
          <li><button onclick="confirm1()">로그아웃</button></li>
        </ul>
      </nav>
    </header>
	
    <div id="content-wrap">
      <aside>
       <button class="openBtn">정보추가</button>
        	<ul>
        	  <h3>그룹별로 보기</h3>	 
        	  	<li><a href="./update.jsp" class="active">전체목록</a></li>
          	  	<li><a href="#">가족</a></li>
          		<li><a href="#">친구</a></li>
          		<li><a href="#">회사</a></li>
          		<li><a href="#">기타</a></li>
        	</ul>
      
       </div>
	<div class="modal hidden">
  		<div class="bg"></div>
  			<div class="modalBox">
  				<div class= "member">
  				<div>
  					<ul><li class = "abc"  align="center"> 연락처 추가</li></ul>
  					
  				</div>
  				<form action="/contact/add" method = "post">
				<div class="aa" align="center">
            		<b>이름</b>
            		<div>
           				<input type="text" placeholder = "이름 입력" class = "bbb"  name = "name">
        			</div>
        		</div>
        			<div class="aa" align = "center">
        			<b >주소</b>
        			<div>
           				<input type="text"  placeholder = "주소 입력" class = "bbb"  name = "address">
           				
        			</div>
        			</div>
  						<div class="aa" align = "center">
            				<b >휴대전화</b>
                				<p align = "center"><input type="tel" placeholder="전화번호 입력" class = "bbb" name = "phone"></p>
        				</div>
        				
        			<div class="aa" align = "center">
        			<b align = "center">그룹설정</b>
						<p align = "center">
						<select  class = "bbb" name = "groups_id" id="country" onChange="getselect()">
 			 			<option value='0' >-- 선택 --</option>
  						<option value='1'>친구</option>
  						<option value='2'>가족</option>
  						<option value='3'>회사</option>
  						<option value='4'>기타</option>
						</select></p>
						</div>
						
        				<div class="aa" align = "center">
            				<b >이메일<small>(선택)</small></b>
            					<p align = "center"><input type="email" placeholder="선택입력" class = "bbb" name = "email"></p>
        				</div>
        				
        				<!-- 3. 필드(생년월일) -->
        			<div class="aa" >
            		<b align = "center">생년월일</b>
                		<p align = "center"><input type="date" name="to" min="1901-01-01" max="2999-12-31" class = "bbb" name = "birthday"></p>
        			</div>
        			
        				
    						<input type = "submit" value = "저장" class="btn_submit find-btn1"></input>
    						
    						</form>
    						<button class="closeBtn find-btn1"></button>			  		
  			</div></div></div>
		</aside>
		
<script>
  const open = () => {
    document.querySelector(".modal").classList.remove("hidden");
  }

  const close = () => {
    document.querySelector(".modal").classList.add("hidden");
  }

  document.querySelector(".openBtn").addEventListener("click", open);
  document.querySelector(".closeBtn").addEventListener("click", close);
  document.querySelector(".bg").addEventListener("click", close);

	</script>
     	  	
      
      <section>
      <div style="overflow:hidden; width:1400px; height:2000px;">
        <article id="london">
         <table class="title_purple" align="left" height="100%">
      			<tr class="table_name" align="center" width="100%">
      			    <th width="44.5px">순서</th>
       				<th width="60px">이름</th>
        			<th width="200px">주소</th>
        			<th width="175px">전화번호</th>
        			<th width="60px">그룹</th>
        			<th width="175px">메일</th>
        			<th width="175px">생일</th>
        			<th width="185.5px">수정하기</th>
      </tr>
    </table>
    <table class="list_purple table_list" border="1" align="left" height="100%">  
       <c:forEach items= "${list}" var="list">
      <tr align="center">
        <td width="44.5px">
          <c:out value="${list.member_id}"></c:out>
        </td>
        <td width="60px">
          <c:out value="${list.name}"></c:out>
        </td>
        <td width="200px">
          <c:out value="${list.address}"></c:out>
        </td>
        <td width="175px">
          <c:out value="${list.phone}"></c:out>
        </td>
        <td width="60px">
        <c:out value="${list.groups_name}"></c:out>
        </td>
        <td width="175px">
          <c:out value="${list.email}"></c:out>
        </td>
        <td width="175px">
        <c:out value="${list.birthday}" ></c:out>
        </td>
        <td width="185.5px">
          <button type = button onclick = "location.href='/contact/update/${list.member_id}'">수정하기</button>&nbsp;&nbsp;&nbsp; 
          <button type = button onclick ="location.href='/contact/delete/${list.member_id}'">삭제하기</button>
        </td>
      </tr>
      </c:forEach>
    </table>
    
    
        
        </article>
        </div>
      </section>
      <!-- end of content-wrap -->
    </div>
    
  <!-- end of wrap   -->
  
</body>
</html>