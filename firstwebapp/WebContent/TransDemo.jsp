<h1> JSP will be transaled into Servlet</h1>
<%!
    int x=667;
    public int sum(int a,int b)
    {
      return a+b;
      }
      %>
      <%=sum(x,999) %>