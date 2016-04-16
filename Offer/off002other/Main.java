package off002other;

import java.io.*;
public class Main {
        public static void main(String[] args) throws Exception{
         
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(
        new InputStreamReader(System.in)));
        while(st.nextToken() != StreamTokenizer.TT_EOF){
            int m = (int)st.nval;
            st.nextToken();
            int n = (int)st.nval;
            st.nextToken();
            int s = (int)st.nval;
            boolean flag = false;
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    st.nextToken();
                    if(s == (int)st.nval)flag=true;
                }
            }
             
            if(flag){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
             
        }
    }
     
    static boolean fun(int[][] g,int m,int n,int s){
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(s == g[i][j]){
                    return true;
                }
            }
        }
        return false;
    }
}