import random
# Function to maximize
def objective_function(x):
    return -x**2 + 10*x


# Generate a neighbor (small random step)
def get_neighbor(x):
    step = random.choice([-1, 1])  # Move left or right
    return x + step


# Hill Climbing Algorithm
def hill_climbing(max_iterations=100):
    current_x = random.randint(0, 10)  # Start from random point
    current_value = objective_function(current_x)

    print(f"Initial State: x = {current_x}, value = {current_value}")
    
    for i in range(max_iterations):
        neighbor_x = get_neighbor(current_x)
        neighbor_value = objective_function(neighbor_x)
        
        if neighbor_value > current_value:  # If better, move
            current_x = neighbor_x
            current_value = neighbor_value
            print(f"Move to: x = {current_x}, value = {current_value}")
        else:
            print("No better neighbor found. Stopping.")
            break

    print(f"Final Solution: x = {current_x}, value = {current_value}")


if __name__ == "__main__":
    # Run the algorithm
    hill_climbing()