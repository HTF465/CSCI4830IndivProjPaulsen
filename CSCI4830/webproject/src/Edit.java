import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Info;
import util.UtilDB;

@WebServlet("/Edit")
public class Edit extends HttpServlet implements Info {
   private static final long serialVersionUID = 1L;

   public Edit() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  int id = Integer.parseInt(request.getParameter("id"));
	  String fName = request.getParameter("fname").trim();
      String lName = request.getParameter("lname").trim();
      String number = request.getParameter("number").trim();
      String dName = request.getParameter("dname").trim();
      String email = request.getParameter("email").trim();
      String button = request.getParameter("hidden");
      int hidden = 0;
      
      if (button != null && button.equals("on"))
	  {
    	  hidden = 1;
	  }
      UtilDB.updateContacts(id, fName, lName, number, dName, email, hidden);

      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      String title = "Database Result";
      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">\n"; //
      out.println(docType + //
            "<html>\n" + //
            "<head><title>" + title + "</title></head>\n" + //
            "<body bgcolor=\"#f0f0f0\">\n" + //
            "<h1 align=\"center\">" + title + "</h1>\n");
      out.println("<ul>");
      out.println("<li> Contact Id: " + id);
      out.println("<li> First Name: " + fName);
      out.println("<li> Last Name: " + lName);
      out.println("<li> Phone Number: " + number);
      out.println("<li> Display Name: " + dName);
      out.println("<li> Email: " + email);
      out.println("</ul>");
      out.println("<a href=\"/webproject/search.html\">Search Data</a> <br>");
      out.println("<a href=\"/webproject/insert.html\">Create Contact</a> <br>");
      out.println("</body></html>");
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}
