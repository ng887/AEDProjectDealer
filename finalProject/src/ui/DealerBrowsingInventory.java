package ui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;

public class DealerBrowsingInventory extends BrowsingInventory {

    private JButton manageButton;
    private String dealerID;
    
    public DealerBrowsingInventory(String dealer) {
        super(dealer);
        dealerID = dealer;
        // TODO Auto-generated constructor stub
        create();
        addListener();
    }
    
    private void create() {
        manageButton = new JButton("Manage");
        manageButton.setPreferredSize(new Dimension(120, 40));
        
        super.buttonPanel.add(Box.createHorizontalStrut(20));
        super.buttonPanel.add(manageButton);
        
    }
    
    private void addListener() {
        ManageButtonListener mbl = new ManageButtonListener();
        manageButton.addActionListener(mbl);
    }
    
    private class ManageButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            
            new ManageInventory(dealerID);
            
        }
        
    }

}
