package com.servlet;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.classes.ControllStructure;
import com.classes.Coupling;
import com.classes.Inheritance;
import com.classes.Size;
import com.classes.SizeVariable;
import com.classes.variable;
import com.model.InheritanceModel;


/**
 * Servlet implementation class codeServlet
 */
@WebServlet("/codeServlet")
public class codeServlet extends HttpServlet {
	
	static String code;
	private static final long serialVersionUID = 1L;
       

    public codeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 code =  request.getParameter("code");
	
		String button = request.getParameter("button");
		
		if(button.equals("Size")) {
			
			request.getRequestDispatcher("WeightSize.jsp").forward(request, response);
		}
			
		if(button.equals("Variable")) {
	
			request.getRequestDispatcher("WeightVariable.jsp").forward(request, response);
		}
		
		
		if(button.equals("ControlStructure")) {
			
			request.getRequestDispatcher("WeightControlStructure.jsp").forward(request, response);
		}
		
	
		if(button.equals("All-Factors")) {
			
			request.getRequestDispatcher("AllFactors.jsp").forward(request, response);
		}
	     
		
		doGet(request, response);
	}
	public String returnCode() {
		//System.out.println(code);
		return code;
	}
}