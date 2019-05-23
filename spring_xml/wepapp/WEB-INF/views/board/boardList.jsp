<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${message ne null}">
	<script type="text/javascript">		
		alert("${message}");
	</script>
</c:if>
<div class="fh5co-section-gray" id="fh5co-tours">
	<div class="container">
 		<div class="row">
			<div class="col-md-8 col-md-offset-2 text-center heading-section animate-box">
				<h3>글 목록</h3>
				<p></p>자유롭게 작성하실 수 있습니다.
			</div>
		</div>
		<div class="row lastRow">
			<div class="col-md-12 text-center animate-box">
				<p>
					<a class="btn btn-primary btn-outline btn-lg" id="moreBtn" href="javascript:void(0);">더 보기<i class="icon-arrow-right22"></i>
					</a>
				</p>
			</div>
 		</div>
	</div>
</div>
<script src="/spring_xml/js/board/boardList.js"></script>