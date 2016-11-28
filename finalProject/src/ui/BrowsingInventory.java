package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.DropMode;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import dto.Inventory;
import dto.Vehicle;
import service.InventoryManager;


import java.awt.Color;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.Box;

public class BrowsingInventory extends JFrame {

	private JPanel contentPane;
	private JPanel topPanel;
	private JPanel midPanel;

	protected JScrollPane scrollPane;
	protected JTable table;

	private JLabel pic;



	private String dealerID;
	private InventoryManager inventoryManager = new InventoryManager();
	private Inventory inventory;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BrowsingInventory frame = new BrowsingInventory("");
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
	public BrowsingInventory(String dealerID) {

		this.dealerID = dealerID;
		inventory = inventoryManager.getInventoryByDealerID(dealerID);


		create();
		setFeatures();
		addListener();

		Dimension screenDimen = Toolkit.getDefaultToolkit().getScreenSize();
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		this.setLocation((int)(screenDimen.getWidth() - this.getWidth()) / 2, (int)(screenDimen.getHeight() - this.getHeight()) / 2);
		this.setVisible(true);
	}




	private void create() {

		topPanel = new JPanel();
		midPanel = new JPanel();

		table = addInfoToTable(inventory.getAllVehicles());
		scrollPane = new JScrollPane(table);

		contentPane = new JPanel();
		contentPane.add(topPanel);
		contentPane.add(midPanel);
		contentPane.add(Box.createVerticalStrut(10)); 
		contentPane.add(scrollPane);

		ImageIcon image = new ImageIcon("/Users/xiaoyue/NEU_2016FALL__InformationSystem/INFO5100_JAVA/Assigments/finalProject/data/birds.gif");
		image.setImage(image.getImage().getScaledInstance(391,180,Image.SCALE_DEFAULT));
		pic = new JLabel(image);
		topPanel.add(pic);



		;
		midPanel.add(Box.createHorizontalGlue());





	}

	private void setFeatures() {

		setContentPane(contentPane);
		setBounds(100, 100, 762, 395);

		contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		contentPane.setBackground(Color.white);

		topPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 2, 1));
		topPanel.setBackground(Color.WHITE);

		midPanel.setBorder(new LineBorder(new Color(204, 204, 204), 2, true));
		midPanel.setLayout(new BoxLayout(midPanel, BoxLayout.X_AXIS));
		midPanel.setBackground(Color.GRAY);



		table.setRowHeight(30);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setPreferredSize(new Dimension(800, 900));



	}



	private JTable addInfoToTable(Collection<Vehicle> vehicles) {
		String columnNamesLine = "id~webId~category~year~make~model~trim~type~price";
		String[] columnName =  columnNamesLine.split("~");
		
		String[][] data = new String[vehicles.size()][];
		System.out.println("%%%" + vehicles.size());

		int idx = 0;
		for (Vehicle ve: vehicles) {
			data[idx] = ve.getVehicleInfo();
			System.out.println("%%%" + data[idx++]);
		}

		JTable tab = new JTable(new DefaultTableModel(data, columnName)) {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};

		tab.setAutoCreateRowSorter(true);

		return tab;

	}

	private void addListener() {




	}








}
