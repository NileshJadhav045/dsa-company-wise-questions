import java.util.ArrayList;
import java.util.List;

public class NumberOfLesser {
    public static int numberOfBeams(String[] bank) {
        List<Integer> ans = new ArrayList<>();

        // Step 1: Count the number of devices in each row
        for (String row : bank) {
            // Count how many '1's are present in the current row
            int c = (int) row.chars().filter(ch -> ch == '1').count();

            // If the row has at least one device, store its count
            if (c != 0) {
                ans.add(c);
            }
        }

        int sum = 0;

        // Step 2: If there are less than 2 non-empty rows, no beams can be formed
        if (ans.size() <= 1) {
            return 0;
        }

        // Step 3: Calculate beams between consecutive non-empty rows
        // The number of beams between two rows is (devices in row i) * (devices in row
        // i+1)
        for (int i = 0; i < ans.size() - 1; i++) {
            sum = sum + ans.get(i) * ans.get(i + 1);
        }

        return sum;
    }

    public static void main(String[] args) {
        String[] bank = { "011001", "000000", "010100", "001000" };
        System.out.println(numberOfBeams(bank));
    }
}
