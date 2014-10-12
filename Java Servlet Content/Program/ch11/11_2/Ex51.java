import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Ex51 extends HttpServlet
 {
  String message="";  

  public synchronized void doPost(HttpServletRequest request,
                                                        HttpServletResponse response)
        throws ServletException, IOException
   {
    response.setContentType("text/html;charset=big5");
    PrintWriter out = response.getWriter();
    request.setCharacterEncoding("big5");

    String val = request.getParameter("data");
    message = message + val;

    out.println("<html><head><title>Ex51</title></head><body>");
    out.println("This is the Sub Page of Ex51" + "<br>");
    out.println("" + "<br>");
    out.println("¦@¨É¸ê®Æ¡G " + message + "<br>");
    out.println("</body></html>");
    out.close();
   }
 }