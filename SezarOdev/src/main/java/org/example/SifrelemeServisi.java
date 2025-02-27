package org.example;

public class SifrelemeServisi {
    String SYMBOLS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public String encrypt(String message, int key) {
        int mesajUzunluk = message.length();
        String sonuc = "";
        for (int i = 0; i < mesajUzunluk; i++) {
            char harf = message.charAt(i);
            if (harf == ' '){
                sonuc +=  " ";
                continue;
            }
            char buyukHarf = Character.toUpperCase(harf);
            int index = SYMBOLS.indexOf(buyukHarf);
            int yeniIndex = (index + key) % SYMBOLS.length();
            char yeniHarf = SYMBOLS.charAt(yeniIndex);
            sonuc += yeniHarf;
        }
        return sonuc;
    }

    public String decript(String sifre, int key){
        int mesajUzunluk = sifre.length();
        String sonuc = "";

        for (int i = 0; i < mesajUzunluk; i++) {
            char harf = sifre.charAt(i);
            if (harf== ' '){
                sonuc+= " ";
                continue;

            }

            char buyukHarf = Character.toUpperCase(harf);
            int index = SYMBOLS.indexOf(buyukHarf);
            int yeniIndex = ((index - key ) + SYMBOLS.length()) % SYMBOLS.length(); // (-2 + 26) % 26 = -2
            char yeniHarf = SYMBOLS.charAt(yeniIndex);
            sonuc+= yeniHarf;

            
        }
        return sonuc;
    }

}
