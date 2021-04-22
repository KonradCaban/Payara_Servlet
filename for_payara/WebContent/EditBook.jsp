<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
    <title>Książka</title>
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
		        <form action="/for_payara/BookServlet">
    		<input type="submit" value="Wróć do zarządzania książkami" class="btn btn-danger" />
    		<input type="hidden" name="dzialanie" value="/list">
		</form> <br>
Zmień dane:
        <form method="get" action="BookServlet">
        <input type="hidden" name="dzialanie" value="/edit">
        <input type="hidden" name="id" value="<%= request.getParameter("id") %>">
        Tytuł: <input type="text" name="title" value="<%= request.getParameter("title") %>" required><br>
        Autor: <input type="text" name="author" value="<%= request.getParameter("author") %>" required><br>
		Kategoria:   <select name="categories">
          			<c:forEach var="item" items="${listcategory}">
           				 <option value="${item.id}"  ${item.id == cat_id ? 'selected="selected"' : ''}>${item.category_name}</option>
          			</c:forEach>
        </select><br>
        Wydawca:
          <select name="publishers">
          			<c:forEach var="item2" items="${listpublisher}">
           				 <option value="${item2.id}"  ${item2.id == pub_id  ? 'selected="selected"' : ''}>${item2.pub_name}</option>
          			</c:forEach>
        </select><br>
        Cena: <input type="number" name="price" min="0" max="10000" step="0.01" value="<%= request.getParameter("price") %>" required><br>
        Ilość: <input type="number" name="quantity" min="0" max="100" value="<%= request.getParameter("quantity") %>" required><br><br>
        <input type="submit" value="Edytuj książkę" class="btn btn-danger"/>
        </form>
    </div>   
    </center>
</body>
</html>