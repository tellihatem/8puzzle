# 8puzzle
## Solve the eight puzzle problem using A* (astar)
### Introduction :
Given a 3×3 board with 8 tiles (every tile has one number from 1 to 8) and one empty space. The objective is to place the numbers on tiles to match the final configuration using the empty space. We can slide four adjacent (left, right, above, and below) tiles into the empty space. 
### A* Algorithme :
Informally speaking, A* Search algorithms, unlike other traversal techniques, it has “brains”. What it means is that it is really a smart algorithm which separates it from the other conventional algorithms. This fact is cleared in detail in below sections. 
And it is also worth mentioning that many games and web-based maps use this algorithm to find the shortest path very efficiently (approximation). 
#### Explanation 
Consider a square grid having many obstacles and we are given a starting cell and a target cell. We want to reach the target cell (if possible) from the starting cell as quickly as possible. Here A* Search Algorithm comes to the rescue.
What A* Search Algorithm does is that at each step it picks the node according to a value-‘f’ which is a parameter equal to the sum of two other parameters – ‘g’ and ‘h’. At each step it picks the node/cell having the lowest ‘f’, and process that node/cell.
We define ‘g’ and ‘h’ as simply as possible below
g = the movement cost to move from the starting point to a given square on the grid, following the path generated to get there. 
h = the estimated movement cost to move from that given square on the grid to the final destination. This is often referred to as the heuristic, which is nothing but a kind of smart guess. We really don’t know the actual distance until we find the path, because all sorts of things can be in the way (walls, water, etc.). There can be many ways to calculate this ‘h’ which are discussed in the later sections.
For More Information [Here](https://www.geeksforgeeks.org/a-search-algorithm)
### Our Solution for the eight puzzle problem:
1. We get the information about the initial and goal matrix from the user and make sure the number given is from 1 to 8 and blank space.
2. Check if a 8 puzzle is solvable by calculating the number of inversions. For More Infromation [Here](https://www.geeksforgeeks.org/check-instance-8-puzzle-solvable/?ref=gcse)
3. Create the object State for the initial matrix.
4. Create the object Solution for the initial State.
    - Every State we create store it in the PriorityQueue.
    - The path we taken store it in the expanded list.
    - We store the child states in another list.
    - We store the child states in the PriorityQueue after we check if the state is not already in the expanded list.
5. We Stop running the programme only if we get the goal matrix or the PriorityQueue is empty.
6. Print Every State in the expanded list.
