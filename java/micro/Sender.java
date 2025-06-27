import java.io.OutputStream;
import java.net.Socket;

public class Sender {
    public static void main(String[] args) throws Exception {
        try (Socket socket = new Socket("127.0.0.1", 9000)) {
            OutputStream out = socket.getOutputStream();
            for (int i = 0; i < 5; i++) {
                byte cmd = 0x01;
                byte[] data = ("Hello " + i).getBytes();
                byte[] frame = MCPProtocol.packFrame(cmd, data);
                out.write(frame);
                System.out.printf("Sent: cmd=%d, data=%s\n", cmd, new String(data));
                Thread.sleep(1000);
            }
        }
    }
} 