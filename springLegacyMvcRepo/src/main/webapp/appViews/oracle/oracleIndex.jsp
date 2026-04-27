<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
<title>Insert title here</title>
<script>
	function insertTest(){	
				
		var queryString = $("#oracle_form").serializeArray();
		$.ajax({
			url:"<c:url value='/oracle/insertTest.do'/>",
			type:'post',
			data:queryString,
			dataType : "json",
			success: function(data, status) {
				var message = data.message;
				//var seq = data.seq;
				
				console.log(message);
				
				//selectDetail(seq);
				
			},
			error: function (data, status, e) {
				console.log(data); 
				console.log("실패");
			}
		});
	}
	
	function procedureTest(){	
		
		var queryString = $("#oracle_form").serializeArray();
		$.ajax({
			url:"<c:url value='/oracle/procedureTest.do'/>",
			type:'post',
			data:queryString,
			dataType : "json",
			success: function(data, status) {
				var message = data.message;
				var resultMap = data.resultMap;
				//var seq = data.seq;
				
				console.log(message);
				console.log("resultMap.outSeq : " + resultMap.outSeq);
				console.log("resultMap.outTitle : " + resultMap.outTitle);
				console.log("resultMap.outWriter : " + resultMap.outWriter);
				console.log("resultMap.outContent : " + resultMap.outContent);
				console.log("resultMap.outRegdate : " + resultMap.outRegdate);
				console.log("resultMap.outCnt : " + resultMap.outCnt);
				
				//selectDetail(seq);
				
			},
			error: function (data, status, e) {
				console.log(data); 
				console.log("실패");
			}
		});
	}
</script>
</head>
<body>
	<div>오라클 인덱스 페이지</div>
	<br>
	<div>
		<form id="oracle_form" name="oracle_form" method="post">
			<input type="hidden" id="hiddenTitle" name="title" value="testTitle">
			<input type="hidden" id="hiddenContent" name="content" value="testContent">
			<button type="button" onclick="insertTest()">Insert Test</button>
		</form>
		<button type="button" onclick="procedureTest()">procedure Insert Test</button>
	</div>
</body>
</html>