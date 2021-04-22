<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
    <title>Książki</title>
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
        <h3>Znajdz Książkę</h3>
         <form method="get" action="BookServlet">
        <input type="hidden" name="dzialanie" value="/find">
        Tytuł: <input type="text" name="title"><br>
        Autor: <input type="text" name="author"><br>
        Kategoria: <input type="text" name="catname"><br>
        Wydawca: <input type="text" name="pubname"><br>
        <input type="submit" value="Wyszukaj"  class="btn btn-danger" /></td></tr>  
        </form>
     
    </center>
    <div align="center">
        <table border="1" cellpadding="9" class="table table-striped">
           
            <tr>
                <th>ID</th>
                <th>Nazwa</th>
                <th>Autor</th>
                <th>Kategoria</th>
                <th>Wydawca</th>
                <th>Cena</th>
                <th>Ilość</th>
                <th>Edycja</th>
                <th>Usuwanie</th>
            </tr>
            <c:forEach var="book" items="${listBook}">
                <tr>
                    <td><c:out value="${book.id}" /></td>
                    <td><c:out value="${book.title}" /></td>
                    <td><c:out value="${book.author}" /></td>
                    <td><c:out value="${book.cat_name}" /></td>
                    <td><c:out value="${book.pub_name}" /></td>
                    <td><c:out value="${book.price}" /></td>
                    <td><c:out value="${book.quantity}" /></td>
                    <td>
                        <form action="BookServlet" method="post">
                        	<input type="hidden" name="dzialanie" value="/load_edit">
                    		<input type="hidden" name="id" value="<c:out value='${book.id}'/>">
                    		<input type="hidden" name="title" value="<c:out value='${book.title}'/>">
                    		<input type="hidden" name="author" value="<c:out value='${book.author}'/>">
                    		<input type="hidden" name="catid" value="<c:out value='${book.catid}'/>">
                    		<input type="hidden" name="pubid" value="<c:out value='${book.pubid}'/>">
                    		<input type="hidden" name="price" value="<c:out value='${book.price}'/>">
                     		<button type="submit" name="quantity" class="btn btn-secondary" value="<c:out value='${book.quantity}'/>">Edytuj</button>
                   		</form>
                    </td>
                        <td>
                        <a href=BookServlet?dzialanie=/delete&id=<c:out value='${book.id}' />>Usuń rekord</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
              <form action="/for_payara/BookServlet">
    		<input type="submit" value="Wyświetl wszystkie książki" class="btn btn-warning" />
    		<input type="hidden" name="dzialanie" value="/list">
		</form>
		<br>
		<h3>Dodaj nową książkę</h3> <br>
        <form method="get" action="BookServlet" >
        	<input type="hidden" name="dzialanie" value="/insert">
        	Tytuł: <input type="text" name="title" required><br>
        	Autor: <input type="text" name="author" required><br>
        	Wydawca: <select name="publishers">
	        	<c:forEach var="item" items="${listpublisher}">
	        		<option value="${item.id}">${item.pub_name}</option>
	        	</c:forEach>
        	</select><br>
            Kategoria: <select name="categories" >
		       <c:forEach var="item2" items="${listcategory}">
		         <option value="${item2.id}">${item2.category_name}</option>
		       </c:forEach>
		     </select><br>
       Cena za sztukę: <input type="number" min="0" max="10000" step="0.01" name="price" required><br>
        Ilość na stanie: <input type="number" min="0" max="10000" name="quantity" required><br>
        <input type="submit" value="Dodaj książkę" class="btn btn-danger" />
        </form>
    </div>   
</body>
</html>