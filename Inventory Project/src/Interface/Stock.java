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
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Stock extends JInternalFrame {
	private JTable table;
	private JTable tablestock;
	private JTextField textiid;
	private JTextField textiname;
	private JTextField textField_2;
	private JTextField textquantity;
	private JTextField textsid;
	private JTextField textsearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stock frame = new Stock();
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
	
	private ImageIcon format = null;
	String fname = null;
	int s = 0;
	byte[] pimage = null;
	private JTextField textbprice;
	private JTextField textsprice;
	
	public Stock() {
		
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
		panel_1.setBounds(20, 20, 432, 513);
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
		
		JLabel lblSize = new JLabel("Size");
		lblSize.setFont(new Font("Lato Black", Font.BOLD, 20));
		lblSize.setBounds(10, 160, 160, 50);
		panel_1.add(lblSize);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Lato Black", Font.BOLD, 20));
		lblQuantity.setBounds(10, 210, 160, 50);
		panel_1.add(lblQuantity);
		
		JLabel lblBuyingPrice = new JLabel("Supplier ID");
		lblBuyingPrice.setFont(new Font("Lato Black", Font.BOLD, 20));
		lblBuyingPrice.setBounds(10, 260, 160, 50);
		panel_1.add(lblBuyingPrice);
		
		JComboBox combocategory = new JComboBox();
		combocategory.setFont(new Font("Lato", Font.BOLD, 15));
		combocategory.setModel(new DefaultComboBoxModel(new String[] {"Select Category", "Women's Boots", "Women's Flats", "Women's Sandles", "Women's Slippers", "Men's Boots", "Men's Casual Shoes", "Men's Formal Shoes", "Men's Slippers"}));
		combocategory.setBounds(200, 110, 222, 40);
		panel_1.add(combocategory);
		Image img2 = new ImageIcon(this.getClass().getResource("/clear.png")).getImage();
		
		textiid = new JTextField();
		textiid.setFont(new Font("Lato", Font.BOLD, 15));
		textiid.setBackground(SystemColor.controlHighlight);
		textiid.setBounds(200, 10, 222, 40);
		panel_1.add(textiid);
		textiid.setColumns(10);
		
		textiname = new JTextField();
		textiname.setFont(new Font("Lato", Font.BOLD, 15));
		textiname.setBackground(SystemColor.controlHighlight);
		textiname.setColumns(10);
		textiname.setBounds(200, 60, 222, 40);
		panel_1.add(textiname);
		
		JComboBox combosize = new JComboBox();
		combosize.setFont(new Font("Lato", Font.BOLD, 15));
		combosize.setModel(new DefaultComboBoxModel(new String[] {"Select Size", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"}));
		combosize.setBounds(200, 160, 222, 40);
		panel_1.add(combosize);
		
		textquantity = new JTextField();
		textquantity.setFont(new Font("Lato", Font.BOLD, 15));
		textquantity.setBackground(SystemColor.controlHighlight);
		textquantity.setColumns(10);
		textquantity.setBounds(200, 210, 222, 40);
		panel_1.add(textquantity);
		
		textsid = new JTextField();
		textsid.setFont(new Font("Lato", Font.BOLD, 15));
		textsid.setBackground(SystemColor.controlHighlight);
		textsid.setColumns(10);
		textsid.setBounds(200, 260, 222, 40);
		panel_1.add(textsid);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(255, 153, 0));
		panel_4.setBounds(10, 452, 170, 50);
		panel_1.add(panel_4);
		
		JLabel label = new JLabel("");
		Image img11 = new ImageIcon(this.getClass().getResource("/updates.png")).getImage();
		label.setIcon(new ImageIcon(img11));
		label.setBounds(0, 0, 50, 50);
		panel_4.add(label);
		
		JLabel lblUpdate = new JLabel("Update");		
		lblUpdate.setBounds(50, 0, 120, 50);
		panel_4.add(lblUpdate);
		lblUpdate.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdate.setFont(new Font("Lato Black", Font.BOLD, 25));
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(new Color(255, 153, 0));
		panel_5.setBounds(252, 452, 170, 50);
		panel_1.add(panel_5);
		
		JLabel label_1 = new JLabel("");
		Image img3 = new ImageIcon(this.getClass().getResource("/delete.png")).getImage();
		label_1.setIcon(new ImageIcon(img3));
		label_1.setBounds(0, 0, 50, 50);
		panel_5.add(label_1);
		
		JLabel lblDelete = new JLabel("Delete");
		lblDelete.setHorizontalAlignment(SwingConstants.CENTER);
		lblDelete.setFont(new Font("Lato Black", Font.BOLD, 25));
		lblDelete.setBounds(50, 0, 120, 50);
		panel_5.add(lblDelete);
		
		JLabel lblSupplierId = new JLabel("Buying Price");
		lblSupplierId.setFont(new Font("Lato Black", Font.BOLD, 20));
		lblSupplierId.setBounds(10, 313, 160, 50);
		panel_1.add(lblSupplierId);
		
		JLabel lblSelligPrice = new JLabel("Sellig Price");
		lblSelligPrice.setFont(new Font("Lato Black", Font.BOLD, 20));
		lblSelligPrice.setBounds(10, 364, 160, 50);
		panel_1.add(lblSelligPrice);
		
		textbprice = new JTextField();
		textbprice.setFont(new Font("Lato", Font.BOLD, 15));
		textbprice.setColumns(10);
		textbprice.setBackground(SystemColor.controlHighlight);
		textbprice.setBounds(200, 311, 222, 40);
		panel_1.add(textbprice);
		
		textsprice = new JTextField();
		textsprice.setFont(new Font("Lato", Font.BOLD, 15));
		textsprice.setColumns(10);
		textsprice.setBackground(SystemColor.controlHighlight);
		textsprice.setBounds(200, 364, 222, 40);
		panel_1.add(textsprice);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new CompoundBorder());
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(473, 20, 432, 513);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblimage = new JLabel("");
		lblimage.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblimage.setBounds(71, 118, 300, 300);
		panel_2.add(lblimage);
		
		JLabel lblClear = new JLabel("Search By Name");
		lblClear.setBounds(126, 11, 179, 50);
		panel_2.add(lblClear);
		lblClear.setHorizontalAlignment(SwingConstants.CENTER);
		lblClear.setFont(new Font("Lato Black", Font.BOLD, 20));
		
		textsearch = new JTextField();
		textsearch.setBackground(SystemColor.controlHighlight);
		textsearch.setFont(new Font("Lato", Font.BOLD, 15));
		textsearch.setColumns(10);
		textsearch.setBounds(29, 58, 372, 40);
		panel_2.add(textsearch);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(71, 429, 300, 72);
		panel_2.add(panel_3);
		panel_3.setBackground(new Color(255, 153, 0));
		panel_3.setLayout(null);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(0, 0, 77, 72);
		panel_3.add(label_2);
		label_2.setIcon(new ImageIcon(img2));
		
		JLabel lblBrowse = new JLabel("Clear");
		lblBrowse.setBounds(79, 0, 221, 72);
		panel_3.add(lblBrowse);
		lblBrowse.setHorizontalAlignment(SwingConstants.CENTER);
		lblBrowse.setFont(new Font("Lato Black", Font.BOLD, 25));
		
		lblBrowse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				textiid.setText("");
				textiname.setText("");
				combocategory.setSelectedIndex(0);
				combosize.setSelectedIndex(0);
				textquantity.setText("");
				textsid.setText("");
				textbprice.setText("");
				textsprice.setText("");
				lblimage.setIcon(null);
			}
		});
		
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				textiid.setText("");
				textiname.setText("");
				combocategory.setSelectedIndex(0);
				combosize.setSelectedIndex(0);
				textquantity.setText("");
				textsid.setText("");
				lblimage.setIcon(null);
				
			}
		});
		
		tablestock = new JTable();
		tablestock.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		tablestock.setBounds(20, 549, 885, 190);
		panel.add(tablestock);
		
		table = new JTable();
		table.setBounds(20, 549, 885, 190);
		panel.add(table);
		
		this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
		BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
		bi.setNorthPane(null);
		
		tablestock.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				String id;
				DefaultTableModel tmodel = (DefaultTableModel) tablestock.getModel();
				int selectrowindex = tablestock.getSelectedRow();
				id = (tmodel.getValueAt(selectrowindex, 0).toString());
				
				try {
					String sql = "SELECT `item_id`, `item_name`, `category`, `size`, `qty`,`supplier_id`, `buy_price`,`sell_price`, `image` FROM `stock` WHERE item_id = '"+id+"'";
					pst = (PreparedStatement)con.prepareStatement(sql);
					rs = pst.executeQuery();
					if(rs.next()) {
						textiid.setText(rs.getString("item_id"));
						textiname.setText(rs.getString("item_name"));
						combocategory.setSelectedItem(rs.getString("category"));
						combosize.setSelectedItem(rs.getString("size"));
						textquantity.setText(rs.getString("qty"));
						textsid.setText(rs.getString("supplier_id"));
						textbprice.setText(rs.getString("buy_price"));
						textsprice.setText(rs.getString("sell_price"));
						
						byte[] imagedata = rs.getBytes("image");
						format = new ImageIcon(imagedata);
						Image mm = format.getImage();
						Image img2 = mm.getScaledInstance(lblimage.getWidth(), lblimage.getHeight(), Image.SCALE_SMOOTH);
						ImageIcon image = new ImageIcon(img2);
						lblimage.setIcon(image);
					}
				}catch (Exception e) {
					JOptionPane.showMessageDialog(rootPane, e);
				}	
				
			}
		});
		
		textsearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				if(textsearch.getText().length() > 0 ) {
				try {
					String sql = "SELECT `item_id`, `item_name`, `category`, `size`, `qty`, `buy_price`, `image` FROM `stock` WHERE item_name LIKE '%"+textsearch.getText()+"%'";
							pst = (PreparedStatement)con.prepareStatement(sql);
							rs = pst.executeQuery();
							tablestock.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
					
				}catch (Exception e) {
				}
			}
				else {
					tableload();
				}
			}
		});
		
		lblUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				String iname = textiname.getText();
				String quantity = textquantity.getText();
				String bprice = textbprice.getText();
				String category = combocategory.getSelectedItem().toString();
				String size = combosize.getSelectedItem().toString();
				String sid = textsid.getText();
				String sprice = textsprice.getText();
				
				try {
					
					String squpdate = "UPDATE `stock` SET `item_name`=?,`category`=?,`size`=?,`qty`=?,`supplier_id`=?,`buy_price`=?,`sell_price`=? WHERE item_id = '"+textiid.getText()+"'";
					pst = (PreparedStatement)con.prepareStatement(squpdate);
					
					pst.setString(1, iname);
					pst.setString(2, category);
					pst.setString(3, size);
					pst.setString(4, quantity);
					pst.setString(5, sid);
					pst.setString(6, bprice);
					pst.setString(7, sprice);
					
					pst.execute();
					
				
				}catch (Exception e1) {
					JOptionPane.showMessageDialog(rootPane, e1);
				}
				
				textiid.setText("");
				textiname.setText("");
				textquantity.setText("");
				textsid.setText("");
				combocategory.setSelectedIndex(0);
				combosize.setSelectedIndex(0);
				textbprice.setText("");
				textsid.setText("");
				textsprice.setText("");
				lblimage.setIcon(null);
				tableload();
			}
			
		});
		
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String iname = textiname.getText();
				String quantity = textquantity.getText();
				String bprice = textbprice.getText();
				String category = combocategory.getSelectedItem().toString();
				String size = combosize.getSelectedItem().toString();
				String sid = textsid.getText();
				String sprice = textsprice.getText();
				
				try {
					
					String squpdate = "UPDATE `stock` SET `item_name`=?,`category`=?,`size`=?,`qty`=?,`supplier_id`=?,`buy_price`=?,`sell_price`=? WHERE item_id = '"+textiid.getText()+"'";
					pst = (PreparedStatement)con.prepareStatement(squpdate);
					
					pst.setString(1, iname);
					pst.setString(2, category);
					pst.setString(3, size);
					pst.setString(4, quantity);
					pst.setString(5, sid);
					pst.setString(6, bprice);
					pst.setString(7, sprice);
					
					pst.execute();
					
				
				}catch (Exception e1) {
					JOptionPane.showMessageDialog(rootPane, e1);
				}
				
				textiid.setText("");
				textiname.setText("");
				textquantity.setText("");
				textsid.setText("");
				combocategory.setSelectedIndex(0);
				combosize.setSelectedIndex(0);
				textbprice.setText("");
				textsid.setText("");
				textsprice.setText("");
				lblimage.setIcon(null);
				tableload();
				
			}
		});
		
		lblDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					
					String sql = "DELETE FROM `stock` WHERE item_id = '"+textiid.getText()+"'";
					pst = (PreparedStatement)con.prepareStatement(sql);
					pst.execute();
					
					textiid.setText("");
					textiname.setText("");
					textquantity.setText("");
					textsid.setText("");
					combocategory.setSelectedIndex(0);
					combosize.setSelectedIndex(0);
					textbprice.setText("");
					textsid.setText("");
					textsprice.setText("");
					lblimage.setIcon(null);;
					tableload();
					
				}catch (Exception e1) {
				}
				
			}
		});
		
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					
					String sql = "DELETE FROM `stock` WHERE item_id = '"+textiid.getText()+"'";
					pst = (PreparedStatement)con.prepareStatement(sql);
					pst.execute();
					
					textiid.setText("");
					textiname.setText("");
					textquantity.setText("");
					textsid.setText("");
					combocategory.setSelectedIndex(0);
					combosize.setSelectedIndex(0);
					textbprice.setText("");
					textsid.setText("");
					textsprice.setText("");
					lblimage.setIcon(null);;
					tableload();
					
				}catch (Exception e1) {
				}
				
			}
		});

		tableload();
	}
	
	//method for load stock table

	private void tableload() {
		
		try {
			String sql = "SELECT `item_id`, `item_name`, `category`, `size`, `qty`,`supplier_id`, `buy_price`, `sell_price`, `image` FROM `stock`";
					pst = (PreparedStatement)con.prepareStatement(sql);
					rs = pst.executeQuery();
					tablestock.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
			
		}catch (Exception e) {
		}
	}
	

	}


