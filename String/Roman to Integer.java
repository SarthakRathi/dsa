class Solution {
    public int romanToInt(String s) {
        int[] values = new int[128];
        values['I'] = 1;
        values['V'] = 5;
        values['X'] = 10;
        values['L'] = 50;
        values['C'] = 100;
        values['D'] = 500;
        values['M'] = 1000;

        int result = 0;
        int prevValue = 0;

        for (int i = 0; i < s.length(); i++) {
            int currentValue = values[s.charAt(i)];
            if (currentValue > prevValue) {
                result += currentValue - 2 * prevValue;
            } else {
                result += currentValue;
            }
            prevValue = currentValue;
        }
        return result;
    }
}