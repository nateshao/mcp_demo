import socket
from media_protocol import MediaControlProtocol

HOST = '127.0.0.1'
PORT = 9100

player_state = 'stopped'

def handle_command(cmd, params):
    global player_state
    if cmd == 'play':
        player_state = 'playing'
        print('Player: 播放')
    elif cmd == 'pause':
        player_state = 'paused'
        print('Player: 暂停')
    elif cmd == 'stop':
        player_state = 'stopped'
        print('Player: 停止')
    else:
        print(f'Player: 未知命令 {cmd}')
    print(f'当前状态: {player_state}')

if __name__ == '__main__':
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
        s.bind((HOST, PORT))
        s.listen(1)
        print(f'Player listening on {HOST}:{PORT}')
        conn, addr = s.accept()
        with conn:
            print('Connected by', addr)
            while True:
                data = conn.recv(1024)
                if not data:
                    break
                cmd, params = MediaControlProtocol.unpack_command(data)
                handle_command(cmd, params) 