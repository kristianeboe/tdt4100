package eksamen2014;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

/**
 * Created by Kristian on 21/05/15.
 */
public abstract class Question {

    public final String question, answer;
    protected List<String> alternatives;

    public Question(String question, String answer){
        this.question = question;
        this.answer = answer;
        this.alternatives = new ArrayList<>();
    }

    public Question(String question, String answer, List<String> alternatives){
        this(question, answer);
        checkAlternatives(alternatives);
        this.alternatives.addAll(alternatives);
    }

    public void askQuestion(PrintStream stream){
        String str = question;
        if (!alternatives.isEmpty()){
            int counter = 0;
            str+=" ";
            for (String choice:alternatives){
                counter++;
                str+=(counter) + " " + choice + " ";
            }
        }
        stream.print(str);
    }

    public boolean checkAnswer(String answer){
        if (!alternatives.isEmpty()){
            return this.answer.equals(answer) || this.answer.equals(alternatives.get(Integer.parseInt(answer)-1));
        } else {
            return this.answer.equals(answer);
        }
    }

    public List<String> getAlternatives(){
        return alternatives;
    }

    public void setAlternatives(List<String> alternatives){
        checkAlternatives(alternatives);
        this.alternatives = alternatives;
    }

    protected void checkAlternatives(List<String> alternatives){
        if (!alternatives.contains(answer)){
            throw new IllegalArgumentException("Answer is not in alternatives");
        }
    }

}
