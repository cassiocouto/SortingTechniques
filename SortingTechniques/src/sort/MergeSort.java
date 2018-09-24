package sort;

public class MergeSort {
	int[] result;

	public int[] sort(int[] arr_0, int[] arr_1) {
		result = new int[arr_0.length + arr_1.length];
		for (int i = 0; i < result.length; i++) {
			if (i < arr_0.length) {
				result[i] = arr_0[i];
			} else if(arr_1.length > 0){
				result[i] = arr_1[i - arr_0.length];
			}
		}
		sort(0, result.length-1);
		return result;
	}

	private void sort(int left, int right) {
		if (left < right) {
			int middle = (left + right) / 2;

			sort(left, middle);
			sort(middle + 1, right);

			merge(left, middle, right);
		}
	}

	private void merge(int left, int middle, int right) {
		int[] aux_1 = new int[middle - left + 1];
		int a = 0;
		for (int i = 0; i < aux_1.length; i++) {
			aux_1[a] = result[a + left];
			a++;
		}

		int[] aux_2 = new int[right - middle];
		for (int j = 0; j < aux_2.length; j++) {
			aux_2[j] = result[a + left];
			a++;
		}

		int i = 0;
		int j = 0;
		int k = left;
		for (; k <= right; k++) {
			if (i < aux_1.length && j < aux_2.length) {
				if (aux_1[i] < aux_2[j]) {
					result[k] = aux_1[i];
					i++;
				} else {
					result[k] = aux_2[j];
					j++;
				}
			}else {break;}
		}
		while (i < aux_1.length) {
			result[k] = aux_1[i];
			i++;
			k++;
		}
		while (j < aux_2.length) {
			result[k] = aux_2[j];
			j++;
			k++;
		}
	}

}
