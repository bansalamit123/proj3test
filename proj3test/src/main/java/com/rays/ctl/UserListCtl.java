package com.rays.ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.dto.UserDTO;
import com.rays.model.UserModel;

@WebServlet("/UserListCtl")
public class UserListCtl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int pageNo = 1;
		int pageSize = 10;
		UserModel model = new UserModel();
		UserDTO dto = new UserDTO();
		List list = model.search(dto, pageNo, pageSize);
		req.setAttribute("List", list);
		RequestDispatcher rd = req.getRequestDispatcher("UserListView.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int pageNo = 1;
		int pageSize = 10;
		String op = req.getParameter("operation");
		String[] ids = req.getParameterValues("ids");
		UserModel model = new UserModel();
		UserDTO dto = new UserDTO();
		if (op.equalsIgnoreCase("delete")) {
			for (String id : ids) {
				System.out.println(id);
				dto.setId(Integer.parseInt(id));
				model.delete(dto);
				req.setAttribute("msg", "User is Successfully Deleted");
			}
		}
		List list = model.search(dto, pageNo, pageSize);
		req.setAttribute("List", list);
		RequestDispatcher rd = req.getRequestDispatcher("UserListView.jsp");
		rd.forward(req, resp);
	}

}
