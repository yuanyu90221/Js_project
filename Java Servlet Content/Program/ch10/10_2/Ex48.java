import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Ex48 extends HttpServlet
 {
  int i=0;

  public void service(HttpServletRequest request,
                    HttpServletResponse response)
        throws ServletException, IOException
   {
    i = i + 1;
    response.setContentType("text/html;charset=big5");
    PrintWriter out = response.getWriter();

    out.println("<html><head><title>Ex48</title></head><body>");
    out.println("This is the Sub Page of Ex48" + "<br>");
    out.println("Driven by Ex48.html" + "<br>");
    out.println("網站資料 i = " + i + "<br>");
    out.println("</body></html>");
    out.close();
   }
 }