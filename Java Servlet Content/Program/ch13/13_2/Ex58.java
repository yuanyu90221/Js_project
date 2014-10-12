import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Ex58 extends HttpServlet
 {
  public synchronized void doPost(HttpServletRequest request,
                                                        HttpServletResponse response)
        throws ServletException, IOException
   {
    response.setContentType("text/html;charset=big5");
    PrintWriter out = response.getWriter();
    request.setCharacterEncoding("big5");

    String user = request.getParameter("user");
    String pwd = request.getParameter("pwd");

    out.println("<html><head><title>Ex58</title></head><body>");
    out.println("This is the Sub Page of Ex58" + "<br>");
    out.println("" + "<br>");

    if(user.equals("¸ë»T¥Í") && pwd.equals("1234"))
        out.println("¦WºÙ±K½XµL»~");
    else
        out.println("¦WºÙ±K½X¦³»~");

     out.println("</body></html>");
     out.close();
   }
 }