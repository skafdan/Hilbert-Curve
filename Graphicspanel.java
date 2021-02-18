/**
 * Etude 3 - Hilbert Curve graphics class
 * @author Dan Skaf
 **/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;


public class Graphicspanel extends JPanel implements ComponentListener{
    private Hilbert hObject;
    private int order;
  
    public Graphicspanel(int order){
        this.order = order;
        this.hObject = new Hilbert(Color.BLACK,order);
        addComponentListener(this);
        setPreferredSize(new Dimension(1024,1024));
    }
    /**
     * paint component
     * @param Grahpics g
     */
    public void paintComponent(Graphics g){
            Graphics2D g2d = (Graphics2D)g;
            super.paintComponent(g2d);
            hObject.display(g2d);
    }
    /**
     * Component listener for window resize
     * @param ComponentEvent e
     **/
    public void componentResized(ComponentEvent e){
        hObject.getDim(getWidth(),getHeight());
        repaint();
    }
    //unused abstract functions
    public void componentHidden(ComponentEvent e)
    {
    } 

    public void componentMoved(ComponentEvent e)
    {
    }
 
    public void componentShown(ComponentEvent e)
    {
    }
 }