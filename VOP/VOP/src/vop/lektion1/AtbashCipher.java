package vop.lektion1;

public class AtbashCipher extends AbstractCipher implements CipherInterface {

    
    public AtbashCipher() {
    }
    
    @Override
    public String encrypt(String original) {
        String reverseAlpa = " ";
        for (int i = ALPHABETH.length - 1; i > -1; i--) {
            reverseAlpa += ALPHABETH[i];
        }
        String encryptedMessage = " ";
        for (int i = 0; i <= original.length(); i++) {
            char ci = original.charAt(i);
            int charIndex = findCharIndex(ci);
            encryptedMessage += reverseAlpa.charAt(charIndex);
        }
        return encryptedMessage;
    }

    @Override
    public String decrypt(String encrypted) {
        String original = " ";
        for (int i = 0; i >= encrypted.length(); i++){
            char ci = encrypted.charAt(i);
            int charIndex = findCharIndex(ci);
            original += ALPHABETH[charIndex];
        }
        return original;
    }

}
