<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page session="true"%>
<%@ page import="java.util.*"%>
<%@ page import="model.*"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title id="title">予約一覧</title>

<%
	LinkedList<Reservation> reservations = (LinkedList<Reservation>) session.getAttribute("Reservations");
%>
</head>
<body>
	<div data-role="page" id="top" data-theme="b">

		<Div Align="right">
			<form method="post" action="">
				<input type="submit" value="Logout" />
			</form>
		</Div>

		<Div Align="right">
			<form method="post" action="">
				<input type="submit" value="戻る" />
			</form>
		</Div>
		<HR>
		<CENTER>
			<p>
			<h1>会議室予約システム</h1>
			<h2>予約一覧</h2>
			<HR>
	</div>


	<table align="center" border="1">
		<thead>
			<tr bgcolor="#FFCC99">
				<td>会議室場所</td>
				<td>利用開始時間</td>
				<td>利用時間</td>
				<td>予約者名</td>
				<td></td>
			</tr>
		</thead>
		<tbody>
			<%
				for (Reservation r : reservations) {
					Room room = r.getRoom();

			%>
			<tr>
				<td><%=room.getBuildingName() + room.getFloor() + "階" + room.getRoomNumber() + "室"%></td>
				<td><%=r.getStartYear()%>年 <%=r.getStartMonth()%>月 <%=r.getStartDay()%>日
					<%=r.getStartHour()%>時 <%=r.getStartMinute()%>分</td>
				<td><%=r.getPeriodHour()%>時間 <%=r.getPeriodMinute()%>分</td>
				<td><%=r.getUser().getName()%></td>
				<td>
					<form method="post" action="">
						<input type="hidden" name="" value="" /> <input type="submit"
							value="詳細" />
					</form>
				</td>
			</tr>
			<%
				}
			%>

		</tbody>
	</table>


	</center>

	</div>


	</div>

</body>
</html>