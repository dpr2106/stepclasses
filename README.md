# Week 03: Linked Lists (Singly Linked List Implementation & Reversal)

This week focuses on pointer-based linear data structures in Java without using standard library collections (`java.util.LinkedList`):
- Custom Node structure (`data`, `next`)
- Head & Tail insertions: `addFirst`, `addLast` ($O(1)$)
- Positional insertion: `insertAt(index, val)` ($O(n)$)
- In-place reversal of singly linked list using 3 pointers (`prev`, `curr`, `next`)
- Deletion and traversal operations

## Folder Structure
- `practice/`: Practice singly linked list implementations, deletion, search, and edge case tests.
- `assignment/`: Core Category B Assignments:
  - `PriorityTokenQueue.java`: Problem 1 (Priority Token Insertion: `addFirst`, `addLast`, `insertAt`).
  - `ReverseQueueList.java`: Problem 3 (Reverse the Queue: in-place linked list reversal without creating new nodes).
