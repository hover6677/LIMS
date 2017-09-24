import java.awt.Frame;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Font;
import java.util.ArrayList;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ProcessingUI extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	private JLabel lblNewLabel;
//	private JTextField textField;
//	private JLabel lblNoOfSteps;
//	private JList<Integer> list;
//	private JScrollBar scrollBar;
//	private JPanel panel;
//	private JPanel panel_1;
	private int totNum;
	private DefaultListModel<Integer> listModelLeft;
	private JPanel panel_1;
	private ArrayList<JTextField> arrayOfTxtBox;
	
	

	public ProcessingUI(String title)
	{
		//super(title);
		setTitle("Process(Admin)");
		setSize(643,500);  
		getContentPane().setLayout(null);  
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 6, 382, 466);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBounds(394, 6, 243, 428);
		getContentPane().add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 30));
		
		JLabel lblNewLabel = new JLabel("Process Name");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblNewLabel.setBounds(23, 39, 123, 27);
		panel.add(lblNewLabel);
		
		JTextField textField = new JTextField();
		textField.setBounds(183, 41, 172, 26);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNoOfSteps = new JLabel("No. of Steps");
		lblNoOfSteps.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblNoOfSteps.setBounds(23, 147, 123, 27);
		panel.add(lblNoOfSteps);
		
		getLabelTotNum();
		
		
		
		final JList<Integer> list = new JList<Integer>(listModelLeft);
		list.setBounds(183, 147, 172, 195);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addListSelectionListener(new ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				if(e.getValueIsAdjusting()==false){
					int numOfTxtBox =list.getSelectedIndex()+1;
					System.out.println(numOfTxtBox);
					addTxtBox(numOfTxtBox);
				}
			}
			
		});
		panel.add(list);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(340, 148, 15, 194);
		panel.add(scrollBar);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(520, 446, 117, 29);
		btnSave.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		getContentPane().add(btnSave);
		
		
		
//		JScrollBar scrollBar_1 = new JScrollBar();
//		panel_1.add(scrollBar_1);
		
		setVisible(true);
		 
		
	}
	
	private void getLabelTotNum(){
		totNum=getTotNum();
		listModelLeft=new DefaultListModel<Integer>();
		for(int i =1; i<=totNum;i++)
		{
			listModelLeft.addElement(i);
		}
		
	}

	// this function is to get totNum from database
	private int getTotNum(){
		return 8;
	}
	private void addTxtBox(int numOfTxtBox){
		panel_1.removeAll();
		arrayOfTxtBox  = new ArrayList<JTextField>();
		for(int i =0; i<numOfTxtBox;i++)
		{	
			JTextField txtBox = new JTextField();
			txtBox.setColumns(6);
			arrayOfTxtBox.add(txtBox);
			panel_1.add(txtBox);
		}
		panel_1.updateUI();
		return;
	}
	public static void main(String args[])
	{
		ProcessingUI pui = new ProcessingUI("Processing");
		System.out.println("end");
		
		
	}
}


