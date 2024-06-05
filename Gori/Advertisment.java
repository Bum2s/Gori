package com.project1;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;

public class Advertisment extends Frame {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Image ad = new ImageIcon(Advertisment.class.getResource("/image/ad.png")).getImage();

    public Advertisment() {
    	 setTitle("아이티윌 인원 모집중!!");
         setSize(400, 600);
         setResizable(false);
         setLocationRelativeTo(null);
         setLayout(null);
         setVisible(true);
         addWindowListener(new WindowAdapter() {
             public void windowClosing(WindowEvent e) {
                 setVisible(false); 
             }
         });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(ad, 0, 0, null);
    }

    public void start() {
        new Advertisment();
    }

   
}