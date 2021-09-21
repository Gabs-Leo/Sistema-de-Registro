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
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.Box;
import java.awt.Font;
import javax.swing.JSplitPane;
import javax.swing.JList;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Component;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
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
		
		JLabel title = new JLabel("Pistolas");
		title.setFont(new Font("VALORANT", Font.PLAIN, 35));
		title.setForeground(Color.WHITE);
		title.setBounds(7, 2, 178, 62);
		panel.add(title);
		
		textField_1 = new JTextField();
		textField_1.setBackground(Color.GRAY);
		textField_1.setForeground(Color.LIGHT_GRAY);
		textField_1.setColumns(10);
		textField_1.setBounds(577, 57, 228, 32);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBackground(Color.GRAY);
		textField_2.setForeground(Color.LIGHT_GRAY);
		textField_2.setColumns(10);
		textField_2.setBounds(577, 107, 228, 32);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setBackground(Color.GRAY);
		textField_3.setForeground(Color.LIGHT_GRAY);
		textField_3.setColumns(10);
		textField_3.setBounds(679, 157, 126, 32);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setBackground(Color.GRAY);
		textField_4.setForeground(Color.LIGHT_GRAY);
		textField_4.setColumns(10);
		textField_4.setBounds(718, 203, 87, 32);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setBackground(Color.GRAY);
		textField_5.setForeground(Color.LIGHT_GRAY);
		textField_5.setColumns(10);
		textField_5.setBounds(743, 251, 61, 32);
		panel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setBackground(Color.GRAY);
		textField_6.setForeground(Color.LIGHT_GRAY);
		textField_6.setColumns(10);
		textField_6.setBounds(604, 305, 201, 32);
		panel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setBackground(Color.GRAY);
		textField_7.setForeground(Color.LIGHT_GRAY);
		textField_7.setColumns(10);
		textField_7.setBounds(587, 353, 218, 32);
		panel.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setBackground(Color.GRAY);
		textField_8.setForeground(Color.LIGHT_GRAY);
		textField_8.setColumns(10);
		textField_8.setBounds(577, 403, 228, 32);
		panel.add(textField_8);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(7, 200, 59, 235);
		panel.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(414, 7, 23, 430);
		panel.add(separator);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBounds(103, 101, 497, 350);
		panel.add(horizontalBox);
		
		Box verticalBox = Box.createVerticalBox();
		horizontalBox.add(verticalBox);
		
		JLabel lblName = new JLabel("Nome:");
		verticalBox.add(lblName);
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("VALORANT", Font.PLAIN, 30));
		
		JLabel lblName_1 = new JLabel("Preco:");
		verticalBox.add(lblName_1);
		lblName_1.setForeground(Color.WHITE);
		lblName_1.setFont(new Font("VALORANT", Font.PLAIN, 30));
		
		JLabel lblName_1_1 = new JLabel("Penetracao:");
		verticalBox.add(lblName_1_1);
		lblName_1_1.setForeground(Color.WHITE);
		lblName_1_1.setFont(new Font("VALORANT", Font.PLAIN, 30));
		
		JLabel lblName_1_1_1_1 = new JLabel("Balas Reserva:");
		verticalBox.add(lblName_1_1_1_1);
		lblName_1_1_1_1.setForeground(Color.WHITE);
		lblName_1_1_1_1.setFont(new Font("VALORANT", Font.PLAIN, 30));
		
		JLabel lblName_1_1_1 = new JLabel("Balas Por Paint:");
		verticalBox.add(lblName_1_1_1);
		lblName_1_1_1.setForeground(Color.WHITE);
		lblName_1_1_1.setFont(new Font("VALORANT", Font.PLAIN, 30));
		
		JLabel lblName_1_1_1_1_1 = new JLabel("cabeca:");
		verticalBox.add(lblName_1_1_1_1_1);
		lblName_1_1_1_1_1.setForeground(Color.WHITE);
		lblName_1_1_1_1_1.setFont(new Font("VALORANT", Font.PLAIN, 30));
		
		JLabel lblName_1_1_1_1_1_1 = new JLabel("corpo:");
		verticalBox.add(lblName_1_1_1_1_1_1);
		lblName_1_1_1_1_1_1.setForeground(Color.WHITE);
		lblName_1_1_1_1_1_1.setFont(new Font("VALORANT", Font.PLAIN, 30));
		
		JLabel lblName_1_1_1_1_1_1_1 = new JLabel("perna:");
		verticalBox.add(lblName_1_1_1_1_1_1_1);
		lblName_1_1_1_1_1_1_1.setForeground(Color.WHITE);
		lblName_1_1_1_1_1_1_1.setFont(new Font("VALORANT", Font.PLAIN, 30));
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		horizontalBox_1.setBounds(52, 59, 336, 32);
		panel.add(horizontalBox_1);
		
		JLabel id = new JLabel("Id: ");
		horizontalBox_1.add(id);
		id.setForeground(Color.WHITE);
		id.setFont(new Font("VALORANT", Font.PLAIN, 30));
		
		textField = new JTextField();
		horizontalBox_1.add(textField);
		textField.setBackground(Color.GRAY);
		textField.setForeground(Color.LIGHT_GRAY);
		textField.setColumns(10);
	}
}
