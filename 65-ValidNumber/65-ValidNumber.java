// Last updated: 7/17/2026, 3:04:50 PM
class Solution {
    public boolean isNumber(String s) {

        boolean digitSeen = false;
        boolean dotSeen = false;
        boolean exponentSeen = false;
        boolean digitAfterExponent = true;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // Digit
            if (Character.isDigit(ch)) {
                digitSeen = true;

                if (exponentSeen) {
                    digitAfterExponent = true;
                }
            }

            // Plus or minus sign
            else if (ch == '+' || ch == '-') {

                // Sign is allowed only at the beginning
                // or immediately after e/E
                if (i != 0 &&
                    s.charAt(i - 1) != 'e' &&
                    s.charAt(i - 1) != 'E') {
                    return false;
                }
            }

            // Decimal point
            else if (ch == '.') {

                // Dot cannot appear twice or after exponent
                if (dotSeen || exponentSeen) {
                    return false;
                }

                dotSeen = true;
            }

            // Exponent
            else if (ch == 'e' || ch == 'E') {

                // Exponent cannot appear twice
                // and must have a digit before it
                if (exponentSeen || !digitSeen) {
                    return false;
                }

                exponentSeen = true;
                digitAfterExponent = false;
            }

            // Any other character
            else {
                return false;
            }
        }

        return digitSeen && digitAfterExponent;
    }
}