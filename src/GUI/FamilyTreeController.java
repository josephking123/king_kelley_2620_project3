import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.util.ArrayList;

public class FamilyTreeController {
    private FamilyTreeGUI gui;

    public FamilyTreeController(FamilyTreeGUI gui) {
        this.gui = gui;
    }

    public void setFamilyTree(ArrayList<FamilyMember> familyMembers) {
        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("Family Tree");

        for (FamilyMember member : familyMembers) {
            DefaultMutableTreeNode memberNode = new DefaultMutableTreeNode(member);
            rootNode.add(memberNode);
            for (FamilyMember child : member.getChildren()) {
                DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(child);
                memberNode.add(childNode);
            }
        }

        DefaultTreeModel treeModel = new DefaultTreeModel(rootNode);
        gui.getTree().setModel(treeModel);
    }
}