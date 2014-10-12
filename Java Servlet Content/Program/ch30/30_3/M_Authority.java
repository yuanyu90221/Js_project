import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class M_Authority extends HttpServlet
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

    String userStr = req.getParameter("user");
    String pwdStr = req.getParameter("pwd");

    String sql="SELECT * FROM Managers WHERE 姓名='" +
               userStr + "'AND 密碼='" + pwdStr +"';" ;

    HttpSession session = req.getSession();
    session.setAttribute("M_Authroity", "true");

    try
      {
       Statement statement = con.createStatement();
       ResultSet rs = statement.executeQuery(sql);
       boolean flag = false;
 
       while(rs.next())  flag = true;
       if (flag)
          {
           out.println("管理員認證成功!!");
           out.println(userStr + "  歡迎光臨本系統");
           out.println("<p></P>");
          }
       else
          res.sendRedirect("http://163.15.40.242:8080/examples/ManagerOpt.html");
      }
    catch (SQLException e)
      {
        e.getMessage();
      }    

     out.println("<html><head><title>M_Authority</title></head><body>");
    
     out.print("<li><p><a href = ");
     out.print("http://163.15.40.242:8080/examples/InsertCustomer.html");
     out.print(">輸入客戶基本資料</a></p></li>");

     out.print("<li><p><a href = ");
     out.print("http://163.15.40.242:8080/examples/InsertAccount.html");
     out.print(">輸入開戶存褶資料</a></p></li>");

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