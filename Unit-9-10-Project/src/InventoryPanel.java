import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class InventoryPanel extends JPanel {
    private JTextField nameField, priceField, extraField, quantityField;
    private JComboBox<String> typeComboBox;
    private JButton addButton;
    private StudentStore store;

    public InventoryPanel(StudentStore store) {
        this.store = store;
        setLayout(new GridLayout(6, 2));

        add(new JLabel("Type:"));
        typeComboBox = new JComboBox<>(new String[]{"Food", "Clothing"});
        add(typeComboBox);

        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Price:"));
        priceField = new JTextField();
        add(priceField);

        add(new JLabel("Quantity:"));  // Label for quantity
        quantityField = new JTextField();
        add(quantityField);

        add(new JLabel("Extra (Calories or Size):"));
        extraField = new JTextField();
        add(extraField);

        addButton = new JButton("Add Item");
        addButton.addActionListener(e -> addItem());
        add(addButton);
    }

    private void addItem() {
        try {
            String type = (String) typeComboBox.getSelectedItem();
            String name = nameField.getText();
            double price = Double.parseDouble(priceField.getText());
            int quantity = Integer.parseInt(quantityField.getText());  // Get quantity from the field
            String extra = extraField.getText();

            if ("Food".equals(type)) {
                store.addItem(new Food(name, price, Integer.parseInt(extra), quantity));
            } else if ("Clothing".equals(type)) {
                store.addItem(new Clothing(name, price, extra, quantity));
            }

            nameField.setText("");
            priceField.setText("");
            extraField.setText("");
            quantityField.setText("");  // Clear quantity field
            JOptionPane.showMessageDialog(this, "Item added successfully!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error in input format: " + ex.getMessage());
        }
    }
}








