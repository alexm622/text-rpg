package rpg.guis.canvas;

import java.awt.Canvas;
import java.awt.Graphics;

import javax.swing.JFrame;

import rpg.game.Handler;
import rpg.objects.map.MapAsTiles;

public class DrawMapCanvas {

    //private vars

    private JFrame frame;
    private Canvas c;
    private Graphics g;
    private Handler h;
    private MapAsTiles m;

    public DrawMapCanvas(Handler h, JFrame frame){
        this.frame = frame;
        this.h = h;
        draw();
    }

    private void draw(){

    }

}