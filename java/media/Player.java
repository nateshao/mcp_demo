import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Player {
    private static String playerState = "stopped";

    public static void handleCommand(String cmd) {
        switch (cmd) {
            case "play":
                playerState = "playing";
                System.out.println("Player: 播放");
                break;
            case "pause":
                playerState = "paused";
                System.out.println("Player: 暂停");
                break;
            case "stop":
                playerState = "stopped";
                System.out.println("Player: 停止");
                break;
            default:
                System.out.println("Player: 未知命令 " + cmd);
        }
        System.out.println("当前状态: " + playerState);
    }

    public static void main(String[] args) throws Exception {
        try (ServerSocket server = new ServerSocket(9100)) {
            System.out.println("Player listening on 127.0.0.1:9100");
            try (Socket socket = server.accept()) {
                InputStream in = socket.getInputStream();
                byte[] buf = new byte[1024];
                while (true) {
                    int n = in.read(buf);
                    if (n == -1) break;
                    MediaProtocol.Command cmd = MediaProtocol.unpackCommand(java.util.Arrays.copyOf(buf, n));
                    handleCommand(cmd.cmd);
                }
            }
        }
    }
} 