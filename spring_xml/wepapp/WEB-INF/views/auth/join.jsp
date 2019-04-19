<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="limiter">
	<div class="container-login100">
		<div class="wrap-login100 p-b-30">
			<form class="login100-form validate-form" action="/spring_xml/auth/join" method="POST">
				<span class="login100-form-title">Join</span>
				<div></div>
				<div class="text-center p-t-55 p-b-30">
					<span class="txt1">Create your account</span>
				</div>
				<div class="wrap-input100 validate-input m-b-16"
					data-validate="ID를 입력하세요">
					<input class="input100" type="text" name="id" placeholder="ID" />
					<span class="focus-input100"></span>
				</div>
				<div class="wrap-input100 validate-input m-b-20" data-validate="비밀번호를 입력하세요">
					<span class="btn-show-pass">
						<i class="fa fa fa-eye"></i>
					</span>
					<input class="input100" type="password" name="pass" placeholder="비밀번호" />
					<span class="focus-input100"></span>
				</div>
				<div class="wrap-input100 validate-input m-b-16" data-validate="예시 : ex@abc.xyz">
					<input class="input100" type="email" name="email" placeholder="Email" />
					<span class="focus-input100"> </span>
				</div>
				<div class="wrap-input100 validate-input m-b-16" data-validate="이름을 입력하세요">
					<input class="input100" type="text" name="name" placeholder="이름" />
					<span class="focus-input100"></span>
				</div>
				<div class="wrap-input100 validate-input m-b-16" data-validate="예시 : 000-0000-0000">
					<input class="input100" type="text" name="phoneNumber" placeholder="휴대폰 번호" />
					<span class="focus-input100"></span>
				</div>
				<div class="wrap-input100 validate-input m-b-16" data-validate="예시 : 1919-03-01">
					<input class="input100" id="datePicker" type="text" name="birthday"	placeholder="birthday" />
					<span class="focus-input100"></span>
				</div>
				<div class="wrap-input100 validate-input m-b-16">
					<span class="emailAd">이메일 수신여부</span><br />
					<span class="emailAd">수신합니다.</span>
					<span> 
						<input type="radio" name="emailYn" checked="checked" value="Y" />
					</span><br/>
					<span class="emailAd">수신하지 않습니다.</span>
					<span>
						<input type="radio" name="emailYn" value="N" />
					</span>
				</div>
				<div class="wrap-input100 validate-input m-b-16 datepicker" data-validate="Please enter your introduction">
					<textarea class="input100" type="text" name="introduction" placeholder="introduction"></textarea>
					<span class="focus-input100"></span>
				</div>
				<div class="container-login100-form-btn">
					<button class="login100-form-btn" style="margin-top: 40px;">Join</button>
				</div>
			</form>
			<div class="container-login100-form-btn">
				<button class="login100-form-btn" id="loginBtn" style="margin-top: 20px;">Login</button>
			</div>
		</div>
	</div>
	<script src="/spring_xml/js/auth/join.js"></script>
</div>