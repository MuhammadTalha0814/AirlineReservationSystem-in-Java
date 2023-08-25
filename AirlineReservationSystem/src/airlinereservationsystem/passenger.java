/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airlinereservationsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.SQLException;
/**
 *
 * @author muham
 */
public class passenger extends person{
    private String contactNo;
    private String passportNo;
    private String gender;
    private String dob;
    
    public void setvalues(int count,String name,String cn,String pn, String g,String d)
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/AirlineReservation","root","mtstyle");
            String s="INSERT INTO passenger VALUES(?,?,?,?,?,?)";
            id=count;
            this.name=name;
            contactNo=cn;
            passportNo=pn;
            gender=g;
            dob=d;
            PreparedStatement Add=con.prepareStatement(s);
            Add.setInt(1, count);
            Add.setString(2,name);
            Add.setString(3,cn);
            Add.setString(4,pn);
            Add.setString(5,g);
            Add.setString(6,d);
            int row=Add.executeUpdate();
            JOptionPane.showMessageDialog(null,"Passenger Added" );
           
            con.close();
            
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"Passenger Not Added" );
            
        }
//        contactNo=cn;
//        passportNo=pn;
//        gender=g;
//        dob=d;
        
    }
    public String getcontact()
    {
        return contactNo;
    }
    public String getpassport()
    {
        return passportNo;
    }
    public String getgender()
    {
        return gender;
    }
    public String getdob()
    {
        return dob;
    }
}
