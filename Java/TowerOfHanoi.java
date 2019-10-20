public class TowerOfHanoi {
	public static void Instructions(int disks, String sourceRod, String destinationRod, String helpRod) {
		if (disks > 0) {
			Instructions(disks - 1, sourceRod, helpRod, destinationRod);
			System.out.println(String.format("Move disk from rod %s to rod %s", sourceRod, destinationRod));
			Instructions(disks - 1, helpRod, destinationRod, sourceRod);
		}
	}

	public static void main(String[] args) {
		Instructions(4, "a", "c", "b");
	}
}
