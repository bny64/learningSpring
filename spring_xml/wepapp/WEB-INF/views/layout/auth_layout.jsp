<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->
<head>
<tiles:insertAttribute name="headerInclude"/>
</head>
<body>
	<div id="fh5co-wrapper">
		<div id="fh5co-page">
			<tiles:insertAttribute name="header"/>
			<!-- end:header-top -->
			<tiles:insertAttribute name="body"/>		
		<!-- END fh5co-page -->
			<tiles:insertAttribute name="footer"/>
		</div>
		<tiles:insertAttribute name="script"/>
	</div>
	<!-- END fh5co-wrapper -->

</body>
</html>

