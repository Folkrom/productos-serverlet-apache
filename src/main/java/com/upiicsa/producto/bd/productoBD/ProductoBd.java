package com.upiicsa.producto.bd.productoBD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.upiicsa.producto.bd.BaseDatos;
import com.upiicsa.producto.producto.Producto;

public class ProductoBd extends BaseDatos{
	public int saveProduct(Producto producto) {
        int registrosInsertados = -1;
        String query = "INSERT INTO producto(nombre, descripcion, cantidad, precio) VALUES (?,?,?,?)";
        try {
            conectar();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getDescripcion());
            ps.setInt(3, producto.getCantidad());
            ps.setInt(4, producto.getPrecio());
           
            // ps.setDate(3,
            // java.sql.Date.valueOf(persona.getFechaNacimiento().toString()));
            registrosInsertados = ps.executeUpdate();
            System.out.println("----Inserto---- "+registrosInsertados);
            ps.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error de tipo SQL");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error generico");
        }
        return registrosInsertados;
    }

    public Producto findById(int id) {
        Producto producto = null;
        String query = "SELECT * FROM producto where idCliente=?";
        try {
            conectar();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                producto = new Producto();
                producto.setIdProducto(rs.getInt(rs.getInt("idCliente")));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setCantidad(rs.getInt(rs.getInt("cantidad")));
                producto.setPrecio(rs.getInt(rs.getInt("precio")));
              
             
                ps.close();
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Se genero un error de tipo SQL");
            e.printStackTrace();
        }catch(Exception e) {
            System.out.println("Se genero un error generico");
            e.printStackTrace();
        }
        return producto;
    }
    public int updateProduct(Producto producto) {
        int registrosActualizados=-1;
        String query="UPDATE producto SET nombre=?, descripcion=?, cantidad=?, precio=? where idCliente =?";
        try {
            conectar();
            PreparedStatement ps=conn.prepareStatement(query);
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getDescripcion());
            ps.setInt(3,producto.getCantidad());
            ps.setInt(4,producto.getPrecio());
           
            ps.setInt(5,producto.getIdProducto());
            registrosActualizados=ps.executeUpdate();
            ps.close();
            conn.close();
        }catch (SQLException e) {
            System.out.println("Se genero un error de tipo SQL");
            e.printStackTrace();
        }catch(Exception e) {
            System.out.println("Se genero un error generico");
            e.printStackTrace();
        }
        return registrosActualizados;
    }
    public int deletePerson(int idProducto) {
        int registrosActualizados=-1;
        String query="DELETE FROM producto WHERE idCliente=?";
        try {
            conectar();
            PreparedStatement ps=conn.prepareStatement(query);
            ps.setInt(1, idProducto);
            registrosActualizados=ps.executeUpdate();
            ps.close();
            conn.close();
        }catch (SQLException e) {
            System.out.println("Se genero un error de tipo SQL");
            e.printStackTrace();
        }catch(Exception e) {
            System.out.println("Se genero un error generico");
            e.printStackTrace();
        }
        return registrosActualizados;
    }
    
    public List<Producto> findaAll(){
        List<Producto> listaProductos=new ArrayList<>();
        BaseDatos bd=new BaseDatos();
        Statement stmt=null;
        
        try {
            conectar();
            stmt=conn.createStatement();
            String query="select * from producto";
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next()) {
                Producto producto=new Producto();
                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setCantidad(rs.getInt("cantidad"));
                producto.setPrecio(rs.getInt("precio"));
                
                listaProductos.add(producto);
            }
            rs.close();
            stmt.close();
            conn.close();
        }catch (SQLException e) {
            System.out.println("Se genero un error de tipo SQL");
            e.printStackTrace();
        }catch(Exception e) {
            System.out.println("Se genero un error generico");
        }
        return listaProductos;
    }
    

}
