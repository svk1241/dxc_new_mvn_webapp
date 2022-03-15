<%@page import ="com.dxc.spwebmvcdemo.bean.Book"  isELIgnored="false"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
 // Book b = (Book)request.getAttribute("book");
  //if(b==null) b= new Book();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <form action ="bookCrud" method = post>
        <table align = center width=50% bgcolor=blue>
        <tr>
           <th>Book Id</th>
           <td><input type = text name = bookId value="${book.bookId}"></td>
           </tr>
           <tr>
           <th>Book Title</th>
           <td><input type = text name =booktitle  value="${book.bookTitle}"></td>
           </tr>
           <tr>
           <th>Author</th>
           <td><input type = text name =author value="${book.author}"></td>
           </tr>
           <tr>
           <th>Publisher</th>
           <td><input type =text name=publisher value="${book.publisher}"></td>
           </tr>
           <tr>
           <th>Price</th>
           <td><input type = text name = price value="${book.price}"></td>
           </tr>
           <tr>
           <th>Subject</th>
           <td><input type = text name = subject value="${book.subject}"></td>
           </tr>
           <tr>
           <th>Total Copies</th>
           <td><input type = text name = copies value="${book.totalCopies}"></td>
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
                   }
                
           </table>
    </form>

</body>
</html>