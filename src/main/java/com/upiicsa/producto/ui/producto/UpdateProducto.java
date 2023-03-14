package com.upiicsa.producto.ui.producto;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.upiicsa.producto.bs.productobs.ProductoBS;
import com.upiicsa.producto.producto.Producto;

/**
 * Servlet implementation class UpdateProducto
 */
public class UpdateProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idPersona=Integer.parseInt(request.getParameter("idProducto"));
		ProductoBS productoBs=new ProductoBS();
		Producto producto=null;
		producto=productoBs.findById(idPersona);
		request.setAttribute("producto",producto);
		RequestDispatcher rd=request.getRequestDispatcher("updateProducto.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
