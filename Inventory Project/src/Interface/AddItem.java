package Interface;

import java.awt.EventQueue;


import javax.swing.JInternalFrame;
import java.awt.Rectangle;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JTextPane;
import java.awt.Cursor;
import javax.swing.UIManager;
import javax.swing.DebugGraphics;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.sql.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class AddItem extends JInternalFrame {
	private JTable tableadditem;
	private JTextField textiname;
	private JTextField textquantity;
	private JTextField textsid;
	private JTextField textbprice;
	private JTextField textsprice;
	private JTextField textiid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddItem frame = new AddItem();
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
	String sid;
	String bprice;
	String sprice;
	Connection con;
	
	private ImageIcon format = null;
	String fname = null;
	int s = 0;
	byte[] pimage = null;
	
	public AddItem() {
		
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
		
		JLabel lblSupplierId = new JLabel("Supplier ID");
		lblSupplierId.setFont(new Font("Lato Black", Font.BOLD, 20));
		lblSupplierId.setBounds(10, 260, 160, 50);
		panel_1.add(lblSupplierId);
		
		JLabel lblBuyingPrice = new JLabel("Buying Price");
		lblBuyingPrice.setFont(new Font("Lato Black", Font.BOLD, 20));
		lblBuyingPrice.setBounds(10, 310, 160, 50);
		panel_1.add(lblBuyingPrice);
		
		JLabel lblSellingPrice = new JLabel("Selling Price");
		lblSellingPrice.setFont(new Font("Lato Black", Font.BOLD, 20));
		lblSellingPrice.setBounds(10, 360, 160, 50);
		panel_1.add(lblSellingPrice);
		
		JComboBox combocategory = new JComboBox();
		combocategory.setFont(new Font("Lato", Font.BOLD, 15));
		combocategory.setModel(new DefaultComboBoxModel(new String[] {"Select Category", "Women's Boots", "Women's Flats", "Women's Sandles", "Women's Slippers", "Men's Boots", "Men's Casual Shoes", "Men's Formal Shoes", "Men's Slippers"}));
		combocategory.setBounds(200, 110, 222, 40);
		panel_1.add(combocategory);
		
		textiname = new JTextField();
		textiname.setFont(new Font("Lato", Font.BOLD, 15));
		textiname.setColumns(10);
		textiname.setBackground(SystemColor.controlHighlight);
		textiname.setBounds(200, 60, 222, 40);
		panel_1.add(textiname);
		
		textquantity = new JTextField();
		textquantity.setFont(new Font("Lato", Font.BOLD, 15));
		textquantity.setColumns(10);
		textquantity.setBackground(SystemColor.controlHighlight);
		textquantity.setBounds(200, 210, 222, 40);
		panel_1.add(textquantity);
		
		textsid = new JTextField();
		textsid.setFont(new Font("Lato", Font.BOLD, 15));
		textsid.setColumns(10);
		textsid.setBackground(SystemColor.controlHighlight);
		textsid.setBounds(200, 260, 222, 40);
		panel_1.add(textsid);
		
		textbprice = new JTextField();
		textbprice.setFont(new Font("Lato", Font.BOLD, 15));
		textbprice.setColumns(10);
		textbprice.setBackground(SystemColor.controlHighlight);
		textbprice.setBounds(200, 310, 222, 40);
		panel_1.add(textbprice);
		
		textsprice = new JTextField();
		textsprice.setFont(new Font("Lato", Font.BOLD, 15));
		textsprice.setColumns(10);
		textsprice.setBackground(SystemColor.controlHighlight);
		textsprice.setBounds(200, 360, 222, 40);
		panel_1.add(textsprice);
		
		textiid = new JTextField();
		textiid.setFont(new Font("Lato", Font.BOLD, 15));
		textiid.setColumns(10);
		textiid.setBackground(SystemColor.controlHighlight);
		textiid.setBounds(200, 10, 222, 40);
		panel_1.add(textiid);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 153, 0));
		panel_4.setBounds(22, 452, 170, 50);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel label_1 = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("/add.png")).getImage();
		label_1.setIcon(new ImageIcon(img1));
		label_1.setBounds(0, 0, 50, 50);
		panel_4.add(label_1);
		
		JLabel lblNewLabel_2 = new JLabel("Add");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Lato Black", Font.BOLD, 20));
		lblNewLabel_2.setBounds(50, 0, 120, 50);
		panel_4.add(lblNewLabel_2);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(new Color(255, 153, 0));
		panel_5.setBounds(240, 452, 170, 50);
		panel_1.add(panel_5);
		
		JLabel label_4 = new JLabel("");
		Image img4 = new ImageIcon(this.getClass().getResource("/updates.png")).getImage();
		label_4.setIcon(new ImageIcon(img4));
		label_4.setBounds(0, 0, 50, 50);
		panel_5.add(label_4);
		
		JLabel lblUpdate = new JLabel("Update");
		lblUpdate.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdate.setFont(new Font("Lato Black", Font.BOLD, 20));
		lblUpdate.setBounds(50, 0, 120, 50);
		panel_5.add(lblUpdate);
		
		JComboBox combosize = new JComboBox();
		combosize.setFont(new Font("Lato", Font.BOLD, 15));
		combosize.setModel(new DefaultComboBoxModel(new String[] {"Select Size", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"}));
		combosize.setBounds(200, 160, 222, 40);
		panel_1.add(combosize);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new CompoundBorder());
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(473, 20, 432, 513);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblimage = new JLabel("");
		lblimage.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblimage.setBounds(71, 11, 300, 300);
		panel_2.add(lblimage);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 153, 0));
		panel_3.setBounds(71, 322, 300, 79);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				JFileChooser fchoser = new JFileChooser();
				fchoser.showOpenDialog(null);
				File f = fchoser.getSelectedFile();
				fname = f.getAbsolutePath();
				ImageIcon micon = new ImageIcon(fname);
				try {
					File image = new File(fname);
					FileInputStream fis = new FileInputStream(image);
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					byte[] buf = new byte[1024];
					for(int readnum; (readnum = fis.read(buf)) != -1;) {
						baos.write(buf, 0, readnum);
					}
					pimage = baos.toByteArray();
					lblimage.setIcon(resizeImage(fname, buf, fchoser));
				}catch (Exception e1) {
					
				}
				
			}
		});
		Image img = new ImageIcon(this.getClass().getResource("/search-7979.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(0, 0, 79, 79);
		panel_3.add(label);
		
		JLabel lblBrowse = new JLabel("Browse");
		lblBrowse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				JFileChooser fchoser = new JFileChooser();
				fchoser.showOpenDialog(null);
				File f = fchoser.getSelectedFile();
				fname = f.getAbsolutePath();
				ImageIcon micon = new ImageIcon(fname);
				try {
					File image = new File(fname);
					FileInputStream fis = new FileInputStream(image);
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					byte[] buf = new byte[1024];
					for(int readnum; (readnum = fis.read(buf)) != -1;) {
						baos.write(buf, 0, readnum);
					}
					pimage = baos.toByteArray();
					lblimage.setIcon(resizeImage(fname, buf, fchoser));
				}catch (Exception e1) {
					
				}
			}
		});
		lblBrowse.setHorizontalAlignment(SwingConstants.CENTER);
		lblBrowse.setFont(new Font("Lato Black", Font.BOLD, 25));
		lblBrowse.setBounds(79, 0, 221, 79);
		panel_3.add(lblBrowse);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(new Color(255, 153, 0));
		panel_6.setBounds(22, 452, 170, 50);
		panel_2.add(panel_6);
		
		JLabel label_3 = new JLabel("");
		Image img3 = new ImageIcon(this.getClass().getResource("/delete.png")).getImage();
		label_3.setIcon(new ImageIcon(img3));
		label_3.setBounds(0, 0, 50, 50);
		panel_6.add(label_3);
		
		JLabel lblDelete = new JLabel("Delete");
		lblDelete.setHorizontalAlignment(SwingConstants.CENTER);
		lblDelete.setFont(new Font("Lato Black", Font.BOLD, 20));
		lblDelete.setBounds(50, 0, 120, 50);
		panel_6.add(lblDelete);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBackground(new Color(255, 153, 0));
		panel_7.setBounds(239, 452, 170, 50);
		panel_2.add(panel_7);
		
		JLabel label_2 = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("/clear.png")).getImage();
		label_2.setIcon(new ImageIcon(img2));
		label_2.setBounds(0, 0, 50, 50);
		panel_7.add(label_2);
		
		JLabel lblClear = new JLabel("Clear");
		lblClear.setHorizontalAlignment(SwingConstants.CENTER);
		lblClear.setFont(new Font("Lato Black", Font.BOLD, 20));
		lblClear.setBounds(50, 0, 120, 50);
		panel_7.add(lblClear);
		
		tableadditem = new JTable();
		tableadditem.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		tableadditem.setBounds(20, 549, 885, 190);
		panel.add(tableadditem);
		
		this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
		BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
		bi.setNorthPane(null);
		
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				getdata();
				category = combocategory.getSelectedItem().toString();
				size = combosize.getSelectedItem().toString();
				
				try {
					String q = "INSERT INTO `stock`(`item_id`, `item_name`, `category`, `size`, `qty`, `supplier_id`, `buy_price`, `sell_price`, `image`) VALUES (?,?,?,?,?,?,?,?,?)";
					pst = (PreparedStatement)con.prepareStatement(q);
					
					pst.setString(1, iid);
					pst.setString(2, iname);
					pst.setString(3, category);
					pst.setString(4, size);
					pst.setString(5, quantity);
					pst.setString(6, sid);
					pst.setString(7, bprice);
					pst.setString(8, sprice);
					pst.setBytes(9, pimage);
					pst.execute();
					
					cleardata();
					combocategory.setSelectedIndex(0);
					combosize.setSelectedIndex(0);
					lblimage.setIcon(null);
					tableload();
				} catch (Exception e1) {
					
				}
				
			}
		});
		
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				getdata();
				category = combocategory.getSelectedItem().toString();
				size = combosize.getSelectedItem().toString();
				
				try {
					String q = "INSERT INTO `stock`(`item_id`, `item_name`, `category`, `size`, `qty`, `supplier_id`, `buy_price`, `sell_price`, `image`) VALUES (?,?,?,?,?,?,?,?,?)";
					pst = (PreparedStatement)con.prepareStatement(q);
					
					pst.setString(1, iid);
					pst.setString(2, iname);
					pst.setString(3, category);
					pst.setString(4, size);
					pst.setString(5, quantity);
					pst.setString(6, sid);
					pst.setString(7, bprice);
					pst.setString(8, sprice);
					pst.setBytes(9, pimage);
					pst.execute();
					
					cleardata();
					combocategory.setSelectedIndex(0);
					combosize.setSelectedIndex(0);
					lblimage.setIcon(null);
					tableload();
				} catch (Exception e1) {
					
				}
				
			}
		});
		
		lblUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				getdata();
				category = combocategory.getSelectedItem().toString();
				size = combosize.getSelectedItem().toString();
				
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
				cleardata();
				combocategory.setSelectedIndex(0);
				combosize.setSelectedIndex(0);
				lblimage.setIcon(null);
				tableload();
			}
			
		});
		
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				getdata();
				category = combocategory.getSelectedItem().toString();
				size = combosize.getSelectedItem().toString();
				
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
				cleardata();
				combocategory.setSelectedIndex(0);
				combosize.setSelectedIndex(0);
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
					
					combocategory.setSelectedIndex(0);
					combosize.setSelectedIndex(0);
					lblimage.setIcon(null);
					cleardata();
					tableload();
					
				}catch (Exception e1) {
				}
			}
		});
		
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				try {
					
					String sql = "DELETE FROM `stock` WHERE item_id = '"+textiid.getText()+"'";
					pst = (PreparedStatement)con.prepareStatement(sql);
					pst.execute();
					
					combocategory.setSelectedIndex(0);
					combosize.setSelectedIndex(0);
					lblimage.setIcon(null);
					cleardata();
					tableload();
					
				}catch (Exception e1) {
				}
				
			}
		});
		
		lblClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				combocategory.setSelectedIndex(0);
				combosize.setSelectedIndex(0);
				lblimage.setIcon(null);
				cleardata();
				
			}
		});
		
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				combocategory.setSelectedIndex(0);
				combosize.setSelectedIndex(0);
				lblimage.setIcon(null);
				cleardata();
				
			}
		});
		
		tableadditem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e1) {
				
				String id;
				DefaultTableModel tmodel = (DefaultTableModel) tableadditem.getModel();
				int selectrowindex = tableadditem.getSelectedRow();
				id = (tmodel.getValueAt(selectrowindex, 0).toString());
				
				try {
					String sql = "SELECT `item_id`, `item_name`, `category`, `size`, `qty`, `supplier_id`, `buy_price`, `sell_price`, `image` FROM `stock` WHERE item_id = '"+id+"'";
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
		
		autoID();
		tableload();
		combocategory.setSelectedIndex(0);
		combosize.setSelectedIndex(0);
		lblimage.setIcon(null);
		cleardata();			
		
	}
	
	//method for get image
	
public ImageIcon resizeImage(String imagePath, byte[] pic, JComponent lblimage) {
		
		ImageIcon myImage = null;
		if(imagePath != null) {
			myImage = new ImageIcon(imagePath);
		}
		else {
			myImage = new ImageIcon(pic);
		}
		
		Image img = myImage.getImage();
		Image img2 = img.getScaledInstance(lblimage.getHeight(), lblimage.getWidth(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(img2);
		return image;
	}
	
//method for creating Item id

private void autoID() {
	
	try {
		String sql = "SELECT `item_id` FROM `stock` ORDER BY item_id DESC LIMIT 1";
		pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		if(rs.next()) {
			String rnno = rs.getString("item_id");
			int co = rnno.length();
			String txt = rnno.substring(0,3);
			String num = rnno.substring(3, co);
			int n = Integer.parseInt(num);
			n++;
			String snum = Integer.toString(n);
			String ftxt = txt + snum;
			textiid.setText(ftxt);
		}
		else {
			textiid.setText("IID1000");
		}
		
	} catch (Exception e) {
		JOptionPane.showMessageDialog(rootPane, e);
	}
	
}	

//method for get data
	
private void getdata() {
	
	iid = textiid.getText();
	iname = textiname.getText();
	quantity = textquantity.getText();
	sid = textsid.getText();
	bprice = textbprice.getText();
	sprice = textsprice.getText();
	
}

//method for clear text fields

private void cleardata(){
	
	autoID();
	textiname.setText("");
	textquantity.setText("");
	textsid.setText("");
	textbprice.setText("");
	textsprice.setText("");
}

//method for load the table

private void tableload() {
	
	try {
		String sql = "SELECT `item_id`, `item_name`, `category`, `size`, `qty`, `supplier_id`, `buy_price`, `sell_price`, `image` FROM `stock`";
				pst = (PreparedStatement)con.prepareStatement(sql);
				rs = pst.executeQuery();
				tableadditem.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
		
	}catch (Exception e) {
	}
}

	
}
	



