import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	public static void main(String[] args) {
//		Check arguments
		String checker = args[0].substring(0);
		char checkerChar = checker.charAt(0);
		if(args[0].length() >1 && (checkerChar == 'a' || checkerChar == 'r' || checkerChar == 'c')){
			System.out.println(Constant.validText2);
			return;
		}
		if(checkerChar!='a' && checkerChar!= 'r' && checkerChar!= 'c' && checkerChar!='?' && checkerChar!='+'){
			System.out.println(Constant.validText);
			return;
		}
		if(args[0].equals("a")) {
			System.out.println(Constant.loadingText);
			try {
				BufferedReader bufferedReader = getBufferedReader();
				String line = bufferedReader.readLine();
				String Students[] = line.split(", ");
				for(String student : Students) {
					System.out.println(student);
				}
			}
			catch (Exception e){

			}
			System.out.println(Constant.dataLoaded);
		}
		else if(args[0].equals("r")) {
			System.out.println(Constant.loadingText);
			try {
				BufferedReader bufferedReader = getBufferedReader();
				String line = bufferedReader.readLine();
				String Students[] = line.split(", ");
				Random random = new Random();
				int numOfWords = Students.length;
				int index = random.nextInt(numOfWords);
				System.out.println(Students[index]);
			}
			catch (Exception e){
				System.out.println(Constant.dataNotFound);
			}
			System.out.println(Constant.dataLoaded);
		}
		else if(args[0].contains("+")){
			System.out.println(Constant.loadingText);
			try {
				BufferedWriter bufferedWriter = new BufferedWriter(
						new FileWriter(Constant.textFile, true));
				BufferedReader bufferedReader = getBufferedReader();
				String line = bufferedReader.readLine();
				extracted();
				String newLine = line;
				String given = args[0].substring(1);
				newLine+=", ";
				newLine+=given;
				Date date = new Date();
				String dateStyle = "dd/mm/yyyy-hh:mm:ss a";
				DateFormat dateFormat = new SimpleDateFormat(dateStyle);
				String formatedDate= dateFormat.format(date);
				bufferedWriter.write(newLine + "\nList newLine updated on " +formatedDate);
				bufferedWriter.close();
			}
			catch (Exception e){

			}
			System.out.println(Constant.dataLoaded);
		}
		else if(args[0].contains("?")) {
			System.out.println(Constant.loadingText);
			try {
				BufferedReader bufferedReader = getBufferedReader();
				String line = bufferedReader.readLine();
				String Students[] = line.split(", ");
				boolean done = false;
				String findString = args[0].substring(1);
				for(int idx = 0; idx<Students.length && !done; idx++) {
					if(Students[idx].equals(findString)) {
						System.out.println(Constant.dataFound);
						done=true;
					}
				}
				if(!done){
					System.out.println("The word you are searching for "+ "( " + findString + " )" + " is not found!");
				}
			}
			catch (Exception e){

			}
			System.out.println(Constant.dataLoaded);
		}
		else if(args[0].contains("c")) {
			System.out.println(Constant.loadingText);
			try {
				BufferedReader bufferedReader = getBufferedReader();
				String line =  bufferedReader.readLine();
				char StudentCharArray[] = line.toCharArray();
				int countOfKomma=0;
				for(char studentChar:StudentCharArray) {
					if( studentChar ==',')
					{
						countOfKomma++;
					}
				}
				System.out.println(countOfKomma+1 +" word(s) found ");
			}
			catch (Exception e){

			}
			System.out.println(Constant.dataLoaded);
		}
	}

	private static void extracted() throws IOException {
		FileWriter fileWriter = new FileWriter(Constant.textFile, false);
		PrintWriter printWriter = new PrintWriter(fileWriter, false);
		printWriter.flush();
		printWriter.close();
	}

	private static BufferedReader getBufferedReader() throws FileNotFoundException {
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(
						new FileInputStream(Constant.textFile)));
		return bufferedReader;
	}
}
