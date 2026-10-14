# Week 01: OOP & Class Hierarchy Quiz (Part B)

### Q1. If Student is a derived type of Person, which members are directly accessible within Student?
- **Answer:** **B. # age and + getName()**
- **Explanation:** In UML, `-` is private (inaccessible to subclasses), `#` is protected (accessible to subclasses), and `+` is public (accessible everywhere).

### Q2. Which diagram illustrates an invalid class inheritance structure, assuming single inheritance?
- **Answer:** **C. Diagram 3, where a class attempts to extend two different classes.**
- **Explanation:** Class S extends both Q and R simultaneously (`S --|> Q` and `S --|> R`), which represents multiple inheritance of classes, disallowed in single-inheritance languages like Java.

### Q3. In what order will the constructors be executed when creating a Manager object?
- **Answer:** **B. Person -> Employee -> Manager**
- **Explanation:** Constructor chaining always proceeds from the root base class down to the most derived class.

### Q4. Which statement about accessing Base members or modifying Base operations from Derived is correct?
- **Answer:** **C. Derived can directly access protectedField.**
- **Explanation:** Protected members are directly accessible in subclasses. Private members cannot be accessed directly, final methods cannot be overridden, and access modifiers cannot be weakened.

### Q5. If a Vehicle reference points to a Bus object, which version of fare() will run?
- **Answer:** **B. The fare() method defined in Bus.**
- **Explanation:** Due to dynamic method dispatch (runtime polymorphism), the method executed is determined by the actual object type (`Bus`), not the reference type (`Vehicle`).

### Q6. Which statement correctly identifies the distinction between overloading and overriding?
- **Answer:** **B. print(text: String) and print(data: int) in Printer are examples of overloading, and SpecialPrinter's print(text: String) is an example of overriding.**
- **Explanation:** Methods with the same name but different signatures within the same class are overloaded; re-implementing an inherited method with identical signature in a subclass is overriding.

### Q7. If a Shape reference s is assigned a Circle object (upcasting), which members can be accessed directly using s?
- **Answer:** **A. Only members defined in the Shape class.**
- **Explanation:** The compiler checks accessible members using the reference type (`Shape`), so members specific to `Circle` (like `radius`) cannot be accessed directly without downcasting.

### Q8. What happens when iterating through Shape[] holding Circle and Square and calling area()?
- **Answer:** **C. The area() method specific to Circle will be called for shapes[0], and the area() method specific to Square will be called for shapes[1].**
- **Explanation:** Polymorphic dispatch executes the respective overridden implementation of `area()` for each concrete instance at runtime.

### Q9. Given Account a = new Current(), which casting attempts will succeed at runtime?
- **Answer:** **B. s = (Savings) a; will fail, c = (Current) a; will succeed.**
- **Explanation:** `a` references a `Current` instance, so downcasting to `Current` succeeds, while downcasting to unrelated sibling `Savings` throws `ClassCastException`.

### Q10. What is the benefit of processing Plan[] elements in a loop calling bill()?
- **Answer:** **B. It allows uniform processing of different derived objects through a base-type reference, without needing type-specific conditional logic.**
- **Explanation:** Polymorphism removes the need for brittle `if-else` / `instanceof` checks when operating on collections of related subtypes.

### Q11. Which operations represent essential behavior vs hidden details in Printer?
- **Answer:** **A. printDocument() is essential behavior; internalBuffer, loadBuffer(), and sendToPrintHead() are hidden details.**
- **Explanation:** Encapsulation hides private buffers and internal coordination methods while exposing public operational methods.

### Q12. Vehicle is abstract and Car is a concrete subclass. Which statements are true?
- **Answer:** **B. A Vehicle reference can refer to a Car object.**
- **Explanation:** Abstract classes cannot be instantiated, but their reference types can point to instances of concrete subclasses.

### Q13. If SavingsAccount does not implement abstract calculateFee(), what will be the consequence?
- **Answer:** **B. SavingsAccount must also be declared as an abstract class.**
- **Explanation:** A class that inherits an abstract method without implementing it remains abstract and cannot be concrete.

### Q14. Which scenario leads to a compilation error in Report and MonthlyReport?
- **Answer:** **B. MonthlyReport attempting to be a concrete class without implementing the abstract method generateBody().**
- **Explanation:** All inherited abstract methods must be implemented by the first concrete subclass.

### Q15. What does an interface fundamentally specify and what does it typically not provide?
- **Answer:** **A. It specifies operations a type promises to provide, but not per-object state or direct implementation.**
- **Explanation:** Interfaces define a behavioral contract without per-instance fields or instance state.

### Q16. Which statement accurately describes implicit visibility and modifiers of interface members?
- **Answer:** **B. logMessage() and getLogLevel() are implicitly public abstract.**
- **Explanation:** In interfaces, method declarations are implicitly `public abstract`, and fields are implicitly `public static final`.

### Q17. DataProcessor realizes Serializable and Resettable. Which operations must it implement?
- **Answer:** **C. Both serialize() from Serializable and reset() from Resettable.**
- **Explanation:** A concrete class implementing multiple interfaces must fulfill every method specified across all realized interfaces.

### Q18. Which construct defines a common protocol for unrelated classes without state or default implementation?
- **Answer:** **C. Box C (Interface)**
- **Explanation:** Interfaces represent "CAN-DO" capabilities that unrelated class trees can implement uniformly.

### Q19. Classify relationships: Dog/Animal and Eagle/Flyable:
- **Answer:** **B. Dog IS-A Animal (generalization); Eagle CAN-DO Flyable (realization).**
- **Explanation:** Class inheritance (`--|>`) is generalization (IS-A), while interface realization (`..|>`) is realization (CAN-DO).

### Q20. Which operations are commonly inherited from the root Object class and often redefined?
- **Answer:** **A. equals(), hashCode(), toString()**
- **Explanation:** These three methods form the standard contract for object identity, hash lookup, and textual representation in Java.
