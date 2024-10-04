import java.sql.SQLException;

public class ClienteDAO extends DAO {
    public void buscarClientes() throws SQLException, ClassNotFoundException {        
        try {
             // Conectamos a la base de datos
            connectarDataBase();
            String sql = "SELECT nombre_contacto, apellido_contacto, telefono FROM cliente ";
            statement = conexion.createStatement();
            resultSet = statement.executeQuery(sql);
            int count = 0;
            while (resultSet.next()) {
                String nombre = resultSet.getString("nombre_contacto");
                String apellido = resultSet.getString("apellido_contacto");
                String telefono = resultSet.getString("telefono");
                count++;
                System.out.println(count + " - " + nombre + " " + apellido + " -  " + telefono);
            }
            // Cerrar ResultSet y Statement dentro del bloque try-catch-finally
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error en la consulta: " + e.getMessage());
        }
    }

    public void buscarClientePorCodigo(int codigo) throws SQLException, ClassNotFoundException {        
        try {
            connectarDataBase();
            String sql = "SELECT nombre_contacto, apellido_contacto, telefono FROM cliente WHERE codig_cliente = " + codigo;
            statement = conexion.createStatement();
            resultSet = statement.executeQuery(sql);
            int count = 0;
            while (resultSet.next()) {
                String nombre = resultSet.getString("nombre_contacto");
                String apellido = resultSet.getString("apellido_contacto");
                String telefono = resultSet.getString("telefono");
                count++;
                System.out.println(count + " - " + nombre + " " + apellido + " -  " + telefono);
            }
            // Cerrar ResultSet y Statement dentro del bloque try-catch-finally
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error en la consulta: " + e.getMessage());
        }

    }
    public void buscarClientePorEmpleado(int codigo_empleado) throws SQLException, ClassNotFoundException {        
        try {
            connectarDataBase();
            String sql = "SELECT codig_cliente,nombre_contacto, apellido_contacto, telefono FROM cliente WHERE id_empleado = " + codigo_empleado;
            statement = conexion.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String codig = resultSet.getString("codig_cliente");
                String nombre = resultSet.getString("nombre_contacto");
                String apellido = resultSet.getString("apellido_contacto");
                String telefono = resultSet.getString("telefono");
                System.out.println(codig + " - " + nombre + " " + apellido + " -  " + telefono);
            }
            // Cerrar ResultSet y Statement dentro del bloque try-catch-finally
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error en la consulta: " + e.getMessage());
        }

    }
 
}
