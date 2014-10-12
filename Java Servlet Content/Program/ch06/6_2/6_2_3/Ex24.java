import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Ex24 extends HttpServlet
 {
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
        throws ServletException, IOException
   {
    int score;
    char grade;

    score = 70;

    switch(score)
      {
       case 90:
            grade = 'A';
            break;
       case 80:
            grade = 'B';
            break;
       case 70:
            grade = 'C';
            break;
       case 60:
            grade = 'D';
            break;
       default:
            grade = 'F';
       }

    response.setContentType("text/html;charset=big5");
    PrintWriter out = response.getWriter();

    out.println("<html><head><title>Ex24</title></head><body>");
    out.println("grade = " + grade + "<br>");
    out.println("</body></html>");
    out.close();
   }
 }