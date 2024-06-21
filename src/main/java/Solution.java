public class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int sum = 0;
        int n = customers.length;
        for (int i = 0; i < n; i++) {
            sum += customers[i] * (1 - grumpy[i]);
        }

        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1) {
                sum += customers[i];
            }
        }

        int res = sum;
        int start = 0;

        for (int i = minutes; i < n; i++) {
            if (grumpy[i] == 1) {
                sum += customers[i];
            }
            if (grumpy[start] == 1) {
                sum -= customers[start];
            }
            start++;

            res = Math.max(sum, res);
        }

        return res;
    }
}
