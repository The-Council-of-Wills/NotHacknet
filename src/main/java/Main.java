import Executeables.ListDirectory;
import Executeables.MakeDirectory;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Whats your name?: ");
        Player player = new Player(scanner.nextLine());
        System.out.println("Hello " + player.getPlayerName());
        MakeDirectory.mkdir(player.getGameState().getCurrentDirectory(), "TestFolder");
        MakeDirectory.mkdir(player.getGameState().getCurrentDirectory(), "TestFolder2");
        MakeDirectory.mkdir(player.getGameState().getCurrentDirectory(), "TestFolder3");
        MakeDirectory.mkdir(player.getGameState().getCurrentDirectory(), "TestFolder4");
        System.out.println(player.getGameState().getCurrentDirectory().getContents());
        System.out.println(ListDirectory.ls(player.getGameState().getCurrentDirectory()));
    }
}
