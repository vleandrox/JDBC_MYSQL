import java.util.Scanner;

import entidades.Cliente;
import persistencia.ClienteDAO;
import persistencia.DAO;
import persistencia.ProductoDAO;

public class Main extends DAO {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        ClienteDAO clienteDAO = new ClienteDAO();
        ProductoDAO productoDAO = new ProductoDAO();        
        System.out.print("Ingrese el id del producto: ");
        int idProducto = sc.nextInt();
        productoDAO.eliminarProducto(idProducto);
        clienteDAO.listarTodosLosClientes();
        System.out.print("Ingrese el codigo del cliente: ");
        int codigo = sc.nextInt();
        sc.nextLine();
        System.out.print("Ingrese el nombre del cliente: ");
        String nombreCliente = sc.nextLine();
        System.out.print("Ingrese el nombre de contacto: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese el apellido de contacto: ");
        String apellido = sc.nextLine();
        // Crear un nuevo objeto Cliente con los datos ingresados
        Cliente cliente = new Cliente();
        cliente.setCodigoCliente(codigo);
        cliente.setNombreCliente(nombreCliente);
        cliente.setNombreContacto(nombre);
        cliente.setApellidoContacto(apellido);
        // Guardar el cliente en la base de datos usando ClienteDAO
        try {
            clienteDAO.guardarCiente(cliente);
            System.out.println("Cliente guardado exitosamente.");            
        } catch (Exception e) {
            System.out.println("Error al guardar el cliente: " + e.getMessage());
        }
        // Main main = new Main();
        // System.out.print("INGRESE LA CONSULTA : ");
        // String sql = sc.nextLine();
        // main.insertarModificarEliminarDataBase(sql);
    }

    public void insertarModificarEliminarDataBase(String sql) throws Exception {
        try {
            consultarDataBase(sql);
            statement = conexion.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println(
                        resultSet.getString(3) + " - " + resultSet.getString(4) + " - " + resultSet.getString(5));
            }
        } catch (Exception e) {
            System.out.println("Error al consultar plantas: " + e.getMessage());
            throw e;
        } finally {
            desconectarDataBase();
        }
    }
}
