import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Ex55_2 extends HttpServlet
 {
  public synchronized void doPost(HttpServletRequest request,
                                                        HttpServletResponse response)
        throws ServletException, IOException
   {
    response.setContentType("text/html;charset=big5");
    PrintWriter out = response.getWriter();
    request.setCharacterEncoding("big5");

    HttpSession session = request.getSession();
    String sessionID = session.getId();

    out.println("<html><head><title>Ex55_2</title></head><body>");
    out.println("This is the Sub Page of Ex55_2" + "<br>");
    out.println("" + "<br>");

    out.println("sessionID : " + sessionID + "<br>");

    out.println("</body></html>");
    out.close();
   }
 }