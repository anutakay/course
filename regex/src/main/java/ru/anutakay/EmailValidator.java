package ru.anutakay;


/**
 * Created by akaygorodova@issart.com on 10.06.2016.
 */
public class EmailValidator {

    EmailMatcherDelegate matcher;

    EmailValidator(String source) {
        matcher = new EmailMatcherDelegate(source, "^", "$");
    }

    public boolean isEmail() {
        return matcher.matches();
    }

    public String email() {
        return matcher.email();
    }
}

