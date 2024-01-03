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
import com.entity.Student;
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name= req.getParameter("name");
		String dob= req.getParameter("dob");
		String address= req.getParameter("address");
		String qualification= req.getParameter("qualification");
		String email= req.getParameter("email");
		
		Student student = new Student (name,dob,address,qualification,email);
		System.out.println(student);
		
		StudentDAO dao= new StudentDAO(DBConnect.getconn());
		HttpSession session = req.getSession();
		
		boolean f=dao.addstudent(student);
		if (f) {
			session.setAttribute("succMsg", "Student Details submit successfully..");
			resp.sendRedirect("add_student.jsp");
		//	System.out.println("student detailse submit successfully");
		}else {
			session.setAttribute("errorMsg","something Wrong on server...");
			//System.out.println("somethig wrong in server");
		}
		
	}

}
