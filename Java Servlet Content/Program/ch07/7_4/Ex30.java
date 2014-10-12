import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Ex30 extends HttpServlet
   {
     public void doGet(HttpServletRequest request, 
                                  HttpServletResponse response)
          throws ServletException, IOException
        {
          String ClientLanguage = request.getHeader("accept-language");

          response.setContentType("text/html;charset=big5");
          PrintWriter out = response.getWriter();
          out.println("<html><head>");
          out.println("<title>Ex30</title></head><body>");
          out.println("ClientLanguage¡G" + ClientLanguage +"<p>");
          out.println("</body></html>");
          out.close();
         }
    }
