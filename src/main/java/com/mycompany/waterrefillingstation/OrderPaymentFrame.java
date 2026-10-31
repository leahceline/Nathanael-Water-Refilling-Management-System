/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.waterrefillingstation;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author user
 */
public class OrderPaymentFrame extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(OrderPaymentFrame.class.getName());

    /**tblProducts
     * Creates new form OrderPaymentFrame
     */
    public OrderPaymentFrame() {
        initComponents();
        
        tblOrderItems.setDefaultEditor(Object.class, null);
        getContentPane().setBackground(
                new java.awt.Color(205, 235, 248)
        );
        getContentPane().setLayout(null);
        applyOrderPaymentStyle();
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        javax.swing.SwingUtilities.invokeLater(() -> {
            centerOrderPaymentComponents();
        });

        addComponentListener(
                new java.awt.event.ComponentAdapter() {
                    @Override
                    public void componentResized(
                            java.awt.event.ComponentEvent evt) {

                        centerOrderPaymentComponents();
                    }
                }
            );
            loadCustomers();
            loadProducts();
            cmbPaymentMethodActionPerformed(null);
            
            java.awt.Color blue =
        new java.awt.Color(43, 145, 225);

java.awt.Color darkBlue =
        new java.awt.Color(0, 83, 150);

java.awt.Color white =
        java.awt.Color.WHITE;

        btnBack.setBackground(blue);
btnBack.setForeground(white);
btnBack.setFont(
        new java.awt.Font("SansSerif", java.awt.Font.BOLD, 14)
);
btnBack.setFocusPainted(false);

btnAddItem.setBackground(blue);
btnAddItem.setForeground(white);
btnAddItem.setFont(
        new java.awt.Font("SansSerif", java.awt.Font.BOLD, 14)
);
btnAddItem.setFocusPainted(false);

btnProcessTransaction.setBackground(blue);
btnProcessTransaction.setForeground(white);
btnProcessTransaction.setFont(
        new java.awt.Font("SansSerif", java.awt.Font.BOLD, 14)
);
btnProcessTransaction.setFocusPainted(false);

btnClear.setBackground(blue);
btnClear.setForeground(white);
btnClear.setFont(
        new java.awt.Font("SansSerif", java.awt.Font.BOLD, 14)
);
btnClear.setFocusPainted(false);
        }
    
    private void applyOrderPaymentStyle() {

    // =========================
    // COLORS
    // =========================
    java.awt.Color lightBlue =
            new java.awt.Color(205, 235, 248);

    java.awt.Color mainBlue =
            new java.awt.Color(43, 145, 225);

    java.awt.Color darkBlue =
            new java.awt.Color(0, 82, 150);

    java.awt.Color white =
            java.awt.Color.WHITE;

    // =========================
    // BACKGROUND
    // =========================
    getContentPane().setBackground(lightBlue);

    // =========================
    // MAIN TITLE
    // =========================
    lblOrderPaymentTitle.setFont(
            new java.awt.Font(
                    "SansSerif",
                    java.awt.Font.BOLD,
                    28
            )
    );

    lblOrderPaymentTitle.setForeground(darkBlue);

    lblOrderPaymentTitle.setHorizontalAlignment(
            javax.swing.SwingConstants.CENTER
    );
    
    jLabel1.setForeground(darkBlue);
    jLabel2.setForeground(darkBlue);
    jLabel3.setForeground(darkBlue);
    jLabel4.setForeground(darkBlue);
    jLabel5.setForeground(darkBlue);
    jLabel6.setForeground(darkBlue);
    jLabel7.setForeground(darkBlue);
    jLabel8.setForeground(darkBlue);
    jLabel9.setForeground(darkBlue);
    jLabel10.setForeground(darkBlue);
    jLabel11.setForeground(darkBlue);
    jLabel12.setForeground(darkBlue);
    jLabel13.setForeground(darkBlue);

    lblDeliveryAddress.setForeground(darkBlue);
    lblReferenceCode.setForeground(darkBlue);

    // =========================
    // LABELS
    // =========================
    javax.swing.JLabel[] labels = {
        jLabel1,
        jLabel2,
        jLabel3,
        jLabel4,
        jLabel5,
        jLabel6,
        jLabel7,
        jLabel8,
        jLabel9,
        jLabel10,
        jLabel11,
        jLabel12,
        jLabel13,
        lblDeliveryAddress,
        lblReferenceCode
    };

    for (javax.swing.JLabel label : labels) {

        label.setFont(
                new java.awt.Font(
                        "SansSerif",
                        java.awt.Font.BOLD,
                        14
                )
        );

        label.setForeground(darkBlue);
    }

    // =========================
    // TEXT FIELDS
    // =========================
    javax.swing.JTextField[] fields = {
        txtSearchCustomer,
        txtPrice,
        txtQuantity,
        txtAmountPaid,
        txtDeliveryAddress,
        txtReferenceCode
    };

    for (javax.swing.JTextField field : fields) {

        field.setBackground(white);
        field.setForeground(java.awt.Color.BLACK);

        field.setFont(
                new java.awt.Font(
                        "SansSerif",
                        java.awt.Font.PLAIN,
                        13
                )
        );
    }

    // =========================
    // COMBO BOXES
    // =========================
    javax.swing.JComboBox<?>[] combos = {
        cmbCustomer,
        cmbProduct,
        cmbOrderType,
        cmbDeliveryStatus,
        cmbPaymentMethod
    };

    for (javax.swing.JComboBox<?> combo : combos) {

        combo.setBackground(white);
        combo.setForeground(java.awt.Color.BLACK);

        combo.setFont(
                new java.awt.Font(
                        "SansSerif",
                        java.awt.Font.PLAIN,
                        13
                )
        );
    }

    // =========================
    // BUTTONS
    // =========================
    styleOrderButton(btnAddItem, mainBlue, white);
    styleOrderButton(btnProcessTransaction, mainBlue, white);
    styleOrderButton(btnClear, mainBlue, white);
    styleOrderButton(btnBack, mainBlue, white);

    // =========================
    // TABLE
    // =========================
    tblOrderItems.setBackground(white);
    tblOrderItems.setForeground(java.awt.Color.BLACK);

    tblOrderItems.setFont(
            new java.awt.Font(
                    "SansSerif",
                    java.awt.Font.PLAIN,
                    13
            )
    );

    tblOrderItems.setRowHeight(32);

    tblOrderItems.setFocusable(false);

    tblOrderItems.getTableHeader().setBackground(lightBlue);
    tblOrderItems.getTableHeader().setForeground(darkBlue);

    tblOrderItems.getTableHeader().setFont(
            new java.awt.Font(
                    "SansSerif",
                    java.awt.Font.BOLD,
                    13
            )
    );

    tblOrderItems.getTableHeader().setPreferredSize(
            new java.awt.Dimension(0, 34)
    );
}
    
    private void styleOrderButton(
        javax.swing.JButton button,
        java.awt.Color background,
        java.awt.Color foreground) {

    button.setBackground(background);
    button.setForeground(foreground);

    button.setFont(
            new java.awt.Font(
                    "SansSerif",
                    java.awt.Font.BOLD,
                    14
            )
    );

    button.setFocusPainted(false);
    button.setBorderPainted(false);
    button.setOpaque(true);
}
    
    private void centerOrderPaymentComponents() {

    int panelWidth = getContentPane().getWidth();

    // Main content width
    int contentWidth = 1200;
    int x = (panelWidth - contentWidth) / 2;

    // =========================
    // TITLE
    // =========================

    lblOrderPaymentTitle.setBounds(
            x + 350, 30, 500, 40
    );

    // =========================
    // LEFT SIDE
    // =========================

    jLabel13.setBounds(x + 0, 95, 160, 25);       // Search Customer
    txtSearchCustomer.setBounds(x + 185, 90, 320, 35);

    jLabel1.setBounds(x + 0, 140, 160, 25);       // Customer
    cmbCustomer.setBounds(x + 185, 135, 355, 35);

    lblDeliveryAddress.setBounds(x + 0, 185, 160, 25);
    txtDeliveryAddress.setBounds(x + 185, 180, 355, 35);

    // =========================
    // RIGHT SIDE
    // =========================

    jLabel9.setBounds(x + 650, 95, 160, 25);      // Order Type
    cmbOrderType.setBounds(x + 835, 90, 355, 35);

    jLabel12.setBounds(x + 650, 140, 160, 25);    // Delivery Status
    cmbDeliveryStatus.setBounds(x + 835, 135, 355, 35);

    jLabel2.setBounds(x + 650, 185, 160, 25);     // Product
    cmbProduct.setBounds(x + 835, 180, 355, 35);

    jLabel3.setBounds(x + 650, 230, 160, 25);     // Price
    txtPrice.setBounds(x + 835, 225, 355, 35);

    jLabel8.setBounds(x + 650, 275, 160, 25);     // Quantity
    txtQuantity.setBounds(x + 835, 270, 355, 35);

    btnAddItem.setBounds(
            x + 835, 315, 355, 40
    );

    // =========================
    // ORDER ITEMS TABLE
    // =========================

    jScrollPane1.setBounds(
            x + 0, 370, 1200, 190
    );
    // =========================
    // PAYMENT - LEFT
    // =========================

    jLabel7.setBounds(x + 0, 585, 160, 25);
    cmbPaymentMethod.setBounds(x + 185, 580, 355, 35);

    lblReferenceCode.setBounds(x + 0, 625, 160, 25);
    txtReferenceCode.setBounds(x + 185, 620, 355, 35);

    jLabel5.setBounds(x + 0, 665, 160, 25);
    txtAmountPaid.setBounds(x + 185, 660, 355, 35);

    btnProcessTransaction.setBounds(
            x + 185, 705, 355, 40
    );

    btnClear.setBounds(
            x + 185, 750, 355, 40
    );

    // =========================
    // TOTALS - RIGHT
    // =========================

    jLabel11.setBounds(x + 650, 585, 160, 25);
    lblSubtotal.setBounds(x + 835, 585, 355, 25);

    jLabel10.setBounds(x + 650, 625, 160, 25);
    lblDeliveryFee.setBounds(x + 835, 625, 355, 25);

    jLabel4.setBounds(x + 650, 665, 160, 25);
    lblTotal.setBounds(x + 835, 665, 355, 25);

    jLabel6.setBounds(x + 650, 705, 160, 25);
    lblChange.setBounds(x + 835, 705, 355, 25);

    // =========================
    // BACK BUTTON
    // =========================

    btnBack.setBounds(
            20, 35, 110, 45
    );

    getContentPane().revalidate();
    getContentPane().repaint();
}
    
    private void loadCustomers() {

    CustomerDAO dao = new CustomerDAO();

    java.util.List<String[]> customers =
            dao.getAllCustomers();

    cmbCustomer.removeAllItems();

    for (String[] customer : customers) {

        String customerId = customer[0];
        String fullName = customer[1] + " " + customer[2];

        cmbCustomer.addItem(
                customerId + " - " + fullName
        );
    }
}
    
    private void loadProducts() {

    ProductDAO dao = new ProductDAO();

    java.util.List<String[]> products =
            dao.getAllProducts();

    cmbProduct.removeAllItems();

    for (String[] product : products) {

        String productId = product[0];
        String productName = product[1];

        cmbProduct.addItem(
                productId + " - " + productName
        );
    }
}
    
    private void calculateDeliveryFee() {

    String orderType =
            cmbOrderType.getSelectedItem().toString();

    int totalQuantity = 0;

    javax.swing.table.DefaultTableModel model =
            (javax.swing.table.DefaultTableModel)
            tblOrderItems.getModel();

    for (int i = 0; i < model.getRowCount(); i++) {

        int quantity =
                Integer.parseInt(
                        model.getValueAt(i, 1).toString()
                );

        totalQuantity += quantity;
    }

    double deliveryFee = 0;

    if (orderType.equalsIgnoreCase("Delivery")) {

        deliveryFee = totalQuantity * 5.00;
    }

    lblDeliveryFee.setText(
            String.format("₱%.2f", deliveryFee)
    );
}
    
    private void updateOrderSummary() {

    javax.swing.table.DefaultTableModel model =
            (javax.swing.table.DefaultTableModel)
            tblOrderItems.getModel();

    double subtotal = 0;
    int totalQuantity = 0;

    // Calculate subtotal and total gallons
    for (int i = 0; i < model.getRowCount(); i++) {

        double itemSubtotal =
                Double.parseDouble(
                        model.getValueAt(i, 3).toString()
                );

        int quantity =
                Integer.parseInt(
                        model.getValueAt(i, 1).toString()
                );

        subtotal += itemSubtotal;
        totalQuantity += quantity;
    }

    // Calculate delivery fee
    double deliveryFee = 0;

    if (cmbOrderType.getSelectedItem() != null) {

        String orderType =
                cmbOrderType.getSelectedItem().toString();

        if (orderType.equalsIgnoreCase("Delivery")) {

            deliveryFee = totalQuantity * 5.00;
        }
    }

    // Calculate final total
    double total = subtotal + deliveryFee;

    // Display subtotal
    lblSubtotal.setText(
            String.format("₱%.2f", subtotal)
    );

    // Display delivery fee
    lblDeliveryFee.setText(
            String.format("₱%.2f", deliveryFee)
    );

    // Display total
    lblTotal.setText(
            String.format("₱%.2f", total)
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

        lblOrderPaymentTitle = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cmbCustomer = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cmbProduct = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        btnAddItem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrderItems = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtAmountPaid = new javax.swing.JTextField();
        lblTotal = new javax.swing.JLabel();
        lblChange = new javax.swing.JLabel();
        cmbPaymentMethod = new javax.swing.JComboBox<>();
        btnProcessTransaction = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        txtQuantity = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        cmbOrderType = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        lblDeliveryFee = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblSubtotal = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cmbDeliveryStatus = new javax.swing.JComboBox<>();
        lblDeliveryAddress = new javax.swing.JLabel();
        txtDeliveryAddress = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtSearchCustomer = new javax.swing.JTextField();
        lblReferenceCode = new javax.swing.JLabel();
        txtReferenceCode = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        lblOrderPaymentTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblOrderPaymentTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOrderPaymentTitle.setText("ORDER & PAYMENT");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Customer:");

        cmbCustomer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbCustomer.addActionListener(this::cmbCustomerActionPerformed);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Product:");

        cmbProduct.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbProduct.addActionListener(this::cmbProductActionPerformed);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Price:");

        txtPrice.setEditable(false);
        txtPrice.addActionListener(this::txtPriceActionPerformed);

        btnAddItem.setText("ADD ITEM");
        btnAddItem.addActionListener(this::btnAddItemActionPerformed);

        tblOrderItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product", "Quantity", "Unit Price", "Subtotal"
            }
        ));
        jScrollPane1.setViewportView(tblOrderItems);

        jLabel4.setText("Total:");

        jLabel5.setText("Amount Paid:");

        jLabel6.setText("Change: ");

        jLabel7.setText("Payment Method:");

        txtAmountPaid.addActionListener(this::txtAmountPaidActionPerformed);
        txtAmountPaid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAmountPaidKeyReleased(evt);
            }
        });

        cmbPaymentMethod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cash", "GCash" }));
        cmbPaymentMethod.addActionListener(this::cmbPaymentMethodActionPerformed);

        btnProcessTransaction.setText("PROCESS TRANSACTION");
        btnProcessTransaction.addActionListener(this::btnProcessTransactionActionPerformed);

        btnClear.setText("CLEAR");
        btnClear.addActionListener(this::btnClearActionPerformed);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Quantity:");

        btnBack.setText("← Back");
        btnBack.addActionListener(this::btnBackActionPerformed);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Order Type:");

        cmbOrderType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Walk-in", "Delivery" }));
        cmbOrderType.addActionListener(this::cmbOrderTypeActionPerformed);

        jLabel10.setText("Delivery Fee:");

        jLabel11.setText("Subtotal:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("Delivery Status:");

        cmbDeliveryStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pending", "Out for Delivery", "Delivered", "Cancelled" }));

        lblDeliveryAddress.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblDeliveryAddress.setText("Delivery Address:");

        txtDeliveryAddress.setEditable(false);
        txtDeliveryAddress.addActionListener(this::txtDeliveryAddressActionPerformed);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("Search Customer:");

        txtSearchCustomer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchCustomerKeyReleased(evt);
            }
        });

        lblReferenceCode.setText("Reference Code:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblOrderPaymentTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8))
                                        .addGap(596, 596, 596))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblDeliveryAddress)
                                            .addComponent(jLabel13))
                                        .addGap(61, 61, 61)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtDeliveryAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cmbProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cmbCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtSearchCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(btnAddItem)
                                        .addGap(133, 133, 133))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(8, 8, 8)
                                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(cmbOrderType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(cmbDeliveryStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(0, 73, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblReferenceCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(195, 195, 195)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnClear)
                                    .addComponent(cmbPaymentMethod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnProcessTransaction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtReferenceCode))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(52, 52, 52)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblChange, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAmountPaid, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDeliveryFee, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(120, 120, 120))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 999, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(btnBack))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(lblOrderPaymentTitle)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(cmbOrderType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDeliveryAddress)
                            .addComponent(jLabel12)
                            .addComponent(cmbDeliveryStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13)
                            .addComponent(txtSearchCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cmbCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addComponent(txtDeliveryAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddItem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDeliveryFee, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtAmountPaid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(lblChange, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbPaymentMethod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblReferenceCode)
                    .addComponent(txtReferenceCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(btnProcessTransaction)
                .addGap(27, 27, 27)
                .addComponent(btnClear)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProcessTransactionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessTransactionActionPerformed
// Check payment method
    if (cmbPaymentMethod.getSelectedIndex() == -1) {

        JOptionPane.showMessageDialog(
                this,
                "Please select a payment method."
        );

        return;
    }

    // Check customer
    if (cmbCustomer.getSelectedIndex() == -1) {

        JOptionPane.showMessageDialog(
                this,
                "Please select a customer."
        );

        return;
    }

    // Check order type
    if (cmbOrderType.getSelectedIndex() == -1) {

        JOptionPane.showMessageDialog(
                this,
                "Please select an order type."
        );

        return;
    }

    // Check order items
    javax.swing.table.DefaultTableModel model =
            (javax.swing.table.DefaultTableModel)
            tblOrderItems.getModel();

    if (model.getRowCount() == 0) {

        JOptionPane.showMessageDialog(
                this,
                "Please add at least one product."
        );

        return;
    }

    // Get total
    String totalText =
            lblTotal.getText()
            .replace("₱", "")
            .trim();

    double total;

    try {

        total = Double.parseDouble(totalText);

    } catch (NumberFormatException e) {

        JOptionPane.showMessageDialog(
                this,
                "Invalid total amount."
        );

        return;
    }

    // Get payment method
    String paymentMethod =
            cmbPaymentMethod.getSelectedItem().toString();

    double amountPaid;
    double change;
    String referenceCode;

    // =========================
    // GCASH PAYMENT
    // =========================
    if (paymentMethod.equalsIgnoreCase("GCash")) {

        // Reference code is required
        referenceCode =
                txtReferenceCode.getText().trim();

        if (referenceCode.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter the GCash reference code."
            );

            return;
        }

        // GCash automatically uses the total amount
        amountPaid = total;

        // GCash has no change
        change = 0.00;

    } 
    
    // =========================
    // CASH PAYMENT
    // =========================
    else {

        // Cash does not need a reference code
        referenceCode = "N/A";

        String amountPaidText =
                txtAmountPaid.getText().trim();

        if (amountPaidText.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter the amount paid."
            );

            return;
        }

        try {

            amountPaid =
                    Double.parseDouble(amountPaidText);

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a valid amount paid."
            );

            return;
        }

        // Amount paid must be greater than 0
        if (amountPaid <= 0) {

            JOptionPane.showMessageDialog(
                    this,
                    "Amount paid must be greater than 0."
            );

            return;
        }

        // Amount paid must be enough
        if (amountPaid < total) {

            JOptionPane.showMessageDialog(
                    this,
                    "Amount paid is not enough."
            );

            return;
        }

        // Calculate cash change
        change = amountPaid - total;
    }

    // Get order type
    String orderType =
            cmbOrderType.getSelectedItem().toString();

    String deliveryStatus;

    if (orderType.equalsIgnoreCase("Delivery")) {

        deliveryStatus =
                cmbDeliveryStatus.getSelectedItem().toString();

    } else {

        deliveryStatus = "N/A";
    }

    // Get delivery fee
    String deliveryFeeText =
            lblDeliveryFee.getText()
            .replace("₱", "")
            .trim();

    double deliveryFee;

    try {

        deliveryFee =
                Double.parseDouble(deliveryFeeText);

    } catch (NumberFormatException e) {

        JOptionPane.showMessageDialog(
                this,
                "Invalid delivery fee."
        );

        return;
    }

    // Get customer ID
    String selectedCustomer =
            cmbCustomer.getSelectedItem().toString();

    int customerId =
            Integer.parseInt(
                    selectedCustomer.split(" - ")[0]
            );

    // Get logged-in user ID
    int userId =
            UserSession.getUserId();

    // Prepare order items
    java.util.List<Object[]> items =
            new java.util.ArrayList<>();

    for (int i = 0;
            i < model.getRowCount();
            i++) {

        String productName =
                model.getValueAt(i, 0).toString();

        int quantity =
                Integer.parseInt(
                        model.getValueAt(i, 1).toString()
                );

        double unitPrice =
                Double.parseDouble(
                        model.getValueAt(i, 2).toString()
                );

        double subtotal =
                Double.parseDouble(
                        model.getValueAt(i, 3).toString()
                );

        // Find product ID
        ProductDAO productDAO =
                new ProductDAO();

        java.util.List<String[]> products =
                productDAO.getAllProducts();

        int productId = -1;

        for (String[] product : products) {

            if (product[1].equals(productName)) {

                productId =
                        Integer.parseInt(product[0]);

                break;
            }
        }

        // Product not found
        if (productId == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "Product not found: "
                    + productName
            );

            return;
        }

        // Add item
        items.add(
                new Object[]{
                    productId,
                    quantity,
                    unitPrice,
                    subtotal
                }
        );
    }

    // Save transaction
    OrderDAO dao =
            new OrderDAO();

    boolean success = dao.saveTransaction(
            customerId,
            userId,
            orderType,
            deliveryStatus,
            deliveryFee,
            total,
            amountPaid,
            change,
            paymentMethod,
            referenceCode,
            items
    );

    // Transaction saved successfully
    if (success) {

        JOptionPane.showMessageDialog(
                this,
                "Transaction saved successfully!"
        );

        // Clear order table
        model.setRowCount(0);

        // Reset summary
        lblSubtotal.setText("₱0.00");

        lblDeliveryFee.setText("₱0.00");

        lblTotal.setText("₱0.00");

        // Reset payment
        txtAmountPaid.setText("");

        txtReferenceCode.setText("N/A");

        lblChange.setText("₱0.00");

        // Reset product inputs
        txtQuantity.setText("");

        txtPrice.setText("");

        // Reset order type
        cmbOrderType.setSelectedIndex(0);

        // Reset payment method
        cmbPaymentMethod.setSelectedIndex(0);

    } else {

        JOptionPane.showMessageDialog(
                this,
                "Failed to save transaction."
        );
    }        
    }//GEN-LAST:event_btnProcessTransactionActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // Clear customer search
        txtSearchCustomer.setText("");

        // Reset customer
        cmbCustomer.setSelectedIndex(-1);

        // Clear delivery address
        txtDeliveryAddress.setText("N/A");

        // Reset order type
        cmbOrderType.setSelectedItem("Walk-in");

        // Reset delivery status
        cmbDeliveryStatus.setSelectedItem("Pending");

        // Reset product
        cmbProduct.setSelectedIndex(-1);

        // Clear price and quantity
        txtPrice.setText("");
        txtQuantity.setText("");

        // Clear order items table
        javax.swing.table.DefaultTableModel model =
                (javax.swing.table.DefaultTableModel)
                tblOrderItems.getModel();

        model.setRowCount(0);

        // Reset subtotal, delivery fee, and total
        lblSubtotal.setText("₱0.00");
        lblDeliveryFee.setText("₱0.00");
        lblTotal.setText("₱0.00");

        // Clear payment
        txtAmountPaid.setText("");

        // Reset change
        lblChange.setText("₱0.00");

        // Reset payment method
        cmbPaymentMethod.setSelectedIndex(0);
    }//GEN-LAST:event_btnClearActionPerformed

    private void cmbProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbProductActionPerformed
        int selectedIndex = cmbProduct.getSelectedIndex();

        if (selectedIndex == -1) {
            txtPrice.setText("");
            return;
        }

        String selectedProduct =
                cmbProduct.getSelectedItem().toString();

        String productId =
                selectedProduct.split(" - ")[0];

        ProductDAO dao = new ProductDAO();

        java.util.List<String[]> products =
                dao.getAllProducts();

        for (String[] product : products) {

            if (product[0].equals(productId)) {

                txtPrice.setText(product[3]);

                break;
            }
        }                
    }//GEN-LAST:event_cmbProductActionPerformed

    private void btnAddItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddItemActionPerformed
        String selectedProduct = cmbProduct.getSelectedItem().toString();
        String productId = selectedProduct.split(" - ")[0];

        String productName = selectedProduct.substring(
                selectedProduct.indexOf(" - ") + 3
        );

        String priceText = txtPrice.getText().trim();
        String quantityText = txtQuantity.getText().trim();

        if (cmbProduct.getSelectedIndex() == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please select a product."
            );

            return;
        }

        if (priceText.isEmpty() || quantityText.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Please enter the quantity."
            );
            return;
        }

        double unitPrice;

        int quantity;

        try {
            unitPrice = Double.parseDouble(priceText);
            quantity = Integer.parseInt(quantityText);
        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Please enter valid numbers."
            );
            return;
        }

        if (quantity <= 0) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a quantity greater than 0."
            );

            return;
        }

        double subtotal = unitPrice * quantity;

        javax.swing.table.DefaultTableModel model =
                (javax.swing.table.DefaultTableModel) tblOrderItems.getModel();

        model.addRow(new Object[]{
            productName,
            quantity,
            unitPrice,
            subtotal
        });

        double total = 0;

        for (int i = 0; i < model.getRowCount(); i++) {
            total += Double.parseDouble(
                    model.getValueAt(i, 3).toString()
            );
        }

        lblTotal.setText("₱" + String.format("%.2f", total));

        txtQuantity.setText("");

        updateOrderSummary();
    }//GEN-LAST:event_btnAddItemActionPerformed

    private void txtAmountPaidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAmountPaidActionPerformed
        String amountPaidText = txtAmountPaid.getText().trim();

        if (amountPaidText.isEmpty()) {
            lblChange.setText("₱0.00");
            return;
        }

        try {
            double amountPaid = Double.parseDouble(amountPaidText);

            String totalText = lblTotal.getText()
                    .replace("₱", "")
                    .trim();

            double total = Double.parseDouble(totalText);

            double change = amountPaid - total;

            if (change < 0) {
                lblChange.setText("₱0.00");
            } else {
                lblChange.setText(
                        "₱" + String.format("%.2f", change)
                );
            }

        } catch (NumberFormatException e) {
            lblChange.setText("₱0.00");
        }        
    }//GEN-LAST:event_txtAmountPaidActionPerformed

    private void txtAmountPaidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAmountPaidKeyReleased
    String amountPaidText = txtAmountPaid.getText().trim();
        
        if (amountPaidText.isEmpty()) {
            lblChange.setText("₱0.00");
            return;
        }

        try {
            double amountPaid = Double.parseDouble(amountPaidText);

            String totalText = lblTotal.getText()
                    .replace("₱", "")
                    .trim();

            double total = Double.parseDouble(totalText);

            double change = amountPaid - total;

            if (change < 0) {
                lblChange.setText("₱0.00");
            } else {
                lblChange.setText(
                        "₱" + String.format("%.2f", change)
                );
            }

        } catch (NumberFormatException e) {
            lblChange.setText("₱0.00");
        }
    }//GEN-LAST:event_txtAmountPaidKeyReleased

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        DashboardFrame dashboard = new DashboardFrame();
        dashboard.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void cmbPaymentMethodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPaymentMethodActionPerformed
        String paymentMethod =
            cmbPaymentMethod.getSelectedItem().toString();

        if (paymentMethod.equalsIgnoreCase("GCash")) {

            // GCash does not require manual amount entry
            txtAmountPaid.setText(lblTotal.getText().replace("₱", ""));
            txtAmountPaid.setEditable(false);

            // GCash requires a reference code
            txtReferenceCode.setText("");
            txtReferenceCode.setEditable(true);

            // No change for GCash
            lblChange.setText("₱0.00");

        } else {

            // Cash requires the amount paid
            txtAmountPaid.setText("");
            txtAmountPaid.setEditable(true);

            // Cash does not need a reference code
            txtReferenceCode.setText("N/A");
            txtReferenceCode.setEditable(false);

            lblChange.setText("₱0.00");
        }
    }//GEN-LAST:event_cmbPaymentMethodActionPerformed

    private void cmbOrderTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbOrderTypeActionPerformed
        updateOrderSummary();
        
        if (cmbOrderType.getSelectedItem() == null) {
        txtDeliveryAddress.setText("");
        return;
        }

        String orderType =
                cmbOrderType.getSelectedItem().toString();

        if (orderType.equalsIgnoreCase("Walk-in")) {

            txtDeliveryAddress.setText("N/A");

        } else if (orderType.equalsIgnoreCase("Delivery")) {

            if (cmbCustomer.getSelectedIndex() == -1) {
                txtDeliveryAddress.setText("N/A");
                return;
            }

            String selectedCustomer =
                    cmbCustomer.getSelectedItem().toString();

            int customerId =
                    Integer.parseInt(selectedCustomer.split(" - ")[0]);

            CustomerDAO dao = new CustomerDAO();

            String address =
                    dao.getCustomerAddress(customerId);

            if (address != null && !address.trim().isEmpty()) {
                txtDeliveryAddress.setText(address);
            } else {
                txtDeliveryAddress.setText("N/A");
            }
        }
    }//GEN-LAST:event_cmbOrderTypeActionPerformed

    private void cmbCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCustomerActionPerformed
        if (cmbCustomer.getSelectedIndex() == -1) {
        txtDeliveryAddress.setText("N/A");
        return;
        }

        String orderType =
                cmbOrderType.getSelectedItem().toString();

        if (orderType.equalsIgnoreCase("Walk-in")) {
            txtDeliveryAddress.setText("N/A");
            return;
        }

        String selectedCustomer =
                cmbCustomer.getSelectedItem().toString();

        int customerId =
                Integer.parseInt(selectedCustomer.split(" - ")[0]);

        CustomerDAO dao = new CustomerDAO();

        String address =
                dao.getCustomerAddress(customerId);

        if (address != null && !address.trim().isEmpty()) {
            txtDeliveryAddress.setText(address);
        } else {
            txtDeliveryAddress.setText("N/A");
        }
    }//GEN-LAST:event_cmbCustomerActionPerformed

    private void txtDeliveryAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDeliveryAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDeliveryAddressActionPerformed

    private void txtSearchCustomerKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchCustomerKeyReleased
        String searchText =
            txtSearchCustomer.getText().trim();

        CustomerDAO dao = new CustomerDAO();

        java.util.List<String[]> customers =
                dao.searchCustomers(searchText);

        cmbCustomer.removeAllItems();

        for (String[] customer : customers) {

            String customerItem =
                    customer[0] + " - "
                    + customer[1] + " "
                    + customer[2];

            cmbCustomer.addItem(customerItem);
        }

        if (cmbCustomer.getItemCount() > 0) {
            cmbCustomer.setSelectedIndex(0);
        }
    }//GEN-LAST:event_txtSearchCustomerKeyReleased

    private void txtPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPriceActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new OrderPaymentFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddItem;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnProcessTransaction;
    private javax.swing.JComboBox<String> cmbCustomer;
    private javax.swing.JComboBox<String> cmbDeliveryStatus;
    private javax.swing.JComboBox<String> cmbOrderType;
    private javax.swing.JComboBox<String> cmbPaymentMethod;
    private javax.swing.JComboBox<String> cmbProduct;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblChange;
    private javax.swing.JLabel lblDeliveryAddress;
    private javax.swing.JLabel lblDeliveryFee;
    private javax.swing.JLabel lblOrderPaymentTitle;
    private javax.swing.JLabel lblReferenceCode;
    private javax.swing.JLabel lblSubtotal;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tblOrderItems;
    private javax.swing.JTextField txtAmountPaid;
    private javax.swing.JTextField txtDeliveryAddress;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtReferenceCode;
    private javax.swing.JTextField txtSearchCustomer;
    // End of variables declaration//GEN-END:variables
}
