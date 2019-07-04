package com.github.dfontana;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GraphPanel extends JPanel{
    private Graph graph;
    private GraphFrame parentFrame;

    public GraphPanel(Graph passedGraph, GraphFrame passedFrame){
        graph = passedGraph;
        parentFrame = passedFrame;
        this.setPreferredSize(new Dimension(500, 500));
        this.addMouseListener(new CustomMouseListener());
    }

    class CustomMouseListener implements MouseListener {
        public void mouseClicked(MouseEvent e) {
            graph.addVertex(e.getX(),e.getY());
            graph.edgeCheck();
            parentFrame.update();
        }

        public void mousePressed(MouseEvent e){}
        public void mouseReleased(MouseEvent e){}
        public void mouseEntered(MouseEvent e){}
        public void mouseExited(MouseEvent e){}
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(rh);

        if (graph != null) {
            for (int v = 0; v < graph.V(); v++){            //For every vertex v
                int vX = graph.getVertex(v).x;
                int vY = graph.getVertex(v).y;
                for(int w : graph.adj(v)) {                  // For every vertex adjacent to v, w
                    int wX = graph.getVertex(w).x;
                    int wY = graph.getVertex(w).y;
                    g2d.setColor(Color.black);
                    g2d.setStroke(new BasicStroke(3));
                    g2d.drawLine(vX, vY, wX, wY);
                }
            }
            for(int v = 0; v < graph.V(); v++){
                int vX = graph.getVertex(v).x;
                int vY = graph.getVertex(v).y;
                paintNode(g2d, Integer.toString(v), vX, vY);  // Paint vertex v
            }
        }
    }

    protected void paintNode(Graphics2D g2d, String name, int x, int y) {
        int len = name.length() * 10 + 6;
        g2d.setColor(Color.cyan);
        g2d.fillOval(x - (len / 2), y - (len / 2), len, len);
        g2d.setColor(Color.black);
        g2d.setFont(new Font("Monospaced", Font.PLAIN, 14));
        g2d.drawString(name, x - (len / 2) + 4,  y - (len / 2) + 14);
    }

}
