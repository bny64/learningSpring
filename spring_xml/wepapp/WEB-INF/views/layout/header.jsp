<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header id="fh5co-header-section" class="sticky-banner">
	<div class="container">
		<div class="nav-header">
			<a href="#" class="js-fh5co-nav-toggle fh5co-nav-toggle dark"><i></i></a>
			<h1 id="fh5co-logo">
				<a href="/spring_xml/index"><i class="fas fa-leaf fa-lg fa-spin" style="height:48px !important;width:48px !important;top:-5px;left:-15px;color:#79B361;font-size: 27px;padding-top: 12px !important;padding-left: 8px;"></i>jAVA_XML</a>
			</h1>
			<!-- START #fh5co-menu-wrap -->
			<nav id="fh5co-menu-wrap" role="navigation">
				<ul class="sf-menu" id="fh5co-primary-menu">
					<c:choose>
						<c:when test="${userInfo eq null}">
							<li><a href="/spring_xml/auth/login"> Login</a></li>
						</c:when>
						<c:otherwise>
							<li><a id="logoutBtn" href="/spring_xml/auth/logout"> Logout</a></li>
						</c:otherwise>
					</c:choose>
					<li><a href="index.html">Home</a></li>
					<li><a href="vacation.html" class="fh5co-sub-ddown">Vacations</a>
						<ul class="fh5co-sub-menu">
							<li><a href="#">Family</a></li>
							<li><a href="#">CSS3 &amp; HTML5</a></li>
							<li><a href="#">Angular JS</a></li>
							<li><a href="#">Node JS</a></li>
							<li><a href="#">Django &amp; Python</a></li>
						</ul></li>
					<li><a class="fh5co-sub-ddown" href="#">Board</a>
					 	<ul class="fh5co-sub-menu">
						    <li><a href="/spring_xml/board/boardList">Board List</a></li>
						    <li><a href="/spring_xml//board/registBoard">Regist Board</a></li>
						</ul>
					</li>
					<li><a href="flight.html">Flights</a></li>
					<li><a href="hotel.html">Hotel</a></li>
					<li><a href="car.html">Car</a></li>
					<li class="active"><a href="blog.html">Blog</a></li>
					<li><a href="contact.html">Contact</a></li>
				</ul>
			</nav>
		</div>
	</div>
</header>