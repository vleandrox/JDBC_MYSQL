import java.sql.SQLException;

public class ProductoDAO extends DAO {
    
    public void getProductosParaReponer(int puntoReposicion) throws SQLException, ClassNotFoundException {
        try {
            connectarDataBase();
            String sql = "SELECT codigo_producto, nombre, cantidad_en_stock FROM producto WHERE cantidad_en_stock <=" + puntoReposicion;
            statement = conexion.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String codigo_producto = resultSet.getString("codigo_producto");
                String nombre = resultSet.getString("nombre");
                String cantidad_en_stock = resultSet.getString("cantidad_en_stock");                
                System.out.println(codigo_producto+ " - " + nombre + " " + "STOCK: " + cantidad_en_stock);
            }
            // Cerrar ResultSet y Statement dentro del bloque try-catch-finally
            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            System.out.println("Error en la consulta: " + e.getMessage());
        }
    }

    public void getProductosGama() throws SQLException, ClassNotFoundException {
        try {
            connectarDataBase();
            String sql = "SELECT id_gama, gama, descripcion_texto FROM gama_producto";
            statement = conexion.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String id_gama = resultSet.getString("id_gama");
                String gama = resultSet.getString("gama");
                String descripcion_texto = resultSet.getString("descripcion_texto");                
                System.out.println(id_gama+ " - " + gama + " " + "STOCK: " + descripcion_texto);
            }
            // Cerrar ResultSet y Statement dentro del bloque try-catch-finally
            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            System.out.println("Error en la consulta: " + e.getMessage());
        }
    }
}
