/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.waterrefillingstation;

import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author user
 */
public class ProductFrame extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ProductFrame.class.getName());

    /**
     * Creates new form ProductFrame
     */
    public ProductFrame() {
    initComponents();
    
    tblProducts.setDefaultEditor(Object.class, null);
    getContentPane().setLayout(null);
    
    applyProductStyle();
    // Table styling
    tblProducts.setRowHeight(30);

    tblProducts.setFont(
        new java.awt.Font("SansSerif", java.awt.Font.PLAIN, 13)
    );

    tblProducts.setSelectionMode(
        javax.swing.ListSelectionModel.SINGLE_SELECTION
    );

    tblProducts.getTableHeader().setFont(
        new java.awt.Font("SansSerif", java.awt.Font.BOLD, 13)
    );

    tblProducts.getTableHeader().setPreferredSize(
        new java.awt.Dimension(0, 32)
    );

    tblProducts.getTableHeader().setBackground(
        new java.awt.Color(225, 240, 250)
    );

    tblProducts.getTableHeader().setForeground(
        new java.awt.Color(0, 82, 150)
    );

    getContentPane().setBackground(
        new java.awt.Color(205, 235, 248)
    );

    setExtendedState(
        javax.swing.JFrame.MAXIMIZED_BOTH
    );

    javax.swing.SwingUtilities.invokeLater(() -> {
        centerProductComponents();
    });

    addComponentListener(
        new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(
                    java.awt.event.ComponentEvent evt) {

                centerProductComponents();
            }
        }
    );

    formatProductTable();
    loadProducts();
}
    
    private void applyProductStyle() {

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
    // FRAME BACKGROUND
    // =========================
    getContentPane().setBackground(lightBlue);

    // =========================
    // MAIN TITLE
    // =========================
    txtProductTitle.setFont(
            new java.awt.Font(
                    "SansSerif",
                    java.awt.Font.BOLD,
                    28
            )
    );

    txtProductTitle.setForeground(darkBlue);

    txtProductTitle.setHorizontalAlignment(
            javax.swing.SwingConstants.CENTER
    );

    // =========================
    // FIELD LABELS
    // =========================
    lblProductName.setFont(
            new java.awt.Font(
                    "SansSerif",
                    java.awt.Font.BOLD,
                    14
            )
    );

    lblProductType.setFont(
            new java.awt.Font(
                    "SansSerif",
                    java.awt.Font.BOLD,
                    14
            )
    );

    lblPrice.setFont(
            new java.awt.Font(
                    "SansSerif",
                    java.awt.Font.BOLD,
                    14
            )
    );

    lblProductName.setForeground(darkBlue);
    lblProductType.setForeground(darkBlue);
    lblPrice.setForeground(darkBlue);

    // =========================
    // PRODUCTS SECTION TITLE
    // =========================
    lblProducts.setFont(
            new java.awt.Font(
                    "SansSerif",
                    java.awt.Font.BOLD,
                    18
            )
    );

    lblProducts.setForeground(darkBlue);

    // =========================
    // TEXT FIELDS
    // =========================
    txtProductName.setBackground(white);
    txtProductType.setBackground(white);
    txtPrice.setBackground(white);

    txtProductName.setForeground(java.awt.Color.BLACK);
    txtProductType.setForeground(java.awt.Color.BLACK);
    txtPrice.setForeground(java.awt.Color.BLACK);

    // =========================
    // BUTTONS
    // =========================
    styleProductButton(btnAdd, mainBlue, white);
    styleProductButton(btnUpdate, mainBlue, white);
    styleProductButton(btnClear, mainBlue, white);
    styleProductButton(btnBack, mainBlue, white);

    // =========================
    // TABLE
    // =========================
    tblProducts.setBackground(white);
    tblProducts.setForeground(java.awt.Color.BLACK);

    tblProducts.setFont(
            new java.awt.Font(
                    "SansSerif",
                    java.awt.Font.PLAIN,
                    13
            )
    );

    tblProducts.setRowHeight(32);

    tblProducts.getTableHeader().setBackground(lightBlue);
    tblProducts.getTableHeader().setForeground(darkBlue);

    tblProducts.getTableHeader().setFont(
            new java.awt.Font(
                    "SansSerif",
                    java.awt.Font.BOLD,
                    13
            )
    );

    tblProducts.getTableHeader().setPreferredSize(
            new java.awt.Dimension(0, 34)
    );

    // Remove focus outline
    tblProducts.setFocusable(false);
}
    
    private void styleProductButton(
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

private void formatProductTable() {

    javax.swing.table.DefaultTableCellRenderer centerRenderer =
        new javax.swing.table.DefaultTableCellRenderer();

    centerRenderer.setHorizontalAlignment(
        javax.swing.SwingConstants.CENTER
    );

    // Product ID
    tblProducts.getColumnModel()
        .getColumn(0)
        .setCellRenderer(centerRenderer);

    // Product Name
    tblProducts.getColumnModel()
        .getColumn(1)
        .setCellRenderer(centerRenderer);

    // Product Type
    tblProducts.getColumnModel()
        .getColumn(2)
        .setCellRenderer(centerRenderer);

    // Price
    tblProducts.getColumnModel()
        .getColumn(3)
        .setCellRenderer(centerRenderer);
}
    
    private void centerProductComponents() {

    int panelWidth = getContentPane().getWidth();

    // Main content width
    int contentWidth = 860;

    // Center horizontally
    int x = (panelWidth - contentWidth) / 2;

    // =========================
    // TITLE
    // =========================
    txtProductTitle.setBounds(
            x,
            35,
            contentWidth,
            45
    );

    // =========================
    // PRODUCT INFORMATION
    // =========================

    lblProductName.setBounds(
            x + 120,
            115,
            150,
            30
    );

    txtProductName.setBounds(
            x + 280,
            108,
            320,
            42
    );

    lblProductType.setBounds(
            x + 120,
            180,
            150,
            30
    );

    txtProductType.setBounds(
            x + 280,
            173,
            320,
            42
    );

    lblPrice.setBounds(
            x + 120,
            245,
            150,
            30
    );

    txtPrice.setBounds(
            x + 280,
            238,
            320,
            42
    );

    // =========================
    // BUTTONS
    // =========================

    btnAdd.setBounds(
            x + 120,
            305,
            160,
            45
    );

    btnUpdate.setBounds(
            x + 350,
            305,
            160,
            45
    );

    btnClear.setBounds(
            x + 580,
            305,
            160,
            45
    );

    // =========================
    // PRODUCTS TITLE
    // =========================

    lblProducts.setBounds(
            x + 80,
            380,
            700,
            35
    );

    // =========================
    // PRODUCTS TABLE
    // =========================

    jScrollPane1.setBounds(
            x + 30,
            420,
            800,
            350
    );

    // =========================
    // BACK BUTTON
    // =========================

    btnBack.setBounds(
            20,
            35,
            110,
            45
    );;

    getContentPane().revalidate();
    getContentPane().repaint();
}
    
    private void loadProducts() {

    ProductDAO dao = new ProductDAO();

    java.util.List<String[]> products =
            dao.getAllProducts();

    javax.swing.table.DefaultTableModel model =
            (javax.swing.table.DefaultTableModel)
            tblProducts.getModel();

    model.setRowCount(0);

    for (String[] product : products) {

        model.addRow(new Object[]{
            product[0],
            product[1],
            product[2],
            product[3]
        });
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

        txtProductTitle = new javax.swing.JLabel();
        lblProductName = new javax.swing.JLabel();
        lblPrice = new javax.swing.JLabel();
        txtProductName = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        lblProducts = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProducts = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        lblProductType = new javax.swing.JLabel();
        txtProductType = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 204, 255));
        setPreferredSize(new java.awt.Dimension(1000, 600));
        setResizable(false);

        txtProductTitle.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        txtProductTitle.setText("PRODUCT MANAGEMENT");

        lblProductName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblProductName.setText("Product Name:");

        lblPrice.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPrice.setText("Price:");

        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAdd.setText("ADD");
        btnAdd.addActionListener(this::btnAddActionPerformed);

        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(this::btnUpdateActionPerformed);

        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnClear.setText("CLEAR");
        btnClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnClearMouseClicked(evt);
            }
        });
        btnClear.addActionListener(this::btnClearActionPerformed);

        lblProducts.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblProducts.setText("Products");

        tblProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Product_ID", "Product Name", "Product Type", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProducts);

        btnBack.setText("← Back");
        btnBack.addActionListener(this::btnBackActionPerformed);

        lblProductType.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblProductType.setText("Product Type:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(lblProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 861, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(120, 120, 120)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblProductType, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(27, 27, 27)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtProductType, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(btnAdd)
                                            .addGap(54, 54, 54)
                                            .addComponent(btnUpdate)
                                            .addGap(60, 60, 60)
                                            .addComponent(btnClear)))
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnBack)
                                    .addGap(131, 131, 131)
                                    .addComponent(txtProductTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBack)
                            .addComponent(txtProductTitle)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblProductName)
                            .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblProductType)
                    .addComponent(txtProductType, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPrice))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate)
                    .addComponent(btnClear)
                    .addComponent(btnAdd))
                .addGap(29, 29, 29)
                .addComponent(lblProducts)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
                                     
    String productName =
            txtProductName.getText().trim();

    String productType =
            txtProductType.getText().trim();

    String priceText =
            txtPrice.getText().trim();

    // Check if fields are empty
    if (productName.isEmpty()
            || productType.isEmpty()
            || priceText.isEmpty()) {

        JOptionPane.showMessageDialog(
                this,
                "Please fill in all fields."
        );

        return;
    }

    // Validate product name
    if (!productName.matches("[a-zA-Z ]+")) {

        JOptionPane.showMessageDialog(
                this,
                "Product name should contain letters only."
        );

        return;
    }

    // Validate product type
    if (!productType.matches("[a-zA-Z ]+")) {

        JOptionPane.showMessageDialog(
                this,
                "Product type should contain letters only."
        );

        return;
    }

    // Validate price
    double price;

    try {

        price = Double.parseDouble(priceText);

    } catch (NumberFormatException e) {

        JOptionPane.showMessageDialog(
                this,
                "Please enter a valid price."
        );

        return;
    }

    if (price <= 0) {

        JOptionPane.showMessageDialog(
                this,
                "Price must be greater than 0."
        );

        return;
    }

    ProductDAO dao = new ProductDAO();

    // Check duplicate Product Name + Product Type
    boolean duplicate = dao.productExists(
            productName,
            productType,
            0
    );

    if (duplicate) {

        JOptionPane.showMessageDialog(
                this,
                "A product with the same name and type already exists."
        );

        return;
    }

    // Add product
    boolean success = dao.addProduct(
            productName,
            productType,
            price
    );

    if (success) {

        JOptionPane.showMessageDialog(
                this,
                "Product added successfully!"
        );

        loadProducts();

        // Clear fields
        txtProductName.setText("");
        txtProductType.setText("");
        txtPrice.setText("");

    } else {

        JOptionPane.showMessageDialog(
                this,
                "Failed to add product."
        );
    }

               // TODO add your handling code here:
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
                                    
    int selectedRow = tblProducts.getSelectedRow();

    // Check if a product is selected
    if (selectedRow == -1) {

        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Please select a product first."
        );

        return;
    }

    // Get OLD product information
    String oldProductName =
            tblProducts.getValueAt(selectedRow, 1).toString();

    String oldProductType =
            tblProducts.getValueAt(selectedRow, 2).toString();

    String oldPrice =
            tblProducts.getValueAt(selectedRow, 3).toString();

    // Get NEW product information
    String newProductName =
            txtProductName.getText().trim();

    String newProductType =
            txtProductType.getText().trim();

    String newPriceText =
            txtPrice.getText().trim();

    // Check empty fields
    if (newProductName.isEmpty()
            || newProductType.isEmpty()
            || newPriceText.isEmpty()) {

        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Please complete all product information fields."
        );

        return;
    }

    // Validate price
    double newPrice;

    try {

        newPrice = Double.parseDouble(newPriceText);

        if (newPrice <= 0) {

            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Price must be greater than 0."
            );

            return;
        }

    } catch (NumberFormatException e) {

        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Price must be a valid number."
        );

        return;
    }

    // Check if NOTHING changed
    double oldPriceValue;

    try {

        oldPriceValue = Double.parseDouble(oldPrice);

    } catch (NumberFormatException e) {

        oldPriceValue = 0;
    }

    if (oldProductName.equals(newProductName)
            && oldProductType.equals(newProductType)
            && Double.compare(oldPriceValue, newPrice) == 0) {

        javax.swing.JOptionPane.showMessageDialog(
                this,
                "No changes detected. Product information is already up to date."
        );

        return;
    }

    // Get Product ID
    int productId = Integer.parseInt(
            tblProducts.getValueAt(selectedRow, 0).toString()
    );

    ProductDAO dao = new ProductDAO();

    // Check duplicate Product Name + Product Type
    boolean duplicate = dao.productExists(
            newProductName,
            newProductType,
            productId
    );

    if (duplicate) {

        javax.swing.JOptionPane.showMessageDialog(
                this,
                "A product with the same name and type already exists."
        );

        return;
    }

    // Update product
    boolean success = dao.updateProduct(
            productId,
            newProductName,
            newProductType,
            newPrice
    );

    if (success) {

        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Product updated successfully."
        );

        loadProducts();

    } else {

        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Failed to update product."
        );
    
}
        
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtProductName.setText("");
        txtProductType.setText("");
        txtPrice.setText("");

        tblProducts.clearSelection();        
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnClearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClearMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnClearMouseClicked

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        DashboardFrame dashboard = new DashboardFrame();
        dashboard.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void tblProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductsMouseClicked
        int selectedRow = tblProducts.getSelectedRow();

        if (selectedRow != -1) {

            txtProductName.setText(
                    tblProducts.getValueAt(selectedRow, 1).toString()
            );

            txtProductType.setText(
                    tblProducts.getValueAt(selectedRow, 2).toString()
            );

            txtPrice.setText(
                    tblProducts.getValueAt(selectedRow, 3).toString()
            );
        }
    }//GEN-LAST:event_tblProductsMouseClicked

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
        java.awt.EventQueue.invokeLater(() -> new ProductFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblProductName;
    private javax.swing.JLabel lblProductType;
    private javax.swing.JLabel lblProducts;
    private javax.swing.JTable tblProducts;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtProductName;
    private javax.swing.JLabel txtProductTitle;
    private javax.swing.JTextField txtProductType;
    // End of variables declaration//GEN-END:variables
}
