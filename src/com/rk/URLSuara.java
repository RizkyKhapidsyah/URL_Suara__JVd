package com.rk;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class URLSuara extends JFrame {

    AudioInputStream suara;
    String eror1 = "Tidak Ada Error";
    String eror2 = "Tidak Ada Error";
    String eror3 = "Tidak Ada Error";

    public URLSuara() {
        URL url = this.getClass().getResource("ContohSuara.wav");

        try {
            suara = AudioSystem.getAudioInputStream(url);
            Clip klip = AudioSystem.getClip();
            klip.open(suara);
            klip.loop(0);
        } catch (UnsupportedAudioFileException e) {
            eror1 = e.toString();
        } catch (IOException e) {
            eror2 = e.toString();
        } catch (LineUnavailableException e) {
            eror3 = e.toString();
        }

        setTitle("Percobaan URL Suara");
        setSize(250, 200);
        setVisible(true);
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    }

    @Override
    public void paint(Graphics g) {
        g.drawString("Eror 1 : " + eror1, 10, 50);
        g.drawString("Eror 2 : " + eror2, 10, 100);
        g.drawString("Eror 3 : " + eror3, 10, 150);
    }


}
