// Serhii Maltsev sm5zj
// LAB 9: Recursion, Pt. 1

public class MaxMin {
	
	static int max;
	static int min;
	
	public static int maximum(int a, int b) {
		if (a>b) {
			return a;
		} else {
			return b;
		}
	}
	
	public static int minimum(int a, int b) {
		if (a<b) {
			return a;
		} else {
			return b;
		}
	}
	
	public static void main(String[] args) 
	{
		int[] values = {19, 12, 13, 14, 17, 18, 16, 14, 11};
		int[] maxMinResults = maxMin(values);
		System.out.println(maxMinResults[0] + " and " + maxMinResults[1]);
	}
	
	/*  maxMin() - Return an array containing the minimum and maximum values of the input array.
	 * 	@param list: an array of ints as input
	 * 	
	 * 	Use the helper function to perform the recursion with the additional parameters
	 * 	
	 * 	@return: an int array, one index is minimum and the other is the maximum value.
	 */
	public static int[] maxMin(int[] list) {
		max = list[0];
		min = list[0];
		return(maxMinHelper(list, 0, list.length-1));
	}

	/*  maxMinHelper() - Helper function for the maxMin function.
	 * 	@param list: an array of ints as input
	 * 	@param first: the first index of the list (for recursion)
	 * 	@param last: the last index of the list (for recursion)
	 * 	
	 * 	Identify a base case, and work it out so that the array returns the min and max values.
	 * 	Then, identify what the method does to recursively arrive at the base case.
	 * 	
	 * 	@return: an int array, one index is minimum and the other is the maximum value.
	 */
	public static int[] maxMinHelper(int[] list, int first, int last){
		
		if (last == first +1) {
			int [] x = new int[2];
			max = maximum(max, maximum(list[first], list[last]));
			min = minimum(min, minimum(list[first], list[last]));
			x[0] = min;
			x[1] = max;
			return x;
		} else if (first == last) {
			max = maximum(max, list[first]);
			min = minimum(min, list[first]);
			int [] x = new int[2];
			x[0] = min;
			x[1] = max;
			return x;
		} else {
			int mid = (first + last)/2;
			maxMinHelper(list, first, mid);
			maxMinHelper(list, mid+1, last);
			int [] x = new int[2];
			x[0] = min;
			x[1] = max;
			return x;
		}

	}
}