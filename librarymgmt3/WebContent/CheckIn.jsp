<%@ page import = "dxc.web.lib2.bean.Book,java.util.ArrayList"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>

<body>
     <form action ="CheckInServlet" method =post>
        Select the Subject
        <select name ="subject">
           <option value ="cpp">C++</option>
           <option value ="java">Java</option>
           <option value ="jee">JEE</option>
           <option value ="python">Python</option>
           <option value ="oracle">Oracle</option>
           <option value ="angular">Angular</option>
           </select>
           <input type = submit value ="Show Books"
 name ="checkin"><hr width= 10% >
 <table align =center width =50% border =1>
 <tr>
     <th>Book Id</th>
     <th>Book Title</th>
     <th>Author</th>
     <th>Available Copies</th>
     </tr>
     <c:forEach var ="b" items ="${bookList }">
       <tr>
          <td>${b.bookId }</td>
          <td>${b.bookTitle }</td>
          <td>${b.author }</td>
          <td>${b.availCopies}</td>
          </tr>
          </c:forEach>
       </table>  
       <hr>
       <table align = center width=50%>
           <tr>
              <th>Member Id</th>
              <td><input type = text name ="memberId"></td>
              <th>Book Id</th>
              <td><input type = text name ="bookId"></td>
              </tr>
              <tr>
              <td><input type = submit  value ="Check In" name="checkin"></td>
              </tr>
       </table>         
       
     </form>
</body>
</html>