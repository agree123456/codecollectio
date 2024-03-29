<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<script src="https://code.jquery.com/jquery-3.3.1.js"></script>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">

<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>

<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<title>Insert title here</title>

</head>

<body>

    <div id="login">

        <h3 class="text-center text-white pt-5">Login form</h3>

        <div class="container">

            <div id="login-row" class="row justify-content-center align-items-center">

                <div id="login-column" class="col-md-6">

                    <div id="login-box" class="col-md-12">

                        <form id="login-form" class="form" action="" method="post">

                            <h3 class="text-center text-info"> 로그인</h3>

                            <div class="form-group">

                                <label for="username" class="text-info">아이디:</label><br>

                                <input type="text" name="username" id="username" class="form-control">

                            </div>

                            <div class="form-group">

                                <label for="password" class="text-info">비밀번호:</label><br>

                                <input type="text" name="password" id="password" class="form-control">

                            </div>

                            <div class="form-group">

                                <label for="remember-me" class="text-info"><span>아이디,비밀번호 저장</span> <span><input id="remember-me" name="remember-me" type="checkbox"></span></label><br>

                                <input type="submit" name="submit" class="btn btn-info btn-md" value="submit">

                            </div>

                            <div id="register-link" class="text-right">

                                <a href="/contact/signup" class="text-info">회원 가입</a>
								
                            </div>

                        </form>

                    </div>

                </div>

            </div>

        </div>

    </div>

</body>

</html>