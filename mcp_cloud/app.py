from flask import Flask, request, jsonify

app = Flask(__name__)

# 用内存字典模拟服务注册表
services = {}

@app.route('/register', methods=['POST'])
def register():
    data = request.json
    name = data.get('name')
    address = data.get('address')
    if not name or not address:
        return jsonify({'error': 'name and address required'}), 400
    services[name] = address
    return jsonify({'message': f'service {name} registered'})

@app.route('/unregister', methods=['POST'])
def unregister():
    data = request.json
    name = data.get('name')
    if not name or name not in services:
        return jsonify({'error': 'service not found'}), 404
    services.pop(name)
    return jsonify({'message': f'service {name} unregistered'})

@app.route('/services', methods=['GET'])
def list_services():
    return jsonify(services)

if __name__ == '__main__':
    app.run(port=5000, debug=True) 