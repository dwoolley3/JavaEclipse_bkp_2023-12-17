package dougTest;

public class ReverseWords {

	private String s;
	
	ReverseWords(String inputS) {
		s = inputS;
	}
	
	public String getReversedWords()
	{
		char[] c = new char[s.length()+1];
		for (int i = 0; i < s.length(); i++)
			c[i] = s.charAt(i);
		reverse(c, 0, c.length - 2);
		c[s.length()] = ' ';
		int st = 0, en = 0;
		while (en < c.length)
		{
			while (en < c.length - 1 && c[++en] != ' ') {}
			reverse(c, st, en - 1);
			st = en+1; en = st;				
		}				
		return new String(c);
	}
	
	private void reverse(char[] c, int st, int en)
	{
		for (int i = 0; i < (en - st + 1) / 2; i++)
			swap(c, st + i, en - i);
	}
	
	private void swap(char[] c, int i, int j)
	{
		char temp = c[i]; c[i] = c[j]; c[j] = temp;
	}
	
	public static void main(String[] arg)
	{
		String s = "Mary had a little lamb";
		ReverseWords rw = new ReverseWords(s);
		System.out.println(s);
		System.out.println(rw.getReversedWords());
	}
}
