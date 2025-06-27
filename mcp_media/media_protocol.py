import json

class MediaControlProtocol:
    @staticmethod
    def pack_command(cmd: str, params: dict = None) -> bytes:
        """
        打包命令为JSON字节流
        """
        obj = {'cmd': cmd}
        if params:
            obj['params'] = params
        return json.dumps(obj).encode('utf-8')

    @staticmethod
    def unpack_command(data: bytes):
        """
        解析命令字节流，返回(cmd, params)
        """
        obj = json.loads(data.decode('utf-8'))
        return obj['cmd'], obj.get('params', {}) 