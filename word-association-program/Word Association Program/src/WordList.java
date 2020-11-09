/*  WordList.java 
 *  Author: Nisarg Patil
 *  GitHub ID: ngpatil
 *  Description: This class represents a singly-linked list that stores a sequence of words.
*/
public class WordList {

    /* Private Member Variables */
    private WordNode head;
    private WordNode tail;
    private int length;

    /* Constructors */
    public WordList(String word) {
        head = new WordNode(word);
        tail = head;
        length = 1;
    }

    /* Setters */
    public void setHead(WordNode node) {
        head = node;
    }

    public void setTail(WordNode node) {
        tail = node;
    }

    public void setLength(int l) {
        length = l;
    }

    /* Getters */
    public WordNode getHead() {
        return head;
    }

    public WordNode getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    /* addWord */
    /*
     * Parameters: word - a String containing the word to be added to the list
     * 
     * Preconditions: The WordList has already been constructed.
     * 
     * Postconditions: The next variable of the tail WordNode is set to the new
     * word, and tail is set to the new WordNode. length is incremented
     */
    public void addWord(String word) {
        WordNode newTail = new WordNode(word);
        tail.setNext(newTail);
        tail = newTail;
        length++;
    }

    /* toString */
    /*
     * Parameters: none
     * 
     * Preconditions: The WordList has already been constructed.
     * 
     * Postconditions: A String is returned that represents how the WordList would
     * be outputted to a txt file.
     */
    public String toString() {
        String output = "";

        WordNode curr = head;
        while (curr != null) {
            output += curr.getWord() + "\n";
            curr = curr.getNext();
        }

        // word summaries
        output += "\n";
        output += "Total words: " + length + "\n";

        return output;

    }
}
