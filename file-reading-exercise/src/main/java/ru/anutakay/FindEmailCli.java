package ru.anutakay;

import org.apache.commons.cli.*;

import java.io.FileNotFoundException;

public class FindEmailCli {

    HelpFormatter formatter = new HelpFormatter();

    public static void main(String... args) {
        FindEmailCli cli = new FindEmailCli();

        cli.start(args);
    }

    FindEmailCli(String... args) {
        System.out.println("Welcome to the CLI!");
    }

    public void start(String... args) {
        Options options = configureOptions();
        CommandLine commandLine = parseArguments(options, args);

        String input = getInput(commandLine);
        if(input == null) {
            System.out.println("Argument is missing");
            formatter.printHelp("findemail input.txt [-o]", options);
            return;
        }

        String output = getOutput(commandLine);
        Application app = new Application();
        try {
            app.start(input, output);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static Options configureOptions() {
        Option help = new Option( "help", "print this message" );
        Option output = new Option("o", "output", true, "output file");

        output.setArgs(1);
        output.setOptionalArg(true);
        output.setArgName("file");

        Options posixOptions = new Options();
        posixOptions.addOption(help);
        posixOptions.addOption(output);

        return posixOptions;
    }

    private static CommandLine parseArguments(Options posixOptions, String... args) {
        CommandLineParser posixParser = new DefaultParser();
        CommandLine commandLine = null;
        try {
            commandLine = posixParser.parse(posixOptions, args);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return commandLine;
    }

    private String getOutput(CommandLine commandLine) {
        String output = null;
        if (commandLine.hasOption("o")) {
            String[] arguments = commandLine.getOptionValues("o");
            output = arguments[0];
        } else {
            output = "output.txt";
        }
        return output;
    }

    private String getInput(CommandLine commandLine) {
        String[] arguments = commandLine.getArgs();
        String input;
        if(arguments.length == 0) {
            return null;
        } else {
            input = arguments[0];
        }
        if (arguments.length > 1) {
            System.out.println("Arguments that after first will be ignored");
        }
        return input;
    }
}
