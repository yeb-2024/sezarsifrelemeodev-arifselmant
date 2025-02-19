package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;

public class AnaSayfa {
    JFrame frame;
    public AnaSayfa(){
        frame = new JFrame("Şifreleme Uygulaması");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(2, 1));

        JButton sifrelemeButonu = new JButton("Şifreleme Yapmak İster misiniz?");
        JButton sifreCozmeButonu = new JButton("Şifre Çözmek İster misiniz?");

        frame.add(sifrelemeButonu);
        frame.add(sifreCozmeButonu);

        sifrelemeButonu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SifrelemeSayfasi();
            }
        });

        sifreCozmeButonu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SifreCozmeSayfasi();
            }
        });

        frame.setVisible(true);
    }




}
