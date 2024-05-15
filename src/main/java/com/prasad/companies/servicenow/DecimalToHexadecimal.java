package com.prasad.companies.servicenow;

class DecimalToHexadecimal {
    public String toHex(int num) {
        char[] chars = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        StringBuilder sb = new StringBuilder();
        if (num == 0) {
            return "0";
        }

        while (num != 0) {
            sb.append(chars[num & 15]);
            num = num >>> 4 ; // this is called unsigned right shift (to handle negative numbers also)
        }

        return sb.reverse().toString();
    }
}