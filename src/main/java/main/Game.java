package main;

import javax.swing.JFrame;
import java.io.IOException;
import java.net.Socket;
import client.Client;
import io.github.cdimascio.dotenv.Dotenv;

/*
 * Starter point, main class Game
 */
public class Game {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        GamePanel panel = new GamePanel();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setTitle("Cloud Game");
        window.setResizable(false);
        window.setVisible(true);
        window.add(panel);
        window.pack();
        panel.startGameThread();

        try {
            Dotenv dotenv = Dotenv.configure().directory("./src").load();
            String user = dotenv.get("USER");
            String pass = dotenv.get("PASS");
            System.out.println("USER: "+ user);
            System.out.println("PASS: "+ pass);
            Socket socket = new Socket("127.0.0.1", 5555);
            Client client = new Client(socket, user, pass);
            if (client.authenticate()) {
                System.out.println("Authentication correct, you enter the chat.");
                client.getMsg();
                client.sendMsg();
            } else {
                System.out.println("User or password incorrect.");
                client.cierraTodo();
            }
        } catch (IOException e) {
            System.out.println("The server wasn't found.");
            e.printStackTrace();
        }
    }
}
