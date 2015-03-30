package stateandbehavior;
import java.util.Scanner;

public class CounterProgram {
    private Counter counter;
     
    public void init(int a, int b) {
        counter = new Counter(a, b);
    }
 
    public void run() {
        System.out.println(counter);
        counter.count();
        System.out.println(counter);
        counter.count();
        System.out.println(counter);
        counter.count();
        System.out.println(counter);
    }
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    	CounterProgram counterProgram = new CounterProgram();
        counterProgram.init(scanner.nextInt(), scanner.nextInt());
        counterProgram.run();
        scanner.close();
    }
}
