package Interface;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Rectangle;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class Main extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setBounds(new Rectangle(0, 0, 925, 750));
		setBounds(0, 0, 925, 750);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 255));
		panel.setBounds(0, 0, 925, 750);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(20, 21, 433, 70);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblAboutShop = new JLabel("About Shop");
		lblAboutShop.setBounds(0, 11, 433, 34);
		lblAboutShop.setHorizontalAlignment(SwingConstants.CENTER);
		lblAboutShop.setFont(new Font("Lato Black", Font.BOLD, 25));
		panel_1.add(lblAboutShop);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(470, 20, 433, 70);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblSizeChart = new JLabel("Size Chart");
		lblSizeChart.setBounds(0, 11, 433, 34);
		panel_2.add(lblSizeChart);
		lblSizeChart.setHorizontalAlignment(SwingConstants.CENTER);
		lblSizeChart.setFont(new Font("Lato Black", Font.BOLD, 25));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(470, 113, 433, 600);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblHeelToToecm = new JLabel("Heel to Toe(cm)");
		lblHeelToToecm.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeelToToecm.setHorizontalTextPosition(SwingConstants.CENTER);
		lblHeelToToecm.setFont(new Font("Lato Black", Font.BOLD, 17));
		lblHeelToToecm.setBounds(0, 0, 216, 50);
		panel_3.add(lblHeelToToecm);
		
		JLabel label_1 = new JLabel("17");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Lato Black", Font.BOLD, 17));
		label_1.setBounds(0, 50, 216, 50);
		panel_3.add(label_1);
		
		JLabel label_2 = new JLabel("18");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Lato Black", Font.BOLD, 17));
		label_2.setBounds(0, 100, 216, 50);
		panel_3.add(label_2);
		
		JLabel label_3 = new JLabel("19");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Lato Black", Font.BOLD, 17));
		label_3.setBounds(0, 150, 216, 50);
		panel_3.add(label_3);
		
		JLabel label_4 = new JLabel("20");
		label_4.setFont(new Font("Lato Black", Font.BOLD, 17));
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(0, 200, 216, 50);
		panel_3.add(label_4);
		
		JLabel label_5 = new JLabel("21");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Lato Black", Font.BOLD, 17));
		label_5.setBounds(0, 250, 216, 50);
		panel_3.add(label_5);
		
		JLabel label_6 = new JLabel("22");
		label_6.setFont(new Font("Lato Black", Font.BOLD, 17));
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBounds(0, 300, 216, 50);
		panel_3.add(label_6);
		
		JLabel label_7 = new JLabel("23");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setFont(new Font("Lato Black", Font.BOLD, 17));
		label_7.setBounds(0, 350, 216, 50);
		panel_3.add(label_7);
		
		JLabel label_8 = new JLabel("24");
		label_8.setFont(new Font("Lato Black", Font.BOLD, 17));
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setBounds(0, 400, 216, 50);
		panel_3.add(label_8);
		
		JLabel label_9 = new JLabel("25");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setFont(new Font("Lato Black", Font.BOLD, 17));
		label_9.setBounds(0, 450, 216, 50);
		panel_3.add(label_9);
		
		JLabel label_10 = new JLabel("26");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setFont(new Font("Lato Black", Font.BOLD, 17));
		label_10.setBounds(0, 500, 216, 50);
		panel_3.add(label_10);
		
		JLabel label_11 = new JLabel("27");
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setFont(new Font("Lato Black", Font.BOLD, 17));
		label_11.setBounds(0, 550, 216, 50);
		panel_3.add(label_11);
		
		JLabel lblShoeSize = new JLabel("Shoe Size");
		lblShoeSize.setHorizontalTextPosition(SwingConstants.CENTER);
		lblShoeSize.setHorizontalAlignment(SwingConstants.CENTER);
		lblShoeSize.setFont(new Font("Lato Black", Font.BOLD, 17));
		lblShoeSize.setBounds(217, 0, 216, 50);
		panel_3.add(lblShoeSize);
		
		JLabel label = new JLabel("5");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Lato Black", Font.BOLD, 17));
		label.setBounds(217, 50, 217, 50);
		panel_3.add(label);
		
		JLabel label_12 = new JLabel("6");
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setFont(new Font("Lato Black", Font.BOLD, 17));
		label_12.setBounds(217, 100, 216, 50);
		panel_3.add(label_12);
		
		JLabel label_13 = new JLabel("7");
		label_13.setHorizontalAlignment(SwingConstants.CENTER);
		label_13.setFont(new Font("Lato Black", Font.BOLD, 17));
		label_13.setBounds(217, 150, 216, 50);
		panel_3.add(label_13);
		
		JLabel label_14 = new JLabel("8");
		label_14.setHorizontalAlignment(SwingConstants.CENTER);
		label_14.setFont(new Font("Lato Black", Font.BOLD, 17));
		label_14.setBounds(217, 200, 216, 50);
		panel_3.add(label_14);
		
		JLabel label_15 = new JLabel("9");
		label_15.setHorizontalAlignment(SwingConstants.CENTER);
		label_15.setFont(new Font("Lato Black", Font.BOLD, 17));
		label_15.setBounds(217, 250, 216, 50);
		panel_3.add(label_15);
		
		JLabel label_16 = new JLabel("10");
		label_16.setHorizontalAlignment(SwingConstants.CENTER);
		label_16.setFont(new Font("Lato Black", Font.BOLD, 17));
		label_16.setBounds(217, 300, 216, 50);
		panel_3.add(label_16);
		
		JLabel label_17 = new JLabel("11");
		label_17.setHorizontalAlignment(SwingConstants.CENTER);
		label_17.setFont(new Font("Lato Black", Font.BOLD, 17));
		label_17.setBounds(217, 350, 216, 50);
		panel_3.add(label_17);
		
		JLabel label_18 = new JLabel("12");
		label_18.setHorizontalAlignment(SwingConstants.CENTER);
		label_18.setFont(new Font("Lato Black", Font.BOLD, 17));
		label_18.setBounds(217, 400, 216, 50);
		panel_3.add(label_18);
		
		JLabel label_19 = new JLabel("13");
		label_19.setHorizontalAlignment(SwingConstants.CENTER);
		label_19.setFont(new Font("Lato Black", Font.BOLD, 17));
		label_19.setBounds(217, 450, 216, 50);
		panel_3.add(label_19);
		
		JLabel label_20 = new JLabel("14");
		label_20.setHorizontalAlignment(SwingConstants.CENTER);
		label_20.setFont(new Font("Lato Black", Font.BOLD, 17));
		label_20.setBounds(217, 500, 216, 50);
		panel_3.add(label_20);
		
		JLabel label_21 = new JLabel("15");
		label_21.setHorizontalAlignment(SwingConstants.CENTER);
		label_21.setFont(new Font("Lato Black", Font.BOLD, 17));
		label_21.setBounds(217, 550, 216, 50);
		panel_3.add(label_21);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(20, 113, 433, 600);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Samuditha Wijemanne\\Desktop\\91bQYhS1yQL._AC_UX500_.jpg"));
		lblNewLabel.setBounds(10, 5, 413, 289);
		panel_4.add(lblNewLabel);
		
		JLabel label_22 = new JLabel("");
		label_22.setIcon(new ImageIcon("C:\\Users\\Samuditha Wijemanne\\Desktop\\new.jpg"));
		label_22.setBounds(10, 305, 413, 289);
		panel_4.add(label_22);
		
		this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
		BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
		bi.setNorthPane(null);

	}
}
