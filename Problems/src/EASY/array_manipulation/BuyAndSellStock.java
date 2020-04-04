package EASY.array_manipulation;

/*
Say you have an array for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock),
design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.
Example 1:
Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.

 */

public class BuyAndSellStock {

    // forgot to consider that we are treating it as a 1-index based array. < -- didn't even matter
    // you had to return the maximum profit not the index that gives you maximum profit.  < -- READ Carefully

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;

        return 0;
    }

    public static int maxProfitFailed(int[] prices) {
        int minVal = Integer.MAX_VALUE, minInd = 0;
        for(int i=0; i<prices.length; i++)
            if (prices[i] < minVal) {
                minVal = prices[i];
                minInd = i;
            }
        int maxProf = 0, maxProfInd = -1;
        for(int i = minInd + 1; i<prices.length; i++) {
            int diff = prices[i] - prices[minInd];
            if (diff > maxProf) {
                maxProf = diff;
                maxProfInd = i;
            }
        }
        return (maxProfInd==-1)? 0: maxProfInd+1;
    }

    public static void main(String[] args) {
        int[] a = {2,9};
        System.out.println(maxProfit(a));
    }
}
