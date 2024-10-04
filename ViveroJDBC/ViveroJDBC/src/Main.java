import java.sql.Statement;
import java.util.Scanner;

import persistencia.DAO;

public class Main extends DAO{

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {        
        Main main = new Main();
        System.out.print("INGRESE LA CONSULTA : ");
        String sql = sc.nextLine();
        main.insertarModificarEliminarDataBase(sql);
    }

    public void insertarModificarEliminarDataBase(String sql) throws Exception {
        try {          
            consultarDataBase(sql);  
            statement = conexion.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println(resultSet.getString(3) + " - " + resultSet.getString(4)+ " - " + resultSet.getString(5));
            }
        } catch (Exception e) {
            System.out.println("Error al consultar plantas: " + e.getMessage());
            throw e;
        } finally {
            desconectarDataBase();
        }
    }
}
