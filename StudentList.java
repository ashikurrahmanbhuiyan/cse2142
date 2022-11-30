import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
	public static void main(String[] args) {

		// Check arguments
		if(args.length != 1){
			System.out.println(constants.errorMessage);   // show error message
		}else{
		if (args[0].equals(constants.displayCommand)) {   // display all
			System.out.println(constants.waitingMessage); // waiting to load data
			try {
				for (String names : students().split(constants.separator)) // separator between string
					System.out.println(names);
			} catch (Exception e) {
			}
			System.out.println(constants.endMessage); //data load finish
		} else if (args[0].equals(constants.randomAccessCommand)) { // random access data
			System.out.println(constants.waitingMessage);
			try {
				String student[] = students().split(constants.separator);
				Random pick = new Random();   //
				System.out.println(student[pick.nextInt(student.length)]);
			} catch (Exception e) {
			}
			System.out.println(constants.endMessage);
		} else if (args[0].contains(constants.addCommand)) {
			System.out.println(constants.waitingMessage);
			try {
				BufferedWriter students = student();
				Date date = new Date();
				DateFormat dateFormat = new SimpleDateFormat(constants.timeFormat);
				students.write(constants.separator + args[0].substring(constants.one) + constants.updateMessage + dateFormat.format(date));
				students.close();
			} catch (Exception e) {
			}
			System.out.println(constants.endMessage);
		} else if (args[0].contains(constants.searchCommand)) {
			System.out.println(constants.waitingMessage);
			try {
				String student[] = students().split(constants.separator);
				for (int idx = 0; idx < student.length; idx++) {
					if (student[idx].equals(args[0].substring(constants.one))) {
						System.out.println(constants.foundMessage);
						break;
					}
				}
			} catch (Exception e) {
			}
			System.out.println(constants.endMessage);
		} else if (args[0].contains(constants.countCommand)) {
			System.out.println(constants.waitingMessage);
			try {
				String student[] = students().split(constants.separator);  
				System.out.println(student.length + constants.countMessage);
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