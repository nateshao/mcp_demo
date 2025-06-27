import struct

START_BYTE = 0xAA

class MCPProtocol:
    @staticmethod
    def pack_frame(cmd: int, data: bytes) -> bytes:
        """
        打包协议帧: [START][CMD][LEN][DATA][CHK]
        """
        length = len(data)
        chk = (cmd + length + sum(data)) & 0xFF
        frame = struct.pack(f'>BBB{length}sB', START_BYTE, cmd, length, data, chk)
        return frame

    @staticmethod
    def unpack_frame(frame: bytes):
        """
        解包协议帧，返回(cmd, data) 或抛出异常
        """
        if len(frame) < 5:
            raise ValueError('Frame too short')
        if frame[0] != START_BYTE:
            raise ValueError('Invalid start byte')
        cmd = frame[1]
        length = frame[2]
        if len(frame) != 4 + length:
            raise ValueError('Length mismatch')
        data = frame[3:3+length]
        chk = frame[3+length]
        if ((cmd + length + sum(data)) & 0xFF) != chk:
            raise ValueError('Checksum error')
        return cmd, data 