
import java.sql.SQLException;
import java.util.Scanner;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author (2020) Daniel Rojas Porras
 */
public class Eventos {
   
    public static void main(String[] args) throws SQLException {
        Mantenimiento_Eventos mE = new Mantenimiento_Eventos(); 
        System.out.println("Ingrese el id del evento que desea modificar ");
        Scanner input = new Scanner(System.in);
        int Consultaid = input.nextInt();
        
        mE.Actualizar(Consultaid);
      
    }
    
}
