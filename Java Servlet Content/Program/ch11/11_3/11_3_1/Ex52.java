import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
public class Ex52 extends HttpServlet
 {
  public void doPost(HttpServletRequest request,
                    HttpServletResponse response)
        throws ServletException, IOException
   {
    response.setContentType("text/html;charset=big5");
    PrintWriter out = response.getWriter();
    request.setCharacterEncoding("big5");
    String val = request.getParameter("data");
    Cookie cok = new Cookie("msg", val);
    cok.setMaxAge(3600*24*3);
    response.addCookie(cok);

    out.println("<html><head><title>Ex52</title></head><body>");
    out.println("This is the Sub Page of Ex52" + "<br>");
    out.println("" + "<br>");
    out.println("¦¨¥\¼g¤JCookie : " + val + "<br>");
    out.println("</body></html>");
    out.close();
   }
 }