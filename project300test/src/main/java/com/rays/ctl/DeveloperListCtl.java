package com.rays.ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.dto.DeveloperDTO;
import com.rays.model.DeveloperModel;

@WebServlet("/DeveloperListCtl")
public class DeveloperListCtl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DeveloperDTO dto = new DeveloperDTO();
		DeveloperModel model = new DeveloperModel();
		List list = model.search(dto);
		req.setAttribute("List", list);
		RequestDispatcher rd = req.getRequestDispatcher("DeveloperListView.jsp");
		rd.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op = req.getParameter("operation");
		DeveloperDTO dto = new DeveloperDTO();
		DeveloperModel model = new DeveloperModel();
		String[] ids = req.getParameterValues("ids");
		if (op.equalsIgnoreCase("delete")) {
			for (String id : ids) {
				dto.setId(Integer.parseInt(id));
				model.delete(dto);
				req.setAttribute("msg", "Developer Sucessfully Deleted");

			}

		}
		List list = model.search(dto);
		req.setAttribute("List", list);
		RequestDispatcher rd = req.getRequestDispatcher("DeveloperListView.jsp");
		rd.forward(req, resp);
	}

}
