# Week 03: Linked List Analysis & Complexity Notes

### Time Complexities
| Operation | Singly Linked List | Array / ArrayList |
|---|---|---|
| `addFirst` | $O(1)$ | $O(n)$ (shifting required) |
| `addLast` (with tail) | $O(1)$ | $O(1)$ amortized |
| `addLast` (without tail) | $O(n)$ | $O(1)$ amortized |
| `insertAt(k)` | $O(k) \le O(n)$ | $O(n)$ (shifting required) |
| `deleteFirst` | $O(1)$ | $O(n)$ |
| `search(val)` | $O(n)$ | $O(n)$ (or $O(\log n)$ if sorted) |
| `reverse()` | $O(n)$ time, $O(1)$ space | $O(n)$ time, $O(1)$ space |

### Why In-Place Reversal Matters
- **Space constraint:** Memory allocation for new nodes is avoided, meeting strict embedded and low-memory environment constraints ($O(1)$ extra space).
- **Pointer turning logic:**
  ```java
  Node next = curr.next;
  curr.next = prev;
  prev = curr;
  curr = next;
  ```
