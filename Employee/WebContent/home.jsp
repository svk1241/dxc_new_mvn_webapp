<%@ page import="java.util.ArrayList,com.dxc.employeedetails.bean.Employee"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
  // ArrayList<Employee> elist=(ArrayList<Employee>)request.getAttribute("empList");
       Employee e=(Employee)request.getAttribute("employee");
           if(e==null) e=new Employee();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <form action ="EmployeeServlet" method="post">
   <table align=center >
      <tr>
        <th>Employee Id</th>
        <td><input type="text"  name="id" value=0> </td>
       
        </tr>
        <tr>
        <th>Employee name</th>
        <td><input type="text" name="name" value="null"> </td>
       
        </tr>
        <tr>
        <td><input type ="submit" name ="empSubmit" value="submit" ></td>
        <td><input type ="reset" value="reset"></td>
        </tr>
        
   </table>
   <hr>
    <td> <input type ="submit" name ="empSubmit" value="showAll"></td>
     <table  align = center border=1> 
        <tr>
            <th>Id</th>
             <th>Name</th>
        </tr>
          <c:forEach var ="e" items="${empList}">
         
                   <tr>
                     <td>${e.id }</td>
                     <td>${e.name }</td>
                     </tr>
                     </c:forEach>
     </table>
   </form>

</body>
</html>