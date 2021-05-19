import java.util.ArrayList;
import java.util.List;

class FindInMatrix {

	public static void main(String[] args) {

		// artifacts = "1B 2C,2D 4D"
		// N = 4
		// searched = "2B 2D 3D 4D 4A"

		// int[] count art full, count some
		// output; [1,1]

		String artifacts = "1B 2C,2D 4D";
		int N = 4;
		String searched = "2B 2D 3D 4D 4A";
		int[] sol = new FindInMatrix().solution(N, artifacts, searched);
		System.out.println(sol[0] + " " + sol[1]);

	}

	class Node {
		String artifactNumber;
		String[] location;

		Node(String number, String[] location) {
			this.artifactNumber = number;
			this.location = location;
		}
	}

	public int[] solution(int N, String artifacts, String searched) {

		List<Node> allNodes = new ArrayList<Node>();

		// Artifacts
		String[] art = artifacts.split(",");
		for (int i = 0; i < art.length; i++) {
			String[] locations = getLocationsArray(art[i]);
			allNodes.add(new Node(String.valueOf(i), locations));
		}

		int countFull = 0;
		int countSome = 0;

		// for every search
		for (Node node : allNodes) {
			String[] locations = node.location;
			int num_locations = locations.length;
			int count_of_matches = 0;

			for (int i = 0; i < num_locations; i++) {
				String loc = locations[i];
				if (searched.indexOf(loc) != -1) {
					count_of_matches++;
				}
			}

			if (count_of_matches == num_locations) {
				countFull++;
			} else if (count_of_matches > 0) {
				countSome++;
			}
		}

		return new int[] { countFull, countSome };
	}

	public String[] getLocationsArray(String artifact) {
		String[] location = artifact.split(" ");

		String loc1 = location[0];
		int num1 = Integer.parseInt(loc1.substring(0, 1));
		char let1 = loc1.charAt(1);

		String loc2 = location[1];
		int num2 = Integer.parseInt(loc2.substring(0, 1));
		char let2 = loc2.charAt(1);

		if (loc1.equals(loc2)) { // same cell (of 1)
			return new String[] { loc1 };
		}

		else if (num1 == num2) { // row of 2, 3, 4 ej. 2A 2C, or 15G 15I

			int l1 = (int) let1;
			int l2 = (int) let2;
			int dif = (l2 - l1 + 1);

			if (dif == 1) {
				return new String[] { loc1, loc2 };
			} else if (dif == 2) {
				String next = String.valueOf((char) (let1 + 1));
				return new String[] { loc1, next, loc2 };
			} else { // 3
				String next = String.valueOf((char) (let1 + 1));
				String next2 = String.valueOf((char) (let1 + 2));

				return new String[] { loc1, next, next2, loc2 };
			}

		} else if (let1 == let2) { // column of 2 3 4 . ej. 2d 4d
			int dif = num2 - num1;
			if (dif == 1) {
				return new String[] { loc1, loc2 };
			} else if (dif == 2) {
				int newnum = num1 + 1;
				String new1 = String.valueOf(newnum) + let1;
				return new String[] { loc1, new1, loc2 };
			} else { // 3
				int newnum1 = num1 + 1;
				int newnum2 = num1 + 2;
				return new String[] { loc1, String.valueOf(newnum1), String.valueOf(newnum2), loc2 };
			}
		} else { // square
			String new1 = num1 + String.valueOf(let2);
			String new2 = num2 + String.valueOf(let1);
			return new String[] { loc1, new1, new2, loc2 };
		}
	}

}
