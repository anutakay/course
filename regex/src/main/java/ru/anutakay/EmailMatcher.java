package ru.anutakay;

/**
 * Created by akaygorodova@issart.com on 12.05.2016.
 */
public class EmailMatcher  {

    EmailMatcherDelegate matcher;

    EmailMatcher(String source) {
        matcher = new EmailMatcherDelegate(source);
    }

    public boolean find() {
        return matcher.find();
    }

    public String email() {
        return matcher.email();
    }

}