
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!DOCTYPE html>
<html>
<head>
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/modernizr/2.7.1/modernizr.min.js"></script>
<script type="text/javascript">
    function enableDisable(courseId) {
        //Reference the Button.
        var btnSubmit = document.getElementById("btnSubmit");
 
        //Verify the TextBox value.
        if (courseId.value.trim() != "") {
            //Enable the TextBox when TextBox has value.
            btnSubmit.disabled = false;
        } else {
            //Disable the TextBox when TextBox is empty.
            btnSubmit.disabled = true;
        }
    };
</script>
</head>
<style>
form#search-form {
	position: absolute;
	top: -130px;
	left: 450px;
}

input {
	height: 40px;
	border-radius: 5px;
	border: none;
}

input#name {
	width: 300px;
}
</style>
<body>
	<form id="search-form" action="Search" method="post">
		<input type="text" list="dsTourName" id="courseId" name="course_id"
			placeholder="Nhập mã môn học để tìm kiếm "  onkeyup="enableDisable(this)" /> 
		<input id="btnSubmit" type="submit" name="" value="Search" disabled="disabled">
	</form>
	<c:forEach items="${list}" var="tour">
		<datalist id="dsTourName">
			<option value="${tour.tenTour.toLowerCase().trim() }"></option>
	</c:forEach>
	</datalist>
	<!-- 	<script type="text/javascript" > 
 	function xuLyLocTheoTen(){
 		var dsTourName = document.getElementById("name").value;
           window.location.href = 'TourController?dsTourName=' + document.getElementById('name').value;
 	}
</script> -->
</body>
</html>