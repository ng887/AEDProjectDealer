package org.neu.project.ui.inventory.browse;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class ResultPanel extends JPanel {

	private JPanel carResultCombo;
	
	private JLabel details;

	private JLabel type;
	private JLabel price;
	private JLabel picture;
	private JLabel vin;
	private JLabel make;
	private JLabel mileage;
	private JLabel model;
	private JLabel year;
	private JLabel doors;
	private JLabel bodyType;
	private JLabel color;

	private JCheckBox select;

	public static void main(String[] args) {

		ResultPanel gui = new ResultPanel();

	}

	public ResultPanel() {

		super(new FlowLayout());
		add(new JScrollPane());

		Car[] cars = this.getResultCars();
		for (Car object : cars) {
			add(showResultCar(object));
		}

	}

	private Car[] getResultCars() {
		Car a = new Car();
		Car b = new Car();
		Car c = new Car();
		Car d = new Car();
		Car e = new Car();
		Car f = new Car();
		Car g = new Car();
		a.setVin("1");
		b.setVin("2");
		c.setVin("3");
		d.setVin("4");
		e.setVin("5");
		f.setVin("6");
		g.setVin("7");
		Car[] cars = { a, b, c, d, e, f, g };
		return cars;
	}

	public Component showResultCar(Car car) {

		carResultCombo = new JPanel();
		carResultCombo.setLayout(null);
		details = new JLabel();
		details.setLayout(new BoxLayout(details, BoxLayout.Y_AXIS));
		select = new JCheckBox("Select");
		ClickMeListener cml = new ClickMeListener();
		select.addActionListener(cml);

		type = new JLabel("Type   " + car.type);
		price = new JLabel("Sale Price   " + car.price);
		picture = new JLabel("Picture   " + car.picture);
		make = new JLabel("Make   " + car.make);
		vin = new JLabel("Vin   " + car.vin);
		mileage = new JLabel("Mileage   " + car.mileage);
		model = new JLabel("Model   " + car.model);
		year = new JLabel("Year   " + car.year);
		doors = new JLabel("Doors   " + car.doors);
		bodyType = new JLabel("BodyType   " + car.bodyType);
		color = new JLabel("Color   " + car.color);

		details.add(make);
		details.add(vin);
		details.add(mileage);
		details.add(model);
		details.add(year);
		details.add(doors);
		details.add(bodyType);
		details.add(color);

		carResultCombo.add(type);
		carResultCombo.add(price);
		carResultCombo.add(picture);
		carResultCombo.add(details);
		carResultCombo.add(select);

		type.setBounds(5, 5, 100, 35);
		price.setBounds(400, 5, 100, 35);
		picture.setBounds(5, 150, 150, 150);
		details.setBounds(250, 150, 300, 200);
		select.setBounds(500, 250, 250, 50);

		return carResultCombo;

	}

}

class ClickMeListener implements ActionListener {
	int cnt = 0;
	private JFrame frame;

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (cnt % 2 == 0) {
			System.out.println("Car selected");
		}
		cnt++;

	}
}
