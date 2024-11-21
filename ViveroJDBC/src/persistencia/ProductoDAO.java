package persistencia;

public class ProductoDAO extends DAO {
    
    public void eliminarProducto(int idProducto) throws Exception {
        String sql = "DELETE FROM producto WHERE id_producto = " + idProducto;
        insertarModificarEliminarDataBase(sql);
        System.out.println("Producto eliminado con exito.");
    }
}
