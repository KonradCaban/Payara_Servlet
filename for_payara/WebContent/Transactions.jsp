<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>	
    <title>Transakcje</title>
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
        <h3>Znajdz Transakcje</h3> 
          <form method="get" action="TransactionServlet">
        <input type="hidden" name="dzialanie" value="/find">
        Tytuł: <input type="text" name="book"><br>
        Klient: <input type="text" name="client"><br>
        <input type="submit" value="Wyszukaj" class="btn btn-danger"  /></td></tr>  
        </form>
        </h1>
      
    </center>
    <div align="center">
        <table border="1" cellpadding="6" class="table table-striped">
            
            <tr>
                <th>ID</th>
                <th>Klient</th>
                <th>Książka</th>
                <th>Ilość</th>
                <th>Edycja</th>
                <th>Usuwanie</th>
            </tr>
            <c:forEach var="item" items="${listTr}">
                <tr>
                    <td><c:out value="${item.id}" /></td>
                    <td><c:out value="${item.client_name}" /></td>
                    <td><c:out value="${item.book_name}" /></td>
                    <td><c:out value="${item.quantity}" /></td>
                    <td>
                        <form action="TransactionServlet" method="post">
                        	<input type="hidden" name="dzialanie" value="/load_edit">
                        	<input type="hidden" name="id" value="<c:out value='${item.id}'/>">
                    		<input type="hidden" name="bookid" value="<c:out value='${item.book_id}'/>">
                    		<input type="hidden" name="clid" value="<c:out value='${item.client_id}'/>">
                     		<button type="submit" name="quantity"  class="btn btn-secondary"  value="<c:out value='${item.quantity}'/>">Edytuj</button>
                   		</form>
                    </td>
                        <td>
                        <a href=TransactionServlet?dzialanie=/delete&id=<c:out value='${item.id}' />>Usuń rekord</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
        <form action="/for_payara/TransactionServlet">
    		<input type="submit" value="Wyświetl wszystkie kategorie książek" class="btn btn-warning" />
    		<input type="hidden" name="dzialanie" value="/list">
		</form>
		<br><h3> Dodaj nową transakcję:</h3>
        <form method="get" action="TransactionServlet">
        <input type="hidden" name="dzialanie" value="/insert">
        Ilość: <input type="number" name="quantity" min="1" max="10" required><br>
       
       Klient: <select name="clients">
	        	<c:forEach var="item" items="${listclient}">
	        		<option value="${item.id}">${item.name}&nbsp;${item.surname } </option>
	        	</c:forEach>
        	</select><br>
            Książka: <select name="books">
		       <c:forEach var="item2" items="${listbook}">
		         <option value="${item2.id}">${item2.title}</option>
		       </c:forEach>
		     </select><br><br>
		      <input type="submit"  class="btn btn-danger"  value="Dodaj transakcję"/>
        
        </form>
    </div>   
</body>
</html>