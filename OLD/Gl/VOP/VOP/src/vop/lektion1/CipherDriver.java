package vop.lektion1;

public class CipherDriver {

    public static void main(String[] args) {
        CipherInterface cipher;

        String message = "Hej s";
        System.out.println("Original: \n" + message);

     
        cipher = new AtbashCipher();
        String enc = cipher.encrypt(message);
        System.out.println("Atbash: \n" + enc);
        System.out.println("Decrpyted message = " + cipher.decrypt(enc));

       
        cipher = new CeasarCipher(13);
        enc = cipher.encrypt(message);
        System.out.println("Ceasar 13: \n" + enc);
        System.out.println(cipher.decrypt(enc));

    }

}
