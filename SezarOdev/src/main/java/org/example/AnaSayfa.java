package org.example;

import javax.swing.*;
import java.awt.*;
import java.io.FileReader;

public class AnaSayfa {
    JFrame frame;
    public AnaSayfa(){
        frame = new JFrame("Şifreleme Uygulaması");
        frame.setSize(300,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(2,1));

        JButton sifrelemeButonu = new JButton("Şifreleme Yapmak İstermisiniz?");
        JButton sifreCozmeButonu = new JButton("Şifre Çözmek İstermisiniz ?");

        frame.add(sifrelemeButonu);
        frame.add(sifreCozmeButonu);

        frame.setVisible(true);

    }
}
