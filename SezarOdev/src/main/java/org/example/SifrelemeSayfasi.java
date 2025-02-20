package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SifrelemeSayfasi {

    JTextField keyField, mesajField, sonucField;
    JButton sifreleButonu;
    JFrame frame;
    public SifrelemeSayfasi() {
        frame.setTitle("Şifreleme Sayfası");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null);

        JLabel keyLabel = new JLabel("Anahtar (0-25):");
        keyLabel.setBounds(10, 10, 100, 25);
        frame.add(keyLabel);

        keyField = new JTextField();
        keyField.setBounds(120, 10, 150, 25);
        frame.add(keyField);

        JLabel mesajLabel = new JLabel("Mesaj:");
        mesajLabel.setBounds(10, 40, 100, 25);
        frame.add(mesajLabel);

        mesajField = new JTextField();
        mesajField.setBounds(120, 40, 150, 25);
        frame.add(mesajField);

        sifreleButonu = new JButton("Şifrele");
        sifreleButonu.setBounds(10, 70, 260, 30);
        frame.add(sifreleButonu);

        sonucField = new JTextField();
        sonucField.setBounds(10, 110, 260, 25);
        sonucField.setEditable(false);
        frame.add(sonucField);

        sifreleButonu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int key = Integer.parseInt(keyField.getText());
                String mesaj = mesajField.getText();
                sonucField.setText(sezarSifrele(mesaj, key));
            }
        });

        frame.setVisible(true);
    }

    private String sezarSifrele(String mesaj, int key) {
        StringBuilder sifreliMetin = new StringBuilder();
        for (char ch : mesaj.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                sifreliMetin.append((char) ((ch - base + key) % 26 + base));
            } else {
                sifreliMetin.append(ch);
            }
        }
        return sifreliMetin.toString();
    }
}

