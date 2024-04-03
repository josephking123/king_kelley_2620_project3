import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import FamilyMembers.FamilyMember;

public class FamilyTreeGUI extends JFrame {
    private JTextArea textArea;

    public FamilyTreeGUI(ArrayList<FamilyMember> familyMembers) {
        setTitle("Family Tree");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        textArea = new JTextArea();
        textArea.setEditable(false); 

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);

        displayFamilyTree(familyMembers);
    }

    private void displayFamilyTree(ArrayList<FamilyMember> familyMembers) {
        StringBuilder treeText = new StringBuilder();
        treeText.append("Family Tree\n");

        for (FamilyMember member : familyMembers) {
            treeText.append("- ").append(member.getName()).append("\n");

            FamilyMember spouse = member.getSpouse();
            if (spouse != null) {
                treeText.append("  - Spouse: ").append(spouse.getName()).append("\n");
            } else {
                treeText.append("  - No spouse\n");
            }
     
            for (FamilyMember child : member.getChildren()) {
                treeText.append("  - Child: ").append(child.getName()).append("\n");
            }
        }

        textArea.setText(treeText.toString());
    }
}
