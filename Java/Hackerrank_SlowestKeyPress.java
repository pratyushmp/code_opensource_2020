import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// Slowest Key press
public class Hackerrank_SlowestKeyPress {

    public static void main(String[] args) {
        //[[0, 2], [1, 5], [0, 9], [2, 15]];
        Integer[][] keyTimes = new Integer[][]{{0, 2}, {1, 5}, {0, 9}, {2, 15}};

        List<List<Integer>> listKeyTimes = new LinkedList<>();

        for (int i = 0; i < keyTimes.length; i++) {

            Integer[] keyTime = keyTimes[i];
            List<Integer> ints = Arrays.asList(keyTime);
            listKeyTimes.add(ints);
        }

        char ch = slowestKey(listKeyTimes);
        System.out.printf("Slowest key: %s\n", ch);

    }

    public static char slowestKey(List<List<Integer>> keyTimes) {

        int longestPress = 0;
        int longestPressKey = 0;
        for (int i = 0; i < keyTimes.size() - 1; i++) {

            int key = keyTimes.get(i).get(0);
            int countPressed = keyTimes.get(i).get(1);

            if (i == 0) {
                longestPressKey = key;
                longestPress = countPressed;
            }

            int key2 = keyTimes.get(i + 1).get(0);
            int countPressed2 = keyTimes.get(i + 1).get(1);

            int diff = countPressed2 - countPressed;

            if (longestPress < diff) {
                longestPress = diff;
                longestPressKey = key2;
            }
        }

        char ch = keyToChar(longestPressKey);
        return ch;
    }

    private static char keyToChar(int key) {
        return (char) ((char) key + 'a');
    }
}