import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Ex60_2 extends HttpServlet
 {
  public synchronized void doGet(HttpServletRequest request,
                    HttpServletResponse response)
        throws ServletException, IOException
   {
    response.setContentType("text/html;charset=big5");
    PrintWriter out = response.getWriter();
    request.setCharacterEncoding("big5");

    HttpSession session = request.getSession();

    out.println("<html><head><title>Ex60_2</title></head><body>");
    out.println("This is the Sub Page of Ex60_2" + "<br>");
    out.println("" + "<br>");

   if(session.getAttribute("Ex60") == "true")
       out.println("認證成功網頁" + "<br>");
   else
       response.sendRedirect("http://163.15.40.242:8080/examples/Ex60.html");

    out.println("</body></html>");
    out.close();
   }
 }