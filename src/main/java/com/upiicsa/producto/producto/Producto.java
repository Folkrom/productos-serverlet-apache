package com.upiicsa.producto.producto;


public class Producto {
	private int IdProducto;
	 private String Nombre;
	 private String Descripcion;
	 private int Cantidad;
	 private int Precio;
	 
	public int getIdProducto() {
		return IdProducto;
	}
	public void setIdProducto(int idProducto) {
		IdProducto = idProducto;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public int getCantidad() {
		return Cantidad;
	}
	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}
	public int getPrecio() {
		return Precio;
	}
	public void setPrecio(int precio) {
		Precio = precio;
	}
	 @Override
	    public String toString() {
	        return  "idProducto: "+ this.IdProducto+ "\n"+
	                "Nombre: "+this.Nombre +"\n"+
	                "Descripción: "+this.Descripcion +"\n"+
	                "Cantidad: "+this.Cantidad +"\n"+
	                "Precio: "+this.Precio;
	    }
} 
