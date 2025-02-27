package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SifrelemeSayfasi implements ActionListener {
    JFrame frame;
    JTextField keyTextField;
    JTextField mesajTextField;
    JButton sifreleButon;
    Font font;
    SifrelemeServisi sifrelemeServisi;

    public SifrelemeSayfasi(){
        frame = new JFrame("Şifrelme Sayfası");
        font = new Font("Arial",Font.BOLD,20);
        keyTextField = TextFieldOlustur();
        mesajTextField = TextFieldOlustur();
        sifreleButon = butonOlustur("Şifrele");
        sifrelemeServisi = new SifrelemeServisi();

    }

    public void baslat(){

        JPanel ustPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        ustPanel.add(new JLabel("Anahtar"));
        ustPanel.add(keyTextField);

        JPanel altPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        altPanel.add(new JLabel("Mesaj"));
        altPanel.add(mesajTextField);

        frame.add(ustPanel);
        frame.add(altPanel);
        frame.add(sifreleButon);

        frame.setLayout(new GridLayout(3,1));
        frame.setSize(300,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public JTextField TextFieldOlustur(){
        JTextField textField = new JTextField();
        textField.setFont(font);
        textField.setPreferredSize(new Dimension(200,50));
        return textField;

    }

    public JButton butonOlustur(String yazi){
        JButton button = new JButton(yazi);
        button.setFont(font);
        button.addActionListener(this);
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String anahtar = keyTextField.getText().trim();
        String mesaj = mesajTextField.getText().trim();
        String sifre = sifrelemeServisi.encrypt(mesaj,Integer.parseInt(anahtar));
        System.out.println("Anahtar: " + anahtar);
        System.out.println("Mesah: " + mesaj);
        JOptionPane.showMessageDialog(frame, "Şifre: "+sifre,"Şifreleme Sonucu",JOptionPane.INFORMATION_MESSAGE     );
        System.out.println(sifre);
    }
}

