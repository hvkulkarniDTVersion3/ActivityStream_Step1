<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page session="false" isELIgnored="false"%>
<html>
<head>
<title>Activity Stream</title>


</head>
<body>
	<h1>This is Index Page</h1>
	<!-- create a form which will have textboxes for Sender Name and Message content along with a Send 
Submit button. Handle errors like empty fields -->

	<table>
		<form action="sendMessage" method="post">
			<tr>
				<th>Sender Name</th>
				<td><input type="text" name="sender" size="20" required /></td>
			</tr>
			<tr>
				<th>Message</th>
				<td><input type="text" name="message" size="40" required /></td>
			</tr>
			<input type="submit" value="Send">
		</form>
	</table>

	<!-- display all existing messages in a tabular structure with Sender Name, Posted Date and Message -->
	<table>
		<tr>
			<th>Sender Name</th>
			<th>Message</th>
			<th>Posted Date</th>
		</tr>
		<c:forEach items="${allMessages}" var="message">
			<tr>
				<td>${message.senderName}</td>
				<td>${message.message}</td>
				<td>${message.postedDate}</td>
			</tr>
		</c:forEach>
			</table>
</body>
</html>