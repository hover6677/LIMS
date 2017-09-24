package UI;
import java.awt.Frame;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
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
import java.awt.Color;


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
	String title;
	String label1;
	String label2;
	String label3;
	String button1;
	
	private int totNum;
	private DefaultListModel<Integer> listModelLeft;
	private JPanel panel_1;
	private ArrayList<JTextField> arrayOfTxtBox;
	
	

	public ProcessingUI(String t,String l1, String l2,String l3, String b1)
	{
		setResizable(false);
		//super(title);
		title =t;
		label1 = l1;
		label2 = l2;
		label3 = l3;
		button1 = b1;
		setTitle(title);
		setSize(643,500);  
		getContentPane().setLayout(null);  
		

		
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.GRAY);
		panel.setBounds(0, 6, 382, 466);
		panel.setBorder(BorderFactory.createRaisedBevelBorder());
		getContentPane().add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBounds(394, 6, 243, 428);
		panel_1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(), label3));
		getContentPane().add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 10));
		
		JLabel lblNewLabel = new JLabel(label1);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblNewLabel.setBounds(23, 39, 123, 27);
		panel.add(lblNewLabel);
		
		JTextField textField = new JTextField();
		textField.setBounds(183, 41, 172, 26);
		textField.setBorder(BorderFactory.createSoftBevelBorder(SoftBevelBorder.LOWERED));
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNoOfSteps = new JLabel(label2);
		lblNoOfSteps.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblNoOfSteps.setBounds(23, 147, 123, 27);
		panel.add(lblNoOfSteps);
		
		getLabelTotNum();
		
		
		
		final JList<Integer> list = new JList<Integer>(listModelLeft);
		list.setVisibleRowCount(12);
		list.setBounds(183, 147, 55, 195);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBorder(BorderFactory.createSoftBevelBorder(SoftBevelBorder.LOWERED));
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
		scrollBar.setBounds(223, 148, 15, 194);
		panel.add(scrollBar);
		
		JButton btnSave = new JButton(button1);
		btnSave.setBounds(520, 446, 117, 29);
		btnSave.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				buttonAction();
			}
			
		});
		getContentPane().add(btnSave);
		
		
		
//		JScrollBar scrollBar_1 = new JScrollBar();
//		panel_1.add(scrollBar_1);
		
		setVisible(true);
		 
		
	}
	
	protected void getLabelTotNum(){
		totNum=getTotNum();
		listModelLeft=new DefaultListModel<Integer>();
		for(int i =1; i<=totNum;i++)
		{
			listModelLeft.addElement(i);
		}
		
	}

	// this function is to get totNum from database
	protected int getTotNum(){
		return 8;
	}
	private void addTxtBox(int numOfTxtBox){
		panel_1.removeAll();
		arrayOfTxtBox  = new ArrayList<JTextField>();
		for(int i =0; i<numOfTxtBox;i++)
		{	
			JLabel label = new JLabel("Label"+(i+1));
			
			JTextField txtBox = new JTextField();
			txtBox.setColumns(6);
			txtBox.setBorder(BorderFactory.createSoftBevelBorder(SoftBevelBorder.LOWERED));
			arrayOfTxtBox.add(txtBox);
			panel_1.add(label);
			panel_1.add(txtBox);
		}
		panel_1.updateUI();
		return;
	}
	protected void buttonAction(){
		
	}
	public static void main(String args[])
	{
		ProcessingUI pui = new ProcessingUI("Process(Admin)","Process Name","No. of Steps","Labels","Save");
		ReceivingUI rui = new ReceivingUI("Receiving(Admin)","Template ID", "No. of Tags","Labels","Save");
		System.out.println("end");
		
		
	}
}


