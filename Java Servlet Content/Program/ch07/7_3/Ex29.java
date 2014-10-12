import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Ex29 extends HttpServlet
   {
     public void doGet(HttpServletRequest request, 
                                  HttpServletResponse response)
          throws ServletException, IOException
        {
          String ClientOpt = request.getHeader("user-agent");

          response.setContentType("text/html;charset=big5");
          PrintWriter out = response.getWriter();
          out.println("<html><head>");
          out.println("<title>Ex29</title></head><body>");
          out.println("ClientOpt¡G" + ClientOpt +"<p>");
          out.println("</body></html>");
          out.close();
         }
    }
