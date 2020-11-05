import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LinkedListDemo2
{
	public static void main(String[] args) throws IOException
	{
		long startTime = System.nanoTime();
		String dataFile = "C:\\Stuff\\AccountNumbers.csv";
		BufferedReader reader = new BufferedReader(new FileReader(dataFile));
		int numLines = 0;
		BufferedReader br = null;

		// Count the number of lines in the data file
		System.out.print("Counting lines in the data file ... ");
		while (reader.readLine() != null)
			numLines++;
		reader.close();
		System.out.println(numLines);

		// Get data set from file and load array with values
		System.out.println("Building array from the data file ...");
		br = new BufferedReader(new FileReader(dataFile));

		LinkedList2 ll = new LinkedList2();
		
		startTime = System.nanoTime();
		for (int i = 0; i < numLines; i++)
		{
			ll.append(Integer.parseInt(br.readLine()));
		}
		timeConvert(startTime, "initialize");
		
		//measure traversal time
		startTime = System.nanoTime();
		System.out.println("Total size: " + ll.length());
		timeConvert(startTime, "traversal");
		
		//measure search time
		startTime = System.nanoTime();
		System.out.println("Index of 838399: " + ll.searchList(838399));
		timeConvert(startTime, "search");
		
		//measure append time
		startTime = System.nanoTime();
		ll.insert(true, 0, "", "", 0);
		timeConvert(startTime, "append");
		
		ll = null;		
		br.close();
	}

	private static void timeConvert(long startTime, String s)
	{
		startTime = System.nanoTime() - startTime;
		float converted = (float) ((startTime) / 1000000.0);
		converted = (float) (Math.round(converted * 1000.0) / 1000.0);
		System.out.println(s + " total Time: " + converted + "ms");
	}
}
