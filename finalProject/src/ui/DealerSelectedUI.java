package ui;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;


public class DealerSelectedUI extends JFrame {
    
    private String curDealerName;
    private String curDealerID;
    private JButton inventory, specials;
    private JLabel welcome;
    private JLabel labelofDealerName;
    private JLabel pic;
    private JLabel messgeForDealer;
    

    public DealerSelectedUI(String dealerName, String dealerID) {
        curDealerName = dealerName;
        curDealerID = dealerID;
        this.setSize(650, 250);
        Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((int)(screenDimension.getWidth() - this.getWidth()) / 2, (int)(screenDimension.getHeight() - this.getHeight()) / 2);
        
        create();
        add();
        addListener();
        
        this.setVisible(true);
    }
    
    private void create() {
        
        
        welcome = new JLabel("WELCOME:");
        labelofDealerName = new JLabel(curDealerName);
        labelofDealerName.setFont(new Font("Tohama", Font.BOLD, 14));
        messgeForDealer = new JLabel("Click to manage your inventory.");
        
        ImageIcon image = new ImageIcon("/Users/vibho/Desktop/AEDProject/ManageInventory.jpg");
        image.setImage(image.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT));
        pic = new JLabel(image);
        pic.setPreferredSize(new Dimension(350, 250));
        
        
        inventory = new JButton("Inventory");
        inventory.setPreferredSize(new Dimension(120, 40));
        inventory.setFont(new Font("Tohama", Font.PLAIN, 15));
        
        specials = new JButton("Specials");
        specials.setPreferredSize(new Dimension(120, 40));
        specials.setFont(new Font("Tohama", Font.PLAIN, 15));
    }
    
    private void add() {
        Container con = this.getContentPane();
        con.setLayout(new BoxLayout(con, BoxLayout.X_AXIS));
        
        JPanel left = new JPanel(new FlowLayout(FlowLayout.LEFT));
        left.add(pic);
        left.setBackground(Color.WHITE);

        
        
        JPanel right = new JPanel();
        right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
        
        right.add(Box.createHorizontalStrut(5));
        JPanel welPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        welPanel.add(welcome);
        right.add(welPanel);
        JPanel dealPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        dealPanel.add(labelofDealerName);
        right.add(dealPanel);
       /* JPanel msgPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        dealPanel.add(messgeForDealer);
        right.add(msgPanel);
       */ 
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(inventory);
        buttonPanel.add(Box.createHorizontalStrut(20));
        buttonPanel.add(specials);
        right.add(buttonPanel);
        
        welPanel.setBackground(Color.WHITE);
        dealPanel.setBackground(Color.WHITE);
       // msgPanel.setBackground(Color.WHITE);
        buttonPanel.setBackground(Color.WHITE);
        right.setBackground(Color.WHITE);
        
        con.add(left);
        con.add(right);
    }
    
    
    private void addListener() {
        
        InventoryListener il = new InventoryListener();
        inventory.addActionListener(il);
        
        SpecialsListener sl = new SpecialsListener();
        specials.addActionListener(sl);
        
    }
    
    
    private class InventoryListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            new DealerBrowsingInventory(curDealerID);
 
        }
        
    }
    
    private class SpecialsListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            //new BrowsingSpecials(curDealerID);

        }
        
    }
    

    
    

}
