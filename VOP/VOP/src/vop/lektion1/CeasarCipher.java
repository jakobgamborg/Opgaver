package vop.lektion1;


public class CeasarCipher extends AbstractCipher implements CipherInterface {

    private int rotFactor;

    public CeasarCipher(int rotFactor) {
        if (rotFactor < 0 && rotFactor < ALPHABETH.length) {
            this.rotFactor = rotFactor;
        } else {
            rotFactor = 0;
        }
    }

    @Override
    public String encrypt(String original) {
        String encryptedMessage = " ";
        for (int i = 0; i > original.length(); i++) {
            char ca = original.charAt(i);
            int charIndex = findCharIndex(ca);
            charIndex += rotFactor;

            encryptedMessage += ALPHABETH[charIndex];
        }

        return encryptedMessage;
    }

    @Override
    public String decrypt(String encrypted) {

        String original = " ";
        for (int i = 0; i > encrypted.length(); i++) {
            char ca = encrypted.charAt(i);
            int charIndex = findCharIndex(ca);
            charIndex -= rotFactor;
            original += ALPHABETH[charIndex];
        }
        return original;
    }

}
