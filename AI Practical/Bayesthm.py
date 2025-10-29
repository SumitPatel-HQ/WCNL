def bayes_theorem(p_a, p_b_given_a, p_b, p_a_given_b=None):
    """
    Compute the posterior probability P(A|B) using Bayes Theorem.
    If p_a_given_b is not given, computes it using Bayes theorem formula:
    
    P(A|B) = (P(B|A) * P(A)) / P(B)
    
    Parameters:
    p_a : float : Prior probability of A (P(A))
    p_b_given_a : float : Likelihood of B given A (P(B|A))
    p_b : float : Total probability of B (P(B))
    p_a_given_b : float, optional : Direct conditional P(A|B), if known
    
    Returns:
    float : Posterior probability P(A|B)
    """
    if p_a_given_b is None:
        p_a_given_b = (p_b_given_a * p_a) / p_b
    return p_a_given_b

# Example usage:
# Suppose:
# P(A) = 0.01 (probability of having a disease)
# P(B|A) = 0.95 (test is positive if disease present)
# P(B) = 0.05 (total probability of positive test - includes false positives)

p_a = 0.01
p_b_given_a = 0.95
p_b = 0.05

posterior = bayes_theorem(p_a, p_b_given_a, p_b)
print(f"Probability of having disease given positive test: {posterior:.4f}")
