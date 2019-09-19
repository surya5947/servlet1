import  java.sql.*;
import  javax.sql.*;
import  java.io.*;
import  javax.servlet.*;
import  javax.servlet.http.*;
import  java.util.*;

public class reportservlet  extends  HttpServlet
{
public void doPost(HttpServletRequest  req,HttpServletResponse  res)throws IOException,ServletException
{
try
{
res.setContentType("text/html");
PrintWriter  out=res.getWriter();

try
{
Class.forName("com.mysql.jdbc.Driver");
String jdbcurl="jdbc:mysql://localhost:3306/surya";//port no:3306 dbname:surya
String username="root";
String password="surya1045";
Connection connection=null;

connection= DriverManager.getConnection(jdbcurl,username,password);
Statement stmt=connection.createStatement();

String z=req.getParameter("dept");
String  sql="select * from student where dept='"+z+"'";
out.println("<h1> STUDENT DETAILS....</h1>");
ResultSet  rs=stmt.executeQuery(sql);
out.println("<table border='2'>");
out.println("<tr>");
out.println("<th>Regno</th>");
out.println("<th>Dept</th>");
out.println("</tr>");

while(rs.next())
{
String regno=rs.getString("regno");
String dept=rs.getString("dept");
out.println("<tr>");
out.println("<td>"+regno+"</td>");
out.println("<td>"+dept+"</td>");
out.println("</tr>");
}
out.println("</table>");

}
catch(ClassNotFoundException  cnfe)
{
out.println("class not found");
}
}
catch(SQLException e)
{
throw new RuntimeException("cannot connect to database!",e);
}
}
}


