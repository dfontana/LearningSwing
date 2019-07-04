package com.github.dfontana;

import java.awt.EventQueue;
import java.awt.Point;
import javax.swing.UIManager;

public class App {
	static Point mouseDownCompCoords;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
			        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			        CourseManager data = new CourseManager();
					final WindowFrame frame = new WindowFrame(data);
					frame.setVisible(true);
					
					frame.addWindowListener(new java.awt.event.WindowAdapter() {
					    @Override
					    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
					      // data.writeToFile();
					    }
					});

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		
	}
}
