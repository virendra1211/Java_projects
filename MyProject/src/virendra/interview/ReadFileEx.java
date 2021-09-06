package virendra.interview;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadFileEx {
	public static void main(String[] args) throws IOException {
		FileInputStream fstream = new FileInputStream("C:/MyDrive/work/mycv.csv");
		DataInputStream in = new DataInputStream(fstream);
		int nof = 10;
		int nol = 50;
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String strLine;

		for (int j = 1; j <= nof; j++) {
			FileWriter fstream1 = new FileWriter("C:/MyDrive/work" + j + ".txt"); // Destination File Location
			BufferedWriter out = new BufferedWriter(fstream1);
			for (int i = 1; i <= nol; i++) {
				strLine = br.readLine();
				if (strLine != null) {
					out.write(strLine);
					if (i != nol) {
						out.newLine();
					}
				}
			}
			out.close();
		}

		in.close();
	}
}
