<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
    <title>Kategorie</title>
</head>
<body>
<nav class="navbar navbar-dark bg-dark">
  <a class="navbar-brand" href="#"><center>Księgarnia</center></a>
<div class="p-3 mb-2 bg-light text-dark">
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
        <h3>Znajdz kategorię: </h3>
          <form method="get" action="CategoryServlet">
        <input type="hidden" name="dzialanie" value="/find">
        <input type="text" name="word"><br>
        <input type="submit" value="Wyszukaj"  class="btn btn-danger" /></td></tr>  
        </form>
        
        
    </center>
    <div align="center">
        <table border="1" cellpadding="3" class="table table-striped" >
           
            <tr>
                <th>ID</th>
                <th>Nazwa</th>
                <th>Edycja</th>
                <th>Usuwanie</th>
            </tr>
            <c:forEach var="category" items="${listCat}">
                <tr>
                    <td><c:out value="${category.id}" /></td>
                    <td><c:out value="${category.category_name}" /></td>
                    <td>
                   <form action="EditCategory.jsp" method="post">
                    	<input type="hidden" name="id" value="<c:out value='${category.id}'/>">
                     	<button type="submit" class="btn btn-secondary" name="name" value="<c:out value='${category.category_name}'/>">Edytuj</button>
                    </form>
                    </td>
                    <td>
                    
                        <a href=CategoryServlet?dzialanie=/delete&id=<c:out value='${category.id}' />>Usuń rekord</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
                <form action="/for_payara/CategoryServlet">
    		<input type="submit" value="Wyświetl wszystkie kategorie książek" class="btn btn-warning" />
    		<input type="hidden" name="dzialanie" value="/list">
		</form>
        <br><h3> Dodaj nową kategorię:</h3>
        <form method="get" action="CategoryServlet">
        <input type="hidden" name="dzialanie" value="/insert">
        Nazwa kategorii: <input type="text" name="name" required><br>
        <input type="submit" value="Dodaj" class="btn btn-danger" /></td></tr>  
        </form>
    </div>  
</div> 
    
</body>
</html>