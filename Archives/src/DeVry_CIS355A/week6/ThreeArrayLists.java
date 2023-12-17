package week6;

import java.util.ArrayList;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class ThreeArrayLists extends JFrame {

	private static final long serialVersionUID = 1L;
	JTextArea textArea;
	
	public ThreeArrayLists() {
		super("ThreeArrayLists");
		setLayout(new FlowLayout());
		setSize(400, 400);
		JButton button = new JButton("Press");
		JLabel label1 = new JLabel("Three Array Lists");

		getContentPane();
		add(label1);
		add(button);

		textArea = new JTextArea(20, 20);
		add(textArea);

		buttonHandler bHandle = new buttonHandler();
		button.addActionListener(bHandle);

	}

	class buttonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			ArrayList<Double> priceList = new ArrayList<Double>();
			ArrayList<Double> quantityList = new ArrayList<Double>();
			ArrayList<Double> amountList = new ArrayList<Double>();

			priceList.add(new Double(10.62));
			priceList.add(new Double(14.89));
			priceList.add(new Double(13.21));
			priceList.add(new Double(16.55));
			priceList.add(new Double(18.62));
			priceList.add(new Double(9.47));
			priceList.add(new Double(6.58));
			priceList.add(new Double(18.32));
			priceList.add(new Double(12.15));
			priceList.add(new Double(3.98));

			quantityList.add(new Double(4.0));
			quantityList.add(new Double(8.5));
			quantityList.add(new Double(6.0));
			quantityList.add(new Double(7.35));
			quantityList.add(new Double(9.0));
			quantityList.add(new Double(15.3));
			quantityList.add(new Double(3));
			quantityList.add(new Double(5.4));
			quantityList.add(new Double(2.9));
			quantityList.add(new Double(4.8));
			{
				String s = "";
				for (int i = 0; i < 10; i++) {
					amountList
							.add((Double.valueOf(priceList.get(i).toString()))
									* (Double.valueOf(quantityList.get(i)
											.toString())));

					 s += String.format("%d) %.2f * %.2f = %.2f \n",i+1,
					 Double.valueOf(priceList.get(i).toString()),
					 Double.valueOf(quantityList.get(i).toString()),
					 Double.valueOf(amountList.get(i).toString()) );

					System.out.printf("%d) %.2f * %.2f = %.2f \n", i + 1,
							Double.valueOf(priceList.get(i).toString()),
							Double.valueOf(quantityList.get(i).toString()),
							Double.valueOf(amountList.get(i).toString()));
				}
				textArea.setText(s);
			}

		}

	}

	public static void main(String[] args) {
		ThreeArrayLists newArray = new ThreeArrayLists();
		newArray.setVisible(true);

	}
}
