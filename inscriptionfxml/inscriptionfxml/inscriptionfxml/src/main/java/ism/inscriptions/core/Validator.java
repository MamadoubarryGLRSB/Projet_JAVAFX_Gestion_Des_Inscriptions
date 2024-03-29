package ism.inscriptions.core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public static boolean isEmail(String field){
        Pattern pattern=Pattern.compile("[a-zA-Z0-9]*@(gmail|yahoo){1}(.com|.fr){1}",Pattern.CASE_INSENSITIVE);
                Matcher matcher=pattern.matcher(field);
                return(matcher.find() && matcher.group().equals(field));

    }
    
}
