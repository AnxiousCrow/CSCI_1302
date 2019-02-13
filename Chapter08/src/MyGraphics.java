
import javax.swing.JFrame;//So I can call and use my my panel class

public class MyGraphics {

	public static void main(String[] args) 
	{
	      JFrame frame = new JFrame("MyGraphicsPanel");//declaring my frame and giving it a title
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//closing the program when Frame is closed

	      frame.getContentPane().add(new MyGraphicsPanel());//declare the panel from the class I created

	      frame.pack();//adding the panel
	      frame.setVisible(true);//making it visible

	}

}
