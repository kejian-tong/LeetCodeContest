package LeetCodeContest.weekly438;

class Solution {
    public boolean hasSameDigits(String s) {
        while (s.length() > 2) {
            StringBuilder next = new StringBuilder();
            for (int i = 0; i < s.length() - 1; i++) {
                int sum = (s.charAt(i) - '0' + s.charAt(i + 1) - '0') % 10;
                next.append(sum);
            }
            s = next.toString();
        }
        return s.charAt(0) == s.charAt(1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        System.out.println(solution.hasSameDigits("3902")); // Expected: true
        System.out.println(solution.hasSameDigits("1234")); // Expected: false
        System.out.println(solution.hasSameDigits("9999")); // Expected: true
        System.out.println(solution.hasSameDigits("4567")); // Expected: false
        System.out.println(solution.hasSameDigits("1010")); // Expected: false
    }
}

