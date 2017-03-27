<<<<<<< HEAD
package com.example.servlets;

import java.util.ArrayList;

public class SearchUsername {

	public static int rank(String key, ArrayList<User> a) { // Array must be
															// sorted.
		int lo = 0;
		int hi = a.size() - 1;
		while (lo <= hi) { // Key is in a[lo..hi] or not present.
			int mid = lo + (hi - lo) / 2;
			if (key.compareToIgnoreCase(a.get(mid).getUsername()) < 0)
				hi = mid - 1;
			else if (a.get(mid).getUsername().compareToIgnoreCase(key) < 0)
				lo = mid + 1;
			else
				return mid;
		}
		return -1;
	}

	public static void main(String[] args) {

	}
=======
package com.example.servlets;

import java.util.ArrayList;

public class SearchUsername {

	public static int rank(String key, ArrayList<User> a) { // Array must be
															// sorted.
		int lo = 0;
		int hi = a.size() - 1;
		while (lo <= hi) { // Key is in a[lo..hi] or not present.
			int mid = lo + (hi - lo) / 2;
			if (key.compareToIgnoreCase(a.get(mid).getUsername()) < 0)
				hi = mid - 1;
			else if (a.get(mid).getUsername().compareToIgnoreCase(key) < 0)
				lo = mid + 1;
			else
				return mid;
		}
		return -1;
	}
	
>>>>>>> refs/remotes/origin/master
}