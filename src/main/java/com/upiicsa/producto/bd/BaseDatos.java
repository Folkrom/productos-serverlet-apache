package com.upiicsa.producto.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.upiicsa.producto.bd.BaseDatos;
import com.upiicsa.producto.producto.Producto;

public class BaseDatos {
	protected Connection conn=null;
    public int conectar() {
        int error=-1;
        try {
            Class.forName("org.postgresql.Driver");
            String url="jdbc:postgresql://localhost/tienda";
            Properties props=new Properties();
            props.setProperty("user", "postgres");
            props.setProperty("password","postgres");
            conn=DriverManager.getConnection(url, props);
            error=1;
            System.out.println("-------->Conectado a la BD");
        }catch (SQLException e) {
            System.out.println("-------->Se genero un error de tipo SQL y no se pudo conectar a la BD");
            e.printStackTrace();
        }catch (Exception e) {
            System.out.println("-------->Se genero un error y no se pudo conectar a la BD");
            e.printStackTrace();
        }
        return error;
    }
    
    public static void main(String[] args) {
        BaseDatos bd=new BaseDatos();
        Statement stmt=null;
        ArrayList<Producto> listaProductos=new ArrayList<>();
        try {
            bd.conectar();
            stmt=bd.conn.createStatement();
            String query="select * from producto";
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next()) {
                Producto producto=new Producto();
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setCantidad(rs.getInt("cantidad"));
                producto.setPrecio(rs.getInt("precio"));
                listaProductos.add(producto);
            }
            for(Producto pro:listaProductos ) {
                System.out.println("Nombre: "+pro.getNombre());
                System.out.println("Descripcion: " +pro.getDescripcion());
                System.out.println("Cantidad: " +pro.getCantidad());
                System.out.println("Precio: " +pro.getPrecio());
                System.out.println("---------------------------------------------------");
            }
            rs.close();
            stmt.close();
            bd.conn.close();
        }catch (SQLException e) {
            System.out.println("Se genero un error de tipo SQL");
            e.printStackTrace();
        }catch(Exception e) {
            System.out.println("Se genero un error generico");
        }
        
    }
    
}
