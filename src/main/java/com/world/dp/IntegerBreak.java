package com.world.dp;

public class IntegerBreak {

    // dp[i+j] = max( i * j, dp[i+j] )
    //         = max( max( dp[i], i ) * max( dp[j], j ), dp[i+j] )

    int integerBreak(int n) {
        int[] dp = new int[1 + n];

        for (int i = 1; i < n; ++i) {
            for (int j = 1; j <= i; ++j) {
                if (i + j <= n) {
                    dp[i + 1] = Math.max(Math.max(dp[i], i) * Math.max(dp[j], j), dp[i + 1]);
                }
            }
        }

        return dp[n];
    }
}
