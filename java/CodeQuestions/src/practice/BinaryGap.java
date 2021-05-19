
public class BinaryGap {

	public static void main(String[] args) {
//		int sol = new BinaryGap().solution(529);
//		int sol = new BinaryGap().solution(20);
//		int sol = new BinaryGap().solution(15);
		int sol = new BinaryGap().solution(32);
//		
		
		System.out.println(sol);
	}
	
	public int solution(int N) {
		
		String bin = Integer.toBinaryString(N);
		System.out.print(bin+"   ->");
		
		int max = 0;
		
		int zero_count = 0;
		
		//0 must be 1, so we start by second elemnt index 1
		for (int i = 1; i < bin.length(); i++) {
			char d = bin.charAt(i);
			
			if(d == '0') {
				zero_count++;
			}else { // == 1
				max = Math.max(max, zero_count);
				zero_count = 0;
			}
		}
		
		
		return max;
	}
	
}
