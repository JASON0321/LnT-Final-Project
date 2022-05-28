import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Random;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Frame extends JFrame implements ActionListener {
	
	Connect con = new Connect();
	
	Vector<Menu> menu = new Vector<>();
	
	String codeMenu = "";
	JLabel title, title2, title3, title4, title5, kodeMenu, kode, namaMenu, hargaMenu, stokMenu, indexNum;
	JTextField tnamaMenu;
	JButton insert, view, update, delete, back, confirm, confirm2, confirm3;
	JTable table;
	JScrollPane sc;
	JFormattedTextField thargaMenu, tstokMenu, tindexNum;
	
	public Frame() {
		getMenu();
		settings();
		initComponent();
		mainMenu();
		setVisible(true);
	}
	
	public void initComponent() {
		title = new JLabel("PT Pudding");
		
		insert = new JButton("Insert Menu");
		insert.addActionListener(this);
		view = new JButton("View Menu");
		view.addActionListener(this);
		update = new JButton("Update Menu");
		update.addActionListener(this);
		delete = new JButton("Delete Menu");
		delete.addActionListener(this);
		
		back = new JButton("Back To Main Menu");
		back.setFocusable(false);
		back.addActionListener(this);
		back.setFont(back.getFont().deriveFont(17f));
		
		title.setFont(title.getFont().deriveFont(50f));
		
		insert.setFont(insert.getFont().deriveFont(17f));
		insert.setFocusable(false);
		view.setFont(view.getFont().deriveFont(17f));
		view.setFocusable(false);
		update.setFont(update.getFont().deriveFont(17f));
		update.setFocusable(false);
		delete.setFont(delete.getFont().deriveFont(17f));
		delete.setFocusable(false);
		
		
		title.setBounds(250, 30, 278, 60);
		insert.setBounds(310, 180, 150, 30);
		view.setBounds(310, 215, 150, 30);
		update.setBounds(310, 250, 150, 30);
		delete.setBounds(310, 285, 150, 30);
	}
	
	public void mainMenu() {
		add(title);
		add(insert);
		add(view);
		add(update);
		add(delete);
	}
	
	public void insertMenu() {
		codeMenu = createCode();
		
		title2 = new JLabel("Insert Menu");
		kodeMenu = new JLabel("Kode Menu:");
		kode = new JLabel(codeMenu);
		namaMenu = new JLabel("Nama Menu:");
		hargaMenu = new JLabel("Harga Menu:");
		stokMenu = new JLabel("Stok Menu:");
		
		tnamaMenu = new JTextField();
		thargaMenu = new JFormattedTextField(NumberFormat.getNumberInstance());
		tstokMenu = new JFormattedTextField(NumberFormat.getNumberInstance());
		
		confirm = new JButton("Confirm");
		confirm.setFocusable(false);
		confirm.addActionListener(this);
		confirm.setFont(confirm.getFont().deriveFont(17f));
		
		title2.setFont(title2.getFont().deriveFont(50f));
		kodeMenu.setFont(kodeMenu.getFont().deriveFont(18f));
		kode.setFont(kode.getFont().deriveFont(18f));
		namaMenu.setFont(namaMenu.getFont().deriveFont(18f));
		tnamaMenu.setFont(tnamaMenu.getFont().deriveFont(18f));
		hargaMenu.setFont(hargaMenu.getFont().deriveFont(18f));
		thargaMenu.setFont(thargaMenu.getFont().deriveFont(18f));
		stokMenu.setFont(stokMenu.getFont().deriveFont(18f));
		tstokMenu.setFont(tstokMenu.getFont().deriveFont(18f));
		
		title2.setBounds(250, 30, 300, 60);
		kodeMenu.setBounds(160, 170, 110, 25);
		kode.setBounds(310, 170, 310, 25);
		namaMenu.setBounds(160, 220, 110, 25);
		tnamaMenu.setBounds(310, 220, 310, 25);
		hargaMenu.setBounds(160, 270, 110, 25);
		thargaMenu.setBounds(310, 270, 310, 25);
		stokMenu.setBounds(160, 320, 110, 25);
		tstokMenu.setBounds(310, 320, 310, 25);
		confirm.setBounds(160, 370, 210, 30);
		back.setBounds(160, 420, 210, 30);
		
		add(title2);
		add(kodeMenu);
		add(kode);
		add(namaMenu);
		add(tnamaMenu);
		add(hargaMenu);
		add(thargaMenu);
		add(stokMenu);
		add(tstokMenu);
		add(confirm);
		add(back);
	}
	
	public void createTable() {
		Vector<String> columns = new Vector<>();
		columns.add("No.");
		columns.add("Kode Menu");
		columns.add("Nama Menu");
		columns.add("Harga Menu");
		columns.add("Stok Menu");
		
		Vector<Vector> rows = new Vector<>();
		
		for (int i = 0; i < menu.size(); i++) {
			Vector<String> row = new Vector<>();
			row.add(String.valueOf(i+1));
			row.add(menu.get(i).getKodeMenu());
			row.add(menu.get(i).getNamaMenu());
			row.add(String.valueOf(menu.get(i).getHargaMenu()));
			row.add(String.valueOf(menu.get(i).getStokMenu()));
			
			rows.add(row);
		}
 		
		Vector<Vector> data = new Vector<>();
		
		for (int i = 0; i < rows.size(); i++) {
			data.add(rows.get(i));
		}
		
		table = new JTable(data, columns) {
			public boolean isCellEditable(int data, int columns) {
				return false;
			}
		};
		
		table.setPreferredScrollableViewportSize(new Dimension(700, 400));
		table.setFillsViewportHeight(true);
		
	    sc = new JScrollPane(table);
	}
	
	public void viewMenu() {
		createTable();
		title3 = new JLabel("View Menu");
		
		title3.setFont(title3.getFont().deriveFont(50f));
		
		title3.setBounds(259, 30, 260, 60);
		sc.setBounds(50, 100, 700, 400);
		back.setBounds(250, 510, 300, 30);
	    
		add(title3);
		add(sc);
		add(back);
	}
	
	public void updateMenu() {
		createTable();
		title4 = new JLabel("Update Menu");
		indexNum = new JLabel("Input Number to Update:");
		hargaMenu = new JLabel("Harga Menu:");
		stokMenu = new JLabel("Stok Menu:");
		
		tindexNum = new JFormattedTextField(NumberFormat.getInstance());
		thargaMenu = new JFormattedTextField(NumberFormat.getInstance());
		tstokMenu = new JFormattedTextField(NumberFormat.getInstance());
		
		confirm2 = new JButton("Confirm");
		confirm2.setFocusable(false);
		confirm2.addActionListener(this);
		
		title4.setFont(title4.getFont().deriveFont(50f));
		indexNum.setFont(indexNum.getFont().deriveFont(15f));
		tindexNum.setFont(tindexNum.getFont().deriveFont(15f));
		hargaMenu.setFont(hargaMenu.getFont().deriveFont(15f));
		thargaMenu.setFont(thargaMenu.getFont().deriveFont(15f));
		stokMenu.setFont(stokMenu.getFont().deriveFont(15f));
		tstokMenu.setFont(tstokMenu.getFont().deriveFont(15f));
		confirm2.setFont(confirm2.getFont().deriveFont(17f));
		
		title4.setBounds(245, 30, 320, 60);
		indexNum.setBounds(50, 360, 200, 25);
		tindexNum.setBounds(250, 360, 200, 25);
		hargaMenu.setBounds(50, 390, 200, 25);
		thargaMenu.setBounds(250, 390, 200, 25);
		stokMenu.setBounds(50, 420, 200, 25);
		tstokMenu.setBounds(250, 420, 200, 25);
		sc.setBounds(50, 100, 700, 250);
		confirm2.setBounds(50, 450, 200, 30);
		back.setBounds(250, 510, 300, 30);
	    
		add(title4);
		add(indexNum);
		add(tindexNum);
		add(hargaMenu);
		add(thargaMenu);
		add(stokMenu);
		add(tstokMenu);
		add(sc);
		add(confirm2);
		add(back);
	}
	
	public void deleteMenu() {
		createTable();
		title5 = new JLabel("Delete Menu");
		indexNum = new JLabel("Input Number to Delete:");
		
		tindexNum = new JFormattedTextField(NumberFormat.getInstance());
		
		confirm3 = new JButton("Confirm");
		confirm3.setFocusable(false);
		confirm3.addActionListener(this);
		
		title5.setFont(title5.getFont().deriveFont(50f));
		indexNum.setFont(indexNum.getFont().deriveFont(15f));
		tindexNum.setFont(tindexNum.getFont().deriveFont(15f));
		confirm3.setFont(confirm3.getFont().deriveFont(17f));
		
		title5.setBounds(245, 30, 320, 60);
		indexNum.setBounds(50, 360, 200, 25);
		tindexNum.setBounds(250, 360, 200, 25);
		sc.setBounds(50, 100, 700, 250);
		confirm3.setBounds(50, 390, 200, 30);
		back.setBounds(250, 510, 300, 30);
	    
		add(title5);
		add(indexNum);
		add(tindexNum);
		add(sc);
		add(confirm3);
		add(back);
	}
	
	public void settings() {
		setLayout(null);
		setSize(800, 600);
		setResizable(false);
		setTitle("PT Pudding");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == insert) {
			getContentPane().removeAll();
			repaint();
			insertMenu();
		}
		else if (e.getSource() == view) {
			getContentPane().removeAll();
			repaint();
			viewMenu();
		}
		else if (e.getSource() == update) {
			getContentPane().removeAll();
			repaint();
			updateMenu();
		}
		else if (e.getSource() == delete) {
			getContentPane().removeAll();
			repaint();
			deleteMenu();
		}
		
		if (e.getSource() == confirm) {
			String menuName = tnamaMenu.getText();
			
			if (menuName.isEmpty() || thargaMenu.getText().isEmpty() || tstokMenu.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Text Field Cannot be Empty", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				int menuPrice, menuStock = 0;
				if (thargaMenu.getValue() == null) {
					menuPrice = Integer.parseInt(thargaMenu.getText());
				} else {
					menuPrice = ((Number) thargaMenu.getValue()).intValue();
				}
				
				if (tstokMenu.getValue() == null) {
					menuStock = Integer.parseInt(tstokMenu.getText());
				} else {
					menuStock = ((Number) tstokMenu.getValue()).intValue();
				}
				
				insert(codeMenu, menuName, menuPrice, menuStock);
				Menu newMenu = new Menu(codeMenu, menuName, menuPrice, menuStock);
				menu.add(newMenu);
				JOptionPane.showMessageDialog(null, "Menu Inserted Successfully", "Success", JOptionPane.PLAIN_MESSAGE);
				getContentPane().removeAll();
				repaint();
				insertMenu();
			}
		}
		
		if (e.getSource() == confirm2) {
			String numIndex = tindexNum.getText();
			
			if (thargaMenu.getText().isEmpty() || tstokMenu.getText().isEmpty() || numIndex.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Text Field Cannot be Empty", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				int idx = 0;
				if(tindexNum.getValue() == null) {
					idx = Integer.parseInt(numIndex)-1;
				} else {
					idx = ((Number) tindexNum.getValue()).intValue()-1;
				}
				
				if (idx > (menu.size()-1)) {
					JOptionPane.showMessageDialog(null, "Menu doesn't exist", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					int menuPrice, menuStock = 0;
					if (thargaMenu.getValue() == null) {
						menuPrice = Integer.parseInt(thargaMenu.getText());
					} else {
						menuPrice = ((Number) thargaMenu.getValue()).intValue();
					}
					
					if (tstokMenu.getValue() == null) {
						menuStock = Integer.parseInt(tstokMenu.getText());
					} else {
						menuStock = ((Number) tstokMenu.getValue()).intValue();
					}
					
					update(menu.get(idx).getKodeMenu(), menuPrice, menuStock);
					menu.get(idx).setHargaMenu(menuPrice);
					menu.get(idx).setStokMenu(menuStock);
					JOptionPane.showMessageDialog(null, "Menu Updated Successfully", "Success", JOptionPane.PLAIN_MESSAGE);
					getContentPane().removeAll();
					repaint();
					updateMenu();
				}
			}
		}
		
		if (e.getSource() == confirm3) {
			String numIndex = tindexNum.getText();
			
			if (numIndex.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Text Field Cannot be Empty", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				int idx = 0;
				if(tindexNum.getValue() == null) {
					idx = Integer.parseInt(numIndex)-1;
				} else {
					idx = ((Number) tindexNum.getValue()).intValue()-1;
				}
				if (idx > (menu.size()-1)) {
					JOptionPane.showMessageDialog(null, "Menu doesn't exist", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					delete(menu.get(idx).getKodeMenu());
					menu.remove(idx);
					JOptionPane.showMessageDialog(null, "Menu Deleted Successfully", "Success", JOptionPane.PLAIN_MESSAGE);
					getContentPane().removeAll();
					repaint();
					deleteMenu();
				}
			}
		}
		
		if (e.getSource() == back) {
			getContentPane().removeAll();
			repaint();
			mainMenu();
		}
	}

	String createCode() {
		Random rand = new Random();
		String code = "PD-";
		boolean isUnique;
		
		do {
			for (int i = 0; i < 3; i++) {
				code = code + (rand.nextInt(10));
			}
			isUnique = true;
			
			for (Menu menu2 : menu) {
				if (menu2.getKodeMenu().equals(code)) {
					code = "PD-";
					isUnique = false;
				}				
			}
		} while(!isUnique);
		return code;
	}
	
	public void getMenu() {
		try {
			ResultSet rs = con.executeQuery("SELECT * From menu");
			while(rs.next()) {
				String kode = rs.getString(1);
				String nama = rs.getString(2);
				int harga = rs.getInt(3);
				int stok = rs.getInt(4);
				Menu menus = new Menu(kode, nama, harga, stok);
				menu.add(menus);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insert(String kode, String nama, int harga, int stok) {
		try {
			PreparedStatement ps = con.prepareStatement("INSERT INTO menu VALUES(?,?,?,?)");
			ps.setString(1, kode);
			ps.setString(2, nama);
			ps.setInt(3, harga);
			ps.setInt(4, stok);
			ps.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void update(String kode, int harga, int stok) {
		try {
			PreparedStatement ps = con.prepareStatement("UPDATE menu SET Harga = ?, Stok = ? WHERE Kode = ?");
			ps.setInt(1, harga);
			ps.setInt(2, stok);
			ps.setString(3, kode);
			ps.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void delete(String kode) {
		try {
			PreparedStatement ps = con.prepareStatement("DELETE FROM menu WHERE Kode = ?");
			ps.setString(1, kode);
			ps.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
