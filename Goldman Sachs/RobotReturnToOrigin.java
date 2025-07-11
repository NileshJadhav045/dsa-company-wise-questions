
public class RobotReturnToOrigin {
    public static boolean judgeCircle(String moves){
        int n=moves.length();
        int x=0; 
        int y=0;
        for(int i=0; i<n; i++){
            if (moves.charAt(i)=='L') {
                x++;
            }else if (moves.charAt(i)=='R') {
                x--;
            } else if (moves.charAt(i)=='U') {
                y++;
            }else{
                y--;
            }
        }
        if (x ==0 && y==0) {
            return true;
        }else{
            return false;
        }

    }
    public static void main(String[] args) {
        String moves = "LL";
        System.out.println(judgeCircle(moves));
    }
}
