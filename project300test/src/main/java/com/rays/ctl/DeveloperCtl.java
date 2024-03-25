package com.rays.ctl;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.dto.DeveloperDTO;
import com.rays.model.DeveloperModel;

@WebServlet("/DeveloperCtl")
public class DeveloperCtl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		DeveloperModel model = new DeveloperModel();
		if (id != null) {
			DeveloperDTO dto = model.findByPk(Integer.parseInt(id));
			req.setAttribute("dto", dto);

		}
		RequestDispatcher rd = req.getRequestDispatcher("DeveloperView.jsp");
		rd.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DeveloperDTO dto = new DeveloperDTO();
		DeveloperModel model = new DeveloperModel();
		String op = req.getParameter("operation");
		System.out.println(op);
		dto.setDob(new Date());
		String id = req.getParameter("id");

		dto.setId(Integer.parseInt(id));

		dto.setDepartment(req.getParameter("department"));
		dto.setName(req.getParameter("name"));
		dto.setProject(req.getParameter("project"));
		dto.setStatus(req.getParameter("status"));
		if (op.equalsIgnoreCase("update") || op.equalsIgnoreCase("save")) {
			System.out.println("update");
			if (dto.getId() > 0) {
				System.out.println("idddd");

				model.update(dto);
				req.setAttribute("dto", dto);
				req.setAttribute("msg", "Developer Sucessfully Updated");

			}

			else {
				model.add(dto);
				req.setAttribute("msg", "Developer Sucessfully Added");
			}
			RequestDispatcher rd = req.getRequestDispatcher("DeveloperView.jsp");
			rd.forward(req, resp);

		} else if (op.equalsIgnoreCase("cancel")) {
			resp.sendRedirect("DeveloperListCtl");

		}

	}

}
