package spoj;
import java.io.*;
public class SPOJ_1724_TRICOUNT_Counting_Triangles_compact
{	
public static void main(String[] args) throws IOException {
BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
int mx=1_000_001,x;
long[] s=new long[mx];
s[1]=1;
for(int i=2;i<mx;i++)
{
s[i]=s[i-1]+i*2-1+((i-1)+1L)*(i-1)/2L;
x=i-(i%2==1?2:1);
s[i]+=((i-x)+(i-3))*((x-1)/2L)/2;
}
int t=Integer.parseInt(in.readLine()); 
for(int T=1;T<=t;T++){			
int n=Integer.parseInt(in.readLine());	
System.out.println(s[n]);	
}
}
}