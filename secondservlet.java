import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  
public class secondservlet extends HttpServlet {  
public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException  
     try
     { 
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
          
        
        String n=request.getParameter("uname");  
        out.print("Hello "+n);  
  
        out.close();  
      }
      catch(ClassNotFoundException  cnfe)
{
out.println("class not found");
}
 
    }  
}  