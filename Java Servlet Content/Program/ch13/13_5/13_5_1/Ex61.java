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
       out.println("����J��ơA�Цܭ������s��J" + "<br>");
    else
        out.println("��J��ơG " + val_data + "<br>");

    if(val_sport==null)
       out.println("���I��B�ʡA�Цܭ������s�I��" + "<br>");
    else
        out.println("�I��B�ʡG " + val_sport + "<br>");

    if(val_course.equals(""))
       out.println("������ҥءA�Цܭ������s���" + "<br>");
    else
        out.println("����ҥءG " + val_course + "<br>");

    out.println("</body></html>");
    out.close();
   }
 }