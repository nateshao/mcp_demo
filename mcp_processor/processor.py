import time
import random
from concurrent.futures import ThreadPoolExecutor, as_completed

def process_channel(channel_id, data):
    print(f'Channel {channel_id} start processing {data}')
    # 模拟处理耗时
    time.sleep(random.uniform(0.5, 2.0))
    result = f'Channel {channel_id} processed {data.upper()}'
    print(f'Channel {channel_id} done')
    return result

if __name__ == '__main__':
    channel_data = {
        1: 'alpha',
        2: 'bravo',
        3: 'charlie',
        4: 'delta',
    }
    results = []
    with ThreadPoolExecutor(max_workers=4) as executor:
        future_to_channel = {
            executor.submit(process_channel, cid, data): cid
            for cid, data in channel_data.items()
        }
        for future in as_completed(future_to_channel):
            cid = future_to_channel[future]
            try:
                res = future.result()
                results.append(res)
            except Exception as exc:
                print(f'Channel {cid} generated an exception: {exc}')
    print('\nAll results:')
    for r in results:
        print(r) 