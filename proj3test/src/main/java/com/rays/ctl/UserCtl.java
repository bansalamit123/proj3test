package com.rays.ctl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.dto.UserDTO;
import com.rays.model.UserModel;

@WebServlet("/UserCtl")
public class UserCtl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		String id=(req.getParameter("id"));
		 System.out.println(id);
		UserModel model = new UserModel();
		 if(id!=null) {
		     UserDTO dto=model.findByPk(Integer.parseInt(id));
		  req.setAttribute("dto",dto);
		 }
          RequestDispatcher rd = req.getRequestDispatcher("UserView.jsp");
			rd.forward(req, resp);
           }

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		UserDTO dto = new UserDTO();
		dto.setName(req.getParameter("name"));
		dto.setLoginId(req.getParameter("login"));
		dto.setPassword(req.getParameter("password"));
         dto.setDob(new Date());
         dto.setAddress(req.getParameter("address"));
		String op = req.getParameter("operation");
		int id = Integer.parseInt(req.getParameter("id"));
		dto.setId(id);
		UserModel model = new UserModel();
		if (op.equalsIgnoreCase("update")||op.equalsIgnoreCase("save")) {
			if (id > 0) {
				model.update(dto);
				req.setAttribute("dto", dto);
				req.setAttribute("msg", "User Sucessfully Updated");
				RequestDispatcher rd = req.getRequestDispatcher("UserView.jsp");
				rd.forward(req, resp);

			}
			else {
				model.add(dto);
				req.setAttribute("msg", "User Suceesfully Added");
				RequestDispatcher rd = req.getRequestDispatcher("UserView.jsp");
				rd.forward(req, resp);
			}
		} else if (op.equalsIgnoreCase("cancel")) {
			resp.sendRedirect("UserListCtl");

		}

	}

}
