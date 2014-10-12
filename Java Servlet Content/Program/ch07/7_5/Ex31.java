import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
public class Ex31 extends HttpServlet
   {
     public void doGet(HttpServletRequest request,
                                      HttpServletResponse response)
         throws ServletException, IOException
       {
         String item = null , value = null;

         response.setContentType("text/html;charset=big5");
         PrintWriter out = response.getWriter();
         out.println("<html><head>");
         out.println("<title>Ex31</title></head><body>");
         out.println("<table border=\"1\">");
         Enumeration en = request.getHeaderNames();
         while(en.hasMoreElements())
             {
               item=(String)en.nextElement();
               value = request.getHeader(item);
               out.println("<tr><td>"+item+"</td><td>"+value+"</td></tr>");
              }
            out.println("</table>");
            out.println("</body></html>");
            out.close();
           }
    }
