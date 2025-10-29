import random


# Objective function (example: maximize f(x) = -x^2 + 10x)
def objective_function(x):
    return -x**2 + 10*x


# Hill climbing algorithm
def hill_climbing(max_iterations=1000, step_size=1):
    # Start with a random solution
    current_solution = random.randint(0, 10)
    current_value = objective_function(current_solution)
    
    for i in range(max_iterations):
        # Generate neighbor
        neighbor = current_solution + random.choice([-step_size, step_size])
        
        # Keep neighbor in bounds
        if neighbor < 0 or neighbor > 10:
            continue
        
        neighbor_value = objective_function(neighbor)
        
        # Move if better
        if neighbor_value > current_value:
            current_solution, current_value = neighbor, neighbor_value

    return current_solution, current_value


if __name__ == "__main__":
    # Run the algorithm
    best_solution, best_value = hill_climbing()
    print("Best solution found:", best_solution)
    print("Value at best solution:", best_value)