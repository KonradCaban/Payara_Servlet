<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>
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
        <h3>Znajdz klienta księgarni: </h3>
        <form method="get" action="ClientServlet">
        <input type="hidden" name="dzialanie" value="/find">
        Imię:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" name="name"><br>
        Nazwisko: <input type="text" name="surname"><br>
        Miasto: &nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="city"><br>
        Adres: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="address"><br>
        Telefon:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" name="phone"><br><br>
        <input type="submit" value="Wyszukaj" class="btn btn-danger"/></td></tr>  
        </form>
        
       

    </center>
    <div align="center">
        <table border="1" cellpadding="7" class="table table-striped" >
            
            <tr>
                <th>ID</th>
                <th>Imię i nazwisko</th>
                <th>Miasto</th>
                <th>Adres</th>
                <th>Numer telefonu</th>
                <th>Edycja</th>
                <th>Usuwanie</th>
            </tr>
            <c:forEach var="cli" items="${listClients}">
                <tr>
                    <td><c:out value="${cli.id}" /></td>
                    <td><c:out value="${cli.name}"/> <c:out value="${cli.surname}"/></td>
                    <td><c:out value="${cli.city}" /></td>
                    <td><c:out value="${cli.adress}" /></td>
                    <td><c:out value="${cli.phone}" /></td>
                    <td>
                     	<form action="EditClient.jsp" method="post">
                    		<input type="hidden" name="id" value="<c:out value='${cli.id}'/>">
                    		<input type="hidden" name="name" value="<c:out value='${cli.name}'/>">
                    		<input type="hidden" name="surname" value="<c:out value='${cli.surname}'/>">
                    		<input type="hidden" name="city" value="<c:out value='${cli.city}'/>">
                    		<input type="hidden" name="adress" value="<c:out value='${cli.adress}'/>">
                     		<button type="submit" name="phone"  class="btn btn-secondary" value="<c:out value='${cli.phone}'/>">Edytuj</button>
                   		</form>
                    </td>
                        <td>
                        <a href=ClientServlet?dzialanie=/delete&id=<c:out value='${cli.id}' />>Usuń rekord</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
                             <form action="/for_payara/ClientServlet">
    		<input type="submit" value="Wyświetl wszystkich klientów księgarni" class="btn btn-warning" />
    		<input type="hidden" name="dzialanie" value="/list">
		</form>
        <form method="get" action="ClientServlet"><br><h3>Dodaj nowego klienta:</h3><br>
        <input type="hidden" name="dzialanie" value="/insert">
        Imię:   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" name="name" required><br>
        Nazwisko: <input type="text" name="surname" required><br>
        Miasto:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" name="city" required><br>
        Adres: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="adress" required><br>
        Numer telefonu: <input type="number" min="0" max="999999999" name="phone" required><br><br>
        <input type="submit" class="btn btn-danger" value="Dodaj klienta"/></td></tr>  
        </form>
    </div>   
    
    
</body>
</html>