package com.cszjo.leetcode.array;

public class Solution5 {

    public void palindrome1(String str)
    {

        if(str==null||str.length()==0)
            return ;
        char chs[]=str.toCharArray();
        int max_len=0;
        boolean f[][]=new boolean[chs.length][chs.length];
        for(int j=0;j<str.length();j++)
        {
            int i=0;
            f[j][j]=true;
            //一个元素肯定是回文串。
            for(;i<j;i++)
            {
                f[i][j]=(chs[j]==chs[i]&&(j-i<2||j>0&&f[i+1][j-1]));
                //如果chs[j]==chs[i]当串的长度小于等于2时，肯定是回文子串，如 1，1，就是回文串。
                //如果长度大于2时，则需要判断f[i+1][j-1]是不是回文。
                if(f[i][j])
                {
                    max_len=Math.max(max_len, j-i+1);
                }
                //max_len保存最大回文子串的长度。
            }
        }
        System.out.println(max_len);
    }

    public static void main(String[] args) {
        new Solution5().palindrome1("abccba");
    }
}
