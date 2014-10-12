import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Ex01 extends HttpServlet 
  {
   public void doGet(HttpServletRequest request,
                     HttpServletResponse response)
         throws IOException, ServletException
     {
      PrintWriter out = response.getWriter();
      out.println("<FONT size='5' color='red'> " +
                  "My First Servlet Porgramming !!</FONT>");
     }
   }



