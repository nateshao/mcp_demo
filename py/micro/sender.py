import socket
import time
from mcp_protocol import MCPProtocol

HOST = '127.0.0.1'
PORT = 9000

if __name__ == '__main__':
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
        s.connect((HOST, PORT))
        for i in range(5):
            cmd = 0x01  # 示例命令
            data = f'Hello {i}'.encode()
            frame = MCPProtocol.pack_frame(cmd, data)
            s.sendall(frame)
            print(f'Sent: cmd={cmd}, data={data}')
            time.sleep(1) 