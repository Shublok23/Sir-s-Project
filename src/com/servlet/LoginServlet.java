package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.daoImpl.LoginDao;
import com.pojo.web;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	web w=new web();
	LoginDao ld=new LoginDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		session.invalidate();
		response.sendRedirect("index.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String uname=request.getParameter("uname");
		String pass=request.getParameter("pass");

		if(uname!=null && uname.equals("admin") && pass.equals("123")) {

			session.setAttribute("admin",uname);
			response.sendRedirect("index.jsp");
			
		}else {

			web b=ld.getUserLogin(uname, pass);
			System.out.println(b);
			if(b.getEmail()!=null && b.getEmail().equals(uname) && b.getPass().equals(pass)) {
				session.setAttribute("user",uname);
				response.sendRedirect("index.jsp");

			} else {
				
				request.setAttribute("lmsg", "Please Enter Valid UserName And Password");
				RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
				rd.include(request, response);
			}

		}
	}

}
