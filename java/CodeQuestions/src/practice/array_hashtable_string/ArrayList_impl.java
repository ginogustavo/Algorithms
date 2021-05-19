package array_hashtable_string;

import java.util.Arrays;

public class ArrayList_impl {
	public static void main(String[] args) {

		ArrayList_impl myArrayList = new ArrayList_impl();

		myArrayList.add(new Integer(1));
		myArrayList.add(new Integer(2));
		myArrayList.add(new Integer(13));
		myArrayList.add(new Integer(24));
		myArrayList.add(new Integer(35));
		myArrayList.add(new Integer(46));
		myArrayList.add(new Integer(57));
		myArrayList.add(new Integer(68));
		myArrayList.add(new Integer(79));
		myArrayList.add(new Integer(810));
		myArrayList.add(new Integer(911));
		myArrayList.add(new Integer(1012));
		myArrayList.add(new Integer(1113));
		myArrayList.add(new Integer(1214));
		myArrayList.add(new Integer(1315));
		myArrayList.add(new Integer(1316));

		for (int i = 0; i < myArrayList.getSize(); i++) {
			System.out.println(myArrayList.getElementAt(i));
		}

	}

	int length = 5;
	Object[] array = new Object[length];
	int pointer = 0;

	public int getSize() {
		return pointer;
	}

	public Object getElementAt(int i) {
		return array[i];
	}

	private void add(Object obj) {
//		System.out.println("[Array]: #Elements:" + pointer + " - Internal Size: " + length + " - New Element: " + obj);
		if (pointer >= length) {
			// double the size of the array and copy the existing to one to a new one

			// Method 1:
			// array = Arrays.copyOf(array, length * 2);

			// Method 2:
			Object[] temp = array;
			array = new Object[length * 2];
			length = array.length;
			for (int i = 0; i < temp.length; i++) {
				array[i] = temp[i];
			}
			temp = null;

		}
		array[pointer] = obj;

		pointer++;

	}
}