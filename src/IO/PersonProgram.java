package IO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class PersonProgram {
	private List<Person> personer;

	public void init() {
		personer = new ArrayList<Person>(Arrays.asList(new Person1("Hallvard",
				"Trætteberg"), new Person2("Marit Reitan"), new Person2(
				"Jens Trætteberg"), new Person1("Anne", "Reitan")));
	}

	private void writerPerson(Person p, PrintWriter writer) {
		writer.println(p.getFullName());
	}

	private Person readPerson(BufferedReader reader) {
		try {
			String line = reader.readLine();
			return new Person2(line);
		} catch (Exception e) {
			return null;
		}
	}

	public void run() {
		System.out.println("Ut: " + personer);
		try {
			PrintWriter writer = new PrintWriter("personer.txt");
			for (Person person : personer) {
				writerPerson(person, writer);
			}
			writer.close();
		} catch (FileNotFoundException e) {
		}

		Collection<Person> innlestePersoner = new ArrayList<Person>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(
					"personer.txt"));
			while (reader.ready()) {
				innlestePersoner.add(readPerson(reader));
			}
			reader.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
	}

	public static void main(String[] args) {
		PersonProgram program = new PersonProgram();
		program.init();
		program.run();
	}
}
