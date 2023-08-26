
package quiz.application.with.timer;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Score extends JFrame implements ActionListener {
    Score(int score, int correctAnswers, int incorrectAnswers){
        setBounds(50, 0, 500,500);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel head = new JLabel("THANK YOU FOR PLAYING QUIZ");
        head.setBounds(50, 50, 1000, 50);
        head.setFont(new Font("Tahoma", Font.PLAIN, 26));
        head.setForeground(Color.BLUE);
        add(head);
        
        JLabel lblscore = new JLabel("Your score is " + score);
        lblscore.setBounds(100, 160, 300, 50);
        lblscore.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblscore.setForeground(Color.magenta);
        add(lblscore);
        
        JLabel detail = new JLabel("Total Correct Answers: " + correctAnswers);
        detail.setBounds(100, 250, 300, 50);
        detail.setFont(new Font("Tahoma", Font.PLAIN, 22));
        detail.setForeground(Color.GREEN);
        add(detail);
        
        JLabel detail2 = new JLabel("Total Incorrect Answers: " + incorrectAnswers);
        detail2.setBounds(100, 280, 300, 50);
        detail2.setFont(new Font("Tahoma", Font.PLAIN, 22));
        detail2.setForeground(Color.RED);
        add(detail2);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }
    
    public static void main(String[] args){
        new Score(0, 0, 0);
    }
}
