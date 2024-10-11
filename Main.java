import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class SecurityOfficer {
    String name;
    String designation;
    List<String> responsibilities;

    public SecurityOfficer(String n, String d, List<String> r) {
        name = n;
        designation = d;
        responsibilities = r;
    }
}

class Gate {
    int gateNumber;
    String location;

    public Gate(int num, String loc) {
        gateNumber = num;
        location = loc;
    }
}

class VisitorRecord {
    SecurityOfficer officer;
    Date dateOfVisit;
    String visitorDetails;
    String destination;
    String purposeOfVisit;
    String modeOfTravel;
    String report;
    Gate gateUsedToEnter;
    Gate gateUsedToExit;
    Date exitTime;

    public VisitorRecord(SecurityOfficer o, String details, String dest,
                         String purpose, String travel, Gate entryGate) {
        officer = o;
        dateOfVisit = new Date();
        visitorDetails = details;
        destination = dest;
        purposeOfVisit = purpose;
        modeOfTravel = travel;
        gateUsedToEnter = entryGate;
        exitTime = null;
    }

    public void addReport(String rep) {
        report = rep;
    }

    public void indicatePurpose(String purpose) {
        purposeOfVisit = purpose;
    }

    public void setExitTime(Date time, Gate exitGate) {
        exitTime = time;
        gateUsedToExit = exitGate;
    }
}

class VisitorsBook {
    List<VisitorRecord> records;

    public VisitorsBook() {
        records = new ArrayList<>();
    }

    public void addRecord(VisitorRecord record) {
        records.add(record);
    }

    public String getRecords() {
        StringBuilder sb = new StringBuilder();
        for (VisitorRecord record : records) {
            sb.append("Visitor: ").append(record.visitorDetails)
                    .append(", Purpose: ").append(record.purposeOfVisit)
                    .append(", Destination: ").append(record.destination)
                    .append(", Entry Gate: ").append(record.gateUsedToEnter.gateNumber)
                    .append(", Entry Time: ").append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(record.dateOfVisit));
            if (record.exitTime != null) {
                sb.append(", Exit Gate: ").append(record.gateUsedToExit.gateNumber)
                        .append(", Exit Time: ").append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(record.exitTime));
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public List<VisitorRecord> searchVisitor(String searchTerm) {
        List<VisitorRecord> matchingRecords = new ArrayList<>();
        for (VisitorRecord record : records) {
            if (record.visitorDetails.toLowerCase().contains(searchTerm.toLowerCase())) {
                matchingRecords.add(record);
            }
        }
        return matchingRecords;
    }

    public void generateReport(String filename) throws IOException {
        // Implementation for report generation
    }
}

public class Main extends JFrame {
    SecurityOfficer officer;
    Gate mainGate;
    VisitorsBook visitorsBook;
    JTextArea displayArea;

    public Main() {
        super("Visitor Management System");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        officer = new SecurityOfficer("John Doe", "Security Officer", List.of("Checking IDs", "Issuing passes"));
        mainGate = new Gate(1, "Main Entrance");
        visitorsBook = new VisitorsBook();

        // Background Image for Input Panel
        JLabel inputBackground = new JLabel(new ImageIcon("background-img.jpg"));
        inputBackground.setLayout(new BorderLayout());
        setContentPane(inputBackground);

        // GUI elements for Input Panel
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        JLabel visitorLabel = new JLabel("Visitor Details:");
        JTextField visitorField = new JTextField(20);
        JLabel purposeLabel = new JLabel("Purpose of Visit:");
        JTextField purposeField = new JTextField(20);
        JLabel destinationLabel = new JLabel("Destination:");
        JTextField destinationField = new JTextField(20);
        JButton addButton = new JButton("Add Visitor");
        addButton.addActionListener(e -> {
            String visitorDetails = visitorField.getText();
            String purposeOfVisit = purposeField.getText();
            String destination = destinationField.getText();
            VisitorRecord visitorRecord = new VisitorRecord(officer, visitorDetails, destination, purposeOfVisit, "Car", mainGate);
            visitorsBook.addRecord(visitorRecord);
            visitorField.setText("");
            purposeField.setText("");
            destinationField.setText("");
        });

        // Add GUI elements to Input Panel
        panel.add(visitorLabel);
        panel.add(visitorField);
        panel.add(purposeLabel);
        panel.add(purposeField);
        panel.add(destinationLabel);
        panel.add(destinationField);
        panel.add(addButton);
        inputBackground.add(panel, BorderLayout.NORTH);

        // Background Image for Display Area
        JLabel displayBackground = new JLabel(new ImageIcon("display_background.jpg"));
        displayBackground.setLayout(new BorderLayout());

        // Display Area for Records
        displayArea = new JTextArea(10, 30);
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);
        displayBackground.add(scrollPane, BorderLayout.CENTER);

        // Button to View Records
        JButton viewButton = new JButton("View Records");
        viewButton.addActionListener(e -> {
            displayArea.setText(visitorsBook.getRecords());
        });
        displayBackground.add(viewButton, BorderLayout.SOUTH);

        // Add Display Area to Content Pane
        inputBackground.add(displayBackground, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}


//By Blacksnow Martin 