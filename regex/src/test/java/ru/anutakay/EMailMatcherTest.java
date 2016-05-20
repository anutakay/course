package ru.anutakay;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by akaygorodova@issart.com on 12.05.2016.
 */
public class EMailMatcherTest {

    EmailMatcher emailMatcher;

    @DataProvider(name = "validEmailDataProvider")
    public Object[][] simpleDataProvider() {
        return new Object[][] {
                {"test111@XPEH.com"},
                {"Miles.O'Brian@example.com"},
                {"dev-100@HuXPEHA.net"},
                {"aurora@gmail.com.com"},
                {"tester+100@gmail.com"},
                {"admin_123@issart-test.ABC.CoM"},
                {"1xxxx@abc.com"},
                {"user-100500@yahoo-test.com"},
                {"crokodile@yahoo.com"},
                {"imyapolzovatelya@aol.com"},
                {"ivan-100@issart.com"},
                {"tra-ta-ta.100@google.com"},
                {"pipets.100@kiev.com.ua"},
                {"short@1.com"}
        };
    }

    @DataProvider(name = "invalidEmailDataProvider")
    public Object[][] simpleDataProvider1() {
        return new Object[][] {
                {"qa()*@gmail.com"},
                {"colonel-sossad@.com.my"},
                {"QA@%*.com"},
                {"developer..2002@mail.ru"},
                {"babama@gmail.com.1a"},
                {"nowhere.@where.com"},
                {"google123@gmail.a"},
                {".askold@port-artur.com"},
                {"zayats12345@@.com.com"},
                {"gmail@gmail.com@gmail.com"}
        };
    }

    @Test(dataProvider = "validEmailDataProvider")
    public void success(String str) {
        emailMatcher = new EmailMatcher(str);
        boolean res = emailMatcher.isEmail();
        assertTrue(res);
    }

    @Test(dataProvider = "invalidEmailDataProvider")
    public void fail(String str) {
        emailMatcher = new EmailMatcher(str);
        boolean res = emailMatcher.isEmail();
        assertFalse(res);
    }

    @Test(dataProvider = "validEmailDataProvider")
    public void find(String str) {
        emailMatcher = new EmailMatcher(str);
        boolean res = emailMatcher.find();
        assertTrue(res);
    }
}
