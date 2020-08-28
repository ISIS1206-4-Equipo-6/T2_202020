package model.logic;

public class ShellSort
{


	public static void sort(Comparable[] a)
	{
		int n = a.length;
		int h = 1;
		while (h < n/3)
			h = 3*h + 1;
		while (h >= 1) {
			for (int i = h; i < n; i++) {
				for (int j = i; j >= h && less(a[j], a[j-h]); j -= h)
					exchange(a, j, j-h);
			}
			h = h/3;
		}
	}

	private static boolean less(Comparable a, Comparable b){
		return a.compareTo(b)<0;
	}

	private static void exchange(Comparable[] array, int i, int j)
	{
		Comparable temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
