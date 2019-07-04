package com.github.dfontana;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class CourseInputDialog extends JDialog {

	private final JPanel contentPanel;
	private JTextField courseNameValue;
	private JTextField instructorNameValue;
	private JComboBox comboBoxYear;
	private JComboBox comboBoxTerm;
	private JLabel lblYearTaken;
	private JLabel lblTermTaken;

	private String courseName;
	private String instructorName;
	private String year;
	private String term;

	public CourseInputDialog() {
		setModalityType(CourseInputDialog.DEFAULT_MODALITY_TYPE);
		setTitle("Add New Course");
		setResizable(false);
		setForeground(Color.WHITE);
		setBounds(100, 100, 300, 174);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPane);

		JLabel courseNameLabel = new JLabel("Course Name:");
		GridBagConstraints gbc_courseNameLabel = new GridBagConstraints();
		gbc_courseNameLabel.anchor = GridBagConstraints.EAST;
		gbc_courseNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_courseNameLabel.gridx = 0;
		gbc_courseNameLabel.gridy = 0;
		contentPanel.add(courseNameLabel, gbc_courseNameLabel);

		courseNameValue = new JTextField();
		GridBagConstraints gbc_courseNameValue = new GridBagConstraints();
		gbc_courseNameValue.fill = GridBagConstraints.HORIZONTAL;
		gbc_courseNameValue.insets = new Insets(0, 0, 5, 0);
		gbc_courseNameValue.gridx = 1;
		gbc_courseNameValue.gridy = 0;
		contentPanel.add(courseNameValue, gbc_courseNameValue);
		courseNameValue.setColumns(10);

		JLabel instructorNameLabel = new JLabel("Instructor:");
		GridBagConstraints gbc_instructorNameLabel = new GridBagConstraints();
		gbc_instructorNameLabel.anchor = GridBagConstraints.EAST;
		gbc_instructorNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_instructorNameLabel.gridx = 0;
		gbc_instructorNameLabel.gridy = 1;
		contentPanel.add(instructorNameLabel, gbc_instructorNameLabel);

		instructorNameValue = new JTextField();
		GridBagConstraints gbc_instructorNameValue = new GridBagConstraints();
		gbc_instructorNameValue.fill = GridBagConstraints.HORIZONTAL;
		gbc_instructorNameValue.insets = new Insets(0, 0, 5, 0);
		gbc_instructorNameValue.gridx = 1;
		gbc_instructorNameValue.gridy = 1;
		contentPanel.add(instructorNameValue, gbc_instructorNameValue);
		instructorNameValue.setColumns(10);

		lblYearTaken = new JLabel("Year Taken:");
		GridBagConstraints gbc_lblYearTaken = new GridBagConstraints();
		gbc_lblYearTaken.insets = new Insets(0, 0, 5, 5);
		gbc_lblYearTaken.anchor = GridBagConstraints.EAST;
		gbc_lblYearTaken.gridx = 0;
		gbc_lblYearTaken.gridy = 2;
		contentPanel.add(lblYearTaken, gbc_lblYearTaken);

		comboBoxYear = new JComboBox();
		comboBoxYear.setModel(new DefaultComboBoxModel(new String[] {"Freshman", "Sophomore", "Junior", "Senior"}));
		GridBagConstraints gbc_comboBoxYear = new GridBagConstraints();
		gbc_comboBoxYear.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxYear.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxYear.gridx = 1;
		gbc_comboBoxYear.gridy = 2;
		contentPanel.add(comboBoxYear, gbc_comboBoxYear);

		lblTermTaken = new JLabel("Term Taken:");
		GridBagConstraints gbc_lblTermTaken = new GridBagConstraints();
		gbc_lblTermTaken.insets = new Insets(0, 0, 5, 5);
		gbc_lblTermTaken.anchor = GridBagConstraints.EAST;
		gbc_lblTermTaken.gridx = 0;
		gbc_lblTermTaken.gridy = 3;
		contentPanel.add(lblTermTaken, gbc_lblTermTaken);

		comboBoxTerm = new JComboBox();
		comboBoxTerm.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C", "D"}));
		GridBagConstraints gbc_comboBoxTerm = new GridBagConstraints();
		gbc_comboBoxTerm.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxTerm.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxTerm.gridx = 1;
		gbc_comboBoxTerm.gridy = 3;
		contentPanel.add(comboBoxTerm, gbc_comboBoxTerm);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setEnabled(false);
		GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
		gbc_btnSubmit.anchor = GridBagConstraints.EAST;
		gbc_btnSubmit.gridx = 1;
		gbc_btnSubmit.gridy = 4;
		contentPanel.add(btnSubmit, gbc_btnSubmit);

		class DocListener implements DocumentListener{
				public void changedUpdate(DocumentEvent e){check();}
				public void removeUpdate(DocumentEvent e) {check();}
				public void insertUpdate(DocumentEvent e) {check();}
				private void check(){
					if(instructorNameValue.getText().trim().equals("") || courseNameValue.getText().trim().equals("")){
						btnSubmit.setEnabled(false);
					}else{
						btnSubmit.setEnabled(true);
					}
				}
		}
		DocListener DocwideListener = new DocListener();
		instructorNameValue.getDocument().addDocumentListener(DocwideListener);
		courseNameValue.getDocument().addDocumentListener(DocwideListener);
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				courseName = courseNameValue.getText().trim();
				instructorName = instructorNameValue.getText().trim();
				year = (String)comboBoxYear.getSelectedItem();
				term = (String)comboBoxTerm.getSelectedItem();
				CourseInputDialog.this.dispose();
			}
		});
	}

	public String getCourseName() {
		return courseName;
	}

	public String getInstructorName() {
		return instructorName;
	}

	public String getYear() {
		return year;
	}

	public String getTerm() {
		return term;
	}
}

