import java.util.Date;
import java.util.Random;

/**
 * Write a program to solve the selection problem.
 * 
 * @author zhouyi
 * 
 */
public class Exercise_1_1 {

	public static void generate(int[] num) {
		Random r = new Random();
		for (int i = 0; i < num.length; i++) {
			num[i] = r.nextInt();
			// System.out.print(num[i]+" \n");
		}
	}

	public static void bubblesort(int[] num) {
		int tmp;
		for (int i = 0; i < num.length; i++)
			for (int j = i + 1; j < num.length; j++) {
				if (num[i] < num[j]) {
					tmp = num[i];
					num[i] = num[j];
					num[j] = tmp;
				}
			}
	}

	public static void quiksort(int[] num, int i, int j) {
		if (i < j) {
			int ii = i, jj = j;
			int x = num[i];
			while (i < j) {
				while (num[j] >= x && i < j)
					j--;
				num[i] = num[j];
				while (num[i] <= x && i < j)
					i++;
				num[j] = num[i];
			}
			num[i] = x;
			quiksort(num, ii, i - 1);
			quiksort(num, j + 1, jj);
		}
	}

	public static void show(int[] num) {
		for (int i = 0; i < num.length; i++)
			System.out.print(num[i] + "\n");
		System.out.print("\n");
	}

	public static void main(String[] args) {
		System.out.println("lg N\t\ttime(ms)");
		int n = 10;
		for (int i = 1; i < 8; i++) {
			n *= 10;
			int[] num = new int[n];
			generate(num);
			long t1 = new Date().getTime();
			quiksort(num, 0, num.length - 1);
			// bubblesort(num);
			long t2 = new Date().getTime();
			System.out.println(i + "\t\t\t" + (t2 - t1));
		}

	}
}
