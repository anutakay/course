package ru.anutakay;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by akaygorodova@issart.com on 12.05.2016.
 */
public class EmailMatcher {

    final static String patternString = "(([0-9a-zA-Z][a-zA-Z0-9\\-'_\\+]*\\.?)+[a-zA-Z0-9][a-zA-Z0-9\\-'_\\+]*@([a-zA-Z0-9][a-zA-Z0-9\\-]*\\.)+[a-zA-Z]{2,})";

    String source;

    Matcher matcher;

    EmailMatcher(String source) {
        this.source = source;
        Pattern pattern = Pattern.compile(patternString);
        matcher = pattern.matcher(source);
    }

    public boolean isEmail() {
        Pattern pattern = Pattern.compile("^" + patternString + "$");
        matcher = pattern.matcher(source);
        return matcher.matches();
    }

    public boolean find() {
        return matcher.find();
    }

    public String email() {
        String email;
        try {
            email = matcher.group(1);
        } catch (IllegalStateException e) {
            throw new IllegalStateException("No email found");
        }
        return email;
    }
}