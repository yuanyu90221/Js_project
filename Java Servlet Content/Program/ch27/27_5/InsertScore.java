import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class InsertScore extends HttpServlet
 {
  private Connection con = null;
  public void init(ServletConfig config) throws ServletException
    {
      try
         {
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           con = DriverManager.getConnection("jdbc:odbc:Exam");
          }
       catch(Exception e){}
      }

  public synchronized void doGet(HttpServletRequest req,
                                                       HttpServletResponse res)
               throws ServletException, IOException
    {
     ServletOutputStream sos=res.getOutputStream();
     res.setContentType("text/html;charset=big5");
     PrintWriter out = new PrintWriter(sos, true);
     req.setCharacterEncoding("big5");

     String numberStr = req.getParameter("Number");
     String cnsStr = req.getParameter("Cns");
     String engStr = req.getParameter("Eng");
     String mathStr = req.getParameter("Math");
     String techStr = req.getParameter("Tech");
     String peopStr = req.getParameter("Peop");

     String sql="INSERT INTO Scores(准考證號碼, 國文, " +
                        "英文, 數學, 自然, 社會)" + " VALUES (" + 
                        numberStr + "," + cnsStr + "," +   engStr + "," +   
                        mathStr  + "," + techStr + "," + peopStr +")" ;

     HttpSession session = req.getSession();
     if(session.getAttribute("M_Authroity") == "true")
         out.println("本網頁為合法Session網頁" + "<p></p>");
     else
        res.sendRedirect("http://163.15.40.242:8080/servlets/ExamPage.html");

     out.println("<HTML><HEAD><TITLE>Books update</TITLE></HEAD>");
     out.println("<BODY>");

     SqlResult result = new SqlResult(con, sql);
     out.println(result);
     out.println("</BODY></HTML>");
     }

  public void destroy()
    {
     try { if (con != null) con.close(); }
     catch (SQLException ignored) { }
    }

  public synchronized void doPost(HttpServletRequest req,
                     HttpServletResponse res)
  throws ServletException, IOException
    {
     doGet(req, res);
    }
  }