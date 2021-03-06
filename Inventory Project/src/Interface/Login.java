package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Login extends JFrame {
	private JTextField textid;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	
	//declaring variables 
	
	int x,y;
	
	PreparedStatement pst = null;
	ResultSet rs = null;
	Connection con;
	
	
	public Login() {
		
		con = DBConnection.connect();
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 550);
		Toolkit toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize();
		setLocation(size.width/2 - getWidth()/2,size.height/2 - getHeight()/2 );
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		
		panel.addMouseMotionListener(new MouseMotionAdapter() {
		
			@Override
		public void mouseDragged(MouseEvent evt) {
				
				int xx = evt.getXOnScreen();
				int yy = evt.getYOnScreen();
				setLocation(xx-x, yy-y);
			}
		});
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent evt) {
				
				x = evt.getX();
				y = evt.getY();
				
			}
		});
	
		panel.setBackground(new Color(0, 0, 51));
		panel.setBounds(0, 0, 450, 50);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int optionDialog = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit","Confirm Exit", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if(optionDialog == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		Image img11 = new ImageIcon(this.getClass().getResource("/close.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img11));
		lblNewLabel.setBounds(400, 0, 50, 50);
		panel.add(lblNewLabel);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 153, 255));
		panel_1.setBounds(0, 50, 450, 500);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(34, 141, 376, 6);
		panel_1.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(34, 262, 376, 6);
		panel_1.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 153, 0));
		panel_4.setBounds(66, 319, 311, 50);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		
		lblLogin.setBounds(0, 0, 311, 50);
		panel_4.add(lblLogin);
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Lato Black", Font.BOLD, 25));
		
		JLabel lblNewLabel_1 = new JLabel("ID Number");
		lblNewLabel_1.setFont(new Font("Lato Black", Font.BOLD, 20));
		lblNewLabel_1.setBounds(34, 57, 196, 29);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblRegister = new JLabel("Password");
		lblRegister.setFont(new Font("Lato Black", Font.BOLD, 20));
		lblRegister.setBounds(34, 179, 196, 29);
		panel_1.add(lblRegister);
		
		textid = new JTextField();
		textid.setFont(new Font("Lato", Font.BOLD, 15));
		textid.setBounds(34, 97, 376, 40);
		panel_1.add(textid);
		textid.setColumns(10);
		
		password = new JPasswordField();
		password.setFont(new Font("Lato", Font.BOLD, 15));
		password.setBounds(34, 219, 376, 40);
		panel_1.add(password);
		
		lblLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				String nid = textid.getText();
				String pwd = String.valueOf(password.getPassword());
				
				try {
					String sql = "SELECT * FROM `register` WHERE `id` = ? AND `password` =? ";
					pst = (PreparedStatement)con.prepareStatement(sql);
					
					pst.setString(1, nid);
					pst.setString(2, pwd);
					
					rs = pst.executeQuery();
					
					if(rs.next()) {
						
						//redirect to home interface
						
							Home ho = new Home();
							ho.setVisible(true);
							dispose();
						}
						else
							JOptionPane.showMessageDialog(rootPane, "Invalid username or password","Login Error",JOptionPane.WARNING_MESSAGE);
				}catch (Exception e) {
					Logger.getLogger(Login.class.getName()).log(Level.SEVERE,null, e);
				}
			}
		});
	}

}
