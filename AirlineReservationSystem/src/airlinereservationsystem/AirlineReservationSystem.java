/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package airlinereservationsystem;

/**
 *
 * @author muham
 */
public class AirlineReservationSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      Splash splash=new Splash();
      new Login().setVisible(true);
      splash.dispose();
    }
    
}
