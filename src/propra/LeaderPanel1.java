package propra;

import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class LeaderPanel1 extends JFrame implements ActionListener{

	/**
	 * 画面を立ち上げる
	 */
	public void launchLeaderPanel1() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LeaderPanel1 frame = new LeaderPanel1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * 画面の構成.
	 */
	public LeaderPanel1() {
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{153, 0};
		gridBagLayout.rowHeights = new int[]{46, 50, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("基本画面");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 7;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		JButton btnNewButton = new JButton("お知らせ表示");
		btnNewButton.addActionListener(this);
		btnNewButton.setActionCommand("move_unfinished");//内部値の設定
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridwidth = 7;
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 1;
		getContentPane().add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_4 = new JButton("健康システム");
		btnNewButton_4.addActionListener(this);
		
		JButton btnNewButton_3 = new JButton("長大ホーム");
		btnNewButton_3.addActionListener(this);
		
		JButton btnNewButton_2 = new JButton("NUWebシステム");
		btnNewButton_2.addActionListener(this);
		
		JButton btnNewButton_1 = new JButton("LACS");
		btnNewButton_1.setHorizontalAlignment(SwingConstants.RIGHT);
		btnNewButton_1.addActionListener(this);
		
		JLabel lblNewLabel_1 = new JLabel("ジャンプ");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		btnNewButton_1.setActionCommand("LACS");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.anchor = GridBagConstraints.BASELINE;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridwidth = 7;
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 3;
		getContentPane().add(btnNewButton_1, gbc_btnNewButton_1);
		btnNewButton_2.setActionCommand("NUWebシステム");
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_2.gridwidth = 7;
		gbc_btnNewButton_2.gridx = 0;
		gbc_btnNewButton_2.gridy = 4;
		getContentPane().add(btnNewButton_2, gbc_btnNewButton_2);
		btnNewButton_3.setActionCommand("長大ホーム");
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.gridwidth = 7;
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_3.gridx = 0;
		gbc_btnNewButton_3.gridy = 5;
		getContentPane().add(btnNewButton_3, gbc_btnNewButton_3);
		btnNewButton_4.setActionCommand("健康システム");
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.gridwidth = 7;
		gbc_btnNewButton_4.gridx = 0;
		gbc_btnNewButton_4.gridy = 6;
		getContentPane().add(btnNewButton_4, gbc_btnNewButton_4);
	}
	
	//ボタンが押された際の挙動
	
	public void actionPerformed(ActionEvent e){
		UnfinishedSubject unfinishedPanel = new UnfinishedSubject();
		
		String cmd = e.getActionCommand();//ボタンに設定した内部値を取得
		
		
		if(cmd.equals("move_unfinished")) {
			System.out.println("OK");
			unfinishedPanel.launchUnfinishedSubjectPanel();
			
		}else if(cmd.equals("LACS")) {
			
			try {
				readL();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
		}else if(cmd.equals("NUWebシステム")) {
			
			try {
				readNW();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
		}else if(cmd.equals("長大ホーム")) {
			
			try {
				readNH();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
		}else if(cmd.equals("健康システム")) {
			
			try {
				readK();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
		}
		
	}
	
	public static void readL() throws Exception,IOException, URISyntaxException, AWTException {

	// 

		Desktop.getDesktop().browse(new URL("https://lacs.nagasaki-u.ac.jp/").toURI());

		Robot robot = new Robot();

		robot.delay(10000);


		robot.keyRelease(KeyEvent.VK_F11);
	
		robot.delay(2000);

	
	}
	
	public static void readNH() throws Exception,IOException, URISyntaxException, AWTException {

		Desktop.getDesktop().browse(new URL("https://www.nagasaki-u.ac.jp/").toURI());
	
		Robot robot = new Robot();
	
		robot.delay(10000);
	
	
		robot.keyRelease(KeyEvent.VK_F11);
		robot.delay(2000);
	
	}
	
	public static void readNW() throws Exception,IOException, URISyntaxException, AWTException {
	
		Desktop.getDesktop().browse(new URL("https://nucas.nagasaki-u.ac.jp/auth/realms/master/protocol/cas/login?service=https://nuweb.nagasaki-u.ac.jp/campusweb/ssologin.do").toURI());
	
		Robot robot = new Robot();
	
		robot.delay(10000);
	
	
		robot.keyRelease(KeyEvent.VK_F11);
		robot.delay(2000);
	
	}
	
	public static void readK() throws Exception,IOException, URISyntaxException, AWTException {

		Desktop.getDesktop().browse(new URL("https://hms.hc.nagasaki-u.ac.jp/").toURI());
	
		Robot robot = new Robot();
	
		robot.delay(10000);
	
	
		robot.keyRelease(KeyEvent.VK_F11);
		robot.delay(2000);
	}

}
