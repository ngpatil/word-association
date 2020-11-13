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

                // starting word
                String choice = JOptionPane.showInputDialog(null,
                                "Enter the starting word specified by the administrator:", "WAP",
                                JOptionPane.INFORMATION_MESSAGE);

                // these are some default options, subject to change
                Integer[] options = { 5, 10, 15, 20, 25, 30, 35, 40, 45, 50 };
                int wordLimit = (Integer) JOptionPane.showInputDialog(null, "Pick a word limit:", "Word Limit",
                                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

                JOptionPane.showMessageDialog(null,
                                "Enter words that come to your mind based on the word \"" + choice + "\".", "WAP",
                                JOptionPane.INFORMATION_MESSAGE);

                // inputting the first word and creating the WordList
                String input = JOptionPane.showInputDialog(null, choice, "WAP", JOptionPane.INFORMATION_MESSAGE);

                WordList wList = new WordList(input);

                // it is important that they always see the previous word
                String prev = input;

                // read in the rest of the words
                for (int i = 0; i < wordLimit - 1; i++) {
                        input = JOptionPane.showInputDialog(null, choice, "WAP", JOptionPane.INFORMATION_MESSAGE);
                        wList.addWord(input);
                        prev = input;
                }

                // writing to file
                File file = new File(name + "-" + choice + "-" + wList.getLength() + ".txt");
                file.createNewFile();
                FileWriter writer = new FileWriter(file);
                writer.write("WAP Results for " + name + ":\n\n");
                writer.write("Starting word: "+choice+"\n\n");
                writer.write(wList.toString());
                writer.flush();
                writer.close();

                // exit message
                JOptionPane.showMessageDialog(null,
                                "Your results have been saved to " + name + "-" + choice + "-" + wList.getLength()
                                                + ".txt.\nThank you for participating!",
                                "WAP", JOptionPane.INFORMATION_MESSAGE);

        }
}
