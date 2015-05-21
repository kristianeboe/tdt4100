package exam2010;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kristian on 21/05/15.
 */
public class RadioAlphabet{

    protected Map<Character, String> alphabet;

    protected Collection<RadioAlphabetListener> listeners;

    public RadioAlphabet(String alphabet, String delimiter) {
        this.alphabet = new HashMap();
        listeners = new ArrayList<>();
        if (alphabet != null) {
            for (String word : alphabet.split(delimiter)) {
                this.alphabet.put(word.charAt(0), word);
            }
        }
    }

    public boolean converts(char letter) {
        return alphabet.containsKey(letter);
    }

    public String convert(char letter) {
        return converts(letter) ? alphabet.get(letter) : null;
    }

    public String convert(String phrase) {
        String converted = "";
        for (char c : phrase.toCharArray()) {
            if (converts(c)) {
                converted += alphabet.get(c) + " ";
            }
        }
        return converted.trim();
    }

    public void setWord(String word) {
        if (!converts(word.charAt(0))) {
            alphabet.put(word.charAt(0), word);
            fireChangedListner(word.charAt(0));

        }
    }

    public void removeWord(String word) {
        if (alphabet.values().contains(word)) {
            alphabet.remove(word.charAt(0));
            fireChangedListner(word.charAt(0));
        }
    }

    public void addListener(RadioAlphabetListener listener){
        if (!listeners.contains(listener)){
            listeners.add(listener);
        }

    }

    public void removeListener(RadioAlphabetListener listener){
        if (listeners.contains(listener)){
            listeners.remove(listener);
        }
    }

    protected void fireChangedListner(char c){
        listeners.stream().forEach(l -> l.radioAlphabetChanged(this,c));
        System.out.println(c+" now means "+alphabet.get(c));
    }

    public static void main(String[] args) {
        RadioAlphabet ra = new RadioAlphabet("alfa-bravo- delta-charlie", "-");
        System.out.println(ra.convert('a'));
        System.out.println(ra.convert('9'));
        System.out.println(ra.converts('a'));
        System.out.println(ra.converts('0'));
        System.out.println(ra.convert("abba"));
        MorseAlphabet ma = new MorseAlphabet();
        System.out.println(ma.convert('s'));
        System.out.println(ma.convert('9'));
        System.out.println(ma.converts('s'));
        System.out.println(ma.converts('0'));
        System.out.println(ma.convert("sos"));
        System.out.println(ma.convert("test"));
    }


}
