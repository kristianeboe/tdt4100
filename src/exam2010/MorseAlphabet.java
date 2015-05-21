package exam2010;

import java.util.Map;

/**
 * Created by Kristian on 21/05/15.
 */
public class MorseAlphabet extends RadioAlphabet {

    public MorseAlphabet() {
        super(null, " ");
        alphabet.put('s', "...");
        alphabet.put('o',"---");
        alphabet.put('t',"-");
        alphabet.put('e',".");
    }


    public void setWord(char letter, String word){

        alphabet.put(letter,word);
        super.fireChangedListner(letter);
    }
}
