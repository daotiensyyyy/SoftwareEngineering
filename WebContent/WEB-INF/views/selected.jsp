<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<!-- saved from url=(0038)https://themes.wplook.com/morning-time -->
<html lang="en">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Elearn</title>

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Elearn project">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.9.0/css/all.css">
<link rel="stylesheet" type="text/css"
	href="./Elearn_files/registration.css">
<link rel="stylesheet" type="text/css"
	href="./Elearn_files/responsive.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

</head>
<style>
input#course_id, input#credits, input#day, input#room, input#start,
	input#end, input#semester {
	border: none;
}

input#course_name {
	border: none;
	width: 200px;
}

#selected {
	width: 100% !important;
}

#subject_list {
	width: 100% !important;
}
.table td, .table th{
	padding: 0 !important;
	padding-top: 10px;
	
}
</style>
<body>
	<!-- Header -->
	<header class="header">
		<!-- Header Content -->
		<div class="header_container">
			<div class="container">
				<div class="row">
					<div class="col">
						<div
							class="header_content d-flex flex-row align-items-center justify-content-start">
							<div class="logo_container">
								<a href="#">
									<div
										class="logo_content d-flex flex-row align-items-end justify-content-start">
										<div class="logo_img">
											<img src="./Elearn_files/logo_1.png" alt="">
										</div>
									</div>
								</a>
							</div>
							<nav class="main_nav_contaner ml-auto">
							<ul class="main_nav">
								<li><a href="index.jsp" style="text-decoration: none;"/home">Trang
										chủ</a></li>
								<li class="active"><a style="text-decoration: none;" href="Course">Đăng
										ký môn học</a></li>
								<li><a style="text-decoration: none;"#">Xem lịch học</a></li>
								<li><a style="text-decoration: none;"#">Xem điểm</a></li>
								<li><a style="text-decoration: none;"#">Xem học phí</a></li>
							</ul>

							<c:if test="${empty loginedUser}">
								<a href="/STM/login"> <atext.request.contextPath}/login">
									<span class="glyphicon glyphicon-user" style="color: black;"></span></a>

							</c:if>
							<c:if test="${not empty loginedUser}">
								<span style="color: gree; margin-right: 20px">
									${loginedUser.userName} </span>
								<a style="text-decoration: none; color: black;" href="${pageContext.request.contextPath}/logout"> Đăng
									xuất </a> &nbsp;</a>
							</c:if>
							<!-- Hamburger -->

							<div class="hamburger menu_mm">
								<i class="fa fa-bars menu_mm" aria-hidden="true"></i>
							</div>
						</nav>

						</div>
					</div>
				</div>
			</div>
		</div>

	</header>

	<!-- Menu -->
	<div class="milestones">
		<!-- Background image artis https://unsplash.com/@thepootphotographer -->
		<div class="parallax_background parallax-window"
			data-parallax="scroll" data-image-src="Elearn_files\bg.jpg"
			data-speed="0.8"></div>
		<div class="container">
			<div class="row milestones_container">
				<div class="container">
					<div class="row">
						<div class="col">
							<div class="home_content text-center">
								<div class="home_logo">
									<img src="./Elearn_files/home_logo_1.png" alt="">
								</div>
								<div class="home_text">
									<div class="home_title"></div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<br>
	<br>
	<div id="subject_list">
		<table class="table">
			<thead class="thead-dark">
				<h4>
					<b>DANH SÁCH MÔN HỌC ĐÃ ĐĂNG KÝ</b>
				</h4>
				<tr>
					<th>Mã môn học</th>
					<th>Tên môn học</th>
					<th>Thứ</th>
					<th>Phòng học</th>
					<th>Học kỳ</th>
					<th>Bắt đầu</th>
					<th>Kết thúc</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<!-- hien thi cac mon hoc da dang ky theo mssv -->
				<c:forEach items="${lst }" var="res">
					<tr>
						<td><input id="course_id" type="text" class="input"
							value="${res.course_id}" name="course_id" readonly /></td>
						<td><input id="course_name" type="text" class="input"
							value="${res.course_name}" name="course_name" readonly /></td>
						<!-- <td><input id="credits" type="text" class="input" -->
						<%-- value="${course.course_credits}" name="credits" readonly /></td> --%>
						<td><input id="day" type="text" class="input"
							value="${res.day}" name="day" readonly /></td>
						<td><input id="room" type="text" class="input"
							value="${res.room}" name="room" readonly /></td>
						<td><input id="semester" type="text" class="input"
							value="${res.semester}" name="course_id" readonly /></td>
												<td><input id="start" type="text" class="input"
													value="${res.start_time}" name="start" readonly /></td>
												<td><input id="end" type="text" class="input"
													value="${res.end_time}" name="end" readonly /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br> <br>

	</div>
	
	<!-- Footer -->
	<jsp:include page="/WEB-INF/footer/footer.jsp"></jsp:include>

	</div>



	<script src="./Elearn_files/ScrollToPlugin.min.js.download"></script>
	<script src="./Elearn_files/parallax.min.js.download"></script>
	<script src="./Elearn_files/custom.js.download"></script>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
		integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
		crossorigin="anonymous"></script>
</body>


</html>
