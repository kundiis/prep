package DesignPattern.CommandPattern;


//https://www.journaldev.com/1624/command-design-pattern

//implementing four components: the Command, the Receiver, the Invoker, and the Client.
// http://www.baeldung.com/java-command-pattern
// Open file as the reciever


public interface Command {
    void execute();
}
