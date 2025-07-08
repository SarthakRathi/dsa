import java.util.Arrays;

class IsomorphicStrings {
    public static void main(String[] args) {
        String s = "egg";
        String t = "ade";

        int[] sToT = new int[128];
        int[] tToS = new int[128];

        Arrays.fill(sToT, -1);
        Arrays.fill(tToS, -1);

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (sToT[sChar] == -1) {
                sToT[sChar] = tChar;
            } else if (sToT[sChar] != tChar) {
                System.out.println("Not isomorphic");
            }

            if (tToS[tChar] == -1) {
                tToS[tChar] = sChar;
            } else if (tToS[tChar] != sChar) {
                System.out.println("Not isomorphic");
            }
        }
    }
}
