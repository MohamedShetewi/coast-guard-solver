from os import listdir
import matplotlib.pyplot as plt
import numpy as np

strategy_abbrev = {"DF": "DFS", "BF": "BFS", "ID": "Iterative Deepening",
                   "AS2": "A Star 2", "AS1": "A Star 1", "GR1": "Greedy 1", "GR2": "Greedy 2"}

units = {"Memory": "KBs", "Time": "Ms", "ExpandedNodes": "No. of Nodes", "CPU": "Percentage"}


def get_log_files():
    return [f for f in listdir("./") if f.endswith(".log")]


def get_log_info(files):
    logs = []
    for file in files:
        with open(file, "r") as f:
            logs.extend(f.readlines())
    return logs


def filter_logs(log):
    log_split = log.split(" ")
    if log_split[0] != "INFO:":
        return False
    return True


def parse_logs(logs):
    metric_map = {}
    for log in logs:
        log_split = log.split(" ")
        info = log_split[1][1:-2]
        info_split = info.split("_")
        strategy, metric_type, metric_num = info_split[0], info_split[1], info_split[2]
        if metric_type not in metric_map:
            metric_map[metric_type] = ([], [])
        metric_map[metric_type][0].append(strategy)
        metric_map[metric_type][1].append(float(metric_num))
    return metric_map


def plot_metrics(metric_map):
    for metric, values in metric_map.items():
        fig, axs = plt.subplots(figsize=(10, 5))
        axs.bar(list(map(lambda x: strategy_abbrev[x], values[0])), values[1])
        plt.title(metric)
        axs.set_xlabel('Search Strategy')
        axs.set_ylabel(units[metric])
        rects = axs.patches
        labels = values[1]
        for rect, label in zip(rects, labels):
            height = rect.get_height()
            axs.text(
                rect.get_x() + rect.get_width() / 2, height + 5, int(label), ha="center", va="bottom"
            )
            if metric == "CPU":
                print(label)
        plt.savefig("./Stats/" + metric + ".png")


if __name__ == '__main__':
    log_files = get_log_files()
    logs_info = get_log_info(log_files)
    filtered_logs = filter(filter_logs, logs_info)
    metric_map = parse_logs(filtered_logs)
    plot_metrics(metric_map)
    print(metric_map)
