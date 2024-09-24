package com.aditya;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aditya.DAO.SchoolDAO;
import com.mysql.cj.*;

import entity.school;

public class SelectServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		List<school> list = new ArrayList<>();
		
		SchoolDAO dao = SchoolDAO.getInstance();
		list = dao.Select();
		
		req.setAttribute( "list", list );
	    RequestDispatcher rd =  req.getRequestDispatcher("display.jsp");
        rd.forward(req, res);
        pw.close();
	}
}
