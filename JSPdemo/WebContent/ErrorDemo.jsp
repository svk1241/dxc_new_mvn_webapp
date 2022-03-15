<%@page errorPage="ErrorHandler.jsp" %>

<%
    int x= Integer.parseInt(request.getParameter("fnum"));
    int y= Integer.parseInt(request.getParameter("snum"));
    String results =" the Division Results is  "+(x/y);
%>
     <h1 style ="text-align:center;color:green"><%= results %></h1>
