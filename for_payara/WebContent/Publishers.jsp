<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
    <title>Wydawcy</title>
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
        <h3>Znajdz wydawcę: 
          <form method="get" action="PublisherServlet">
        <input type="hidden" name="dzialanie" value="/find">
        <input type="text" name="word"><br>
        <input type="submit" value="Wyszukaj"  class="btn btn-danger" /></td></tr>  
        </form>
        </h3>

    </center>
    <div align="center">
        <table border="1" cellpadding="4" class="table table-striped">
            <tr>
                <th>ID</th>
                <th>Nazwa</th>
                <th>Edycja</th>
                <th>Usuwanie</th>
            </tr>
            <c:forEach var="pub" items="${listPub}">
                <tr>
                    <td><c:out value="${pub.id}" /></td>
                    <td><c:out value="${pub.pub_name}" /></td>
                    <td>
                    
                    <form action="EditPublisher.jsp" method="post">
                    	<input type="hidden" name="id" value="<c:out value='${pub.id}'/>">
                     	<button type="submit" name="name"  class="btn btn-secondary"  value="<c:out value='${pub.pub_name}'/>">Edytuj</button>
                    </form>
                        </td>
                        <td>
                        <a href=PublisherServlet?dzialanie=/delete&id=<c:out value='${pub.id}' />>Usuń rekord</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
              <form action="/for_payara/PublisherServlet">
    		<input type="submit" value="Wyświetl wszystkie wydawnictwa książek" class="btn btn-warning" />
    		<input type="hidden" name="dzialanie" value="/list">
        <br><br> <h3>Dodaj nowego wydawcę:</h3>
        <form method="get" action="PublisherServlet">
        <input type="hidden" name="dzialanie" value="/insert">
        Nazwa wydawcy: <input type="text" name="name" required><br>
        <input type="submit" value="Dodaj" class="btn btn-danger"/>
        </form>
    </div>   
</body>
</html>