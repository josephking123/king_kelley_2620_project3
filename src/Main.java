import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.swing.SwingUtilities;
import FamilyMembers.FamilyMember;
import FamilyMembers.GanttChart;

public class Main {
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                ArrayList<FamilyMember> people = FileReader.readInputFile("lib\\sampleInput2.txt");
                FamilyTreeGUI gui = new FamilyTreeGUI(people);
                gui.setVisible(true);

                GanttChart.createGanttChart(people);
            } catch (FileNotFoundException ex) {
                System.err.println("Input file not found!");
            }
        });
    }
}