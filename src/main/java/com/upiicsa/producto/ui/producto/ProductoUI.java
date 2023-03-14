package com.upiicsa.producto.ui.producto;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.upiicsa.producto.bs.productobs.ProductoBS;
import com.upiicsa.producto.producto.Producto;

/**
 * Servlet implementation class Producto
 */
@WebServlet(urlPatterns = "/producto")
public class ProductoUI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductoUI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 PrintWriter out = response.getWriter();
	        out.println("<html>");
	        out.println("<body>");
	        out.println("<h1>Corriendo un servlet");
	        out.println("</body>");
	        out.println("</html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Producto producto= new Producto();
		producto.setNombre(request.getParameter("nombre"));
		producto.setDescripcion(request.getParameter("descripcion"));
		int cantidad=Integer.parseInt(request.getParameter("cantidad"));
		producto.setCantidad(cantidad);
		int precio=Integer.parseInt(request.getParameter("precio"));
		producto.setPrecio(precio);
	
		ProductoBS productoBs= new ProductoBS();
		int registoInsertado=productoBs.saveProducto(producto);
		response.sendRedirect("index.jsp");
	}

}
