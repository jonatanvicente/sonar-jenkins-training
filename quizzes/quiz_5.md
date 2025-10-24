

**1.- What are SOLID principles?**

<details>
  <summary>Solution</summary>

- S – Single Responsibility Principle (SRP)
	A class should have only one reason to change.
	Each class handles a single part of the functionality.

- O – Open/Closed Principle (OCP)
	Software entities should be open for extension but closed for modification.
	You can add new behavior without changing existing code.

- L – Liskov Substitution Principle (LSP)
	Subtypes must be replaceable for their base types without altering correctness.
	Derived classes should behave like the parent class.

- I – Interface Segregation Principle (ISP)
	Clients should not be forced to depend on interfaces they don’t use.
	Many specific interfaces are better than one general-purpose interface.

- D – Dependency Inversion Principle (DIP)
	High-level modules should not depend on low-level modules; both should depend on abstractions.
	Depend on interfaces or abstract classes, not concrete implementations.

</details>

**2.- According to the testing pyramid, in what order should unit tests be executed?**

<details>
  <summary>Solution</summary>

- Unit tests should be executed first.

</details>

**3.- What are FIRST principles?**

<details>
  <summary>Solution</summary>

- F – Fast. Tests should run quickly to give immediate feedback.
- I – Independent. Tests should not depend on each other; order of execution shouldn’t matter.
- R – Repeatable. Tests should pass or fail consistently on any environment.
- S – Self-Validating. Tests should produce a clear pass/fail result automatically, without manual checking.
- T – Timely. Tests should be written at the right time, ideally before the code (Test-Driven Development).

</details>
