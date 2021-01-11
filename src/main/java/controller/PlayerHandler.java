package controller;

import dao.PlayerDao;
import java.util.Scanner;
import lib.Inject;
import model.Player;

public class PlayerHandler implements ConsoleHandler {
    @Inject
    private PlayerDao playerDao;

    @Override
    public void handle() {
        Scanner scanner = new Scanner(System.in);
        boolean isCorrectData = false;
        while (!isCorrectData) {
            String command = scanner.nextLine();
            Player player = null;
            try {
                String[] userData = command.split(" ");
                String nickname = userData[0];
                String password = userData[1];
                player = new Player(nickname, password);
                isCorrectData = true;
                playerDao.addPlayer(player);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Please,repeat with correct data");
            }
            System.out.println(playerDao.getAll().toString());
        }
    }
}
