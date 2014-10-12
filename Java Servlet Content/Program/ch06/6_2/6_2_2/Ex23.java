import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Ex23 extends HttpServlet
 {
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
        throws ServletException, IOException
   {
    int score;
    char grade;

    score = 70;

    if(score>=90)
       grade = 'A';
      else if(score>=80 & score<90)
              grade = 'B';
          else if(score>=70 & score<80)
                  grade = 'C';
             else if(score>=60 & score<70)
                     grade = 'D';
                else
                    grade = 'F';

    response.setContentType("text/html;charset=big5");
    PrintWriter out = response.getWriter();

    out.println("<html><head><title>Ex23</title></head><body>");
    out.println("grade = " + grade + "<br>");
    out.println("</body></html>");
    out.close();
   }
 }