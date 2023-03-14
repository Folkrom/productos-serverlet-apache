package com.upiicsa.producto.bs.productobs;

import java.util.ArrayList;
import java.util.List;


import com.upiicsa.producto.bd.productoBD.ProductoBd;
import com.upiicsa.producto.producto.Producto;


public class ProductoBS {
	
	public int saveProducto(Producto producto) {
	    int registrosInsertados=-1;
	    ProductoBd productoBd= new ProductoBd();
	    registrosInsertados=productoBd.saveProduct(producto);
	    return registrosInsertados; 
	}
	
	public List<Producto> findAll(){
		List<Producto> listaProducto=new ArrayList<> ();
		ProductoBd productoBd= new ProductoBd();
		listaProducto=productoBd.findaAll();
		return listaProducto;
	}
	
	public Producto findById(int id) {
		Producto producto=null;
		ProductoBd productoBd=new ProductoBd();
		producto=productoBd.findById(id);
		return producto;
	}
	
	public static void main(String[] args) {
        int registrosInsertados=-1;
        Producto producto=new Producto();
        Producto producto2=null;
        ProductoBd productoBD=new ProductoBd();
        producto.setNombre("Nutrileche");
        producto.setDescripcion("Leche Entera");
        producto.setCantidad(24);
        producto.setPrecio(18);
        
        
        registrosInsertados=productoBD.saveProduct(producto);
        //persona2=personaBD.findById(1);
        //System.out.println(persona2);
        List<Producto> lista=productoBD.findaAll();
        for(Producto product:lista) {
            System.out.println(product);
        }
        
    }
}
