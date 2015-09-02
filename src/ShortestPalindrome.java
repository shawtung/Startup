public class ShortestPalindrome {
    public static void main(String[] args) {
        String test = "abgbacr";
        String test_rev = shortestPalindrome(test);
        System.out.println(test_rev);
    }

    /*    public static String shortestPalindrome(String s) {
            String r = "";
            for (int i = s.length()-1; i >=0 ; i--) {
                r+=s.charAt(i);
            }
    
            for (int i = 0; i <= s.length() - 1; i++) {
                String s_sub = s.substring(0, s.length() - i);
                String r_sub = r.substring(i);
                if (s_sub.equals(r_sub)) {
                    return r.substring(0, i) + s;
                }
            }
            return "";
        }
     */
    public static String reverse(String s) {
        String rev = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            rev += s.charAt(i);
        }
        return rev;
    }


    public static String shortestPalindrome(String s) {
        String l = "", r = "";
        while (!s.equals(null)) {
            int j = 0;
            for (int i = s.length() - 1; i >= 0; i--) {
                if (s.charAt(j) == s.charAt(i)) {
                    j++;
                }
            }
            if (j == s.length()) {
                return l + s + r;
            } else {
                l = l + reverse(s.substring(j));
                r = s.substring(j) + r;
                s = s.substring(0, j);
            }
        }
        return "";
    }
}