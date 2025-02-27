package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SifreCozmeSayfasi implements ActionListener {
    JFrame frame;
    JTextField keyTextField;
    JTextField passTextField;
    JButton sifreleButon;
    Font font;
    SifrelemeServisi sifrelemeServisi;

    public SifreCozmeSayfasi(){
        frame = new JFrame("Şifre Çözme Sayfası");
        font = new Font("Arial",Font.BOLD,20);
        keyTextField = TextFieldOlustur();
        passTextField = TextFieldOlustur();
        sifreleButon = butonOlustur("Çöz");
        sifrelemeServisi = new SifrelemeServisi();

    }

    public void baslat(){
        JPanel ustPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        ustPanel.add(new JLabel("Anahtar"));
        ustPanel.add(keyTextField);

        JPanel altPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        altPanel.add(new JLabel("Şifre"));
        altPanel.add(passTextField);

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
        String sifre = passTextField.getText().trim();
        String mesaj = sifrelemeServisi.decript(sifre,Integer.parseInt(anahtar));
        System.out.println("Anahtar: " + anahtar);
        System.out.println("Şifre : " + sifre);
        System.out.println("Mesaj: " + mesaj);

        JOptionPane.showMessageDialog(frame, "Mesaf: "+mesaj,"Şifreleme Sonucu",JOptionPane.INFORMATION_MESSAGE     );
        System.out.println(mesaj);

    }
}
