package com.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conn.DBConnect;
import com.dao.StudentDAO;
@WebServlet("/delete")
public class delete extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id= Integer.parseInt(req.getParameter("id"));
		StudentDAO dao= new StudentDAO(DBConnect.getconn());
		boolean f= dao.deleteStudent(id);
		HttpSession session = req.getSession();
		if (f) {
			session.setAttribute("succMsg","Student Details Delete successfully..");
			resp.sendRedirect("index.jsp");
		//	System.out.println("student detailse submit successfully");
		}else {
			session.setAttribute("errorMsg","something Wrong on server...");
			resp.sendRedirect("index.jsp");
			//System.out.println("somethig wrong in server");
		}
	}
	

}
