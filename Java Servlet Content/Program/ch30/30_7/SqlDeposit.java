import java.sql.*;
public class SqlDeposit
  {
   private Connection con;
   private String sql;
   public SqlDeposit(Connection con, String sql)
     {
      this.con = con;
      this.sql = sql;
     }
    public String toString()
    {
      boolean flag = false;
      StringBuffer sb = new StringBuffer();
      try
        {
          Statement statement = con.createStatement();
          con.setAutoCommit(false);
          statement.execute(sql);
          con.commit();
          con.setAutoCommit(true);
          sb.append("Transaction works successfully!!");

        }
      catch (SQLException e)
       {
         sb.append("</TABLE><H1>SQL Exception Error:</H1> " +
                            e.getMessage());
        }
      return sb.toString();
    }
  }
