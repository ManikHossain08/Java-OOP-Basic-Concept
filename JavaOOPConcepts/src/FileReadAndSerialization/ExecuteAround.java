package FileReadAndSerialization;


// https://www.geeksforgeeks.org/serialization-in-java/
// https://www.codejava.net/java-se/file-io/java-serialization-basic-example


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ExecuteAround {

  //private static final String FILE = "";//ExecuteAround.class.getResource("/Users/info.txt").getFile();
  private static final String MacOSXPathToReadFile = "/Users/info.txt";

  public static void main(String... args) throws IOException {
    // method we want to refactor to make more flexible
	
	// this method is working exactly same functionality like this code.   
	ScanFile();
    String result = processFileLimited();
    System.out.println(result);

    System.out.println("---");

    String oneLine = processFile((BufferedReader b) -> b.readLine());
    System.out.println(oneLine);

    String twoLines = processFile((BufferedReader b) -> b.readLine() + b.readLine());
    System.out.println(twoLines);
  }

  public static void ScanFile() {
	  String filename = MacOSXPathToReadFile;
		File file = new File(filename);
		try {
			Scanner sc = new Scanner(file);
			while (sc.hasNext()) {
				String data = sc.nextLine();
				System.out.println(data);
				//data = filterData(data);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
  }
  

  public static String processFileLimited() throws IOException {
    try (BufferedReader br = new BufferedReader(new FileReader(MacOSXPathToReadFile))) {
      return br.readLine();
    }
  }

  public static String processFile(BufferedReaderProcessor p) throws IOException {
    try (BufferedReader br = new BufferedReader(new FileReader(MacOSXPathToReadFile))) {
      return p.process(br);
    }
  }

  public interface BufferedReaderProcessor {

    String process(BufferedReader b) throws IOException;

  }

}
