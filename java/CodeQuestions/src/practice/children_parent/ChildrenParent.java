package children_parent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class ChildrenParent {
	public static void main(String[] args) {
		// initialize data
//		(1, 3), (2, 3), (3, 6), (5, 6),
//		(5, 7), (4, 5), (4, 8), (4, 9), (9, 11)
		ArrayList<Object> parentChildPairs = new ArrayList<Object>();
		parentChildPairs.add(new int[] { 1, 3 });
		parentChildPairs.add(new int[] { 2, 3 });
		parentChildPairs.add(new int[] { 3, 6 });
		parentChildPairs.add(new int[] { 5, 6 });
		parentChildPairs.add(new int[] { 5, 7 });
		parentChildPairs.add(new int[] { 4, 5 });
		parentChildPairs.add(new int[] { 4, 8 });
		parentChildPairs.add(new int[] { 4, 9 });
		parentChildPairs.add(new int[] { 9, 11 });

		new ChildrenParent().findNodesWithZeroAndOneParents(parentChildPairs);
	}

	public void findNodesWithZeroAndOneParents(ArrayList<Object> parentChildPairs) {

		Map<Integer, ArrayList<Integer>> childrenMap = new HashMap<Integer, ArrayList<Integer>>();

		for (Object obj : parentChildPairs) {
			// getting pair (parent, child) of each element in the array
			int[] pair = (int[]) obj;
			int parent = pair[0];
			int child = pair[1];

			if (!childrenMap.containsKey(child)) {
				childrenMap.put(child, new ArrayList<Integer>());
			}
			if (!childrenMap.containsKey(parent)) {
				childrenMap.put(parent, new ArrayList<Integer>());
			}
			ArrayList<Integer> parents = childrenMap.get(child);
			parents.add(parent);
			childrenMap.put(child, parents);

		}

		ArrayList<Integer> zeroParents = new ArrayList<Integer>();
		ArrayList<Integer> oneParents = new ArrayList<Integer>();

		// traverse the map
		for (Map.Entry<Integer, ArrayList<Integer>> mapElement : childrenMap.entrySet()) {
			int key = mapElement.getKey();
			ArrayList<Integer> value = mapElement.getValue();

			// and look for the ones with empty array.
			if (value.size() == 0) {
				zeroParents.add(key);
			} else if (value.size() == 1) {
				oneParents.add(key);
			}

			// System.out.println(key + " " + value.size());
			// [1, 2, 4], // Individuals with zero parents
			// [5, 7, 8, 9, 11] // Individuals with exactly one parent
		}

		System.out.println(zeroParents);
		System.out.println(oneParents);

	}

}