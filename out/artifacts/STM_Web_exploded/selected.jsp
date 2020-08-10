<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table class="selected">
	<h4 class="selected-title">Selected</h4>
	<thead class="">
		<tr>
			<th>Mã môn học</th>
			<th>Tên môn học</th>
			<th>Số tín chỉ</th>
			<th>Thứ</th>
			<th>Phòng học</th>
			<th>Học kỳ</th>
			<th>Ngày bắt đầu</th>
			<th>Ngày kết thúc</th>
			<th></th>
		</tr>
	</thead>
	<tbody>

		<c:forEach items="${lstCart }" var="cart">
			<tr>
				<td><input id="name" type="text" class="input"
					value="${cart.course_id}" readonly /></td>
				<td><input id="course-name" type="text" class="input"
					value="${cart.course_name}" readonly /></td>
				<td><input id="credits" type="text" class="input"
					value="${cart.course_credits}" readonly /></td>
				<td><input id="day" type="text" class="input"
					value="${cart.day}" readonly /></td>
				<td><input id="room" type="text" class="input"
					value="${cart.room}" readonly /></td>
				<td><input id="semester" type="text" class="input"
					value="${cart.semester}" readonly /></td>
				<td><input id="start" type="text" class="input"
					value="${cart.start_time}" readonly /></td>
				<td><input id="end" type="text" class="input"
					value="${cart.end_time}" readonly /></td>

				<td><a href="XuLyXoaSP?course_id=${cart.course_id }">
						<button type="button" class="" aria-label="Right Align">
							<span class="glyphicon glyphicon-trash" aria-hidden="true">Xóa</span>
						</button>
				</a></td>
			</tr>
		</c:forEach>

	</tbody>
</table>