<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<!-- saved from url=(0044)https://technext.github.io/elearn/index.html -->
<html lang="en">

<!-- head -->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Elearn</title>

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="Elearn project">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

    <link rel="stylesheet" type="text/css" href="./Elearn_files/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.9.0/css/all.css">
    <link rel="stylesheet" type="text/css" href="./Elearn_files/main_styles.css">
    <link rel="stylesheet" type="text/css" href="./Elearn_files/responsive.css">

    <style>
        input#course_id, input#credits, input#day, input#room, input#start,
        input#end, input#semester, input#time {
            border: none;
            width: 80px;
        }

        input#course_name {
            border: none;
            width: 300px;
        }

        #selected {
            width: 100% !important;
        }

        #subject_list {
            width: 100% !important;
            padding: 1em 4em;
        }

        .table td, .table th {
            padding: 0 !important;
            padding-top: 10px;
        }

        ul#pagination {
            display: flex;
            flex-wrap: wrap;

            justify-content: center;
            -webkit-justify-content: flex-end;
        }
    </style>

</head>
<!---->
<body>
<div class="parallax-mirror"
     style="visibility: hidden; z-index: -100; position: fixed; top: 0px; left: 0px; overflow: hidden; height: 504.8px; width: 1457.6px; transform: translate3d(0px, 766.338px, 0px);">
    <img class="parallax-slider" src="./Elearn_files/milestones.jpg"
         style="position: absolute; height: 637px; width: 1457.6px; max-width: none; transform: translate3d(0px, -190.268px, 0px);">
</div>

<div class="super_container">
    <!-- Header -->
    <jsp:include page="/WEB-INF/header/header.jsp"></jsp:include>

    <!-- Menu -->

    <div
            class="menu d-flex flex-column align-items-end justify-content-start text-right menu_mm trans_400">
        <div class="menu_close_container">
            <div class="menu_close">
                <div></div>
                <div></div>
            </div>
        </div>
        <nav class="menu_nav">
            <ul class="menu_mm">
                <li class="menu_mm"><a href="index.jsp">Trang chủ</a></li>
                <li class="menu_mm"><a href="Course">Đăng ký môn học</a></li>
                <li class="menu_mm"><a href="#">Xem lịch học</a></li>
                <li class="menu_mm"><a href="#">Xem điểm</a></li>
                <li class="menu_mm"><a href="#">Xem học phí</a></li>
            </ul>
        </nav>

    </div>

    <!-- Milestones -->

    <div class="milestones">
        <!-- Background image artis https://unsplash.com/@thepootphotographer -->
        <div class="parallax_background parallax-window"
             data-parallax="scroll" data-image-src="./Elearn_files/bg.jpg"
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
                                    <div class="home_title">Đăng ký môn học</div>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div id="subject_list">
        <div class="table-responsive-lg">
            <table class="table">
                <thead class="thead-dark">
                <h4>
                    <b>DANH SÁCH MÔN HỌC</b>
                </h4>
                <tr>
                    <th>Mã môn học</th>
                    <th>Tên môn học</th>
                    <th>Thứ</th>
                    <th>Phòng học</th>
                    <th>Tiết bắt đầu</th>
                    <th>Học kỳ</th>
                    <th>Bắt đầu</th>
                    <th>Kết thúc</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>

                <!-- lay danh sach mon hoc va hien thi len bang -->
                <div><h4>${message }</h4></div>
                <c:forEach items="${list }" var="course">
                    <tr>
                        <td><input id="course_id" type="text" class="input"
                                   value="${course.course_id}" name="course_id" readonly/></td>
                        <td><input id="course_name" type="text" class="input"
                                   value="${course.course_name}" name="course_name" readonly/></td>
                        <!-- 						<td><input id="credits" type="text" class="input" -->
                            <%-- 							value="${course.course_credits}" name="credits" readonly /></td> --%>
                        <td><input id="day" type="text" class="input"
                                   value="${course.day}" name="day" readonly/></td>
                        <td><input id="room" type="text" class="input"
                                   value="${course.room}" name="room" readonly/></td>
                        <td><input id="time" type="text" class="input"
                                   value="${course.time}" name="time" readonly/></td>
                        <td><input id="semester" type="text" class="input"
                                   value="${course.semester}" name="semester" readonly/></td>
                        <td><input id="start" type="text" class="input"
                                   value="${course.start_time}" name="start" readonly/></td>
                        <td><input id="end" type="text" class="input"
                                   value="${course.end_time}" name="end" readonly/></td>
                        <td><a type="submit"
                               href="Save?course_id=${course.course_id }&course_name=${course.course_name }
							&day=${course.day }&room=${course.room }&time=${course.time }&semester=${course.semester }
							&start=${course.start_time }&end=${course.end_time }">
                            <i class="fas fa-square"></i>
                        </a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <br>
            <div><a href="Course">Quay lại</a></div>
        </div>
        <br> <br>

    </div>

    <!-- Footer -->
    <jsp:include page="/WEB-INF/footer/footer.jsp"></jsp:include>
    =======

    <!-- Footer -->
    <jsp:include page="/WEB-INF/footer/footer.jsp"></jsp:include>
    >>>>>>> ea819476e8b43254130f88bbd17aa7c6e6268eba

</div>

<script src="./Elearn_files/jquery-3.2.1.min.js.download"></script>
<script src="./Elearn_files/popper.js.download"></script>
<script src="./Elearn_files/bootstrap.min.js.download"></script>

<script src="./Elearn_files/ScrollMagic.min.js.download"></script>
<script src="./Elearn_files/animation.gsap.min.js.download"></script>

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

