package LeetCodeContest.weekly436;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] assignElements(int[] groups, int[] elements) {
        int n = groups.length;
        int m = elements.length;
        int[] assigned = new int[n];

        // Step 1: Store the smallest index of each element
        Map<Integer, Integer> elementMap = new HashMap<>();
        for (int j = 0; j < m; j++) {
            elementMap.putIfAbsent(elements[j], j); // Store the first occurrence (smallest index)
        }

        // Step 2: Process each group
        for (int i = 0; i < n; i++) {
            int minIndex = Integer.MAX_VALUE;
            int groupSize = groups[i];

            // Step 3: Find the smallest valid element index using divisors
            for (int div = 1; div * div <= groupSize; div++) {
                if (groupSize % div == 0) { // div is a divisor
                    // Check if the divisor exists in elements
                    if (elementMap.containsKey(div)) {
                        minIndex = Math.min(minIndex, elementMap.get(div));
                    }
                    // Check if the complementary divisor exists (to avoid duplicate work)
                    int complement = groupSize / div;
                    if (elementMap.containsKey(complement)) {
                        minIndex = Math.min(minIndex, elementMap.get(complement));
                    }
                }
            }

            // Assign the smallest found index, or -1 if no match
            assigned[i] = (minIndex == Integer.MAX_VALUE) ? -1 : minIndex;
        }

        return assigned;
        
    }   
}


/**
Fast Lookup: Uses a HashMap O(1) to find the smallest valid index
Divisibility checkin O(sqrt(V)) 
Handles large inputs efficiently: works within O(N*sqrt(V))

Final:time: O(N*sqrt(10^5))
      space: O(M)

*/


