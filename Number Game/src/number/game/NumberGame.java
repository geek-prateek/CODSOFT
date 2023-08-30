package number.game;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class NumberGame extends JFrame implements ActionListener {
    private JLabel label;
    private JTextField inputField;
    private JTextArea outputArea;
    private JButton guessButton;
    private int randomNumber;
    private int guesses;

    public NumberGame() {
        setTitle("Number Game");
        setSize(300, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        
        label = new JLabel("Please Type a Number between 1 to 100 : ");
        label.setBounds(10,20,300,30);
        label.setForeground(Color.BLUE);
        
        inputField = new JTextField();
        inputField.setBounds(10,50,200,30);
        
        guessButton = new JButton("Guess");
        guessButton.setBounds(10, 100, 100, 30);
        
        outputArea = new JTextArea();
        outputArea.setForeground(Color.MAGENTA);
        outputArea.setBounds(10, 140, 280, 300);
        
        add(label);
        add(inputField);    
        add(guessButton);
        add(outputArea);

        guessButton.addActionListener(this);

        generateRandomNumber();
        guesses = 0;
    }

    private void generateRandomNumber() {
        Random random = new Random();
        randomNumber = random.nextInt(100) + 1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == guessButton) {
            String input = inputField.getText();
            if (!input.matches("\\d+")) {
                inputField.setText("");
                outputArea.append("Please type a number.\n");
                return;
            }

            int userGuess = Integer.parseInt(input);
            guesses++;

            if (userGuess == randomNumber) {
                outputArea.append("Wow! You got it right!\n");
                outputArea.append("You got it in " + guesses + " guesses\n");
                guessButton.setEnabled(false);
            } else if (userGuess > randomNumber) {
                outputArea.append("You were above the number!\n");
            } else {
                outputArea.append("You were below the number!\n");
            }

            inputField.setText("");
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            NumberGame game = new NumberGame();
            game.setVisible(true);
        });
    }
    
}
