import java.sql.*;
public class SqlResult
  {
   private Connection con;
   private String sql;
   public SqlResult(Connection con, String sql)
     {
      this.con = con;
      this.sql = sql;
     }
    public String toString()
    {
      StringBuffer sb = new StringBuffer();
      try
        {
          Statement statement = con.createStatement();
          if (statement.execute(sql))
            {
              ResultSet rs = statement.getResultSet();
              ResultSetMetaData md = rs.getMetaData();
              int colCount = md.getColumnCount();
              sb.append("<TABLE CELLSPACING=10><TR>");
              for (int i = 1; i <= colCount; i++)
              sb.append("<TH>" + md.getColumnLabel(i));
              while (rs.next())
                {
                  sb.append("<TR>");
                  for (int i = 1; i <= colCount; i++)
                    {
                      sb.append("<TD>");
                      Object obj = rs.getObject(i);
                      if (obj != null)
                          sb.append(obj.toString());
                      else
                          sb.append("&nbsp;");
                    }
                }
              sb.append("</TABLE>\n");
            }
           else
              sb.append("<B>Update Count:</B> " +
                                 statement.getUpdateCount());
        }
      catch (SQLException e)
       {
         sb.append("</TABLE><H1>SQL Exception Error:</H1> " +
                            e.getMessage());
        }
      return sb.toString();
    }
  }
