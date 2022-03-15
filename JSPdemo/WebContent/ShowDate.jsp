<%@page import ="dxc.jsp.demo.dao.UsersDAO" session ="true" %>
<%
   String username = request.getParameter("uid");
   String password = request.getParameter("pwd");
   if(new UsersDAO().searchUser(username,password))
   {
	   session.setAttribute("uid",username);
       out.print("welcome to jsp technology");
   }
   else
	   out.print("dawn username and password");

%>






















