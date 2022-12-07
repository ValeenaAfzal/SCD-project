/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.scdproject;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import static com.mycompany.scdproject.SCDProject.dbpassword;
import static com.mycompany.scdproject.SCDProject.dbusername;
import static com.mycompany.scdproject.SCDProject.url;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Valeena Afzal
 */
public class EntryOperator extends javax.swing.JFrame {

    /**
     * Creates new form EntryOperator
     */
    public EntryOperator() {
        initComponents();
//        ListInventory();
    }
    
   
    Connection Con = null;
    Statement St=null;
    ResultSet Rs=null;
    public void ListInventory()
    {
        try
        {
            Con= DriverManager.getConnection(url, dbusername, dbpassword);
            St = Con.createStatement();
            Rs =St.executeQuery("Select * from Inventory");
            DefaultTableModel model = new DefaultTableModel();
                String[] columnNames = {"ID","Type", "Name", "Category", "Quantity","Price","Date"};
                model.setColumnIdentifiers(columnNames);
                Tables2.setModel(model);

            while(Rs.next())
            {
                ResultSetMetaData metaData = Rs.getMetaData();
                int numberOfColumns = metaData.getColumnCount();

                model.addRow(new Object[]{Rs.getString(1), Rs.getString(2), Rs.getString(3)
                        , Rs.getString(4),Rs.getString(5),Rs.getString(6),Rs.getString(7)});
                
                //System.out.println(Rs.getString(1)+" "+Rs.getString(2)+" "+Rs.getString(3)); 
            }
             // Tables2.setModel(resultSetToTableModel(Rs));
            
            
           // Tables2.setModel();*/
            Con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void ListOrder()
    {
        try
        {
            Con= DriverManager.getConnection(url, dbusername, dbpassword);
            St = Con.createStatement();
            Rs =St.executeQuery("Select * from Orders");
            DefaultTableModel model = new DefaultTableModel();
                String[] columnNames = {"ID","Type", "Name", "Category", "Quantity","CNIC","Date","Price"
                        , "Status","Delivery Date"};
                model.setColumnIdentifiers(columnNames);
                Tables1.setModel(model);

            while(Rs.next())
            {
                ResultSetMetaData metaData = Rs.getMetaData();
                int numberOfColumns = metaData.getColumnCount();

                model.addRow(new Object[]{Rs.getString(1), Rs.getString(2), Rs.getString(3)
                        , Rs.getString(4),Rs.getString(5),Rs.getString(6),Rs.getString(7),
                Rs.getString(8),Rs.getString(9),Rs.getString(10)});
                
                //System.out.println(Rs.getString(1)+" "+Rs.getString(2)+" "+Rs.getString(3)); 
            }
             // Tables2.setModel(resultSetToTableModel(Rs));
            
            
           // Tables2.setModel();*/
            Con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    

    public void GenerateOPdf()
    {
        String input = "";
        input = JOptionPane.showInputDialog(null, "Enter File Name for the pdf:");
        if(input.length() == 0)
            input = "myPdf";
        System.out.println(input);
        
        String path = "";
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int  x =j.showSaveDialog(this);
        if(x == JFileChooser.APPROVE_OPTION)
            path = j.getSelectedFile().getPath();
        
        Document doc  = new Document();
        try 
        {
            //System.out.println(path + "\'mydocomg.docx"); 
            PdfWriter.getInstance(doc, new FileOutputStream(path + "\\" + input + ".pdf"));
            doc.open();
            if(Tables1.getRowCount() >0){
            int n = Tables1.getColumnCount();
            int m= Tables1. getRowCount();
            System.out.println("No of cokumsn: " + n);
            System.out.println("No of rows: " + m);
            System.out.println("No of rows: " + Tables1. getRowCount());
            
            PdfPTable tb = new PdfPTable(n);
            for(int i = 0; i < n;i++)
                tb.addCell(Tables2.getColumnName(i));
            
            String value = "";
            for(int y = 0; y < m ; y++ )
            {
                for(int  z = 0; z < n; z++)
                {
                    
                    value = Tables1.getValueAt(y,z).toString(); 
                    System.out.println("Value " + value);
                    tb.addCell(value);
                }
            }
            doc.add(tb);
            JOptionPane.showMessageDialog(null,"Pdf gnerated");
            }
            
        } 
        catch (FileNotFoundException | DocumentException ex) 
        {
            JOptionPane.showMessageDialog(null,"there is some issue");
            
        }
        doc.close();
    }
    public void GeneratePdf()
    {
        String input = "";
        input = JOptionPane.showInputDialog(null, "Enter File Name for the pdf:");
        if(input.length() == 0)
            input = "myPdf";
        System.out.println(input);
        
        String path = "";
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int  x =j.showSaveDialog(this);
        if(x == JFileChooser.APPROVE_OPTION)
            path = j.getSelectedFile().getPath();
        
        Document doc  = new Document();
        try 
        {
            //System.out.println(path + "\'mydocomg.docx"); 
            PdfWriter.getInstance(doc, new FileOutputStream(path + "\\" + input + ".pdf"));
            doc.open();
            int n = Tables2.getColumnCount();
            int m= Tables2. getRowCount();
            System.out.println("No of cokumsn: " + n);
            System.out.println("No of rows: " + m);
            System.out.println("No of rows: " + Tables2. getRowCount());
            
            PdfPTable tb = new PdfPTable(n);
            for(int i = 0; i < n;i++)
                tb.addCell(Tables2.getColumnName(i));
            
            String value = "";
            for(int y = 0; y < m ; y++ )
            {
                for(int  z = 0; z < n; z++)
                {
                    
                    value = Tables2.getValueAt(y,z).toString(); 
                    System.out.println("Value " + value);
                    tb.addCell(value);
                }
            }
            doc.add(tb);
            JOptionPane.showMessageDialog(null,"Pdf gnerated");
            
            
        } 
        catch (FileNotFoundException | DocumentException ex) 
        {
            JOptionPane.showMessageDialog(null,"there is some issue");
            
        }
        doc.close();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ContentPane = new javax.swing.JPanel();
        Layers = new javax.swing.JLayeredPane();
        InventoryPanel = new javax.swing.JPanel();
        Manage = new javax.swing.JPanel();
        Formpanel = new javax.swing.JPanel();
        ManageInv = new javax.swing.JPanel();
        editlabel = new javax.swing.JLabel();
        editfield = new javax.swing.JTextField();
        InvType = new javax.swing.JLabel();
        plantType = new javax.swing.JComboBox<>();
        Name = new javax.swing.JLabel();
        plantName = new javax.swing.JTextField();
        Category = new javax.swing.JLabel();
        plantCategory = new javax.swing.JComboBox<>();
        Quantity = new javax.swing.JLabel();
        plantQuantity = new javax.swing.JTextField();
        Price = new javax.swing.JLabel();
        plantPrice = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        editbutton = new javax.swing.JLabel();
        QV1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        MButtonsP = new javax.swing.JPanel();
        ButtonsInv = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        InvHeadingP = new javax.swing.JPanel();
        Heading1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        Search = new javax.swing.JButton();
        SearchInv = new javax.swing.JTextField();
        OrderPanel = new javax.swing.JPanel();
        Manage1 = new javax.swing.JPanel();
        Formpanel1 = new javax.swing.JPanel();
        ManageInv1 = new javax.swing.JPanel();
        editlabel1 = new javax.swing.JLabel();
        editfield1 = new javax.swing.JTextField();
        InvType1 = new javax.swing.JLabel();
        OplantType = new javax.swing.JComboBox<>();
        Name1 = new javax.swing.JLabel();
        OplantName = new javax.swing.JTextField();
        Category1 = new javax.swing.JLabel();
        OplantCategory = new javax.swing.JComboBox<>();
        Quantity1 = new javax.swing.JLabel();
        OplantQuantity = new javax.swing.JTextField();
        Price1 = new javax.swing.JLabel();
        OplantPrice = new javax.swing.JTextField();
        CNIC = new javax.swing.JLabel();
        OCNIC = new javax.swing.JTextField();
        editbutton1 = new javax.swing.JLabel();
        InvHeadingP1 = new javax.swing.JPanel();
        Heading2 = new javax.swing.JLabel();
        MButtonsP2 = new javax.swing.JPanel();
        ButtonsInv2 = new javax.swing.JPanel();
        AddOrder = new javax.swing.JButton();
        EditOrder = new javax.swing.JButton();
        PrintOrder = new javax.swing.JButton();
        ClearOrder = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        Search1 = new javax.swing.JButton();
        SearchOrder = new javax.swing.JTextField();
        MailPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jFileChooser1 = new javax.swing.JFileChooser();
        jButton6 = new javax.swing.JButton();
        ViewInv2 = new javax.swing.JPanel();
        HeadingPanel2 = new javax.swing.JPanel();
        Heading4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        deleteInvfield = new javax.swing.JTextField();
        deleteInvButton = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        TablePanel2 = new javax.swing.JPanel();
        PTable2 = new javax.swing.JScrollPane();
        Tables2 = new javax.swing.JTable();
        OrderView = new javax.swing.JPanel();
        HeadingPanel3 = new javax.swing.JPanel();
        Heading5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        deletefield = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        TablePanel3 = new javax.swing.JPanel();
        PTable1 = new javax.swing.JScrollPane();
        Tables1 = new javax.swing.JTable();
        Menu = new javax.swing.JPanel();
        Logo = new javax.swing.JPanel();
        TLogo = new javax.swing.JLabel();
        Buttons = new javax.swing.JPanel();
        Inventory = new javax.swing.JButton();
        Inventory1 = new javax.swing.JButton();
        Orders = new javax.swing.JButton();
        OrderList = new javax.swing.JButton();
        Mails = new javax.swing.JButton();
        LogOut = new javax.swing.JButton();
        Buttons1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ContentPane.setLayout(new java.awt.GridLayout(1, 0));

        Layers.setLayout(new java.awt.CardLayout());

        InventoryPanel.setBackground(new java.awt.Color(255, 153, 255));
        InventoryPanel.setLayout(new java.awt.GridLayout(1, 0));

        Manage.setBackground(new java.awt.Color(255, 255, 255));
        Manage.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        Formpanel.setBackground(new java.awt.Color(255, 255, 255));
        Formpanel.setForeground(new java.awt.Color(255, 0, 0));
        Formpanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        ManageInv.setBackground(new java.awt.Color(255, 255, 255));
        ManageInv.setLayout(new java.awt.GridLayout(8, 1, 0, 30));

        editlabel.setBackground(new java.awt.Color(255, 255, 255));
        editlabel.setForeground(new java.awt.Color(153, 0, 0));
        ManageInv.add(editlabel);

        editfield.setForeground(new java.awt.Color(153, 0, 0));
        editfield.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        editfield.setToolTipText("");
        editfield.setBorder(null);
        editfield.setCaretColor(new java.awt.Color(255, 255, 255));
        editfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editfieldActionPerformed(evt);
            }
        });
        editfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                editfieldKeyTyped(evt);
            }
        });
        ManageInv.add(editfield);

        InvType.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        InvType.setForeground(new java.awt.Color(153, 0, 0));
        InvType.setText("Select Type");
        ManageInv.add(InvType);

        plantType.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        plantType.setForeground(new java.awt.Color(153, 0, 0));
        plantType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fruit Trees", "Trees", "Shrubs", "Herbs", "Climbers", "Creepers", "None" }));
        ManageInv.add(plantType);

        Name.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        Name.setForeground(new java.awt.Color(153, 0, 0));
        Name.setText("Name");
        ManageInv.add(Name);

        plantName.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        plantName.setForeground(new java.awt.Color(153, 0, 0));
        ManageInv.add(plantName);

        Category.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        Category.setForeground(new java.awt.Color(153, 0, 0));
        Category.setText("Category");
        ManageInv.add(Category);

        plantCategory.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        plantCategory.setForeground(new java.awt.Color(153, 0, 0));
        plantCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Plants", "Seeds", "Tools" }));
        ManageInv.add(plantCategory);

        Quantity.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        Quantity.setForeground(new java.awt.Color(153, 0, 0));
        Quantity.setText("Quantity");
        ManageInv.add(Quantity);

        plantQuantity.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        plantQuantity.setForeground(new java.awt.Color(153, 0, 0));
        plantQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plantQuantityActionPerformed(evt);
            }
        });
        plantQuantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                plantQuantityKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                plantQuantityKeyTyped(evt);
            }
        });
        ManageInv.add(plantQuantity);

        Price.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        Price.setForeground(new java.awt.Color(153, 0, 0));
        Price.setText("Price");
        ManageInv.add(Price);

        plantPrice.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        plantPrice.setForeground(new java.awt.Color(153, 0, 0));
        plantPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                plantPriceKeyTyped(evt);
            }
        });
        ManageInv.add(plantPrice);
        ManageInv.add(jLabel11);

        editbutton.setBackground(new java.awt.Color(255, 255, 255));
        editbutton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        editbutton.setForeground(new java.awt.Color(153, 0, 0));
        editbutton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        editbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editbuttonMouseClicked(evt);
            }
        });
        ManageInv.add(editbutton);
        ManageInv.add(QV1);

        Formpanel.add(ManageInv);

        jLabel9.setText("                                                                                                            ");
        Formpanel.add(jLabel9);

        MButtonsP.setBackground(new java.awt.Color(255, 255, 255));
        MButtonsP.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 5));

        ButtonsInv.setBackground(new java.awt.Color(255, 255, 255));
        ButtonsInv.setLayout(new java.awt.GridLayout(1, 0, 30, 0));

        jButton1.setBackground(new java.awt.Color(153, 0, 0));
        jButton1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Add");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        ButtonsInv.add(jButton1);

        jButton2.setBackground(new java.awt.Color(153, 0, 0));
        jButton2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Edit");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        ButtonsInv.add(jButton2);

        jButton4.setBackground(new java.awt.Color(153, 0, 0));
        jButton4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Clear");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        ButtonsInv.add(jButton4);

        MButtonsP.add(ButtonsInv);

        InvHeadingP.setBackground(new java.awt.Color(255, 255, 255));

        Heading1.setBackground(new java.awt.Color(153, 0, 0));
        Heading1.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        Heading1.setForeground(new java.awt.Color(153, 0, 0));
        Heading1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Heading1.setText("Manage Inventory");
        InvHeadingP.add(Heading1);

        javax.swing.GroupLayout ManageLayout = new javax.swing.GroupLayout(Manage);
        Manage.setLayout(ManageLayout);
        ManageLayout.setHorizontalGroup(
            ManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Formpanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(MButtonsP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(InvHeadingP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ManageLayout.setVerticalGroup(
            ManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ManageLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(InvHeadingP, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(Formpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(MButtonsP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(247, Short.MAX_VALUE))
        );

        InventoryPanel.add(Manage);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(153, 0, 0));

        jList1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jList1.setForeground(new java.awt.Color(153, 0, 0));
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "ID", "Type", "Name", "Category", "Quantity", "Price", "Date" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        Search.setFont(new java.awt.Font("Century Gothic", 3, 18)); // NOI18N
        Search.setForeground(new java.awt.Color(153, 0, 0));
        Search.setText("Search");
        Search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SearchMouseClicked(evt);
            }
        });

        SearchInv.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        SearchInv.setForeground(new java.awt.Color(153, 0, 0));
        SearchInv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchInvActionPerformed(evt);
            }
        });
        SearchInv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SearchInvKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(Search)
                        .addGap(85, 85, 85)
                        .addComponent(SearchInv, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(130, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Search)
                    .addComponent(SearchInv, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(491, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 298, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        InventoryPanel.add(jPanel3);

        Layers.add(InventoryPanel, "card2");

        OrderPanel.setBackground(new java.awt.Color(255, 255, 255));
        OrderPanel.setLayout(new java.awt.GridLayout(1, 0));

        Manage1.setBackground(new java.awt.Color(255, 255, 255));
        Manage1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        Formpanel1.setBackground(new java.awt.Color(255, 255, 255));
        Formpanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        ManageInv1.setBackground(new java.awt.Color(255, 255, 255));
        ManageInv1.setLayout(new java.awt.GridLayout(8, 6, 15, 30));

        editlabel1.setBackground(new java.awt.Color(255, 255, 255));
        editlabel1.setForeground(new java.awt.Color(153, 0, 0));
        ManageInv1.add(editlabel1);

        editfield1.setForeground(new java.awt.Color(153, 0, 0));
        editfield1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        editfield1.setToolTipText("");
        editfield1.setBorder(null);
        editfield1.setCaretColor(new java.awt.Color(255, 255, 255));
        editfield1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editfield1ActionPerformed(evt);
            }
        });
        editfield1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                editfield1KeyTyped(evt);
            }
        });
        ManageInv1.add(editfield1);

        InvType1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        InvType1.setForeground(new java.awt.Color(153, 0, 0));
        InvType1.setText("Select Type");
        ManageInv1.add(InvType1);

        OplantType.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        OplantType.setForeground(new java.awt.Color(153, 0, 0));
        OplantType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fruit Trees", "Trees", "Shrubs", "Herbs", "Climbers", "Creepers", "None" }));
        ManageInv1.add(OplantType);

        Name1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        Name1.setForeground(new java.awt.Color(153, 0, 0));
        Name1.setText("Name");
        ManageInv1.add(Name1);

        OplantName.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        OplantName.setForeground(new java.awt.Color(153, 0, 0));
        ManageInv1.add(OplantName);

        Category1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        Category1.setForeground(new java.awt.Color(153, 0, 0));
        Category1.setText("Category");
        ManageInv1.add(Category1);

        OplantCategory.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        OplantCategory.setForeground(new java.awt.Color(153, 0, 0));
        OplantCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Plants", "Seeds", "Tools" }));
        ManageInv1.add(OplantCategory);

        Quantity1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        Quantity1.setForeground(new java.awt.Color(153, 0, 0));
        Quantity1.setText("Quantity");
        ManageInv1.add(Quantity1);

        OplantQuantity.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        OplantQuantity.setForeground(new java.awt.Color(153, 0, 0));
        OplantQuantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                OplantQuantityKeyTyped(evt);
            }
        });
        ManageInv1.add(OplantQuantity);

        Price1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        Price1.setForeground(new java.awt.Color(153, 0, 0));
        Price1.setText("Price");
        ManageInv1.add(Price1);

        OplantPrice.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        OplantPrice.setForeground(new java.awt.Color(153, 0, 0));
        OplantPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                OplantPriceKeyTyped(evt);
            }
        });
        ManageInv1.add(OplantPrice);

        CNIC.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        CNIC.setForeground(new java.awt.Color(153, 0, 0));
        CNIC.setText("CNIC");
        ManageInv1.add(CNIC);

        OCNIC.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        OCNIC.setForeground(new java.awt.Color(153, 0, 0));
        OCNIC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                OCNICKeyTyped(evt);
            }
        });
        ManageInv1.add(OCNIC);

        editbutton1.setBackground(new java.awt.Color(255, 255, 255));
        editbutton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        editbutton1.setForeground(new java.awt.Color(153, 0, 0));
        editbutton1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        editbutton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editbutton1MouseClicked(evt);
            }
        });
        ManageInv1.add(editbutton1);

        Formpanel1.add(ManageInv1);

        InvHeadingP1.setBackground(new java.awt.Color(255, 255, 255));

        Heading2.setBackground(new java.awt.Color(153, 0, 0));
        Heading2.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        Heading2.setForeground(new java.awt.Color(153, 0, 0));
        Heading2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Heading2.setText("Manage Orders");
        InvHeadingP1.add(Heading2);

        MButtonsP2.setBackground(new java.awt.Color(255, 255, 255));
        MButtonsP2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 5));

        ButtonsInv2.setBackground(new java.awt.Color(255, 255, 255));
        ButtonsInv2.setLayout(new java.awt.GridLayout(1, 0, 30, 0));

        AddOrder.setBackground(new java.awt.Color(153, 0, 0));
        AddOrder.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        AddOrder.setForeground(new java.awt.Color(255, 255, 255));
        AddOrder.setText("Add");
        AddOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddOrderMouseClicked(evt);
            }
        });
        AddOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddOrderActionPerformed(evt);
            }
        });
        ButtonsInv2.add(AddOrder);

        EditOrder.setBackground(new java.awt.Color(153, 0, 0));
        EditOrder.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        EditOrder.setForeground(new java.awt.Color(255, 255, 255));
        EditOrder.setText("Edit");
        EditOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EditOrderMouseClicked(evt);
            }
        });
        EditOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditOrderActionPerformed(evt);
            }
        });
        ButtonsInv2.add(EditOrder);

        PrintOrder.setBackground(new java.awt.Color(153, 0, 0));
        PrintOrder.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        PrintOrder.setForeground(new java.awt.Color(255, 255, 255));
        PrintOrder.setText("Print");
        PrintOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintOrderActionPerformed(evt);
            }
        });
        ButtonsInv2.add(PrintOrder);

        ClearOrder.setBackground(new java.awt.Color(153, 0, 0));
        ClearOrder.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        ClearOrder.setForeground(new java.awt.Color(255, 255, 255));
        ClearOrder.setText("Clear");
        ClearOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClearOrderMouseClicked(evt);
            }
        });
        ButtonsInv2.add(ClearOrder);

        javax.swing.GroupLayout Manage1Layout = new javax.swing.GroupLayout(Manage1);
        Manage1.setLayout(Manage1Layout);
        Manage1Layout.setHorizontalGroup(
            Manage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Formpanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 891, Short.MAX_VALUE)
            .addComponent(InvHeadingP1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(MButtonsP2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(Manage1Layout.createSequentialGroup()
                .addGap(237, 237, 237)
                .addComponent(ButtonsInv2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Manage1Layout.setVerticalGroup(
            Manage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Manage1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(InvHeadingP1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Formpanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ButtonsInv2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(159, 159, 159)
                .addComponent(MButtonsP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(155, Short.MAX_VALUE))
        );

        OrderPanel.add(Manage1);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel7.setForeground(new java.awt.Color(255, 255, 255));

        jPanel8.setBackground(new java.awt.Color(153, 0, 0));

        jList2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jList2.setForeground(new java.awt.Color(153, 0, 0));
        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "ID", "Type", "Name", "Category", "Quantity", "CNIC", "Date", "Price", "Status", "Delivery date" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList2);

        Search1.setFont(new java.awt.Font("Century Gothic", 3, 18)); // NOI18N
        Search1.setForeground(new java.awt.Color(153, 0, 0));
        Search1.setText("Search");
        Search1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Search1MouseClicked(evt);
            }
        });

        SearchOrder.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        SearchOrder.setForeground(new java.awt.Color(153, 0, 0));
        SearchOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchOrderActionPerformed(evt);
            }
        });
        SearchOrder.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SearchOrderKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(Search1)
                        .addGap(85, 85, 85)
                        .addComponent(SearchOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(130, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Search1)
                    .addComponent(SearchOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(491, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        OrderPanel.add(jPanel7);

        Layers.add(OrderPanel, "card3");

        MailPanel.setBackground(new java.awt.Color(255, 255, 255));
        MailPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        MailPanel.setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setAlignmentX(5.0F);

        jPanel2.setBackground(new java.awt.Color(153, 0, 0));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setAlignmentX(5.0F);
        jPanel2.setPreferredSize(new java.awt.Dimension(500, 550));

        jLabel2.setBackground(new java.awt.Color(153, 0, 0));
        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Subject");

        jTextField9.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTextField9.setForeground(new java.awt.Color(153, 0, 0));

        jLabel4.setBackground(new java.awt.Color(153, 0, 0));
        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("From");

        jTextField11.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTextField11.setForeground(new java.awt.Color(153, 0, 0));
        jTextField11.setText("valeenaafzal@gmail.com");
        jTextField11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField11ActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(153, 0, 0));
        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Content");

        jTextField12.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jTextField12.setForeground(new java.awt.Color(153, 0, 0));

        jLabel6.setBackground(new java.awt.Color(153, 0, 0));
        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Select Attachment");

        jLabel3.setBackground(new java.awt.Color(153, 0, 0));
        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Send To");

        jTextField10.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTextField10.setForeground(new java.awt.Color(153, 0, 0));

        jLabel7.setBackground(new java.awt.Color(153, 0, 0));
        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 0, 0));
        jLabel7.setText("Send To");

        jButton6.setFont(new java.awt.Font("Century Gothic", 3, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(153, 0, 0));
        jButton6.setText("Send");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(209, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFileChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(357, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(122, 122, 122)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(226, 226, 226)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jFileChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(276, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(482, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 934, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        MailPanel.add(jPanel1);

        Layers.add(MailPanel, "card4");

        ViewInv2.setBackground(new java.awt.Color(255, 255, 255));
        ViewInv2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        HeadingPanel2.setBackground(new java.awt.Color(255, 255, 255));
        HeadingPanel2.setLayout(new java.awt.GridLayout(1, 0));

        Heading4.setBackground(new java.awt.Color(153, 0, 0));
        Heading4.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        Heading4.setForeground(new java.awt.Color(153, 0, 0));
        Heading4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Heading4.setText("Inventory List");
        HeadingPanel2.add(Heading4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new java.awt.GridLayout(1, 0));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setForeground(new java.awt.Color(153, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Enter ID to delete");
        jPanel5.add(jLabel1);

        deleteInvfield.setToolTipText("");
        deleteInvfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteInvfieldActionPerformed(evt);
            }
        });
        deleteInvfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                deleteInvfieldKeyTyped(evt);
            }
        });
        jPanel5.add(deleteInvfield);

        deleteInvButton.setBackground(new java.awt.Color(153, 0, 0));
        deleteInvButton.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        deleteInvButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteInvButton.setText("Delete");
        deleteInvButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteInvButtonMouseClicked(evt);
            }
        });
        deleteInvButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteInvButtonActionPerformed(evt);
            }
        });
        jPanel5.add(deleteInvButton);

        jButton3.setBackground(new java.awt.Color(153, 0, 0));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Print List");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jPanel5.add(jButton3);

        HeadingPanel2.add(jPanel5);

        TablePanel2.setBackground(new java.awt.Color(255, 255, 255));
        TablePanel2.setForeground(new java.awt.Color(153, 0, 0));
        TablePanel2.setLayout(new java.awt.GridLayout(1, 0));

        PTable2.setBackground(new java.awt.Color(153, 0, 0));
        PTable2.setBorder(null);
        PTable2.setForeground(new java.awt.Color(255, 255, 255));
        PTable2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N

        Tables2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Tables2.setForeground(new java.awt.Color(153, 0, 0));
        Tables2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Type", "Name", "Category", "Price", "Quantity", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tables2.setGridColor(new java.awt.Color(153, 0, 0));
        Tables2.setSelectionBackground(new java.awt.Color(255, 255, 255));
        Tables2.setSelectionForeground(new java.awt.Color(255, 153, 204));
        PTable2.setViewportView(Tables2);

        TablePanel2.add(PTable2);

        javax.swing.GroupLayout ViewInv2Layout = new javax.swing.GroupLayout(ViewInv2);
        ViewInv2.setLayout(ViewInv2Layout);
        ViewInv2Layout.setHorizontalGroup(
            ViewInv2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(HeadingPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(TablePanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1787, Short.MAX_VALUE)
        );
        ViewInv2Layout.setVerticalGroup(
            ViewInv2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewInv2Layout.createSequentialGroup()
                .addComponent(HeadingPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(TablePanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 836, Short.MAX_VALUE))
        );

        Layers.add(ViewInv2, "card5");

        OrderView.setBackground(new java.awt.Color(255, 255, 255));
        OrderView.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        HeadingPanel3.setBackground(new java.awt.Color(255, 255, 255));
        HeadingPanel3.setLayout(new java.awt.GridLayout(1, 0));

        Heading5.setBackground(new java.awt.Color(153, 0, 0));
        Heading5.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        Heading5.setForeground(new java.awt.Color(153, 0, 0));
        Heading5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Heading5.setText("Order List");
        Heading5.setToolTipText("");
        HeadingPanel3.add(Heading5);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new java.awt.GridLayout(1, 0));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setForeground(new java.awt.Color(153, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Enter ID to delete");
        jPanel6.add(jLabel8);

        deletefield.setToolTipText("");
        deletefield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletefieldActionPerformed(evt);
            }
        });
        deletefield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                deletefieldKeyTyped(evt);
            }
        });
        jPanel6.add(deletefield);

        jButton5.setBackground(new java.awt.Color(153, 0, 0));
        jButton5.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Delete");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton5);

        jButton7.setBackground(new java.awt.Color(153, 0, 0));
        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Generate PDF");
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
        });
        jPanel6.add(jButton7);

        HeadingPanel3.add(jPanel6);

        TablePanel3.setBackground(new java.awt.Color(255, 255, 255));
        TablePanel3.setForeground(new java.awt.Color(153, 0, 0));
        TablePanel3.setLayout(new java.awt.GridLayout(1, 0));

        PTable1.setBackground(new java.awt.Color(153, 0, 0));
        PTable1.setBorder(null);
        PTable1.setForeground(new java.awt.Color(255, 255, 255));
        PTable1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N

        Tables1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Tables1.setForeground(new java.awt.Color(153, 0, 0));
        Tables1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Type", "Name", "Date", "CNIC", "Quantity", "Price", "Category", "DDate", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tables1.setGridColor(new java.awt.Color(153, 0, 0));
        Tables1.setSelectionBackground(new java.awt.Color(255, 255, 255));
        Tables1.setSelectionForeground(new java.awt.Color(255, 153, 204));
        PTable1.setViewportView(Tables1);

        TablePanel3.add(PTable1);

        javax.swing.GroupLayout OrderViewLayout = new javax.swing.GroupLayout(OrderView);
        OrderView.setLayout(OrderViewLayout);
        OrderViewLayout.setHorizontalGroup(
            OrderViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(HeadingPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(TablePanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1787, Short.MAX_VALUE)
        );
        OrderViewLayout.setVerticalGroup(
            OrderViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OrderViewLayout.createSequentialGroup()
                .addComponent(HeadingPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(TablePanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 836, Short.MAX_VALUE))
        );

        Layers.add(OrderView, "card5");

        ContentPane.add(Layers);

        Menu.setBackground(new java.awt.Color(255, 255, 255));
        Menu.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        Logo.setBackground(new java.awt.Color(255, 255, 255));

        TLogo.setIcon(new javax.swing.ImageIcon("C:\\Users\\Valeena Afzal\\Documents\\NetBeansProjects\\SCDProject\\src\\main\\java\\com\\mycompany\\Images\\BudB.png")); // NOI18N

        Buttons.setBackground(new java.awt.Color(255, 255, 255));
        Buttons.setLayout(new java.awt.GridLayout(6, 0, 0, 30));

        Inventory.setBackground(new java.awt.Color(153, 0, 0));
        Inventory.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Inventory.setForeground(new java.awt.Color(255, 255, 255));
        Inventory.setIcon(new javax.swing.ImageIcon("C:\\Users\\Valeena Afzal\\Documents\\NetBeansProjects\\SCDProject\\src\\main\\java\\com\\mycompany\\Images\\icons8-warehouse-30.png")); // NOI18N
        Inventory.setText("Update Inventory");
        Inventory.setBorder(null);
        Inventory.setIconTextGap(15);
        Inventory.setMargin(new java.awt.Insets(1, 14, 2, 14));
        Inventory.setPreferredSize(new java.awt.Dimension(120, 50));
        Inventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InventoryActionPerformed(evt);
            }
        });
        Buttons.add(Inventory);

        Inventory1.setBackground(new java.awt.Color(153, 0, 0));
        Inventory1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Inventory1.setForeground(new java.awt.Color(255, 255, 255));
        Inventory1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Valeena Afzal\\Documents\\NetBeansProjects\\SCDProject\\src\\main\\java\\com\\mycompany\\Images\\icons8-list-view-30.png")); // NOI18N
        Inventory1.setText("Inventory List");
        Inventory1.setBorder(null);
        Inventory1.setIconTextGap(45);
        Inventory1.setMargin(new java.awt.Insets(1, 14, 2, 14));
        Inventory1.setPreferredSize(new java.awt.Dimension(120, 50));
        Inventory1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Inventory1ActionPerformed(evt);
            }
        });
        Buttons.add(Inventory1);

        Orders.setBackground(new java.awt.Color(153, 0, 0));
        Orders.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Orders.setForeground(new java.awt.Color(255, 255, 255));
        Orders.setIcon(new javax.swing.ImageIcon("C:\\Users\\Valeena Afzal\\Documents\\NetBeansProjects\\SCDProject\\src\\main\\java\\com\\mycompany\\Images\\icons8-order-30.png")); // NOI18N
        Orders.setText("Add Order");
        Orders.setIconTextGap(50);
        Orders.setPreferredSize(new java.awt.Dimension(120, 50));
        Orders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrdersActionPerformed(evt);
            }
        });
        Buttons.add(Orders);

        OrderList.setBackground(new java.awt.Color(153, 0, 0));
        OrderList.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        OrderList.setForeground(new java.awt.Color(255, 255, 255));
        OrderList.setIcon(new javax.swing.ImageIcon("C:\\Users\\Valeena Afzal\\Documents\\NetBeansProjects\\SCDProject\\src\\main\\java\\com\\mycompany\\Images\\icons8-list-view-30.png")); // NOI18N
        OrderList.setText("Order List");
        OrderList.setToolTipText("");
        OrderList.setIconTextGap(50);
        OrderList.setPreferredSize(new java.awt.Dimension(120, 50));
        OrderList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrderListActionPerformed(evt);
            }
        });
        Buttons.add(OrderList);

        Mails.setBackground(new java.awt.Color(153, 0, 0));
        Mails.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Mails.setForeground(new java.awt.Color(255, 255, 255));
        Mails.setIcon(new javax.swing.ImageIcon("C:\\Users\\Valeena Afzal\\Documents\\NetBeansProjects\\SCDProject\\src\\main\\java\\com\\mycompany\\Images\\icons8-send-email-30.png")); // NOI18N
        Mails.setText("Email");
        Mails.setIconTextGap(80);
        Mails.setPreferredSize(new java.awt.Dimension(120, 50));
        Mails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MailsActionPerformed(evt);
            }
        });
        Buttons.add(Mails);

        LogOut.setBackground(new java.awt.Color(153, 0, 0));
        LogOut.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        LogOut.setForeground(new java.awt.Color(255, 255, 255));
        LogOut.setIcon(new javax.swing.ImageIcon("C:\\Users\\Valeena Afzal\\Documents\\NetBeansProjects\\SCDProject\\src\\main\\java\\com\\mycompany\\Images\\icons8-logout-rounded-left-50.png")); // NOI18N
        LogOut.setBorder(null);
        LogOut.setIconTextGap(80);
        LogOut.setPreferredSize(new java.awt.Dimension(120, 50));
        LogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutActionPerformed(evt);
            }
        });
        Buttons.add(LogOut);

        Buttons1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout Buttons1Layout = new javax.swing.GroupLayout(Buttons1);
        Buttons1.setLayout(Buttons1Layout);
        Buttons1Layout.setHorizontalGroup(
            Buttons1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 187, Short.MAX_VALUE)
        );
        Buttons1Layout.setVerticalGroup(
            Buttons1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout LogoLayout = new javax.swing.GroupLayout(Logo);
        Logo.setLayout(LogoLayout);
        LogoLayout.setHorizontalGroup(
            LogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LogoLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(LogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Buttons, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TLogo)
                    .addComponent(Buttons1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        LogoLayout.setVerticalGroup(
            LogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LogoLayout.createSequentialGroup()
                .addComponent(TLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(Buttons, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Buttons1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout MenuLayout = new javax.swing.GroupLayout(Menu);
        Menu.setLayout(MenuLayout);
        MenuLayout.setHorizontalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Logo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        MenuLayout.setVerticalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addComponent(Logo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(ContentPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ContentPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(Menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void InventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InventoryActionPerformed

        SwitchPanels(InventoryPanel);
        
       /* try 
        {
            String soundName = ".wav";    
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } 
        catch (Exception ex) {
            Logger.getLogger(EntryOperator.class.getName()).log(Level.SEVERE, null, ex);
        }*/
       
        // TODO add your handling code here:
    }//GEN-LAST:event_InventoryActionPerformed

    private void OrdersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrdersActionPerformed
        SwitchPanels(OrderPanel);
        ListOrder();
        // TODO add your handling code here:
    }//GEN-LAST:event_OrdersActionPerformed

    private void MailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MailsActionPerformed
        SwitchPanels(MailPanel);
        // TODO add your handling code here:
    }//GEN-LAST:event_MailsActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void deleteInvButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteInvButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteInvButtonActionPerformed

    private void EditOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditOrderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EditOrderActionPerformed

    private void PrintOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintOrderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PrintOrderActionPerformed

    private void jTextField11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void LogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutActionPerformed

        new LOGIN().setVisible(true);
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_LogOutActionPerformed

    
    private void Inventory1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Inventory1ActionPerformed
        SwitchPanels(ViewInv2);
        ListInventory();
        // TODO add your handling code here:
    }//GEN-LAST:event_Inventory1ActionPerformed

    private void SearchInvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchInvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchInvActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
    
        
        String A = plantType.getSelectedItem().toString();
        String D = plantCategory.getSelectedItem().toString();
        String E = plantQuantity.getText();
        String C = plantName.getText();
        String F = plantPrice.getText();
        
        String query = " ";
        int status=Integer.MAX_VALUE;
        if(A.isEmpty() || D.isEmpty() || E.isEmpty() || C.isEmpty() || F.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Missing Information");
        }
        else
        {
            try (Connection con = DriverManager.getConnection(url, dbusername, dbpassword); Statement st = con.createStatement();) 
                {
                    query  = "insert into Inventory (Type,Name,Category,Quantity,Price,Date)"
                    +  "VALUES(?, ?, ?, ?, ? ,?)";
                    PreparedStatement ps;
                    ps = con.prepareStatement(query);
                    ps.setString(1, A);
                    ps.setString(2, C);
                    ps.setString(3, D);
                    ps.setString(4, E);
                    ps.setString(5, F);
                    ps.setString(6, String.valueOf(LocalDateTime.now()));
                    status = ps.executeUpdate();
                    if(status == 1)
                    {
                        JOptionPane.showMessageDialog(this, "Inventory Added Successfully");
                        
                    }
                    con.close();
                }
                catch (SQLException e)
                {
                    e.printStackTrace();
                }
            }
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        plantName.setText("");
        plantPrice.setText("");
        plantQuantity.setText("");
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked

        
        editlabel.setText("Enter ID of record you want to edit");
        editbutton.setBackground(Color.red);
        editbutton.setText("Done");
        editfield.setBackground(Color.red);
       
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseClicked

    private void deleteInvfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteInvfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteInvfieldActionPerformed

    private void AddOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddOrderMouseClicked
        // TODO add your handling code here:
        String A = OplantType.getSelectedItem().toString();
        String D = OplantCategory.getSelectedItem().toString();
        String E = OplantQuantity.getText();
        String C = OplantName.getText();
        String F = OplantPrice.getText();
        String B = OCNIC.getText();
      //  String G = ODate.g
        
        String query = " ";
        int status=Integer.MAX_VALUE;
        if(A.isEmpty() || D.isEmpty() || E.isEmpty() || C.isEmpty() || F.isEmpty() || B.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Missing Information");
        }
        else
        {
            try (Connection con = DriverManager.getConnection(url, dbusername, dbpassword); Statement st = con.createStatement();) 
                {
                    query  = "insert into Orders (Type,Name,Category,Quantity,CNIC,Date,Price,Status,DeliveryDate)"
                    +  "VALUES(?, ?, ?, ? ,?,?,?,?,?)";
                    PreparedStatement ps;
                    ps = con.prepareStatement(query);
                    ps.setString(1, A);
                    ps.setString(2, C);
                    ps.setString(3, D);
                    ps.setString(4, E);
                    ps.setString(5, B);
                    ps.setString(6, String.valueOf(LocalDateTime.now()));
                    ps.setString(7, F);
                    ps.setString(8, "Not Approved");
                    ps.setString(9, String.valueOf(LocalDateTime.now()));
                    status = ps.executeUpdate();
                    if(status == 1)
                    {
                        JOptionPane.showMessageDialog(this, "Order Added Successfully");
                        
                    }
                    con.close();
                    ListOrder();
                }
                catch (SQLException e)
                {
                    e.printStackTrace();
                }
            }
    }//GEN-LAST:event_AddOrderMouseClicked

    private void OrderListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrderListActionPerformed
        // TODO add your handling code here:
        SwitchPanels(OrderView);
        ListOrder();
    }//GEN-LAST:event_OrderListActionPerformed

    private void deletefieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletefieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deletefieldActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void ClearOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearOrderMouseClicked
        // TODO add your handling code here:
        OplantName.setText("");
        OplantPrice.setText("");
        OplantQuantity.setText("");
        OCNIC.setText("");
        
    }//GEN-LAST:event_ClearOrderMouseClicked

    private void SearchOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchOrderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchOrderActionPerformed

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked

        deletefield.getText();
        String query = " ";
        int status=Integer.MAX_VALUE;
        if(deletefield.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Missing Information");
        }
        else
        {
            try (Connection con = DriverManager.getConnection(url, dbusername, dbpassword); Statement st = con.createStatement();) 
                {
                    query  = "delete from Orders where ID=?";
                    PreparedStatement ps;
                    ps = con.prepareStatement(query);
                    ps.setString(1, deletefield.getText());
                    status = ps.executeUpdate();
                    if(status == 1)
                    {
                        JOptionPane.showMessageDialog(this, "Deleted Successfully");
                    }
                    con.close();
                    ListOrder();
                }
                catch (SQLException e)
                {
                    e.printStackTrace();
                }
            }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5MouseClicked

    private void deleteInvButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteInvButtonMouseClicked
        
        deleteInvfield.getText();
        String query = " ";
        int status=Integer.MAX_VALUE;
        if(deleteInvfield.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Missing Information");
        }
        else
        {
            try (Connection con = DriverManager.getConnection(url, dbusername, dbpassword); Statement st = con.createStatement();) 
                {
                    query  = "delete from Inventory where ID=?";
                    PreparedStatement ps;
                    ps = con.prepareStatement(query);
                    ps.setString(1, deleteInvfield.getText());
                    status = ps.executeUpdate();
                    if(status == 1)
                    {
                        JOptionPane.showMessageDialog(this, "Deleted Successfully");
                    }
                    con.close();
                    ListInventory();
                }
                catch (SQLException e)
                {
                    e.printStackTrace();
                }
            }

        // TODO add your handling code here:
    }//GEN-LAST:event_deleteInvButtonMouseClicked

    private void plantQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plantQuantityActionPerformed
           

        // TODO add your handling code here:
    }//GEN-LAST:event_plantQuantityActionPerformed

    private void plantQuantityKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_plantQuantityKeyTyped

        char c=evt.getKeyChar();
        
        if(!Character.isDigit(c))
            evt.consume();

        // TODO add your handling code here:
    }//GEN-LAST:event_plantQuantityKeyTyped

    private void plantPriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_plantPriceKeyTyped

       
        char c=evt.getKeyChar();
        
        if(!Character.isDigit(c))
            evt.consume();// TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_plantPriceKeyTyped

    private void plantQuantityKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_plantQuantityKeyPressed
     
    }//GEN-LAST:event_plantQuantityKeyPressed

    private void OplantQuantityKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_OplantQuantityKeyTyped
        char c=evt.getKeyChar();
        
        if(!Character.isDigit(c))
            evt.consume();
    
            // TODO add your handling code here:
    }//GEN-LAST:event_OplantQuantityKeyTyped

    private void OplantPriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_OplantPriceKeyTyped
     char c=evt.getKeyChar();
        
        if(!Character.isDigit(c))
            evt.consume();
        // TODO add your handling code here:
    }//GEN-LAST:event_OplantPriceKeyTyped

    private void OCNICKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_OCNICKeyTyped
        char c=evt.getKeyChar();
        if(!Character.isDigit(c))
            evt.consume();
        // TODO add your handling code here:
    }//GEN-LAST:event_OCNICKeyTyped

    private void AddOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddOrderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddOrderActionPerformed

    private void deletefieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_deletefieldKeyTyped
         char c=evt.getKeyChar();
        
        if(!Character.isDigit(c))
            evt.consume();
        // TODO add your handling code here:
    }//GEN-LAST:event_deletefieldKeyTyped

    private void deleteInvfieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_deleteInvfieldKeyTyped
         char c=evt.getKeyChar();
        
        if(!Character.isDigit(c))
            evt.consume();
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteInvfieldKeyTyped

    private void SearchOrderKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchOrderKeyTyped
         char c=evt.getKeyChar();
        
        if(!Character.isDigit(c))
            evt.consume();
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchOrderKeyTyped

    private void SearchInvKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchInvKeyTyped
         char c=evt.getKeyChar();
        
        if(!Character.isDigit(c))
            evt.consume();
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchInvKeyTyped

    private void SearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchMouseClicked
        String query = "";
        int status=Integer.MAX_VALUE;
        if(SearchInv.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Missing Information");
        }
        else
        {
            try (Connection con = DriverManager.getConnection(url, dbusername, dbpassword); Statement st = con.createStatement();) 
                {
                    query  = "Select * from Inventory where ID = ?";
                    PreparedStatement ps;
                    ps = con.prepareStatement(query);
                    ps.setString(1, SearchInv.getText());
                    ResultSet rs = ps.executeQuery();
                    rs.next();
                    DefaultListModel model = new DefaultListModel();
                    model.addElement("ID:   "+rs.getString(1));
                    model.addElement("Type:   "+rs.getString(2));
                    model.addElement("Name:   "+rs.getString(3));
                    model.addElement("Category:   "+rs.getString(4));
                    model.addElement("Quantity:   "+rs.getString(5));
                    model.addElement("Price:   "+rs.getString(6));
                    model.addElement("Date:   "+rs.getString(7));
                    jList1.setModel(model);
                    con.close();
                }
                catch (SQLException e)
                {
                    e.printStackTrace();
                }
            }
        

        // TODO add your handling code here:
    }//GEN-LAST:event_SearchMouseClicked

    private void Search1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Search1MouseClicked
        String query = "";
        int status=Integer.MAX_VALUE;
        if(SearchOrder.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Missing Information");
        }
        else
        {
            try (Connection con = DriverManager.getConnection(url, dbusername, dbpassword); Statement st = con.createStatement();) 
                {
                    query  = "Select * from Orders where ID = ?";
                    PreparedStatement ps;
                    ps = con.prepareStatement(query);
                    ps.setString(1, SearchOrder.getText());
                    ResultSet rs = ps.executeQuery();
                    rs.next();
                    DefaultListModel model = new DefaultListModel();
                    model.addElement("ID:   "+rs.getString(1));
                    model.addElement("Type:   "+rs.getString(2));
                    model.addElement("Name:   "+rs.getString(3));
                    model.addElement("Category:   "+rs.getString(4));
                    model.addElement("Quantity:   "+rs.getString(5));
                    model.addElement("CNIC:   "+rs.getString(6));
                    model.addElement("Date:   "+rs.getString(7));
                    model.addElement("Price:   "+rs.getString(8));
                    model.addElement("Status:   "+rs.getString(9));
                    model.addElement("Delivery Date:   "+rs.getString(10));
                    jList2.setModel(model);
                    con.close();
                }
                catch (SQLException e)
                {
                    e.printStackTrace();
                }
            }

        
    }//GEN-LAST:event_Search1MouseClicked

    private void editfieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editfieldKeyTyped
        char c=evt.getKeyChar();
        
        if(!Character.isDigit(c))
            evt.consume();
        // TODO add your handling code here:
    }//GEN-LAST:event_editfieldKeyTyped

    private void editfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editfieldActionPerformed

    private void editbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editbuttonMouseClicked

        String G=editfield.getText();
        
        String A = plantType.getSelectedItem().toString();
        String D = plantCategory.getSelectedItem().toString();
        String E = plantQuantity.getText();
        String C = plantName.getText();
        String F = plantPrice.getText();
        
        String query = " ";
        int status=Integer.MAX_VALUE;
        if(A.isEmpty() || D.isEmpty() || E.isEmpty() || C.isEmpty() || F.isEmpty()|| G.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Missing Information");
        }
        else
        {
            try (Connection con = DriverManager.getConnection(url, dbusername, dbpassword); Statement st = con.createStatement();) 
                {
                    query="UPDATE Inventory SET ID="+G+",Type=?,Name=?,Category=?,Quantity=?,Price=?,Date=? WHERE ID=? ";
                   
                    PreparedStatement ps;
                    ps = con.prepareStatement(query);
                    ps.setString(1, A);
                    ps.setString(2, C);
                    ps.setString(3, D);
                    ps.setString(4, E);
                    ps.setString(5, F);
                    ps.setString(6, String.valueOf(LocalDateTime.now()));
                    ps.setString(7, G);
                    status = ps.executeUpdate();
                    if(status == 1)
                    {
                        JOptionPane.showMessageDialog(this, "Inventory Edited Successfully");
                        
                    }
                    con.close();
                }
                catch (SQLException e)
                {
                    e.printStackTrace();
                }
            
                editlabel.setText("");
                editfield.setBackground(Color.WHITE);
                editfield.setText("");
                editbutton.setText("");
            }
        // TODO add your handling code here:
    }//GEN-LAST:event_editbuttonMouseClicked

    private void editfield1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editfield1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editfield1ActionPerformed

    private void editfield1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editfield1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_editfield1KeyTyped

    private void editbutton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editbutton1MouseClicked

        
        String A = OplantType.getSelectedItem().toString();
        String D = OplantCategory.getSelectedItem().toString();
        String E = OplantQuantity.getText();
        String C = OplantName.getText();
        String F = OplantPrice.getText();
        String B = OCNIC.getText();
        String G=editfield1.getText();
        
        
        String query = " ";
        int status=Integer.MAX_VALUE;
        if(A.isEmpty() || D.isEmpty() || E.isEmpty() || C.isEmpty() || F.isEmpty()|| G.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Missing Information");
        }
        else
        {
            try (Connection con = DriverManager.getConnection(url, dbusername, dbpassword); Statement st = con.createStatement();) 
                {
                   query  = "UPDATE Orders SET ID="+G+",Type=?,Name=?,Category=?,"
                           + "Quantity=?,CNIC=?,"
                           + "Date=?,Price=?,Status=?,DeliveryDate=? WHERE ID=?";
                    PreparedStatement ps; 
                    ps = con.prepareStatement(query);
                    ps.setString(1, A);
                    ps.setString(2, C);
                    ps.setString(3, D);
                    ps.setString(4, E);
                    ps.setString(5, B);
                    ps.setString(6, String.valueOf(LocalDateTime.now()));
                    ps.setString(7, F);
                    ps.setString(8, "Not Approved");
                    ps.setString(9, String.valueOf(LocalDateTime.now()));
                    ps.setString(10, G);
                    status = ps.executeUpdate();
                    if(status == 1)
                    {
                        JOptionPane.showMessageDialog(this, "Order Edited Successfully");
                        
                    }
                    con.close();
                }
                catch (SQLException e)
                {
                    e.printStackTrace();
                }
            
                editlabel1.setText("");
                editfield1.setBackground(Color.WHITE);
                editfield1.setText("");
                editbutton1.setText("");
            }
        // TODO add your handling code here:

        // TODO add your handling code here:
    }//GEN-LAST:event_editbutton1MouseClicked

    private void EditOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditOrderMouseClicked
        editlabel1.setText("Enter ID of record you want to edit");
        editbutton1.setBackground(Color.red);
        editbutton1.setText("Done");
        editfield1.setBackground(Color.red);
        // TODO add your handling code here:
    }//GEN-LAST:event_EditOrderMouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked

        GeneratePdf();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseClicked
        GenerateOPdf();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7MouseClicked

    public void SwitchPanels(JPanel panel)
    {
        Layers.removeAll();
        Layers.add(panel);
        Layers.repaint();
        Layers.revalidate();
    }
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
            java.util.logging.Logger.getLogger(EntryOperator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EntryOperator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EntryOperator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EntryOperator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EntryOperator().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddOrder;
    private javax.swing.JPanel Buttons;
    private javax.swing.JPanel Buttons1;
    private javax.swing.JPanel ButtonsInv;
    private javax.swing.JPanel ButtonsInv2;
    private javax.swing.JLabel CNIC;
    private javax.swing.JLabel Category;
    private javax.swing.JLabel Category1;
    private javax.swing.JButton ClearOrder;
    private javax.swing.JPanel ContentPane;
    private javax.swing.JButton EditOrder;
    private javax.swing.JPanel Formpanel;
    private javax.swing.JPanel Formpanel1;
    private javax.swing.JLabel Heading1;
    private javax.swing.JLabel Heading2;
    private javax.swing.JLabel Heading4;
    private javax.swing.JLabel Heading5;
    private javax.swing.JPanel HeadingPanel2;
    private javax.swing.JPanel HeadingPanel3;
    private javax.swing.JPanel InvHeadingP;
    private javax.swing.JPanel InvHeadingP1;
    private javax.swing.JLabel InvType;
    private javax.swing.JLabel InvType1;
    private javax.swing.JButton Inventory;
    private javax.swing.JButton Inventory1;
    private javax.swing.JPanel InventoryPanel;
    private javax.swing.JLayeredPane Layers;
    private javax.swing.JButton LogOut;
    private javax.swing.JPanel Logo;
    private javax.swing.JPanel MButtonsP;
    private javax.swing.JPanel MButtonsP2;
    private javax.swing.JPanel MailPanel;
    private javax.swing.JButton Mails;
    private javax.swing.JPanel Manage;
    private javax.swing.JPanel Manage1;
    private javax.swing.JPanel ManageInv;
    private javax.swing.JPanel ManageInv1;
    private javax.swing.JPanel Menu;
    private javax.swing.JLabel Name;
    private javax.swing.JLabel Name1;
    private javax.swing.JTextField OCNIC;
    private javax.swing.JComboBox<String> OplantCategory;
    private javax.swing.JTextField OplantName;
    private javax.swing.JTextField OplantPrice;
    private javax.swing.JTextField OplantQuantity;
    private javax.swing.JComboBox<String> OplantType;
    private javax.swing.JButton OrderList;
    private javax.swing.JPanel OrderPanel;
    private javax.swing.JPanel OrderView;
    private javax.swing.JButton Orders;
    private javax.swing.JScrollPane PTable1;
    private javax.swing.JScrollPane PTable2;
    private javax.swing.JLabel Price;
    private javax.swing.JLabel Price1;
    private javax.swing.JButton PrintOrder;
    private javax.swing.JLabel QV1;
    private javax.swing.JLabel Quantity;
    private javax.swing.JLabel Quantity1;
    private javax.swing.JButton Search;
    private javax.swing.JButton Search1;
    private javax.swing.JTextField SearchInv;
    private javax.swing.JTextField SearchOrder;
    private javax.swing.JLabel TLogo;
    private javax.swing.JPanel TablePanel2;
    private javax.swing.JPanel TablePanel3;
    private javax.swing.JTable Tables1;
    private javax.swing.JTable Tables2;
    private javax.swing.JPanel ViewInv2;
    private javax.swing.JButton deleteInvButton;
    private javax.swing.JTextField deleteInvfield;
    private javax.swing.JTextField deletefield;
    private javax.swing.JLabel editbutton;
    private javax.swing.JLabel editbutton1;
    private javax.swing.JTextField editfield;
    private javax.swing.JTextField editfield1;
    private javax.swing.JLabel editlabel;
    private javax.swing.JLabel editlabel1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JComboBox<String> plantCategory;
    private javax.swing.JTextField plantName;
    private javax.swing.JTextField plantPrice;
    private javax.swing.JTextField plantQuantity;
    private javax.swing.JComboBox<String> plantType;
    // End of variables declaration//GEN-END:variables
}
