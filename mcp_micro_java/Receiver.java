import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class Receiver {
    public static void main(String[] args) throws Exception {
        try (ServerSocket server = new ServerSocket(9000)) {
            System.out.println("Receiver listening on 127.0.0.1:9000");
            try (Socket socket = server.accept()) {
                InputStream in = socket.getInputStream();
                byte[] buffer = new byte[1024];
                int bufferLen = 0;
                while (true) {
                    int n = in.read(buffer, bufferLen, buffer.length - bufferLen);
                    if (n == -1) break;
                    bufferLen += n;
                    // 尝试解析完整帧
                    while (bufferLen >= 5) {
                        if (buffer[0] != MCPProtocol.START_BYTE) {
                            // 跳过无效起始字节
                            System.arraycopy(buffer, 1, buffer, 0, --bufferLen);
                            continue;
                        }
                        int length = buffer[2] & 0xFF;
                        int frameLen = 4 + length;
                        if (bufferLen < frameLen) break;
                        byte[] frame = Arrays.copyOfRange(buffer, 0, frameLen);
                        try {
                            MCPProtocol.UnpackedFrame unpacked = MCPProtocol.unpackFrame(frame);
                            System.out.printf("Received: cmd=%d, data=%s\n", unpacked.cmd, new String(unpacked.data));
                        } catch (Exception e) {
                            System.out.println("Frame error: " + e.getMessage());
                        }
                        // 移动buffer
                        System.arraycopy(buffer, frameLen, buffer, 0, bufferLen - frameLen);
                        bufferLen -= frameLen;
                    }
                }
            }
        }
    }
} 