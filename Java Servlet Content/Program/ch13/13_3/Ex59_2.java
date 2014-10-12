import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Ex59_2 extends HttpServlet
 {
  public synchronized void doGet(HttpServletRequest request,
                    HttpServletResponse response)
        throws ServletException, IOException
   {
    response.setContentType("text/html;charset=big5");
    PrintWriter out = response.getWriter();
    request.setCharacterEncoding("big5");

    HttpSession session = request.getSession();

    out.println("<html><head><title>Ex59_2</title></head><body>");
    out.println("This is the Sub Page of Ex59_2" + "<br>");
    out.println("" + "<br>");

   if(session.getAttribute("Ex59") == "true")
       out.println("認證成功網頁" + "<br>");
   else
       out.println("非認證成功網頁" + "<br>");

    out.println("</body></html>");
    out.close();
   }
 }