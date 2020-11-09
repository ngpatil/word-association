/*  App.java 
 *  Author: Nisarg Patil
 *  GitHub ID: ngpatil
 *  Description: This class handles the GUI, user inputs, and writes to file for the WAP.
*/

/* Imports */
import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {

        JOptionPane.showMessageDialog(null, "Welcome to the Word Assocation Program!", "WAP",
                JOptionPane.INFORMATION_MESSAGE);

        String name = JOptionPane.showInputDialog(null, "Enter your last name:", "WAP",
                JOptionPane.INFORMATION_MESSAGE);

        Integer[] options = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int timeLimit = (Integer) JOptionPane.showInputDialog(null, "Pick a time limit (mins):", "Time Limit",
                JOptionPane.QUESTION_MESSAGE, null, options, options[2]);

        JOptionPane.showMessageDialog(null,
                "Enter the first word that comes to your mind.\n            Continue until time runs out.", "WAP",
                JOptionPane.INFORMATION_MESSAGE);

        String input = JOptionPane.showInputDialog(null, "Enter a starting word:", "WAP",
                JOptionPane.INFORMATION_MESSAGE);

        WordList wList = new WordList(input);

        String prev = input;

        for (int i = 0; i < timeLimit - 1; i++) {
            input = JOptionPane.showInputDialog(null, prev, "WAP", JOptionPane.INFORMATION_MESSAGE);
            wList.addWord(input);
            prev = input;
        }
        System.out.print("WAP Results for " + name + ":\n\n");
        System.out.println(wList);

        JOptionPane.showMessageDialog(null,
                "Your results have been saved to " + name + ".txt.\nThank you for participating!", "WAP",
                JOptionPane.INFORMATION_MESSAGE);

    }
}
