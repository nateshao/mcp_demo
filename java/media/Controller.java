import java.io.OutputStream;
import java.net.Socket;

public class Controller {
    public static void main(String[] args) throws Exception {
        try (Socket socket = new Socket("127.0.0.1", 9100)) {
            OutputStream out = socket.getOutputStream();
            String[] cmds = {"play", "pause", "play", "stop"};
            for (String cmd : cmds) {
                byte[] msg = MediaProtocol.packCommand(cmd, null);
                out.write(msg);
                System.out.println("Sent command: " + cmd);
                Thread.sleep(1000);
            }
        }
    }
} 