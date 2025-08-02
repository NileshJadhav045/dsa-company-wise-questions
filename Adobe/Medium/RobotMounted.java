public class RobotMounted {
    /*
     * Leetcode -> 1041. Robot Bounded In Circle
     * On an infinite plane, a robot initially stands at (0, 0) and faces north.
     * Note that:
     * 
     * The north direction is the positive direction of the y-axis.
     * The south direction is the negative direction of the y-axis.
     * The east direction is the positive direction of the x-axis.
     * The west direction is the negative direction of the x-axis.
     * The robot can receive one of three instructions:
     * 
     * "G": go straight 1 unit.
     * "L": turn 90 degrees to the left (i.e., anti-clockwise direction).
     * "R": turn 90 degrees to the right (i.e., clockwise direction).
     * The robot performs the instructions given in order, and repeats them forever.
     * 
     * Return true if and only if there exists a circle in the plane such that the
     * robot never leaves the circle.
     */
    public static boolean isRobotBounded(String instructions) {
        // Initial direction is North
        char D = 'N';
        int x = 0, y = 0;

        for (char i : instructions.toCharArray()) {
            switch (i) {
                case 'G' -> {
                    // Move one step in the current direction
                    switch (D) {
                        case 'N' : y++;
                        case 'E' : x++;
                        case 'S' : y--;
                        case 'W' : x--;
                        default : {
                        }
                    }
                }

                case 'L' -> {
                    // Turn left: N->W, W->S, S->E, E->N
                    switch (D) {
                        case 'N' : D = 'W';
                        case 'W' : D = 'S';
                        case 'S' : D = 'E';
                        case 'E' : D = 'N';
                        default  :{
                        }
                    }
                }

                case 'R' -> {
                    // Turn right: N->E, E->S, S->W, W->N
                    switch (D) {
                        case 'N' : D = 'E';
                        case 'E' : D = 'S';
                        case 'S' : D = 'W';
                        case 'W' : D = 'N';
                        default  :{
                        }
                    }
                }
            }
        }

        // The robot is bounded in a circle if:
        // 1. It's back at the origin (0, 0)
        // 2. It's not facing North after one cycle (which means it will turn
        // eventually)
        return (x == 0 && y == 0) || D != 'N';
    }

    public static void main(String[] args) {
        String instructions = "GGLLGG";
        System.out.println(isRobotBounded(instructions));
    }
}
