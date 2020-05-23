package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.classes.FileUpload;


@WebServlet("/FileSelectServlet")
public class FileSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public FileSelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		FileUpload fu = new FileUpload();
		String button = request.getParameter("button");
		String code = fu.getCode(button);
		request.setAttribute("tb", code);
		
		request.getRequestDispatcher("fileUpload.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
