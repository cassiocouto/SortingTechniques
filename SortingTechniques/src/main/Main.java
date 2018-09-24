package main;

import sort.*;
import util.ArrayCreator;

public class Main {

	public static void main(String[] args) {
		ArrayCreator ar = new ArrayCreator();
		for (int max_val = 10; max_val <= 30000000; max_val = max_val * 2) {
			// Long t1 = System.nanoTime();
			int pivot = (int) (max_val * 0.03);
			int[] my_arr = ar.createOrderedArray(max_val);
			int[] my_arr_2 = ar.createChaoticIntArray(8, 0, max_val);
			// System.out.println("Time for creating arrays with " + max_val + " elements: "
			// + (System.nanoTime() - t1));
			long t2 = System.nanoTime();
			int[] sorted_binary = new BinaryInsertSort().sort(my_arr, my_arr_2);
			long t3 = System.nanoTime();
			for (int i = 0; i < sorted_binary.length - 1; i++) {
				if (sorted_binary[i] > sorted_binary[i + 1]) {
					System.out.println("Unsorted at " + i + " position");
				}
			}
			long time_binary = t3 - t2;
			// System.out.println("Time for binary sort with " + max_val + " elements: " + (time_binary));
			t2 = System.nanoTime();
			int[] merged = new MergeSort().sort(my_arr, my_arr_2);
			t3 = System.nanoTime();
			for (int i = 0; i < merged.length - 1; i++) {
				if (merged[i] > merged[i + 1]) {
					System.out.println("Unsorted at " + i + " position");
				}
			}
			long time_merge = t3 - t2;
			
			t2 = System.nanoTime();
			int[] inserted = new InsertionSort().sort(my_arr, my_arr_2);
			t3 = System.nanoTime();
			for (int i = 0; i < inserted.length - 1; i++) {
				if (inserted[i] > inserted[i + 1]) {
					System.out.println("Unsorted at " + i + " position");
				}
			}
			long time_insertion = t3 - t2;

			if(time_binary < time_merge && time_binary < time_insertion) {
				System.out.println("Binary won @"+max_val);
			}else if(time_merge < time_binary && time_merge < time_insertion) {
				System.out.println("Merge won @"+max_val);
			} else if(time_insertion < time_binary && time_insertion < time_merge) {
				System.out.println("Insertion won @"+max_val);
			} 
		}
	}

}
