package com.mycompany.scdproject;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.statistics.HistogramDataset;

public class APage extends javax.swing.JFrame 
{
    public APage() {
        initComponents();
        //showPieChart();
        showLineChart();
        //showHistogram();
        showBarChart();
    }
    /*
    public void showPieChart(){
        
        //create dataset
      DefaultPieDataset barDataset = new DefaultPieDataset( );
      barDataset.setValue( "IPhone 5s" , new Double( 20 ) );  
      barDataset.setValue( "SamSung Grand" , new Double( 20 ) );   
      barDataset.setValue( "MotoG" , new Double( 40 ) );    
      barDataset.setValue( "Nokia Lumia" , new Double( 10 ) );  
      
      //create chart
       JFreeChart piechart = ChartFactory.createPieChart("mobile sales",barDataset, false,true,false);//explain
      
        PiePlot piePlot =(PiePlot) piechart.getPlot();
      
       //changing pie chart blocks colors
        piePlot.setSectionPaint("IPhone 5s", new Color(255,255,102));
        piePlot.setSectionPaint("SamSung Grand", new Color(102,255,102));
        piePlot.setSectionPaint("MotoG", new Color(255,102,153));
        piePlot.setSectionPaint("Nokia Lumia", new Color(0,204,204));
      
       
        piePlot.setBackgroundPaint(Color.white);
        
        //create chartPanel to display chart(graph)
        ChartPanel barChartPanel = new ChartPanel(piechart);
        panelBarChart.removeAll();
        panelBarChart.add(barChartPanel, BorderLayout.CENTER);
        panelBarChart.validate();
    }

    =============================================================================*/
    
    public void showLineChart(){
        //create dataset for the graph
         DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(200, "Amount", "january");
        dataset.setValue(150, "Amount", "february");
        dataset.setValue(18, "Amount", "march");
        dataset.setValue(100, "Amount", "april");
        dataset.setValue(80, "Amount", "may");
        dataset.setValue(250, "Amount", "june");
        
        //create chart
        JFreeChart linechart = ChartFactory.createLineChart("contribution","monthly","amount", 
                dataset, PlotOrientation.VERTICAL, false,true,false);
        
        //create plot object
        CategoryPlot lineCategoryPlot = linechart.getCategoryPlot();
       // lineCategoryPlot.setRangeGridlinePaint(Color.BLUE);
        lineCategoryPlot.setBackgroundPaint(Color.white);
        
        //create render object to change the moficy the line properties like color
        LineAndShapeRenderer lineRenderer = (LineAndShapeRenderer) lineCategoryPlot.getRenderer();
        Color lineChartColor = new Color(204,0,51);
        lineRenderer.setSeriesPaint(0, lineChartColor);
        
         //create chartPanel to display chart(graph)
        ChartPanel lineChartPanel = new ChartPanel(linechart);
        panelBarChart1.removeAll();
        panelBarChart1.add(lineChartPanel, BorderLayout.CENTER);
        panelBarChart1.validate();
    }

    /*========================================================================================
    
    public void showHistogram(){
        
         double[] values = { 95, 49, 14, 59, 50, 66, 47, 40, 1, 67,
                            12, 58, 28, 63, 14, 9, 31, 17, 94, 71,
                            49, 64, 73, 97, 15, 63, 10, 12, 31, 62,
                            93, 49, 74, 90, 59, 14, 15, 88, 26, 57,
                            77, 44, 58, 91, 10, 67, 57, 19, 88, 84                                
                          };
 
 
        HistogramDataset dataset = new HistogramDataset();
        dataset.addSeries("key", values, 20);
        
         JFreeChart chart = ChartFactory.createHistogram("JFreeChart Histogram","Data", "Frequency", dataset,PlotOrientation.VERTICAL, false,true,false);
            XYPlot plot= chart.getXYPlot();
        plot.setBackgroundPaint(Color.WHITE);

        
        
        ChartPanel barpChartPanel2 = new ChartPanel(chart);
        panelBarChart2.removeAll();
        panelBarChart2.add(barpChartPanel2, BorderLayout.CENTER);
        panelBarChart2.validate();
    }

    ========================================================================================*/
    
