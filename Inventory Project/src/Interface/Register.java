package Interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Register extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	
	int x, y;
	private JTextField textfname;
	private JTextField textlname;
	private JTextField textmobile;
	private JTextField textemail;
	private JPasswordField password1;
	private JPasswordField password2;
	private JTextField textid;
	
	
	PreparedStatement pst = null;
	ResultSet rs = null;
	String eid;
	String fname;
	String lname;
	String mobile; 
	String occtype;
	String email; 
	String pwd1; 
	String pwd2; 
	
	
	Connection con;
	
	public Register() {
		
		con = DBConnection.connect();
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 668);
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
		
		//close button
		
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int optionDialog = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?","Confirm Exit", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if(optionDialog == JOptionPane.YES_OPTION) {
					Home ho = new Home();
					ho.setVisible(true);
					dispose();
					
				}
				
			}
		});
		Image img11 = new ImageIcon(this.getClass().getResource("/close.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img11));
		lblNewLabel.setBounds(400, 0, 50, 50);
		panel.add(lblNewLabel);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 153, 255));
		panel_1.setBounds(0, 49, 450, 618);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 153, 0));
		panel_4.setBounds(10, 557, 119, 50);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblLogin = new JLabel("Register");
		lblLogin.setBounds(0, 0, 119, 50);
		panel_4.add(lblLogin);
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Lato Black", Font.BOLD, 25));
		
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setFont(new Font("Lato Black", Font.BOLD, 20));
		lblNewLabel_1.setBounds(10, 83, 196, 29);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblRegister = new JLabel("Mobile");
		lblRegister.setFont(new Font("Lato Black", Font.BOLD, 20));
		lblRegister.setBounds(10, 160, 196, 29);
		panel_1.add(lblRegister);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Lato Black", Font.BOLD, 20));
		lblLastName.setBounds(244, 83, 196, 29);
		panel_1.add(lblLastName);
		
		textfname = new JTextField();
		textfname.setFont(new Font("Lato", Font.BOLD, 15));
		textfname.setBounds(10, 115, 196, 40);
		panel_1.add(textfname);
		textfname.setColumns(10);
		
		textlname = new JTextField();
		textlname.setFont(new Font("Lato", Font.BOLD, 15));
		textlname.setColumns(10);
		textlname.setBounds(244, 115, 196, 40);
		panel_1.add(textlname);
		
		textmobile = new JTextField();
		textmobile.setFont(new Font("Lato", Font.BOLD, 15));
		textmobile.setColumns(10);
		textmobile.setBounds(10, 187, 430, 40);
		panel_1.add(textmobile);
		
		JLabel lblOccupationType = new JLabel("Occupation Type");
		lblOccupationType.setFont(new Font("Lato Black", Font.BOLD, 20));
		lblOccupationType.setBounds(10, 238, 196, 29);
		panel_1.add(lblOccupationType);
		
		JComboBox combotype = new JComboBox();
		combotype.setFont(new Font("Lato", Font.BOLD, 15));
		combotype.setModel(new DefaultComboBoxModel(new String[] {"Select Option", "Casheir", "Store Keeper", "Managing Director"}));
		combotype.setBackground(Color.WHITE);
		combotype.setBounds(10, 267, 430, 40);
		panel_1.add(combotype);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Lato Black", Font.BOLD, 20));
		lblEmail.setBounds(10, 315, 196, 29);
		panel_1.add(lblEmail);
		
		textemail = new JTextField();
		textemail.setFont(new Font("Lato", Font.BOLD, 15));
		textemail.setColumns(10);
		textemail.setBounds(10, 342, 430, 40);
		panel_1.add(textemail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Lato Black", Font.BOLD, 20));
		lblPassword.setBounds(10, 393, 196, 29);
		panel_1.add(lblPassword);
		
		password1 = new JPasswordField();
		password1.setFont(new Font("Lato", Font.BOLD, 15));
		password1.setBounds(10, 422, 430, 40);
		panel_1.add(password1);
		
		JLabel lblReEnterPassword = new JLabel("Re Enter Password");
		lblReEnterPassword.setFont(new Font("Lato Black", Font.BOLD, 20));
		lblReEnterPassword.setBounds(10, 473, 196, 29);
		panel_1.add(lblReEnterPassword);
		
		password2 = new JPasswordField();
		password2.setFont(new Font("Lato", Font.BOLD, 15));
		password2.setBounds(10, 506, 430, 40);
		panel_1.add(password2);
		
		textid = new JTextField();
		textid.setFont(new Font("Lato", Font.BOLD, 15));
		textid.setColumns(10);
		textid.setBounds(10, 41, 430, 40);
		panel_1.add(textid);
		
		JLabel lblNationalIdNumber = new JLabel("National ID Number");
		lblNationalIdNumber.setFont(new Font("Lato Black", Font.BOLD, 20));
		lblNationalIdNumber.setBounds(10, 11, 221, 29);
		panel_1.add(lblNationalIdNumber);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(255, 153, 0));
		panel_2.setBounds(165, 557, 119, 50);
		panel_1.add(panel_2);
		
		JLabel lblUpdate = new JLabel("Update");
		lblUpdate.setBounds(0, 0, 119, 50);
		panel_2.add(lblUpdate);
		lblUpdate.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdate.setFont(new Font("Lato Black", Font.BOLD, 25));
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(255, 153, 0));
		panel_3.setBounds(321, 557, 119, 50);
		panel_1.add(panel_3);
		
		JLabel lblDelete = new JLabel("Delete");
		lblDelete.setHorizontalAlignment(SwingConstants.CENTER);
		lblDelete.setFont(new Font("Lato Black", Font.BOLD, 25));
		lblDelete.setBounds(0, 0, 119, 50);
		panel_3.add(lblDelete);
		

		lblLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				getData();
				
				occtype = combotype.getSelectedItem().toString();
				pwd1 = String.valueOf(password1.getPassword());
				pwd2 = String.valueOf(password2.getPassword());
				
				if(!pwd1.equals(pwd2)) {
					
					password2.setText("");
					JOptionPane.showMessageDialog(rootPane, "password did't match");
				}
				else {
					
				try {
					String q = "INSERT INTO `register`(`id`, `f_name`, `l_name`, `mobile`, `occu_type`, `email`, `password`) VALUES (?,?,?,?,?,?,?)";
					pst = (PreparedStatement)con.prepareStatement(q);
					
					pst.setString(1, eid);
					pst.setString(2, fname);
					pst.setString(3, lname);
					pst.setString(4, mobile);
					pst.setString(5, occtype);
					pst.setString(6, email);
					pst.setString(7, pwd1);
					pst.execute();
					
					combotype.setSelectedIndex(0);
					clearData();
					JOptionPane.showMessageDialog(rootPane, "New user added");
					Home ho = new Home();
					ho.setVisible(true);
					dispose();
					
					
				} catch (Exception e1) {
					
				}
				}
			}
		});
		
		textid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				if(textid.getText().length() == 10) {
					try {
						String sql = "SELECT `f_name`, `l_name`, `mobile`, `occu_type`, `email`, `password` FROM `register`WHERE id = '"+textid.getText()+"'";
						pst = (PreparedStatement)con.prepareStatement(sql);
						rs = pst.executeQuery();
						if(rs.next()) {

							textfname.setText(rs.getString("f_name"));
							textlname.setText(rs.getString("l_name"));
							textmobile.setText(rs.getString("mobile"));
							combotype.setSelectedItem(rs.getString("occu_type"));
							textemail.setText(rs.getString("email"));
							password1.setText(rs.getString("password"));
							
							
						}
					}catch (Exception e) {
						JOptionPane.showMessageDialog(rootPane, e);
					}	
							}
			}
		});
		
		lblUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				getData();
				occtype = combotype.getSelectedItem().toString();
				pwd1 = String.valueOf(password1.getPassword());
				pwd2 = String.valueOf(password2.getPassword());
				
				if(!pwd1.equals(pwd2)) {
					
					password2.setText("");
					JOptionPane.showMessageDialog(rootPane, "password did't match");
				}
				else {
				try {
					
					String squpdate = "UPDATE `register` SET `f_name`=?,`l_name`=?,`mobile`=?,`occu_type`=?,`email`=?,`password`=? WHERE id = '"+textid.getText()+"'";
					pst = (PreparedStatement)con.prepareStatement(squpdate);
					
					pst.setString(1, fname);
					pst.setString(2, lname);
					pst.setString(3, mobile);
					pst.setString(4, occtype);
					pst.setString(5, email);
					pst.setString(6, pwd1);
					
					
					pst.execute();
					
				}catch (Exception e1) {
					JOptionPane.showMessageDialog(rootPane, e1);
				}
				
				JOptionPane.showMessageDialog(rootPane, "Contact updated");
				clearData();
				combotype.setSelectedIndex(0);
				Home ho = new Home();
				ho.setVisible(true);
				dispose();
				}
			}
		});
		
		lblDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				try {
					
					String sql = "DELETE FROM `register`WHERE id = '"+textid.getText()+"'";
					pst = (PreparedStatement)con.prepareStatement(sql);
					pst.execute();
					
					JOptionPane.showMessageDialog(rootPane, "Contact deleted");
					clearData();
					combotype.setSelectedIndex(0);
					
					
				}catch (Exception e1) {
				}
				
			}
		});
		
		
	}
	
	//method for get data
	
	private void getData() {
		
		eid = textid.getText();
		fname = textfname.getText();
		lname = textlname.getText();
		mobile = textmobile.getText();
		email = textemail.getText();
		
	}
	
	//method for clear fields
	
	private void clearData() {
		
		textid.setText("");
		textfname.setText("");
		textlname.setText("");
		textmobile.setText("");
		textemail.setText("");
		password1.setText("");
		password2.setText("");
		
	}
	
}