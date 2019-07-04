package com.github.dfontana;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class CategoryInputDialog extends JDialog {

	private final JPanel contentPanel;
	private JTextField categoryNameValue;
	private JTextField categoryWeightValue;
	private JLabel percentLabel;

	private Double weight;
	private String name;

	public CategoryInputDialog() {
		setModalityType(CategoryInputDialog.DEFAULT_MODALITY_TYPE);
		setTitle("Add New Category");
		setResizable(false);
		setForeground(Color.WHITE);
		setBounds(100, 100, 300, 140);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPane);

		JLabel catagoryNameLabel = new JLabel("Category Name:");
		GridBagConstraints gbc_catagoryNameLabel = new GridBagConstraints();
		gbc_catagoryNameLabel.anchor = GridBagConstraints.EAST;
		gbc_catagoryNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_catagoryNameLabel.gridx = 0;
		gbc_catagoryNameLabel.gridy = 1;
		contentPanel.add(catagoryNameLabel, gbc_catagoryNameLabel);

		categoryNameValue = new JTextField();
		GridBagConstraints gbc_categoryNameValue = new GridBagConstraints();
		gbc_categoryNameValue.gridwidth = 2;
		gbc_categoryNameValue.insets = new Insets(0, 0, 5, 0);
		gbc_categoryNameValue.fill = GridBagConstraints.HORIZONTAL;
		gbc_categoryNameValue.gridx = 1;
		gbc_categoryNameValue.gridy = 1;
		contentPanel.add(categoryNameValue, gbc_categoryNameValue);
		categoryNameValue.setColumns(10);

		JLabel categoryWeightLabel = new JLabel("Category Weight:");
		GridBagConstraints gbc_categoryWeightLabel = new GridBagConstraints();
		gbc_categoryWeightLabel.anchor = GridBagConstraints.EAST;
		gbc_categoryWeightLabel.insets = new Insets(0, 0, 5, 5);
		gbc_categoryWeightLabel.gridx = 0;
		gbc_categoryWeightLabel.gridy = 2;
		contentPanel.add(categoryWeightLabel, gbc_categoryWeightLabel);

		categoryWeightValue = new JTextField();
		GridBagConstraints gbc_categoryWeightValue = new GridBagConstraints();
		gbc_categoryWeightValue.insets = new Insets(0, 0, 5, 5);
		gbc_categoryWeightValue.fill = GridBagConstraints.HORIZONTAL;
		gbc_categoryWeightValue.gridx = 1;
		gbc_categoryWeightValue.gridy = 2;
		contentPanel.add(categoryWeightValue, gbc_categoryWeightValue);
		categoryWeightValue.setColumns(10);

		percentLabel = new JLabel("%");
		GridBagConstraints gbc_percentLabel = new GridBagConstraints();
		gbc_percentLabel.anchor = GridBagConstraints.WEST;
		gbc_percentLabel.insets = new Insets(0, 0, 5, 0);
		gbc_percentLabel.gridx = 2;
		gbc_percentLabel.gridy = 2;
		contentPanel.add(percentLabel, gbc_percentLabel);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setEnabled(false);
		GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
		gbc_btnSubmit.gridwidth = 2;
		gbc_btnSubmit.anchor = GridBagConstraints.EAST;
		gbc_btnSubmit.gridx = 1;
		gbc_btnSubmit.gridy = 3;
		contentPanel.add(btnSubmit, gbc_btnSubmit);

		class DocListener implements DocumentListener{
			public void changedUpdate(DocumentEvent e){check();}
			public void removeUpdate(DocumentEvent e) {check();}
			public void insertUpdate(DocumentEvent e) {check();}
			private void check(){
				try {
					Double.parseDouble(categoryWeightValue.getText());
					if(categoryNameValue.getText().trim().equals("")){ btnSubmit.setEnabled(false);}
					else{btnSubmit.setEnabled(true);}
				}
				catch (NumberFormatException e1) {
					btnSubmit.setEnabled(false);
				}
			}
		}
		DocListener DocwideListener = new DocListener();
		categoryNameValue.getDocument().addDocumentListener(DocwideListener);
		categoryWeightValue.getDocument().addDocumentListener(DocwideListener);

		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name = categoryNameValue.getText().trim();
				weight = Double.parseDouble(categoryWeightValue.getText());
				CategoryInputDialog.this.dispose();
			}
		});
	}
	public Double getWeight() {
		return weight;
	}

	public String getName() {
		return name;
	}
}

