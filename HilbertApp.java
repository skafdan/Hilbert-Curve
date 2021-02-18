/**
 * Etude 3 - Hilbert Curve App
 * @author Dan Skaf 
 */
import javax.swing.*;
import java.awt.*;

public class HilbertApp{
    public static void main(String[] args){
        try{
            int order = Integer.parseInt(args[0]);
            if(order > 11 || order <= 0){
                System.err.println("Unexpected input. Expected" +
                    ": 'java HilbertApp <n>' n = (1 - 11).");
                    System.exit(1);
            }
            JFrame frame = new JFrame("Hilbert");
            frame.pack();
            frame.setSize(1024,1024);
            frame.setLocationRelativeTo(null); 
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(new Graphicspanel(order));
            frame.pack();
            frame.setVisible(true);
        }catch (Exception e){
            if(e instanceof ArrayIndexOutOfBoundsException ||
                e instanceof NumberFormatException){
                    System.err.println("Unexpected input. Expected" +
                        ": 'java HilbertApp <n>' n = (1 - 11).");
                } else {
                    System.err.println(e);
                }
        }
    }
}