import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList

// Program: VZ_2017_05_AMI_EC2.java 
// Created by: Doug Woolley on 5/6/2017
// Description: Given two files, correlating all EC2 to the AMI that created it and 
//              another correlating the AMI's that got created from an EC2,
//              determine the original base-AMI from which an EC2 is derived.
//              Further, all the unique base-AMI's are listed with a count of the number of EC2's that use them.

public class VZ_2017_05_AMI_EC2
{	
	FastReader in, in2;
	PrintWriter out;
	final String FILE_NAME = "Sharedservices-dev Instance ID and AMI id";
	final String FILE_NAME2 = "Shareservices-dev AMI creation";
	final String OUT_FILE_NAME = "ss-dev-ec2-ami-base";
	
//	final String FILE_NAME = "Sharedservices-np Instance ID and AMI id";
//	final String FILE_NAME2 = "Shareservices-np AMI creation";
//	final String OUT_FILE_NAME = "ss-np-ec2-ami-base";
	
	public static void main(String[] args) throws IOException  {
		new VZ_2017_05_AMI_EC2().runWithFiles();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		in2 = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	void runWithFiles() throws IOException  {
		in = new FastReader(new File("src/" + FILE_NAME + ".csv")); 
		in2 = new FastReader(new File("src/" + FILE_NAME2 + ".csv"));
		out = new PrintWriter(new File("src/" + OUT_FILE_NAME + ".out"));

		solve();
		out.close();
	}
	
	void solve()
	{
		// 1. Correlate EC2 built from AMI, from the given file
		// 2. Correlate AMI built from EC2, from the given file
		// 3. Build and display flow from EC2 to base AMI, and associate EC2 with base-AMI used
		// 4. Show count of EC2's for various number of levels between EC2 and AMI
		// 5. Build unique set of base_ami's and the count of how many EC2's used them	
		// 6. Display unique set of base_ami's and the count of how many EC2's used them
		
		// 1. Correlate EC2 built from AMI, from the given file
		TreeMap<String,String> ec2_built_from_ami = new TreeMap<>();
		
		String s = in.nextLine();  //Skip 1st line  
		String ec2, ami;
		s = in.nextLine();  
		while (s != null && !s.equals(""))
		{		
			String[] st = s.split(",");
			//Trim leading/trailing quotations (")
			if (st.length == 2) 
			{	
				ami = st[0].substring(1,st[0].length()-1);
				ec2 = st[1].substring(1,st[1].length()-1);
				ec2_built_from_ami.put(ec2, ami);
			}
		
			s = in.nextLine(); 
		}
		
		int numEc2 = ec2_built_from_ami.size();
		
		System.out.println("ec2_built_from_ami.size() = " + numEc2 + "   FileName = " + FILE_NAME);
		out.println("ec2_built_from_ami.size() = " + numEc2 + "   FileName = " + FILE_NAME);
		
		// 2. Correlate AMI built from EC2, from the given file
		TreeMap<String,String> ami_built_from_ec2 = new TreeMap<>();
		
		s = in2.nextLine();  //Skip 1st line
		s = in2.nextLine();  
		while (s != null && !s.equals(""))
		{		
			String[] st = s.split(",");
			if (st.length == 4) 
			{			
				//Trim leading/trailing quotations (")				
				ec2 = st[0].substring(1,st[0].length()-1);
				ami = st[3].substring(1,st[3].length()-1);
				ami_built_from_ec2.put(ami, ec2);
			}
			
			s = in2.nextLine(); 
		}
		
		int numAmi = ami_built_from_ec2.size();
		
		System.out.println("ami_built_from_ec2.size() = " + numAmi + "   FileName2 = " + FILE_NAME2);
		out.println("ami_built_from_ec2.size() = " + numAmi + "   FileName2 = " + FILE_NAME2);
			
		// 3. Build and display flow from EC2 to base AMI, and associate EC2 with base-AMI used
		TreeMap<String,String> ec2_built_from_base_ami = new TreeMap<>();
		String firstEc2 = "", lastAmi = "", key = "", value = "";
		int maxLevels = 50;   // Maximum number of levels in np thus far has been 33
		int[] levels = new int[maxLevels];
		
		System.out.println("\nFlow from EC2 to base AMI");
		out.println("\nFlow from EC2 to base AMI");
		
		for (Map.Entry<String,String> ent : ec2_built_from_ami.entrySet())  
		{
			ec2 = ent.getKey();			
			ami = ent.getValue();
			firstEc2 = ec2;
			System.out.print(firstEc2);
			out.print(firstEc2);
			
			key = "EC2";
			value = ami;
			lastAmi = ami;
			int level = 1;
			
			while(!value.equals(""))
			{
				System.out.print( " --> " + value);
				out.print(" --> " + value);
				value = "";
				
				if (key.equals("EC2"))
				{
					key = "AMI";
					if (ami_built_from_ec2.get(ami) != null)
					{
						ec2 = ami_built_from_ec2.get(ami);
						value = ec2;
						level++;
					}					
				}
				else //if (key.equals("AMI"))
				{
					key = "EC2";
					if (ec2_built_from_ami.get(ec2) != null)
					{
						ami = ec2_built_from_ami.get(ec2);
						value = ami;
						lastAmi = ami;
						level++;
					}					
				}
			}
			System.out.println();
			out.println();
			levels[level]++;
			ec2_built_from_base_ami.put(firstEc2, lastAmi);
		}			
		
		// 4. Show count of EC2's for various number of levels between EC2 and AMI				
		System.out.println("\nNumber level deep between EC2 and AMI");
		out.println("\nNumber level deep between EC2 and AMI");
		int total = 0;
		for (int i = 0; i < levels.length; i++)
			if (levels[i] > 0)
			{
				System.out.println(i + " level = " + levels[i]);
				out.println(i + " level = " + levels[i]);
				total += levels[i];
			}
		
		System.out.println("Grand total = " + total);
		out.println("Grand total = " + total);
		
		// 5. Build unique set of base_ami's and the count of how many EC2's used them		
		TreeMap<String,Integer> base_ami_count = new TreeMap<>();
		
		for (Map.Entry<String,String> ent : ec2_built_from_base_ami.entrySet())  
		{
			ami = ent.getValue();
			if (base_ami_count.get(ami) == null)
				base_ami_count.put(ami, 1);
			else
				base_ami_count.put(ami, base_ami_count.get(ami) + 1);
		}
		
		// 6. Display unique set of base_ami's and the count of how many EC2's used them
		System.out.println("\nNumber of times base-ami used by EC2");
		out.println("\nNumber of times base-ami used by EC2");
		total = 0;		
		for (Map.Entry<String,Integer> ent : base_ami_count.entrySet())  
		{
			System.out.println(ent.getKey() + " = " + ent.getValue());
			out.println(ent.getKey() + " = " + ent.getValue());
			total += ent.getValue();
		}
		
		System.out.println("Grand total = " + total);
		out.println("Grand total = " + total);		
	}

	//-----------------------------------------------------

	
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
				//throw(new RuntimeException());
				return "";   //Allow end of file to be detected with a null or empty string
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
