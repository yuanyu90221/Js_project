import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Transfer extends HttpServlet
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

       String outnumberStr=req.getParameter("OutNumber");
       String innumberStr=req.getParameter("InNumber");
       String amountStr=req.getParameter("Amount");

       HttpSession session = req.getSession();
       if(session.getAttribute(outnumberStr) == "true")
           out.println("���������X�kSession����");
       else
          {
            amountStr = "0";
            res.sendRedirect("http://163.15.40.242:8080/examples/" +
                                       "CustomerOpt.html");
           }

       String sql1 =  "UPDATE Deposit " +
                             " SET ��X�b��= " + outnumberStr + "," +
                                      " ��J�b��= " + innumberStr + "," +
                                      " ��b���B= " + amountStr +
                             " WHERE �s���b��=000 " + ";";

       String sql2 = "UPDATE Deposit " +
                             "SET ��b���B = DLookup('��b���B', 'Deposit', " +
                                                                          " '�s���b�� = 000') " +
                             "WHERE �s���b�� = (SELECT  ��X�b�� " +
                                                                  "FROM Deposit " +
                                                                  "WHERE �s���b�� = 000) ";

       String  sql3 = "UPDATE Deposit " +
                             "SET ��b���B = DLookup('��b���B', 'Deposit', " +
                                                                          " '�s���b�� = 000') " +
                             "WHERE �s���b�� = (SELECT ��J�b�� " +
                                                                  "FROM Deposit " +
                                                                  "WHERE �s���b�� = 000) ";

       String  sql4 = "UPDATE Deposit " +
                                 "SET �l�B = �l�B - ��b���B " +
                                 "WHERE �s���b�� = (SELECT ��X�b�� " +
                                                                      "FROM Deposit " +
                                                                      "WHERE �s���b�� = 000)";

       String  sql5 = "UPDATE Deposit " +
                                 "SET �l�B = �l�B + ��b���B " +
                                 "WHERE �s���b�� = (SELECT ��J�b�� " +
                                                                      "FROM Deposit " +
                                                                      "WHERE �s���b�� = 000)";

       String  sql6 = "SELECT �l�B " +
                               "FROM Deposit " +
                               "WHERE �s���b�� = " + outnumberStr + ";";

       out.println("<HTML><HEAD><TITLE>Transfer</TITLE></HEAD>");
       out.println("<BODY>");
       SqlTransfer result = new SqlTransfer(con, sql1, sql2, sql3, sql4, sql5, sql6);
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