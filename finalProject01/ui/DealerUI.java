package finalProject01.ui;

import finalProject01.service.DealerManager;
import finalProject01.service.DealerManagerImpl;
import finalProject01.ui.Entry.ComboBoxListener;
import finalProject01.ui.Entry.CustomerListener;
import finalProject01.ui.Entry.DealerListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;


public class DealerUI extends JFrame{

/*	private JComboBox dealersCombo;

	public void create() {
		DealerManager dealerManager = getDealerManager();
		List<String> dealerNames = dealerManager.getAllDealerNamesInSystem();
		// dealersCombo =
	}

	private DealerManager getDealerManager() {
		return new DummyDealerManager();
	}

}
*/

private JButton customer, dealer;
private JComboBox dealerList;
private JLabel label;

//private DealerPool dealers;
DealerManager dealerManager = getDealerManager();


public DealerUI() {
    super();
    
   /* String dealerFile = "C:\\Users\\vibho\\Desktop\\car-dealers.txt";
    String inventoryFileFoldPath = "C:\\Users\\vibho\\Desktop\\inventory";
    DataManager dataManager = new DataManager(dealerFile, inventoryFileFoldPath);
    dealers = dataManager.getDealerPool();
    */
    
    create();
    add();
    addListener();
    
    Dimension screenDimen = Toolkit.getDefaultToolkit().getScreenSize();
    this.setExtendedState(Frame.MAXIMIZED_BOTH);
    this.setLocation((int)(screenDimen.getWidth() - this.getWidth()) / 2, (int)(screenDimen.getHeight() - this.getHeight()) / 2);
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}


private void create() {
    // TODO Auto-generated method stub
    label = new JLabel("Select a Dealer's");
    label.setFont(new Font("Tahoma", Font.PLAIN, 30));
    label.setSize(200, 50);
    
    customer = new JButton("Customer");
    customer.setEnabled(false);
    customer.setFont(new Font("Tahoma", Font.PLAIN, 15));
    customer.setPreferredSize(new Dimension(160, 40));

    dealer = new JButton("Dealer");
    dealer.setEnabled(false);
    dealer.setFont(new Font("Tahoma", Font.PLAIN, 15));
    dealer.setPreferredSize(new Dimension(160, 40));
    
    dealerList = new JComboBox();
    dealerList.setPreferredSize(new Dimension(250, 40));
    
    
	List<String> dealerNames = dealerManager.getAllDealerNamesInSystem();
	//System.out.println(dealerNames);
    addDataToComboBoxList(dealerList,dealerNames);
    
}

private DealerManager getDealerManager() {
	return new DealerManagerImpl();
}

private void addDataToComboBoxList(JComboBox list, List<String> dealerNames) {
   /* Set<String> dp = dealers.getDealersName();
    list.addItem(null);
    
    for (String name: dp) {
        list.addItem(name);
    }
    */
	list.addItem(null);
    for (String dealer : dealerNames){
    		list.addItem(dealer);
	
	
	}
    
}



private void add() {
    // TODO Auto-generated method stub
    Container con = this.getContentPane();
    JPanel base = new JPanel();
    con.add(base);
    base.setLayout(new BoxLayout(base, BoxLayout.Y_AXIS));
    
    JPanel topPanel = new JPanel();
    ImageIcon image = new ImageIcon("/Users/vibho/Desktop/AEDProject/unclutch.png");
    JLabel pic = new JLabel(image);
    topPanel.add(pic);
    topPanel.setBackground(Color.WHITE);
    topPanel.setPreferredSize(new Dimension(200, 250));
    base.add(topPanel);
    
    JPanel midPanel = new JPanel();
    midPanel.add(label);
    midPanel.add(dealerList);
    midPanel.setBackground(Color.WHITE);
    midPanel.setPreferredSize(new Dimension(200, 20));
    base.add(midPanel);
    
    JPanel bottomPanel = new JPanel();
    bottomPanel.add(customer);
    bottomPanel.add(Box.createHorizontalStrut(20));
    bottomPanel.add(dealer);
    bottomPanel.setBackground(Color.GRAY);
    base.add(bottomPanel);
    
    con.setBackground(Color.WHITE);
    
}



private void addListener() {
    // TODO Auto-generated method stub
    ComboBoxListener cbl = new ComboBoxListener();
    dealerList.addItemListener(cbl);
    
  //  CustomerListener cl = new CustomerListener();
  //  customer.addActionListener(cl);
    
   DealerListener dl = new DealerListener();
   dealer.addActionListener(dl);
    
}



class ComboBoxListener implements ItemListener {

    @Override
    public void itemStateChanged(ItemEvent e) {
        // TODO Auto-generated method stub
        if (dealerList.getSelectedItem() == null) {
            customer.setEnabled(false);
            dealer.setEnabled(false);
        }
        else {
            customer.setEnabled(true);
            dealer.setEnabled(true);
        }
    }

	
}

/*
class CustomerListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        String dealerid = dealers.getDealerIDbyName(dealerList.getSelectedItem().toString());
        new CustomerBrowsingInventory(dealerid);

    }   
}
*/

class DealerListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
       
       String dealerName = dealerList.getSelectedItem().toString();
       String dealerid = dealerManager.getDealerIDByNameInSystem(dealerName);
       new DealerSelectedUI(dealerName, dealerid);      
    }
    
}




public static void main(String[] args) {
    // TODO Auto-generated method stub
    
    DealerUI entry = new DealerUI();
    
}

}
