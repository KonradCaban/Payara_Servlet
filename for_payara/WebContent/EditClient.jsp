<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
    <title>Klienci</title>
</head>
<body>
<nav class="navbar navbar-dark bg-dark">
  <a class="navbar-brand" href="#"><center>Księgarnia</center></a>
  </div>
</nav>

    <div class="navbar">
      <div class="navbar-inner">
        <a class="brand" href="#"></a>
        <ul class="nav">
        
        <form action="/for_payara/main.jsp">
    		<input type="submit" value="Menu główne księgarni" class="btn btn-primary btn-lg"/>
		</form>
		&nbsp;&nbsp;&nbsp;&nbsp;
		        <form action="/for_payara/CategoryServlet">
    		<input type="submit" value="Zarządzanie kategoriami książek"  class="btn btn-primary btn-lg" />
    		<input type="hidden" name="dzialanie" value="/list">
		</form>
		&nbsp;&nbsp;&nbsp;&nbsp;
		        <form action="/for_payara/PublisherServlet">
    		<input type="submit" value="Zarządzanie wydawnictwami książek" class="btn btn-primary btn-lg"/>
    		<input type="hidden" name="dzialanie" value="/list" >
		</form>
		&nbsp;&nbsp;&nbsp;&nbsp;
		        <form action="/for_payara/ClientServlet">
    		<input type="submit" value="Zarządzanie klientami księgarni"class="btn btn-primary btn-lg" />
    		<input type="hidden" name="dzialanie" value="/list">
		</form>
		&nbsp;&nbsp;&nbsp;&nbsp;
		        <form action="/for_payara/BookServlet">
    		<input type="submit" value="Zarządzanie egzemplarzami"class="btn btn-primary btn-lg" />
    		<input type="hidden" name="dzialanie" value="/list">
		</form>
		&nbsp;&nbsp;&nbsp;&nbsp;
		        <form action="/for_payara/TransactionServlet">
    		<input type="submit" value="Zarządzanie transakcjami"class="btn btn-primary btn-lg" />
    		<input type="hidden" name="dzialanie" value="/list">
		</form>
		&nbsp;&nbsp;&nbsp;&nbsp;
        
        </ul>
      </div>
    </div>
    <center>
		        <form action="/for_payara/ClientServlet">
    		<input type="submit" value="Wróć do zarządzania klientami" class="btn btn-danger" />
    		<input type="hidden" name="dzialanie" value="/list">
		</form>
Zmień dane:
        <form method="get" action="ClientServlet">
        <input type="hidden" name="dzialanie" value="/edit">
        <input type="hidden" name="id" value="<%= request.getParameter("id") %>">
        Imię: <input type="text" name="name" value="<%= request.getParameter("name") %>" required><br>
        Nazwisko: <input type="text" name="surname" value="<%= request.getParameter("surname") %>" required><br>
        Miasto: <input type="text" name="city" value="<%= request.getParameter("city") %>" required><br>
        Adres: <input type="text" name="adress" value="<%= request.getParameter("adress") %>" required><br>
        Telefon: <input type="number" name="phone" min="0" max="999999999" value="<%= request.getParameter("phone") %>" required><br><br>
        <input type="submit" value="Edytuj klienta"  class="btn btn-danger"/>
        </form>
    </div>   
    </center>
</body>
</html>