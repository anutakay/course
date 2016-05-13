package ru.anutakay;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by akaygorodova@issart.com on 12.05.2016.
 */
public class EmailMatcher {

    String patternString = "(([0-9a-zA-Z][a-zA-Z0-9\\-'_\\+]*\\.?)+[a-zA-Z0-9][a-zA-Z0-9\\-'_\\+]*@[a-zA-Z0-9][[a-zA-Z0-9\\-]*\\.[a-zA-Z0-9]]*\\.[a-zA-Z]{2,})";

    public boolean matches(String str) {
        Pattern pattern = Pattern.compile("^" + patternString + "$");
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    public String find(String str) {
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(str);
        if(matcher.find()) {
            return matcher.group(1);
        } else
            return null;
    }
}