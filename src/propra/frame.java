
package propra;
import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Robot;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class frame  {
	static JFrame frame = new JFrame();
	
	public static void main(String[] args) {  
		
		
		JLabel NameLabel=new JLabel("名前");
	    JLabel Password=new JLabel("暗証番号");
		JLabel bigNameJLabel = new JLabel("登録画面"); 
	    
	    JTextField NameText = new JTextField(10);
		JTextField PassText = new JTextField(10);
		
		JButton to=new JButton("登録");
		JButton sn=new JButton("新規登録");
		
		
	
	   JFrame T = new JFrame("登録");
	   T.setBounds(222,333,333,222);
	   T.setSize(500,400);
	   T.setVisible(true);
	   
	   T.setLayout(null);
	   T.setResizable(false);
	   NameLabel.setBounds(30,120,70,40);
	   Password.setBounds(30,160,70,40);
	   NameText.setBounds(100, 130, 300, 20);
	   PassText.setBounds(100, 170, 300, 20);
	   bigNameJLabel.setBounds(200,0,200,200);
	   T.add(NameLabel);
	   T.add(Password);
	   T.add(NameText);
	   T.add(PassText);
	   T.add(bigNameJLabel);
	   to.setBounds(70, 240, 80, 50);
	   sn.setBounds(320, 240, 100, 50);
	   T.add(to);
	   T.add(sn);
	   to.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (NameText.getText().isEmpty()) {
				
				JOptionPane.showMessageDialog(frame, "ユーザー名を入力してください", null, JOptionPane.WARNING_MESSAGE);
			}
			if (PassText.getText().isEmpty()) {
				
				JOptionPane.showMessageDialog(frame, "パスワードを入力してください", null, JOptionPane.WARNING_MESSAGE);
			}
			
			
			// TODO 自動生成されたメソッド・スタブ
			int a=0;
			int b=0;
			File pass1=new File("password1.txt");
			File user1=new File("user1.txt");
			try {
				save1(user1, NameText);
			} catch (Exception e1) {
				// TODO 自動生成された catch ブロック
				e1.printStackTrace();
			}
			try {
				save1(pass1, PassText);
			} catch (Exception e1) {
				// TODO 自動生成された catch ブロック
				e1.printStackTrace();
			}
			
			File file1 = new File("user.txt");
			File file2 = new File("user1.txt");
			String str1 = getMD5Str(file1);
			String str2 = getMD5Str(file2);
			
			if(str1.equals(str2)) {
				 a=1;
			}
			else {
				 a=0;
			}
			
			
			File file3 = new File("password.txt");
			File file4 = new File("password1.txt");
			String str3 = getMD5Str(file3);
			String str4 = getMD5Str(file4);
			if(str3.equals(str4)) {
				 b=1;
			}
			else 
			{
				 b=0;
				
			}
		
			
			
			if(a==1) {
				if(b==1) {
					LeaderPanel1 leaderPanel = new LeaderPanel1();
					
					leaderPanel.launchLeaderPanel1();
					/*JFrame main=new JFrame("main");
					T.dispose();
					
					
					main.setSize(800,800);
					main.setBounds(222,333,500,500);
					main.setLayout(null);
					main.setVisible(true);
					main.setResizable(false);
					JButton LACS=new JButton("LACS");
					JButton NW = new JButton("NUWebシステム");
					JButton NA = new JButton("長大ホーム");
					JButton KN  =new JButton("健康システム");
					LACS.setBounds(150, 100, 200, 20);
					NW.setBounds(150, 150, 200, 20);
					NA.setBounds(150, 200, 200, 20);
					KN.setBounds(150,250,200,20);
					main.add(LACS);
					main.add(NW);
					main.add(NA);
					main.add(KN);
					
					LACS.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO 自動生成されたメソッド・スタブ
							try {
								readL(args);
							} catch (Exception e1) {
								// TODO 自動生成された catch ブロック
								e1.printStackTrace();
							}
						}
					});
					NW.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO 自動生成されたメソッド・スタブ
							try {
								readNW(args);
							} catch (Exception e1) {
								// TODO 自動生成された catch ブロック
								e1.printStackTrace();
							}
						}
					});
					
					NA.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO 自動生成されたメソッド・スタブ
							try {
								readNH(args);
							} catch (Exception e1) {
								// TODO 自動生成された catch ブロック
								e1.printStackTrace();
							}
						}
					});
					KN.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO 自動生成されたメソッド・スタブ
							try {
								readK(args);
							} catch (Exception e1) {
								// TODO 自動生成された catch ブロック
								e1.printStackTrace();
							}
						}
					});
					
					closeThis();
					*/
					
					
					
				}
				else {
					JOptionPane.showMessageDialog(frame, "パスワードが間違っています", null, JOptionPane.WARNING_MESSAGE);
				}
				
			}else {
				JOptionPane.showMessageDialog(frame, "存在しないユーザー名です", null, JOptionPane.WARNING_MESSAGE);
			}
			
		
			
			
			
		}
	});
	   
	   sn.addActionListener(new ActionListener(){
	       public void actionPerformed(ActionEvent e) {
		   closeThis();
		   JFrame frame = new JFrame("新規登録");
		   frame.setLocation(300,250);
		   frame.setSize(700,500);
		   frame.setVisible(true);
		   JButton ka = new JButton("完了");
		   JButton kya = new JButton("キャンセル");
		   JLabel Newname =new JLabel("ユーザー名");
		   JLabel NewPassword = new JLabel("パスワード");
		   JLabel KPassword = new JLabel("パスワード確認");
		   //JLabel LACSuser = new JLabel("LACS番号");
		   //JLabel LACSpassword = new JLabel("LACSパスワード");
		   JTextField Newuser = new JTextField(10);
		   JTextField Newpass =new JTextField(10);
		   //TextField NewLACSN = new TextField(10);
		   //TextField NewLACSP = new TextField(10);
		   TextField Kpass =new TextField(10);
		   ka.setBounds(450, 300, 80, 50);
		   kya.setBounds(150,300,100,50);
		   Newname.setBounds(80, 80, 80, 20);
		   NewPassword.setBounds(80, 120, 80, 20);
		   KPassword.setBounds(80, 160, 100, 20);
		   //LACSuser.setBounds(80, 200, 80, 20);
		   //LACSpassword.setBounds(80, 240, 100, 20);
		   Newuser.setBounds(200, 80, 300, 20);
		   Newpass.setBounds(200, 120, 300, 20);
		   Kpass.setBounds(200, 160, 300, 20);
		   //NewLACSN.setBounds(200, 200, 300, 20);
		   //NewLACSP.setBounds(200, 240, 300, 20);
		   frame.add(ka);
		   frame.add(kya);
		   frame.add(Newname);
		   frame.add(NewPassword);
		   frame.add(KPassword);
		   
		   frame.add(Newuser);
		   frame.add(Kpass);
		  
		   frame.add(Newpass);
		   frame.setLayout(null);
		   frame.setResizable(false);
		   T.setVisible(false);
		   ka.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自動生成されたメソッド・スタブ
				if (Newuser.getText().isEmpty()) {
					
					JOptionPane.showMessageDialog(frame, "ユーザー名を入力してください", null, JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				 if (Newpass.getText().isEmpty()) {
					JOptionPane.showMessageDialog(frame, "パスワードを入力してください",null,JOptionPane.WARNING_MESSAGE);
					return;
					
				}
				
				if(Kpass.getText().isEmpty()) {
					JOptionPane.showMessageDialog(frame, "パスワードを確認してください",null,JOptionPane.WARNING_MESSAGE);
				}
				String N1=Newpass.getText();
				String N2=Kpass.getText();
				
				 if(N1.equals(N2)) {
					frame.dispose();
					T.setVisible(true);
					File user=new File("user.txt");
					try {
						save( user , Newuser);
					} catch (Exception e1) {
						// TODO 自動生成された catch ブロック
						e1.printStackTrace();
					}
					File password = new File("password.txt");
					try {
						save(password,Newpass);
					} catch (Exception e1) {
						// TODO 自動生成された catch ブロック
						e1.printStackTrace();
					}	
				}
					else {
						JOptionPane.showMessageDialog(frame, "二回のパスワードは一致しない",null,JOptionPane.WARNING_MESSAGE);
						return;
					}
					
					
					
					
					
					
				}
				
		   
				
			
	       
		});
		   
		   
		   
		   
		   kya.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 JFrame kaku = new JFrame();
				 kaku.setLocation(300,250);
				 kaku.setSize(300,300);
				 kaku.setVisible(true);
				 kaku.setResizable(false);
				 kaku.setLayout(null);
				 JLabel yon = new JLabel("新規登録中止？（登録画面へ戻ります）");
				 JButton ha = new JButton("はい");
				 JButton ie = new JButton("いいえ");
				 yon.setBounds(20,20,250,20);
				 ha.setBounds(20, 140, 80, 50);
				 ie.setBounds(180,140,80,50);
				 kaku.add(yon);
				 kaku.add(ha);
				 kaku.add(ie);
				 
				 ha.addActionListener(new ActionListener() {
					 public void actionPerformed(ActionEvent e) {
						 kaku.dispose();
						 frame.dispose();
						 T.setVisible(true);
					 }
					 
				 });
				 
				 ie.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO 自動生成されたメソッド・スタブ
						kaku.dispose();
					}
				});
				 
			 }
			   
		   });
		   
		 
		   
		   }
		   
	   });
	   
	   T.addWindowListener(new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent e) {
		    	System.exit(0);
		    }
		    
		    
       });
	}
	
		public static void closeThis() {
			frame.dispose();      
       
        
        //窗口显示
       
  
    }  
		public static void save(File fileName, JTextField textField) throws Exception {
			FileOutputStream out = new FileOutputStream(fileName, false);
			out.write(textField.getText().getBytes());
			//out.write("\n".getBytes());
			out.close();
			}
		public static void save1(File fileName, JTextField textField) throws Exception {
			FileOutputStream out = new FileOutputStream(fileName, false);
			out.write(textField.getText().getBytes());
			
			out.close();
			}
		
		
		
		public static String getMD5Str(File file) {
			if(!file.isFile()) {
				System.out.println(file.getName()+"不是文件");
				return null;
			}
			InputStream in = null;
			try {
				MessageDigest digest = MessageDigest.getInstance("MD5");
				in = new FileInputStream(file);
				byte[]bs = new byte[1024];
				int len = -1;
				while((len=in.read(bs))!=-1) {
					digest.update(bs,0,len);
				}
				BigInteger bi = new BigInteger(1,digest.digest());
				return bi.toString(16);
			} catch (NoSuchAlgorithmException e) {
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return null;
		}
		public static void readL(String[] args) throws Exception,

		IOException, URISyntaxException, AWTException {

		// 

		Desktop.getDesktop().browse(new URL("https://lacs.nagasaki-u.ac.jp/").toURI());

		Robot robot = new Robot();

		robot.delay(10000);


		robot.keyRelease(KeyEvent.VK_F11);

		robot.delay(2000);

		
		}
		public static void readNH(String[] args) throws Exception,

		IOException, URISyntaxException, AWTException {

		Desktop.getDesktop().browse(new URL("https://www.nagasaki-u.ac.jp/").toURI());

		Robot robot = new Robot();

		robot.delay(10000);

	
		robot.keyRelease(KeyEvent.VK_F11);
		robot.delay(2000);
		
		}
		public static void readNW(String[] args) throws Exception,

		IOException, URISyntaxException, AWTException {

		Desktop.getDesktop().browse(new URL("https://nucas.nagasaki-u.ac.jp/auth/realms/master/protocol/cas/login?service=https://nuweb.nagasaki-u.ac.jp/campusweb/ssologin.do").toURI());

		Robot robot = new Robot();

		robot.delay(10000);

	
		robot.keyRelease(KeyEvent.VK_F11);
		robot.delay(2000);
		
		}
		public static void readK(String[] args) throws Exception,

		IOException, URISyntaxException, AWTException {

		Desktop.getDesktop().browse(new URL("https://hms.hc.nagasaki-u.ac.jp/").toURI());

		Robot robot = new Robot();

		robot.delay(10000);

	
		robot.keyRelease(KeyEvent.VK_F11);
		robot.delay(2000);
		}
		
	}
		
		
	
  
  



