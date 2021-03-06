package Interface;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;

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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Customer extends JInternalFrame {
	private JTextField textcid;
	private JTextField textcname;
	private JTextField textcmobile;
	private JTextField textsid;
	private JTextField textpaid;
	private JTextField textqty;
	private JTable tablecustomer;
	private JTextField cidsearch;
	private JTextField cnamesearch;
	private JTextField sidsearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer frame = new Customer();
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
	String name;
	String mobile;
	String sellid;
	String itemid;
	String qty;
	String paid;
	Connection con;
	private JTextField textiid;
	
	public Customer() {
		
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
		panel_1.setBounds(20, 20, 432, 431);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Customer ID");
		lblNewLabel.setFont(new Font("Lato Black", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 10, 160, 50);
		panel_1.add(lblNewLabel);
		
		JLabel lblItemName = new JLabel("Name");
		lblItemName.setFont(new Font("Lato Black", Font.BOLD, 20));
		lblItemName.setBounds(10, 60, 182, 50);
		panel_1.add(lblItemName);
		
		JLabel lblItemCategory = new JLabel("Mobile");
		lblItemCategory.setFont(new Font("Lato Black", Font.BOLD, 20));
		lblItemCategory.setBounds(10, 110, 160, 50);
		panel_1.add(lblItemCategory);
		
		JLabel lblSize = new JLabel("Sell ID");
		lblSize.setFont(new Font("Lato Black", Font.BOLD, 20));
		lblSize.setBounds(10, 160, 160, 50);
		panel_1.add(lblSize);
		
		JLabel lblQuantity = new JLabel("Amount Paid");
		lblQuantity.setFont(new Font("Lato Black", Font.BOLD, 20));
		lblQuantity.setBounds(10, 296, 160, 50);
		panel_1.add(lblQuantity);
		
		JLabel lblSupplierId = new JLabel("NO Of Items");
		lblSupplierId.setFont(new Font("Lato Black", Font.BOLD, 20));
		lblSupplierId.setBounds(10, 250, 222, 50);
		panel_1.add(lblSupplierId);
		
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 153, 0));
		panel_4.setBounds(10, 370, 170, 50);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblUpdate = new JLabel("Update");
		lblUpdate.setBounds(50, 0, 120, 50);
		panel_4.add(lblUpdate);
		lblUpdate.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdate.setFont(new Font("Lato Black", Font.BOLD, 20));
		
		JLabel label_4 = new JLabel("");
		Image img4 = new ImageIcon(this.getClass().getResource("/updates.png")).getImage();
		label_4.setIcon(new ImageIcon(img4));
		label_4.setBounds(0, 0, 50, 50);
		panel_4.add(label_4);

		
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(new Color(255, 153, 0));
		panel_5.setBounds(252, 370, 170, 50);
		panel_1.add(panel_5);
		
		JLabel label_1 = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("/delete.png")).getImage();
		label_1.setIcon(new ImageIcon(img1));
		label_1.setBounds(0, 0, 50, 50);
		panel_5.add(label_1);
		
		
		JLabel lblNewLabel_2 = new JLabel("Delete");
		lblNewLabel_2.setBounds(50, 0, 120, 50);
		panel_5.add(lblNewLabel_2);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Lato Black", Font.BOLD, 20));
		
	
		textcid = new JTextField();
		textcid.setEditable(false);
		textcid.setFont(new Font("Lato", Font.BOLD, 15));
		textcid.setBackground(SystemColor.controlHighlight);
		textcid.setBounds(200, 10, 222, 40);
		panel_1.add(textcid);
		textcid.setColumns(10);
		
		textcname = new JTextField();
		textcname.setFont(new Font("Lato", Font.BOLD, 15));
		textcname.setColumns(10);
		textcname.setBackground(SystemColor.controlHighlight);
		textcname.setBounds(202, 60, 222, 40);
		panel_1.add(textcname);
		
		textcmobile = new JTextField();
		textcmobile.setFont(new Font("Lato", Font.BOLD, 15));
		textcmobile.setColumns(10);
		textcmobile.setBackground(SystemColor.controlHighlight);
		textcmobile.setBounds(200, 110, 222, 40);
		panel_1.add(textcmobile);
		
		textsid = new JTextField();
		textsid.setEditable(false);
		textsid.setFont(new Font("Lato", Font.BOLD, 15));
		textsid.setColumns(10);
		textsid.setBackground(SystemColor.controlHighlight);
		textsid.setBounds(200, 160, 222, 40);
		panel_1.add(textsid);
		
		textpaid = new JTextField();
		textpaid.setEditable(false);
		textpaid.setFont(new Font("Lato", Font.BOLD, 15));
		textpaid.setColumns(10);
		textpaid.setBackground(SystemColor.controlHighlight);
		textpaid.setBounds(200, 304, 222, 40);
		panel_1.add(textpaid);
		
		textqty = new JTextField();
		textqty.setEditable(false);
		textqty.setFont(new Font("Lato", Font.BOLD, 15));
		textqty.setColumns(10);
		textqty.setBackground(SystemColor.controlHighlight);
		textqty.setBounds(200, 256, 222, 40);
		panel_1.add(textqty);
		
		JLabel lblItemId = new JLabel("Item ID");
		lblItemId.setFont(new Font("Lato Black", Font.BOLD, 20));
		lblItemId.setBounds(10, 206, 222, 50);
		panel_1.add(lblItemId);
		
		textiid = new JTextField();
		textiid.setFont(new Font("Lato", Font.BOLD, 15));
		textiid.setEditable(false);
		textiid.setColumns(10);
		textiid.setBackground(SystemColor.controlHighlight);
		textiid.setBounds(200, 206, 222, 40);
		panel_1.add(textiid);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new CompoundBorder());
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(473, 20, 432, 431);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Srarch By Customer ID");
		lblNewLabel_1.setFont(new Font("Lato Black", Font.BOLD, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(94, 11, 238, 50);
		panel_2.add(lblNewLabel_1);
		
		cidsearch = new JTextField();
		cidsearch.setFont(new Font("Lato", Font.BOLD, 15));
		cidsearch.setBackground(SystemColor.controlHighlight);
		cidsearch.setBounds(29, 58, 372, 40);
		panel_2.add(cidsearch);
		cidsearch.setColumns(10);
		
		JLabel lblSrarchByCustomer = new JLabel("Srarch By Customer Name");
		lblSrarchByCustomer.setHorizontalAlignment(SwingConstants.CENTER);
		lblSrarchByCustomer.setFont(new Font("Lato Black", Font.BOLD, 20));
		lblSrarchByCustomer.setBounds(77, 120, 280, 50);
		panel_2.add(lblSrarchByCustomer);
		
		JLabel lblSrarchBySell = new JLabel("Srarch By Sell ID");
		lblSrarchBySell.setHorizontalAlignment(SwingConstants.CENTER);
		lblSrarchBySell.setFont(new Font("Lato Black", Font.BOLD, 20));
		lblSrarchBySell.setBounds(94, 235, 238, 50);
		panel_2.add(lblSrarchBySell);
		
		cnamesearch = new JTextField();
		cnamesearch.setFont(new Font("Lato", Font.BOLD, 15));
		cnamesearch.setColumns(10);
		cnamesearch.setBackground(SystemColor.controlHighlight);
		cnamesearch.setBounds(29, 167, 372, 40);
		panel_2.add(cnamesearch);
		
		sidsearch = new JTextField();
		sidsearch.setFont(new Font("Lato", Font.BOLD, 15));
		sidsearch.setColumns(10);
		sidsearch.setBackground(SystemColor.controlHighlight);
		sidsearch.setBounds(29, 281, 372, 40);
		panel_2.add(sidsearch);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(255, 153, 0));
		panel_3.setBounds(129, 370, 170, 50);
		panel_2.add(panel_3);
		
		JLabel label = new JLabel("");
		Image img11 = new ImageIcon(this.getClass().getResource("/clear.png")).getImage();
		label.setIcon(new ImageIcon(img11));
		label.setBounds(0, 0, 50, 50);
		panel_3.add(label);
		
		JLabel lblClear = new JLabel("Clear");
		lblClear.setHorizontalAlignment(SwingConstants.CENTER);
		lblClear.setFont(new Font("Lato Black", Font.BOLD, 20));
		lblClear.setBounds(50, 0, 120, 50);
		panel_3.add(lblClear);
		
		tablecustomer = new JTable();
		tablecustomer.setBounds(20, 470, 885, 269);
		panel.add(tablecustomer);
		
		this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
		BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
		bi.setNorthPane(null);
		
		
		tablecustomer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				String id;
				DefaultTableModel tmodel = (DefaultTableModel) tablecustomer.getModel();
				int selectrowindex = tablecustomer.getSelectedRow();
				id = (tmodel.getValueAt(selectrowindex, 0).toString());
				
				try {
					String sql = "SELECT `customer_id`, `customer_name`, `mobile`, `sell_id`, `item_id`, `no_of_items`, `amount_paid` FROM `customer` WHERE customer_id = '"+id+"'";
					pst = (PreparedStatement)con.prepareStatement(sql);
					rs = pst.executeQuery();
					if(rs.next()) {
						textcid.setText(rs.getString("customer_id"));
						textcname.setText(rs.getString("customer_name"));
						textcmobile.setText(rs.getString("mobile"));
						textsid.setText(rs.getString("sell_id"));
						textiid.setText(rs.getString("item_id"));
						textqty.setText(rs.getString("no_of_items"));
						textpaid.setText(rs.getString("amount_paid"));
						
					}
				}catch (Exception e) {
					JOptionPane.showMessageDialog(rootPane, e);
				}
				
			}
		});
		
		lblUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					
					loadData();
					
					String squpdate = "UPDATE `customer` SET `customer_name`=?,`mobile`=? WHERE customer_id = '"+textcid.getText()+"'";
					pst = (PreparedStatement)con.prepareStatement(squpdate);
					
					pst.setString(1, name);
					pst.setString(2, mobile);
					
					pst.execute();
					
				}catch (Exception e1) {
					JOptionPane.showMessageDialog(rootPane, e1);
				}
				tableload();
			}
			
		});
		
		
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				try {
					
					loadData();
					
					String squpdate = "UPDATE `customer` SET `customer_name`=?,`mobile`=? WHERE customer_id = '"+textcid.getText()+"'";
					pst = (PreparedStatement)con.prepareStatement(squpdate);
					
					pst.setString(1, name);
					pst.setString(2, mobile);
					
					pst.execute();
					
				}catch (Exception e1) {
					JOptionPane.showMessageDialog(rootPane, e1);
				}
				tableload();
				
			}
		});

		
		lblClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				clearData();
			}
		});
		
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				clearData();
			}
		});
		
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					String sql2 = "DELETE FROM `customer` WHERE customer_id = '"+textcid.getText()+"'";
					pst = (PreparedStatement)con.prepareStatement(sql2);
					pst.execute();
	
					clearData();
					tableload();
					
				}catch (Exception e1) {
				}
			}
		});
		
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				try {
					String sql2 = "DELETE FROM `customer` WHERE customer_id = '"+textcid.getText()+"'";
					pst = (PreparedStatement)con.prepareStatement(sql2);
					pst.execute();
	
					clearData();
					tableload();
					
				}catch (Exception e1) {
				}
			}
		});
		
		cidsearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				if(cidsearch.getText().length() > 0 ) {
					try {
						String sql = "SELECT `customer_id`, `customer_name`, `mobile`, `sell_id`, `item_id`, `no_of_items`, `amount_paid` FROM `customer` WHERE customer_id LIKE '%"+cidsearch.getText()+"%'";
								pst = (PreparedStatement)con.prepareStatement(sql);
								rs = pst.executeQuery();
								tablecustomer.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
						
					}catch (Exception e) {
					}
				}
					else {
						tableload();
					}
				
			}
		});
		
		cnamesearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				if(cnamesearch.getText().length() > 0 ) {
					try {
						String sql = "SELECT `customer_id`, `customer_name`, `mobile`, `sell_id`, `item_id`, `no_of_items`, `amount_paid` FROM `customer` WHERE customer_name LIKE '%"+cnamesearch.getText()+"%'";
								pst = (PreparedStatement)con.prepareStatement(sql);
								rs = pst.executeQuery();
								tablecustomer.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
						
					}catch (Exception e) {
					}
				}
					else {
						tableload();
					}
				
			}
		});
		
		sidsearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				if(sidsearch.getText().length() > 0 ) {
					try {
						String sql = "SELECT `customer_id`, `customer_name`, `mobile`, `sell_id`, `item_id`, `no_of_items`, `amount_paid` FROM `customer` WHERE sell_id LIKE '%"+sidsearch.getText()+"%'";
								pst = (PreparedStatement)con.prepareStatement(sql);
								rs = pst.executeQuery();
								tablecustomer.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
						
					}catch (Exception e) {
					}
				}
					else {
						tableload();
					}
				
			}
		});
		
		
		tableload();
	}
	
private void tableload() {
		
		try {
			String sql = "SELECT `customer_id`, `customer_name`, `mobile`, `sell_id`, `item_id`, `no_of_items`, `amount_paid` FROM `customer`";
					pst = (PreparedStatement)con.prepareStatement(sql);
					rs = pst.executeQuery();
					tablecustomer.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
			
		}catch (Exception e) {
		}
	}

//method for get data

private void loadData(){
	
	name = textcname.getText();
	mobile = textcmobile.getText();
	sellid = textsid.getText();
	itemid = textiid.getText();
	qty = textqty.getText();
	paid = textpaid.getText();
	
	}

//method for clear fields 

private void clearData() {
	
	textcid.setText("");
	textcname.setText("");
	textcmobile.setText("");
	textsid.setText("");
	textiid.setText("");
	textqty.setText("");
	textpaid.setText("");
	
	}
}
