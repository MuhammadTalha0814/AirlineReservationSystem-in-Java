/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airlinereservationsystem;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author muham
 */
public class TravelingAgent extends person{
    private String password;
    private String id;
     public Connection con=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    Statement st=null;
    
    
    public boolean Login(String username,String password)
    {
        
        try {
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/AirlineReservation","root","mtstyle");
            String s="SELECT * FROM travelingagent";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(s);
            while(rs.next())
            {
                this.id=String.valueOf(rs.getString("Name"));
                this.password=String.valueOf(rs.getString("Password"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Passengers.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(username.isEmpty() || password.isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Please Enter UserName AND Password" );
            return false;
        }
        else if(username.equals(this.id) && password.equals(this.password))
        {
            new MainForm().setVisible(true);
            return true;
        }
        else
        {
            JOptionPane.showMessageDialog(null,"INVALID USERNAME OR PASSWORD" );
            return false;
        }
        
    }
    
    public void addPassengers(int c,String n,String cn,String pn,String g,String d)
    {
     passenger pass=new passenger();
     pass.setvalues(c,n,cn,pn,g,d);
    }
    
    public void addticket(int n,int p,String t)
    {
        Ticket tick=new Ticket();
        tick.setTicket(n,p,t);
    }
    
    public ResultSet viewFlight()
    {
        try
        {
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/AirlineReservation","root","mtstyle");
            String s="SELECT * FROM Flight";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(s);
            return rs;
        }
        catch(Exception ex)
        {
            return null;
        }
    }
    public void cancelTicket(String ticket,String flight)
    {
        try
            {
                if(ticket!="")
                {
                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/AirlineReservation","root","mtstyle");
                    String s="DELETE FROM Ticket WHERE TicketNumber="+ticket;
                    Statement st=con.createStatement();
                    st.executeUpdate(s);
                    
                    s="DELETE FROM ticketreserved WHERE TNo="+ticket;
                    st=con.createStatement();
                    st.executeUpdate(s);
                
                    JOptionPane.showMessageDialog(null,"Ticket Cancelled" );
                }
                
               
               
            
            }
            catch(HeadlessException | SQLException e)
            {
                
            }
    
    }
}
