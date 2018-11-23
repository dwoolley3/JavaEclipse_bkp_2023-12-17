package spoj;
import java.io.*;
public class SPOJ_3442_LASTDIG_The_last_digit_compact
{	
public static void main(String[] args) throws IOException {
BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
int t = Integer.parseInt(in.readLine());
for (int T = 1; T <= t; T++) {
String[] s = in.readLine().split(" ");
int a = Integer.parseInt(s[0]);
int b = Integer.parseInt(s[1]);
if (a == 0) 
System.out.println(0);
else if (b == 0)
System.out.println(1);
else {				
int[] d = new int[11];
int i = 0;
d[i] = a % 10;
int prod = d[i];
while (i < 10 && (prod * d[0]) % 10 != d[0])
{
i++; 
prod *= d[0];
d[i] = prod % 10;
prod = d[i];
}
i++;
b--;
b %= i;				
System.out.println(d[b]);	
}
}
}
}
