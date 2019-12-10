# Lesson 4

Objectives:
  * Recap what we've learned so far


### Variables

Variables are declared inside methods. They are also known as _local variables_, or simply _locals_.

1. Declare a variable with implicit type (Java will deduce the type based on the initial value):
    ```Java
    var totalScore = 389;
    var scoreBonus = 1.5;
    var playerName = "Nichole";

    System.out.println("Total score: " + totalScore);
    System.out.println("Score bonus: " + scoreBonus);
    System.out.println("Player name: " + playerName);
    ```

2. Declare a variable with explicit type (you specify the type yourself):
    ```Java
    String name = "Mike";
    double height = 5.9;
    float gpa = 3.1f;
    int age = 21;

    System.out.println("Hi, " + name);
    System.out.println("Your height is " + height);
    System.out.println("Your GPA is " + gpa);
    System.out.println("You are " + age + " years old");
    ```

    **Note:** `float` and `double` types are very similar, they both can hold decimal values like `0.9`, `-3.587` etc. They differ in _precision_, but you don't need to worry about that for now.
    Just remember that `float` values normally have letter `f` at the end (for example, `2.35f`).


### Simple Arithmetic

In Java, you have all the basic mathematical operators:

  * addition: `+`
  * subtraction: `-`
  * multiplication: `*`
  * division: `/`
  * modulo (division remainder): `%`


1. Addition:
    ```Java
    System.out.println(51 + 12);
    System.out.println(2.0 + 5.0);
    ```

    **Note:** what is different about the result in the second example?

2. Subtraction:
    ```Java
    System.out.println(10 - 3);
    System.out.println(7.3 - 9.5);
    ```

3. Multiplication:
    ```Java
    System.out.println(2 * 4);
    System.out.println(1.5f * 5f);
    ```

4. Division:
    ```Java
    System.out.println(10 / 3);
    System.out.println(10.0 / 3.0);
    ```

    **Note:** do those two commands produce the same result? What do you think is happening here?

5. Modulo:
    ```Java
    System.out.println(10 % 3);
    ```

    Modulo operator can also be applied to `float` and `double` values but is not usually that useful in that instance.

6. Grouping operations with parentheses:
    ```Java
    System.out.println(2 * (5 + 8) - 1);
    ```

    **Exercise:** how will the result change when you remove the parentheses?


### Conditional Statements

When we need to make a decision what code to run next, we use a conditional statement. So far, we have learned the `if` statement.

1. Run some code only when a condition is met:
    ```Java
    var health = 65;

    System.out.println("Current health: " + health);

    if (health < 30) {
        System.out.println("Warning: damage critical!");
    }
    ```

    **Exercise:** Run the above code with different values of `health` and see what values make the second message appear on the screen.

2. Run some code when a condition is met, run a different code otherwise:
    ```Java
    var speed = 0.78;

    if (speed == 0) {
        System.out.println("Robot is stationary");
    } else {
        System.out.println("Robot is moving");
    }
    ```

    **Exercise:** Run the above code for different values of `speed`. Can you make it print both messages?


### Loops

Every time you'd like to repeat the same piece of code multiple times, use a loop.

1. Run the same code six times:
    ```Java
    for (var i = 0; i < 6; i++) {
        System.out.println("Don't repeat yourself!");
    }
    ```

2. Print ten consecutive even numbers, starting from 0:
    ```Java
    for (var i = 0; i < 10; i++) {
        System.out.println(i * 2);
    }
    ```

    **Remember:** In computer programming, we normally start counting from `0`.

    **Exercise:** Write a loop that prints eight consecutive odd numbers.
