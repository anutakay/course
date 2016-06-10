package ru.anutakay;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by akaygorodova@issart.com on 10.06.2016.
 */
public class EmailMatcherDelegate {

    static final String DEFAULT_PATTERN = "(([0-9a-zA-Z][a-zA-Z0-9\\-'_\\+]*\\.?)+[a-zA-Z0-9][a-zA-Z0-9\\-'_\\+]*@([a-zA-Z0-9][a-zA-Z0-9\\-]*\\.)+[a-zA-Z]{2,})";

    private String patternString = DEFAULT_PATTERN;

    private String source;

    protected Matcher matcher;

    public EmailMatcherDelegate(String source) {
        this(source, "", "");
    }

    public EmailMatcherDelegate(String source, String prefix, String postfix) {
        this.source = source;
        Pattern pattern = Pattern.compile(getPatternString());
        matcher = pattern.matcher(source);
    }

    protected String getPatternString() {
        return patternString;
    }

    public boolean matches() {
        return matcher.matches();
    }

    public String group(int i) {
        return matcher.group(i);
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

    public boolean find() {
        return matcher.find();
    }
}
