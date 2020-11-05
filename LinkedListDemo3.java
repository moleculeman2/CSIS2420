import java.util.LinkedList;
import java.util.function.Function;
import java.util.Iterator;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LinkedListDemo3 
{
	public static void main(String[] args) throws IOException
	{
		long startTime = System.nanoTime();
		LinkedList<Integer> intList = new LinkedList<Integer>();
	    
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
		
		startTime = System.nanoTime();
		for (int i = 0; i < numLines; i++)
		{
			intList.add((Integer.parseInt(br.readLine())));
		}
		timeConvert(startTime, "initialize");
		
		//measure traversal time
		startTime = System.nanoTime();
		System.out.println("Total size: " + intList.size());
		timeConvert(startTime, "traversal");
		
		//measure search time
		startTime = System.nanoTime();
		System.out.println("Index of 838399: " + intList.lastIndexOf(838399));
		timeConvert(startTime, "search");
		
		//measure append time
		startTime = System.nanoTime();
		System.out.println("Append value of 500: " + intList.add(500));
		timeConvert(startTime, "append");
		
		intList.clear();
		br.close();
		
		
	}
	
	private static void timeConvert(long startTime, String s)
	{
		startTime = System.nanoTime() - startTime;
		System.out.println(startTime);
		float converted = (float) ((startTime) / 1000000.0);
		System.out.println(converted);
		converted = (float) (Math.round(converted * 1000.0) / 1000.0);
		System.out.println(s + " total Time: " + converted + "ms");
	}

	private static void printList(LinkedList<Integer> intList) 
	{
	    Iterator<Integer> it = intList.iterator();
	    System.out.print("List: ");
	    while (it.hasNext())
	    {
	    	System.out.print(it.next() + " -> ");
	    }
	    System.out.println("null");
	}
}
