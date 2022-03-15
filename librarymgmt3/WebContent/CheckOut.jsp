<%@page import ="dxc.web.lib2.bean.Transaction" %>
<%@taglib uri ="http://java.sun.com/jsp/jstl/core" prefix ="c" %> 
<!DOCTYPE html>
<html>
<body>
    <h1 style ="text-align:center;text-decoration:underline;color:red">CheckOut Screen</h1>
    <form action ="CheckOutServlet">
    Member Id<input type = text name ="memberId">
    <input type = submit value ="getDetails" name ="checkout">
    <c:if test ="${memberObj!=null}">
       <table align="left" border="1">
           <caption>MemberDetails</caption>
           <tr>
              <th>Member Id</th>
              <td>${memberObj.memberId}</td>
              </tr>
              <tr>
                 <th> Member Name</th>
                 <td>${memberObj.name}</td>
                 </tr>
                 <tr>
                    <th>Aadhar No</th>
                    <td>${memberObj.aadaharNo }</td>
                    </tr>
                    <tr>
                    <th>Phone</th>
                    <td>${memberObj.phone}</td>
                    </tr>
                    <tr>
                    <th> EmailId</th>
                    <td>${memberObj.emailId }</td>
                    </tr>
                    
       </table>
       </c:if>
    <table align = center width = 50% border=1>
       <caption>BookIssueDetails</caption>
    <tr>
      <th>Book Id</th>
      <th>Book Title</th>
      <th>Issued Date</th>
      <th>Status</th>
      </tr>
      <c:forEach var ="t" items ="${transObj}">
      <tr>
          <td>${t[0]}</td>
          <td>${t[1]}</td>
          <td>${t[2]}</td>
          <td>${t[3]}</td>
          </tr>
          </c:forEach>
      </table>
      <hr>
        BookId<input type = text name="bookId">
        <input type = submit value="Return Book" name="checkout">
    </form>

</body>
</html>