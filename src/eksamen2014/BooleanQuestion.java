package eksamen2014;

import java.io.PrintStream;

/**
 * Created by Kristian on 21/05/15.
 */
public class BooleanQuestion extends Question {

    public BooleanQuestion(String question, boolean answer) {
        super(question, Boolean.toString(answer));
    }

    @Override
    public void askQuestion(PrintStream stream) {
        super.askQuestion(stream);
    }

}
