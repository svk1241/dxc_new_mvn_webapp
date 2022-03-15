<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.ArrayList,dxc.mvc.demo.bean.Book"%>
<html>
<body>
      <table width=50% align=center border=1 width=50%>
      <caption>Using jstl</caption>
      <tr>
          <th>BookId</th>
          <th>BookTitle</th>
          <th>Author</th>
          <th>Publisher</th>
          <th>Price</th>
          </tr>
          <c:forEach var="b" items="${booklist}">
          	<tr>
          		<td>${b.bookId}</td>
          		<td>${b.bookTitle}</td>
          		<td>${b.author}</td>
          		<td>${b.publisher}</td>
          		<td>${b.price}</td>
          	</tr>
          </c:forEach>
		</table>
	</body>
</html>
