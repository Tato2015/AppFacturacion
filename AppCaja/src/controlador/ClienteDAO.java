package controlador;

import bd.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.Cliente;

public class ClienteDAO extends ConexionBD{
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    /*
     public void registrar(Cliente cliente) throws ClassNotFoundException, SQLException {

        try {
            this.conexion();
            String query = "INSERT INTO cliente(nombre,apellido_paterno,direccion,fecha_nacimiento,telefono,email) values (?,?)";
            PreparedStatement ps = this.con.prepareStatement(query);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getDescripcion());
            ps.executeUpdate();
        } clich (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            this.cerrarConexion();
        }
    }
    */
    
    public List<Cliente> listar() throws ClassNotFoundException, SQLException, ParseException {
        List<Cliente> lista;
        ResultSet rs;

        try {
            this.conexion();
            String query = "SELECT id_cliente,nombre,apellido_paterno,direccion,fecha_nacimiento,telefono,email FROM cliente";
            PreparedStatement ps = this.con.prepareCall(query);
            rs = ps.executeQuery();
            lista = new ArrayList();

            while (rs.next()) {
                Cliente cli = new Cliente();
                Date fechaN = sdf.parse(sdf.format(rs.getDate("fecha_nacimiento")));
                cli.setId(rs.getInt("id_cliente"));
                cli.setNombre(rs.getString("nombre"));
                cli.setApellidoPaterno(rs.getString("apellido_paterno"));
                cli.setDireccion(rs.getString("direccion"));
                // La fecha que se obtiene de mysql presenta el formato : yyyy/MM/dd
                cli.setFechaNacimiento(fechaN);
                cli.setTelefono(rs.getString("telefono"));
                cli.setEmail(rs.getString("email"));
                lista.add(cli);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }

        return lista;

    }
    /*
    public void actualizar(Cliente cliente) throws ClassNotFoundException, SQLException
    {
        this.conexion();
        try {
            String query = "UPDATE cliente SET nombre=?,descripcion=? where id_cliente=?";
            PreparedStatement ps = this.con.prepareStatement(query);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getDescripcion());
            ps.setInt(3,cliente.getId());
            ps.executeUpdate();            
        } clich (SQLException e) {
            throw e;
        }finally{
        this.cerrarConexion();
        }
    
    }
    
    public void eliminar(int id) throws ClassNotFoundException, SQLException
    {
        this.conexion();
        try {
            String query="DELETE FROM cliente WHERE id_cliente = ?";
            PreparedStatement ps = this.con.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } clich (SQLException e) {
            throw e;
        }finally{
            this.cerrarConexion();
        }
    */
    public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {
        ClienteDAO cd = new ClienteDAO();
        System.out.println("Lista : "+ cd.listar());
    }
}
