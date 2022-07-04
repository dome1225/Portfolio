package example;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class GUI_Example {
	//Action listener and window to allow for the switching of what is displayed
	private ActionListener action;
	private JFrame mainWindow;

	//Putting text from one area of the program to another
	private JTextField inputText;
	private JButton addTextButton;
	private DefaultListModel<String> list = new DefaultListModel<>(); 
	private JList<String> jList;
	
	//The menu that allows for the switching of what is displayed
	private Panel currentDisplay;
	private MenuItem menuItem1;
	private MenuItem menuItem2;
	
	public GUI_Example() {
		//This creates the instance of a "TestWindow" window JFrame
		mainWindow = new JFrame("TestWindow");

		action = new AppliactionActionListener();
		
		mainWindow.getContentPane().setLayout(new BorderLayout());
		
		mainWindow.setBounds(10, 10, 1000, 1000);
		
		loadData();
		
		//Note: You can directly and to a JFrame, but making that window invisible causes the window to disappear from the taskbar
		mainWindow.getContentPane().add(new JLabel("Test"), BorderLayout.NORTH);
		mainWindow.setMenuBar(createMenuBar());
		
		currentDisplay = createAddingToListExample();
		
		mainWindow.getContentPane().add(currentDisplay, BorderLayout.CENTER);
		
		//This make the whole window visible. Use after you are done setting up the window 
		mainWindow.setVisible(true);
		
		//Method 1 of closing
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Method 2 of closing
		mainWindow.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				//Hint: You can does stuff this way before the process ends
				System.exit(0);
			}
		});
	}
	
	private void loadData() {
		try {
			File newFile = new File("C:/file.txt");
			Scanner fileInput = new Scanner(newFile);
			
			
			while(fileInput.hasNext()) {
				list.addElement(fileInput.nextLine());
			}
			fileInput.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Creates a panel that displays an example of a list
	 * @return The example panel
	 */
	private Panel createAddingToListExample() {
		Panel mainPanel = new Panel();
		
		//Makes 2 area. An area to enter text, and the list
		mainPanel.setLayout(new GridLayout(1, 2));
		
		//A panel for the label, text area, and button to add in the items from the text area
		Panel textToAddPanel = new Panel(new FlowLayout());
		
		JLabel enterTextLabel = new JLabel("Enter text here: ");
		textToAddPanel.add(enterTextLabel);
		
		inputText = new JTextField(30);
		textToAddPanel.add(inputText);
		
		addTextButton = new JButton("Add");
		//Need to add an action listener for the button to have any effect
		addTextButton.addActionListener(action);
		textToAddPanel.add(addTextButton);
		
		mainPanel.add(textToAddPanel);
		
		//Creates a blank list. This list is updated from the AppliactionActionListener
		jList = new JList<String>(list);
		jList.addListSelectionListener(new MyListSelectionListener());

		mainPanel.add(jList);
		
		return mainPanel;
	}
	
	/**
	 * Creates a new menu bar
	 * @return the new menu bar
	 */
	private MenuBar createMenuBar() {
		MenuBar menuBar = new MenuBar();
		
		Menu menuOption1 = new Menu("Example menu");
		
		menuItem1 = new MenuItem("Main menu");
		menuItem1.addActionListener(action);
		menuOption1.add(menuItem1);
		
		menuItem2 = new MenuItem("Other screen");
		menuItem2.addActionListener(action);
		menuOption1.add(menuItem2);
		
		menuBar.add(menuOption1);
		
		return menuBar;
	}
	
	/**
	 * An example of a panel that can be changed to
	 * @return
	 */
	private Panel changingDisplayExample(){
		Panel examplePanel = new Panel();
		examplePanel.add(new JLabel("Example of changing to a different view"));
		
		return examplePanel;
	}
	
	/**
	 * Example of an action listener
	 *
	 */
	private class AppliactionActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			//Clicking on the first menu option
			if(e.getSource().equals(menuItem1)) {
				
				//Clears the window, and replaces it with the panel from createAddingToListExample
				mainWindow.getContentPane().setVisible(false);
				mainWindow.getContentPane().remove(currentDisplay);
				
				currentDisplay = createAddingToListExample();
				mainWindow.getContentPane().add(currentDisplay);
				mainWindow.getContentPane().setVisible(true);
				
			}
			//Clicking on the second menu option
			else if(e.getSource().equals(menuItem2)) {
				//Clears the window, and replaces it with the panel from changingDisplayExample
				mainWindow.getContentPane().setVisible(false);
				mainWindow.getContentPane().remove(currentDisplay);
				
				currentDisplay = changingDisplayExample();
				mainWindow.getContentPane().add(currentDisplay);
				mainWindow.getContentPane().setVisible(true);
			}
			//Clicking on the add text button
			else if(e.getSource().equals(addTextButton)) {
				String newText = inputText.getText();
				inputText.setText("");
				
				jList.setVisible(false);
				list.add(list.size(), newText);
				jList.setVisible(true);
			}
			
		}
		
	}
	class MyListSelectionListener implements ListSelectionListener
	{

		@Override
		public void valueChanged(ListSelectionEvent e)
		{
			System.out.println(jList.getSelectedValue());
		}
		
	}
}
