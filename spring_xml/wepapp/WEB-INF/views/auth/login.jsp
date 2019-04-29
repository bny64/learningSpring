<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="limiter">
  <div class="container-login100">
    <div class="wrap-login100 p-t-90 p-b-30">
      <form class="login100-form validate-form" action="/spring_xml/auth/login" method="POST">
      	<span class="login100-form-title p-b-40">Login</span>
        <div>
        	<a class="btn-login-with bg1 m-b-10" id="facebookBtn" href="#">
        		<i class="fa fa-facebook-official"></i> Login with facebook
        	</a>
        	<a class="btn-login-with bg2 m-b-10" id="twitterBtn" href="#">
        		<i class="fa fa-twitter"></i> Login with twitter
        	</a>
        	<a class="btn-login-with bg3" id="wechatBtn" href="#">
        		<i class="fa fa-weixin"></i> Login with wechat
        	</a>
        </div>
        <div class="text-center p-t-55 p-b-30">
        	<span class="txt1">Login with email</span>
        </div>
        <div class="wrap-input100 validate-input m-b-16" data-validate="Please enter email: ex@abc.xyz">
          <input class="input100" type="email" name="id" placeholder="ID" />
          <span class="focus-input100"></span>
        </div>
        <div class="wrap-input100 validate-input m-b-20" data-validate="Please enter password">
        	<span class="btn-show-pass">
        		<i class="fa fa fa-eye"></i>
        	</span>
         	<input class="input100" type="password" name="password" placeholder="Password" />
         	<span class="focus-input100"></span>
        </div>
        <div class="container-login100-form-btn">
          <button class="login100-form-btn">Login</button>
        </div>
        <div class="flex-col-c p-t-224">
        	<span class="txt2 p-b-10">Don’t have an account?</span>
        	<a class="txt3 bo1 hov1" href="/spring_xml/auth/join">Sign up now</a>
        </div>
      </form>
    </div>
  </div>
  <script src="/spring_xml/js/auth/login.js"></script>
</div>