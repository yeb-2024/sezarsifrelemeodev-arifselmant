package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnaSayfa implements ActionListener {
    JFrame frame;
    JLabel label;
    JButton encriptButon;
    JButton decripctButon;
    JPanel panel;
    Font font;

    public AnaSayfa(){
        frame = new JFrame("AnaSayfa");
        label = new JLabel("Sezar Şifreleme Uygulması");
        encriptButon = butonOlustur("Şifrele");
        decripctButon = butonOlustur ("Şifre Çöz");
        panel = new JPanel();
        font = new Font("Arial", Font.BOLD,20);
    }

    public void basla(){
        frame.setLayout(new GridLayout(2,1));
        frame.setSize(300,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setFont(font);

        frame.add(label);


        panel.setLayout(new FlowLayout());
        panel.add(decripctButon);
        panel.add(encriptButon);
        frame.add(panel);



        frame.setVisible(true);

    }

    public JButton butonOlustur(String yazi){
        JButton button = new JButton(yazi);
        button.setFont(font);
        button.addActionListener(this);
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == encriptButon){
            SifrelemeSayfasi sifrelemeSayfasi = new SifrelemeSayfasi();
            sifrelemeSayfasi.baslat();
            frame.dispose();

        }
        if (e.getSource() == decripctButon){
            SifreCozmeSayfasi sifreCozmeSayfasi = new SifreCozmeSayfasi();
            sifreCozmeSayfasi.baslat();
            frame.dispose();
        }

    }



}

