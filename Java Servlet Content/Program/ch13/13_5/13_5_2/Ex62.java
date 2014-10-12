import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Ex62 extends HttpServlet
 {
  public void doPost(HttpServletRequest request,
                    HttpServletResponse response)
        throws ServletException, IOException
   {
    response.setContentType("text/html;charset=big5");
    PrintWriter out = response.getWriter();
    request.setCharacterEncoding("big5");

    String val_String = request.getParameter("number");
    int val_Int = Integer.parseInt(val_String); 

    out.println("<html><head><title>Ex62</title></head><body>");
    out.println("This is the Sub Page of Ex62" + "<br>");
    out.println("" + "<br>");

    if((val_Int>0) && (val_Int<=999999))
       out.println("輸入數字： " +  val_Int + "<br>");
    else
        out.println("非合法輸入數字" + "<br>");

    out.println("</body></html>");
    out.close();
   }
 }