from collections import deque


def bfs(graph, start):
	
	visited = set()  # To track visited nodes
	queue = deque([start])  # Initialize a queue with the starting node
	visited.add(start)  # Mark the starting node as visited

	while queue:
		node = queue.popleft()  # Dequeue a node from the front of the queue
		print(node, end=" ")  # Process the node (e.g., print its value)
		for neighbor in graph.get(node, []):  # Enqueue all unvisited neighbors
			if neighbor not in visited:
				visited.add(neighbor)
				queue.append(neighbor)


if __name__ == "__main__":
	# Example graph represented as an adjacency list
	graph = {
		'A': ['B', 'C'],
		'B': ['D', 'E'],
		'C': ['F'],
		'D': [],
		'E': ['F'],
		'F': []
	}

	# Perform BFS starting from node 'A'
	bfs(graph, 'A')  # Expected output: A B C D E F
	print()