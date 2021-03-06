package Interface;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

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
import javax.swing.JTextPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Sell extends JInternalFrame {
	private JTextField textiid;
	private JTextField textiname;
	private JTextField textField_2;
	private JTextField textsellPrice;
	private JTextField textItemDiscount;
	private JTextField textpayble;
	private JTextField textcash;
	private JTextField textbalance;
	private JTextField textcustomerID;
	private JTextField textsellID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sell frame = new Sell();
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
	String iid;
	String iname;
	String category;
	String size;
	String quantity;
	String tot;
	String discount;
	String payble;
	String cash;
	String balance;
	String cusid;
	String selid;
	String date;
	Connection con;
	
	private ImageIcon format = null;
	String fname = null;
	int s = 0;
	byte[] pimage = null;
	
	public Sell() {
		
		con = DBConnection.connect();
		autoID();
		
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
		panel_1.setBounds(20, 20, 480, 719);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Item ID");
		lblNewLabel.setFont(new Font("Lato Black", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 10, 160, 50);
		panel_1.add(lblNewLabel);
		
		JLabel lblItemName = new JLabel("Item Name");
		lblItemName.setFont(new Font("Lato Black", Font.BOLD, 20));
		lblItemName.setBounds(10, 60, 160, 50);
		panel_1.add(lblItemName);
		
		JLabel lblItemCategory = new JLabel("Category");
		lblItemCategory.setFont(new Font("Lato Black", Font.BOLD, 20));
		lblItemCategory.setBounds(10, 110, 160, 50);
		panel_1.add(lblItemCategory);
		
		JLabel lblsize = new JLabel("Size");
		lblsize.setFont(new Font("Lato Black", Font.BOLD, 20));
		lblsize.setBounds(10, 160, 160, 50);
		panel_1.add(lblsize);
		
		JLabel lblQuantity = new JLabel("No Of Items");
		lblQuantity.setFont(new Font("Lato Black", Font.BOLD, 20));
		lblQuantity.setBounds(10, 210, 201, 50);
		panel_1.add(lblQuantity);
		
		JLabel lblSupplierId = new JLabel("Total Price");
		lblSupplierId.setFont(new Font("Lato Black", Font.BOLD, 20));
		lblSupplierId.setBounds(10, 260, 201, 50);
		panel_1.add(lblSupplierId);
		
		JLabel lblBuyingPrice = new JLabel("Discount(%)");
		lblBuyingPrice.setFont(new Font("Lato Black", Font.BOLD, 20));
		lblBuyingPrice.setBounds(10, 310, 160, 50);
		panel_1.add(lblBuyingPrice);
		
		JLabel lblSellingPrice = new JLabel("Payble");
		lblSellingPrice.setFont(new Font("Lato Black", Font.BOLD, 20));
		lblSellingPrice.setBounds(10, 360, 160, 50);
		panel_1.add(lblSellingPrice);
		
		JComboBox combocategory = new JComboBox();
		combocategory.setFont(new Font("Lato", Font.BOLD, 15));
		combocategory.setModel(new DefaultComboBoxModel(new String[] {"Select Category", "Women's Boots", "Women's Flats", "Women's Sandles", "Women's Slippers", "Men's Boots", "Men's Casual Shoes", "Men's Formal Shoes", "Men's Slippers"}));
		combocategory.setBounds(230, 110, 240, 40);
		panel_1.add(combocategory);
		
		
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 153, 0));
		panel_4.setBounds(10, 650, 146, 50);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(0, 0, 50, 50);
		panel_4.add(label_1);
		Image img1 = new ImageIcon(this.getClass().getResource("/Sell (2).png")).getImage();
		label_1.setIcon(new ImageIcon(img1));
		
		JLabel lblNewLabel_2 = new JLabel("Sell");
		lblNewLabel_2.setBounds(48, 0, 98, 50);
		panel_4.add(lblNewLabel_2);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Lato Black", Font.BOLD, 20));
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(new Color(255, 153, 0));
		panel_5.setBounds(166, 650, 146, 50);
		panel_1.add(panel_5);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(0, 0, 50, 50);
		panel_5.add(label_4);
		Image img4 = new ImageIcon(this.getClass().getResource("/Print.png")).getImage();
		label_4.setIcon(new ImageIcon(img4));
		
		JLabel lblUpdate = new JLabel("Print");
		lblUpdate.setBounds(47, 0, 99, 50);
		panel_5.add(lblUpdate);
		lblUpdate.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdate.setFont(new Font("Lato Black", Font.BOLD, 20));
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(322, 650, 148, 50);
		panel_1.add(panel_7);
		panel_7.setLayout(null);
		panel_7.setBackground(new Color(255, 153, 0));
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(0, 0, 50, 50);
		panel_7.add(label_2);
		Image img2 = new ImageIcon(this.getClass().getResource("/clear.png")).getImage();
		label_2.setIcon(new ImageIcon(img2));
		
		JLabel lblClear = new JLabel("Clear");
		lblClear.setBounds(60, 0, 88, 50);
		panel_7.add(lblClear);
		lblClear.setHorizontalAlignment(SwingConstants.CENTER);
		lblClear.setFont(new Font("Lato Black", Font.BOLD, 20));
		
		JLabel lblPayble = new JLabel("Cash");
		lblPayble.setFont(new Font("Lato Black", Font.BOLD, 20));
		lblPayble.setBounds(10, 410, 160, 50);
		panel_1.add(lblPayble);
		
		JLabel lblCash = new JLabel("Balance");
		lblCash.setFont(new Font("Lato Black", Font.BOLD, 20));
		lblCash.setBounds(10, 460, 160, 50);
		panel_1.add(lblCash);
		
		JLabel lblBalance = new JLabel("Customer ID");
		lblBalance.setFont(new Font("Lato Black", Font.BOLD, 20));
		lblBalance.setBounds(10, 510, 160, 50);
		panel_1.add(lblBalance);
		
		JLabel lblSellId = new JLabel("Sell ID");
		lblSellId.setBounds(10, 560, 160, 50);
		panel_1.add(lblSellId);
		lblSellId.setFont(new Font("Lato Black", Font.BOLD, 20));
		
		textiid = new JTextField();
		textiid.setFont(new Font("Lato", Font.BOLD, 15));
		textiid.setBackground(SystemColor.controlHighlight);
		textiid.setBounds(230, 10, 240, 40);
		panel_1.add(textiid);
		textiid.setColumns(10);
		
		textiname = new JTextField();
		textiname.setFont(new Font("Lato", Font.BOLD, 15));
		textiname.setColumns(10);
		textiname.setBackground(SystemColor.controlHighlight);
		textiname.setBounds(230, 60, 240, 40);
		panel_1.add(textiname);
		
		JComboBox combosize = new JComboBox();
		combosize.setFont(new Font("Lato", Font.BOLD, 15));
		combosize.setModel(new DefaultComboBoxModel(new String[] {"Select Size", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"}));
		combosize.setBounds(230, 160, 240, 40);
		panel_1.add(combosize);
		
		JTextField textnoOfItem = new JTextField();
		textnoOfItem.setFont(new Font("Lato", Font.BOLD, 15));
		textnoOfItem.setColumns(10);
		textnoOfItem.setBackground(SystemColor.controlHighlight);
		textnoOfItem.setBounds(230, 210, 240, 40);
		panel_1.add(textnoOfItem);
		
		textsellPrice = new JTextField();
		textsellPrice.setFont(new Font("Lato", Font.BOLD, 15));
		textsellPrice.setColumns(10);
		textsellPrice.setBackground(SystemColor.controlHighlight);
		textsellPrice.setBounds(230, 260, 240, 40);
		panel_1.add(textsellPrice);
		
		textItemDiscount = new JTextField();
		textItemDiscount.setFont(new Font("Lato", Font.BOLD, 15));
		textItemDiscount.setColumns(10);
		textItemDiscount.setBackground(SystemColor.controlHighlight);
		textItemDiscount.setBounds(230, 310, 240, 40);
		panel_1.add(textItemDiscount);
		
		textpayble = new JTextField();
		textpayble.setFont(new Font("Lato", Font.BOLD, 15));
		textpayble.setColumns(10);
		textpayble.setBackground(SystemColor.controlHighlight);
		textpayble.setBounds(230, 360, 240, 40);
		panel_1.add(textpayble);
		
		textcash = new JTextField();
		textcash.setFont(new Font("Lato", Font.BOLD, 15));
		textcash.setColumns(10);
		textcash.setBackground(SystemColor.controlHighlight);
		textcash.setBounds(230, 410, 240, 40);
		panel_1.add(textcash);
		
		textbalance = new JTextField();
		textbalance.setFont(new Font("Lato", Font.BOLD, 15));
		textbalance.setColumns(10);
		textbalance.setBackground(SystemColor.controlHighlight);
		textbalance.setBounds(230, 460, 240, 40);
		panel_1.add(textbalance);
		
		textcustomerID = new JTextField();
		textcustomerID.setFont(new Font("Lato", Font.BOLD, 15));
		textcustomerID.setColumns(10);
		textcustomerID.setBackground(SystemColor.controlHighlight);
		textcustomerID.setBounds(230, 510, 240, 40);
		panel_1.add(textcustomerID);
		
		textsellID = new JTextField();
		textsellID.setEditable(false);
		textsellID.setFont(new Font("Lato", Font.BOLD, 15));
		textsellID.setColumns(10);
		textsellID.setBackground(SystemColor.controlHighlight);
		textsellID.setBounds(230, 560, 240, 40);
		panel_1.add(textsellID);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new CompoundBorder());
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(510, 20, 395, 719);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblimage = new JLabel("");
		lblimage.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblimage.setBounds(48, 11, 300, 300);
		panel_2.add(lblimage);
		
		JTextPane textbill = new JTextPane();
		textbill.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		textbill.setBounds(10, 338, 375, 360);
		panel_2.add(textbill);
		
		this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
		BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
		bi.setNorthPane(null);

		textiid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
			
				if(textiid.getText().length() == 7) {
		try {
			String sql = "SELECT `item_name`, `category`, `size`,`sell_price`, `image` FROM `stock` WHERE item_id = '"+textiid.getText()+"'";
			pst = (PreparedStatement)con.prepareStatement(sql);
			rs = pst.executeQuery();
			if(rs.next()) {

				textiname.setText(rs.getString("item_name"));
				combocategory.setSelectedItem(rs.getString("category"));
				combosize.setSelectedItem(rs.getString("size"));
				textsellPrice.setText(rs.getString("sell_price"));
				
				
				byte[] imagedata = rs.getBytes("image");
				format = new ImageIcon(imagedata);
				Image mm = format.getImage();
				Image img22 = mm.getScaledInstance(lblimage.getWidth(), lblimage.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon image = new ImageIcon(img22);
				lblimage.setIcon(image);
			}
		}catch (Exception e) {
			JOptionPane.showMessageDialog(rootPane, e);
		}	
				}
			}
		});
		
		textnoOfItem.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				double price = Double.parseDouble(textsellPrice.getText());
				int unit = Integer.parseInt(textnoOfItem.getText());
				
				double tPrice = price * unit;
				textsellPrice.setText(tPrice+"");
			}
		});
		
		textItemDiscount.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				double discount = Double.parseDouble(textItemDiscount.getText());
				double tprice = Double.parseDouble(textsellPrice.getText());
				
				double payble = tprice - (tprice / 100 ) * discount;
				textpayble.setText(payble+"");
			}
		});
		
		textcash.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				double cash = Double.parseDouble(textcash.getText());
				double payble = Double.parseDouble(textpayble.getText());
				
				double balance = cash - payble;
				textbalance.setText(balance+"");
				
			}
		});
		
		textbill.setText("\t\t --Shoes Arena-- \t\n\n\n");
		
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				textbill.setText(textbill.getText() + "Item Name\t:\t" + textiname.getText() + "\n\nCategory\t:\t" + combocategory.getSelectedItem().toString() + "\n\nSize\t:\t" + combosize.getSelectedItem().toString() + "\n\nNo Of Items\t:\t" + textnoOfItem.getText() + "\n\nDiscount\t:\t" + textItemDiscount.getText() + "\n\nFinal Bill\t:\t" + textpayble.getText() + "\n------------------------------------------------\n\nCustomer ID\t:\t" + textcustomerID.getText() + "\nSell ID\t:\t "+ textsellID.getText() + "\n------------------------------------------------\n\n\t\t --Thank You-- \n\t\t --Come Again--" );
			
				getdata();
				category = combocategory.getSelectedItem().toString();
				size = combosize.getSelectedItem().toString();
				quantity =textnoOfItem.getText();
				
				try {
					String q = "INSERT INTO `sale`(`item_id`, `item_name`, `category`, `size`, `quantity`, `tot_price`, `item_discount`, `payble`, `cash`, `balance`, `customer_id`, `sell_id`, `date`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
					pst = (PreparedStatement)con.prepareStatement(q);
					
					pst.setString(1, iid);
					pst.setString(2, iname);
					pst.setString(3, category);
					pst.setString(4, size);
					pst.setString(5, quantity);
					pst.setString(6, tot);
					pst.setString(7, discount);
					pst.setString(8, payble);
					pst.setString(9, cash);
					pst.setString(10, balance);
					pst.setString(11, cusid);
					pst.setString(12, selid);
					pst.setString(13, date);
					pst.execute();
					
					
				} catch (Exception e1) {	
				}
				try {
					String q1 = "INSERT INTO `customer`(`customer_id`, `customer_name`, `mobile`, `sell_id`, `item_id`, `no_of_items`, `amount_paid`) VALUES (?,?,?,?,?,?,?)";
					pst = (PreparedStatement)con.prepareStatement(q1);
					
					pst.setString(1, cusid);
					pst.setString(2, " ");
					pst.setString(3, " ");
					pst.setString(4, selid);
					pst.setString(5, iid);
					pst.setString(6, quantity);
					pst.setString(7, payble);
					pst.execute();
					
				}catch (Exception e1) {
					
				}
				
			}
		});
		
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				textbill.setText(textbill.getText() + "Item Name\t:\t" + textiname.getText() + "\n\nCategory\t:\t" + combocategory.getSelectedItem().toString() + "\n\nSize\t:\t" + combosize.getSelectedItem().toString() + "\n\nNo Of Items\t:\t" + textnoOfItem.getText() + "\n\nDiscount\t:\t" + textItemDiscount.getText() + "\n\nFinal Bill\t:\t" + textpayble.getText() + "\n------------------------------------------------\n\nCustomer ID\t:\t" + textcustomerID.getText() + "\nSell ID\t:\t "+ textsellID.getText() + "\n------------------------------------------------\n\n\t\t --Thank You-- \n\t\t --Come Again--" );
				
				getdata();
				category = combocategory.getSelectedItem().toString();
				size = combosize.getSelectedItem().toString();
				quantity =textnoOfItem.getText();
				
				try {
					String q = "INSERT INTO `sale`(`item_id`, `item_name`, `category`, `size`, `quantity`, `tot_price`, `item_discount`, `payble`, `cash`, `balance`, `customer_id`, `sell_id`, `date`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
					pst = (PreparedStatement)con.prepareStatement(q);
					
					pst.setString(1, iid);
					pst.setString(2, iname);
					pst.setString(3, category);
					pst.setString(4, size);
					pst.setString(5, quantity);
					pst.setString(6, tot);
					pst.setString(7, discount);
					pst.setString(8, payble);
					pst.setString(9, cash);
					pst.setString(10, balance);
					pst.setString(11, cusid);
					pst.setString(12, selid);
					pst.setString(13, date);
					pst.execute();
					
					
				} catch (Exception e1) {	
				}
				try {
					String q1 = "INSERT INTO `customer`(`customer_id`, `customer_name`, `mobile`, `sell_id`, `item_id`, `no_of_items`, `amount_paid`) VALUES (?,?,?,?,?,?,?)";
					pst = (PreparedStatement)con.prepareStatement(q1);
					
					pst.setString(1, cusid);
					pst.setString(2, " ");
					pst.setString(3, " ");
					pst.setString(4, selid);
					pst.setString(5, iid);
					pst.setString(6, quantity);
					pst.setString(7, payble);
					pst.execute();
					
				}catch (Exception e1) {
					
				}
				
			}
		});
		
		//print the bill
		
		lblUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				try {
				textbill.print();
				} catch (Exception e) {
				}
			}
		});
		
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				try {
					textbill.print();
					} catch (Exception e) {
					}
			}
		});
		
		//clear the fields
		
		lblClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				 autoID();
				 textiid.setText("");
				 textiname.setText("");
				 combocategory.setSelectedIndex(0);
				 combosize.setSelectedIndex(0);
				 lblimage.setIcon(null);
				 textnoOfItem.setText("");
				 textsellPrice.setText("");
				 textItemDiscount.setText("");
				 textpayble.setText("");
				 textcash.setText("");
				 textbalance.setText("");
				 textcustomerID.setText("");
				 textbill.setText(""); 
			}
		});
		
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				 autoID();
				 textiid.setText("");
				 textiname.setText("");
				 combocategory.setSelectedIndex(0);
				 combosize.setSelectedIndex(0);
				 lblimage.setIcon(null);
				 textnoOfItem.setText("");
				 textsellPrice.setText("");
				 textItemDiscount.setText("");
				 textpayble.setText("");
				 textcash.setText("");
				 textbalance.setText("");
				 textcustomerID.setText("");
				 textbill.setText(""); 
				
			}
		});
		
		
		autoID();	
	}
	
	//method for creating sell id automatically
	
	private void autoID() {
		
		try {
			String sql = "SELECT `sell_id` FROM `sale` ORDER BY sell_id DESC LIMIT 1";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			if(rs.next()) {
				String rnno = rs.getString("sell_id");
				int co = rnno.length();
				String txt = rnno.substring(0,3);
				String num = rnno.substring(3, co);
				int n = Integer.parseInt(num);
				n++;
				String snum = Integer.toString(n);
				String ftxt = txt + snum;
				textsellID.setText(ftxt);
			}
			else {
				textsellID.setText("SID1000");
			}
			
		} catch (Exception e) {
			//JOptionPane.showMessageDialog(rootPane, e);
		}
	}
	
	//method for get data
	
	private void getdata() {
		
		iid = textiid.getText();
		iname = textiname.getText();
		tot = textsellPrice.getText();
		discount = textItemDiscount.getText();
		payble = textpayble.getText();
		cash = textcash.getText();
		balance= textbalance.getText();
		cusid = textcustomerID.getText();
		selid = textsellID.getText();
		LocalDate ndate = LocalDate.now();
		date = ndate+"";
		
	}
}
