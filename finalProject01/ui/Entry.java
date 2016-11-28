package finalProject01.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import java.util.Set;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class Entry extends JFrame{
    
    private JButton customer, dealer;
    private JComboBox dealerList;
    private JLabel label;

    private DealerPool dealers;
    

    public Entry() {
        super();
        // TODO Auto-generated constructor stub
        String dealerFile = "C:\\Users\\vibho\\Desktop\\car-dealers.txt";
        String inventoryFileFoldPath = "C:\\Users\\vibho\\Desktop\\inventory";
        DataManager dataManager = new DataManager(dealerFile, inventoryFileFoldPath);
        dealers = dataManager.getDealerPool();

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
        label = new JLabel("Select a Dealer：");
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
        addDataToComboBoxList(dealerList, dealers);
        
    }
    
    private void addDataToComboBoxList(JComboBox list, DealerPool dealers) {
        Set<String> dp = dealers.getDealersName();
        list.addItem(null);
        
        for (String name: dp) {
            list.addItem(name);
        }
        
    }



    private void add() {
        // TODO Auto-generated method stub
        Container con = this.getContentPane();
        JPanel base = new JPanel();
        con.add(base);
        base.setLayout(new BoxLayout(base, BoxLayout.Y_AXIS));
        
        JPanel topPanel = new JPanel();
        ImageIcon image = new ImageIcon("/Users/xiaoyue/NEU_2016FALL__InformationSystem/INFO5100_JAVA/Assigments/finalProject/data/title.gif");
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
        
        CustomerListener cl = new CustomerListener();
        customer.addActionListener(cl);
        
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
    
    class CustomerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            String dealerid = dealers.getDealerIDbyName(dealerList.getSelectedItem().toString());
            new CustomerBrowsingInventory(dealerid);

        }   
    }
    
    class DealerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            String dealerName = dealerList.getSelectedItem().toString();
            String dealerid = dealers.getDealerIDbyName(dealerName);
            new DealerBridge(dealerName, dealerid);      
        }
        
    }
    

    

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        Entry entry = new Entry();
        
    }

}
