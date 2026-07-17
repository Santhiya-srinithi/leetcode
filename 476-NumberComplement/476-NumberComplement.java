// Last updated: 7/17/2026, 3:03:07 PM
class Solution {
    public int findComplement(int num) 
    {
        int mask = 0;
        while(mask<num)
        {
            mask = (mask<<1)|1;
        }
        int complement = mask^num; 
    return complement;
    }
}