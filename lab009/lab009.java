// Lab 010	: Natural Merge
// Name :
// Student ID :

import java.util.*;


class NaturalMerge {
	int noe;  // the number of elements
	private int[] inputArray; // input array 
	int[] outputArray; // output array 


	NaturalMerge() { 
		noe = 0;
	}

	void Init(int [] arr, int n) { 
		noe = n;
		inputArray = new int[noe];
		System.arraycopy(arr, 0, inputArray, 0, n);

		outputArray = new int[noe];
	}

	void Merge() { 
		int m = 0;

		System.out.println("m = " + m + ", n = " + noe);

		// NEED TO IMPLEMENT


	}
}


