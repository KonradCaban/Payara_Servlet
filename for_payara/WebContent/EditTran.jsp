<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Transakcja</title>
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
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
		        <form action="/for_payara/TransactionServlet">
    		<input type="submit" value="Wróć do zarządzania transakcjami" class="btn btn-danger" />
    		<input type="hidden" name="dzialanie" value="/list">
		</form>
Zmień dane:
        <form method="get" action="TransactionServlet">
        <input type="hidden" name="dzialanie" value="/edit">
        <input type="hidden" name="id" value="<%= request.getParameter("id") %>">
		Książka:   <select name="books">
          			<c:forEach var="item" items="${listbook}">
           				 <option value="${item.id}"  ${item.id == book_id ? 'selected="selected"' : ''}>${item.title}</option>
          			</c:forEach>
        </select><br>
        Klient:
          <select name="clients">
          			<c:forEach var="item2" items="${listclient}">
           				 <option value="${item2.id}"  ${item2.id == cl_id  ? 'selected="selected"' : ''}>${item2.name} ${item2.surname}</option>
          			</c:forEach>
        </select><br>
        Ilość: <input type="number" name="quantity" min="0" max="1000" value="<%= request.getParameter("quantity") %>" required><br><br>
        <input type="submit" value="Edytuj transakcje" class="btn btn-danger"/>
        </form>
    </div>  
    </center> 
</body>
</html>