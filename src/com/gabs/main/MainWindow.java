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
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import com.gabs.sql.Conexao;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	
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
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sql.connect();
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
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setEditable(false);
		labelID.add(textField);
		textField.setBackground(Color.GRAY);
		textField.setForeground(Color.WHITE);
		textField.setColumns(10);
		
		Box labelNome = Box.createHorizontalBox();
		labelNome.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		verticalBox.add(labelNome);
		
		JLabel lblName = new JLabel("Nome: ");
		labelNome.add(lblName);
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("VALORANT", Font.PLAIN, 30));
		
		textField_9 = new JTextField();
		textField_9.setHorizontalAlignment(SwingConstants.CENTER);
		textField_9.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_9.setForeground(Color.WHITE);
		textField_9.setColumns(10);
		textField_9.setBackground(Color.GRAY);
		labelNome.add(textField_9);
		
		Box horizontalBox_1_2 = Box.createHorizontalBox();
		horizontalBox_1_2.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		verticalBox.add(horizontalBox_1_2);
		
		JLabel lblName_1 = new JLabel("Preco: ");
		horizontalBox_1_2.add(lblName_1);
		lblName_1.setForeground(Color.WHITE);
		lblName_1.setFont(new Font("VALORANT", Font.PLAIN, 30));
		
		textField_10 = new JTextField();
		textField_10.setHorizontalAlignment(SwingConstants.CENTER);
		textField_10.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_10.setForeground(Color.WHITE);
		textField_10.setColumns(10);
		textField_10.setBackground(Color.GRAY);
		horizontalBox_1_2.add(textField_10);
		
		Box labelBalasPorPaint = Box.createHorizontalBox();
		labelBalasPorPaint.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		verticalBox.add(labelBalasPorPaint);
		
		JLabel lblName_1_1_1 = new JLabel("Balas Por Pente: ");
		labelBalasPorPaint.add(lblName_1_1_1);
		lblName_1_1_1.setForeground(Color.WHITE);
		lblName_1_1_1.setFont(new Font("VALORANT", Font.PLAIN, 30));
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_2.setForeground(Color.WHITE);
		textField_2.setColumns(10);
		textField_2.setBackground(Color.GRAY);
		labelBalasPorPaint.add(textField_2);
		
		Box horizontalBox_1_2_2 = Box.createHorizontalBox();
		horizontalBox_1_2_2.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		verticalBox.add(horizontalBox_1_2_2);
		
		JLabel lblName_1_1_1_1 = new JLabel("Balas Reserva: ");
		horizontalBox_1_2_2.add(lblName_1_1_1_1);
		lblName_1_1_1_1.setForeground(Color.WHITE);
		lblName_1_1_1_1.setFont(new Font("VALORANT", Font.PLAIN, 30));
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setForeground(Color.WHITE);
		textField_1.setColumns(10);
		textField_1.setBackground(Color.GRAY);
		horizontalBox_1_2_2.add(textField_1);
		
		Box horizontalBox_1_2_1 = Box.createHorizontalBox();
		horizontalBox_1_2_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		verticalBox.add(horizontalBox_1_2_1);
		
		JLabel lblName_1_1 = new JLabel("Penetracao: ");
		horizontalBox_1_2_1.add(lblName_1_1);
		lblName_1_1.setForeground(Color.WHITE);
		lblName_1_1.setFont(new Font("VALORANT", Font.PLAIN, 30));
		
		textField_11 = new JTextField();
		textField_11.setHorizontalAlignment(SwingConstants.CENTER);
		textField_11.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_11.setForeground(Color.WHITE);
		textField_11.setColumns(10);
		textField_11.setBackground(Color.GRAY);
		horizontalBox_1_2_1.add(textField_11);
		
		Box horizontalBox_1_2_4 = Box.createHorizontalBox();
		horizontalBox_1_2_4.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		verticalBox.add(horizontalBox_1_2_4);
		
		JLabel lblName_1_1_1_1_1 = new JLabel("cabeca: ");
		horizontalBox_1_2_4.add(lblName_1_1_1_1_1);
		lblName_1_1_1_1_1.setForeground(Color.WHITE);
		lblName_1_1_1_1_1.setFont(new Font("VALORANT", Font.PLAIN, 30));
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_3.setForeground(Color.WHITE);
		textField_3.setColumns(10);
		textField_3.setBackground(Color.GRAY);
		horizontalBox_1_2_4.add(textField_3);
		
		Box horizontalBox_1_2_5 = Box.createHorizontalBox();
		horizontalBox_1_2_5.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		verticalBox.add(horizontalBox_1_2_5);
		
		JLabel lblName_1_1_1_1_1_1 = new JLabel("corpo: ");
		horizontalBox_1_2_5.add(lblName_1_1_1_1_1_1);
		lblName_1_1_1_1_1_1.setForeground(Color.WHITE);
		lblName_1_1_1_1_1_1.setFont(new Font("VALORANT", Font.PLAIN, 30));
		
		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_4.setForeground(Color.WHITE);
		textField_4.setColumns(10);
		textField_4.setBackground(Color.GRAY);
		horizontalBox_1_2_5.add(textField_4);
		
		Box horizontalBox_1_3 = Box.createHorizontalBox();
		horizontalBox_1_3.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		verticalBox.add(horizontalBox_1_3);
		
		JLabel lblName_1_1_1_1_1_1_1 = new JLabel("perna: ");
		horizontalBox_1_3.add(lblName_1_1_1_1_1_1_1);
		lblName_1_1_1_1_1_1_1.setForeground(Color.WHITE);
		lblName_1_1_1_1_1_1_1.setFont(new Font("VALORANT", Font.PLAIN, 30));
		
		textField_5 = new JTextField();
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_5.setForeground(Color.WHITE);
		textField_5.setColumns(10);
		textField_5.setBackground(Color.GRAY);
		horizontalBox_1_3.add(textField_5);
		
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
				}else {
					System.out.println("Nem um arquivo adicionado!");
				}
			}
		});
		Btn_Select_Image.setBounds(7, 383, 395, 52);
		panel.add(Btn_Select_Image);
		
		
	}
}
