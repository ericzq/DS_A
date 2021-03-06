/**
 * Write a program to print all permutations of chars in a string.
 * 
 * @author zhouyi
 *
 */
public class Exercise_1_6 {
	static int x = 0;

	public static void permute(String str) {
		permute(str.toCharArray(), 0, str.length());
	}

	private static void permute(char[] str, int low, int high) {
		if (low == high) {
			System.out.println(str);
		} else {
			char x = str[low];
			for (int i = low; i < high; i++) {
				/*
				 * if a char exists for more than one time, the program will not
				 * print it.
				 */
				if (str[low] == str[i] && low != i)
					continue;
				str[low] = str[i];
				str[i] = x;
				permute(str, low + 1, high);
				str[i] = str[low];
				str[low] = x;
			}
		}
	}

	public static void main(String[] args) {
		permute("abc");
	}

}
