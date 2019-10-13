package Coding_Exam_B;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CodingExamB {
	/*
	 * This is a logging program for collecting TODO comments in a program. The program will scan
	 * Through all the files in the Coding_Exam_B/classes package, and collect all the comments that start
	 * with //TODO: and write them to their own file. See the TODO_Log_example.txt file for an idea of what 
	 * the final file output will look like.
	 */
	
	
	public static String getLoggingInfo(String fileName) {
		/*
		 * 1. Complete the getLoggingInfoMethod.
		 *    The method takes in a String for a file and returns a String. 
		 *    The method will open the file a read through it. It will then 
		 *    take all the comments that begin with //TODO: and combine them 
		 *    into one large String. The string will also state the file name and
		 *    the line number for where each TODO was found. 
		*/
		String TODO = "";
		ArrayList<Integer> arrLines = new ArrayList<Integer>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line;
			int lineVal = 0;
			try {
				line = br.readLine();
				TODO = "";
				while (line != null) {
					lineVal++;
					if (line.contains("TODO")) {
						TODO += fileName + ": " + "line " + lineVal + ": " + line;
						TODO += "\n";
						//System.out.println(TODO);
					}
					arrLines.add(lineVal);
					line = br.readLine();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return TODO;
	}
	
	public static void main(String[] args) throws IOException {
		String finalLogString = getLoggingInfo("src/Coding_Exam_B/classes/Camera.java");
		finalLogString += getLoggingInfo("src/Coding_Exam_B/classes/RayTracedImageViewer.java");
		finalLogString += getLoggingInfo("src/Coding_Exam_B/classes/RayTracer.java");
		finalLogString += getLoggingInfo("src/Coding_Exam_B/classes/Vector3.java");
		System.out.println(finalLogString);
		/*
		 * 2. Write the finalLogString to a file called TODO_Log.txt. The file should match TODO_Log_example.txt. 
		 */
			BufferedWriter bw = new BufferedWriter(new FileWriter("src/Coding_Exam_B/TODO_Log_example.txt"));
			bw.write(finalLogString);
			// TODO Auto-generated catch block

	}
}
