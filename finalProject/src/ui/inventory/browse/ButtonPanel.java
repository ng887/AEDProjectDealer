package org.neu.project.ui.inventory.browse;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel {
	JButton btnView;
	JButton btnEdit;
	JButton btnDelete;

	public ButtonPanel() {
		// Arrange in vertical order, with spacing of 10
		super(new GridLayout(4,1,0,5));

		btnView = new JButton("View Vehicle");
		btnEdit = new JButton("Edit Vehicle");
		btnDelete = new JButton("Delete Vehicle");

		add(btnView);
		add(btnEdit);
		add(btnDelete);
	}

	private void addListener(Result resultPanel) {
		// Look for what's checked in the results panel

	}

	@Override
	public Component add(Component comp) {
		super.add(comp);
		comp.setMaximumSize( comp.getPreferredSize() ); // Limits size from expanding
		return comp;
	}
}
