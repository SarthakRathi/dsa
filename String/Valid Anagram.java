class ValidAnagram {
    public static void main(String[] args) {
        String s = "anagramt";
        String t = "nagaram";

        if (s.length() != t.length()) {
            System.out.println("Not anagram");
        }

        int[] charCount = new int[26];

        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a']++;
            charCount[t.charAt(i) - 'a']--;
        }

        for (int count : charCount) {
            if (count != 0) {
                System.out.println("Not anagram");
                break;
            }
        }
    }
}
