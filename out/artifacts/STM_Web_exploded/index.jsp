<%@ page import="utils.Utils" %>
<jsp:include page="/WEB-INF/taglibs/taglibs.jsp"></jsp:include>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<!-- saved from url=(0044)https://technext.github.io/elearn/index.html -->
<html lang="en">

<!-- head -->
<jsp:include page="/WEB-INF/head/head.jsp"></jsp:include>
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
                <li class="menu_mm"><a href="#">Trang chủ</a></li>
                <li class="menu_mm"><a href="Course">Đăng ký môn học</a></li>
                <li class="menu_mm"><a href="#">Xem lịch học</a></li>
                <li class="menu_mm"><a href="#">Xem điểm</a></li>
                <li class="menu_mm"><a href="#">Xem học phí</a></li>
                <li class="menu_mm"><a href="<%= Utils.fullPath("login")%>">
                    <span class="glyphicon glyphicon-user" style="color: black;"></span></a></li>
            </ul>
        </nav>
        <div class="menu_extra">
            <div class="menu_phone">
                <span class="menu_title">phone:</span>(009) 35475 6688933 32
            </div>
            <div class="menu_social">
                <span class="menu_title">follow us</span>
                <ul>
                    <li><a href="https://technext.github.io/elearn/index.html#"><i
                            class="fa fa-pinterest" aria-hidden="true"></i></a></li>
                    <li><a href="https://technext.github.io/elearn/index.html#"><i
                            class="fa fa-facebook" aria-hidden="true"></i></a></li>
                    <li><a href="https://technext.github.io/elearn/index.html#"><i
                            class="fa fa-instagram" aria-hidden="true"></i></a></li>
                    <li><a href="https://technext.github.io/elearn/index.html#"><i
                            class="fa fa-twitter" aria-hidden="true"></i></a></li>
                </ul>
            </div>
        </div>
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
                                    <div class="home_title">Đại học Nông Lâm TP.HCM</div>
                                    <div class="home_subtitle">Maecenas rutrum viverra
                                        sapien sed fermentum. Morbi tempor odio eget lacus tempus
                                        pulvinar. Praesent vel nisl fermentum, gravida augue ut,
                                        fermentum ipsum.</div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Sections -->

    <div class="grouped_sections">
        <div class="container">
            <div class="row">

                <!-- Why Choose Us -->



                <!-- Events -->

                <div class="col-lg-6 grouped_col">
                    <div class="grouped_title">Hoạt động</div>
                    <div class="events">

                        <!-- Event -->
                        <div
                                class="event d-flex flex-row align-items-start justify-content-start">
                            <div>
                                <div
                                        class="event_date d-flex flex-column align-items-center justify-content-center">
                                    <div class="event_day">20</div>
                                    <div class="event_month">tháng 4</div>
                                </div>
                            </div>
                            <div class="event_body">
                                <div class="event_title">
                                    <a href="https://technext.github.io/elearn/index.html#">Hiến máu tình nguyện</a>
                                </div>
                                <div class="event_subtitle">Địa điểm: PV123</div>
                            </div>
                        </div>

                        <!-- Event -->
                        <div
                                class="event d-flex flex-row align-items-start justify-content-start">
                            <div>
                                <div
                                        class="event_date d-flex flex-column align-items-center justify-content-center">
                                    <div class="event_day">23</div>
                                    <div class="event_month">tháng 8</div>
                                </div>
                            </div>
                            <div class="event_body">
                                <div class="event_title">
                                    <a href="https://technext.github.io/elearn/index.html#">Làm lồng đèn trung thu</a>
                                </div>
                                <div class="event_subtitle">Địa điểm: PV123</div>
                            </div>
                        </div>



                    </div>
                </div>

                <!-- News -->

                <div class="col-lg-6 grouped_col">
                    <div class="grouped_title">Thông báo mới</div>
                    <div class="news">

                        <!-- News Post -->
                        <div
                                class="news_post d-flex flex-row align-items-start justify-content-start">
                            <div>
                            </div>
                            <div class="news_post_body">
                                <div class="news_post_date">27-06-2020</div>
                                <div class="news_post_title">
                                    <a href="#">Đăng ký môn học 2020-2021</a>
                                </div>
                            </div>
                        </div>

                        <!-- News Post -->
                        <div
                                class="news_post d-flex flex-row align-items-start justify-content-start">
                            <div>

                            </div>
                            <div class="news_post_body">
                                <div class="news_post_date">26-06-2020</div>
                                <div class="news_post_title">
                                    <a href="#">Lưu ý khi đăng ký môn học</a>
                                </div>

                            </div>
                        </div>

                        <!-- News Post -->
                        <div
                                class="news_post d-flex flex-row align-items-start justify-content-start">
                            <div>

                            </div>
                            <div class="news_post_body">
                                <div class="news_post_date">25-06-2020</div>
                                <div class="news_post_title">
                                    <a href="">Thông báo lịch thi học kì 2 năm học 2019-2020</a>
                                </div>

                            </div>
                        </div>



                    </div>
                </div>
            </div>
        </div>
    </div>


    <!-- Footer -->
    <jsp:include page="/WEB-INF/footer/footer.jsp"></jsp:include>

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

