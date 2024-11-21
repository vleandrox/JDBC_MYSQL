package persistencia;

import java.util.ArrayList;

import entidades.Cliente;

public class ClienteDAO extends DAO {

    public void guardarCiente(Cliente cliente) throws Exception {
        if (cliente == null) {
            throw new Exception("El cliente no puede ser nulo.");
        }
        try {
            String sql = " INSERT INTO cliente (codig_cliente,nombre_cliente, nombre_contacto, apellido_contacto)" +
                    "VALUES ('" + cliente.getCodigoCliente() + "','" + cliente.getNombreCliente() + "','"
                    + cliente.getNombreContacto() + "','"
                    + cliente.getApellidoContacto() + "')";
            insertarModificarEliminarDataBase(sql);
            System.out.println("Cliente guardado con exito.");
        } catch (Exception e) {
            System.out.println("Error al guardar Clientes: " + e.getMessage());
            throw e;
        }
    }

    public void listarTodosLosClientes() throws Exception {
        try {
            // Crear la consulta SQL para seleccionar los campos requeridos
            String sql = "SELECT id_cliente, nombre_contacto, apellido_contacto FROM cliente";

            // Conectar a la base de datos y ejecutar la consulta
            connectarDataBase();
            statement = conexion.createStatement();
            resultSet = statement.executeQuery(sql);

            // Crear una lista para almacenar los clientes
            ArrayList<Cliente> clientes = new ArrayList<>();

            // Recorrer el ResultSet y añadir cada cliente a la lista
            while (resultSet.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(resultSet.getInt("id_cliente"));
                cliente.setNombreContacto(resultSet.getString("nombre_contacto"));
                cliente.setApellidoContacto(resultSet.getString("apellido_contacto"));

                clientes.add(cliente); // Agregar el cliente a la lista
            }

            // Verificar si la lista no está vacía e imprimir cada cliente
            if (!clientes.isEmpty()) {
                for (Cliente cliente : clientes) {
                    cliente.mostrarInformacionBasica();
                }
            } else {
                System.out.println("No se encontraron clientes en la base de datos.");
            }
        } catch (Exception e) {
            System.out.println("Error al consultar Clientes: " + e.getMessage());
            throw e;
        } finally {
            // Asegurarse de cerrar la conexión y liberar recursos
            desconectarDataBase();
        }
    }
}
