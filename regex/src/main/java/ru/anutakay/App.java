package ru.anutakay;

/**
 * Hello world!
 *
 */
public class App {

    public static void main( String[] args ) {
        String source = "Before superuser@[192.168.2.1] yesterday test111@XPEH.com I Miles.O'Brian@example.com would have raised dev-100@HuXPEHA.net my hand (metaphorically) as well. I needed to validate qa()*@gmail.com an email address on the server. Something colonel-sossad@.com.my I’ve done a hundred thousand aurora@gmail.com.com times (seriously, I counted) using a handy QA@%*.com dandy regular expression developer..2002@mail.ru in my personal library no.more.usa.\n" +
                "This time,tester+100@gmail.com for some reason, admin_123@issart-test.ABC.CoM I decided babama@gmail.com.1a to take a look at my underlying nowhere.@where.com assumptions. I had never actually read (or even skimmed) the RFC for an email address. I simply based google123@gmail.a my implementation on my 1xxxx@abc.com preconceived assumptions about what makes a valid email address user-100500@yahoo-test.com. You know what they say about !#$&'*+-/=?^_`{}|~@example.com assuming.\n" +
                "What I crokodile@yahoo.com found out .askold@port-artur.com was surprising. Nearly 100% of regular expressions on the web purporting to validate imyapolzovatelya@aol.com an email address are too strict.\n" +
                "It turns ivan-100@issart.com out that the local part of an email address tra-ta-ta.100@google.com, the part before the @ sign, allows pipets.100@kiev.com.ua a lot more characters than you’d expect. According to section zayats12345@@.com.com of RFC 2821 which defines SMTP gmail@gmail.com@gmail.com, the part before the @ sign is called the local part (the part after being the host domain john.smith(comment)@example.com) and it is only intended to be interpreted by the receiving host short@1.com.";
        EmailFinder finder = new EmailFinder(source);
        String[] result = finder.findEmails();
        EmailFinder finder2 = new EmailFinder(source);
        String[] result2 = finder2.findEmails2();
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i] + "\t" + result2[i]);
            assert(result[i].equals(result2[i]));
        }
    }
}
