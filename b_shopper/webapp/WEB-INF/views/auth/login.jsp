<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section id="form"><!--form-->
	<div class="container">
		<div class="row">
			<div class="col-sm-4 col-sm-offset-1">
				<div class="login-form"><!--login form-->
					<h2>로그인</h2>
					<form action="#">
						<input type="email" placeholder="Email" />
						<input type="password" placeholder="Password" />
						<!-- <span>
							<input type="checkbox" class="checkbox"> 
							Keep me signed in
						</span> -->
						<button type="submit" class="btn btn-default">Login</button>
					</form>
				</div><!--/login form-->
			</div>
			<div class="col-sm-1">
				<h2 class="or">OR</h2>
			</div>
			<div class="col-sm-4">
				<div class="signup-form"><!--sign up form-->
					<h2>회원 가입</h2>
					<form action="#">
						<input type="text" placeholder="ID" id="id"/>
						<input type="text" placeholder="Name" id="name"/>
						<input type="email" placeholder="Email Address" id="email"/>
						<input type="password" placeholder="Password" id="password"/>
						<input type="text" placeholder="address" id="address">						 
						<button type="submit" class="btn btn-default" id="signupBtn">Signup</button>
					</form>
				</div><!--/sign up form-->
			</div>
		</div>
	</div>
</section><!--/form-->
<script src="/js/auth/login.js"></script>