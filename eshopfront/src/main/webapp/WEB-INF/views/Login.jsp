<%@include file="Header.jsp"%>

<h3 align="center">Login Page</h3>

<div class="container">

<form action="perform_login" method="post">
<table class="table table-bordered responsive">
	<tr class="success">
		<td colspan="4" class="text-center">Sign In Here</td>
	</tr>
	<tr>
		<td colspan="2">User Name </td>
		<td colspan="2"> <input type="text" name="username"/></td>
	</tr>
	<tr>
		<td colspan="2">Password</td>
		<td colspan="2"> <input type="password" name="password"/></td>
	</tr>
	<tr>
		<td colspan="4">
		<center>
		<input type="submit" value="Login" class="btn btn-success"/>
		</center>
	</td>
</table>
</form>

</div>
</body>
</html>