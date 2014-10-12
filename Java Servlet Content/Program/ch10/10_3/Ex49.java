import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Ex49 extends HttpServlet
 {
  int i=0, j=0;

  public void init(ServletConfig config) throws ServletException
   {
     j = j + 1;
    }

  public void service(HttpServletRequest request,
                    HttpServletResponse response)
        throws ServletException, IOException
   {
    i = i + 1;
    response.setContentType("text/html;charset=big5");
    PrintWriter out = response.getWriter();

    out.println("<html><head><title>Ex49</title></head><body>");
    out.println("This is the Sub Page of Ex49" + "<br>");
    out.println("Driven by Ex49.html" + "<br>");
    out.println("網站資料 i = " + i + "<br>");
    out.println("網頁資料 j = " + j + "<br>");
    out.println("</body></html>");
    out.close();
   }

   public void destroy(){;}
 }