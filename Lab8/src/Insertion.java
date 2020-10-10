import java.util.ArrayList;

//Name: Serhii Maltsev
//UVA id: sm5zj

public class Insertion {

	public static Comparable[] sort(Comparable[] list) {
		
		ArrayList<Comparable> arrList = new ArrayList<Comparable>();
		for (Comparable i : list) {
			arrList.add(i);
		}
		
		int pointer = 0;
		Comparable value = 0;
		boolean check = false;
		
		
		for (int i = 0; i<arrList.size(); i++) {
			value = arrList.get(i);
			pointer = i - 1;
			
			while (pointer >= 0 && arrList.get(pointer).compareTo(value)>0) {
				arrList.set(pointer+1, arrList.get(pointer));
				pointer--;
			}
			arrList.set(pointer + 1, value);
		}
		
		Comparable[] sortedList = new Comparable[arrList.size()]; 
		for (int i = 0; i < arrList.size(); i++) {
			sortedList[i] = arrList.get(i);
		}
		return sortedList;
		
	}
	
	public static void main(String[] args) {
	
		Comparable[] test = new Comparable[5];
		
		test[0] = Integer.valueOf(5);
		test[1] = Integer.valueOf(1);
		test[2] = Integer.valueOf(2);
		test[3] = Integer.valueOf(4);
		test[4] = Integer.valueOf(3);
		
		System.out.println("Unsorted array: ");
		for (Comparable i: test) {
			System.out.print(i + " ");
		}
		
		System.out.println("\nSorted array: ");
		Comparable[] sorted = new Comparable[5];
		sorted = Insertion.sort(test);
		
		for (Comparable i: sorted) {
			System.out.print(i + " ");
		}
	
	}
	
}
