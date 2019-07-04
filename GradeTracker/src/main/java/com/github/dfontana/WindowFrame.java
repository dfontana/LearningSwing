package com.github.dfontana;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JLabel;

public class WindowFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtAssignmentGradeValue;
	private JTextField txtCategoryGradeValue;
	private JTextField txtCourseGradeValue;
	private JTextField statusField;

	/**
	 * Create the frame.
	 */
	public WindowFrame(CourseManager courseManager) {
		setTitle("Grade Tracker!");
		setForeground(Color.WHITE);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{46, 33, 79, 79, 79, 79, 79, 0};
		gbl_contentPane.rowHeights = new int[]{160, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		JScrollPane scrollPaneCourses = new JScrollPane();
		scrollPaneCourses.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPaneCourses = new GridBagConstraints();
		gbc_scrollPaneCourses.gridwidth = 3;
		gbc_scrollPaneCourses.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPaneCourses.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneCourses.gridx = 0;
		gbc_scrollPaneCourses.gridy = 0;
		contentPane.add(scrollPaneCourses, gbc_scrollPaneCourses);

		JList list_Course = new JList(courseManager.getModel());
		scrollPaneCourses.setViewportView(list_Course);
		list_Course.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list_Course.setLayoutOrientation(JList.VERTICAL);
		list_Course.setVisibleRowCount(-1);
		list_Course.setBackground(new Color(224, 255, 255));
		list_Course.setVisibleRowCount(4);

		JScrollPane scrollPaneCategories = new JScrollPane();
		scrollPaneCategories.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPaneCategories = new GridBagConstraints();
		gbc_scrollPaneCategories.gridwidth = 2;
		gbc_scrollPaneCategories.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPaneCategories.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneCategories.gridx = 3;
		gbc_scrollPaneCategories.gridy = 0;
		contentPane.add(scrollPaneCategories, gbc_scrollPaneCategories);

		JList list_Category = new JList();
		list_Category.setEnabled(false);
		scrollPaneCategories.setViewportView(list_Category);
		list_Category.setBackground(new Color(224, 255, 255));
		list_Category.setVisibleRowCount(4);
		

		JScrollPane scrollPaneAssignments = new JScrollPane();
		scrollPaneAssignments.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPaneAssignments = new GridBagConstraints();
		gbc_scrollPaneAssignments.gridwidth = 2;
		gbc_scrollPaneAssignments.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPaneAssignments.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneAssignments.gridx = 5;
		gbc_scrollPaneAssignments.gridy = 0;
		contentPane.add(scrollPaneAssignments, gbc_scrollPaneAssignments);

		JList list_Assignment = new JList();
		list_Assignment.setEnabled(false);
		scrollPaneAssignments.setViewportView(list_Assignment);
		list_Assignment.setBackground(new Color(224, 255, 255));

		JButton addBtn_Course = new JButton("+");

		GridBagConstraints gbc_addBtn_Course = new GridBagConstraints();
		gbc_addBtn_Course.gridwidth = 2;
		gbc_addBtn_Course.anchor = GridBagConstraints.NORTHEAST;
		gbc_addBtn_Course.insets = new Insets(0, 0, 5, 5);
		gbc_addBtn_Course.gridx = 0;
		gbc_addBtn_Course.gridy = 1;
		contentPane.add(addBtn_Course, gbc_addBtn_Course);

		JButton subBtn_Course = new JButton("-");
		subBtn_Course.setEnabled(false);
		GridBagConstraints gbc_subBtn_Course = new GridBagConstraints();
		gbc_subBtn_Course.anchor = GridBagConstraints.NORTHWEST;
		gbc_subBtn_Course.insets = new Insets(0, 0, 5, 5);
		gbc_subBtn_Course.gridx = 2;
		gbc_subBtn_Course.gridy = 1;
		contentPane.add(subBtn_Course, gbc_subBtn_Course);

		JButton addBtn_Category = new JButton("+");
		addBtn_Category.setEnabled(false);
		GridBagConstraints gbc_addBtn_Category = new GridBagConstraints();
		gbc_addBtn_Category.anchor = GridBagConstraints.NORTHEAST;
		gbc_addBtn_Category.insets = new Insets(0, 0, 5, 5);
		gbc_addBtn_Category.gridx = 3;
		gbc_addBtn_Category.gridy = 1;
		contentPane.add(addBtn_Category, gbc_addBtn_Category);

		JButton subBtn_Category = new JButton("-");
		subBtn_Category.setEnabled(false);
		GridBagConstraints gbc_subBtn_Category = new GridBagConstraints();
		gbc_subBtn_Category.anchor = GridBagConstraints.NORTHWEST;
		gbc_subBtn_Category.insets = new Insets(0, 0, 5, 5);
		gbc_subBtn_Category.gridx = 4;
		gbc_subBtn_Category.gridy = 1;
		contentPane.add(subBtn_Category, gbc_subBtn_Category);

		JButton addBtn_Assignment = new JButton("+");
		addBtn_Assignment.setEnabled(false);
		GridBagConstraints gbc_addBtn_Assignment = new GridBagConstraints();
		gbc_addBtn_Assignment.anchor = GridBagConstraints.NORTHEAST;
		gbc_addBtn_Assignment.insets = new Insets(0, 0, 5, 5);
		gbc_addBtn_Assignment.gridx = 5;
		gbc_addBtn_Assignment.gridy = 1;
		contentPane.add(addBtn_Assignment, gbc_addBtn_Assignment);

		JButton subBtn_Assignment = new JButton("-");
		subBtn_Assignment.setEnabled(false);
		GridBagConstraints gbc_subBtn_Assignment = new GridBagConstraints();
		gbc_subBtn_Assignment.anchor = GridBagConstraints.NORTHWEST;
		gbc_subBtn_Assignment.insets = new Insets(0, 0, 5, 0);
		gbc_subBtn_Assignment.gridx = 6;
		gbc_subBtn_Assignment.gridy = 1;
		contentPane.add(subBtn_Assignment, gbc_subBtn_Assignment);

		JLabel assignmentLabel = new JLabel("Selected Assignment Grade");
		GridBagConstraints gbc_assignmentLabel = new GridBagConstraints();
		gbc_assignmentLabel.anchor = GridBagConstraints.EAST;
		gbc_assignmentLabel.gridwidth = 2;
		gbc_assignmentLabel.insets = new Insets(0, 0, 5, 5);
		gbc_assignmentLabel.gridx = 4;
		gbc_assignmentLabel.gridy = 2;
		contentPane.add(assignmentLabel, gbc_assignmentLabel);

		txtAssignmentGradeValue = new JTextField();
		txtAssignmentGradeValue.setHorizontalAlignment(SwingConstants.LEFT);
		txtAssignmentGradeValue.setEditable(false);
		GridBagConstraints gbc_txtAssignmentGradeValue = new GridBagConstraints();
		gbc_txtAssignmentGradeValue.insets = new Insets(0, 0, 5, 0);
		gbc_txtAssignmentGradeValue.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAssignmentGradeValue.gridx = 6;
		gbc_txtAssignmentGradeValue.gridy = 2;
		contentPane.add(txtAssignmentGradeValue, gbc_txtAssignmentGradeValue);
		txtAssignmentGradeValue.setColumns(10);

		JLabel categoryLabel = new JLabel("Selected Category Grade:");
		GridBagConstraints gbc_categoryLabel = new GridBagConstraints();
		gbc_categoryLabel.anchor = GridBagConstraints.EAST;
		gbc_categoryLabel.gridwidth = 2;
		gbc_categoryLabel.insets = new Insets(0, 0, 5, 5);
		gbc_categoryLabel.gridx = 4;
		gbc_categoryLabel.gridy = 3;
		contentPane.add(categoryLabel, gbc_categoryLabel);

		txtCategoryGradeValue = new JTextField();
		txtCategoryGradeValue.setHorizontalAlignment(SwingConstants.LEFT);
		txtCategoryGradeValue.setEditable(false);
		GridBagConstraints gbc_txtCategoryGradeValue = new GridBagConstraints();
		gbc_txtCategoryGradeValue.insets = new Insets(0, 0, 5, 0);
		gbc_txtCategoryGradeValue.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCategoryGradeValue.gridx = 6;
		gbc_txtCategoryGradeValue.gridy = 3;
		contentPane.add(txtCategoryGradeValue, gbc_txtCategoryGradeValue);
		txtCategoryGradeValue.setColumns(10);

		JLabel lblStatus = new JLabel("Status:");
		GridBagConstraints gbc_lblStatus = new GridBagConstraints();
		gbc_lblStatus.insets = new Insets(0, 0, 0, 5);
		gbc_lblStatus.gridx = 0;
		gbc_lblStatus.gridy = 4;
		contentPane.add(lblStatus, gbc_lblStatus);

		statusField = new JTextField();
		statusField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		GridBagConstraints gbc_statusField = new GridBagConstraints();
		gbc_statusField.gridwidth = 3;
		gbc_statusField.insets = new Insets(0, 0, 0, 5);
		gbc_statusField.fill = GridBagConstraints.HORIZONTAL;
		gbc_statusField.gridx = 1;
		gbc_statusField.gridy = 4;
		contentPane.add(statusField, gbc_statusField);
		statusField.setColumns(10);

		JLabel courseLabel = new JLabel("Selected Course Grade:");
		GridBagConstraints gbc_courseLabel = new GridBagConstraints();
		gbc_courseLabel.anchor = GridBagConstraints.EAST;
		gbc_courseLabel.gridwidth = 2;
		gbc_courseLabel.insets = new Insets(0, 0, 0, 5);
		gbc_courseLabel.gridx = 4;
		gbc_courseLabel.gridy = 4;
		contentPane.add(courseLabel, gbc_courseLabel);

		txtCourseGradeValue = new JTextField();
		txtCourseGradeValue.setHorizontalAlignment(SwingConstants.LEFT);
		txtCourseGradeValue.setEditable(false);
		GridBagConstraints gbc_txtCourseGradeValue = new GridBagConstraints();
		gbc_txtCourseGradeValue.anchor = GridBagConstraints.NORTH;
		gbc_txtCourseGradeValue.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCourseGradeValue.gridx = 6;
		gbc_txtCourseGradeValue.gridy = 4;
		contentPane.add(txtCourseGradeValue, gbc_txtCourseGradeValue);
		txtCourseGradeValue.setColumns(10);

		/**************************************
		 * Button Listeners
		 **************************************/
		addBtn_Course.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							CourseInputDialog dialog = new CourseInputDialog();
							dialog.setVisible(true);
							
							
							String name = dialog.getCourseName();
							if(name == null){
								statusField.setText("Closed Dialog Box.");
								return;
							}

							if (courseManager.isWithin(name)){
								statusField.setText("Course Already Exists!");
								return;
							}else{
								statusField.setText("");
								int index = list_Course.getSelectedIndex(); //get selected index
								if (index == -1) { //no selection, so insert at beginning
									index = 0;
								} else {           //add after the selected item
									index++;
								}
								
								
								Course newCourse = new Course(name, dialog.getInstructorName(), dialog.getYear(), dialog.getTerm());
								courseManager.addCourse(newCourse);
								list_Course.setSelectedIndex(index);
								list_Course.ensureIndexIsVisible(index);
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}

					

				});

			}
		});
		subBtn_Course.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = list_Course.getSelectedIndex();
				courseManager.deleteCourse(index);
				
				int size = courseManager.getSize();

				if (size == 0){ 
					subBtn_Course.setEnabled(false);
				}
				else{
					if (index == size) { index--;}
					list_Course.setSelectedIndex(index);
					list_Course.ensureIndexIsVisible(index);
				}
			}
		});

		addBtn_Category.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							CategoryInputDialog dialog = new CategoryInputDialog();
							dialog.setVisible(true);
							
							Course parentCourse = courseManager.getElementAt(list_Course.getSelectedIndex());
							String name = dialog.getName();
							
							if(name == null){
								statusField.setText("Closed Dialog Box.");
								return;
							}
							
							if (parentCourse.isWithin(name)){
								statusField.setText("Category Already Exists!");
								return;
							}
							
							if(parentCourse.isTotalWeight(dialog.getWeight()/100)){
								statusField.setText("Weights must sum to 100 for a Course");
								return;
							}
							
							statusField.setText("");
							int index = list_Category.getSelectedIndex(); //get selected index
							if (index == -1) { //no selection, so insert at beginning
								index = 0;
							} else {           //add after the selected item
								index++;
							}

							Category newCategory = new Category(name, dialog.getWeight()/100);
							parentCourse.addCategory(newCategory);
							list_Category.setSelectedIndex(index);
							list_Category.ensureIndexIsVisible(index);
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		subBtn_Category.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = list_Category.getSelectedIndex();
				Course parentCourse = courseManager.getElementAt(list_Course.getSelectedIndex());
				DefaultListModel parentModel = parentCourse.getCategoryModel();
				
				parentCourse.deleteCategory((Category)list_Category.getModel().getElementAt(list_Category.getSelectedIndex()), index);

				int size = parentModel.getSize();

				if (size == 0){ 
					subBtn_Category.setEnabled(false);
				}
				else{
					if (index == size) { index--;}
					list_Category.setSelectedIndex(index);
					list_Category.ensureIndexIsVisible(index);
				}
			}
		});

		addBtn_Assignment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							AssignmentInputDialog dialog = new AssignmentInputDialog();
							dialog.setVisible(true);
							Category parentCategory = (Category)list_Category.getModel().getElementAt(list_Category.getSelectedIndex());
							String name = dialog.getName();
							
							if(name == null){
								statusField.setText("Closed Dialog Box.");
								return;
							}
							
							if (parentCategory.isWithin(name)){
								statusField.setText("Assignment Already Exists!");
								return;
							}else{
								statusField.setText("");
								int index = list_Assignment.getSelectedIndex(); //get selected index
								if (index == -1) { //no selection, so insert at beginning
									index = 0;
								} else {           //add after the selected item
									index++;
								}
								
								Assignment newAssignment = new Assignment(name, dialog.getEarned(), dialog.getTotal());
								parentCategory.addAssignment(newAssignment);
								list_Assignment.setSelectedIndex(index);
								list_Assignment.ensureIndexIsVisible(index);
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		subBtn_Assignment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = list_Assignment.getSelectedIndex();
				Category parentCategory = (Category)list_Category.getModel().getElementAt(list_Category.getSelectedIndex());
				DefaultListModel parentModel = parentCategory.getAssignmentModel();
				
				parentCategory.deleteAssignment((Assignment)list_Assignment.getModel().getElementAt(list_Assignment.getSelectedIndex()), index);

				int size = parentModel.getSize();

				if (size == 0){ 
					subBtn_Assignment.setEnabled(false);
				}
				else{
					if (index == size) { index--;}
					list_Assignment.setSelectedIndex(index);
					list_Assignment.ensureIndexIsVisible(index);
				}
			}
		});

		/**************************************
		 * List Listeners
		 **************************************/
		list_Course.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (e.getValueIsAdjusting() == false) {
					if (list_Course.getSelectedIndex() == -1) {
						list_Category.setEnabled(false);
						addBtn_Category.setEnabled(false);
						subBtn_Course.setEnabled(false);
						list_Category.setModel(new DefaultListModel()); // No selection means no categories should be visible
						list_Assignment.setModel(new DefaultListModel());
						txtCourseGradeValue.setText("");
					} else {
						list_Category.setEnabled(true);
						addBtn_Category.setEnabled(true);
						subBtn_Course.setEnabled(true);	
						Course selectedCourse = courseManager.getElementAt(list_Course.getSelectedIndex());
						list_Category.setModel(selectedCourse.getCategoryModel());
						txtCourseGradeValue.setText(((Double)((((Course)courseManager.getElementAt(list_Course.getSelectedIndex())).computeGrade())*100.0)).toString());
					}
				}
			}
		});

		list_Category.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (e.getValueIsAdjusting() == false) {
					if (list_Category.getSelectedIndex() == -1) {
						list_Assignment.setEnabled(false);
						addBtn_Assignment.setEnabled(false);
						subBtn_Category.setEnabled(false);
						list_Assignment.setModel(new DefaultListModel());
						txtCourseGradeValue.setText(((Double)((((Course)courseManager.getElementAt(list_Course.getSelectedIndex())).computeGrade())*100.0)).toString());;
						txtCategoryGradeValue.setText("");
					} else {
						list_Assignment.setEnabled(true);
						addBtn_Assignment.setEnabled(true);
						subBtn_Category.setEnabled(true);
						try{
							Category parentCategory = (Category)list_Category.getModel().getElementAt(list_Category.getSelectedIndex());
							txtCourseGradeValue.setText(((Double)((((Course)courseManager.getElementAt(list_Course.getSelectedIndex())).computeGrade())*100.0)).toString());						
							txtCategoryGradeValue.setText(((Double)((((Category)list_Category.getModel().getElementAt(list_Category.getSelectedIndex())).computeGrade())*100.0)).toString());
							list_Assignment.setModel(parentCategory.getAssignmentModel());
						}catch(Exception e1){
							list_Assignment.setEnabled(false);
							addBtn_Assignment.setEnabled(false);
							list_Assignment.setModel(new DefaultListModel());
							txtCategoryGradeValue.setText("0.0");
						}
						
					}
				}
			}
		});

		list_Assignment.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (e.getValueIsAdjusting() == false) {
					txtCourseGradeValue.setText(((Double)((((Course)courseManager.getElementAt(list_Course.getSelectedIndex())).computeGrade())*100.0)).toString());
					txtCategoryGradeValue.setText(((Double)((((Category)list_Category.getModel().getElementAt(list_Category.getSelectedIndex())).computeGrade())*100.0)).toString());
					
					if (list_Assignment.getSelectedIndex() == -1) {
						subBtn_Assignment.setEnabled(false);
						txtAssignmentGradeValue.setText("");
					} else {
						subBtn_Assignment.setEnabled(true);
						Assignment parentAssignment = (Assignment)list_Assignment.getModel().getElementAt(list_Assignment.getSelectedIndex());
						txtAssignmentGradeValue.setText(((Double)(parentAssignment.computeGrade()*100.0)).toString());
					}
				}
			}
		});
	}
}
