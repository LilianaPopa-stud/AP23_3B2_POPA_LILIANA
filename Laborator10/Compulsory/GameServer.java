/** An instance of this class will create a ServerSocket running at a specified port.
 * The server will receive requests (commands) from clients, and it will execute them.
 */
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;

public class GameServer {
    private ServerSocket serverSocket;
    boolean isRunning;

    public GameServer(int port) {
        try {
            serverSocket = new ServerSocket(port);
            isRunning = true;
            System.out.println("Server started on port " + port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start(GameServer gameServer) {
        try {
            serverSocket.setSoTimeout(1000); // Setează un timeout de 1 secundă (poți ajusta valoarea conform necesităților)
            while (true) {
                try {
                    if (serverSocket.isClosed()) {
                        break;
                    }
                    Socket clientSocket = serverSocket.accept();
                    System.out.println("New client connected: " + clientSocket.getInetAddress().getHostAddress());
                    ClientThread clientThread = new ClientThread(clientSocket, gameServer);
                    clientThread.start();
                } catch (SocketTimeoutException e) {
                    // Timeout a fost atins, continuăm cu verificarea condiției de ieșire din buclă
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        isRunning = false;
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Server stopped");

    }

    public static void main(String[] args) {
        GameServer gameServer = new GameServer(3456);
        gameServer.start(gameServer);
    }
}
