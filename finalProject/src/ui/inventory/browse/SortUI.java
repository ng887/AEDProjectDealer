package org.neu.project.ui.inventory.browse;

import javax.swing.*;
import java.awt.*;

/**
 * @author Ruby,Liao
 * SortUI in browse inventory page
 * FlowLayout to place title label and sort items horizontally
 * Pending addListeners
 */

class SortUI extends JPanel
{
	SortUI()
	{
		this.setLayout(new FlowLayout());
		String[] sortItems = {"Select Sort By","Price: High To Low","Price: Low To High",
                "Year: High To Low","Year: Low To High","Make: A - Z","Maker: Z - A",
                "Model: A - Z","Model: Z - A","Mileage: High To Low","Mileage: Low To High",
                "HWY MPG: High To Low","HWY MPG: Low To High","Exterior Color: A - Z",
                "Exterior Color: Z - A","Specials","Certified"};

		JComboBox sortList = new JComboBox<>(sortItems);
		JLabel sortLabel = new JLabel("Sort By:");

		add(sortLabel);
		add(sortList);
	}
}