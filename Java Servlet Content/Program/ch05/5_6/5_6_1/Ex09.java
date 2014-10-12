import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Ex09 extends HttpServlet
 {
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
        throws ServletException, IOException
   {
    int a=3, x, y;

    x = ~a;
    y = ~a + 1;

    response.setContentType("text/html;charset=big5");
    PrintWriter out = response.getWriter();

    out.println("<html><head><title>Ex09</title></head><body>");
    out.println("~3 = " + x + "<br>");
    out.println("~3 + 1 = " + y + "<br>");
    out.println("</body></html>");
    out.close();
   }
 }