package toxi.util.datatypes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

/**
 * A collection of array utilities.
 * 
 * @author toxi
 */
public class ArrayUtil {

	/**
	 * Rearranges the array items in random order using the default
	 * java.util.Random generator. Operation is in-place, no copy is created.
	 * 
	 * @param array
	 */
	public static <T> void shuffle(T[] array) {
		shuffle(array, new Random());
	}

	/**
	 * Rearranges the array items in random order using the given RNG. Operation
	 * is in-place, no copy is created.
	 * 
	 * @param array
	 * @param rnd
	 */
	public static <T> void shuffle(T[] array, Random rnd) {
		int N = array.length;
		for (int i = 0; i < N; i++) {
			int r = i + (int) (rnd.nextFloat() * (N - i)); // between i and N-1
			T swap = array[i];
			array[i] = array[r];
			array[r] = swap;
		}
	}

	/**
	 * Reverses the item order of the supplied array (generic types).
	 * 
	 * @param array
	 */
	public static <T> void reverse(T[] array) {
		int len = array.length - 1;
		int len2 = array.length / 2;
		for (int i = 0; i < len2; i++) {
			T tmp = array[i];
			array[i] = array[len - i];
			array[len - i] = tmp;
		}
	}

	/**
	 * Reverses the item order of the supplied byte array.
	 * 
	 * @param array
	 */
	public static void reverse(byte[] array) {
		int len = array.length - 1;
		int len2 = array.length / 2;
		for (int i = 0; i < len2; i++) {
			byte tmp = array[i];
			array[i] = array[len - i];
			array[len - i] = tmp;
		}
	}

	/**
	 * Reverses the item order of the supplied short array.
	 * 
	 * @param array
	 */
	public static void reverse(short[] array) {
		int len = array.length - 1;
		int len2 = array.length / 2;
		for (int i = 0; i < len2; i++) {
			short tmp = array[i];
			array[i] = array[len - i];
			array[len - i] = tmp;
		}
	}

	/**
	 * Reverses the item order of the supplied char array.
	 * 
	 * @param array
	 */
	public static void reverse(char[] array) {
		int len = array.length - 1;
		int len2 = array.length / 2;
		for (int i = 0; i < len2; i++) {
			char tmp = array[i];
			array[i] = array[len - i];
			array[len - i] = tmp;
		}
	}

	/**
	 * Reverses the item order of the supplied int array.
	 * 
	 * @param array
	 */
	public static void reverse(int[] array) {
		int len = array.length - 1;
		int len2 = array.length / 2;
		for (int i = 0; i < len2; i++) {
			int tmp = array[i];
			array[i] = array[len - i];
			array[len - i] = tmp;
		}
	}

	/**
	 * Reverses the item order of the supplied float array.
	 * 
	 * @param array
	 */
	public static void reverse(float[] array) {
		int len = array.length - 1;
		int len2 = array.length / 2;
		for (int i = 0; i < len2; i++) {
			float tmp = array[i];
			array[i] = array[len - i];
			array[len - i] = tmp;
		}
	}

	/**
	 * Converts the generic array into an {@link ArrayList} of the same type.
	 * 
	 * @param array
	 * @return
	 */
	public static <T> ArrayList<T> arrayToList(T[] array) {
		ArrayList<T> list = new ArrayList<T>(array.length);
		for (int i = 0; i < array.length; i++) {
			list.add(array[i]);
		}
		return list;
	}

	/**
	 * Adds all array elements to the given collection of the same type.
	 * 
	 * @param <T>
	 * @param array
	 *            array
	 * @param collection
	 *            existing collection or null (to create a new {@link ArrayList}
	 *            automatically)
	 */
	static <T> void addArrayToCollection(T[] array, Collection<T> collection) {
		if (collection == null) {
			collection = new ArrayList<T>();
		}
		for (T o : array) {
			collection.add(o);
		}
	}

}
