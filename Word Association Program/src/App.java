/*  App.java 
 *  Author: Nisarg Patil
 *  GitHub ID: ngpatil
 *  Description: This class handles the GUI, user inputs, and writes to file for the WAP.
*/

/* Imports */
import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileWriter;

public class App {
    public static void main(String[] args) throws Exception {

        JOptionPane.showMessageDialog(null, "Welcome to the Word Assocation Program!", "WAP",
                JOptionPane.INFORMATION_MESSAGE);

        // used to create a unique filename
        String name = JOptionPane.showInputDialog(null, "Enter your last name:", "WAP",
                JOptionPane.INFORMATION_MESSAGE);

        // these are some default options, subject to change
        Integer[] options = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
        int wordLimit = (Integer) JOptionPane.showInputDialog(null, "Pick a word limit:", "Word Limit",
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        JOptionPane.showMessageDialog(null, "Enter the first word that comes to your mind.", "WAP",
                JOptionPane.INFORMATION_MESSAGE);

        // inputting the first word and creating the WordList
        String input = JOptionPane.showInputDialog(null, "Enter a starting word:", "WAP",
                JOptionPane.INFORMATION_MESSAGE);

        WordList wList = new WordList(input);

        // it is important that they always see the previous word
        String prev = input;

        // read in the rest of the words
        for (int i = 0; i < wordLimit - 1; i++) {
            input = JOptionPane.showInputDialog(null, prev, "WAP", JOptionPane.INFORMATION_MESSAGE);
            wList.addWord(input);
            prev = input;
        }

        // writing to file
        File file = new File(name + wList.getLength() + ".txt");
        file.createNewFile();
        FileWriter writer = new FileWriter(file);
        writer.write("WAP Results for " + name + ":\n\n");
        writer.write(wList.toString());
        writer.flush();
        writer.close();

        // exit message
        JOptionPane.showMessageDialog(null,
                "Your results have been saved to " + name + wList.getLength() + ".txt.\nThank you for participating!",
                "WAP", JOptionPane.INFORMATION_MESSAGE);

    }
}
