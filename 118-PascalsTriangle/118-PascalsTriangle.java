// Last updated: 7/17/2026, 3:04:11 PM
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for (int row = 0; row < numRows; row++) {
            List<Integer> currentRow = new ArrayList<>();

            for (int col = 0; col <= row; col++) {

                // First and last values in every row are 1
                if (col == 0 || col == row) {
                    currentRow.add(1);
                } else {
                    int value = result.get(row - 1).get(col - 1)
                              + result.get(row - 1).get(col);

                    currentRow.add(value);
                }
            }

            result.add(currentRow);
        }

        return result;
    }
}