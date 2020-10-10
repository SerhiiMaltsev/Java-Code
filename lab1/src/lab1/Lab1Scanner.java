package lab1;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Lab1Scanner {
	
	public static void main (String[] args) throws FileNotFoundException {
	/*	Scanner theInput = new Scanner(System.in);
		int s = 0;
		for (int i=0; i<=4; i++) {
			double x = theInput.nextInt();
			s += x;
		}
		System.out.println("Avarage:"+s/5);
	*/
		
	/*
		File theFile = new File("data1");
		Scanner inputFile = new Scanner(theFile);
		while (inputFile.hasNext()) {
			String str = inputFile.nextLine();
			System.out.println(str);
		}
		inputFile.close();
		System.out.println(theFile.length());
		System.out.println(theFile.getAbsolutePath());
	*/
		int s = 0;
		File theFile = new File("data2.txt");
		Scanner inputFile = new Scanner(theFile);
		while (inputFile.hasNext()) {
			String str = inputFile.nextLine();
			if (isInteger(str) == true) {
				s += Integer.parseInt(str);
			}
		}
		System.out.println(s);
	}
	
	
	public static boolean isInteger(String str) {    
	    if (str.length() == 1) {
		if (str.charAt(0)>=48 && str.charAt(0)<=57) {
	    	return true;
	    } else {
	    	return false;
	    }
	    } else {
	    	return false;
	    }
	}
}
