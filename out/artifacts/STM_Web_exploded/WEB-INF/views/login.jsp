<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/taglibs/taglibs.jsp" %>
<%@page import="utils.Utils" %>
<?php
if(isset($_POST['submit'])){
$name;
$captcha;
if(isset($_POST['name'])){
$name = $_POST['name'];
?>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!DOCTYPE HTML>
<html lang="en">
<head>
    <!-- Meta tag Keywords -->
    <title>Đăng nhập</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords"
          content="Online Login Form Responsive Widget,Login form widgets, Sign up Web forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements"/>
    <link
            href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i&amp;subset=cyrillic,cyrillic-ext,greek,greek-ext,latin-ext,vietnamese"
            rel="stylesheet">
    <link
            href="//fonts.googleapis.com/css?family=Dosis:200,300,400,500,600,700,800&amp;subset=latin-ext"
            rel="stylesheet">
    <!-- //online-fonts -->
    <script src='https://www.google.com/recaptcha/api.js'></script>
    <style>
        html, body, div, span, applet, object, iframe, h1, h2, h3, h4, h5, h6, p,
        blockquote, pre, a, abbr, acronym, address, big, cite, code, del, dfn,
        em, img, ins, kbd, q, s, samp, small, strike, strong, sub, sup, tt, var,
        b, u, i, dl, dt, dd, ol, nav ul, nav li, fieldset, form, label, legend,
        table, caption, tbody, tfoot, thead, tr, th, td, article, aside, canvas,
        details, embed, figure, figcaption, footer, header, hgroup, menu, nav,
        output, ruby, section, summary, time, mark, audio, video {
            margin: 0;
            padding: 0;
            border: 0;
            font-size: 100%;
            font: inherit;
            vertical-align: baseline;
        }

        article, aside, details, figcaption, figure, footer, header, hgroup,
        menu, nav, section {
            display: block;
        }

        ol, ul {
            list-style: none;
            margin: 0px;
            padding: 0px;
        }

        blockquote, q {
            quotes: none;
        }

        blockquote:before, blockquote:after, q:before, q:after {
            content: '';
            content: none;
        }

        table {
            border-collapse: collapse;
            border-spacing: 0;
        }

        /* start editing from here */
        a {
            text-decoration: none;
        }

        .txt-rt {
            text-align: right;
        }

        /* text align right */
        .txt-lt {
            text-align: left;
        }

        /* text align left */
        .txt-center {
            text-align: center;
        }

        /* text align center */
        .float-rt {
            float: right;
        }

        /* float right */
        .float-lt {
            float: left;
        }

        /* float left */
        .clear {
            clear: both;
        }

        /* clear float */
        .pos-relative {
            position: relative;
        }

        /* Position Relative */
        .pos-absolute {
            position: absolute;
        }

        /* Position Absolute */
        .vertical-base {
            vertical-align: baseline;
        }

        /* vertical align baseline */
        .vertical-top {
            vertical-align: top;
        }

        /* vertical align top */
        nav.vertical ul li {
            display: block;
        }

        /* vertical menu */
        nav.horizontal ul li {
            display: inline-block;
        }

        /* horizontal menu */
        img {
            max-width: 100%;
        }

        /*end reset*/
        body {
            background: green;
            background-size: cover;
            -webkit-background-size: cover;
            -moz-background-size: cover;
            -o-background-size: cover;
            -ms-background-size: cover;
            background-attachment: fixed;
            background-position: center;
            text-align: center;
            font-family: 'Open Sans', sans-serif;
            height: 100%;
            background-size: cover;
        }

        /*--header--*/
        .header-w3l {
            padding-top: 2em;
        }

        .header-w3l h1 {
            font-size: 3em;
            color: white;
            letter-spacing: 8px;
            font-weight: 500;
            font-family: 'Dosis', sans-serif;
            text-transform: uppercase;
            text-shadow: 5px 3px 5px #101010;
        }

        /*--//header--*/

        /*--main--*/
        .wthree-pro h2 {
            font-size: 1.2em;
            color: #fff;
            letter-spacing: 4px;
            margin-bottom: 1.5em;
            text-transform: uppercase;
        }

        .sub-main-w3 input[type="text"], .sub-main-w3 input[type="password"] {
            outline: none;
            font-size: .9em;
            padding: 1em 3em 1em 1em;
            border: none;
            margin-bottom: 0.3em;
            background: lightgrey;
            width: 82%;
            color: #000;
            border-radius: 30px;
            font-weight: 400;
            font-family: 'Open Sans', sans-serif;
            letter-spacing: 1px;
            width: 82%;
        }

        .sub-main-w3 {
            width: 26%;
            margin: 10em auto 12em;
        }

        .sub-w3l h6 a {
            font-size: .9em;
            color: #fff;
            letter-spacing: 1px;
            text-align: right;
            display: inherit;
        }

        .sub-w3l {
            margin-top: 1em;
        }

        .right-w3l {
            margin-top: 2em;
        }

        .pom-agile {
            position: relative;
        }

        input.pass {
            margin-top: .7em;
        }

        span.icon1, span.icon2 {
            color: #ea2858;
            font-size: 1.1em;
            position: absolute;
            right: 6%;
        }

        span.icon1 {
            top: 23%;
        }

        span.icon2 {
            top: 34%;
        }

        .sub-main-w3 input[type="submit"] {
            color: black;
            background: white;
            border: none;
            padding: .7em 0;
            outline: none;
            width: 44%;
            font-size: 1em;
            cursor: pointer;
            letter-spacing: 1px;
            font-weight: 400;
            font-family: 'Open Sans', sans-serif;
            transition: 0.5s all;
            -webkit-transition: 0.5s all;
            -o-transition: 0.5s all;
            -moz-transition: 0.5s all;
            -ms-transition: 0.5s all;
            border-radius: 30px;
        }

        .sub-main-w3 input[type="submit"]:hover {
            background: red;
            color: white;
            transition: 0.5s all;
            -webkit-transition: 0.5s all;
            -o-transition: 0.5s all;
            -moz-transition: 0.5s all;
            -ms-transition: 0.5s all;
        }

        /*--//main--*/

        /*--footer--*/
        .footer p {
            font-size: .9em;
            color: white;
            letter-spacing: 2px;
        }

        .footer p a {
            color: #fff;
        }

        .footer p a:hover {
            color: #ea2858;
        }

        /*--//footer--*/

        /*--responsive--*/
        @media ( max-width: 1680px) {
        }

        @media ( max-width: 1600px) {
        }

        @media ( max-width: 1440px) {
            .footer {
                padding-bottom: 3em;
            }

            .sub-main-w3 {
                width: 29%;
                margin: 7em auto 9em;
            }
        }

        @media ( max-width: 1366px) {
        }

        @media ( max-width: 1280px) {
        }

        @media ( max-width: 1080px) {
            .sub-main-w3 {
                width: 35%;
            }
        }

        @media ( max-width: 1050px) {
        }

        @media ( max-width: 1024px) {
            .sub-main-w3 {
                width: 38%;
            }
        }

        @media ( max-width: 991px) {
        }

        @media ( max-width: 900px) {
            .header-w3l {
                padding-top: 1.5em;
            }

            .sub-main-w3 {
                width: 42%;
                margin: 6em auto 8em;
            }

            .footer {
                padding-bottom: 2.5em;
            }
        }

        @media ( max-width: 800px) {
            .header-w3l h1 {
                font-size: 2.7em;
                letter-spacing: 7px;
            }
        }

        @media ( max-width: 768px) {
            .header-w3l {
                padding-top: 4.5em;
            }

            .sub-main-w3 {
                width: 50%;
                margin: 10em auto 16em;
            }
        }

        @media ( max-width: 736px) {
            .header-w3l {
                padding-top: 1.5em;
            }

            .sub-main-w3 {
                margin: 5em auto 6.5em;
            }
        }

        @media ( max-width: 667px) {
            .footer {
                padding-bottom: 2em;
            }
        }

        @media ( max-width: 640px) {
        }

        @media ( max-width: 600px) {
            .sub-main-w3 input[type="email"], .sub-main-w3 input[type="password"] {
                padding: .9em 3em .9em 1em;
            }

            .sub-main-w3 input[type="submit"] {
                font-size: .95em;
            }

            .footer p {
                letter-spacing: 1px;
            }

            .right-w3l {
                margin-top: 1em;
            }

            .header-w3l h1 {
                font-size: 2.5em;
                letter-spacing: 5px;
            }

            .wthree-pro h2 {
                font-size: 1em;
            }

            .sub-main-w3 {
                margin: 6em auto 8em;
                width: 54%;
            }
        }

        @media ( max-width: 568px) {
            .sub-main-w3 {
                width: 56%;
            }
        }

        @media ( max-width: 480px) {
            .header-w3l h1 {
                font-size: 2.3em;
                letter-spacing: 4px;
            }

            .sub-main-w3 {
                width: 69%;
                margin: 6em auto 6.3em;
            }

            .footer p {
                line-height: 1.9;
            }
        }

        @media ( max-width: 440px) {
            .sub-main-w3 {
                width: 72%;
            }
        }

        @media ( max-width: 414px) {
            .sub-main-w3 input[type="email"], .sub-main-w3 input[type="password"] {
                font-size: .85em;
            }

            .sub-w3l h6 a {
                font-size: .8em;
            }

            .header-w3l h1 {
                font-size: 2.1em;
            }

            .sub-main-w3 {
                margin: 7em auto 9.3em;
            }
        }

        @media ( max-width: 384px) {
            .sub-main-w3 input[type="email"], .sub-main-w3 input[type="password"] {
                font-size: .8em;
            }

            .header-w3l h1 {
                font-size: 2em;
            }

            .sub-main-w3 input[type="submit"] {
                font-size: .9em;
            }

            .wthree-pro h2 {
                margin-bottom: 1.2em;
            }

            .sub-main-w3 {
                margin: 6em auto 7.5em;
                width: 74%;
            }

            span.icon1 {
                top: 18%;
            }

            span.icon2 {
                top: 32%;
            }
        }

        @media ( max-width: 375px) {
        }

        @media ( max-width: 320px) {
            .header-w3l h1 {
                font-size: 1.8em;
                letter-spacing: 2px;
            }

            .wthree-pro h2 {
                font-size: .9em;
                letter-spacing: 2px;
            }

            .sub-main-w3 input[type="submit"] {
                font-size: .8em;
            }

            .footer p {
                font-size: .8em;
            }

            .sub-main-w3 {
                margin: 4.2em auto 4.5em;
                width: 81%;
            }

            .sub-main-w3 input[type="email"], .sub-main-w3 input[type="password"] {
                width: 80%;
            }
        }

        /*--//responsive--*/
    </style>
</head>
<body>
<!-- main -->
<div class="center-container">
    <!--header-->
    <div class="header-w3l">
        <h1>Đăng nhập</h1>
    </div>
    <!--//header-->
    <div class="main-content-agile">
        <div class="sub-main-w3">
            <div class="wthree-pro"></div>
            <div class="alert alert-danger" role="alert" style="color: red">${requestScope.errorMessage}</div>
            <form class="form_register"
                  action="<c:url value="/login"/>" method="post">
                <div class="pom-agile">
                    <input placeholder="MSSV" name="userName" class="user"
                           type="text" required=""> <span class="icon1"><i
                        class="fa fa-user" aria-hidden="true"></i></span>
                </div>
                <div class="pom-agile">
                    <input placeholder="Password" name="password" class=" pass"
                           type="password" required=""> <span class="icon2"><i
                        class="fa fa-unlock" aria-hidden="true"></i></span>
                </div>
                <div class="sub-w3l" align="center">
                    <c:if test="${not empty sessionScope.captcha}">
                        <div class="g-recaptcha" data-sitekey="6LfvybwZAAAAALP0QrropENpVU2CpCcAP6HS7GbF"
                             data-callback="enableSubmit"></div>
                        <td colspan="2">
                            <input class="btn btn-success" id="btnSubmit" type="submit" value="Submit" disabled/>
                            <a style="color: black; margin-left: 50px;" href="<c:url value="/"/>">Cancel</a>
                        </td>
                    </c:if>
                    <c:if test="${empty sessionScope.captcha}">
                        <td colspan="2">
                            <input type="submit" value="Submit"/>
                            <a style="color: black; margin-left: 50px;" href="<c:url value="/"/>">Cancel</a>
                        </td>
                    </c:if>
                </div>
            </form>
        </div>
    </div>

    <!--//main-->
</div>
<script>
    function enableSubmit() {
        document.getElementById("btnSubmit").disabled = false;
    }
</script>

</body>
</html>