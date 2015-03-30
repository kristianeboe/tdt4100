package stateandbehavior;
import java.util.Random;

public class RandomStringGenerator {
	Random number;
	int min;
	int max;
	
	public RandomStringGenerator(){
		number = new Random();
		min = 1;
		max = number.nextInt(10);
	}
	public String getRandomString(){
		String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String rStr = "";
		for(int i = this.min; i<this.max;i++){
			int temp = number.nextInt(25);
			rStr = rStr + str.charAt(temp);
		}
		return rStr;
	}
	

}
