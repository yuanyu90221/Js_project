import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Ex33 extends HttpServlet
 {
  public void doPost(HttpServletRequest request,
                    HttpServletResponse response)
        throws ServletException, IOException
   {
    response.setContentType("text/html;charset=big5");
    PrintWriter out = response.getWriter();

    out.println("<html><head><title>Ex33</title></head><body>");
    out.println("This is the Sub Page of Ex33" + "<br>");
    out.println("Driven by Ex33.html" + "<br>");
    out.println("</body></html>");
    out.close();
   }
 }