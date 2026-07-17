// Last updated: 7/17/2026, 3:04:02 PM
class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> wordDict = new HashSet<>(wordList);

        if (!wordDict.contains(endWord))
            return 0;

        Set<String> reached = new HashSet<>();
        reached.add(beginWord);

        wordDict.remove(beginWord);

        int distance = 1;

        while (!reached.contains(endWord)) {

            Set<String> toAdd = new HashSet<>();

            for (String word : reached) {

                char[] chars = word.toCharArray();

                for (int i = 0; i < chars.length; i++) {

                    char original = chars[i];

                    for (char ch = 'a'; ch <= 'z'; ch++) {

                        chars[i] = ch;
                        String newWord = new String(chars);

                        if (wordDict.contains(newWord)) {
                            toAdd.add(newWord);
                            wordDict.remove(newWord);
                        }
                    }

                    chars[i] = original;
                }
            }

            if (toAdd.isEmpty())
                return 0;

            reached = toAdd;
            distance++;
        }

        return distance;
    }
}