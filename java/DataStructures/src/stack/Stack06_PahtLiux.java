package stack;
import java.util.Iterator;
import java.util.Stack;

public class Stack06_PahtLiux {

	public static void main(String[] args) {
		System.out.println(simplifyPath("/home//foo/"));
		//System.out.println(simplifyPath("/../"));

	}

	public static String simplifyPath(String path) {

		Stack<String> stack = new Stack<String>();

		String newString = path.replace("//", "/");
		String[] split = newString.split("/");

		for (int i = 0; i < split.length; i++) {
			String dir = split[i];

			if (dir.equals(".") || dir.equals("")) {

			} else if (dir.equals("..")) {
				if (!stack.isEmpty())
					stack.pop();
			} else {
				stack.push(dir);
			}
		}

		Iterator<String> it = stack.iterator();
		String new_path = "";
		while (it.hasNext()) {
			String dir = it.next();
			new_path += "/" + dir;
		}
		if (new_path.equals(""))
			new_path = "/";
		return new_path;

	}

}
