package finalProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.Graphics;
import javax.imageio.ImageIO;
import javax.swing.*;


public class GUI implements ActionListener {
	
BurgerFactory factory = new BurgerFactory();
	
	private JLabel burgerLabel;
	private JLabel costLabel;
	private int totalCost;
	private String stringCost;
	private JTextArea descriptionLabel;
	private static String burgerType;
	private JLabel menuTitle;
	private JTextArea burgerItem;
	private JTextArea sideMenu;
	private boolean slawTotal;
	private boolean friTotal;
	
	HashMap<String, String> menu = new HashMap<String, String>();
	
	//Attempt to use StateList for menu
	StateList stateList = new StateList();
	
	
	

	
	public GUI() {
		
		slawTotal=false;
		friTotal=false;
		
		
		//State Test 
		System.out.println(stateList.toString());
		stateList.addSlaw();
		if (stateList.toString().contains("Empty")) {
			System.out.println("It worked");
		}else {
			System.out.println("It didnt");
		}

	
		//Image for menu
		ImageIcon ii = new ImageIcon("src/images/burger.jpg");
		JLabel jLabel = new JLabel();
		jLabel.setIcon(ii);
		
		
		//Make labels and text areas 
		burgerLabel = new JLabel("Burger Type: ");
		costLabel = new JLabel("Cost: ");
		descriptionLabel = new JTextArea("Your Order: ");
		descriptionLabel.setLineWrap(true);;
		menuTitle = new JLabel("Z Burger Menu");
		menuTitle.setFont(new Font("verdana", Font.ITALIC, 24));
		burgerItem = new JTextArea("Burgers: "+"\n"+ "Regular Burger: $5" + "\n"+"Beast Burger: $10"+"\n"+"Monster Burger: $25");
		sideMenu = new JTextArea("Sides: "+"\n"+"Cole Slaw: $1"+"\n"+"Fries: $1");
		
	
		
		
		//Frame
		JFrame frame = new JFrame("Burger Joint");
		frame.setLayout(new GridLayout(0,2));
		
		//Adding image to screen
		frame.add(menuTitle);
		frame.add(jLabel);
		
		//Adding menu
		frame.add(burgerItem);
		frame.add(sideMenu);

		//Drop down menus 
		String[] test = {"Regular", "Beast", "Monster"};
		JComboBox testList = new JComboBox(test);
		testList.setSelectedIndex(0);
		testList.addActionListener(new Action0());
		
		frame.add(testList);
		frame.add(burgerLabel);
		
		//Buttons----------------------------------------------
		JButton addSlawButton = new JButton("Add Coleslaw");
		addSlawButton.addActionListener(new AddSlawAction());
		addSlawButton.setBackground(Color.GREEN);
		frame.add(addSlawButton);
		
		JButton minusSlawButton = new JButton("Take away Slaw");
		minusSlawButton.addActionListener(new MinusSlawAction());
		minusSlawButton.setBackground(Color.RED);
		frame.add(minusSlawButton);
		
		JButton addFriesButton = new JButton("Add Fries");
		addFriesButton.addActionListener(new AddFries());
		addFriesButton.setBackground(Color.GREEN);
		frame.add(addFriesButton);
		
		JButton minusFriesButton = new JButton("Take away Fries");
		minusFriesButton.addActionListener(new RemoveFries());
		minusFriesButton.setBackground(Color.RED);
		frame.add(minusFriesButton);
		
		
		//Adds the bottom two labels
		frame.add(costLabel);
		frame.add(descriptionLabel);
		
		//Sets size of frame
		frame.setSize(500,800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Burger Joint");
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
		
	}
	
	//Method called from drop down menu
	public class Action0 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JComboBox<String> combo = (JComboBox<String>) e.getSource();
			burgerType = (String) combo.getSelectedItem();
			
			//FACTORY ===============================================================**
			
			//create the type of rocket from the factory 
			factory.createBurger(burgerType);
			menu.put(burgerType, String.valueOf(factory.createBurger(burgerType).cost()));
			
			//if changed, updates the cost back to zero
			totalCost=0;
			
			//update the text labels on the GUI
			burgerLabel.setText("Burger Type: " + factory.createBurger(burgerType).description);
			
			//Update the cost
			totalCost+=factory.createBurger(burgerType).cost();
			System.out.println(totalCost);
			
			//Set the text 
			stringCost = String.valueOf(totalCost);
			System.out.println("String Cost: " + stringCost);
			costLabel.setText("Cost $" + stringCost);
			
			//Remove if the choice changes 
			menu.remove("Regular");
			menu.remove("Beast");
			menu.remove("Monster");
			
			//put the burger choice into the menu
			if (burgerType == "Regular") {
				menu.put("Regular", "$5");
			}else if (burgerType == "Beast") {
				menu.put("Beast", "$10");
			}else {
				menu.put("Monster", "$25");
			}
			
			//Iterate over the menu and print out 
			MenuIterator menuIterator = new MenuIterator();
			String a = menuIterator.MenuIteratorMethod(menu);
			descriptionLabel.setText(a);
			
			//Test for the state
			stateList.addBurger();
			stateList.getState();
			System.out.println(stateList.getState());	
			stateList.minusBurger();
			System.out.println(stateList.getState());
			
		}
	}
	

	public class AddSlawAction implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			coleslawAdd ColeslawAdd = new coleslawAdd();
			ColeslawAdd.execute(totalCost);
			
			//menu.put("Cole Slaw", "$1");
			
			stateList.returnHash(menu).put("Cole Slaw", "$1");
			stateList.addSlaw();
			stateList.getState();
			
			System.out.println(stateList.getState());
			
			stateList.minusSlaw();
			System.out.println(stateList.getState());
			
			//Iterate over the menu and print to screen 
			MenuIterator menuIterator = new MenuIterator();
			String a = menuIterator.MenuIteratorMethod(menu);
			descriptionLabel.setText(a);
			
			//Check to see if slaw is already ordered or not 
			if(slawTotal==false) {
				totalCost+=1;
			}else {
				totalCost+=0;
			}
			
			slawTotal=true;
			
			//Update the cost 
			stringCost = String.valueOf(totalCost);
			costLabel.setText("Cost $" + stringCost);
					
		}
	}
	
	public class MinusSlawAction implements ActionListener{
		public void actionPerformed(ActionEvent e) {
		
			//Check to see if slaw is already on menu
			if(slawTotal==false) {
				totalCost-=0;
			}else {
				totalCost-=1;
			}
			slawTotal=false;
			
	
			stringCost = String.valueOf(totalCost);
			costLabel.setText("Cost $" + stringCost);
			
			
			//menu.remove("Cole Slaw");
			
			stateList.returnHash(menu).remove("Cole Slaw");
			stateList.minusSlaw();

			//Iterate over menu and print to screen 
			MenuIterator menuIterator = new MenuIterator();
			String a = menuIterator.MenuIteratorMethod(menu);
			descriptionLabel.setText(a);
					
		}
	}

	public class AddFries implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//Check to see if fries are already on menu 
			if(friTotal==false) {
				totalCost+=1;
			}else {
				totalCost+=0;
			}
			
			friTotal=true;
			
		
			stringCost = String.valueOf(totalCost);
			costLabel.setText("Cost $" + stringCost);
			
			menu.put("Fries", "$1");
			//Iterate over menu and print to screen
			MenuIterator menuIterator = new MenuIterator();
			String a = menuIterator.MenuIteratorMethod(menu);
			descriptionLabel.setText(a);
				
		}
	}
	
	//Method to update cost, range for adding Warp Drive
	public class RemoveFries implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			if(friTotal==false) {
				totalCost-=0;
			}else {
				totalCost-=1;
			}
			friTotal=false;
			
			stringCost = String.valueOf(totalCost);
			costLabel.setText("Cost $" + stringCost);
			
			menu.remove("Fries");
			MenuIterator menuIterator = new MenuIterator();
			String a = menuIterator.MenuIteratorMethod(menu);
			descriptionLabel.setText(a);
			
			
		}
	}

}
