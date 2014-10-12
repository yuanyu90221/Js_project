import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Ex28 extends HttpServlet
   {
     public void doGet(HttpServletRequest request, 
                                  HttpServletResponse response)
          throws ServletException, IOException
        {
          String ClientAddr = request.getRemoteAddr();
          response.setContentType("text/html;charset=big5");
          PrintWriter out = response.getWriter();
          out.println("<html><head>");
          out.println("<title>Ex28</title></head><body>");
          out.println("ClientAddress¡G" + ClientAddr+"<p>");
          out.println("</body></html>");
          out.close();
         }
    }
