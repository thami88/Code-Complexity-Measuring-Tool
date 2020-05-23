package com.weightServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.classes.ControllStructure;
import com.servlet.codeServlet;

/**
 * Servlet implementation class WeightControlStructureServlet
 */
@WebServlet("/WeightControlStructureServlet")
public class WeightControlStructureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WeightControlStructureServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String button = request.getParameter("submit");
		
		
		String weightIf =  request.getParameter("weightIf");
		String weightCase =  request.getParameter("weightCase");
		String weightFor =  request.getParameter("weightFor");
		
		if(button.equals("save")) {
		ControllStructure c = new ControllStructure();
		c.weights(Integer.parseInt(weightIf), Integer.parseInt(weightCase),Integer.parseInt(weightFor));
		
		
		
		codeServlet cs = new codeServlet();
		String code = cs.returnCode();

		c.setCode(code);
		String tb =	c.getTable();
		request.setAttribute("tb", tb);
		request.getRequestDispatcher("controlStructures.jsp").forward(request, response);
		
		
		}
		doGet(request, response);
	}


}
