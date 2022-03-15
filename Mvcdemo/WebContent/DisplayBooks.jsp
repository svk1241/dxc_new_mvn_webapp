<%@ page import="java.util.ArrayList,dxc.mvc.demo.bean.Book"%>
<%
   ArrayList<Book> blist=(ArrayList<Book>)request.getAttribute("booklist");
%>
<!DOCTYPE html>
<html>
<body>
      <table align=center border=1 width=50%>
      <tr>
          <th>BookId</th>
          <th>BookTitle</th>
          <th>Author</th>
          <th>Publisher</th>
          <th>Price</th>
          </tr>
          <%
             for(Book b : blist)
             {
            	 
             
          %>
           <tr>
          <td><%=b.getBookId()%></td>
          <td><%=b.getBookTitle()%></td>
          <td><%=b.getAuthor()%></td>
          <td><%=b.getPublisher()%></td>
          <td><%=b.getPrice()%></td>
          </tr>
          
          <%
             }
          
          %>
      </table>
</body>
</html>