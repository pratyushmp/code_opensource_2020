package selfdp;

public class editdistance {
	public static int editdr(String s1, String s2) {
		if (Math.min(s1.length(), s2.length()) == 0)
			return Math.max(s1.length(), s2.length());
		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);
		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);
		if (ch1 == ch2)
			return editdr(ros1, ros2);
		else {
			int a = editdr(s1, ros2);// d
			int b = editdr(ros1, s2);// i
			int c = editdr(ros1, ros2);// r
			int r = Math.min(Math.min(a, b), c) + 1;
			//System.out.println(r);
			return r;

		}

	}

	static String x;
	static String y;

	public static int editdTD(String s1, String s2, int strg[][]) {

		if (Math.min(s1.length(), s2.length()) == 0) {
			return Math.max(s1.length(), s2.length());
		}

		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);
		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);
		int si1 = x.indexOf(ch1);
		int si2 = y.indexOf(ch2);
	//	System.out.println(ch1+" "+si1);

		if (strg[si1][si2] != 0) {
		//	 System.out.println("hi");
			return strg[si1][si2];
		}

		if (ch1 == ch2) {

			return editdTD(ros1, ros2, strg);
		} else {
			int a = editdTD(s1, ros2, strg);// d
			int b = editdTD(ros1, s2, strg);// i
			int c = editdTD(ros1, ros2, strg);// r
			int r = Math.min(Math.min(a, b), c) + 1;
			strg[si1][si2] = r;
			//System.out.println(r);

			return r;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		x = "sundayfkl";
		y = "saturdayjuhi";
		System.out.println(editdr(x, y));
		System.out.println("-------------");
		System.out.println(editdTD(x, y, new int[x.length()][y.length()]));

	}

}
