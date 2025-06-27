import socket
import time
from media_protocol import MediaControlProtocol

HOST = '127.0.0.1'
PORT = 9100

if __name__ == '__main__':
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
        s.connect((HOST, PORT))
        cmds = ['play', 'pause', 'play', 'stop']
        for cmd in cmds:
            msg = MediaControlProtocol.pack_command(cmd)
            s.sendall(msg)
            print(f'Sent command: {cmd}')
            time.sleep(1) 