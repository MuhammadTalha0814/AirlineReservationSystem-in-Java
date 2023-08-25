/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airlinereservationsystem;

/**
 *
 * @author Qamar ul Zaman
 */
public class Ticket {
    private int number;
    private int price;
    private String type;
    
    public void setTicket(int number,int price,String type)
    {
        this.number=number;
        this.price=price;
        this.type=type;
    }
    public int getTicketNumber()
    {
        return number;
    }
    public int getTicketprice()
    {
        return price;
    }
    public String getTicketType()
    {
        return type;
    }
    
}
