# Lesson 1

Objectives:

  * _Statements_: method calls
  * _Loops_: for with index
  * _Conditionals_: if-else

Extras:

  * Declaring variables: `var` keyword
  * Printing text to the console: `System.out.println()`
  * Code comments: `//`
  * Blocks: `{ }`


### Statements

The main reason to write any program is to make the computer do something useful for us. To do so, we can give the computer a command in form of a _method call_. Method calls look like this:

```Java
      arguments go inside parenthesis
                    |
               +----|---+
               |        |
               V        V
drawPlayerPlane(200, 300); <-- remember: semicolon at the end!
      ^          ^    ^
      |          |    |
      |          | second argument
      |          |
      |     first argument
      |
name of the command
```

Methods calls are made up of two parts:
  * a name of the method to call, `drawPlayerPlane` in the above example (**required**)
  * a list of _arguments_, written in-between the parenthesis; for example: `(200, 300)`

**Note:** Some methods don't have any arguments, but you still need to use empty parenthesis in the method call in Java, e.g.:

```Java
System.out.println();
```


### Loops

Loops allow us to repeat the same commands multiple times. The most basic form of a loop is an indexed `for` loop:

```Java
name of our loop index
         |
         | starting index value
         |        |
         |   +----+
         |   |
         |   | when to end the loop
         |   |          |
         |   |     +----+
         |   |     |
         |   |     |    +---- what to do after each iteration
         |   |     |    |
         V   V     V    V
for (var i = 0; i < 8; i++)
  drawPlayerPlane(250, i * 100);  <--- loop body: what command to repeat
```

This code tells the computer that we want to have a loop with an index named `i` that starts at zero. Every time the loop is repeated (every _iteration_ of the loop), we want to execute the following command:

```Java
drawPlayerPlane(250, i * 100);
```

The value of `i` in the method call above will change with each iteration of the loop, so the first time it will be `0`, the next it will be `1`, then `2` and so on. This is because we told the computer we want to _increment_ (increase the value) of the loop index by `1` every time. That's what `i++` means, it's a shorthand for _increase the value by 1_.

Finally, the loop will finish when the value of our loop index will no longer be less than 8. In our case, this will happen when the value of `i` will be _exactly_ `8`.

To see what happens with the loop index inside the _for_ loop, put this code in your `init()` method:

```Java
for (var i = 0; i < 5; i++)
  System.out.println("the value of i is: " + i);
```

When you run the program, you should see the following output in your terminal:

```text
the value of i is: 0
the value of i is: 1
the value of i is: 2
the value of i is: 3
the value of i is: 4
```


### Conditionals

A lot of times when writing our programs, we will have to make a decision on what code to run next. Let's take an example from above, where we displayed the player plane multiple times. This time, we will create a zig-zag pattern out of the planes by using conditionals.

A _conditional_ is a test that the computer makes to decide what code to run next. For example:

```Java
for (var i = 0; i < 8; i++)
  if (isEven(i))
    drawPlayerPlane(250, i * 100);
```

In Java, the simplest form of a conditional is an _if statement_. It consists of the `if` keyword, followed by the parenthesis that contain the test to perform, followed by the command to execute _if the condition is true_.

In the above example, the player plane will only be drawn when the value of `i` is even.

Often times, if the condition is _false_, we would like to run some other command. To do this, we use the `else` keyword:

```Java
for (var i = 0; i < 8; i++)
  if (isEven(i))
    drawPlayerPlane(250, i * 100);
  else
    drawPlayerPlane(350, i * 100);
```

What happens here is that every time that `i` is even, we will run the `drawPlayerPlane(250, i * 100)`, and every time that `i` is odd, we will run `drawPlayerPlane(350, i * 100)` _instead_. Only one of those commands will run inside a single iteration of the _for_ loop.
