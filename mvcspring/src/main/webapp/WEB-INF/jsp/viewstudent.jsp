  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   <%@ page isELIgnored="false"  %>    
  
<h1>Students List</h1>  
<table style="border:2px">  
<tr><th>Id</th><th>Name</th><th>Salary</th><th>Designation</th><th>Edit</th><th>Delete</th></tr>  
   <c:forEach var="stud" items="${list}">   
   <tr>  
   <td><c:out value="${stud.Id}"></c:out></td>  
   <td><c:out value="${stud.Name}"></c:out></td>  
   <td><c:out value="${stud.Sem}"></c:out></td>  
   <td><c:out value="${stud.CPI}"></c:out></td>  
   <td><a href="editstud/${stud.Id}">Edit</a></td>  
   <td><a href="deletestud/${stud.Id}">Delete</a></td>  
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
   <a href="studform">Add New Student</a>