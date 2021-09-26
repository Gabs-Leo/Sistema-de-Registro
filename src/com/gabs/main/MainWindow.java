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
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
	JComboBox comboBox = new JComboBox();
	Conexao instrucao = new Conexao();
	String ImgPath = null;
	
	//Conexão com SQL
	public Connection getConnection() {
		try {
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/objects", "root", "");
			System.out.println("Conectado!");
			return cn;
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//Fazer Imagem Caber no Container
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
	
	//Validação de Inputs
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
	
	//Instanciando e colocando em array os elementos do banco de dados.
	public ArrayList<Pistols> getPistolList(){
		ArrayList<Pistols> pistolList = new ArrayList<Pistols>();
		Connection cn = getConnection();
		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(instrucao.loadObjects());
			
			while(rs.next()) {
				Pistols pistol = new Pistols(rs.getInt("id"), rs.getString("name"), rs.getInt("price"), rs.getString("wall_penetration"), rs.getInt("balas_por_paint"), rs.getInt("balas_reserva"), rs.getInt("head"), rs.getInt("body"), rs.getInt("leg"), rs.getBytes("image"));
				pistolList.add(pistol);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pistolList;
	}
	
	//Preenchendo a tabela com os dados
	public void mostrarNaComboBox() {
		ArrayList<Pistols> al = getPistolList();
		for(int i = 0; i < al.size(); i++) {
			comboBox.addItem(al.get(i));
		}
		
	}
	
	//
	public void showItem(int index) {
		text_id.setText(Integer.toString(getPistolList().get(index).getId()));
		text_name.setText(getPistolList().get(index).getName());
		text_price.setText(Integer.toString(getPistolList().get(index).getPrice()));
		text_penetration.setText(getPistolList().get(index).getWallPenetration());
		text_bulletPP.setText(Integer.toString(getPistolList().get(index).getBalasPorPaint()));
		text_head.setText(Integer.toString(getPistolList().get(index).getHead()));
		text_body.setText(Integer.toString(getPistolList().get(index).getBody()));
		text_legs.setText(Integer.toString(getPistolList().get(index).getLeg()));
		Lbl_image.setIcon(resizeImage(null, getPistolList().get(index).getImage()));
	}
	
	//PSVM
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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

	//Criação do Frame
	public MainWindow() {
		getConnection();
		mostrarNaComboBox();
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
		
		
		comboBox.setBounds(8, 57, 395, 34);
		panel.add(comboBox);
		
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
		
		//Adicionar Item
		JButton btn_add = new JButton("");
		btn_add.setBackground(Color.DARK_GRAY);
		btn_add.setIcon(new ImageIcon(MainWindow.class.getResource("/com/gabs/icons/add.png")));
		btn_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkInputs() && ImgPath != null) {
					try {
						Connection con = getConnection();
						PreparedStatement addField = con.prepareStatement(instrucao.insertObject());
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
						mostrarNaComboBox();
						JOptionPane.showMessageDialog(null, "Produto Adicionado!");
					}catch(Exception exception) {
						exception.printStackTrace();
					}
				}else {
					JOptionPane.showMessageDialog(null, "Um ou mais campos estão vazios!");
				}
			}
		});
		btn_add.setBounds(180, 5, 45, 45);
		panel.add(btn_add);
		
		
		Lbl_image.setForeground(Color.MAGENTA);
		Lbl_image.setBackground(Color.MAGENTA);
		Lbl_image.setBounds(7, 106, 395, 261);
		panel.add(Lbl_image);
		
		//Atualizar Item
		JButton btn_refresh = new JButton("");
		btn_refresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkInputs() && text_id.getText() != null) {		
					PreparedStatement ps = null;
					Connection cn = getConnection();
					if(ImgPath == null) {
						try {
							ps = cn.prepareStatement(instrucao.updateQuery());
							ps.setString(1, text_name.getText());
							ps.setInt(2, Integer.parseInt(text_price.getText()));
							ps.setString(3, text_penetration.getText());
							ps.setInt(4, Integer.parseInt(text_bulletPP.getText()));
							ps.setInt(5, Integer.parseInt(text_totalBullet.getText()));
							ps.setInt(6, Integer.parseInt(text_head.getText()));
							ps.setInt(7, Integer.parseInt(text_body.getText()));
							ps.setInt(8, Integer.parseInt(text_legs.getText()));
							ps.setInt(9, Integer.parseInt(text_id.getText()));
							ps.executeUpdate();
							mostrarNaComboBox();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}else {
							try {
								InputStream img = new FileInputStream(new File(ImgPath));
								ps = cn.prepareStatement(instrucao.updateQueryImage());
								ps.setString(1, text_name.getText());
								ps.setInt(2, Integer.parseInt(text_price.getText()));
								ps.setString(3, text_penetration.getText());
								ps.setInt(4, Integer.parseInt(text_bulletPP.getText()));
								ps.setInt(5, Integer.parseInt(text_totalBullet.getText()));
								ps.setInt(6, Integer.parseInt(text_head.getText()));
								ps.setInt(7, Integer.parseInt(text_body.getText()));
								ps.setInt(8, Integer.parseInt(text_legs.getText()));
								ps.setBlob(9, img);
								ps.setInt(10, Integer.parseInt(text_id.getText()));
								ps.executeUpdate();
								mostrarNaComboBox();
							} catch (FileNotFoundException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
					}
				}else {
					JOptionPane.showMessageDialog(null, "Um ou mais campos preenchidos incorretamente!");
				}
				JOptionPane.showMessageDialog(null, "Alterações Salvas!");
			}
		});
		btn_refresh.setIcon(new ImageIcon(MainWindow.class.getResource("/com/gabs/icons/refresh.png")));
		btn_refresh.setBackground(Color.DARK_GRAY);
		btn_refresh.setBounds(239, 5, 45, 45);
		panel.add(btn_refresh);
		
		//Excluir Item
		JButton btnNewButton_1_1_1 = new JButton("");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!text_id.getText().equals("")) {
					try {
						Connection cn = getConnection();
						PreparedStatement ps = cn.prepareStatement(instrucao.deleteObject());
						int id = Integer.parseInt(text_id.getText());
						ps.setInt(1, id);
						ps.executeUpdate();
						mostrarNaComboBox();
						JOptionPane.showMessageDialog(null, "Item deletado com sucesso!");
					} catch (SQLException e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Falha ao excluir o item.");
					}
				}else {
					JOptionPane.showMessageDialog(null, "Falha ao excluir o item, sem ID para deletar.");
				}
			}
		});
		btnNewButton_1_1_1.setIcon(new ImageIcon(MainWindow.class.getResource("/com/gabs/icons/delete.png")));
		btnNewButton_1_1_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1_1_1.setBounds(298, 5, 45, 45);
		panel.add(btnNewButton_1_1_1);
		
		//Selecionar Imagem
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
