/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uv.org.practica4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kali
 */
public class DAOEmpleado implements IDAOGeneral<Empleado, Long>{
    
    private Connection con;
    
    @Override
    public Empleado create(Empleado p) {
        ConexionDB cx = ConexionDB.getInstance();
        TransacciónDB tdb = new TransacciónDB<Empleado>(p) {
               @Override
            public boolean execute(Connection con) {
                try {
                String sql = "insert into ejemplo (clave, nombre, direccion, telefono) values "
                    + "(?,?,?,?)";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setLong(1, p.getClave());
                pst.setString(2, p.getNombre());
                pst.setString(4, p.getDireccion());
                pst.setString(2, p.getDireccion());
                pst.execute();
                return true;
                }
                catch (SQLException ex){
                   Logger.getLogger(DAOEmpleado.class.getName()).log(Level.INFO, "Exito...");
                   return false;
                }       
            }
        };
        
        boolean res = cx.execute(tdb);
        if (res)
            Logger.getLogger(DAOEmpleado.class.getName()).log(Level.INFO, "Se guardo...");
        else
            Logger.getLogger(DAOEmpleado.class.getName()).log(Level.INFO, "Error...");
        
        return p;
    }

    @Override
    public boolean delete(Long id) {
        try {
            Connection con = null;
            String sql = "DELETE FROM jugadores WHERE (id = ?);";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public Empleado update(Empleado p, Long id) {
        try {
            String sql = "select * from ejemplo where clave= ?";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            boolean check = false;
            
            while (rs.next()) {
                check = true;
                
            }
            if (check == true) {
                try {
                    String sqlupdate  = "update employee set emp_name=?, "
                            + " emp_address= ? where emp_id = ?";
                    PreparedStatement ps = con.prepareStatement(sqlupdate);
                    ps.setString(1, p.getNombre());
                    ps.setString(2, p.getDireccion());
                    ps.setString(3, p.getTelefono());
                    ps.executeUpdate();
                } catch (SQLException ex) {
                    Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else
                return null;
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    @Override
    public List<Empleado> findAll() {
        return null;
    }

    @Override
    public Empleado findById(Long id) {
        return null;
    }
    
}
