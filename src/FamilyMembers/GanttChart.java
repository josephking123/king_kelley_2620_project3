package FamilyMembers;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class GanttChart {

    public static void createGanttChart(List<FamilyMember> familyMembers) {
        TaskSeriesCollection dataset = createDataset(familyMembers);
        JFreeChart chart = createChart(dataset);

        displayChart(chart);
    }

    private static TaskSeriesCollection createDataset(List<FamilyMember> familyMembers) {
        TaskSeries series = new TaskSeries("Family Members");

        for (FamilyMember member : familyMembers) {
            try {
            Date birthDate = parseDate(member.getBirthday());
            Task task;
            if (member instanceof Living) {
                task = new Task(member.getName(), birthDate, new Date());
            } else if (member instanceof Deceased) {
                Date deathDate = parseDate(((Deceased) member).getInfo());
                task = new Task(member.getName(), birthDate, deathDate);
            } else {
                continue;
            }
            series.add(task);
        } catch (IllegalArgumentException e){
            System.err.println("Error creating task for " + member.getName() + ": " + e.getMessage());
        }
    }

        TaskSeriesCollection dataset = new TaskSeriesCollection();
        dataset.add(series);

        return dataset;
    }

    private static JFreeChart createChart(IntervalCategoryDataset dataset) {
        return ChartFactory.createGanttChart(
                "Family Tree Gantt Chart", 
                "Family Members", 
                "Timeline", 
                dataset, 
                true, 
                true, 
                false 
        );
    }


        private static void displayChart(JFreeChart chart) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Gantt Chart");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.add(new ChartPanel(chart));
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    private static Date parseDate(String dateString) {
        try {
            return new SimpleDateFormat("dd MM yyyy").parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
