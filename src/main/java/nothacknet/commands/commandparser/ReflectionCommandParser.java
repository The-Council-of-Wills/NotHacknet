package nothacknet.commands.commandparser;

import nothacknet.commands.executables.interfaces.Executable;
import nothacknet.commands.executables.interfaces.Exec;
import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;
import org.reflections.scanners.MethodParameterScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ReflectionCommandParser {
    /*
    This should add all Classes that are annotated with @Exec and put them into a hashmap for easy lookup.
    Sadly this currently doesnt work this way since the library it depends on is broken.
    If it can be fixed one would just have to annotate a Class with @Exec to make it load the Classes at startup, so they wouldnt have to
    be hardcoded.
     */



    private static Map<Object, Executable> commands = new HashMap<>();


    public static void initialize() {


        for (Field f : new Reflections("nothacknet/commands/executables").getFieldsAnnotatedWith(Exec.class)) {
            Exec e = f.getAnnotation(Exec.class);

        }

        Set<Class<?>> test = new HashSet<>();


//        Reflections reflections = new Reflections("commands/Executables");
//
//        for (Class<?> cl : reflections.getTypesAnnotatedWith(Executeable.class)) {
//            Executeable executeable = cl.getAnnotation(Executeable.class);
//            System.out.printf("Found class: %s, with meta name: %s%n",
//                    cl.getSimpleName(), executeable.key());
//        }

        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .setUrls(ClasspathHelper.forPackage("Executables"))
                .setScanners(new FieldAnnotationsScanner(), new MethodParameterScanner()));

        Set<Class<?>> commandClasses = reflections.getTypesAnnotatedWith(Exec.class);

        commands = commandClasses.stream().collect(
                Collectors.toMap(
                        commandClass -> commandClass.getAnnotation(Exec.class).key(), ReflectionCommandParser::createNewInstance
                )
        );

        //commands.get("ls").execute();
    }

    private static Executable createNewInstance(Class<?> c) {
        try {
            return (Executable) c.getConstructor().newInstance();
        } catch (Exception e) {
            return new FailedInitializationNotifier();
        }
    }

    public static void parseCommand() {

    }
}