    public void showBarChart(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(200, "Amount", "january");
        dataset.setValue(150, "Amount", "february");
        dataset.setValue(18, "Amount", "march");
        dataset.setValue(100, "Amount", "april");
        dataset.setValue(80, "Amount", "may");
        dataset.setValue(250, "Amount", "june");
        
        JFreeChart chart = ChartFactory.createBarChart("contribution","monthly","amount", 
                dataset, PlotOrientation.VERTICAL, false,true,false);
        
        CategoryPlot categoryPlot = chart.getCategoryPlot();
        //categoryPlot.setRangeGridlinePaint(Color.BLUE);
        categoryPlot.setBackgroundPaint(Color.WHITE);
        BarRenderer renderer = (BarRenderer) categoryPlot.getRenderer();
        Color clr3 = new Color(204,0,51);
        renderer.setSeriesPaint(0, clr3);
        
        ChartPanel barpChartPanel = new ChartPanel(chart);
        panelBarChart3.removeAll();
        panelBarChart3.add(barpChartPanel, BorderLayout.CENTER);
        panelBarChart3.validate();
        
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSMetroTextPlaceHolderBeanInfo1 = new rojerusan.RSMetroTextPlaceHolderBeanInfo();
        jPanel1 = new javax.swing.JPanel();
        Logo = new javax.swing.JLabel();
        Shipments = new javax.swing.JLabel();
        Profile = new javax.swing.JLabel();
        DashBoard = new javax.swing.JLabel();
        DEOs = new javax.swing.JLabel();
        Order = new javax.swing.JLabel();
        DashBoardBtn = new javax.swing.JButton();
        MyProfileBtn = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        DEOsBtn = new javax.swing.JButton();
        ManageShipmentsBtn = new javax.swing.JButton();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        DashBoardPanel = new javax.swing.JPanel();
        jCalendar2 = new com.toedter.calendar.JCalendar();
        jTextField2 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        panelBarChart1 = new javax.swing.JPanel();
        panelBarChart3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        MyProfilePanel = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        rSPasswordTextPlaceHolder1 = new rojerusan.RSPasswordTextPlaceHolder();
        rSMaterialButtonRectangle1 = new rojerusan.RSMaterialButtonRectangle();
        jTextField12 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        jLabel28 = new javax.swing.JLabel();
        DEOPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        rSTableMetro2 = new rojeru_san.complementos.RSTableMetro();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        MButtonsP = new javax.swing.JPanel();
        ButtonsInv = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        rSPasswordTextPlaceHolder2 = new rojerusan.RSPasswordTextPlaceHolder();
        rSMaterialButtonRectangle2 = new rojerusan.RSMaterialButtonRectangle();
        ManageShipmentsPanel = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        rSTableMetro4 = new rojeru_san.complementos.RSTableMetro();
        jTextField13 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        MButtonsP1 = new javax.swing.JPanel();
        ButtonsInv1 = new javax.swing.JPanel();
        jButton11 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        rSPasswordTextPlaceHolder3 = new rojerusan.RSPasswordTextPlaceHolder();
        rSMaterialButtonRectangle3 = new rojerusan.RSMaterialButtonRectangle();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buds.png"))); // NOI18N
        Logo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogoMouseClicked(evt);
            }
        });
        jPanel1.add(Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 19, -1, -1));

        Shipments.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Shipments.setForeground(new java.awt.Color(255, 255, 255));
        Shipments.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-order-30.png"))); // NOI18N
        Shipments.setText(" Manage Shipments");
        Shipments.setToolTipText("");
        Shipments.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ShipmentsMouseClicked(evt);
            }
        });
        jPanel1.add(Shipments, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 180, 30));

        Profile.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Profile.setForeground(new java.awt.Color(255, 255, 255));
        Profile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-admin-settings-male-30.png"))); // NOI18N
        Profile.setText("  My Profile");
        Profile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProfileMouseClicked(evt);
            }
        });
        jPanel1.add(Profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 180, -1));

        DashBoard.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        DashBoard.setForeground(new java.awt.Color(255, 255, 255));
        DashBoard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-dashboard-30.png"))); // NOI18N
        DashBoard.setText(" DashBoard");
        DashBoard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashBoardMouseClicked(evt);
            }
        });
        jPanel1.add(DashBoard, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 180, 30));

        DEOs.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        DEOs.setForeground(new java.awt.Color(255, 255, 255));
        DEOs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-user-account-30.png"))); // NOI18N
        DEOs.setText(" Data Entry Operators");
        DEOs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DEOsMouseClicked(evt);
            }
        });
        jPanel1.add(DEOs, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 180, 30));

        Order.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Order.setForeground(new java.awt.Color(255, 255, 255));
        Order.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-ecology-30_1.png"))); // NOI18N
        Order.setText(" Approve Order");
        jPanel1.add(Order, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, 180, -1));

        DashBoardBtn.setBackground(new java.awt.Color(153, 0, 0));
        DashBoardBtn.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        DashBoardBtn.setForeground(new java.awt.Color(153, 0, 0));
        DashBoardBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashBoardBtnMouseClicked(evt);
            }
        });
        DashBoardBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DashBoardBtnActionPerformed(evt);
            }
        });
        jPanel1.add(DashBoardBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 200, 50));

        MyProfileBtn.setBackground(new java.awt.Color(153, 0, 0));
        MyProfileBtn.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        MyProfileBtn.setForeground(new java.awt.Color(153, 0, 0));
        MyProfileBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MyProfileBtnMouseClicked(evt);
            }
        });
        MyProfileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MyProfileBtnActionPerformed(evt);
            }
        });
        jPanel1.add(MyProfileBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 200, 50));

        jButton3.setBackground(new java.awt.Color(153, 0, 0));
        jButton3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(153, 0, 0));
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 200, 50));

        DEOsBtn.setBackground(new java.awt.Color(153, 0, 0));
        DEOsBtn.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        DEOsBtn.setForeground(new java.awt.Color(153, 0, 0));
        DEOsBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DEOsBtnMouseClicked(evt);
            }
        });
        DEOsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DEOsBtnActionPerformed(evt);
            }
        });
        jPanel1.add(DEOsBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 200, 50));

        ManageShipmentsBtn.setBackground(new java.awt.Color(153, 0, 0));
        ManageShipmentsBtn.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        ManageShipmentsBtn.setForeground(new java.awt.Color(153, 0, 0));
        ManageShipmentsBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ManageShipmentsBtnMouseClicked(evt);
            }
        });
        ManageShipmentsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManageShipmentsBtnActionPerformed(evt);
            }
        });
        jPanel1.add(ManageShipmentsBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 200, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1, 240, 740));

        jLayeredPane1.setBackground(new java.awt.Color(255, 255, 255));
        jLayeredPane1.setLayout(new java.awt.CardLayout());

        DashBoardPanel.setBackground(new java.awt.Color(153, 0, 0));
        DashBoardPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCalendar2.setBackground(new java.awt.Color(255, 255, 255));
        jCalendar2.setDecorationBackgroundColor(new java.awt.Color(153, 0, 0));
        jCalendar2.setSundayForeground(new java.awt.Color(0, 0, 0));
        jCalendar2.setWeekdayForeground(new java.awt.Color(255, 255, 255));
        DashBoardPanel.add(jCalendar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 420, 390, 250));

        jTextField2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jTextField2.setText("  Search");
        jTextField2.setBorder(null);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        DashBoardPanel.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 20, 170, 30));

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/search_26px.png"))); // NOI18N
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        DashBoardPanel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 20, 30, 30));

        panelBarChart1.setBackground(new java.awt.Color(255, 255, 255));
        panelBarChart1.setLayout(new java.awt.BorderLayout());
        DashBoardPanel.add(panelBarChart1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 120, 320, 250));

        panelBarChart3.setBackground(new java.awt.Color(255, 255, 255));
        panelBarChart3.setLayout(new java.awt.BorderLayout());
        DashBoardPanel.add(panelBarChart3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 580, 250));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(153, 0, 0));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 0, 0));
        jLabel3.setText("Orders Completed");
        jPanel2.add(jLabel3);

        jLabel12.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(153, 0, 0));
        jLabel12.setText("12");
        jPanel2.add(jLabel12);

        DashBoardPanel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 260, 100));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 0, 0));
        jLabel7.setText("Orders Pending");
        jPanel3.add(jLabel7);

        jLabel13.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(153, 0, 0));
        jLabel13.setText("2");
        jPanel3.add(jLabel13);

        DashBoardPanel.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, 260, 100));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 0, 0));
        jLabel10.setText("Orders InProgress");
        jPanel4.add(jLabel10);

        jLabel15.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(153, 0, 0));
        jLabel15.setText("5");
        jPanel4.add(jLabel15);

        DashBoardPanel.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 260, 100));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 0, 0));
        jLabel11.setText("Target Orders");
        jPanel5.add(jLabel11);

        jLabel14.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(153, 0, 0));
        jLabel14.setText("30");
        jPanel5.add(jLabel14);

        DashBoardPanel.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 270, 260, 100));

        jLayeredPane1.add(DashBoardPanel, "card5");

        MyProfilePanel.setBackground(new java.awt.Color(153, 0, 0));
        MyProfilePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField1.setText("admin1@gmail.com");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        MyProfilePanel.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 290, 250, -1));

        jTextField3.setText("admin");
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        MyProfilePanel.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 380, 250, -1));

        jTextField4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField4.setText("Rameen");
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        MyProfilePanel.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 200, 150, -1));

        jLabel16.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Email");
        MyProfilePanel.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 250, 120, 30));

        jLabel17.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("UserName");
        MyProfilePanel.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 380, 120, 30));

        jLabel18.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Profile Picture");
        MyProfilePanel.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 200, 120, 30));

        jTextField11.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jTextField11.setText("  Search");
        jTextField11.setBorder(null);
        jTextField11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField11ActionPerformed(evt);
            }
        });
        MyProfilePanel.add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 20, 170, 30));

        jLabel25.setBackground(new java.awt.Color(0, 0, 0));
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/search_26px.png"))); // NOI18N
        jLabel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel25MouseClicked(evt);
            }
        });
        MyProfilePanel.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 20, 30, 30));

        jLabel26.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Password");
        MyProfilePanel.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 420, 120, 30));

        rSPasswordTextPlaceHolder1.setText("pasword");
        rSPasswordTextPlaceHolder1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSPasswordTextPlaceHolder1ActionPerformed(evt);
            }
        });
        MyProfilePanel.add(rSPasswordTextPlaceHolder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 420, 250, 30));

        rSMaterialButtonRectangle1.setBackground(new java.awt.Color(255, 255, 255));
        rSMaterialButtonRectangle1.setForeground(new java.awt.Color(204, 0, 0));
        rSMaterialButtonRectangle1.setText("Save");
        rSMaterialButtonRectangle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle1ActionPerformed(evt);
            }
        });
        MyProfilePanel.add(rSMaterialButtonRectangle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 490, 100, 40));

        jTextField12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField12.setText("00000000");
        jTextField12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField12ActionPerformed(evt);
            }
        });
        MyProfilePanel.add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 290, 150, -1));

        jLabel27.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Phone");
        MyProfilePanel.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 250, 120, 30));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-user-50.png"))); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setVerifyInputWhenFocusTarget(false);
        MyProfilePanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 110, 90, 70));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(255, 255, 255));
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        MyProfilePanel.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 90, 110, 110));

        jLabel28.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Name");
        MyProfilePanel.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, 120, 30));

        jLayeredPane1.add(MyProfilePanel, "card3");

        DEOPanel.setBackground(new java.awt.Color(153, 0, 0));
        DEOPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSTableMetro2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name", "Tasks Done", "Status", "Title 4"
            }
        ));
        rSTableMetro2.setColorBackgoundHead(new java.awt.Color(153, 0, 0));
        jScrollPane2.setViewportView(rSTableMetro2);

        DEOPanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 380, 790, 230));

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        DEOPanel.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 90, 200, -1));

        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        DEOPanel.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, 180, -1));

        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        DEOPanel.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 180, -1));

        jLabel19.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Email");
        DEOPanel.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 80, 100, 40));

        jLabel20.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("UserName");
        DEOPanel.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 110, 40));

        jLabel21.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Name");
        DEOPanel.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 110, 40));

        MButtonsP.setBackground(new java.awt.Color(255, 255, 255));
        MButtonsP.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 5));

        ButtonsInv.setBackground(new java.awt.Color(255, 255, 255));
        ButtonsInv.setLayout(new java.awt.GridLayout(1, 0, 30, 0));

        jButton1.setBackground(new java.awt.Color(153, 0, 0));
        jButton1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Add");
        ButtonsInv.add(jButton1);

        jButton2.setBackground(new java.awt.Color(153, 0, 0));
        jButton2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Edit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        ButtonsInv.add(jButton2);

        jButton4.setBackground(new java.awt.Color(153, 0, 0));
        jButton4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Delete");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        ButtonsInv.add(jButton4);

        jButton5.setBackground(new java.awt.Color(153, 0, 0));
        jButton5.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Save");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        ButtonsInv.add(jButton5);

        MButtonsP.add(ButtonsInv);

        DEOPanel.add(MButtonsP, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, -1, -1));

        jLabel29.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Password");
        DEOPanel.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 130, 100, 40));

        rSPasswordTextPlaceHolder2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSPasswordTextPlaceHolder2ActionPerformed(evt);
            }
        });
        DEOPanel.add(rSPasswordTextPlaceHolder2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 140, 200, 30));

        rSMaterialButtonRectangle2.setBackground(new java.awt.Color(255, 255, 255));
        rSMaterialButtonRectangle2.setForeground(new java.awt.Color(204, 0, 0));
        rSMaterialButtonRectangle2.setText("Save Changes");
        rSMaterialButtonRectangle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle2ActionPerformed(evt);
            }
        });
        DEOPanel.add(rSMaterialButtonRectangle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 300, 140, 40));

        jLayeredPane1.add(DEOPanel, "card4");

        ManageShipmentsPanel.setBackground(new java.awt.Color(153, 0, 0));
        ManageShipmentsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSTableMetro4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Quantity", "OrderedBy", "Order Date"
            }
        ));
        rSTableMetro4.setColorBackgoundHead(new java.awt.Color(153, 0, 0));
        jScrollPane4.setViewportView(rSTableMetro4);

        ManageShipmentsPanel.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 380, 790, 230));

        jTextField13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField13ActionPerformed(evt);
            }
        });
        ManageShipmentsPanel.add(jTextField13, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 90, 200, -1));

        jTextField14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField14ActionPerformed(evt);
            }
        });
        ManageShipmentsPanel.add(jTextField14, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, 180, -1));

        jTextField15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField15ActionPerformed(evt);
            }
        });
        ManageShipmentsPanel.add(jTextField15, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 180, -1));

        jLabel30.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("OrderedBy:");
        ManageShipmentsPanel.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 80, 100, 40));

        jLabel31.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Quanitiy:");
        ManageShipmentsPanel.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 110, 40));

        jLabel32.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("ID:");
        ManageShipmentsPanel.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 110, 40));

        MButtonsP1.setBackground(new java.awt.Color(255, 255, 255));
        MButtonsP1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 5));

        ButtonsInv1.setBackground(new java.awt.Color(255, 255, 255));
        ButtonsInv1.setLayout(new java.awt.GridLayout(1, 0, 30, 0));

        jButton11.setBackground(new java.awt.Color(153, 0, 0));
        jButton11.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setText("View");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        ButtonsInv1.add(jButton11);

        jButton6.setBackground(new java.awt.Color(153, 0, 0));
        jButton6.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Add");
        ButtonsInv1.add(jButton6);

        jButton7.setBackground(new java.awt.Color(153, 0, 0));
        jButton7.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Edit");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        ButtonsInv1.add(jButton7);

        jButton8.setBackground(new java.awt.Color(153, 0, 0));
        jButton8.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Delete");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        ButtonsInv1.add(jButton8);

        jButton9.setBackground(new java.awt.Color(153, 0, 0));
        jButton9.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("Save");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        ButtonsInv1.add(jButton9);

        MButtonsP1.add(ButtonsInv1);

        ManageShipmentsPanel.add(MButtonsP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, -1, -1));

        jLabel33.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Order Date:");
        ManageShipmentsPanel.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 130, 100, 40));

        rSPasswordTextPlaceHolder3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSPasswordTextPlaceHolder3ActionPerformed(evt);
            }
        });
        ManageShipmentsPanel.add(rSPasswordTextPlaceHolder3, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 140, 200, 30));

        rSMaterialButtonRectangle3.setBackground(new java.awt.Color(255, 255, 255));
        rSMaterialButtonRectangle3.setForeground(new java.awt.Color(204, 0, 0));
        rSMaterialButtonRectangle3.setText("Save Changes");
        rSMaterialButtonRectangle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle3ActionPerformed(evt);
            }
        });
        ManageShipmentsPanel.add(rSMaterialButtonRectangle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 300, 140, 40));

        jLayeredPane1.add(ManageShipmentsPanel, "card4");

        getContentPane().add(jLayeredPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 1130, 710));

        setSize(new java.awt.Dimension(1385, 751));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void DashBoardBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashBoardBtnMouseClicked
        switchPanel(DashBoardPanel);
    }//GEN-LAST:event_DashBoardBtnMouseClicked

    private void DashBoardBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DashBoardBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DashBoardBtnActionPerformed

    private void MyProfileBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MyProfileBtnMouseClicked
        switchPanel(MyProfilePanel);
    }//GEN-LAST:event_MyProfileBtnMouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        switchPanel(MyProfilePanel);
    }//GEN-LAST:event_jButton3MouseClicked

    private void DEOsBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DEOsBtnMouseClicked
        switchPanel(MyProfilePanel);
    }//GEN-LAST:event_DEOsBtnMouseClicked

    private void DEOsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DEOsBtnActionPerformed
        
    }//GEN-LAST:event_DEOsBtnActionPerformed

    private void ManageShipmentsBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ManageShipmentsBtnMouseClicked
        switchPanel(ManageShipmentsPanel);
    }//GEN-LAST:event_ManageShipmentsBtnMouseClicked

    private void ManageShipmentsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManageShipmentsBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ManageShipmentsBtnActionPerformed

    private void ProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProfileMouseClicked
        switchPanel(MyProfilePanel);
    }//GEN-LAST:event_ProfileMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void MyProfileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MyProfileBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MyProfileBtnActionPerformed

    private void LogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoMouseClicked
        switchPanel(DashBoardPanel);
    }//GEN-LAST:event_LogoMouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void DEOsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DEOsMouseClicked
        switchPanel(DEOPanel);
    }//GEN-LAST:event_DEOsMouseClicked

    private void ShipmentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ShipmentsMouseClicked
        switchPanel(ManageShipmentsPanel);
    }//GEN-LAST:event_ShipmentsMouseClicked

    private void DashBoardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashBoardMouseClicked
        switchPanel(DashBoardPanel);// TODO add your handling code here:
    }//GEN-LAST:event_DashBoardMouseClicked

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jTextField11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11ActionPerformed

    private void jLabel25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel25MouseClicked

    private void rSPasswordTextPlaceHolder1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSPasswordTextPlaceHolder1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSPasswordTextPlaceHolder1ActionPerformed

    private void rSMaterialButtonRectangle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonRectangle1ActionPerformed

    private void jTextField12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12ActionPerformed

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void rSPasswordTextPlaceHolder2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSPasswordTextPlaceHolder2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSPasswordTextPlaceHolder2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void rSMaterialButtonRectangle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonRectangle2ActionPerformed

    private void jTextField13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField13ActionPerformed

    private void jTextField14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField14ActionPerformed

    private void jTextField15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField15ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void rSPasswordTextPlaceHolder3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSPasswordTextPlaceHolder3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSPasswordTextPlaceHolder3ActionPerformed

    private void rSMaterialButtonRectangle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonRectangle3ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

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
            java.util.logging.Logger.getLogger(APage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(APage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(APage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(APage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new APage().setVisible(true);
            }
        });
    }
        
    public void switchPanel(JPanel panel)
    {
        jLayeredPane1.removeAll();
        jLayeredPane1.add(panel);
        jLayeredPane1.repaint();
        jLayeredPane1.revalidate();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ButtonsInv;
    private javax.swing.JPanel ButtonsInv1;
    private javax.swing.JPanel DEOPanel;
    private javax.swing.JLabel DEOs;
    private javax.swing.JButton DEOsBtn;
    private javax.swing.JLabel DashBoard;
    private javax.swing.JButton DashBoardBtn;
    private javax.swing.JPanel DashBoardPanel;
    private javax.swing.JLabel Logo;
    private javax.swing.JPanel MButtonsP;
    private javax.swing.JPanel MButtonsP1;
    private javax.swing.JButton ManageShipmentsBtn;
    private javax.swing.JPanel ManageShipmentsPanel;
    private javax.swing.JButton MyProfileBtn;
    private javax.swing.JPanel MyProfilePanel;
    private javax.swing.JLabel Order;
    private javax.swing.JLabel Profile;
    private javax.swing.JLabel Shipments;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private com.toedter.calendar.JCalendar jCalendar2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JPanel panelBarChart1;
    private javax.swing.JPanel panelBarChart3;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle1;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle2;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle3;
    private rojerusan.RSMetroTextPlaceHolderBeanInfo rSMetroTextPlaceHolderBeanInfo1;
    private rojerusan.RSPasswordTextPlaceHolder rSPasswordTextPlaceHolder1;
    private rojerusan.RSPasswordTextPlaceHolder rSPasswordTextPlaceHolder2;
    private rojerusan.RSPasswordTextPlaceHolder rSPasswordTextPlaceHolder3;
    private rojeru_san.complementos.RSTableMetro rSTableMetro2;
    private rojeru_san.complementos.RSTableMetro rSTableMetro4;
    // End of variables declaration//GEN-END:variables

}
