<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/taglibs/taglibs.jsp" %>
<link rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<!-- Header -->

<header class="header">
    <!-- Top Bar -->
    <!-- <div class="top_bar">
        <div class="top_bar_container">
          <div class="container">
            <div class="row">
              <div class="col">
                <div class="top_bar_content d-flex flex-row align-items-center justify-content-start">
                  <div class="top_bar_login ml-auto">
                    <ul>
                      <li><a href="#">Login</a></li>
                    </ul>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div> -->

    <!-- Header Content -->
    <div class="header_container">
        <div class="container">
            <div class="row">
                <div class="col">
                    <div
                            class="header_content d-flex flex-row align-items-center justify-content-start">
                        <div class="logo_container">
                            <a href="http://localhost:8080/">
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
                                <li><a style="text-decoration: none;" href="/home">Trang chủ</a></li>
                                <li><a style="text-decoration: none;" href="Course">Đăng
                                    ký môn học</a></li>
                                <li><a style="text-decoration: none;" href="#">Xem lịch học</a></li>
                                <li><a style="text-decoration: none;" href="#">Xem điểm</a></li>
                                <li><a style="text-decoration: none;" href="#">Xem học phí</a></li>
                            </ul>

                            <c:if test="${empty loginedUser}">
                                <a href="<c:url value="/login"/>"> <span
                                        class="glyphicon glyphicon-user" style="color: black;"></span>
                                </a>

                            </c:if>
                            <c:if test="${not empty loginedUser}">
                                <span style="color: #1d2124; margin-right: 20px">${loginedUser.username}</span>
                                <a style="text-decoration: none; color: black;"
                                   href="${pageContext.request.contextPath}/logout"> Đăng xuất
                                </a> &nbsp;</a>
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

    <!-- Header Search Panel -->
    <div class="header_search_container">
        <div class="container">
            <div class="row">
                <div class="col">
                    <div
                            class="header_search_content d-flex flex-row align-items-center justify-content-end">
                        <form action="#" class="header_search_form">
                            <button
                                    class="header_search_button d-flex flex-column align-items-center justify-content-center">
                                <i class="fas fa-search" aria-hidden="true"></i>
                            </button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>
