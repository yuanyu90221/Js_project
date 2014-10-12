import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class InsertStudent extends HttpServlet
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
     String nameStr = req.getParameter("Name");
     String addressStr = req.getParameter("Address");

     String sql="INSERT INTO Students(准考證號碼, 姓名, 地址)" +
                " VALUES (" + numberStr + ",'" + nameStr + "','" + addressStr +"')" ;

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