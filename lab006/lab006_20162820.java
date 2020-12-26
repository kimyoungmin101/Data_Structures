// Lab 007	: Disjoint Sets
// Name :
// Student ID :

import java.util.*;


class DisjointSets {
	int numofelements;  // the total number of elements in all the disjoint sets
	private int[] parent; // maintains the parent pointer of each element in the disjoint sets
	private int[] weight; // maintains the weight of each set


	DisjointSets() { 
		// DisjointSets constructor. 
	}

	public String toString() { // Show all the element in sequence
		String str = new String();
	    // Show the array elements in parent[]

		str = "parent[]: - ";
		for(int i = 1; i <= numofelements; i++)
			str += parent[i] + " ";
		return str;
	}

   void InitSet(int n) { 
      // Initialize the array parent[] and weight[]
      numofelements = n;
      parent = new int[n+1];
      weight = new int[n+1];
      for(int i = 1; i <= n; i++) {
         parent[i] = 0;
         weight[i] = 1;
      }
   }
   boolean Union(int i, int j) { 
   // Union the set that contains i and the set that contains j
   // the set that has larger weight is the new root of the unioned set
   // when the weights are the same, choose the root of smaller value
      int a = SimpleFind(i); 
      int b = SimpleFind(j); 

      if(a == b){ // weight[j] > weight[i] ex) u 8 7
         return false;
      }
      if(weight[a] < weight[b]) {
         parent[a] = b;
         weight[b] += weight[a];
         weight[a] = 0;
      }
      else if(weight[a] == weight[b]) {
         int max = 0;
         int min = 0;
         if(a < b) {
            max = b;
            min = a;
         }
         else {
            max = a;
            min = b;
         } // 서브트리가 되려
         parent[min] = max;
         weight[SimpleFind(min)] += weight[max];
         weight[min] = 0;
      }
      else {
         parent[b] = a;
         weight[a] += weight[b];
         weight[b] = 0;
      }

      return true;

      // first find the root of i and j
      
      }

   int SimpleFind(int i) { 
   // return the root node that contains the element i
      int root = i;
      while (parent[i] > 0) {
            i = parent[i];  // move up the tree
            root = i;
      }

      return root;
   }
}
