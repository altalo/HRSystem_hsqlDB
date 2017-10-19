import javax.swing.*;
import javax.swing.border.*;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class TestGridLayout {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		frame.setSize(800,800);
		frame.setLayout(new GridLayout(1,2));
		
		//Insert Components		
		
		JPanel icPanel = new JPanel();
		icPanel.setBorder(new TitledBorder("添加公司"));
		icPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		icPanel.add(insertColumn("名称"));
		icPanel.add(insertColumn("级别"));
		icPanel.add(insertColumn("薪资"));
		icPanel.add(insertColumn("名称"));
		icPanel.add(new JButton("提交"));
		
		//Insert Job Title
		JPanel ijtPanel = new JPanel();
		ijtPanel.setBorder(new TitledBorder("添加职位"));
		ijtPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		ijtPanel.add(insertColumn("名称"));
		ijtPanel.add(insertColumn("级别"));
		ijtPanel.add(insertColumn("薪资"));
		ijtPanel.add(insertColumn("名称"));
				
		//Insert Panel
		JPanel insertPanel = new JPanel();
		insertPanel.setBorder(new TitledBorder("插入数据"));
		insertPanel.setLayout(new GridLayout(2,1));
		insertPanel.add(icPanel);
		insertPanel.add(ijtPanel);
		
		//Display Components
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		panel1.setBorder(new TitledBorder("Panel one"));
		panel2.setBorder(new TitledBorder("Panel one"));
		
		//Display Panel
		JPanel dPanel = new JPanel();
		dPanel.setLayout(new GridLayout(1,2,10,30));
		dPanel.add(panel1);
		dPanel.add(panel2);
		
		//Insert and Display panel
		JSplitPane sp1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,insertPanel,dPanel);
		sp1.setDividerLocation(300);
		
		//Search Job Title
		JPanel sjtPanel = new JPanel();
		sjtPanel.setBorder(new TitledBorder("根据职位筛选"));
		sjtPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		sjtPanel.add(insertColumn("名称"));
		sjtPanel.add(insertColumn("级别"));
		sjtPanel.add(insertColumn("薪资"));
		sjtPanel.add(insertColumn("名称"));
		sjtPanel.add(insertSelect());
		
		//Search Company
		JPanel scPanel = new JPanel();
		scPanel.setBorder(new TitledBorder("根据公司筛选"));
		scPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		scPanel.add(insertColumn("名称"));
		scPanel.add(insertColumn("级别"));
		scPanel.add(insertColumn("薪资"));
		scPanel.add(insertColumn("名称"));
		
		//Search Box Panel
		JPanel searchboxPanel = new JPanel();
		searchboxPanel.setLayout(new GridLayout(2,1));
		searchboxPanel.setBorder(new TitledBorder("Search"));
		searchboxPanel.add(sjtPanel);
		searchboxPanel.add(scPanel);
		
		//Search Result Panel
		JPanel result = new JPanel();
		result.setBorder(new TitledBorder("Result"));
		
		//Search Panel
		JSplitPane searchPanel = new JSplitPane(JSplitPane.VERTICAL_SPLIT,searchboxPanel,result);
		searchPanel.setDividerLocation(300);
		
		frame.add(sp1);
		frame.add(searchPanel);
		frame.setVisible(true);
		
	}
	
	public static JPanel insertColumn(String x){
		JPanel column = new JPanel();
		column.setLayout(new FlowLayout(FlowLayout.LEFT));
		column.add(new JLabel(x));
		column.add(new JTextField(5));
		return column;
	}

	public static JComboBox<String> insertSelect(){
		JComboBox<String> box= new JComboBox<String>();
		box.addItem("123");
		box.addItem("456");
		return box;
		
	}
}
