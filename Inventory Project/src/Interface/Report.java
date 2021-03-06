package Interface;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDateChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Report extends JInternalFrame {
	private JTextField searchcategory;
	private JTable tablesales;
	private JTable tablestock;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Report frame = new Report();
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
	
	PreparedStatement pst = null;
	ResultSet rs = null;
	Connection con;
	private JTextField searchiid;
	
	
	public Report() {
		
		con = DBConnection.connect();
		
		setClosable(true);
		setFocusCycleRoot(false);
		setFocusTraversalPolicyProvider(true);
		setFocusable(false);
		setBounds(0, 0, 925, 779);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 255));
		panel.setBounds(0, 0, 925, 750);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 20, 905, 104);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblItemName = new JLabel("Item ID");
		lblItemName.setFont(new Font("Lato Black", Font.BOLD, 20));
		lblItemName.setBounds(10, 55, 160, 50);
		panel_1.add(lblItemName);
		Image img8 = new ImageIcon(this.getClass().getResource("/updates.png")).getImage();
		
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(new Color(255, 153, 0));
		panel_5.setBounds(725, 42, 170, 50);
		panel_1.add(panel_5);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(0, 0, 50, 50);
		panel_5.add(label_2);
		Image img2 = new ImageIcon(this.getClass().getResource("/clear.png")).getImage();
		label_2.setIcon(new ImageIcon(img2));
		
		JLabel lblClear = new JLabel("Clear");
		lblClear.setBounds(50, 0, 120, 50);
		panel_5.add(lblClear);
		lblClear.setHorizontalAlignment(SwingConstants.CENTER);
		lblClear.setFont(new Font("Lato Black", Font.BOLD, 20));
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(545, 42, 170, 50);
		panel_1.add(panel_6);
		panel_6.setLayout(null);
		panel_6.setBackground(new Color(255, 153, 0));
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(0, 0, 50, 50);
		panel_6.add(label_1);
		Image img1 = new ImageIcon(this.getClass().getResource("/Print.png")).getImage();
		label_1.setIcon(new ImageIcon(img1));
		
		JLabel lblUpdate = new JLabel("Print");
		lblUpdate.setBounds(50, 0, 120, 50);
		panel_6.add(lblUpdate);
		lblUpdate.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdate.setFont(new Font("Lato Black", Font.BOLD, 20));
		
		JLabel lblSales = new JLabel("Sales");
		lblSales.setHorizontalAlignment(SwingConstants.CENTER);
		lblSales.setFont(new Font("Lato Black", Font.BOLD, 23));
		lblSales.setBounds(0, 0, 120, 39);
		panel_1.add(lblSales);
		
		searchiid = new JTextField();
		searchiid.setFont(new Font("Lato", Font.BOLD, 15));
		searchiid.setBounds(118, 65, 210, 39);
		panel_1.add(searchiid);
		searchiid.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new CompoundBorder());
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 409, 905, 86);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblStock = new JLabel("Stock");
		lblStock.setHorizontalAlignment(SwingConstants.CENTER);
		lblStock.setFont(new Font("Lato Black", Font.BOLD, 23));
		lblStock.setBounds(0, 0, 120, 39);
		panel_2.add(lblStock);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setHorizontalAlignment(SwingConstants.CENTER);
		lblCategory.setFont(new Font("Lato Black", Font.BOLD, 20));
		lblCategory.setBounds(10, 48, 108, 39);
		panel_2.add(lblCategory);
		
		searchcategory = new JTextField();
		searchcategory.setFont(new Font("Lato", Font.BOLD, 15));
		searchcategory.setBounds(128, 53, 225, 33);
		panel_2.add(searchcategory);
		searchcategory.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(543, 21, 170, 50);
		panel_2.add(panel_7);
		panel_7.setLayout(null);
		panel_7.setBackground(new Color(255, 153, 0));
		
		JLabel label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/Print.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(0, 0, 50, 50);
		panel_7.add(label);
		
		JLabel lblPrint = new JLabel("Print");
		lblPrint.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrint.setFont(new Font("Lato Black", Font.BOLD, 20));
		lblPrint.setBounds(50, 0, 120, 50);
		panel_7.add(lblPrint);
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBackground(new Color(255, 153, 0));
		panel_8.setBounds(723, 21, 170, 50);
		panel_2.add(panel_8);
		
		JLabel label_6 = new JLabel("Clear");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("Lato Black", Font.BOLD, 20));
		label_6.setBounds(50, 0, 120, 50);
		panel_8.add(label_6);
		
		JLabel label_7 = new JLabel("");
		Image img7 = new ImageIcon(this.getClass().getResource("/clear.png")).getImage();
		label_7.setIcon(new ImageIcon(img7));
		label_7.setBounds(0, 0, 50, 50);
		panel_8.add(label_7);
		Image img12 = new ImageIcon(this.getClass().getResource("/updates.png")).getImage();
		
		
		tablesales = new JTable();
		tablesales.setBounds(10, 135, 905, 242);
		panel.add(tablesales);
		
		tablestock = new JTable();
		tablestock.setBounds(10, 506, 905, 233);
		panel.add(tablestock);
		
		
		this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
		BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
		bi.setNorthPane(null);
		
		searchiid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				if(searchiid.getText().length() > 0) {
					try {
						String sql = "SELECT `item_id`, `item_name`, `category`, `size`, `quantity`, `tot_price`, `item_discount`, `payble`, `cash`, `balance`, `customer_id`, `sell_id`, `date` FROM `sale` WHERE item_id LIKE '%"+searchiid.getText()+"%'";
								pst = (PreparedStatement)con.prepareStatement(sql);
								rs = pst.executeQuery();
								tablesales.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
						
					}catch (Exception e) {
						
					}
				}
					else {
						saletableload();
					}
			}
		});
		
		lblUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				try {
					tablesales.print();
					} catch (Exception e) {
					}
			}
		});
		
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				try {
					tablesales.print();
					} catch (Exception e) {
					}
			}
		});
		
		lblClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				searchiid.setText("");
				saletableload();
			}
		});
		
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				searchiid.setText("");
				saletableload();
			}
		});
		
		
		searchcategory.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				String category = searchcategory.getText();
				
				if(category.length() > 0) {
					try {
						String sql = "SELECT `item_id`, `item_name`, `category`, `size`, `qty`, `supplier_id`, `buy_price`, `sell_price` FROM `stock` WHERE category Like '%"+category+"%'";
								pst = (PreparedStatement)con.prepareStatement(sql);
								rs = pst.executeQuery();
								tablestock.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
						
					}catch (Exception e) {
						
					}
				}
					else {
						stocktableload();
					}
			}
		});
		
		lblPrint.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				try {
					tablestock.print();
					} catch (Exception e) {
					}
			}
		});
		
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				try {
					tablestock.print();
					} catch (Exception e) {
					}
			}
		});
		

		label_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				searchcategory.setText("");
				stocktableload();
			}
		});
		
		label_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				searchcategory.setText("");
				stocktableload();
			}
		});
		
		
		saletableload();
		stocktableload();
		
	}
	
	//method for load sale table 
	
private void saletableload() {
		
		try {
			String sql = "SELECT `item_id`, `item_name`, `category`, `size`, `quantity`, `tot_price`, `item_discount`, `payble`, `cash`, `balance`, `customer_id`, `sell_id`, `date` FROM `sale`";
					pst = (PreparedStatement)con.prepareStatement(sql);
					rs = pst.executeQuery();
					tablesales.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
			
		}catch (Exception e) {
		}
	}

//method for load stock table 
	
private void stocktableload() {
		
		try {
			String sql = "SELECT `item_id`, `item_name`, `category`, `size`, `qty`, `supplier_id`, `buy_price`, `sell_price` FROM `stock`";
					pst = (PreparedStatement)con.prepareStatement(sql);
					rs = pst.executeQuery();
					tablestock.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
			
		}catch (Exception e) {
		}
	}
}
