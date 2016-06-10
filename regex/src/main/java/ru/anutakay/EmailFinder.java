package ru.anutakay;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by akaygorodova@issart.com on 12.05.2016.
 */
public class EmailFinder {


    private Pattern pattern = Pattern.compile("(^|[\\?!\\s,;:])([^,\\s;:\\?!]+@[^;,\\?!\\s\\(\\)\\[\\]]+[^;,\\?!\\s\\.\\(\\)\\[\\]]+)\\.?([,;\\?!|\\s\\(\\)\\[\\]]|$)");

    public EmailFinder() {

    }

    public String[] findEmailByCandidate(String source) {

        Matcher matcher = pattern.matcher(source);

        List<String> result = new ArrayList<String>();

        while (matcher.find()) {
            String candidate = matcher.group(2);
            EmailValidator emailMatcher = new EmailValidator(candidate);
            boolean isFound = emailMatcher.isEmail();
            if (isFound) {
                result.add(emailMatcher.email());
            }
        }
        String[] res = new String[result.size()];
        return result.toArray(res);
    }

    public String[] findEmails2(String source) {

        EmailMatcher emailMatcher = new EmailMatcher(source);

        List<String> result = new ArrayList<String>();

        while (emailMatcher.find()) {
            result.add(emailMatcher.email());
        }
        String[] res = new String[result.size()];
        return result.toArray(res);
    }
}
