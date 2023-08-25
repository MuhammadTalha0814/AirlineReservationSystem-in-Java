/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package airlinereservationsystem;
import java.awt.HeadlessException;
import java.sql.*;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author muham
 */
public class Tickets extends javax.swing.JFrame {

    private String fid,departure,destination,times;
    private String name;
    private String contactNo;
    private String passportNo;
    private String gender;
    private String type;
    private String id,ticket,price;
    private int count=0;
    public Connection con=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    Statement st=null;
    /**
     * Creates new form Tickets
     */
    public Tickets() {
        initComponents();
        getpassengers();
        getflight();
        displaydata();
        String c=Integer.toString(countTickets());
        PNAME.setEditable(false);
        GENDER.setEditable(false);
        PASSPORT.setEditable(false);
        DEP.setEditable(false);
        DEST.setEditable(false);
        TIME.setEditable(false);
        //TNO.setEditable(false);
        //TNO.setText((c));
        TICKETTABLE.setEnabled(false);
    }
    public void getflight()
    {
         try {
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/AirlineReservation","root","mtstyle");
            String s="SELECT * FROM Flight";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(s);
            while(rs.next())
            {
                String pid=String.valueOf(rs.getInt("FId"));
                FID.addItem(pid);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Passengers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void getpassengers()
    {
        try {
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/AirlineReservation","root","mtstyle");
            String s="SELECT * FROM passenger";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(s);
            while(rs.next())
            {
                String pid=String.valueOf(rs.getInt("Id"));
                PID.addItem(pid);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Passengers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void clear()
    {
        PNAME.setText("");
        GENDER.setText("");
        PASSPORT.setText("");
        PRICE.setText("");
        DEP.setText("");
        DEST.setText("");
        TIME.setText("");
        
        
    }
     public void getflightData()
    {
        
          
        try {
            
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/AirlineReservation","root","mtstyle");
            String s="SELECT * FROM flight where FId="+FID.getSelectedItem().toString();
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(s);
            while(rs.next())
            {
                departure=rs.getString("Departure");
                destination=rs.getString("Destination");
                times=rs.getString("Times");
            }
            DEP.setText(departure);
            DEST.setText(destination);
            TIME.setText(times);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Passengers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int countTickets()
    {
        try
        {
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/AirlineReservation","root","mtstyle");
            st=con.createStatement();
            rs=st.executeQuery("Select max(TicketNumber) from Ticket");
            rs.next();
            count=rs.getInt(1)+1;
            con.close();
            return count;
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(this,e );
            return 0;
        }
    }
    
    
    public void getpassengerData()
    {
        
          
        try {
            
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/AirlineReservation","root","mtstyle");
            String s="SELECT * FROM passenger where Id="+PID.getSelectedItem().toString();
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(s);
            while(rs.next())
            {
                name=rs.getString("Name");
                contactNo=rs.getString("ContactNumber");
                passportNo=rs.getString("PassportNumber");
                gender=rs.getString("Gender");
            }
            PNAME.setText(name);
            GENDER.setText(gender);
            PASSPORT.setText(passportNo);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Passengers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        PNAME = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        PID = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        PASSPORT = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        FID = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        GENDER = new javax.swing.JTextField();
        TNO = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        PRICE = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TICKETTABLE = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        SAVE = new javax.swing.JButton();
        BACK = new javax.swing.JButton();
        DEP = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        DEST = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        TIME = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        TYPE = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 0, 0));
        jLabel2.setText("Airline Reservation");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 0, 0));
        jLabel5.setText("Tickets Booking");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 0, 0));
        jLabel6.setText("Passenger Name");

        PNAME.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 0, 0));
        jLabel4.setText("Passenger Id");

        PID.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        PID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PIDMouseClicked(evt);
            }
        });
        PID.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                PIDInputMethodTextChanged(evt);
            }
        });
        PID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PIDActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 0, 0));
        jLabel7.setText("Gender");

        PASSPORT.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 0, 0));
        jLabel9.setText("Passport Number");

        FID.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        FID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FIDActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 0, 0));
        jLabel8.setText("Flight Code");

        GENDER.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        TNO.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 0, 0));
        jLabel10.setText("Ticket Number");

        PRICE.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 0, 0));
        jLabel11.setText("Price");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 0, 0));
        jLabel12.setText("Type");

        TICKETTABLE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Passenger ID", "Passenger Name", "Gender", "Passport Number", "Ticket Number", "Price", "Type", "Flight Code", "Departure", "Destination", "Time"
            }
        ));
        jScrollPane1.setViewportView(TICKETTABLE);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 0, 0));
        jLabel13.setText("Bookings");

        SAVE.setBackground(new java.awt.Color(218, 216, 216));
        SAVE.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        SAVE.setForeground(new java.awt.Color(255, 0, 0));
        SAVE.setText("Save");
        SAVE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SAVEMouseClicked(evt);
            }
        });

        BACK.setBackground(new java.awt.Color(218, 216, 216));
        BACK.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        BACK.setForeground(new java.awt.Color(255, 0, 0));
        BACK.setText("Back");
        BACK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BACKMouseClicked(evt);
            }
        });
        BACK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BACKActionPerformed(evt);
            }
        });

        DEP.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(204, 0, 0));
        jLabel14.setText("Departure");

        DEST.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(204, 0, 0));
        jLabel15.setText("Destination");

        TIME.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(204, 0, 0));
        jLabel16.setText("Time");

        TYPE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Economy", "Business" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(SAVE, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BACK, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(429, 429, 429))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(508, 508, 508))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel5))
                            .addComponent(jLabel2))
                        .addGap(470, 470, 470))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(PID, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FID, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(PNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(DEP, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(GENDER, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(DEST, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(TIME, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(PASSPORT, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(97, 97, 97)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(TNO, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PRICE, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TYPE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))))
                .addGap(16, 16, 16))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(PID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(GENDER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(PRICE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(TNO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(TYPE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(PNAME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PASSPORT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(FID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(29, 29, 29)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(DEST, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TIME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SAVE)
                    .addComponent(BACK))
                .addGap(18, 18, 18)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1144, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 17, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
public void displaydata()
    {
        
         DefaultTableModel model = (DefaultTableModel) TICKETTABLE.getModel();
         model.setRowCount(0);
        try {
            
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/AirlineReservation","root","mtstyle");
            String s="SELECT * FROM Passenger INNER JOIN TicketReserved ON passenger.Id=TicketReserved.PId";
            Statement st=con.createStatement();
           
            Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/AirlineReservation","root","mtstyle");
            String s1="SELECT * FROM flight INNER JOIN TicketReserved ON flight.FId=TicketReserved.FId";
            Statement st1=con.createStatement();
            
            Connection con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/AirlineReservation","root","mtstyle");
            String s2="SELECT * FROM Ticket INNER JOIN TicketReserved ON Ticket.TicketNumber=TicketReserved.TNo";
            Statement st2=con.createStatement();
            ResultSet rs=st.executeQuery(s);
            ResultSet rs1=st1.executeQuery(s1);
            ResultSet rs2=st2.executeQuery(s2);
            while(rs.next() && rs1.next() && rs2.next())
            {
                id=String.valueOf(rs.getInt("Passenger.Id"));
                name=rs.getString("Passenger.Name");
                ticket=rs.getString("TicketReserved.TNo");
                passportNo=rs.getString("Passenger.PassportNumber");
                gender=rs.getString("Passenger.Gender");
                fid=rs1.getString("flight.FId");
                destination=rs1.getString("flight.Destination");
                departure=rs1.getString("flight.Departure");
                times=rs1.getString("flight.Times");
                type=rs2.getString("Ticket.TicketType");
                price=rs2.getString("Ticket.Price");
                String tbData[]={id,name,gender,passportNo,ticket,price,type,fid,departure,destination,times};
                DefaultTableModel tbl=(DefaultTableModel)TICKETTABLE.getModel();
               
                tbl.addRow(tbData);
            }
            if(ticket!=null)
            {
                TravelingAgent ta=new TravelingAgent();
                ta.addticket(Integer.parseInt(ticket), Integer.parseInt(price), type);            
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Passengers.class.getName()).log(Level.SEVERE, null, ex);
        }
         
            
    }
    private void SAVEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SAVEMouseClicked
        // TODO add your handling code here:
        if(PNAME.getText()!=null && DEP.getText()!=null && !(PRICE.getText().isEmpty()) && TNO.getText()!=null )
        {
            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/AirlineReservation","root","mtstyle");
                
                String s="INSERT INTO Ticket VALUES(?,?,?)";
            
                PreparedStatement Add=con.prepareStatement(s);
                Add.setInt(1, Integer.parseInt(TNO.getText()));
                Add.setString(2,PRICE.getText());
                Add.setString(3, (String) TYPE.getSelectedItem());
            
                Add.executeUpdate();
                
                
                Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/AirlineReservation","root","mtstyle");
                s="INSERT INTO TicketReserved VALUES(?,?,?)";
            
                PreparedStatement Add1=con.prepareStatement(s);
                Add1.setInt(1, Integer.parseInt( TNO.getText()));
                Add1.setInt(2, Integer.parseInt((String) PID.getSelectedItem()));
                Add1.setInt(3, Integer.parseInt((String) FID.getSelectedItem()));
            
                Add1.executeUpdate();
                JOptionPane.showMessageDialog(this,"Ticket Booked" );
                clear();
            /*
            String tbData[]={Integer.toString(count),PRICE.getText(),TYPE.getSelectedItem().toString()};
            DefaultTableModel tbl=(DefaultTableModel)PASSENGERTABLE.getModel();
            tbl.addRow(tbData);
            */
                con1.close();
                con.close();
                displaydata();
                System.out.print(TNO.getText()+" "+PRICE.getText()+" "+TYPE.getSelectedItem());
            
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(this,"Already Seat Booked" );
            
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(this,"Missing Information" );
            
            }
            String c=Integer.toString(countTickets());
            TNO.setText(c);
        }
        else
        {
            JOptionPane.showMessageDialog(this,"Missing Information" );
            
        }
        
    }//GEN-LAST:event_SAVEMouseClicked

    private void PIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PIDMouseClicked
        // TODO add your handling code here:
       // getpassengerData();
       
    }//GEN-LAST:event_PIDMouseClicked

    private void PIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PIDActionPerformed
        // TODO add your handling code here:
        getpassengerData();
        //PID.removeAllItems();
        //getpassengers();
       
        
    }//GEN-LAST:event_PIDActionPerformed

    private void PIDInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_PIDInputMethodTextChanged
        // TODO add your handling code here:
       // getpassengerData();
    }//GEN-LAST:event_PIDInputMethodTextChanged

    private void FIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FIDActionPerformed
        // TODO add your handling code here:
        
        getflightData();
    }//GEN-LAST:event_FIDActionPerformed

    private void BACKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BACKMouseClicked
        // TODO add your handling code here:
        new MainForm().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BACKMouseClicked

    private void BACKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BACKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BACKActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tickets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tickets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tickets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tickets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tickets().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BACK;
    private javax.swing.JTextField DEP;
    private javax.swing.JTextField DEST;
    private javax.swing.JComboBox<String> FID;
    private javax.swing.JTextField GENDER;
    private javax.swing.JTextField PASSPORT;
    private javax.swing.JComboBox<String> PID;
    private javax.swing.JTextField PNAME;
    private javax.swing.JTextField PRICE;
    private javax.swing.JButton SAVE;
    private javax.swing.JTable TICKETTABLE;
    private javax.swing.JTextField TIME;
    private javax.swing.JTextField TNO;
    private javax.swing.JComboBox<String> TYPE;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
