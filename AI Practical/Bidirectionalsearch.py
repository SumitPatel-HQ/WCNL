from collections import deque

def bidirectional_search(graph, start, goal):
    # Separate frontiers and visited sets for both searches
    queue_start = deque([start])
    queue_goal = deque([goal])
    visited_start = {start}
    visited_goal = {goal}
    parent_start = {start: None}
    parent_goal = {goal: None}

    while queue_start and queue_goal:
        # Expand search from start side
        if _expand_frontier(graph, queue_start, visited_start, parent_start, visited_goal):
            # Intersection found, reconstruct path
            return _construct_path(parent_start, parent_goal, queue_start[-1])
        
        # Expand search from goal side
        if _expand_frontier(graph, queue_goal, visited_goal, parent_goal, visited_start):
            # Intersection found, reconstruct path
            return _construct_path(parent_start, parent_goal, queue_goal[-1])
    return None  # No path

def _expand_frontier(graph, queue, visited_this, parent_this, visited_other):
    current = queue.popleft()
    for neighbor in graph.get(current, []):
        if neighbor not in visited_this:
            visited_this.add(neighbor)
            parent_this[neighbor] = current
            queue.append(neighbor)
            if neighbor in visited_other:
                # Intersection detected
                return True
    return False

def _construct_path(parent_start, parent_goal, meet_node):
    # Trace path from start to intersection, then from intersection to goal
    path_from_start = []
    node = meet_node
    while node is not None:
        path_from_start.append(node)
        node = parent_start[node]
    path_from_goal = []
    node = parent_goal[meet_node]
    while node is not None:
        path_from_goal.append(node)
        node = parent_goal[node]
    path = path_from_start[::-1] + path_from_goal
    return path

# Example usage:
graph = {
    'A': ['B', 'C'],
    'B': ['A', 'D', 'E'],
    'C': ['A', 'F'],
    'D': ['B'],
    'E': ['B', 'F'],
    'F': ['C', 'E']
}
print("Path:", bidirectional_search(graph, 'A', 'F'))  # Output: ['A', 'C', 'F'] or ['A', 'B', 'E', 'F']
