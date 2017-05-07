package ccc;

import java.util.ArrayList;
import java.util.Collections;

public class sortCSV {

	public static ArrayList<User> sort(ArrayList<User> a) {
		// Collections.shuffle(a); // Eliminate dependence on input.
		sort(a, 1, a.size() - 1);
		return a;
	}

	private static void sort(ArrayList<User> a, int lo, int hi) {
		if (hi <= lo)
			return;
		int j = partition(a, lo, hi); // Partition (see page 291).
		sort(a, lo, j - 1); // Sort left part a[lo .. j-1].
		sort(a, j + 1, hi); // Sort right part a[j+1 .. hi].
	}

	private static int partition(ArrayList<User> a, int lo, int hi) { // Partition
																		// into
																		// a[lo..i-1],
																		// a[i],
																		// a[i+1..hi].
		int i = lo, j = hi + 1; // left and right scan indices
		User v = a.get(lo); // partitioning item
		while (true) { // Scan right, scan left, check for scan complete, and
						// exchange.
			while (less(a.get(++i).getUsername(), v.getUsername()))
				if (i == hi)
					break;
			while (less(v.getUsername(), a.get(--j).getUsername()))
				if (j == lo)
					break;
			if (i >= j)
				break;
			exch(a, i, j);
		}
		exch(a, lo, j); // Put v = a[j] into position
		return j; // with a[lo..j-1] <= a[j] <= a[j+1..hi].
	}

	private static boolean less(String u1, String u2) {
		if (u1.equals(null)) {
			return true;
		} else if (u2.equals(null)) {
			return false;
		}
		return u1.toUpperCase().compareTo(u2.toUpperCase()) < 0;
	}

	private static void exch(ArrayList<User> a, int i, int j) {
		User t = a.get(i);
		a.set(i, a.get(j));
		a.set(j, t);
	}
}
