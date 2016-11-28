package org.neu.project.ui.inventory.browse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class Search extends JPanel {
//	public static void main(String[] args) {
////		addSearchBox();
//	}

	public Search() throws IOException {

		super(new GridLayout(0,1,0,5));

		JCheckBox New = new JCheckBox("New");
		// Font bigFont = new Font("", Font.ITALIC, 28);
		// New.setFont(bigFont);
		JCheckBox Used = new JCheckBox("Used");
		JCheckBox Certified = new JCheckBox("Certified");
		JComboBox<String> makes = new JComboBox<String>();
		JComboBox<String> models = new JComboBox<String>();
		JComboBox<String> maxPrice = new JComboBox<String>();
		JComboBox<String> types = new JComboBox<String>();
		JButton search = new JButton("SEARCH INVENTORY");

		HashSet<String> setMakes = new HashSet<String>();
		HashSet<String> setModels = new HashSet<String>();
		HashSet<String> setTypes = new HashSet<String>();

		SortUI sort = new SortUI();
		add(sort);

		add(New);
		add(Used);
		add(Certified);
		add(makes);
		add(models);
		add(types);
		add(maxPrice);
		add(search);

		makes.addItem("All Makes");
	}

	private static void addSearchBox() throws IOException {
		HashSet<String> setMakes = new HashSet<String>();
		HashSet<String> setModels = new HashSet<String>();
		HashSet<String> setTypes = new HashSet<String>();

		JFrame frame = new JFrame();
		frame.setTitle("Search Car");
		//frame.getContentPane().setBackground(Color.red);

		JCheckBox New = new JCheckBox("New");
		// Font bigFont = new Font("", Font.ITALIC, 28);
		// New.setFont(bigFont);
		JCheckBox Used = new JCheckBox("Used");
		JCheckBox Certified = new JCheckBox("Certified");
		JComboBox<String> makes = new JComboBox<String>();
		JComboBox<String> models = new JComboBox<String>();
		JComboBox<String> maxPrice = new JComboBox<String>();
		JComboBox<String> types = new JComboBox<String>();
		JButton search = new JButton("SEARCH INVENTORY");

		FlowLayout fl = new FlowLayout();

		Container con = frame.getContentPane();
		con.setLayout(fl);

		con.add(New);
		con.add(Used);
		con.add(Certified);
		con.add(makes);
		con.add(models);
		con.add(types);
		con.add(maxPrice);
		con.add(search);

		makes.addItem("All Makes");
		readFile(setMakes, setModels, setTypes);
		for (String s : setMakes) {
			if (!s.isEmpty() && !s.endsWith("make")) makes.addItem(s);
		}
		models.addItem("All Models");
		for (String s : setModels) {
			if (!s.isEmpty() && !s.endsWith("models")) models.addItem(s);
		}
		types.addItem("All Types");
		for (String s : setTypes) {
			if (!s.isEmpty() && !s.endsWith("type")) types.addItem(s);
		}
		maxPrice.addItem("No Max Price");
		String[] prices = {"10000", "20000", "30000", "40000", "50000", "60000", "70000", "80000", "90000", "100000"};
		for (String s : prices) maxPrice.addItem(s);



		frame.setSize(600, 800);
		frame.setVisible(true);
	}

	private static void readFile(HashSet<String> setMakes, HashSet<String> setModels, HashSet<String> setTypes) throws IOException {

		File filefolder = new File(".\\..\\..\\data");
		String file = findFile(filefolder);
		@SuppressWarnings("resource")
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line;
		while ((line = reader.readLine()) != null) {
			String[] str = line.split("~");
			setMakes.add(str[4]);
			setModels.add(str[5]);
			setTypes.add(str[7]);
		}

	}

	private static String findFile(File filefolder) {
		// TODO Auto-generated method stub
		String filepath = null;
		for (File file : filefolder.listFiles()) {
			filepath = file.getAbsolutePath();
		}
		return filepath;
	}

	class clickMeSearch implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}

}
