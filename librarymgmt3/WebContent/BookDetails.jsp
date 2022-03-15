<%@page import ="dxc.web.lib2.bean.Book" %>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
  Book b = (Book)request.getAttribute("book");
  if(b==null) b= new Book();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <form action ="BookMgmtServlet" method = post>
        <table align = center width=50% bgcolor=blue>
        <tr>
           <th>Book Id</th>
           <td><input type = text name = bookId value=<%=b.getBookId() %>></td>
           </tr>
           <tr>
           <th>Book Title</th>
           <td><input type = text name =booktitle  value=<%=b.getBookTitle() %>></td>
           </tr>
           <tr>
           <th>Author</th>
           <td><input type = text name =author value=<%=b.getAuthor() %>></td>
           </tr>
           <tr>
           <th>Publisher</th>
           <td><input type =text name=publisher value=<%=b.getPublisher()%>></td>
           </tr>
           <tr>
           <th>Price</th>
           <td><input type = text name = price value=<%=b.getPrice()%>></td>
           </tr>
           <tr>
           <th>Subject</th>
           <td><input type = text name = subject value=<%=b.getSubject() %>></td>
           </tr>
           <tr>
           <th>Total Copies</th>
           <td><input type = text name = copies value=<%=b.getTotalCopies()%>></td>
           </tr>
           <tr>
              <td><input type = submit value = Add name ="bookSubmit"></td>
              <td><input type = submit value = Modify name ="bookSubmit"></td>
              <td><input type = submit value =Delete name ="bookSubmit"></td>
              <td><input type = submit value =Show name ="bookSubmit"></td>
              </tr>
              
    
           
        </table>
        <hr>
           <input type =submit value ="ShowAll" name ="bookSubmit">
           <table align = center border =1>
              <tr>
                <th>Book Id</th>
                <th>Book Title</th>
                <th>Author</th>
                <th>Publisher</th>
                <th>Price</th>
                <th>Subject</th>
                <th>Total Copies</th>
                <th>Available Copies</th>
                </tr>
                <c:forEach var ="b" items="${bookList}">
                <tr>
                   <td>${b.bookId}</td>
                   <td>${b.bookTitle}</td>
                   <td>${b.author}</td>
                   <td>${b.publisher }</td>
                   <td>${b.price}</td>
                   <td>${b.subject}</td>
                   <td>${b.totalCopies}</td>
                   <td>${b.availCopies}</td>
                   </tr>
                   </c:forEach>
                   
                
           </table>
    </form>

</body>
</html>