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
		for(int i = 0; i < inputArray.length-1; i++){
				if(inputArray[i] > inputArray[i+1]) {
					m = i + 1;
					break;
				}
		}
		Arrays.sort(inputArray);
		
		for(int j = 0; j < inputArray.length; j++){
			outputArray[j] = inputArray[j];
		}
		System.out.println("m = " + m + ", n = " + noe);

		// NEED TO IMPLEMENT


	}
}
