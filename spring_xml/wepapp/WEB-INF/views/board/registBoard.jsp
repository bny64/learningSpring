<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="fh5co-section-gray" id="fh5co-tours">
    <div class="container">
        <form class="contentForm" method="POST" action="/board/registBoard">
            <div class="row">
                <div class="col-md-8 col-md-offset-2 text-center heading-section animate-box">
                    <h3>제목</h3>
                    <input class="ht40 wd100p bdCr" type="text" name="title" />
                </div>
            </div>
            <div class="row">
                <div class="col-md-8 col-md-offset-2 text-left heading-section animate-box" style="margin-bottom:15px;">
                    <h3 style="text-align:center;">내용</h3>
                    <textarea id="summernote" name="contents"></textarea>
                </div>
            </div>
            <div class="row">
                <div class="col-md-8 col-md-offset-2 text-center heading-section animate-box">
                    <h4>비밀번호</h4>
                    <input class="ht40 wd100p bdCr" type="password" style="width:100px; text-align:center;" name="password" />
                </div>
            </div>
        </form>
        <div class="row">
            <div class="col-md-12 text-center animate-box">
                <p><a class="btn btn-primary btn-outline btn-lg" id="registBtn" href="#">등록하기<i class="icon-arrow-right22"></i></a></p>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12 text-center animate-box">
                <p><a class="btn btn-primary btn-outline btn-lg" href="#">돌아가기<i class="icon-arrow-right22"></i></a></p>
            </div>
        </div>
    </div>
</div>
<script src="/spring_xml/js/board/registBoard.js"></script>