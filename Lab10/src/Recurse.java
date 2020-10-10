	
public class Recurse {
	
	public static void main (String[] args) {
		System.out.print(sumDigits(125));
	}
	
	public static int strCount(String str, String sub) {
		if (str.length() < sub.length()) {
			return 0;
		} else if ((str.length() >= sub.length()) && (str.substring(0, sub.length()).equals(sub))){
			return strCount (str.substring(sub.length(), str.length()), sub) + 1;
		} else {
			return strCount (str.substring(1, str.length()), sub);
		}
	}
	
	public static int bunnyEars(int bunnies) {
		  if (bunnies == 0){
		    return 0;
		  } else {
		    return 2 + bunnyEars(bunnies-1);
		  }
		}
	
	public static int sumDigits(int n) {
		  if (n<10){
		    return n;
		  } else {
		    return n%10 + sumDigits(n/10); 
		  }
		}
}

