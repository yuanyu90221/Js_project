import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Withdraw extends HttpServlet
  {
   private Connection con = null;
   public void init(ServletConfig config)  throws ServletException
     {
       try
         {
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           con = DriverManager.getConnection("jdbc:odbc:Bank"); 
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

       String outnumberStr=req.getParameter("Outnumber");
       String amountStr=req.getParameter("Amount");

       HttpSession session = req.getSession();
       if(session.getAttribute(outnumberStr) == "true")
           out.println("本網頁為合法Session網頁");
       else
          {
            amountStr = "0";
            res.sendRedirect("http://163.15.40.242:8080/examples/" +
                                       "CustomerOpt.html");
           }
       String sql1 = "UPDATE Deposit " +
                           " SET 餘額 = 餘額 - " + amountStr  +
                           " WHERE 存褶帳號 = " + outnumberStr + ";";

       String sql2 = "SELECT  餘額 " +
                               "FROM Deposit " +
                               "WHERE 存褶帳號 = " + outnumberStr + ";";

        out.println("<HTML><HEAD><TITLE>Withdraw</TITLE></HEAD>");
        out.println("<BODY>");
        SqlWithdraw result = new SqlWithdraw(con, sql1, sql2);
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