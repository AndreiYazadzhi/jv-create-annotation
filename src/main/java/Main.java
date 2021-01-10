import controller.BetHandler;
import controller.ConsoleHandler;
import controller.PlayerHandler;
import java.lang.reflect.InvocationTargetException;
import lib.Injector;

public class Main {

    public static void main(String[] args) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        ConsoleHandler userConsoleHandler = (ConsoleHandler) Injector
                .getInstance(PlayerHandler.class);
        System.out.println("Enter nickname and password");
        userConsoleHandler.handle();
        ConsoleHandler betConsoleHandler = (ConsoleHandler) Injector.getInstance(BetHandler.class);
        System.out.println("Enter value and risk for your bet!");
        betConsoleHandler.handle();
    }
}
