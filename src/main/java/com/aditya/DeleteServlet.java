package com.aditya;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aditya.DAO.SchoolDAO;
import com.mysql.cj.*;

public class DeleteServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int input = Integer.parseInt(req.getParameter("id"));
		
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		
		SchoolDAO dao = SchoolDAO.getInstance();
		int result = dao.Delete(input);
		
		if(result != 0) {
			pw.write("<h2>Record Deleted!</h2>");
		} else {
			pw.write("<h2>Failed</h2>");
		}
        pw.close();
	}

}
