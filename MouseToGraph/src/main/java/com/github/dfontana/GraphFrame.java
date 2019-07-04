package com.github.dfontana;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;

public class GraphFrame extends JFrame {
    private GraphPanel gPanel;
    private Graph graph;

    public GraphFrame(Graph passedGraph) {
        try {
            graph = passedGraph;
            gPanel = new GraphPanel(graph, this);
            jbInit();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(new GridBagLayout());
        this.setSize(500, 500);
        this.setTitle("MouseToGraph - The Slider Changes the Edge Distance Threshold!");

        JSlider distSlider = new JSlider();
        distSlider.setMajorTickSpacing(10);
        distSlider.setMaximum(250);
        distSlider.setMinimum(10);
        distSlider.setOrientation(SwingConstants.VERTICAL);
        distSlider.setPaintLabels(true);
        distSlider.setPaintTicks(true);
        distSlider.setSnapToTicks(true);
        distSlider.setToolTipText("Adjust Distance Threshold");
        distSlider.setValue(50);
        distSlider.setValueIsAdjusting(true);

        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.BOTH;
        this.add(distSlider, gbc);

        gPanel.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        this.add(gPanel, gbc);

        this.pack();
        this.setVisible(true);

        distSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                if (!source.getValueIsAdjusting()) {
                    graph.setThreshold(source.getValue());
                    graph.recomputeEdges();
                }
                update();
            }
        });
    }

    public void update(){
        this.repaint();
        //graph.printAdj();
    }
}
