/*  WordNode.java 
 *  Author: Nisarg Patil
 *  GitHub ID: ngpatil
 *  Description: This class represents a node for a WordList. It tracks the word it holds as well as the next word in the sequence.
*/

public class WordNode {

    /* Private Member Variables */
    private String word;
    private WordNode next;

    /* Constructors */
    public WordNode(String w) {
        word = w;
        next = null;
    }

    /* Setters */
    public void setWord(String w) {
        word = w;
    }

    public void setNext(WordNode n) {
        next = n;
    }

    /* Getters */
    public String getWord() {
        return word;
    }

    public WordNode getNext() {
        return next;
    }
}
