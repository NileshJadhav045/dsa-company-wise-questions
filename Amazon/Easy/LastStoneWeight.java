package Amazon.Easy;

import java.util.PriorityQueue;
/* Leetcode -> 1046. Last Stone Weight
 * You are given an array of integers stones where stones[i] is the weight of the ith stone.

    We are playing a game with the stones. On each turn, we choose the heaviest two 
    stones and smash them together. Suppose the heaviest two stones have weights 
    x and y with x <= y. The result of this smash is:

    If x == y, both stones are destroyed, and
    If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
    At the end of the game, there is at most one stone left.

    Return the weight of the last remaining stone. If there are no stones left, return 0.
 */
public class LastStoneWeight {
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) {
            pq.offer(stone);
        }
        while (pq.size() > 1) {
            int x = pq.poll();
            int y = pq.poll();
            if (x != y) pq.offer(x - y);
        }
        return pq.isEmpty() ? 0 : pq.poll();

    }

    public static void main(String[] args) {
        int stones[] = {2,7,4,1,8,1};
        System.out.println(lastStoneWeight(stones));
    }
}
