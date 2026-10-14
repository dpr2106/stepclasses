# Week 01: Concept Questions & Answers (Part C)

### Question 1: Method Overloading vs. Method Overriding
- **Method Overloading:** Occurs when two or more methods in the same class share the same name but have different parameter lists (types, counts, or order). It is resolved at **compile-time** (static binding) based on the reference type and arguments.
- **Method Overriding:** Occurs when a subclass provides its own specific implementation of a method inherited from a superclass with the identical signature and return type. It is resolved at **run-time** (dynamic binding) based on the actual object type in memory.

### Question 2: Constructor Invocation Sequence
- **Sequence:** Constructors are executed hierarchically starting from the top-most ancestor class down to the instantiated subclass (`Object` -> Base -> Derived).
- **Passing values:** A derived constructor passes parameters to its parent constructor using the `super(...)` call as the very first statement inside the constructor body.

### Question 3: Concrete Classes vs. Abstract Classes vs. Interfaces
- **Concrete Class:** Can be instantiated directly, maintains per-instance mutable state, and provides full implementations for all methods. Used for specific tangible entities.
- **Abstract Class:** Cannot be instantiated directly; provides common state and partially implemented shared logic to closely related subclasses (`IS-A`).
- **Interface:** Pure contract specifying capabilities without instance state (`CAN-DO`), implemented by any class regardless of its position in the class hierarchy.

### Question 4: Identical Method Signatures in Two Interfaces
- When a class implements two interfaces declaring the identical method signature, a single implementation in the class satisfies the contract for both interfaces. This illustrates that interfaces specify abstract contracts rather than physical implementations.

### Question 5: Importance of Overriding Both equals() and hashCode()
- The general contract requires that **if two objects are equal according to `equals()`, they MUST return the same `hashCode()`**.
- If `equals()` is overridden but `hashCode()` is not, two logically identical objects will produce different hash codes and be placed into different buckets in hash-based collections (`HashMap`, `HashSet`), causing lookups and deduplication to fail silently.

### Question 6: Shallow Copy vs. Deep Copy
- **Shallow Copy:** Copies primitive fields and duplicates references to nested objects, meaning both copies point to the exact same nested instances in heap memory.
- **Deep Copy:** Recursively clones both the outer object and all nested mutable objects, creating entirely independent object graphs.
- **Failure scenario:** If an employee has a mutable `Address` object, modifying the address of a shallow copy inadvertently mutates the original employee's address.

### Question 7: Inner Classes vs. Static Nested Classes
- **Inner Class (non-static):** Bound to an instance of the outer class and has direct access to the outer class's instance fields and methods. Ideal for helper classes tightly coupled to outer state (e.g., custom `Iterator`).
- **Static Nested Class:** Not bound to any outer instance; can only access static members of the outer class. Useful for namespacing and builders (e.g., `Builder` pattern).

### Question 8: Array Time Complexities
- **Index Access:** $O(1)$ because array elements reside in contiguous memory, allowing direct address arithmetic `address = base + index * element_size`.
- **Insertion / Deletion in Middle:** $O(n)$ because all subsequent elements must be shifted forward or backward to maintain contiguous layout.

### Question 9: Uniform Processing & Dynamic Method Dispatch
- An array of base-type references (e.g., `Animal[]`) can store any subtype (`Dog`, `Cat`). When iterating and calling `makeSound()`, the JVM uses the object's virtual method table (vtable) to dispatch the call to the actual runtime class's implementation without needing explicit `if-else` or `instanceof` checks.

### Question 10: Choosing 'IS-A' vs. 'CAN-DO'
- Use **IS-A (Inheritance)** when the derived type is a specialized version of the base type and shares substantial core identity and state (e.g., `SavingsAccount IS-A Account`).
- Use **CAN-DO (Interface)** when representing a role or capability that can be exhibited across disparate class trees (e.g., `Printable`, `Serializable`, `Chargeable`).
