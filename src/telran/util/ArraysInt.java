package telran.util;

import java.util.Arrays;

public class ArraysInt {
	public static int[] addNumber(int[] array, int number) {
		int[] arrayNew = Arrays.copyOf(array, array.length + 1);
		arrayNew[array.length] = number;
		return arrayNew;
	}

	public static int[] insertNumber(int[] array, int index, int number) {
/* HW
 		int[] arrayNew = Arrays.copyOf(array, array.length + 1);
		if (index == 0) {
			System.arraycopy(array, 0, arrayNew, 1, array.length);
		} else if (index != array.length) {
			System.arraycopy(array, 0, arrayNew, 0, index - 1);
			System.arraycopy(array, index, arrayNew, index + 1, array.length - index);
		}
		arrayNew[index] = number;
*/
		int[] arrayNew = new int[array.length + 1];
		arrayNew[index] = number;
		System.arraycopy(array,  0,  arrayNew,  0,  index);
		System.arraycopy(array, index, arrayNew, index + 1, array.length - index);
		return arrayNew;
	}

	public static int[] removeNumber(int[] array, int index) {
		int[] arrayNew = new int[array.length - 1];
/* HW 	if (index == 0) {
			System.arraycopy(array, 1, arrayNew, 0, arrayNew.length);
		} else if (index == array.length - 1) {
			System.arraycopy(array, 0, arrayNew, 0, index);
		} else {
			System.arraycopy(array, 0, arrayNew, 0, index);
			System.arraycopy(array, index + 1, arrayNew, index, arrayNew.length - index);
		}
*/
		System.arraycopy(array, 0, arrayNew, 0, index);
		System.arraycopy(array, index + 1, arrayNew, index, array.length - index - 1);
		return arrayNew;
	}

	public static int[] insertSorted(int[] sortedArray, int number) {
		int index = Arrays.binarySearch(sortedArray, number);
		return index >= 0 ? insertNumber(sortedArray, index, number) : insertNumber(sortedArray, -index - 1, number);
	}
}
