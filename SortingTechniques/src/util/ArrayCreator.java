package util;

public class ArrayCreator {

	public int[] createOrderedArray(int qty) {
		int[] result = new int[qty];
		for (int i = 0; i < qty; i++) {
			result[i] = i;
		}
		return result;
	}
	
	
	public int[] createChaoticIntArray(int qty, int minValue, int maxValue) {
		int[] result = new int[qty];
		int delta = maxValue - minValue;
		for (int i = 0; i < qty; i++) {
			result[i] = minValue + (int) Math.round(Math.random() * delta);
		}
		return result;
	}

	public int[] createSemiOrderedArray(int qty) {
		int[] result = new int[qty];
		int half_0 = qty / 2;
		int half_1 = qty - half_0;

		for (int i = 0; i < half_0; i++) {
			result[i] = i;
		}
		for (int i = half_0; i < half_1; i++) {
			result[i] = i;
		}
		return result;
	}
	
	public int[] createSemiOrderedArray(int qty, int pivot) {
		int[] result = new int[qty];
		int half_0 = pivot;
		int half_1 = qty - half_0;

		for (int i = 0; i < half_0; i++) {
			result[i] = i;
		}
		for (int i = half_0; i < half_1; i++) {
			result[i] = i;
		}
		return result;
	}

	public int[] createReverseOrderedArray(int qty, int minValue, int maxValue) {
		int[] result = new int[qty];

		for (int i = 0; i < qty; i++) {
			result[i] = qty - i;
		}
		return result;
	}
}
