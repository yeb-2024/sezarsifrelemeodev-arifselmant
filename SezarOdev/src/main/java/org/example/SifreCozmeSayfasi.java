package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SifreCozmeSayfasi {
    JTextField keyField, sifreliMesajField, sonucField;
    JButton cozButonu;
    JFrame frame;

    public SifreCozmeSayfasi() {
        frame.setTitle("Şifre Çözme Sayfası");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null);

        JLabel keyLabel = new JLabel("Anahtar (0-25):");
        keyLabel.setBounds(10, 10, 100, 25);
        frame.add(keyLabel);

        keyField = new JTextField();
        keyField.setBounds(120, 10, 150, 25);
        frame.add(keyField);

        JLabel mesajLabel = new JLabel("Şifreli Mesaj:");
        mesajLabel.setBounds(10, 40, 100, 25);
        frame.add(mesajLabel);

        sifreliMesajField = new JTextField();
        sifreliMesajField.setBounds(120, 40, 150, 25);
        frame.add(sifreliMesajField);

        cozButonu = new JButton("Çöz");
        cozButonu.setBounds(10, 70, 260, 30);
        frame.add(cozButonu);

        sonucField = new JTextField();
        sonucField.setBounds(10, 110, 260, 25);
        sonucField.setEditable(false);
        frame.add(sonucField);

        cozButonu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int key = Integer.parseInt(keyField.getText());
                String sifreliMesaj = sifreliMesajField.getText();
                sonucField.setText(sezarCoz(sifreliMesaj, key));
            }
        });

        frame.setVisible(true);
    }

    private String sezarCoz(String sifreliMesaj, int key) {
        StringBuilder cozulmusMetin = new StringBuilder();
        for (char ch : sifreliMesaj.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                cozulmusMetin.append((char) ((ch - base - key + 26) % 26 + base));
            } else {
                cozulmusMetin.append(ch);
            }
        }
        return cozulmusMetin.toString();
    }
}
