package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class Ed17_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new Ed17_B().run();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	void solve()
	{
		int usbOnly = in.nextInt();
		int ps2Only = in.nextInt();
		int both = in.nextInt();
		int m = in.nextInt();

		ArrayList<Integer> usb = new ArrayList<>();
		ArrayList<Integer> ps2 = new ArrayList<>();
		for (int i = 0; i < m; i++)
		{
			int val = in.nextInt();
			String s = in.next();
			if (s.equals("USB")) usb.add(val); else ps2.add(val);
		}
		Collections.sort(usb);
		Collections.sort(ps2);
		
		int iusb = 0, ips2 = 0, equip = 0;
		long cost = 0;
		int maxEquip = Math.min(usbOnly + ps2Only + both, usb.size() + ps2.size());
		while (equip < maxEquip)
		{
			int cost_usb = Integer.MAX_VALUE, cost_ps2 = Integer.MAX_VALUE;
			if (iusb < usb.size()) 
				cost_usb = usb.get(iusb);
			if (ips2 < ps2.size())
				cost_ps2 = ps2.get(ips2);
			if (cost_usb < cost_ps2)
				if (usbOnly > 0)
				{
					usbOnly--;
					cost += cost_usb;
					iusb++;
				}
				else if (both > 0)
				{
					both--;
					cost += cost_usb;
					iusb++;
				}
				else if (cost_ps2 < Integer.MAX_VALUE)
				{
					ps2Only--;
					cost += cost_ps2;
					ips2++;
				}
				else
					break;
			else // cost_ps2 <= cost_usb
				if (ps2Only > 0)
				{
					ps2Only--;
					cost += cost_ps2;
					ips2++;
				}
				else if (both > 0)
				{
					both--;
					cost += cost_ps2;
					ips2++;
				}
				else if (cost_usb < Integer.MAX_VALUE)
				{
					usbOnly--;
					cost += cost_usb;
					iusb++;
				}
				else
					break;
			equip++;
		}
		
		out.println(equip + " " + cost);
	}

	//-----------------------------------------------------
	void runWithFiles() {
		in = new FastReader(new File("input.txt"));
		try {
			out = new PrintWriter(new File("output.txt"));
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		solve();
		out.close();
	}
	
	class FastReader
	{
	    BufferedReader br;
	    StringTokenizer tokenizer;
	    
	    public FastReader(InputStream stream)
	    {
	        br = new BufferedReader(new InputStreamReader(stream));
	        tokenizer = null;
	    }
		public FastReader(File f) {
			try {
				br = new BufferedReader(new FileReader(f));
				tokenizer = null;
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	    
	    private String next() {
	        while (tokenizer == null || !tokenizer.hasMoreTokens())
	            try {
	            	tokenizer = new StringTokenizer(br.readLine());
	            }
	            catch (IOException e) {
	                throw new RuntimeException(e);
	            }
	        return tokenizer.nextToken();
	    }
		public String nextLine() {
			try	{
				return br.readLine();
			}
			catch(Exception e) {
				throw(new RuntimeException());
			}
		}

	    int nextInt() {
	        return Integer.parseInt(next());
	    }
	    long nextLong() {
	        return Long.parseLong(next());
	    }
	    double nextDouble() {
	        return Double.parseDouble(next());
	    }	    
	    BigInteger nextBigInteger() {
	        return new BigInteger(next());
	    }
	    BigDecimal nextBigDecimal() {
	        return new BigDecimal(next());
	    }
	}
}
