/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package poly_and_strings;

/**
 *
 * @author erso
 */
public class ToLowerManip extends AbstractManiplulable {

    public ToLowerManip(String originalString) {
        super(originalString);
    }

    @Override
    public String manip() {
        return originalString.toLowerCase(); //To change body of generated methods, choose Tools | Templates.
    }

}
