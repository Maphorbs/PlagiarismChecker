# PlagiarismChecker
# Plagiarism Checker Application using Java Swing

## Summary
The code implements a simple Plagiarism Checker application using Java Swing for the graphical user interface (GUI). This application allows users to input two code snippets and checks for potential plagiarism by comparing their similarity.

## Key Components
### GUI Layout:
- The application window uses a BorderLayout, dividing the UI into top and bottom panels.
- The top panel includes JTextAreas for users to paste their code snippets, with labels indicating the purpose of each area.
- The bottom panel contains a "Check Plagiarism" button for initiating the similarity check.

### Functionality:
- Upon clicking the "Check Plagiarism" button, the ActionListener performs the plagiarism detection process.
- The code uses tokenization to split the code snippets into individual words (tokens) and calculates their similarity using the Jaccard similarity coefficient.
- If the similarity score between the code snippets exceeds a predefined threshold (0.7 in this example), a message is displayed indicating potential plagiarism in a popup dialog using JOptionPane.showMessageDialog().
- The message indicates whether potential plagiarism is detected and provides the similarity score.

## How to Use
1. Run the application.
2. Paste the first code snippet in the "Paste your code here" area.
3. Paste the second code snippet in the "Paste code to compare" area.
4. Click the "Check Plagiarism" button.
5. A popup message will display the result: either detecting potential plagiarism or confirming no plagiarism, along with the similarity score.

This implementation provides basic functionality to compare code snippets for similarity based on tokenization and a threshold-based similarity check. Users can use this tool to get an indication of potential plagiarism between two code samples.
