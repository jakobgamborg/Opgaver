/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vop.lektion1;

import jdk.nashorn.internal.ir.BreakNode;

/**
 *
 * @author welov
 */
public abstract class AbstractCipher implements CipherInterface {
    protected int findCharIndex (char ch ) {
        int returnInt = -1;
        if(Character.isLetter(ch) == false) {
           return returnInt;
        }
        for(int i = 0; i< ALPHABETH.length; i++) {
            char charInAlphabeth = ALPHABETH[i];
               if (charInAlphabeth == ch){
                   returnInt = i;
                   return returnInt;
               }
        }
        return returnInt;
    }
}
