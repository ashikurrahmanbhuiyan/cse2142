import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
	public static void main(String[] args) {

		// Check arguments
		if(args.length == 0){
			System.out.println(constants.errorMessage);
		}else{
		if (args[0].equals(constants.displayCommand)) {
			System.out.println(constants.waitingMessage);
			try {
				String read = students();
				String student[] = read.split(constants.separator);
				for (String names : student) {
					System.out.println(names);
				}
			} catch (Exception e) {
			}
			System.out.println(constants.endMessage);
		} else if (args[0].equals(constants.randomAccessCommand)) {
			System.out.println(constants.waitingMessage);
			try {
				String read = students();
				String student[] = read.split(constants.separator);
				Random pick = new Random();
				int picked = pick.nextInt(student.length);
				System.out.println(student[picked]);
			} catch (Exception e) {
			}
			System.out.println(constants.endMessage);
		} else if (args[0].contains(constants.addCommand)) {
			System.out.println(constants.waitingMessage);
			try {
				BufferedWriter students = student();
				String t = args[0].substring(constants.one);
				Date date = new Date();
				String format= constants.timeFormat;
				DateFormat dateFormat = new SimpleDateFormat(format);
				String dates = dateFormat.format(date);
				students.write(constants.separator + t + constants.updateMessage + dates);
				students.close();
			} catch (Exception e) {
			}

			System.out.println(constants.endMessage);
		} else if (args[0].contains(constants.searchCommand)) {
			System.out.println(constants.waitingMessage);
			try {
				String read = students();
				String student[] = read.split(constants.separator);
				boolean done = false;
				String t = args[0].substring(constants.one);
				for (int idx = 0; idx < student.length && !done; idx++) {
					if (student[idx].equals(t)) {
						System.out.println(constants.foundMessage);
						done = true;
					}
				}
			} catch (Exception e) {
			}
			System.out.println(constants.endMessage);
		} else if (args[0].contains(constants.countCommand)) {
			System.out.println(constants.waitingMessage);
			try {
				String read = students();
				char letters[] = read.toCharArray();
				boolean in_word = false;
				int count = 0;
				for (char letter : letters) {
					if (letter == constants.singleSpaceChar) {
						if (!in_word) {
							count++;
							in_word = true;
						} else {
							in_word = false;
						}
					}
				}
				System.out.println(count + constants.countMessage);
			} catch (Exception e) {
			}
			System.out.println(constants.endMessage);
		}else{
			System.out.println(constants.errorMessage);
		}
	}
	}

	private static BufferedWriter student() throws IOException {
		BufferedWriter students = new BufferedWriter(
				new FileWriter(constants.inputFileName, true));
		return students;
	}

	private static String students() throws FileNotFoundException, IOException {
		BufferedReader students = new BufferedReader(
				new InputStreamReader(
						new FileInputStream(constants.inputFileName)));
		String read = students.readLine();
		students.close();
		return read;
	}
}