package basic.topic.interview;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CallMain {
	public static void main(String[] args) throws IOException {
		verifyFileReaderException();
		try {
		//	main(null);
		} catch (StackOverflowError se) {
			System.out.println(";;;");
			System.err.print(se.getMessage());
		}finally {
		//	System.out.println("finally block");
		}
		
	}
	
	
	public static void verifyFileReaderException() throws FileNotFoundException {
		BufferedReader br = new BufferedReader(new FileReader("C:\\IFRToolLog.txt"));
		try(br){
			System.out.println(br.readLine());
			}catch(IOException ie) {
				System.out.println(ie);
			}
		}
}
