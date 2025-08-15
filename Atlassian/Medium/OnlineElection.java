import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OnlineElection {
    static class vote {
        int person;
        int time;

        vote(int p, int t) {
            this.person = p;
            this.time = t;
        }
    }

    static List<vote> list;

    OnlineElection(int[] persons, int[] times) {
        list = new ArrayList<vote>();
        Map<Integer, Integer> map = new HashMap<>();
        int leader = -1;
        int votes = 0;
        for (int i = 0; i < persons.length; i++) {
            int p = persons[i];
            int c = map.getOrDefault(p, 0) + 1;
            map.put(p, c);
            if (c >= votes) {
                if (leader != p) {
                    leader = p;
                    list.add(new vote(p, times[i]));
                }
                votes = c;
            }
        }
    }

    public static int q(int t) {
        int ans = -1;
        int s = 0;
        int e = list.size() - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (list.get(mid).time <= t) {
                ans = list.get(mid).person;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int persons[] = { 0, 1, 1, 0, 0, 1, 0 };
        int times[] = { 0, 5, 10, 15, 20, 25, 30 };
        OnlineElection oe = new OnlineElection(persons, times);
        System.out.print(oe.q(3)+" ");
        System.out.print(oe.q(12)+" ");
        System.out.print(oe.q(25)+" ");
        System.out.print(oe.q(15)+" ");
        System.out.print(oe.q(24)+" ");
        System.out.print(oe.q(8)+" ");
    }
}
