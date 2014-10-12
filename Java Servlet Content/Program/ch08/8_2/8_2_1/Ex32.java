import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Ex32 extends HttpServlet
 {
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
        throws ServletException, IOException
   {
    response.setContentType("text/html;charset=big5");
    PrintWriter out = response.getWriter();

    out.println("<html><head><title>Ex32</title></head><body>");
    out.println("This is the Sub Page of Ex32" + "<br>");
    out.println("Driven by Ex32.html" + "<br>");
    out.println("</body></html>");
    out.close();
   }
 }