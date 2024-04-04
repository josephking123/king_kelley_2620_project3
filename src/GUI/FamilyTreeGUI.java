import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.util.ArrayList;

import FamilyMembers.Deceased;
import FamilyMembers.FamilyMember;

public class FamilyTreeGUI extends JFrame {
    private JTree tree;

    public FamilyTreeGUI(ArrayList<FamilyMember> familyMembers) {
        setTitle("Family Tree");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        DefaultMutableTreeNode root = buildTree(familyMembers);
        tree = new JTree(root);
        JScrollPane scrollPane = new JScrollPane(tree);

        getContentPane().add(scrollPane);

        setVisible(true);
    }

    private DefaultMutableTreeNode buildTree(ArrayList<FamilyMember> familyMembers) {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Family Tree");

        for (FamilyMember member : familyMembers) {
            DefaultMutableTreeNode memberNode = new DefaultMutableTreeNode(buildLabel(member));

            FamilyMember spouse = member.getSpouse();
            if (spouse != null) {
                DefaultMutableTreeNode spouseNode = new DefaultMutableTreeNode(buildLabelName(spouse, "Spouse"));
                memberNode.add(spouseNode);
            }

            ArrayList<FamilyMember> parents = member.getParents();
            if (!parents.isEmpty()) {
                DefaultMutableTreeNode parentsNode = new DefaultMutableTreeNode("Parents");
                for (FamilyMember parent : parents) {
                    DefaultMutableTreeNode parentNode = new DefaultMutableTreeNode(buildLabelName(parent, "Parent"));
                    parentsNode.add(parentNode);
                }
                memberNode.add(parentsNode);
            }

            ArrayList<FamilyMember> children = member.getChildren();
            if (!children.isEmpty()) {
                DefaultMutableTreeNode childrenNode = new DefaultMutableTreeNode("Children");
                for (FamilyMember child : children) {
                    DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(buildLabelName(child, "Child"));
                    childrenNode.add(childNode);
                }
                memberNode.add(childrenNode);
            }

            root.add(memberNode);
        }

        return root;
    }

    private String buildLabel(FamilyMember member) {
        StringBuilder labelBuilder = new StringBuilder();
        labelBuilder.append(member.getName()).append(" (").append(member.getBirthday()).append(")");
        if (member instanceof Deceased) {
            labelBuilder.append(" - Deceased (Date of Death: ").append(member.getInfo()).append(")");
        } else {
            labelBuilder.append(" - Address: ").append(member.getInfo());
        }
        return labelBuilder.toString();
    }

    private String buildLabelName(FamilyMember member, String relationship) {
        return relationship + ": " + buildLabel(member);
    }
}