import java.sql.SQLException;
import java.util.Scanner;
public class App {

    private static Scanner entrada = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        ClienteDAO clienteDAO = new ClienteDAO();
        ProductoDAO productoDAO = new ProductoDAO();
        try {
            clienteDAO.buscarClientes();
            System.out.print("Ingresa el codigo del cliente a buscar: ");
            int codigo = entrada.nextInt();
            entrada.nextLine();
            clienteDAO.buscarClientePorCodigo(codigo);
            System.out.println("Ingresa el id del empleado a buscar: ");
            int id_empleado = entrada.nextInt();
            clienteDAO.buscarClientePorEmpleado(id_empleado);
            entrada.nextLine();
            System.out.println("Ingresa el punto de reposicion: ");
            int puntoReposicion = entrada.nextInt();            
            productoDAO.getProductosParaReponer(puntoReposicion);            
            productoDAO.getProductosGama();
        } catch (SQLException|ClassNotFoundException e) {
            e.printStackTrace();
        }        
    }    
}

