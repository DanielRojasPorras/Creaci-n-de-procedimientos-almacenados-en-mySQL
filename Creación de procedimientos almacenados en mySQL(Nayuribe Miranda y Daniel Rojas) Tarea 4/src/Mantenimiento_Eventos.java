
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author (2020) Daniel Rojas Porras
 */
public class Mantenimiento_Eventos {

    public static final String URL = "jdbc:mysql://localhost:3306/eventos?serverTimezone=UTC";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "NRoot";
    PreparedStatement ppmt;
    ResultSet rs;
    Statement a;

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Conexion exitosa");

        } catch (Exception e) {
            System.out.println(e);
        }
        return con;

    }

    public Mantenimiento_Eventos() {
    }
    

    public Boolean Actualizar(int id) throws SQLException {
        Connection con = null;
        con = getConnection();
        CallableStatement callS = null;

        try {
            System.out.println("Ingrese la nueva fecha con el formato año/mes/dia y la hora con el formato hora: minutos");
            Scanner input = new Scanner(System.in);
            String Datofecha = input.nextLine();
            String consulta = "{call actualizar (?,?)}";
            callS = con.prepareCall(consulta);
            callS.setInt(1, id);
            
            callS.setString(2, Datofecha);
            callS.execute();
             System.out.println("Actualizacion realizada con exito");
            return true;
        } catch (Exception ex) {
            Logger.getLogger(Mantenimiento_Eventos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        finally {
            callS.close();
        }

    }

}
