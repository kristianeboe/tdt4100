package eksamen2014;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Kristian on 21/05/15.
 */
public class Quiz {

    private List<Question> questions;

    public Quiz(List<Question> questions) {
        this.questions = new ArrayList<>();
        if (questions != null) {
            this.questions.addAll(questions);
        }
    }

    public Quiz() {
        this.questions = new ArrayList<>();
        try (
                InputStream stream = new FileInputStream("");
                InputStreamReader reader = new InputStreamReader(stream);
                BufferedReader bufferedReader = new BufferedReader(reader);
        ) {
            while (bufferedReader.ready()) {
                String question = bufferedReader.readLine();
                String answer = bufferedReader.readLine();
                String nxtLine = bufferedReader.readLine();
                if (!nxtLine.equals("")) {
                    List<String> alternatives = new ArrayList<>();
                    alternatives.add(nxtLine);
                    while (!nxtLine.equals("")) {
                        nxtLine = bufferedReader.readLine();
                        alternatives.add(nxtLine);
                    }
                    questions.add(new StringOptionsQuestions(question, answer, alternatives));
                }
                if (answer.equals("true") || answer.equals("false")) {
                    questions.add(new BooleanQuestion(question, Boolean.parseBoolean(answer)));
                } else {
                    questions.add(new StringQuestion(question, answer));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void addQuestion(Question question) {
        if (!questions.contains(question)) {
            questions.add(question);
        }
    }

    public void runQuiz() {
        Scanner scanner = new Scanner(System.in);
        for (Question question : questions) {
            while (true) {
                question.askQuestion(System.out);
                String answer = scanner.next();
                if (question.checkAnswer(answer)) {
                    break;
                } else {
                    System.out.println("Feil, prøv igjen!");
                }
            }
        }
    }

    public void start(boolean mode, OutputStream out, InputStream in){

    }

    public int doQuestion(){
        return 0;
    }

    public void stop(){

    }

    public static void main(String[] args) {
        List<Question> questions = new ArrayList<>();
        Quiz quiz = new Quiz(questions);
        quiz.addQuestion(new StringOptionsQuestions("Hva heter jeg?", "Kristian", new ArrayList<>(Arrays.asList("Pål", "Nicolaij", "Kristian"))));
        quiz.addQuestion(new BooleanQuestion("True?", true));
        quiz.addQuestion(new StringQuestion("Hva er hovedstaden i Norge?", "Oslo"));
        quiz.start(true, System.out, System.in);
        while (quiz.doQuestion()>0);
        quiz.stop();
    }
}
