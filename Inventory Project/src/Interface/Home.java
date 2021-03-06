package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import javax.swing.JDesktopPane;
import java.awt.event.MouseMotionAdapter;

public class Home extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	Connection con;
	
	
	public Home() {
		
		con = DBConnection.connect();
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		Toolkit toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize();
		setLocation(size.width/2 - getWidth()/2,size.height/2 - getHeight()/2 );
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 51));
		panel.setForeground(new Color(0, 51, 51));
		panel.setBounds(0, 0, 1200, 50);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 51));
		panel_2.setBounds(1150, 0, 50, 50);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		//Close button
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int optionDialog = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?","Confirm Exit", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if(optionDialog == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
				
			}
		});
		Image img11 = new ImageIcon(this.getClass().getResource("/close.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img11));
	
		lblNewLabel_1.setBounds(0, 0, 50, 50);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Inventory Management System");
		
		//Interface movement
		
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent evt) {
				
				x = evt.getX();
				y = evt.getY();
				
			}
		});
		lblNewLabel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent evt) {
				
				int xx = evt.getXOnScreen();
				int yy = evt.getYOnScreen();
				setLocation(xx-x, yy-y);
			}
		});
		lblNewLabel.setFont(new Font("Lato Black", Font.BOLD, 30));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(0, 0, 1150, 50);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 51));
		panel_1.setBounds(0, 50, 275, 750);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 0, 275, 100);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel label_14 = new JLabel("");
		Image img14 = new ImageIcon(this.getClass().getResource("/Logo.png")).getImage();
		label_14.setIcon(new ImageIcon(img14));
		label_14.setBounds(0, 0, 275, 100);
		panel_3.add(label_14);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 153, 0));
		panel_4.setBounds(0, 136, 275, 50);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBounds(0, 0, 50, 50);
		panel_12.setBackground(new Color(255, 153, 0));
		panel_4.add(panel_12);
		panel_12.setLayout(null);
		
		JLabel label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/Home.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(0, 0, 50, 50);
		panel_12.add(label);
		
		JLabel lblHome = new JLabel("    Home");
		lblHome.setFont(new Font("Lato Black", Font.BOLD, 20));
		lblHome.setBounds(50, 0, 225, 50);
		panel_4.add(lblHome);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 153, 0));
		panel_5.setBounds(0, 208, 275, 50);
		panel_1.add(panel_5);
		panel_5.setLayout(null);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBounds(0, 0, 50, 50);
		panel_13.setBackground(new Color(255, 153, 0));
		panel_5.add(panel_13);
		panel_13.setLayout(null);
		
		JLabel label_1 = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("/Add item.png")).getImage();
		label_1.setIcon(new ImageIcon(img1));
		label_1.setBounds(0, 0, 50, 50);
		panel_13.add(label_1);
		
		JLabel lblAddItem = new JLabel("    Add Item");
		
		lblAddItem.setFont(new Font("Lato Black", Font.BOLD, 20));
		lblAddItem.setBounds(50, 0, 225, 50);
		panel_5.add(lblAddItem);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 153, 0));
		panel_6.setBounds(0, 280, 275, 50);
		panel_1.add(panel_6);
		panel_6.setLayout(null);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBounds(0, 0, 50, 50);
		panel_14.setBackground(new Color(255, 153, 0));
		panel_6.add(panel_14);
		panel_14.setLayout(null);
		
		JLabel label_2 = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("/sell.png")).getImage();
		label_2.setIcon(new ImageIcon(img2));
		label_2.setBounds(0, 0, 50, 50);
		panel_14.add(label_2);
		
		JLabel lblSell = new JLabel("    Sell");
		lblSell.setFont(new Font("Lato Black", Font.BOLD, 20));
		lblSell.setBounds(50, 0, 225, 50);
		panel_6.add(lblSell);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(255, 153, 0));
		panel_7.setBounds(0, 351, 275, 50);
		panel_1.add(panel_7);
		panel_7.setLayout(null);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBounds(0, 0, 50, 50);
		panel_15.setBackground(new Color(255, 153, 0));
		panel_7.add(panel_15);
		panel_15.setLayout(null);
		
		JLabel label_3 = new JLabel("");
		Image img3 = new ImageIcon(this.getClass().getResource("/Stock.png")).getImage();
		label_3.setIcon(new ImageIcon(img3));
		label_3.setBounds(0, 0, 50, 50);
		panel_15.add(label_3);
		
		JLabel lblStock = new JLabel("    Stock");
		lblStock.setFont(new Font("Lato Black", Font.BOLD, 20));
		lblStock.setBounds(50, 0, 225, 50);
		panel_7.add(lblStock);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(255, 153, 0));
		panel_8.setBounds(0, 423, 275, 50);
		panel_1.add(panel_8);
		panel_8.setLayout(null);
		
		JPanel panel_16 = new JPanel();
		panel_16.setBounds(0, 0, 50, 50);
		panel_16.setBackground(new Color(255, 153, 0));
		panel_8.add(panel_16);
		panel_16.setLayout(null);
		
		JLabel label_4 = new JLabel("");
		Image img4 = new ImageIcon(this.getClass().getResource("/Customer-512.png")).getImage();
		label_4.setIcon(new ImageIcon(img4));
		label_4.setBounds(0, 0, 50, 50);
		panel_16.add(label_4);
		
		JLabel lblCustomers = new JLabel("    Customers");
		lblCustomers.setFont(new Font("Lato Black", Font.BOLD, 20));
		lblCustomers.setBounds(50, 0, 225, 50);
		panel_8.add(lblCustomers);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(255, 153, 0));
		panel_9.setBounds(0, 495, 275, 50);
		panel_1.add(panel_9);
		panel_9.setLayout(null);
		
		JPanel panel_17 = new JPanel();
		panel_17.setBounds(0, 0, 50, 50);
		panel_17.setBackground(new Color(255, 153, 0));
		panel_9.add(panel_17);
		panel_17.setLayout(null);
		
		JLabel label_5 = new JLabel("");
		Image img5 = new ImageIcon(this.getClass().getResource("/report.png")).getImage();
		label_5.setIcon(new ImageIcon(img5));
		label_5.setBounds(0, 0, 50, 50);
		panel_17.add(label_5);
		
		JLabel lblReport = new JLabel("    Report");
		lblReport.setFont(new Font("Lato Black", Font.BOLD, 20));
		lblReport.setBounds(50, 0, 225, 50);
		panel_9.add(lblReport);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(255, 153, 0));
		panel_10.setBounds(0, 567, 275, 50);
		panel_1.add(panel_10);
		panel_10.setLayout(null);
		
		JPanel panel_18 = new JPanel();
		panel_18.setBounds(0, 0, 50, 50);
		panel_18.setBackground(new Color(255, 153, 0));
		panel_10.add(panel_18);
		panel_18.setLayout(null);
		
		JLabel label_6 = new JLabel("");
		Image img6 = new ImageIcon(this.getClass().getResource("/Registeration Icon.png")).getImage();
		label_6.setIcon(new ImageIcon(img6));
		label_6.setBounds(0, 0, 50, 50);
		panel_18.add(label_6);
		
		JLabel lblRegister = new JLabel("    Register");
		lblRegister.setFont(new Font("Lato Black", Font.BOLD, 20));
		lblRegister.setBounds(50, 0, 225, 50);
		panel_10.add(lblRegister);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(Color.YELLOW);
		panel_11.setBounds(0, 675, 275, 75);
		panel_1.add(panel_11);
		panel_11.setLayout(null);
		
		JLabel lblDesignBy = new JLabel("Design By - ");
		lblDesignBy.setBounds(0, 0, 275, 25);
		panel_11.add(lblDesignBy);
		
		JLabel lblNewLabel_2 = new JLabel("for Shoes Arena Store");
		lblNewLabel_2.setBounds(0, 50, 275, 25);
		panel_11.add(lblNewLabel_2);
		
		JLabel lblDsihgfbuidfsgosdg = new JLabel("Samuditha | Manith | Achini | Vishmi");
		lblDsihgfbuidfsgosdg.setBounds(0, 25, 275, 25);
		panel_11.add(lblDsihgfbuidfsgosdg);
		
		JDesktopPane homeDesktop = new JDesktopPane();
		homeDesktop.setBackground(Color.WHITE);
		homeDesktop.setBounds(275, 50, 925, 750);
		getContentPane().add(homeDesktop);
		homeDesktop.setLayout(null);
		
		homeDesktop.removeAll();
		Main ma = new Main();
		homeDesktop.add(ma).setVisible(true);
		
		//Button for main interface
		
		lblHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				homeDesktop.removeAll();
				Main ma = new Main();
				homeDesktop.add(ma).setVisible(true);
			}
		});
		
		// icon main
		
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				homeDesktop.removeAll();
				Main ma = new Main();
				homeDesktop.add(ma).setVisible(true);
			}
		});
		
		//Button for add item interface
		
		lblAddItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				homeDesktop.removeAll();
				AddItem ad = new AddItem();
				homeDesktop.add(ad).setVisible(true);
				
				
			}
		});
		
		// icon add item
		
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				homeDesktop.removeAll();
				AddItem ad = new AddItem();
				homeDesktop.add(ad).setVisible(true);
				
			}
		});
		
		//Button for sell interface
		
		lblSell.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				homeDesktop.removeAll();
				Sell se = new Sell();
				homeDesktop.add(se).setVisible(true);
			}
		});
		
		// icon sell
		
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				homeDesktop.removeAll();
				Sell se = new Sell();
				homeDesktop.add(se).setVisible(true);
				
			}
		});
		
		//Button for stock interface
		
		lblStock.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				homeDesktop.removeAll();
				Stock st = new Stock();
				homeDesktop.add(st).setVisible(true);
			}
		});
		
		// icon stock
		
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				homeDesktop.removeAll();
				Stock st = new Stock();
				homeDesktop.add(st).setVisible(true);
			}
		});
		
		//Button for customer interface
		
		lblCustomers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				homeDesktop.removeAll();
				Customer cu = new Customer();
				homeDesktop.add(cu).setVisible(true);
			}
		});
		
		// icon customer
		
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				homeDesktop.removeAll();
				Customer cu = new Customer();
				homeDesktop.add(cu).setVisible(true);
			}
		});
		
		//Button for report interface
		
		lblReport.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				homeDesktop.removeAll();
				Report re = new Report();
				homeDesktop.add(re).setVisible(true);
			}
		});
		
		// icon report
		
		label_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				homeDesktop.removeAll();
				Report re = new Report();
				homeDesktop.add(re).setVisible(true);
			}
		});
		
		//Button for register interface
		
		lblRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				Register re = new Register();
				re.setVisible(true);
				dispose();
				
			}
		});
		
		// icon register
		
		label_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				Register re = new Register();
				re.setVisible(true);
				dispose();
				
			}
		});
		
	}
}
