package sort;

public class InsertionSort {
	int[] result;

	public int[] sort(int[] arr_0, int[] arr_1) {
		result = new int[arr_0.length + arr_1.length];
		result = new int[arr_0.length + arr_1.length];
		for (int i = 0; i < result.length; i++) {
			if (i < arr_0.length) {
				result[i] = arr_0[i];
			} else if (arr_1.length > 0) {
				result[i] = arr_1[i - arr_0.length];
			}
		}
		sort();
		return result;
	}
	
	private void sort() {
		int i = 1;
		while(i < result.length) {
			int j = i;
			while(j > 0 && result[j-1] > result[j]) {
				swap(j, j-1);
				j--;
			}
			i++;
		}
	}
	
	private void swap(int index_1, int index_2) {
		int temp = result[index_1];
		int temp2 = result[index_2];
		result[index_1] = temp2;
		result[index_2] = temp;
	}
}
