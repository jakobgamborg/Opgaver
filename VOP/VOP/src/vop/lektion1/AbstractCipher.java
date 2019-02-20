/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vop.lektion1;

/**
 *
 * @author welov
 */
public abstract class AbstractCipher implements CipherInterface {
    protected int findCharIndex (char ch ) {
        int charLength = ALPHABETH.length;
        int returnInt = -1;
        for(int i = 0; i< charLength-1; i++) {
            char charInAlphabeth = ALPHABETH[i];
               if (charInAlphabeth == ch){
                   returnInt = i;
                   return returnInt;
               }
        }
        return returnInt;
    }
}
