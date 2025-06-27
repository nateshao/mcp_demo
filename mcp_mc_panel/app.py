from flask import Flask, render_template_string, jsonify

app = Flask(__name__)

# 模拟服务器状态和配置
server_status = {
    'status': 'running',
    'players': 5,
    'max_players': 20,
    'motd': 'Welcome to MCP Minecraft Server!',
    'plugins': ['Essentials', 'WorldEdit', 'Dynmap'],
    'backups': ['backup_2024-06-01.zip', 'backup_2024-06-02.zip']
}

HTML = '''
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>MCP Minecraft 控制面板</title>
    <style>
        body { font-family: Arial; margin: 40px; }
        h1 { color: #2d7a2d; }
        .section { margin-bottom: 2em; }
        .label { font-weight: bold; }
        ul { padding-left: 1.5em; }
    </style>
</head>
<body>
    <h1>MCP Minecraft 控制面板</h1>
    <div class="section">
        <span class="label">服务器状态：</span> <span id="status"></span><br>
        <span class="label">在线玩家：</span> <span id="players"></span> / <span id="max_players"></span><br>
        <span class="label">MOTD：</span> <span id="motd"></span>
    </div>
    <div class="section">
        <span class="label">已安装插件：</span>
        <ul id="plugins"></ul>
    </div>
    <div class="section">
        <span class="label">备份列表：</span>
        <ul id="backups"></ul>
    </div>
    <script>
        fetch('/api/status').then(r => r.json()).then(data => {
            document.getElementById('status').textContent = data.status;
            document.getElementById('players').textContent = data.players;
            document.getElementById('max_players').textContent = data.max_players;
            document.getElementById('motd').textContent = data.motd;
            let plugins = document.getElementById('plugins');
            plugins.innerHTML = '';
            data.plugins.forEach(p => {
                let li = document.createElement('li');
                li.textContent = p;
                plugins.appendChild(li);
            });
            let backups = document.getElementById('backups');
            backups.innerHTML = '';
            data.backups.forEach(b => {
                let li = document.createElement('li');
                li.textContent = b;
                backups.appendChild(li);
            });
        });
    </script>
</body>
</html>
'''

@app.route('/')
def index():
    return render_template_string(HTML)

@app.route('/api/status')
def api_status():
    return jsonify(server_status)

if __name__ == '__main__':
    app.run(port=5001, debug=True) 