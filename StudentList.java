import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
	public static void main(String[] args) {

		// Check arguments
		if(args.length == 0){
			System.out.println("put a valid argument");
		}else{
		if (args[0].equals("a")) {
			System.out.println("Loading data ...");
			try {
				BufferedReader students = new BufferedReader(
						new InputStreamReader(
								new FileInputStream("students.txt")));
				String read = students.readLine();
				students.close();
				String student[] = read.split(", ");
				for (String names : student) {
					System.out.println(names);
				}
			} catch (Exception e) {
			}
			System.out.println("Data Loaded.");
		} else if (args[0].equals("r")) {
			System.out.println("Loading data ...");
			try {
				BufferedReader students = new BufferedReader(
						new InputStreamReader(
								new FileInputStream("students.txt")));
				String read = students.readLine();
				students.close();
				String student[] = read.split(", ");
				Random pick = new Random();
				int picked = pick.nextInt(student.length);
				System.out.println(student[picked]);
			} catch (Exception e) {
			}
			System.out.println("Data Loaded.");
		} else if (args[0].contains("+")) {
			System.out.println("Loading data ...");
			try {
				BufferedWriter students = new BufferedWriter(
						new FileWriter("students.txt", true));
				String t = args[0].substring(1);
				Date date = new Date();
				String format= "dd/mm/yyyy-hh:mm:ss a";
				DateFormat dateFormat = new SimpleDateFormat(format);
				String dates = dateFormat.format(date);
				students.write(", " + t + "\nList last updated on " + dates);
				students.close();
			} catch (Exception e) {
			}

			System.out.println("Data Loaded.");
		} else if (args[0].contains("?")) {
			System.out.println("Loading data ...");
			try {
				BufferedReader students = new BufferedReader(
						new InputStreamReader(
								new FileInputStream("students.txt")));
				String reader = students.readLine();
				students.close();
				String student[] = reader.split(", ");
				boolean done = false;
				String t = args[0].substring(1);
				for (int idx = 0; idx < student.length && !done; idx++) {
					if (student[idx].equals(t)) {
						System.out.println("We found it!");
						done = true;
					}
				}
			} catch (Exception e) {
			}
			System.out.println("Data Loaded.");
		} else if (args[0].contains("c")) {
			System.out.println("Loading data ...");
			try {
				BufferedReader students = new BufferedReader(
						new InputStreamReader(
								new FileInputStream("students.txt")));
				String read = students.readLine();
				students.close();
				char letters[] = read.toCharArray();
				boolean in_word = false;
				int count = 0;
				for (char letter : letters) {
					if (letter == ' ') {
						if (!in_word) {
							count++;
							in_word = true;
						} else {
							in_word = false;
						}
					}
				}
				System.out.println(count + " word(s) found ");
			} catch (Exception e) {
			}
			System.out.println("Data Loaded.");
		}else{
			System.out.println("put a valid argument");
		}
	}
	}
}