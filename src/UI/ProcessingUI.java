package UI;
import java.awt.Frame;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
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


public class ProcessingUI extends AbstractUI{

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
	private SpinnerListModel listModelLeft;
	private JPanel panel_1;
	private ArrayList<JTextField> arrayOfTxtBox;
	
	

	public ProcessingUI()
	{
		super("Process(Admin)","Process Name","No. of Steps","Labels","Save");
		
	}
	

	// this function is to get totNum from database
	@Override
	protected int getTotNum(){
		return 12;
	}
	
	@Override
	protected void buttonAction(){
		
	}
	public static void main(String args[])
	{
		ProcessingUI pui = new ProcessingUI();
		ReceivingUI rui = new ReceivingUI();
		
		
	}
}


