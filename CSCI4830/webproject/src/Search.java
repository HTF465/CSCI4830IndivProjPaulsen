import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datamodel.Contact;
import util.Info;
import util.UtilDB;

@WebServlet("/Search")
public class Search extends HttpServlet implements Info {
	private static final long serialVersionUID = 1L;

	public Search() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = request.getParameter("keyword").trim();

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

		List<Contact> listEmployees = null;
		if (keyword != null && !keyword.isEmpty()) {
			listEmployees = UtilDB.listContacts(keyword);
		} else {
			listEmployees = UtilDB.listContacts();
		}
		display(listEmployees, out);
		out.println("</ul>");
		out.println("<a href=\"/webproject/insert.html\">Create Contact</a> <br>");
		out.println("<a href=\"/webproject/edit.html\">Update Contact</a> <br>");
		out.println("</body></html>");
	}

	void display(List<Contact> listEmployees, PrintWriter out) {
		for (Contact contact : listEmployees) {
			if (contact.getHidden() == 0)
			{
				System.out.println("[DBG] " + contact.toString());
				out.println("<li>" + contact.toString() + "</li>");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
