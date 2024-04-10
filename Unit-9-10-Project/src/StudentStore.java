import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

class StudentStore extends JPanel {
    private JList<Product> itemList;
    private DefaultListModel<Product> model;
    private JButton purchaseButton;
    private DefaultListModel<String> purchaseListModel;
    private JList<String> purchaseList;
    private JLabel totalLabel;
    private double totalCost = 0.0;

    public StudentStore() {
        setLayout(new BorderLayout());
        model = new DefaultListModel<>();
        itemList = new JList<>(model);
        JScrollPane itemScrollPane = new JScrollPane(itemList);
        purchaseButton = new JButton("Purchase");
        purchaseButton.addActionListener(e -> purchaseItem());

        // Purchases Panel
        JPanel purchasesPanel = new JPanel(new BorderLayout());
        purchaseListModel = new DefaultListModel<>();
        purchaseList = new JList<>(purchaseListModel);
        JScrollPane purchaseScrollPane = new JScrollPane(purchaseList);
        totalLabel = new JLabel("Total: $0.00");
        purchasesPanel.add(purchaseScrollPane, BorderLayout.CENTER);
        purchasesPanel.add(totalLabel, BorderLayout.SOUTH);

        // Adding to main layout
        add(itemScrollPane, BorderLayout.CENTER);
        add(purchaseButton, BorderLayout.SOUTH);
        add(purchasesPanel, BorderLayout.EAST);
    }

    private void purchaseItem() {
        Product selected = itemList.getSelectedValue();
        if (selected != null && selected.getQuantity() > 0) {
            selected.setQuantity(selected.getQuantity() - 1);
            itemList.repaint();

            // Update purchases list and total cost
            updatePurchases(selected);

            if (selected.getQuantity() == 0) {
                JOptionPane.showMessageDialog(this, selected.getName() + " is now out of stock.");
            }
        } else if (selected != null && selected.getQuantity() == 0) {
            JOptionPane.showMessageDialog(this, "This item is out of stock.");
        } else {
            JOptionPane.showMessageDialog(this, "No item selected");
        }
    }

    private void updatePurchases(Product product) {
        String purchaseEntry = product.getName() + " - $" + product.getPrice();
        purchaseListModel.addElement(purchaseEntry);
        totalCost += product.getPrice();
        totalLabel.setText("Total: $" + String.format("%.2f", totalCost));
    }

    public void addItem(Product item) {
        model.addElement(item);
    }
}