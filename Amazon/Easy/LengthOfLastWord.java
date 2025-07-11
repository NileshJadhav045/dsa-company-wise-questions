package Amazon.Easy;

public class LengthOfLastWord {
    public static int countLength(String str){
        int lenCount=0;
        str=str.trim();
        int n=str.length();
        for(int i=0; i<n; i++){
            if (str.charAt(i) != ' ') {
                lenCount++;
            }else{
                lenCount=0;
            }
        }
        return lenCount;
    }
    public static void main(String[] args) {
        String str = "I love codind";
        System.out.println("Length of Last word is: "+countLength(str));
    }
}
