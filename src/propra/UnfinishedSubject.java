package propra;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class UnfinishedSubject extends JFrame implements ActionListener{

	public class MainPanel {

	}

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	Object[][] data = new Object[9][3];
	String[] columns = {"Column0","Column1","Column2"};
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public void launchUnfinishedSubjectPanel() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UnfinishedSubject frame = new UnfinishedSubject();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UnfinishedSubject() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 1000, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{148, 141, 136, 0};
		gbl_contentPane.rowHeights = new int[]{21, 96, 21, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		textField = new JTextField();
		textField.setText("更新日");
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 0;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setText("通知");
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 0;
		contentPane.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setText("URL");
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.gridx = 2;
		gbc_textField_2.gridy = 0;
		contentPane.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		table = new JTable(data, columns);
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridwidth = 3;
		gbc_table.insets = new Insets(0, 0, 5, 0);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 1;
		contentPane.add(table, gbc_table);
		
		btnNewButton = new JButton("更新");
		btnNewButton.addActionListener(this);
		btnNewButton.setActionCommand("kousin");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 2;
		contentPane.add(btnNewButton, gbc_btnNewButton);
	}
	
	public void actionPerformed(ActionEvent e){
		String cmd = e.getActionCommand();
		int counter = 0;
		if(cmd.equals("kousin")) {
			System.out.println("更新");
			
			try {
	    		
		    	
	    		 Document doc = Jsoup.connect("https://www.nagasaki-u.ac.jp/ja/student/").get();
	    		 
	    		 Element body = doc.body();
	    		
	 
	    		 //System.out.println(doc.html());
	    		 //System.out.println(body.html());
	    		 
	    		 Elements elements = body.select(".student_news dl dt");
	    		 Elements elements2 = body.select(".student_news dl dd a");
	    	        for (Element element : elements) {
	    	            System.out.println(element.ownText());
	    	            String elementString = String.valueOf(element.ownText());
	    	            data[counter][0] = elementString;
	    	            counter++;
	    	        }
	    	        counter =  0;
	    	        for (Element element : elements2) {
	    	            System.out.println(element.ownText()+"  "+ element.absUrl("href"));
	    	            String elementString = String.valueOf(element.ownText());
	    	            String element2String = String.valueOf(element.absUrl("href"));    	           
	    	            data[counter][1] = elementString;
	    	            data[counter][2] = element2String;
	    	            counter++;
	    	        }
	    	        counter = 0;
	    	        
	             
	    	}catch(IOException e1) {
	    		e1.printStackTrace();
	    	}
			
			for(int i = 0; i <= 8; i++) {
				System.out.println( data[i][0]);
				System.out.println( data[i][1]);
				System.out.println( data[i][2]);
			}
			for(int i = 0; i <= 8; i++) {
				table.setValueAt( data[i][0], i, 0);
				table.setValueAt( data[i][1], i, 1);
				table.setValueAt( data[i][2], i, 2);
			}
			
		}
	}

}
