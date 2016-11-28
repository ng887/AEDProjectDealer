package org.neu.project.ui.common;

import javax.swing.*;

/**
 * Shared class to create UI frames. Feel free to add anything that's missing.
 * - Ken
 */
public abstract class BaseFrame extends JFrame {
	private int width;
	private int height;

	public BaseFrame(int width, int height) {
		this.width = width;
		this.height = height;

		create();
		add();
		addListener();
		setup();
	}

	protected void setup() {
		setSize(width,height);
		setVisible(true);
		// Exits the running process on window close
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Centers the window on screen
		setLocationRelativeTo(null);
	}

	protected abstract void create();

	protected abstract void add();

	protected abstract void addListener();
}
