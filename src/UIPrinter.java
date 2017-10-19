import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class UIPrinter extends JFrame{
	public UIPrinter(){
		this.setTitle("TestFrame");
		this.setSize(500,500);
		JScrollPane ListOut = new JScrollPane();
		JPanel list = new JPanel();
		list.setLayout(new GridLayout(30,1));
		int i=0;
		while(i<30){
		list.add(new JLabel("ְԱ"));
			i++;
		}
		ListOut.setViewportView(list);
		add(ListOut);
	}
}
