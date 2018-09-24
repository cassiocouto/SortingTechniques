package sort;

import java.util.ArrayList;

public class BinaryInsertSort {
	private ArrayList<Number> priority;

	public int[] sort(int[] arr_0, int[] arr_1) {
		priority = new ArrayList<>();
		for (int i = 0; i < arr_0.length; i++) {
			priority.add(arr_0[i]);
		}
		for (int i = 0; i < arr_1.length; i++) {
			add(arr_1[i], 0);
		}
		int[] result = new int[arr_0.length + arr_1.length];
		for (int i = 0; i < arr_0.length + arr_1.length; i++) {
			result[i] = priority.get(i).intValue();
		}
		return result;
	}

	private void add(Number elementPriority, int inferiorLimit) {

		if (priority.size() == 0) {
			priority.add(elementPriority);
			return;
		} else if (priority.size() == 1) {
			Number tempN = priority.get(0);

			priority.clear();

			if (tempN.doubleValue() <= elementPriority.doubleValue()) {
				priority.add(tempN);
				priority.add(elementPriority);
				return;
			} else {
				priority.add(elementPriority);
				priority.add(tempN);
				return;
			}
		}

		if (elementPriority.doubleValue() >= priority.get(priority.size() - 1).doubleValue()) {
			priority.add(elementPriority);
		} else {
			binaryInsert(elementPriority, inferiorLimit);
		}

	}

	private void binaryInsert(Number elementPriority, int inferiorLimit) {
		int inferior = inferiorLimit;
		int superior = priority.size() - 1;
		int delta = superior - inferior;

		while (delta > 1) {
			int index = (int) (Math.floor((inferior + superior) / 2d));
			if (priority.get(index).doubleValue() > elementPriority.doubleValue()) {
				superior = index;
			} else {
				inferior = index;
			}
			delta = superior - inferior;
		}
		priority.add(inferior, elementPriority);

	}

}
