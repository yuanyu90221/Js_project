import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Ex70_authority extends HttpServlet
 {
   private Connection con = null;
   public void init(ServletConfig config)  throws ServletException
     {
       try
         {
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           con = DriverManager.getConnection("jdbc:odbc:Bookch16"); 
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

    String sql="SELECT * FROM Manager WHERE 姓名='" +
               userStr + "'AND 密碼='" + pwdStr +"';" ;

    out.println("<html><head><title>Ex70</title></head><body>");
    out.println("This is the Sub Page of Ex70" + "<br>");
    out.println("" + "<br>");

    try
      {
       Statement statement = con.createStatement();
       ResultSet rs = statement.executeQuery(sql);
       boolean flag = false;
 
       while(rs.next())  flag = true;
       if (flag)
          {
           out.println("認証成功!!");
           out.println(userStr + "  歡迎光臨本系統");
          }
       else
          {
           out.println("認証失敗!!");
          }
       
      }
    catch (SQLException e)
      {
        e.getMessage();
      }    

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