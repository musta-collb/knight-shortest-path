<h1>Shortest path for a knight to reach a final position</h1>
<p style="margin-left:20px;font-style:italic">
Given a standard M \times N chessboard, we want to find the minimum number of steps for a knight to reach a destination position \mathbf{(S, T)} from a source position \mathbf{(X, Y)}. Here, the source and destination position of the knight on a chessboard is known.
On a chessboard, a knight can move two ways. It can either move one square horizontally and two squares vertically, or one square vertically and two squares horizontally. Hence, from a given position (X, Y), the possible moves are:

<strong>[(X + 2, Y - 1), (X + 2, Y + 1), (X - 2, Y + 1), (X - 2, Y - 1), (X + 1, Y + 2), (X + 1, Y - 2), (X - 1, Y + 2), (X - 1, Y - 2)]</strong>

Here, we’ve shown the 8 possible positions on a chessboard a knight can move from a given initial position. At any point in time, a knight can’t go out of the chessboard. Finally, if there is a situation that the knight can’t reach the destination from the given initial position, we’ll return -1.
</p>
<h1>Approach</h1>
<p>

In a knight’s graph, each box on a chessboard denotes a vertex. Each vertex corresponds to the position of a knight on a chessboard. Each edge represents a legal move of a knight. Hence, we can apply any searching algorithm to find the shortest path from one point to another in order to solve the knight’s shortest path problem. We’re using Breadth-First Search (BFS) algorithm here.

Initially, we’ll position a knight randomly on a chessboard. From the initial point, we’ll aim to explore all possible 8 positions. If all the possible positions which can be reached from the initial position are not visited, we enqueue this state into a queue. Moreover, we increase the number of moves by \mathsf{1} from the last state in the queue.

At each new position, we’ll check if the current position of the knight is the destination position or not. If the current position is not the destination, we’ll pop the current position from the queue and enqueue the possible positions a knight can move from the current position.

We’ll continue until we reach the destination position or explore all the possible positions on a chessboard.
</p>