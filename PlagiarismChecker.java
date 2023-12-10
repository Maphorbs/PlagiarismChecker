import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlagiarismChecker extends JFrame implements ActionListener {
    private JTextArea leftTextArea, rightTextArea;

    public PlagiarismChecker() {
        setTitle("Code Plagiarism Checker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        setResizable(false);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));

        JLabel leftLabel = new JLabel("Paste your code here:");
        leftTextArea = new JTextArea(10, 40);
        JScrollPane leftScrollPane = new JScrollPane(leftTextArea);

        JLabel rightLabel = new JLabel("Paste code to compare:");
        rightTextArea = new JTextArea(10, 40);
        JScrollPane rightScrollPane = new JScrollPane(rightTextArea);

        topPanel.add(leftLabel);
        topPanel.add(leftScrollPane);
        topPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        topPanel.add(rightLabel);
        topPanel.add(rightScrollPane);

        add(topPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton runButton = new JButton("Check Plagiarism");
        runButton.addActionListener(this);
        bottomPanel.add(runButton);

        add(bottomPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null); 
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Check Plagiarism")) {
            String leftCode = leftTextArea.getText();
            String rightCode = rightTextArea.getText();

            List<String> leftTokens = tokenizeCode(leftCode);
            List<String> rightTokens = tokenizeCode(rightCode);

            double similarity = calculateSimilarity(leftTokens, rightTokens);

            String resultMessage;
            if (similarity > 0.7) {
                resultMessage = "Potential Plagiarism Detected! Similarity score: " + similarity;
            } else {
                resultMessage = "No Plagiarism Detected. Similarity score: " + similarity;
            }

            JOptionPane.showMessageDialog(this, resultMessage);
        }
    }

    private List<String> tokenizeCode(String code) {
        String[] tokens = code.split("[\\s\\[\\]{}();,]+");
        return Arrays.asList(tokens);
    }

    private double calculateSimilarity(List<String> list1, List<String> list2) {
        List<String> union = new ArrayList<>(list1);
        union.addAll(list2);

        List<String> intersection = new ArrayList<>(list1);
        intersection.retainAll(list2);

        double intersectionSize = intersection.size();
        double unionSize = union.size();

        return intersectionSize / unionSize;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PlagiarismChecker());
    }
}
