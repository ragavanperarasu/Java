import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizGame extends JFrame implements ActionListener {

    private Container container;
    private JLabel questionLabel, resultLabel;
    private JRadioButton option1, option2, option3, option4;
    private ButtonGroup optionsGroup;
    private JButton nextButton;
    private int currentQuestionIndex = 0;
    private int score = 0;

    // Sample quiz data
    String[][] questions = {
            {"What is the capital of France?", "Paris", "Berlin", "Madrid", "Rome", "Paris"},
            {"Which planet is known as the Red Planet?", "Earth", "Mars", "Jupiter", "Venus", "Mars"},
            {"Who developed the theory of relativity?", "Newton", "Einstein", "Galileo", "Tesla", "Einstein"},
            {"What is the largest ocean on Earth?", "Atlantic", "Pacific", "Indian", "Arctic", "Pacific"}
    };

    public QuizGame() {
        setTitle("Quiz Game");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container = getContentPane();
        container.setLayout(null);

        // Set background color
        container.setBackground(Color.decode("#1B1B1B"));

        // Question label
        questionLabel = new JLabel();
        questionLabel.setFont(new Font("Arial", Font.BOLD, 20));

        questionLabel.setForeground(Color.decode("#C71585"));
        questionLabel.setBounds(50, 30, 500, 30);
        container.add(questionLabel);

        // Options
        option1 = new JRadioButton();
        option2 = new JRadioButton();
        option3 = new JRadioButton();
        option4 = new JRadioButton();

        optionsGroup = new ButtonGroup();
        optionsGroup.add(option1);
        optionsGroup.add(option2);
        optionsGroup.add(option3);
        optionsGroup.add(option4);

        option1.setBounds(50, 80, 200, 30);
        option2.setBounds(300, 80, 200, 30);
        option3.setBounds(50, 120, 200, 30);
        option4.setBounds(300, 120, 200, 30);

        option1.setBackground(Color.decode("#1B1B1B"));
        option2.setBackground(Color.decode("#1B1B1B"));
        option3.setBackground(Color.decode("#1B1B1B"));
        option4.setBackground(Color.decode("#1B1B1B"));

        option1.setForeground(Color.white);
        option2.setForeground(Color.white);
        option3.setForeground(Color.white);
        option4.setForeground(Color.white);

        option1.setFont(new Font("Arial", Font.PLAIN, 18));
        option2.setFont(new Font("Arial", Font.PLAIN, 18));
        option3.setFont(new Font("Arial", Font.PLAIN, 18));
        option4.setFont(new Font("Arial", Font.PLAIN, 18));

        container.add(option1);
        container.add(option2);
        container.add(option3);
        container.add(option4);

        // Next Button
        nextButton = new JButton("Next");
        nextButton.setFont(new Font("Arial", Font.BOLD, 14));
        nextButton.setForeground(Color.WHITE);
        nextButton.setBackground(new Color(0, 102, 0));
        nextButton.setBounds(150, 180, 150, 40);
        nextButton.setBorder(new RoundedBorder(40));
        nextButton.addActionListener(this);
        container.add(nextButton);

        // Result Label
        resultLabel = new JLabel();
        resultLabel.setFont(new Font("Arial", Font.BOLD, 16));
        resultLabel.setForeground(Color.WHITE);
        resultLabel.setBounds(50, 300, 500, 30);
        container.add(resultLabel);

        loadQuestion();
        setVisible(true);
    }

    // Load the current question and options
    private void loadQuestion() {
        questionLabel.setText("Q" + (currentQuestionIndex + 1) + ": " + questions[currentQuestionIndex][0]);
        option1.setText(questions[currentQuestionIndex][1]);
        option2.setText(questions[currentQuestionIndex][2]);
        option3.setText(questions[currentQuestionIndex][3]);
        option4.setText(questions[currentQuestionIndex][4]);
        optionsGroup.clearSelection(); // Clear previous selection

    }

    // Check if the selected option is correct
    private boolean isCorrectAnswer() {
        String selectedAnswer = "";
        if (option1.isSelected()) {
            selectedAnswer = option1.getText();
        } else if (option2.isSelected()) {
            selectedAnswer = option2.getText();
        } else if (option3.isSelected()) {
            selectedAnswer = option3.getText();
        } else if (option4.isSelected()) {
            selectedAnswer = option4.getText();
        }
        nextButton.setVisible(true);
        return selectedAnswer.equals(questions[currentQuestionIndex][5]);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (isCorrectAnswer()) {
            score++;

        }

        currentQuestionIndex++;

        if (currentQuestionIndex < questions.length) {
            loadQuestion(); // Load the next question
        } else {
            resultLabel.setText("Quiz Finished! Your score: " + score + "/" + questions.length);
            nextButton.setEnabled(false); // Disable button after last question
        }
    }

    public static void main(String[] args) {
        new QuizGame();
    }
}

class RoundedBorder implements Border {
    private int radius;

    RoundedBorder(int radius) {
        this.radius = radius;
    }

    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
    }

    public boolean isBorderOpaque() {
        return true;
    }

    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
    }
}

/*
Algorithm:
Initialize the Quiz Game:

Create a JFrame window with a colorful background.
Add components such as question labels, radio buttons for options, and a button to move to the next question.
Load Questions:

Store questions and their options in a 2D array. The last entry in each row contains the correct answer.
Display one question at a time, along with its options.
Answer Validation:

Check if the user-selected option matches the correct answer.
If the answer is correct, increase the score.
Next Question:

Upon clicking the "Next Question" button, load the next question from the array.
After the final question, display the user's score and disable further input.
*/