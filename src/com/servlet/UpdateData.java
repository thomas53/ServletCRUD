package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.DAO.DaoUser;
import com.data.DataUser;

/**
 * Servlet implementation class UpdateData
 */
@WebServlet("/UpdateData")
public class UpdateData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get data from db
		DaoUser du = new DaoUser();
		DataUser user = du.getDataUserById(Integer.parseInt(request.getParameter("id")));
		
		
		// send data to servlet
		request.setAttribute("id", user.getId());
		request.setAttribute("username", user.getUsername());
		request.setAttribute("nama", user.getNama());
		request.setAttribute("alamat", user.getAlamat());
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/UpdatePage.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
    	
		if(request.getParameter("batal")==null){
			// Ambil data dari form    	
	    	DataUser dataUser = new DataUser();
	    	dataUser.setUsername(request.getParameter("username"));
	    	dataUser.setNama(request.getParameter("nama"));
	    	dataUser.setAlamat(request.getParameter("alamat"));
	    	dataUser.setId(Integer.parseInt(request.getParameter("id")));
	    	
	    	// simpan data
			DaoUser daoUser = new DaoUser();
			
	    	if(daoUser.updateData(dataUser)){
	    		response.sendRedirect("index.jsp");
	    	}else{
	    		out.print("gagal");
	    	}
		}else{
			response.sendRedirect("index.jsp");
		}
		
		
	}

}
