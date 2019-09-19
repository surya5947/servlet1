import  java.sql.*;
import  javax.sql.*;
import  java.io.*;
import  javax.servlet.*;
import  javax.servlet.http.*;
import  java.util.*;

public class formservlet  extends  HttpServlet
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
String jdbcurl="jdbc:mysql://localhost:3306/surya";
String username="root";
String password="surya1045";
Connection connection=null;

connection= DriverManager.getConnection(jdbcurl,username,password);
Statement stmt=connection.createStatement();

String x=req.getParameter("sname");
String y=req.getParameter("dept");
String  sql="insert into student values ('"+x+"','"+y+"')";
stmt.executeUpdate(sql);

out.println("<h1> Record successfull added</h1>");
RequestDispatcher rd=req.getRequestDispatcher("/student.html");
rd.include(req,res);

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


	