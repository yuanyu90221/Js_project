import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Ex27 extends HttpServlet
 {
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
        throws ServletException, IOException
   {
    int a;

    for(a=1; a<=3; a++){;}

    response.setContentType("text/html;charset=big5");
    PrintWriter out = response.getWriter();

    out.println("<html><head><title>Ex27</title></head><body>");
    out.println("a = " + a + "<br>");
    out.println("</body></html>");
    out.close();
   }
 }