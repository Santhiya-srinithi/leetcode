// Last updated: 7/17/2026, 3:03:59 PM
import java.util.*;

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        Map<String, List<String>> memo = new HashMap<>();

        return solve(s, set, memo);
    }

    private List<String> solve(String s, Set<String> set, Map<String, List<String>> memo) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        List<String> result = new ArrayList<>();

        if (s.length() == 0) {
            result.add("");
            return result;
        }

        for (int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i);

            if (set.contains(prefix)) {
                String suffix = s.substring(i);
                List<String> suffixWays = solve(suffix, set, memo);

                for (String way : suffixWays) {
                    if (way.length() == 0) {
                        result.add(prefix);
                    } else {
                        result.add(prefix + " " + way);
                    }
                }
            }
        }

        memo.put(s, result);
        return result;
    }
}