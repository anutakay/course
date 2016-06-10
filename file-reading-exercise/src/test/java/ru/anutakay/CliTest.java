package ru.anutakay;

import org.testng.annotations.Test;

public class CliTest {

    @Test
    public void output() {
        String[] args = {"input.txt", "-o", "output.json"};
        FindEmailCli cli = new FindEmailCli();
        cli.start(args);
    }

    @Test
    public void negative_output() {
        String[] args = {"-o", "output.json"};
        FindEmailCli cli = new FindEmailCli();
        cli.start(args);
    }

    @Test
    public void mult_output() {
        String[] args = {"input.txt", "input2.json", "-o", "output.json"};
        FindEmailCli cli = new FindEmailCli();
        cli.start(args);
    }
}
