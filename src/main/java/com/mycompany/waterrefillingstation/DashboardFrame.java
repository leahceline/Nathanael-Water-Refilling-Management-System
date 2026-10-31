/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.waterrefillingstation;

/**
 *
 * @author user
 */
public class DashboardFrame extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(DashboardFrame.class.getName());

    /**
     * Creates new form DashboardFrame
     */
    public DashboardFrame() {
        initComponents();
        
        tblTodayTransactions.setDefaultEditor(Object.class, null);
        tblTodayTransactions.getTableHeader().setFont(
            new java.awt.Font("SansSerif", java.awt.Font.BOLD, 13)
        );          
        tblTodayTransactions.getTableHeader().setPreferredSize(
            new java.awt.Dimension(0, 32)
        );
        tblTodayTransactions.getTableHeader().setBackground(
            new java.awt.Color(225, 240, 250)
        );
        tblTodayTransactions.getTableHeader().setForeground(
            new java.awt.Color(8, 82, 150)
        );
        setupDashboardIcons();
        btnDashboard.setFocusPainted(false);
        getContentPane().setLayout(new java.awt.BorderLayout());

        getContentPane().removeAll();

        getContentPane().add(pnlSidebar, java.awt.BorderLayout.WEST);
        getContentPane().add(pnlMain, java.awt.BorderLayout.CENTER);
        
        getContentPane().revalidate();
        getContentPane().repaint();
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        loadTodayTransactions();
        loadDashboardCounts();
        applyRolePermissions();
    }
    
    private void setupDashboardIcons() {

        try {
            java.awt.Image customerImage =
                    new javax.swing.ImageIcon(
                            getClass().getResource(
                                    "/images/customers_icon_100x100.png"
                            )
                    ).getImage();

            java.awt.Image productImage =
                    new javax.swing.ImageIcon(
                            getClass().getResource(
                                    "/images/products_icon_100x100.png"
                            )
                    ).getImage();

            lblCustomerIcon.setIcon(
                    new javax.swing.ImageIcon(customerImage)
            );

            lblProductIcon.setIcon(
                    new javax.swing.ImageIcon(productImage)
            );

            lblCustomerIcon.setHorizontalAlignment(
                    javax.swing.SwingConstants.CENTER
            );

            lblProductIcon.setHorizontalAlignment(
                    javax.swing.SwingConstants.CENTER
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void loadTodayTransactions() {

    DashboardDAO dao = new DashboardDAO();

    java.util.List<String[]> transactions =
            dao.getTodayTransactions();

    javax.swing.table.DefaultTableModel model =
            (javax.swing.table.DefaultTableModel)
            tblTodayTransactions.getModel();
    
    model.setRowCount(0);

    for (String[] transaction : transactions) {
        model.addRow(transaction);
    }
}
    
    private void loadDashboardCounts() {

        DashboardDAO dao = new DashboardDAO();

        int customerCount = dao.getCustomerCount();
        int productCount = dao.getProductCount();
        int todayTransactionCount = dao.getTodayTransactions().size();
        int pendingDeliveryCount = dao.getPendingDeliveryCount();

        lblCustomerCount.setText(
                String.valueOf(customerCount)
        );

        lblProductCount.setText(
                String.valueOf(productCount)
        );

        lblTodayTransactionCount.setText(
                String.valueOf(todayTransactionCount)
        );

        lblPendingDeliveryCount.setText(
                String.valueOf(pendingDeliveryCount)
        );
    }
    
    private void applyRolePermissions() {

    String role = UserSession.getRole();

    if (role == null) {
        return;
    }

    User currentUser;

    if (role.equalsIgnoreCase("Admin")) {

        currentUser = new AdminUser(
                UserSession.getUserId(),
                UserSession.getUsername()
        );

    } else {

        currentUser = new StaffUser(
                UserSession.getUserId(),
                UserSession.getUsername()
        );
    }

    // Same User reference, different behavior
    btnCustomers.setEnabled(true);
    btnOrders.setEnabled(true);
    btnReports.setEnabled(true);

    btnProducts.setEnabled(
            currentUser.canManageProducts()
    );

    btnArchive.setEnabled(
            currentUser.canAccessArchive()
    );
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlSidebar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnDashboard = new javax.swing.JButton();
        btnCustomers = new javax.swing.JButton();
        btnProducts = new javax.swing.JButton();
        btnOrders = new javax.swing.JButton();
        btnArchive = new javax.swing.JButton();
        btnReports = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        pnlMain = new javax.swing.JPanel();
        lblDashboardTitle = new javax.swing.JLabel();
        lblTodayTransactions = new javax.swing.JLabel();
        pnlCustomers = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblCustomerCount = new javax.swing.JLabel();
        lblCustomerIcon = new javax.swing.JLabel();
        lblCustomerDescription = new javax.swing.JLabel();
        pnlProducts = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lblProductCount = new javax.swing.JLabel();
        lblProductIcon = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTodayTransactions = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        cmbDashboardDeliveryStatus = new javax.swing.JComboBox<>();
        btnUpdateDeliveryStatus = new javax.swing.JButton();
        pnlTodayTransactions = new javax.swing.JPanel();
        lblTodayTransactionTitle = new javax.swing.JLabel();
        lblTodayTransactionIcon = new javax.swing.JLabel();
        lblTodayTransactionCount = new javax.swing.JLabel();
        lblTodayTransactionDescription = new javax.swing.JLabel();
        pnlPendingDeliveries = new javax.swing.JPanel();
        lblPendingDeliveryIcon = new javax.swing.JLabel();
        lblPendingDeliveryTitle = new javax.swing.JLabel();
        lblPendingDeliveryCount = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblDashboardSubtitle = new javax.swing.JLabel();
        lblTransactionSubtitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlSidebar.setBackground(new java.awt.Color(8, 82, 150));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("NATHANAEL");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("WATER REFILLING");

        btnDashboard.setBackground(new java.awt.Color(43, 145, 255));
        btnDashboard.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnDashboard.setForeground(new java.awt.Color(255, 255, 255));
        btnDashboard.setText("Dashboard");
        btnDashboard.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnDashboard.addActionListener(this::btnDashboardActionPerformed);

        btnCustomers.setBackground(new java.awt.Color(8, 82, 150));
        btnCustomers.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnCustomers.setForeground(new java.awt.Color(255, 255, 255));
        btnCustomers.setText("Customers");
        btnCustomers.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnCustomers.addActionListener(this::btnCustomersActionPerformed);

        btnProducts.setBackground(new java.awt.Color(8, 82, 150));
        btnProducts.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnProducts.setForeground(new java.awt.Color(255, 255, 255));
        btnProducts.setText("Products");
        btnProducts.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnProducts.addActionListener(this::btnProductsActionPerformed);

        btnOrders.setBackground(new java.awt.Color(8, 82, 150));
        btnOrders.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnOrders.setForeground(new java.awt.Color(255, 255, 255));
        btnOrders.setText("Orders");
        btnOrders.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnOrders.addActionListener(this::btnOrdersActionPerformed);

        btnArchive.setBackground(new java.awt.Color(8, 82, 150));
        btnArchive.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnArchive.setForeground(new java.awt.Color(255, 255, 255));
        btnArchive.setText("Archive");
        btnArchive.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnArchive.addActionListener(this::btnArchiveActionPerformed);

        btnReports.setBackground(new java.awt.Color(8, 82, 150));
        btnReports.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnReports.setForeground(new java.awt.Color(255, 255, 255));
        btnReports.setText("Reports");
        btnReports.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnReports.addActionListener(this::btnReportsActionPerformed);

        btnLogout.setBackground(new java.awt.Color(8, 82, 150));
        btnLogout.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(255, 255, 255));
        btnLogout.setText("Logout");
        btnLogout.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnLogout.addActionListener(this::btnLogoutActionPerformed);

        javax.swing.GroupLayout pnlSidebarLayout = new javax.swing.GroupLayout(pnlSidebar);
        pnlSidebar.setLayout(pnlSidebarLayout);
        pnlSidebarLayout.setHorizontalGroup(
            pnlSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSidebarLayout.createSequentialGroup()
                .addGroup(pnlSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSidebarLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(pnlSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnLogout, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnReports, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnArchive, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnOrders, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnProducts, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCustomers, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDashboard, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))))
                    .addGroup(pnlSidebarLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel1)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        pnlSidebarLayout.setVerticalGroup(
            pnlSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSidebarLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(41, 41, 41)
                .addComponent(btnDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCustomers, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnOrders, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnArchive, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnReports, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1034, Short.MAX_VALUE))
        );

        pnlMain.setBackground(new java.awt.Color(205, 235, 248));

        lblDashboardTitle.setFont(new java.awt.Font("SansSerif", 1, 32)); // NOI18N
        lblDashboardTitle.setForeground(new java.awt.Color(8, 82, 150));
        lblDashboardTitle.setText("Dashboard");

        lblTodayTransactions.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        lblTodayTransactions.setForeground(new java.awt.Color(8, 82, 150));
        lblTodayTransactions.setText("Today's Transactions");

        pnlCustomers.setBackground(new java.awt.Color(255, 255, 255));
        pnlCustomers.setPreferredSize(new java.awt.Dimension(280, 120));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(8, 82, 150));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("CUSTOMERS");

        lblCustomerCount.setFont(new java.awt.Font("SansSerif", 1, 32)); // NOI18N
        lblCustomerCount.setForeground(new java.awt.Color(8, 82, 150));
        lblCustomerCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCustomerCount.setText("0");

        lblCustomerIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCustomerIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/customers_icon_100x100.png"))); // NOI18N
        lblCustomerIcon.setPreferredSize(new java.awt.Dimension(110, 110));

        lblCustomerDescription.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        lblCustomerDescription.setForeground(new java.awt.Color(8, 82, 150));
        lblCustomerDescription.setText("Total Registered Customers");

        javax.swing.GroupLayout pnlCustomersLayout = new javax.swing.GroupLayout(pnlCustomers);
        pnlCustomers.setLayout(pnlCustomersLayout);
        pnlCustomersLayout.setHorizontalGroup(
            pnlCustomersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCustomersLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCustomerIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCustomersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(pnlCustomersLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblCustomerCount, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblCustomerDescription))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        pnlCustomersLayout.setVerticalGroup(
            pnlCustomersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCustomersLayout.createSequentialGroup()
                .addGroup(pnlCustomersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlCustomersLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCustomerCount, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblCustomerDescription))
                    .addGroup(pnlCustomersLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblCustomerIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(24, 24, 24))
        );

        pnlProducts.setBackground(new java.awt.Color(255, 255, 255));
        pnlProducts.setPreferredSize(new java.awt.Dimension(280, 120));

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(8, 82, 150));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("PRODUCTS");

        lblProductCount.setFont(new java.awt.Font("SansSerif", 1, 32)); // NOI18N
        lblProductCount.setForeground(new java.awt.Color(8, 82, 150));
        lblProductCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProductCount.setText("2");

        lblProductIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProductIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/products_icon_100x100.png"))); // NOI18N
        lblProductIcon.setPreferredSize(new java.awt.Dimension(110, 110));

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(8, 82, 150));
        jLabel6.setText("Available Products");

        javax.swing.GroupLayout pnlProductsLayout = new javax.swing.GroupLayout(pnlProducts);
        pnlProducts.setLayout(pnlProductsLayout);
        pnlProductsLayout.setHorizontalGroup(
            pnlProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProductsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addGroup(pnlProductsLayout.createSequentialGroup()
                        .addComponent(lblProductIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pnlProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlProductsLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel5))
                            .addGroup(pnlProductsLayout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(lblProductCount, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        pnlProductsLayout.setVerticalGroup(
            pnlProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProductsLayout.createSequentialGroup()
                .addGroup(pnlProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblProductIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlProductsLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblProductCount, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(210, 225, 235)));

        tblTodayTransactions.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        tblTodayTransactions.setForeground(new java.awt.Color(8, 82, 150));
        tblTodayTransactions.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID", "Customer", "Date", "Order Type", "Delivery Status ", "Delivery Fee", "Total"
            }
        ));
        tblTodayTransactions.setGridColor(new java.awt.Color(230, 230, 238));
        tblTodayTransactions.setRowHeight(30);
        tblTodayTransactions.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tblTodayTransactions);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(8, 82, 150));
        jLabel4.setText("Delivery Status:");

        cmbDashboardDeliveryStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pending", "Out for Delivery", "Delivered", "Cancelled" }));
        cmbDashboardDeliveryStatus.addActionListener(this::cmbDashboardDeliveryStatusActionPerformed);

        btnUpdateDeliveryStatus.setBackground(new java.awt.Color(43, 145, 255));
        btnUpdateDeliveryStatus.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnUpdateDeliveryStatus.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateDeliveryStatus.setText("Update Status");
        btnUpdateDeliveryStatus.setFocusPainted(false);
        btnUpdateDeliveryStatus.addActionListener(this::btnUpdateDeliveryStatusActionPerformed);

        pnlTodayTransactions.setBackground(new java.awt.Color(255, 255, 255));
        pnlTodayTransactions.setPreferredSize(new java.awt.Dimension(280, 120));

        lblTodayTransactionTitle.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        lblTodayTransactionTitle.setForeground(new java.awt.Color(8, 82, 150));
        lblTodayTransactionTitle.setText("TODAY'S TRANSACTIONS");

        lblTodayTransactionIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTodayTransactionIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/today_transactions_icon_80x80 (1).png"))); // NOI18N

        lblTodayTransactionCount.setFont(new java.awt.Font("SansSerif", 1, 28)); // NOI18N
        lblTodayTransactionCount.setForeground(new java.awt.Color(8, 82, 150));
        lblTodayTransactionCount.setText("8");

        lblTodayTransactionDescription.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        lblTodayTransactionDescription.setForeground(new java.awt.Color(8, 82, 150));
        lblTodayTransactionDescription.setText("Completed Orders");

        javax.swing.GroupLayout pnlTodayTransactionsLayout = new javax.swing.GroupLayout(pnlTodayTransactions);
        pnlTodayTransactions.setLayout(pnlTodayTransactionsLayout);
        pnlTodayTransactionsLayout.setHorizontalGroup(
            pnlTodayTransactionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTodayTransactionsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTodayTransactionIcon)
                .addGroup(pnlTodayTransactionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTodayTransactionsLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(lblTodayTransactionCount, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlTodayTransactionsLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlTodayTransactionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTodayTransactionTitle)
                            .addGroup(pnlTodayTransactionsLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(lblTodayTransactionDescription)))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        pnlTodayTransactionsLayout.setVerticalGroup(
            pnlTodayTransactionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTodayTransactionsLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlTodayTransactionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblTodayTransactionIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlTodayTransactionsLayout.createSequentialGroup()
                        .addComponent(lblTodayTransactionTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTodayTransactionCount)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTodayTransactionDescription)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlPendingDeliveries.setBackground(new java.awt.Color(255, 255, 255));

        lblPendingDeliveryIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPendingDeliveryIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pending_deliveries_icon_80x80.png"))); // NOI18N
        lblPendingDeliveryIcon.setPreferredSize(new java.awt.Dimension(280, 120));

        lblPendingDeliveryTitle.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        lblPendingDeliveryTitle.setForeground(new java.awt.Color(8, 82, 150));
        lblPendingDeliveryTitle.setText("PENDING DELIVERIES");

        lblPendingDeliveryCount.setFont(new java.awt.Font("SansSerif", 1, 28)); // NOI18N
        lblPendingDeliveryCount.setForeground(new java.awt.Color(8, 82, 150));
        lblPendingDeliveryCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPendingDeliveryCount.setText("0");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(8, 82, 150));
        jLabel7.setText("Pending / Out for Delivery");

        javax.swing.GroupLayout pnlPendingDeliveriesLayout = new javax.swing.GroupLayout(pnlPendingDeliveries);
        pnlPendingDeliveries.setLayout(pnlPendingDeliveriesLayout);
        pnlPendingDeliveriesLayout.setHorizontalGroup(
            pnlPendingDeliveriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPendingDeliveriesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPendingDeliveryIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnlPendingDeliveriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPendingDeliveriesLayout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(lblPendingDeliveryCount, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlPendingDeliveriesLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPendingDeliveryTitle))
                    .addGroup(pnlPendingDeliveriesLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        pnlPendingDeliveriesLayout.setVerticalGroup(
            pnlPendingDeliveriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPendingDeliveriesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblPendingDeliveryIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
            .addGroup(pnlPendingDeliveriesLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(lblPendingDeliveryTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPendingDeliveryCount)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblDashboardSubtitle.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        lblDashboardSubtitle.setForeground(new java.awt.Color(8, 82, 150));
        lblDashboardSubtitle.setText("Welcome back! Here's what's happening today.");

        lblTransactionSubtitle.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        lblTransactionSubtitle.setForeground(new java.awt.Color(8, 82, 150));
        lblTransactionSubtitle.setText("Latest orders and deliveries for today");

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlCustomers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(pnlProducts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(pnlTodayTransactions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(pnlPendingDeliveries, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(970, 970, 970))
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTransactionSubtitle)
                    .addComponent(lblTodayTransactions))
                .addGap(494, 494, 494)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cmbDashboardDeliveryStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUpdateDeliveryStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDashboardTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDashboardSubtitle)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1321, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(lblDashboardTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDashboardSubtitle)
                .addGap(74, 74, 74)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlPendingDeliveries, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlTodayTransactions, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                    .addComponent(pnlProducts, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                    .addComponent(pnlCustomers, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTodayTransactions)
                    .addComponent(jLabel4)
                    .addComponent(cmbDashboardDeliveryStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdateDeliveryStatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTransactionSubtitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(393, 393, 393))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlSidebar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlSidebar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOrdersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdersActionPerformed
        // TODO add your handling code here:
        OrderPaymentFrame order = new OrderPaymentFrame();
        order.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnOrdersActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        UserSession.clear();

        LoginFrame login = new LoginFrame();
        login.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnCustomersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomersActionPerformed
        // TODO add your handling code here:
        CustomerFrame customer = new CustomerFrame();
        customer.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCustomersActionPerformed

    private void btnProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductsActionPerformed
        ProductFrame product = new ProductFrame();
        product.setVisible(true);
        //this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_btnProductsActionPerformed

    private void btnArchiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArchiveActionPerformed
        ArchiveFrame archive = new ArchiveFrame();
        archive.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnArchiveActionPerformed

    private void btnReportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportsActionPerformed
        ReportFrame report = new ReportFrame();
        report.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnReportsActionPerformed

    private void btnDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDashboardActionPerformed
        loadTodayTransactions();
        loadDashboardCounts();
    }//GEN-LAST:event_btnDashboardActionPerformed

    private void btnUpdateDeliveryStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateDeliveryStatusActionPerformed
        int selectedRow = tblTodayTransactions.getSelectedRow();

        if (selectedRow == -1) {
            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Please select a transaction first."
            );
            return;
        }

        String orderType =
                tblTodayTransactions.getValueAt(selectedRow, 3).toString();

        if (!orderType.equalsIgnoreCase("Delivery")) {
            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Only delivery transactions can have a delivery status."
            );
            return;
        }

        int orderId = Integer.parseInt(
                tblTodayTransactions.getValueAt(selectedRow, 0).toString()
        );

        String newStatus =
                cmbDashboardDeliveryStatus.getSelectedItem().toString();

        DashboardDAO dao = new DashboardDAO();

        boolean success =
                dao.updateDeliveryStatus(orderId, newStatus);

        if (success) {
            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Delivery status updated successfully!"
            );

            loadTodayTransactions();

        } else {
            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Failed to update delivery status."
            );
        }    
    }//GEN-LAST:event_btnUpdateDeliveryStatusActionPerformed

    private void cmbDashboardDeliveryStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDashboardDeliveryStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbDashboardDeliveryStatusActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new DashboardFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnArchive;
    private javax.swing.JButton btnCustomers;
    private javax.swing.JButton btnDashboard;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnOrders;
    private javax.swing.JButton btnProducts;
    private javax.swing.JButton btnReports;
    private javax.swing.JButton btnUpdateDeliveryStatus;
    private javax.swing.JComboBox<String> cmbDashboardDeliveryStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCustomerCount;
    private javax.swing.JLabel lblCustomerDescription;
    private javax.swing.JLabel lblCustomerIcon;
    private javax.swing.JLabel lblDashboardSubtitle;
    private javax.swing.JLabel lblDashboardTitle;
    private javax.swing.JLabel lblPendingDeliveryCount;
    private javax.swing.JLabel lblPendingDeliveryIcon;
    private javax.swing.JLabel lblPendingDeliveryTitle;
    private javax.swing.JLabel lblProductCount;
    private javax.swing.JLabel lblProductIcon;
    private javax.swing.JLabel lblTodayTransactionCount;
    private javax.swing.JLabel lblTodayTransactionDescription;
    private javax.swing.JLabel lblTodayTransactionIcon;
    private javax.swing.JLabel lblTodayTransactionTitle;
    private javax.swing.JLabel lblTodayTransactions;
    private javax.swing.JLabel lblTransactionSubtitle;
    private javax.swing.JPanel pnlCustomers;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlPendingDeliveries;
    private javax.swing.JPanel pnlProducts;
    private javax.swing.JPanel pnlSidebar;
    private javax.swing.JPanel pnlTodayTransactions;
    private javax.swing.JTable tblTodayTransactions;
    // End of variables declaration//GEN-END:variables
}
