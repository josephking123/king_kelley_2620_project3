import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.swing.SwingUtilities;
import FamilyMembers.FamilyMember;

public class Main {
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                ArrayList<FamilyMember> people = FileReader.readInputFile("lib\\sampleInput1.txt");
                FamilyTreeGUI gui = new FamilyTreeGUI(people);
                gui.setVisible(true);
            } catch (FileNotFoundException ex) {
                System.err.println("Input file not found!");
            }
        });
    }
}