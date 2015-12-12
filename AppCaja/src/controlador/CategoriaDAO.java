package controlador;

import bd.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Categoria;

public class CategoriaDAO extends ConexionBD {

    public void registrar(Categoria categoria) throws ClassNotFoundException, SQLException {

        try {
            this.conexion();
            String query = "INSERT INTO categoria(nombre,descripcion) values (?,?)";
            PreparedStatement ps = this.con.prepareStatement(query);
            ps.setString(1, categoria.getNombre());
            ps.setString(2, categoria.getDescripcion());
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            this.cerrarConexion();
        }
    }

    public List<Categoria> listar() throws ClassNotFoundException, SQLException {
        List<Categoria> lista;
        ResultSet rs;

        try {
            this.conexion();
            String query = "SELECT id_categoria,nombre,descripcion FROM categoria";
            PreparedStatement ps = this.con.prepareCall(query);
            rs = ps.executeQuery();
            lista = new ArrayList();

            while (rs.next()) {
                Categoria cat = new Categoria();
                cat.setId(rs.getInt("id_categoria"));
                cat.setNombre(rs.getString("nombre"));
                cat.setDescripcion(rs.getString("descripcion"));
                lista.add(cat);
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }

        return lista;

    }
    
    public void actualizar(Categoria categoria) throws ClassNotFoundException, SQLException
    {
        this.conexion();
        try {
            String query = "UPDATE categoria SET nombre=?,descripcion=? where id_categoria=?";
            PreparedStatement ps = this.con.prepareStatement(query);
            ps.setString(1, categoria.getNombre());
            ps.setString(2, categoria.getDescripcion());
            ps.setInt(3,categoria.getId());
            ps.executeUpdate();            
        } catch (SQLException e) {
            throw e;
        }finally{
        this.cerrarConexion();
        }
    
    }
    
    public void eliminar(int id) throws ClassNotFoundException, SQLException
    {
        this.conexion();
        try {
            String query="DELETE FROM categoria WHERE id_categoria = ?";
            PreparedStatement ps = this.con.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }finally{
            this.cerrarConexion();
        }
    
    }

    //Método main para realizar pruebas de métodos CRUD.
    /*INSERTAR
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
     CategoriaDAO c = new CategoriaDAO();
     Categoria ca = new Categoria();
     ca.setNombre("TECNO");
     ca.setDescripcion("TECNOLOGIA");        
     c.registrar(ca);
        
     }
     */
    
    /*LISTAR
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        CategoriaDAO c = new CategoriaDAO();
        System.out.println("Lista:"+c.listar());
    }
    */
    
    /*ACTUALIZAR
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
     CategoriaDAO c = new CategoriaDAO();
     Categoria ca = new Categoria();
     ca.setNombre("tecno");
     ca.setDescripcion("tecnologia");        
     ca.setId(1);
     c.actualizar(ca);
    }
    
    */
    
    /*ELIMINAR
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
         CategoriaDAO c = new CategoriaDAO();                  
         c.eliminar(1);
    }
    */
}
