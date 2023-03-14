package com.upiicsa.producto.ui.producto;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.upiicsa.producto.bs.productobs.ProductoBS;
import com.upiicsa.producto.producto.Producto;

/**
 * Servlet implementation class ListaProductos
 */
@WebServlet(urlPatterns="/listaProductos")
public class ListaProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaProductos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductoBS productoBs= new ProductoBS();
		List<Producto> listaProductos=productoBs.findAll();
		request.setAttribute("listaProductos", listaProductos);
		RequestDispatcher rd=request.getRequestDispatcher("listaproductos.jsp");
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
