package com.gabs.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.Box;
import java.awt.Font;
import javax.swing.JSplitPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.border.SoftBevelBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import com.gabs.sql.Conexao;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JTextField text_id;
	private JTextField text_name;
	private JTextField text_price;
	private JTextField text_penetration;
	private JTextField text_totalBullet;
	private JTextField text_bulletPP;
	private JTextField text_head;
	private JTextField text_body;
	private JTextField text_legs;
	
	JLabel Lbl_image = new JLabel("");
	public static Conexao sql = new Conexao();
	String ImgPath = null;
	
	//System to size image for the container
	public ImageIcon resizeImage(String imagePath, byte[] pic) {
		ImageIcon myImage = null;
		
		if(imagePath != null) {
			myImage = new ImageIcon(imagePath);
		}else {
			myImage = new ImageIcon(pic);
		}
		
		Image img = myImage.getImage();
		Image img2 = img.getScaledInstance(Lbl_image.getWidth(), Lbl_image.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(img2);
		return image;
	}
	
	public boolean checkInputs() {
		if(text_name.getText() == null
		|| text_price.getText() == null
		|| text_bulletPP.getText() == null
		|| text_totalBullet.getText() == null
		|| text_penetration.getText() == null
		|| text_head.getText() == null
		|| text_body.getText() == null
		|| text_legs.getText() == null){
			return false;
		}else {
			try {
				Integer.parseInt(text_price.getText());
				Integer.parseInt(text_bulletPP.getText());
				Integer.parseInt(text_totalBullet.getText());
				Integer.parseInt(text_head.getText());
				Integer.parseInt(text_body.getText());
				Integer.parseInt(text_legs.getText());
				return true;
			}catch(Exception e) {
				return false;
			}
		}
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sql.getConnection();
					MainWindow frame = new MainWindow();
					frame.setTitle("Valorant Pistols");
					frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/com/gabs/icons/icon.png")));
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
	public MainWindow() {
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 493);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		contentPane.add(panel);
		panel.setLayout(null);
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBounds(432, 7, 367, 429);
		panel.add(verticalBox);
		
		Box labelID = Box.createHorizontalBox();
		labelID.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		verticalBox.add(labelID);
		
		JLabel id = new JLabel("Id: ");
		labelID.add(id);
		id.setForeground(Color.WHITE);
		id.setFont(new Font("VALORANT", Font.PLAIN, 30));
		
		text_id = new JTextField();
		text_id.setHorizontalAlignment(SwingConstants.CENTER);
		text_id.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text_id.setEditable(false);
		labelID.add(text_id);
		text_id.setBackground(Color.GRAY);
		text_id.setForeground(Color.WHITE);
		text_id.setColumns(10);
		
		Box labelNome = Box.createHorizontalBox();
		labelNome.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		verticalBox.add(labelNome);
		
		JLabel lblName = new JLabel("Nome: ");
		labelNome.add(lblName);
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("VALORANT", Font.PLAIN, 30));
		
		text_name = new JTextField();
		text_name.setHorizontalAlignment(SwingConstants.CENTER);
		text_name.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text_name.setForeground(Color.WHITE);
		text_name.setColumns(10);
		text_name.setBackground(Color.GRAY);
		labelNome.add(text_name);
		
		Box horizontalBox_1_2 = Box.createHorizontalBox();
		horizontalBox_1_2.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		verticalBox.add(horizontalBox_1_2);
		
		JLabel lblName_1 = new JLabel("Preco: ");
		horizontalBox_1_2.add(lblName_1);
		lblName_1.setForeground(Color.WHITE);
		lblName_1.setFont(new Font("VALORANT", Font.PLAIN, 30));
		
		text_price = new JTextField();
		text_price.setHorizontalAlignment(SwingConstants.CENTER);
		text_price.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text_price.setForeground(Color.WHITE);
		text_price.setColumns(10);
		text_price.setBackground(Color.GRAY);
		horizontalBox_1_2.add(text_price);
		
		Box labelBalasPorPaint = Box.createHorizontalBox();
		labelBalasPorPaint.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		verticalBox.add(labelBalasPorPaint);
		
		JLabel lblName_1_1_1 = new JLabel("Balas Por Pente: ");
		labelBalasPorPaint.add(lblName_1_1_1);
		lblName_1_1_1.setForeground(Color.WHITE);
		lblName_1_1_1.setFont(new Font("VALORANT", Font.PLAIN, 30));
		
		text_bulletPP = new JTextField();
		text_bulletPP.setHorizontalAlignment(SwingConstants.CENTER);
		text_bulletPP.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text_bulletPP.setForeground(Color.WHITE);
		text_bulletPP.setColumns(10);
		text_bulletPP.setBackground(Color.GRAY);
		labelBalasPorPaint.add(text_bulletPP);
		
		Box horizontalBox_1_2_2 = Box.createHorizontalBox();
		horizontalBox_1_2_2.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		verticalBox.add(horizontalBox_1_2_2);
		
		JLabel lblName_1_1_1_1 = new JLabel("Balas Reserva: ");
		horizontalBox_1_2_2.add(lblName_1_1_1_1);
		lblName_1_1_1_1.setForeground(Color.WHITE);
		lblName_1_1_1_1.setFont(new Font("VALORANT", Font.PLAIN, 30));
		
		text_totalBullet = new JTextField();
		text_totalBullet.setHorizontalAlignment(SwingConstants.CENTER);
		text_totalBullet.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text_totalBullet.setForeground(Color.WHITE);
		text_totalBullet.setColumns(10);
		text_totalBullet.setBackground(Color.GRAY);
		horizontalBox_1_2_2.add(text_totalBullet);
		
		Box horizontalBox_1_2_1 = Box.createHorizontalBox();
		horizontalBox_1_2_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		verticalBox.add(horizontalBox_1_2_1);
		
		JLabel lblName_1_1 = new JLabel("Penetracao: ");
		horizontalBox_1_2_1.add(lblName_1_1);
		lblName_1_1.setForeground(Color.WHITE);
		lblName_1_1.setFont(new Font("VALORANT", Font.PLAIN, 30));
		
		text_penetration = new JTextField();
		text_penetration.setHorizontalAlignment(SwingConstants.CENTER);
		text_penetration.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text_penetration.setForeground(Color.WHITE);
		text_penetration.setColumns(10);
		text_penetration.setBackground(Color.GRAY);
		horizontalBox_1_2_1.add(text_penetration);
		
		Box horizontalBox_1_2_4 = Box.createHorizontalBox();
		horizontalBox_1_2_4.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		verticalBox.add(horizontalBox_1_2_4);
		
		JLabel lblName_1_1_1_1_1 = new JLabel("cabeca: ");
		horizontalBox_1_2_4.add(lblName_1_1_1_1_1);
		lblName_1_1_1_1_1.setForeground(Color.WHITE);
		lblName_1_1_1_1_1.setFont(new Font("VALORANT", Font.PLAIN, 30));
		
		text_head = new JTextField();
		text_head.setHorizontalAlignment(SwingConstants.CENTER);
		text_head.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text_head.setForeground(Color.WHITE);
		text_head.setColumns(10);
		text_head.setBackground(Color.GRAY);
		horizontalBox_1_2_4.add(text_head);
		
		Box horizontalBox_1_2_5 = Box.createHorizontalBox();
		horizontalBox_1_2_5.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		verticalBox.add(horizontalBox_1_2_5);
		
		JLabel lblName_1_1_1_1_1_1 = new JLabel("corpo: ");
		horizontalBox_1_2_5.add(lblName_1_1_1_1_1_1);
		lblName_1_1_1_1_1_1.setForeground(Color.WHITE);
		lblName_1_1_1_1_1_1.setFont(new Font("VALORANT", Font.PLAIN, 30));
		
		text_body = new JTextField();
		text_body.setHorizontalAlignment(SwingConstants.CENTER);
		text_body.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text_body.setForeground(Color.WHITE);
		text_body.setColumns(10);
		text_body.setBackground(Color.GRAY);
		horizontalBox_1_2_5.add(text_body);
		
		Box horizontalBox_1_3 = Box.createHorizontalBox();
		horizontalBox_1_3.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		verticalBox.add(horizontalBox_1_3);
		
		JLabel lblName_1_1_1_1_1_1_1 = new JLabel("perna: ");
		horizontalBox_1_3.add(lblName_1_1_1_1_1_1_1);
		lblName_1_1_1_1_1_1_1.setForeground(Color.WHITE);
		lblName_1_1_1_1_1_1_1.setFont(new Font("VALORANT", Font.PLAIN, 30));
		
		text_legs = new JTextField();
		text_legs.setHorizontalAlignment(SwingConstants.CENTER);
		text_legs.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text_legs.setForeground(Color.WHITE);
		text_legs.setColumns(10);
		text_legs.setBackground(Color.GRAY);
		horizontalBox_1_3.add(text_legs);
		
		JLabel title = new JLabel("Pistolas");
		title.setBounds(7, 11, 167, 40);
		panel.add(title);
		title.setFont(new Font("VALORANT", Font.PLAIN, 35));
		title.setForeground(Color.WHITE);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(8, 57, 395, 34);
		panel.add(comboBox);
		


		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.setIcon(new ImageIcon(MainWindow.class.getResource("/com/gabs/icons/add.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkInputs() && ImgPath != null) {
					sql.getConnection();
					try {
						PreparedStatement addField = sql.insertObject();
						addField.setString(1, text_name.getText());
						addField.setString(2, text_price.getText());
						addField.setString(3, text_penetration.getText());
						addField.setString(4, text_bulletPP.getText());
						addField.setString(5, text_totalBullet.getText());
						addField.setString(6, text_head.getText());
						addField.setString(7, text_body.getText());
						addField.setString(8, text_legs.getText());
						InputStream img = new FileInputStream(new File(ImgPath));
						addField.setBlob(9, img);
						addField.executeUpdate();
					}catch(Exception exception) {
						exception.printStackTrace();
					}
				}else {
					JOptionPane.showMessageDialog(null, "Um ou mais campos estão vazios!");
				}
			}
		});
		btnNewButton_1.setBounds(180, 5, 45, 45);
		panel.add(btnNewButton_1);
		
		
		Lbl_image.setForeground(Color.MAGENTA);
		Lbl_image.setBackground(Color.MAGENTA);
		Lbl_image.setBounds(7, 106, 395, 261);
		panel.add(Lbl_image);
		
		JButton btnNewButton_1_1 = new JButton("");
		btnNewButton_1_1.setIcon(new ImageIcon(MainWindow.class.getResource("/com/gabs/icons/refresh.png")));
		btnNewButton_1_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1_1.setBounds(239, 5, 45, 45);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("");
		btnNewButton_1_1_1.setIcon(new ImageIcon(MainWindow.class.getResource("/com/gabs/icons/delete.png")));
		btnNewButton_1_1_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1_1_1.setBounds(298, 5, 45, 45);
		panel.add(btnNewButton_1_1_1);
		
		JButton Btn_Select_Image = new JButton("Escolher Imagem");
		Btn_Select_Image.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Btn_Select_Image.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser file = new JFileChooser();
				file.setCurrentDirectory(new File(System.getProperty("user.home")));
				
				FileNameExtensionFilter filter = new FileNameExtensionFilter("*.image", "jpg", "png");
				file.addChoosableFileFilter(filter);
				int result = file.showSaveDialog(null);
				
				if(result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = file.getSelectedFile();
					String path = selectedFile.getAbsolutePath();
					Lbl_image.setIcon(resizeImage(path, null));
					ImgPath = path;
				}else {
					System.out.println("Nem um arquivo adicionado!");
				}
			}
		});
		Btn_Select_Image.setBounds(7, 383, 395, 52);
		panel.add(Btn_Select_Image);
		
		
	}

}
