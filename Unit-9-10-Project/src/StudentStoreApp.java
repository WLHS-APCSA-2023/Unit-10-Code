import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentStoreApp extends JFrame {
    private CardLayout cardLayout = new CardLayout();
    private JPanel mainPanel = new JPanel(cardLayout);
    private StudentStore storePanel;
    private InventoryPanel inventoryPanel;

    public StudentStoreApp() {
        super("Student Store Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);

        // Initialize panels
        storePanel = new StudentStore();
        inventoryPanel = new InventoryPanel(storePanel);

        // Add panels to card layout
        mainPanel.add(storePanel, "Store");
        mainPanel.add(inventoryPanel, "Inventory");

        // Menu to switch panels
        JMenuBar menuBar = new JMenuBar();
        JMenu navigationMenu = new JMenu("Navigate");
        JMenuItem goToStore = new JMenuItem("Store");
        JMenuItem goToInventory = new JMenuItem("Inventory");
        
        goToStore.addActionListener(e -> cardLayout.show(mainPanel, "Store"));
        goToInventory.addActionListener(e -> cardLayout.show(mainPanel, "Inventory"));
        
        navigationMenu.add(goToStore);
        navigationMenu.add(goToInventory);
        menuBar.add(navigationMenu);
        setJMenuBar(menuBar);

        // Add main panel to frame
        add(mainPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentStoreApp());
    }
}