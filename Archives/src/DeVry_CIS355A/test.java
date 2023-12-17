
public class test {

	public static void main(String[] args) {
		double[] Scores = {10.3, 8.3, 7.2, 7.0, 5.3, 3.8, 1.4};
		double sum = 0;
		int numOfScores = Scores.length;
		for (int i = 0; i < numOfScores; i++)
			sum += Scores[i];
		double average = sum / numOfScores;
		int greater = 0, less = 0;
		for (int i = 0; i < numOfScores; i++)
		{
			if (Scores[i] <= average)
				less++;
			else   // (Scores[i] > average)
				greater++;
		}
		
		System.out.println("Average = " + average); 
		System.out.println("Number less than or equal to average = " + less); 
		System.out.println("Number greater than average = " + greater); 
	}

}
