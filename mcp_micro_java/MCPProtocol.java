import java.util.Arrays;

public class MCPProtocol {
    public static final byte START_BYTE = (byte) 0xAA;

    // 打包协议帧: [START][CMD][LEN][DATA][CHK]
    public static byte[] packFrame(byte cmd, byte[] data) {
        int length = data.length;
        byte chk = (byte) (cmd + length);
        for (byte b : data) {
            chk += b;
        }
        chk = (byte) (chk & 0xFF);
        byte[] frame = new byte[4 + length];
        frame[0] = START_BYTE;
        frame[1] = cmd;
        frame[2] = (byte) length;
        System.arraycopy(data, 0, frame, 3, length);
        frame[3 + length] = chk;
        return frame;
    }

    // 解包协议帧，返回cmd和data
    public static UnpackedFrame unpackFrame(byte[] frame) throws Exception {
        if (frame.length < 5) throw new Exception("Frame too short");
        if (frame[0] != START_BYTE) throw new Exception("Invalid start byte");
        byte cmd = frame[1];
        int length = frame[2] & 0xFF;
        if (frame.length != 4 + length) throw new Exception("Length mismatch");
        byte[] data = Arrays.copyOfRange(frame, 3, 3 + length);
        byte chk = frame[3 + length];
        int sum = cmd + length;
        for (byte b : data) sum += b;
        if (((sum & 0xFF)) != (chk & 0xFF)) throw new Exception("Checksum error");
        return new UnpackedFrame(cmd, data);
    }

    public static class UnpackedFrame {
        public byte cmd;
        public byte[] data;
        public UnpackedFrame(byte cmd, byte[] data) {
            this.cmd = cmd;
            this.data = data;
        }
    }
} 