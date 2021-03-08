
<%@page import="com.app.entity.Employee"%>
<%@page import="java.util.List"%>
<head>
<title>Employee Management</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>

<form class="form-horizontal" action="register" , method="post">
	<fieldset>

		<%
			String success = (String) request.getAttribute("success");
			String error = (String) request.getAttribute("error");
		%>

		<%
			if (success != null) {
		%>
		<div class="alert alert-success">
			<strong>success</strong>
			<%=success%>
		</div>

		<%
			}
		%>

		<%
			if (error != null) {
		%>
		<div class="alert alert-danger">
			<strong>error</strong>
			<%=error%>
		</div>
		<%
			}
		%>

		<br />

		<!-- Form Name -->
		<legend>Employee Management</legend>

		<%
			Employee employee = (Employee) request.getAttribute("employee");
		%>

		<%
			if (employee != null) {
		%>

		<input type="hidden" value="<%=employee.getId()%>" name="id">

		<!-- Text input-->
		<div class="form-group">
			<label class="col-md-4 control-label" for="textinput">Name</label>
			<div class="col-md-4">
				<input id="name" name="name" type="text" placeholder="Enter name"
					class="form-control input-md" required=""
					value=<%=employee.getName()%>>

			</div>
		</div>

		<!-- Text input-->
		<div class="form-group">
			<label class="col-md-4 control-label" for="textinput">Mobile
				number</label>
			<div class="col-md-4">
				<input id="mobile" name="mobile" type="text"
					placeholder="Enter mobile number" class="form-control input-md"
					required="" value=<%=employee.getMobile()%>>

			</div>
		</div>

		<!-- Text input-->
		<div class="form-group">
			<label class="col-md-4 control-label" for="textinput">Salary</label>
			<div class="col-md-4">
				<input id="salary" name="salary" type="text"
					placeholder=" Enter salary" class="form-control input-md"
					required="" value=<%=employee.getSalary()%>>

			</div>
		</div>

		<!-- Text input-->
		<div class="form-group">
			<label class="col-md-4 control-label" for="textinput">Age</label>
			<div class="col-md-4">
				<input id="age" name="age" type="text" placeholder="Enter age"
					class="form-control input-md" required=""
					value=<%=employee.getAge()%>>

			</div>
		</div>

		<!-- Button -->
		<div class="form-group">
			<label class="col-md-4 control-label" for=""></label>
			<div class="col-md-4">
				<button id="" name="" class="btn btn-success">update</button>
			</div>
		</div>

		<%
			} else {
		%>
		<input type="hidden" value="" name="id">

		<!-- Text input-->
		<div class="form-group">
			<label class="col-md-4 control-label" for="textinput">Name</label>
			<div class="col-md-4">
				<input id="textinput" name="name" type="text"
					placeholder="Enter name" class="form-control input-md" required="">

			</div>
		</div>

		<!-- Text input-->
		<div class="form-group">
			<label class="col-md-4 control-label" for="textinput">Mobile
				number</label>
			<div class="col-md-4">
				<input id="textinput" name="mobile" type="text"
					placeholder="Enter mobile number" class="form-control input-md"
					required="">

			</div>
		</div>

		<!-- Text input-->
		<div class="form-group">
			<label class="col-md-4 control-label" for="textinput">Salary</label>
			<div class="col-md-4">
				<input id="textinput" name="salary" type="text"
					placeholder=" Enter salary" class="form-control input-md"
					required="">

			</div>
		</div>

		<!-- Text input-->
		<div class="form-group">
			<label class="col-md-4 control-label" for="textinput">Age</label>
			<div class="col-md-4">
				<input id="textinput" name="age" type="text" placeholder="Enter age"
					class="form-control input-md" required="">

			</div>
		</div>

		<!-- Button -->
		<div class="form-group">
			<label class="col-md-4 control-label" for=""></label>
			<div class="col-md-4">
				<button id="" name="" class="btn btn-success">Save</button>
			</div>
		</div>

		<%
			}
		%>

	</fieldset>
</form>


<div class="container">
	<h2>Employee List</h2>

	<table class="table table-striped">
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Mobile</th>
				<th>Salary</th>
				<th>Age</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<%
				List<Employee> employees = (List<Employee>) request.getAttribute("employees");
				if (!employees.isEmpty()) {
					for (Employee emp : employees) {
			%>

			<tr>

				<td><%=emp.getId()%></td>
				<td><%=emp.getName()%></td>
				<td><%=emp.getMobile()%></td>
				<td><%=emp.getSalary()%></td>
				<td><%=emp.getAge()%></td>
				<td><a href="edit?id=<%=emp.getId()%>">Edit</a>|<a
					href="delete?id=<%=emp.getId()%>">Delete</a></td>
			</tr>
			<%
				}
				} else {
			%>

			<%
				out.write("Records Not Found");
				}
			%>
		</tbody>
	</table>
</div>









