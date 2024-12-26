import javax.swing.JOptionPane;
public class UsingSwingClass {

	/**
	 * Implementinng the input dialog box and show message 
	 *+box
	 * Something to check on the showMessage dialog box 
	 * JOption.PLAIN_MESSAGE is the one without any icon
	 */
	public static void main(String[] args) {
		String num1, num2, color1, color2, color3, color4, color5;
		int number1, number2, sum;
		
		
		num1 = JOptionPane.showInputDialog("num1");
		number1 = Integer.parseInt(num1);
				
		num2 = JOptionPane.showInputDialog("num2");
		number2 = Integer.parseInt(num2);
		
		sum = number1 + number2;
		
		JOptionPane.showMessageDialog(null, "the sum is : " + sum , "Results", JOptionPane.PLAIN_MESSAGE );
		//colors
		color1 = JOptionPane.showInputDialog("color1");
		color2 = JOptionPane.showInputDialog("color2");
		color3 = JOptionPane.showInputDialog("color3");
		color4 = JOptionPane.showInputDialog("color4");
		color5 = JOptionPane.showInputDialog("color5");
		
		JOptionPane.showMessageDialog(null, "the colors are : " + color1 + ", " + color2 + ", " + color3 + ", " + color4 + ", " + color5, "Results", JOptionPane.PLAIN_MESSAGE );
		
		
		System.exit(0);
		
	}
}

