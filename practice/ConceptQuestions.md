# Week 02: Concept Questions & Answers (Part C)

### Question 1: Searching in Unsorted vs. Sorted 1D Arrays
- **Unsorted Array:** Requires **Linear Search** with $O(n)$ time complexity in the worst/average case because elements have no order; every element may need examination.
- **Sorted Array:** Enables **Binary Search** with $O(\log n)$ time complexity because examining the midpoint allows halving the remaining search space at every step.

### Question 2: Dropping Constants in Big-O (2n vs. O(n))
- Big-O describes the **asymptotic growth rate** as $n \to \infty$. Since multiplying by a constant scale factor does not change the shape of the growth function (doubling input doubles runtime for both $n$ and $2n$), constant multipliers are dropped to capture fundamental scalability.

### Question 3: Traversal in Linear vs. Non-Linear Data Structures
- **Linear Data Structures (Arrays/Lists):** Have a single natural sequence from start to finish where each element has exactly one predecessor and successor.
- **Non-Linear Data Structures (Trees/Graphs):** Have multi-way branching relationships (one-to-many or many-to-many), requiring structured traversal orders such as Preorder, Inorder, Postorder (DFS) or Level-Order (BFS).
