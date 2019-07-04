package com.github.dfontana;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JDialog;

public class AssignmentInputDialog extends JDialog {

	private final JPanel contentPanel;
	private JTextField assignmentNameValue;
	private JTextField assignmentEarnedValue;
	private JTextField assignmentTotalValue;
	private JLabel divisorLabel;
	
	private String name;
	private Double earned;
	private Double total;

	public AssignmentInputDialog() {
		setModalityType(AssignmentInputDialog.DEFAULT_MODALITY_TYPE);
		setTitle("Add New Assignment");
		setResizable(false);
		setForeground(Color.WHITE);
		setBounds(100, 100, 300, 140);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 65, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPane);

		JLabel assignmentNameLabel = new JLabel("Assignment Name:");
		GridBagConstraints gbc_assignmentNameLabel = new GridBagConstraints();
		gbc_assignmentNameLabel.anchor = GridBagConstraints.EAST;
		gbc_assignmentNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_assignmentNameLabel.gridx = 0;
		gbc_assignmentNameLabel.gridy = 1;
		contentPanel.add(assignmentNameLabel, gbc_assignmentNameLabel);

		assignmentNameValue = new JTextField();
		GridBagConstraints gbc_assignmentNameValue = new GridBagConstraints();
		gbc_assignmentNameValue.gridwidth = 3;
		gbc_assignmentNameValue.insets = new Insets(0, 0, 5, 5);
		gbc_assignmentNameValue.fill = GridBagConstraints.HORIZONTAL;
		gbc_assignmentNameValue.gridx = 1;
		gbc_assignmentNameValue.gridy = 1;
		contentPanel.add(assignmentNameValue, gbc_assignmentNameValue);
		assignmentNameValue.setColumns(10);

		JLabel assignmentPointsLabel = new JLabel("Point Value:");
		GridBagConstraints gbc_assignmentPointsLabel = new GridBagConstraints();
		gbc_assignmentPointsLabel.anchor = GridBagConstraints.EAST;
		gbc_assignmentPointsLabel.insets = new Insets(0, 0, 5, 5);
		gbc_assignmentPointsLabel.gridx = 0;
		gbc_assignmentPointsLabel.gridy = 2;
		contentPanel.add(assignmentPointsLabel, gbc_assignmentPointsLabel);

		assignmentEarnedValue = new JTextField();
		GridBagConstraints gbc_assignmentEarnedValue = new GridBagConstraints();
		gbc_assignmentEarnedValue.fill = GridBagConstraints.HORIZONTAL;
		gbc_assignmentEarnedValue.insets = new Insets(0, 0, 5, 5);
		gbc_assignmentEarnedValue.gridx = 1;
		gbc_assignmentEarnedValue.gridy = 2;
		contentPanel.add(assignmentEarnedValue, gbc_assignmentEarnedValue);
		assignmentEarnedValue.setColumns(10);

		divisorLabel = new JLabel("/");
		GridBagConstraints gbc_divisorLabel = new GridBagConstraints();
		gbc_divisorLabel.insets = new Insets(0, 0, 5, 5);
		gbc_divisorLabel.anchor = GridBagConstraints.EAST;
		gbc_divisorLabel.gridx = 2;
		gbc_divisorLabel.gridy = 2;
		contentPanel.add(divisorLabel, gbc_divisorLabel);

		assignmentTotalValue = new JTextField();
		GridBagConstraints gbc_assignmentTotalValue = new GridBagConstraints();
		gbc_assignmentTotalValue.insets = new Insets(0, 0, 5, 0);
		gbc_assignmentTotalValue.fill = GridBagConstraints.HORIZONTAL;
		gbc_assignmentTotalValue.gridx = 3;
		gbc_assignmentTotalValue.gridy = 2;
		contentPanel.add(assignmentTotalValue, gbc_assignmentTotalValue);
		assignmentTotalValue.setColumns(10);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setEnabled(false);
		GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
		gbc_btnSubmit.anchor = GridBagConstraints.EAST;
		gbc_btnSubmit.gridx = 3;
		gbc_btnSubmit.gridy = 3;
		contentPanel.add(btnSubmit, gbc_btnSubmit);
		
		class DocListener implements DocumentListener{
			public void changedUpdate(DocumentEvent e){check();}
			public void removeUpdate(DocumentEvent e) {check();}
			public void insertUpdate(DocumentEvent e) {check();}
			private void check(){
				try {
					Double.parseDouble(assignmentEarnedValue.getText());
					Double.parseDouble(assignmentTotalValue.getText());
					if(assignmentNameValue.getText().trim().equals("")){ btnSubmit.setEnabled(false);}
					else{btnSubmit.setEnabled(true);}
				}
				catch (NumberFormatException e1) {
					btnSubmit.setEnabled(false);
				}
			}
		}
		DocListener DocwideListener = new DocListener();
		assignmentTotalValue.getDocument().addDocumentListener(DocwideListener);
		assignmentEarnedValue.getDocument().addDocumentListener(DocwideListener);
		assignmentNameValue.getDocument().addDocumentListener(DocwideListener);

		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name = assignmentNameValue.getText().trim();
				earned = Double.parseDouble(assignmentEarnedValue.getText());
				total = Double.parseDouble(assignmentTotalValue.getText());
				AssignmentInputDialog.this.dispose();
			}
		});
	}
	
	public Double getEarned() {
		return earned;
	}
	
	public Double getTotal() {
		return total;
	}

	public String getName() {
		return name;
	}

}
