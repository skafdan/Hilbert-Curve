/**
 * Etude 3 - Hilbert Curve
 * @author Dan 
 **/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.Math;
import java.util.*;

public class Hilbert{
    Color colour;
    int order;
    int n;
    int total;
    int length;

    //Coordinates 
    int[] pathx;
    int[] pathy;

    //current window dimensions
    int width;
    int height;

    public Hilbert(Color colour, int order){
        this.colour = colour;
        this.order = order;
        this.n = (int)Math.pow(2,order);
        this.total = n * n;
        this.length = (4096)/(n);
        this.pathx = new int[total];
        this.pathy = new int[total];
        for(int i = 0; i < total; i++){
            pathx[i] = hIndextoXY(i,true);
            pathy[i] = hIndextoXY(i,false);
            pathx[i] = ((pathx[i] * length)+(length/2));
            pathy[i] = ((pathy[i] * length)+(length/2));
        }
    }

    /**
     * Converts the index of a point on the hilbert curve to a x,y point
     * @param boolean xy. true for x coordinate false for y
     * @param i, index to convert
     * @return int respective x or y coordinate.
     **/
    public int hIndextoXY(int i,boolean xy){
        //base hilbert curve
        int[] hPointx = {0,0,1,1};
        int[] hPointy = {0,1,1,0};
        int index = i & 3;
        int xIndex = hPointx[index];
        int yIndex = hPointy[index];
        for(int subOrder = 1; subOrder < order; subOrder++){
            i = i >>> 2;
            index = i & 3;
            int size = (int)Math.pow(2,subOrder);
            if(index == 0){
                int temp = xIndex;
                xIndex = yIndex;
                yIndex = temp;
            } else if (index == 1){
                yIndex += size;
            } else if (index == 2){
                xIndex += size;
                yIndex += size;
            } else if (index == 3){
                int temp = size - 1 - xIndex;
                xIndex = size - 1 - yIndex;
                yIndex = temp;
                xIndex += size;
            }
        }
        if(xy == true){
            return xIndex;
        }else {
            return yIndex;
        }
    }
    /**
     * Get the dimension of currnet window 
     * @param int width;
     * @param int height;
     **/
    public void getDim(int width, int height){
        this.width = width;
        this.height = height;
    }

    /**
     * Display function
     * @param Graphics2D g2d
     **/
    public void display(Graphics2D g2d){
        g2d.setColor(colour);
        double scaleX = (double)width/(double)4096;
        double scaleY = (double)height/(double)4096;
        g2d.scale(scaleX,scaleY);
        g2d.drawPolyline(pathx,pathy,total);
    }
}