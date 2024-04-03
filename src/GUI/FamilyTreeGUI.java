import javax.swing.*;
import java.awt.*;

public class FamilyTreeGUI extends JFrame {
    @SuppressWarnings("unused")
    private FamilyTreeController controller;

    private JPanel treePanel;
    private JTree tree;

    public FamilyTreeGUI() {
        setTitle("Family Tree");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        treePanel = new JPanel();
        tree = new JTree();

        treePanel.setLayout(new BorderLayout());
        treePanel.add(new JScrollPane(tree), BorderLayout.CENTER); 

        setLayout(new BorderLayout());

        add(treePanel, BorderLayout.CENTER);
    }

    public void setController(FamilyTreeController controller) {
        this.controller = controller;
    }

    public JTree getTree() {
        return tree;
    }
}