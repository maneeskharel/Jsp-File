<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<title>Email Pages</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>


<div class="form-group">
<img src = "img/student.jpeg" style = "height: 200px">

<h2>Result is </h2>

<%    //Scriptlet Tag

   String tr = request.getParameter("email");
   StringBuilder stringBuilder  = new StringBuilder(tr);
   String ulta =stringBuilder.reverse().toString();
%>
hello final is <%=ulta %>
</div>

    </body>
</html>