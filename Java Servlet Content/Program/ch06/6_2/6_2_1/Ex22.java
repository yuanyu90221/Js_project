import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Ex22 extends HttpServlet
 {
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
        throws ServletException, IOException
   {
    int score;
    String statement;

    score = 70;

    if(score>=60)
      statement = "pass";
    else
      statement = "fail";

    response.setContentType("text/html;charset=big5");
    PrintWriter out = response.getWriter();

    out.println("<html><head><title>Ex22</title></head><body>");
    out.println("statement = " + statement + "<br>");
    out.println("</body></html>");
    out.close();
   }
 }