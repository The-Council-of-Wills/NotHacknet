package nothacknet.commands.commandparser;

import nothacknet.commands.executables.interfaces.Executable;

import java.util.List;

public class FailedInitializationNotifier implements Executable {

    public FailedInitializationNotifier() {

    }

    @Override
    public void execute(List<String> args) {
        System.out.println("There was an Error during initialization");
    }
}
