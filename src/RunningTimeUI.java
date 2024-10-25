import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class RunningTimeUI extends JFrame {
    private JTextArea resultArea;
    private JButton uploadButton;
    private JButton analyzeButton;
    private File selectedFile;

    public RunningTimeUI() {
        setTitle("Running Time Analyzer");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize components
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);

        uploadButton = new JButton("Upload Pseudocode File");
        analyzeButton = new JButton("Analyze");
        analyzeButton.setEnabled(false);  // Enable after file upload

        // Panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(uploadButton);
        buttonPanel.add(analyzeButton);

        // Set up layout
        setLayout(new BorderLayout());
        add(buttonPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Button Actions
        uploadButton.addActionListener(new UploadAction());
        analyzeButton.addActionListener(new AnalyzeAction());

        setVisible(true);
    }

    public void displayRunningTime(String runningTime) {
        resultArea.append("\nRunning Time Expression:\n" + runningTime + "\n");
    }

    private class UploadAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();

            int result = fileChooser.showOpenDialog(RunningTimeUI.this);

            if (result == JFileChooser.APPROVE_OPTION) {
                selectedFile = fileChooser.getSelectedFile();

                resultArea.append("\nSelected File: " + selectedFile.getAbsolutePath() + "\n");

                analyzeButton.setEnabled(true);
            }
        }
    }

    private class AnalyzeAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (selectedFile != null) {
                Main.performAnalysis(selectedFile.getPath(), RunningTimeUI.this);
            }
        }
    }


}
