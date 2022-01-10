package com.algorithm;

class _72_编辑距离 {
    public int minDistance(String word1, String word2) {
        /**本题采用动态规划思想
        1、假设字符串Word1长度为n1，word2长度为n2;
        2、dp是大小为(n1+1)*(n2+2)的二维数组
        3、dp[i][j]是word1[0,i)转换成word2[0,j)的最少操作数
        4、word1[0,i)是word1的前i个字符串组成的子串。
        5、dp[n1][n2]就是我们的答案。
        场景：
        dp[0][0]:代表空字串转换为空字串的最少操作数，值=0；
        dp[i][0]:word1[0,i)转换为空字串的最少操作数，就是删除。值=i；
        dp[0][j]:空字串转换为word[0,j)的最少操作数，就是增加，值=j;
        如何求出其他位置的dp[i][j]?
        分4种情况进行讨论：
        1）先删除word1[0,i)的最后一个字符得到word1[0,i-1)
           此时：由word1[0,i-1)转换为word[0,j),那么dp[i][j]=1+dp[i-1][j];
        2）先由word1[0,i)转换为word2[0,j-1),然后在最后插入字符word2[j-1]。
            那么dp[i][j]=1+dp[i][j-1];
        3）如果word1[i-1] != word2[j-1],先由word1[0][i-1]转换为word2[0][j-1],
        然后将果word1[i-1]替换为 word2[j-1]，此时dp[i][j]=dp[i-1][j-1]+1；
        4）如果word1[i-1] == word2[j-1],将word1[0][i-1]转换为word2[0][j-1]之后，
        就不需要做任何操作了。此时dp[i][j]=dp[i-1][j-1]；
        */
        //1、进行安全边界检查
        if(word1==null||word2==null){
            return 0;
        }
        char [] c1=word1.toCharArray();
        char [] c2=word2.toCharArray();
        int [][]dp=new int[c1.length+1][c2.length+1];
        dp[0][0]=0;
        for(int i=1;i<=c1.length;i++){
            dp[i][0]=i;
        }
        for(int j=1;j<=c2.length;j++){
            dp[0][j]=j;
        }
        for(int i=1;i<=c1.length;i++){
            for(int j=1;j<=c2.length;j++){
                int a;
                if(c1[i-1]!=c2[j-1]){
                    a=dp[i-1][j-1]+1;
                }else{
                    a=dp[i-1][j-1];
                }
                dp[i][j]=Math.min(Math.min(a,1+dp[i-1][j]),1+dp[i][j-1]);
            }
        }
        return dp[c1.length][c2.length];
    }
}