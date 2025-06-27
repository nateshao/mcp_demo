import socket
from mcp_protocol import MCPProtocol

HOST = '127.0.0.1'
PORT = 9000

if __name__ == '__main__':
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
        s.bind((HOST, PORT))
        s.listen(1)
        print(f'Receiver listening on {HOST}:{PORT}')
        conn, addr = s.accept()
        with conn:
            print('Connected by', addr)
            buffer = b''
            while True:
                data = conn.recv(1024)
                if not data:
                    break
                buffer += data
                # 尝试解析完整帧
                while len(buffer) >= 5:
                    try:
                        # 取长度字段
                        if buffer[0] != 0xAA:
                            buffer = buffer[1:]
                            continue
                        length = buffer[2]
                        frame_len = 4 + length
                        if len(buffer) < frame_len:
                            break  # 等待更多数据
                        frame = buffer[:frame_len]
                        cmd, payload = MCPProtocol.unpack_frame(frame)
                        print(f'Received: cmd={cmd}, data={payload}')
                        buffer = buffer[frame_len:]
                    except Exception as e:
                        print('Frame error:', e)
                        buffer = buffer[1:] 