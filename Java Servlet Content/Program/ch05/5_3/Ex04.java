import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Ex04 extends HttpServlet
 {
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
        throws ServletException, IOException
   {
    int a, b, c, d;

    a=b=c=d=10;
    
    response.setContentType("text/html;charset=big5");
    PrintWriter out = response.getWriter();

    out.println("<html><head><title>Ex04</title></head><body>");
    out.println("�e�m���W ++a = " + ++a + "<br>");
    out.println("��m���W b++ = " + b++ + "<br>");
    out.println("�e�m���� --c = " + --c + "<br>");
    out.println("��m���� d-- = " + d-- + "<br>");
    out.println("</body></html>");
    out.close();
   }
 }