 package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.daoImpl.webDaoImpl;
import com.pojo.web;

@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {

	web w = new web();
	webDaoImpl wdi = new webDaoImpl();
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();

		String action=request.getParameter("action");

		if(action!=null && action.equals("delete")) {
			String email=request.getParameter("email");
			boolean b=wdi.deletetweb(email);
			if(b) {
				response.sendRedirect("MyServlet");
			}
		}else if(action!=null && action.equals("edit")) {
			String email=request.getParameter("email");

			web w=wdi.getUserByEmail(email);
			session.setAttribute("w",w);

			response.sendRedirect("updateUser.jsp");
		}
		else {
			List<web> wl = wdi.getUserList();
			session.setAttribute("wlist",wl);
			response.sendRedirect("userList.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hi");

		String action=request.getParameter("action");

		String name = request.getParameter("name");
		String contact = request.getParameter("contact");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");

		w.setName(name);
		w.setContact(contact);
		w.setEmail(email);
		w.setPass(pass);

		System.out.println(w);
		if(action!=null && action.equals("addUser")) {
			boolean i = wdi.insertweb(w);
			if(i)
			{
				System.out.println("Success");
			}
			else {
				System.out.println("Not Success");
			}
		}else if(action!=null && action.equals("updateUser")) {
			
			boolean b=wdi.updateweb(w);
			if(b) {
				response.sendRedirect("MyServlet");

			}
		}
	}

}
