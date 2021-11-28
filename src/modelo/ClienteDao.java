package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author MauwiA3
 * @version 26-11-2021
 */
public class ClienteDao {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    //Registrar cliente
    public boolean RegistrarCliente(Cliente cl) {
        String sql = "INSERT INTO clientes (rut, nombre, telefono, direccion, razon) VALUES (?,?,?,?,?)";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cl.getRut());
            ps.setString(2, cl.getNombre());
            ps.setInt(3, cl.getTelefono());
            ps.setString(4, cl.getDireccion());
            ps.setString(5, cl.getRazon());
            ps.execute();
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;

        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }

    //Listar cliente
    public List ListarCliente() {
        List<Cliente> ListaCl = new ArrayList();
        String sql = "SELECT * FROM clientes";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Cliente cl = new Cliente();
                cl.setId(rs.getInt("id"));
                cl.setRut(rs.getInt("rut"));
                cl.setNombre(rs.getString("nombre"));
                cl.setTelefono(rs.getInt("telefono"));
                cl.setDireccion(rs.getString("direccion"));
                cl.setRazon(rs.getString("razon"));
                ListaCl.add(cl);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ListaCl;
    }
    
    //Eliminar clientes mediante id
    public boolean EliminarCliente(int id) {
        String sql = "DELETE FROM clientes WHERE id = ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;           
        } finally {
            
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
    }
    
    //Modificar cliente
    public boolean ModificarCliente(Cliente cl) {
        String sql = "UPDATE clientes SET rut=?, nombre=?, telefono=?, direccion=?, razon=? WHERE id=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, cl.getRut());
            ps.setString(2, cl.getNombre());
            ps.setInt(3, cl.getTelefono());
            ps.setString(4, cl.getDireccion());
            ps.setString(5, cl.getRazon());
            ps.setInt(6, cl.getId());
            ps.execute();
            return true;
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }
//
//    //Buscar cliente por rut 
//    public Cliente Buscarcliente(int rut) {
//        Cliente cl = new Cliente();
//        String sql = "SELECT * FROM clientes WHERE rut = ?";
//
//        try {
//            con = cn.getConnection();
//            ps = con.prepareStatement(sql);
//            ps.setInt(1, rut);
//            rs = ps.executeQuery();
//            if (rs.next()) {
//                cl.setId(rs.getInt("id"));
//                cl.setNombre(rs.getString("nombre"));
//                cl.setTelefono(rs.getString("telefono"));
//                cl.setDireccion(rs.getString("direccion"));
//            }
//        } catch (SQLException e) {
//            System.out.println(e.toString());
//        }
//        return cl;
//    }

}
