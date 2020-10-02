class Knapsack {

  /**
   * This program will give you an idea about 0/1 knapsack problem
   *
   */
  public static void main(String args[]) {
    int val[] = new int[] { 20, 50, 100 };
    int wt[] = new int[] { 5, 10, 30 };
    int W = 40;
    int n = val.length;
    System.out.println(knapSack(W, wt, val, n));
  }

  static int max(int a, int b) {
    return (a > b) ? a : b;
  }

  static int knapSack(int W, int wt[], int val[], int n) {
    if (n == 0 || W == 0)
      return 0;

    if (wt[n - 1] > W)
      return knapSack(W, wt, val, n - 1);
    else
      return max(
          val[n - 1] + knapSack(W - wt[n - 1],
              wt, val, n - 1),
          knapSack(W, wt, val, n - 1));
  }

}