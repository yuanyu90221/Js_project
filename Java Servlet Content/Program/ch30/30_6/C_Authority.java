import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class C_Authority extends HttpServlet
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

    res.setContentType("text/html;charset=big5");
    ServletOutputStream sos=res.getOutputStream();
    PrintWriter out=new PrintWriter(sos,true);
    req.setCharacterEncoding("big5");

    String numberStr = req.getParameter("Number");
    String pwdStr = req.getParameter("Pwd");

    String sql="SELECT * FROM Customers WHERE �s���b��=" +
               numberStr + " AND �K�X='" + pwdStr +"';" ;

    HttpSession session = req.getSession();
    session.setAttribute(numberStr, "true");

    try
      {
       Statement statement = con.createStatement();
       ResultSet rs = statement.executeQuery(sql);
       boolean flag = false;
 
       while(rs.next())  flag = true;
       if (flag)
          {
           out.println("�Ȥ�{�Ҧ��\!!");
           out.println("  �w����{���t��");
           out.println("<p></P>");
          }
       else
          res.sendRedirect("http://163.15.40.242:8080/examples/CustomerOpt.html");
      }
    catch (SQLException e)
      {
        e.getMessage();
      }    

     out.println("<html><head><title>C_Authority</title></head><body>");
    
     out.print("<li><p><a href = ");
     out.print("http://163.15.40.242:8080/examples/Deposit.html");
     out.print(">�s�ھާ@</a></p></li>");

     out.print("<li><p><a href = ");
     out.print("http://163.15.40.242:8080/examples/Withdraw.html");
     out.print(">���ھާ@</a></p></li>");

     out.print("<li><p><a href = ");
     out.print("http://163.15.40.242:8080/examples/Transfer.html");
     out.print(">��b�ާ@</a></p></li>");

     out.print("<li><p><a href = ");
     out.print("http://163.15.40.242:8080/examples/QueryBalance.html");
     out.print(">�d�߾ާ@</a></p></li>");

     out.println("</body></html>");
     out.close();
   }

  public void destroy()
    {
    try
      {
       if (con != null) con.close();
      }
    catch (SQLException ignored) { }
    }
 
  public synchronized void doPost(HttpServletRequest req,
                                  HttpServletResponse res)
         throws ServletException, IOException
    {
    doGet(req, res);
    }
 }