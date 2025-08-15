import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OnlineElection {

    // Vote record ka class (leader + uska time)
    static class vote {
        int person; // leader ka id
        int time; // jis time pe leader bana

        vote(int p, int t) {
            this.person = p;
            this.time = t;
        }
    }

    // Ye list leader changes ka history rakhegi
    static List<vote> list;

    @SuppressWarnings("Convert2Diamond")
    OnlineElection(int[] persons, int[] times) {
        list = new ArrayList<vote>();
        Map<Integer, Integer> map = new HashMap<>(); // har person ka vote count
        int leader = -1; // current leader ka id
        int votes = 0; // current leader ke votes

        // Har vote ke liye process karo
        for (int i = 0; i < persons.length; i++) {
            int p = persons[i];

            // Ye person ke votes increment karo
            int c = map.getOrDefault(p, 0) + 1;
            map.put(p, c);

            // Agar is bande ke votes leader ke votes ke barabar ya zyada hain
            if (c >= votes) {
                // Agar leader change ho gaya
                if (leader != p) {
                    leader = p; // naye leader ka id
                    // List me naye leader ka record store karo
                    list.add(new vote(p, times[i]));
                }
                // Leader ke votes update karo
                votes = c;
            }
        }
    }

    // Query function: given time t, us time pe leader kaun tha
    public static int q(int t) {
        int ans = -1; // default answer
        int s = 0;
        int e = list.size() - 1; // binary search ka end index

        // Binary search chalake last leader <= t find karo
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (list.get(mid).time <= t) {
                ans = list.get(mid).person; // potential answer
                s = mid + 1; // right side me search karo
            } else {
                e = mid - 1; // left side me search karo
            }
        }
        return ans;
    }

    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        int persons[] = { 0, 1, 1, 0, 0, 1, 0 };
        int times[] = { 0, 5, 10, 15, 20, 25, 30 };

        // Object create karke history prepare karega
        OnlineElection oe = new OnlineElection(persons, times);

        // Queries run karke output print karega
        System.out.print(oe.q(3) + " "); // Time 3 pe leader kaun
        System.out.print(oe.q(12) + " "); // Time 12 pe leader kaun
        System.out.print(oe.q(25) + " "); // Time 25 pe leader kaun
        System.out.print(oe.q(15) + " "); // Time 15 pe leader kaun
        System.out.print(oe.q(24) + " "); // Time 24 pe leader kaun
        System.out.print(oe.q(8) + " "); // Time 8 pe leader kaun
    }
}
