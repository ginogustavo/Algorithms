package child_common_ancestor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/discuss/interview-question/786821/indeed-oa-2020-parents-and-children-graph

public class Common_ancestor {

	public static void main(String[] args) {
		ArrayList<Object> pairs = new ArrayList<Object>();
		pairs.add(new int[] { 1, 3 });
		pairs.add(new int[] { 2, 3 });
		pairs.add(new int[] { 3, 6 });
		pairs.add(new int[] { 5, 6 });
		pairs.add(new int[] { 5, 7 });
		pairs.add(new int[] { 4, 5 });
		pairs.add(new int[] { 4, 8 });
		pairs.add(new int[] { 4, 9 });
		pairs.add(new int[] { 9, 11 });
		pairs.add(new int[] { 14, 4 });
		pairs.add(new int[] { 13, 12 });
		pairs.add(new int[] { 12, 9 });
		System.out.println(new Common_ancestor().has_common_ancestor(pairs, 3,8));
		//System.out.println(new Common_ancestor().has_common_ancestor(pairs, 5,8));

		// parent_child_pairs_1 = [(1, 3), (2, 3), (3, 6), (5, 6), (5, 7),
		// (4, 5),(4, 8), (4, 9), (9, 11), (14, 4), (13, 12), (12, 9)]
	}

	/*
	 * Write a function that takes the graph, as well as two of the individuals in
	 * our data set, as its inputs and returns true if and only if they share at
	 * least one ancestor.
	 */

	class FamilyTree{
		public FamilyTree() {
		}
		public FamilyTree(ArrayList<Integer> anc, ArrayList<Integer>desc) {
			setAncestors(anc);
			setDescendents(desc);
		}
		int key;
		public int getKey() {
			return key;
		}
		public void setKey(int key) {
			this.key = key;
		}
		public ArrayList<Integer> getAncestors() {
			return ancestors;
		}
		public void setAncestors(ArrayList<Integer> ancestors) {
			this.ancestors = ancestors;
		}
		public ArrayList<Integer> getDescendents() {
			return descendents;
		}
		public void setDescendents(ArrayList<Integer> descendents) {
			this.descendents = descendents;
		}
		ArrayList<Integer> ancestors;
		ArrayList<Integer> descendents;
		
	}
	
	public boolean has_common_ancestor(ArrayList<Object> array, int n1, int n2) {
		
		Map<Integer, FamilyTree> childrenMap = new HashMap<Integer, FamilyTree>();
				
		for (Object obj : array) {
			int[] pair = (int [])obj;
			int parent = pair[0];
			int child = pair[1];

			if(!childrenMap.containsKey( child )) {
				childrenMap.put( child , new FamilyTree(new ArrayList<Integer>(), new ArrayList<Integer>()));
			}
			if(!childrenMap.containsKey( parent )) {
				childrenMap.put( parent , new FamilyTree(new ArrayList<Integer>(), new ArrayList<Integer>()));
			}

			childrenMap.get(child).getAncestors().add(parent);
			
			ArrayList<Integer> parentAncestors =  childrenMap.get(parent).getAncestors();
			if(parentAncestors.size()>0) {
				//childAncestors.addAll( parentAncestors);
				childrenMap.get(child).getAncestors().addAll( parentAncestors);
				for (Integer parentAns : parentAncestors) {
					childrenMap.get(parentAns).getDescendents().add(child);		
				}
			}

			childrenMap.get(parent).getDescendents().add(child);
			
			//get child'd descendants
			ArrayList<Integer> childDescendents = childrenMap.get(child).getDescendents();
			//get parent's descendants and add these group
			if(childDescendents.size()>0) {
				childrenMap.get(parent).getDescendents().addAll( childDescendents );
				for (Integer childDes : childDescendents) {
					childrenMap.get(childDes).getAncestors().add(parent);
				}
			}
			
			//= [(1, 3), (2, 3), (3, 6), (5, 6), (5, 7), (4, 5),(4, 8), (4, 9), (9, 11), (14, 4), (13, 12), (12, 9)]

			//childrenMap.put(child, ancestors);
			
			//all that has parent 5(child, they will have now ancestos also 4(parent
			//get all those that has parent [child]
			
			
		}
		
		//Add child (if it does't exist) with empty array
		//Add parent (as child) (if it does't exist) with empty array
		//get the child key and its ancestors array to add this parent

		// if parent has ancestors add them as ancestor of child
		
		for(Map.Entry<Integer, FamilyTree> entry: childrenMap.entrySet() ) {
			int key = entry.getKey();
			FamilyTree tree = entry.getValue();
			System.out.println(key + " " + tree.getAncestors() + " "+tree.getDescendents());			
		}
		
		
		return false;
	}

}
