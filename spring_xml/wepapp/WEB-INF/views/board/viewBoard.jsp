<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<input id="listNoVal" style="display:none;" value="${content.listNo }"/>
<div class="fh5co-section-gray" id="fh5co-tours">
    <div class="container">
        <form class="contentForm" method="POST" action="/board/registBoard">
            <div class="row">
                <div class="col-md-8 col-md-offset-2 text-center heading-section animate-box">
                    <h3>제목</h3>
                    <div class="fsz25" id="boardTitle">${content.title }</div>
                </div>
            </div>
            <div class="row mbt75">
                <div class="col-md-8 col-md-offset-2 text-left heading-section animate-box" style="margin-bottom:15px;">
                    <h3 class="mbt75" style="text-align:center;">내용</h3>
                    <div id="boardContents">${content.contents }</div>
                </div>
            </div>
        </form>
        <div class="row lastRow">
            <div class="col-md-12 text-center animate-box">
                <p><a class="btn btn-primary btn-outline btn-lg" id="showComment" href="javascript:void(0);">댓글 달기</a></p>
                <p><a class="btn btn-primary btn-outline btn-lg" href="/board/boardList">돌아가기 </a></p>
            </div>
        </div>
    </div>
</div>
<div id="popup" style="display:none;">
    <h3>작성자</h3>
    <input class="form-control" type="text" value="${user.name }" disabled="disabled" />
    <h3>내용</h3>
    <textarea class="form-control" id="commentContents" style="height:40%;"></textarea>
    <p><a class="btn btn-primary" id="addComment" href="javascript:void(0);">댓글 달기</a></p>
    <p><a class="btn btn-primary" id="cancelComment" href="javascript:void(0);">취소</a></p>
</div>
<script src="/spring_xml/js/board/viewBoard.js"></script>