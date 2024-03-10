package com.prasad.arraysiii;

class Power {

    public static void main(String[] args) {
        System.out.println(new Power().myPow(2, -2147483648));
    }

    public double myPow(double x, int n) {
        boolean isNegative = n < 0 ? true : false;

        if (n == Integer.MIN_VALUE) {
            n = n + 1;
            n = -n;
            double ans =  getFastPower(x, n);
            return 1/(ans * x);
        }

        n = Math.abs(n);
        double ans = getFastPower(x, n);
        if (isNegative) {
            return 1/ans;
        }
        return ans;
    }

    public double getFastPower(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double ans = myPow(x, n / 2);
        if (n % 2 == 0) {
            return ans * ans;
        }
        return x * ans * ans;
    }

}