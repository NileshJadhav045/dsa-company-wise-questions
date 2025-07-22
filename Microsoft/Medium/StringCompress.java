public class StringCompress {
    public static String compress(String str) {
        int n = str.length();
        StringBuilder sb = new StringBuilder(); // store the updated str
        Integer count; // count the similer char
        for (int i = 0; i < n; i++) {
            count = 1; // first char
            while (i < n - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++; // found similar char
                i++; // increment the i
            }
            sb.append(str.charAt(i)); // add char in to sb
            if (count > 1) { // check if count < 1 then add to the sb
                sb.append(String.valueOf(count)); // convert integer to char
            }
        }
        return sb.toString(); // return the ans sb
    }

    public static void main(String[] args) {
        String s = "aaabbddddeec"; // a3b2d4e2c
        System.out.println(compress(s));
    }
}
