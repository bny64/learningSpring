<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<tiles:insertAttribute name="headerInclude"/>
</head><!--/head-->
<body>
	<header id="header"><!--header-->
		<tiles:insertAttribute name="header_top"/>
		<tiles:insertAttribute name="header_mid"/>
		<tiles:insertAttribute name="header_bot"/>
	</header>
	<tiles:insertAttribute name="slider"/>
	<section>
		<div class="container">
			<div class="row">
				<tiles:insertAttribute name="left"/>
				<tiles:insertAttribute name="body"/>
			</div>
		</div>
	</section>
	<footer id="footer"><!--Footer-->
		<tiles:insertAttribute name="footer_top"/>
		<tiles:insertAttribute name="footer_wid"/>
		<tiles:insertAttribute name="footer_bot"/>
	</footer>
</body>