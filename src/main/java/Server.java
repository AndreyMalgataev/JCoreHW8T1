import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        int port = 8080;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            int i = 0;
            while (i <= 4) { //5 коннектов и сервер падает
                Socket connection = serverSocket.accept();

                PrintWriter out = new PrintWriter(connection.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                System.out.printf("New connection accepted. Port: %d%n", connection.getPort());
                final String name = in.readLine();
                out.println(String.format("Hi %s, your port is %d", name, connection.getPort()));

                i++;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
