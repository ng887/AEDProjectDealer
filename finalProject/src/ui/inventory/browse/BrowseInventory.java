package org.neu.project.ui.inventory.browse;

import org.neu.project.ui.common.BaseFrame;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * @author ken prayogo
 * Main BrowseInventory UI rendering class
 */
public class BrowseInventory extends BaseFrame {
	// Static values
	private static final int scrWidth = 1200;
	private static final int scrHeight = 720;
	// Components
	private ButtonPanel buttonPanel;

	public BrowseInventory() {
		super(scrWidth, scrHeight);
	}

	@Override
	protected void create() {
		this.setTitle("Inventory List");
	}

	@Override
	protected void add() {
		Container container = this.getContentPane();
		// First layout to separate header, controls and footer
//		GridLayout layoutMaster = new GridLayout(1,3,0,10);
		container.setLayout(new FlowLayout());

		/* Declare and Add Panels here */

		// Search/Filter panel
		JPanel filterPanel = new JPanel();
		try {
			Search searchPane = new Search();
			filterPanel.add(searchPane);
		} catch (IOException e) {
			System.out.println(e);
		}
		filterPanel.setPreferredSize(new Dimension(300,720));

		// Results panel
		Result results = new Result();
		results.setPreferredSize(new Dimension(600,600));

		// Arrange Horizontal screen layout
		container.add(filterPanel);
		container.add(results);
		buttonPanel = new ButtonPanel();
		container.add(buttonPanel);
	}

	@Override
	protected void addListener() {

	}

	public static void main(String args[]) {
		new BrowseInventory();
	}
}

/**
 * Example for reference.
 * Renders a scrollable Table.
 */
class ListPanel extends JPanel {
	private JPanel mainList;
	public JTable table;

	public ListPanel() {

		mainList = new JPanel();
		mainList.setLayout(new BorderLayout());

		Object[][] data = getVehicleData();
		String[] labels = {"VIN", "Make", "Model", "Year", "Type", "Color", "Mileage"};
		table = new JTable(data, labels);

		JScrollPane tableContainer = new JScrollPane(table);
		tableContainer.setPreferredSize(new Dimension(500, 150));

		mainList.add(tableContainer, BorderLayout.CENTER);
		add(tableContainer);
	}

	private static Object[][] getVehicleData() {
		Object[][] data = {
				{"VIN-NO1", "Honda", "Civic", "2012", "Sedan", "White", "5000"},
				{"VIN-NO2", "Honda", "Civic", "2012", "Sedan", "White", "5000"},
				{"VIN-NO3", "Honda", "Civic", "2012", "Sedan", "White", "5000"},
				{"VIN-NO4", "Honda", "Civic", "2012", "Sedan", "White", "5000"},
				{"VIN-NO5", "Honda", "Civic", "2012", "Sedan", "White", "5000"},
				{"VIN-NO6", "Honda", "Civic", "2012", "Sedan", "White", "5000"},
				{"VIN-NO7", "Honda", "Civic", "2012", "Sedan", "White", "5000"},
				{"VIN-NO8", "Honda", "Civic", "2012", "Sedan", "White", "5000"},
				{"VIN-NO9", "Honda", "Civic", "2012", "Sedan", "White", "5000"}
		};
		return data;
	}
}