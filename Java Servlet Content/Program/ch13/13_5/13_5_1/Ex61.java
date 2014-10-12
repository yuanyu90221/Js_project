import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Ex61 extends HttpServlet
 {
  public void doPost(HttpServletRequest request,
                    HttpServletResponse response)
        throws ServletException, IOException
   {
    response.setContentType("text/html;charset=big5");
    PrintWriter out = response.getWriter();
    request.setCharacterEncoding("big5");

    String val_data = request.getParameter("data");
    String val_sport = request.getParameter("sport");
    String val_course = request.getParameter("course");

    out.println("<html><head><title>Ex61</title></head><body>");
    out.println("This is the Sub Page of Ex61" + "<br>");
    out.println("" + "<br>");

    if(val_data.equals(""))
       out.println("未輸入資料，請至首頁重新輸入" + "<br>");
    else
        out.println("輸入資料： " + val_data + "<br>");

    if(val_sport==null)
       out.println("未點選運動，請至首頁重新點選" + "<br>");
    else
        out.println("點選運動： " + val_sport + "<br>");

    if(val_course.equals(""))
       out.println("未選取課目，請至首頁重新選取" + "<br>");
    else
        out.println("選取課目： " + val_course + "<br>");

    out.println("</body></html>");
    out.close();
   }
 }