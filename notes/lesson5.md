# Lesson 5


### Objectives

 * Restrict player movement with `if` statements
 * Dive deeper into methods in Java


## Intermission: Restricting Player Movement

In the previous lessons, we've learned the Java's primary conditional statement: the `if` statement. If you recall, its syntax looks like this:

```Java
if (/* some condition */) {
  // run some code
}
```

for example:

```Java
if (playerHealth < 30) {
    System.out.println("Critical damage!");
}
```

Of course, we also have the `if-else` variant, to run some different code when the condition is _not_ true:

```Java
if (score == 100) {
    System.out.println("Perfect score");
} else {
    System.out.println("You can do better");
}
```

Today, we'll use this knowledge to keep the player from moving off screen in our game.

First, we need to talk about the game's _coordinate system_, though. In short, it looks something like this:

```text
(0, 799)         (599, 799)
   +-----------------+
   |                 |
   |                 |
   |                 |
   |                 |
   |                 |
   |                 |
   |                 |
   |        P        |
   |    (300, 200)   |
   |                 |
   +-----------------+
(0, 0)          (599, 0)
```

where the first number is the _x_ coordinate and the second one is _y_. The location marked with `P` is the approximate starting location for the player, which is `(300, 200)`, or `x = 300, y = 200`.

To keep the player within the bounds of the screen, we will add some conditional statements to our `update()` method. Yours should currently look like this:

```Java
@Override
protected void update() {
    // The code to run repeatedly during the game goes here
    var dx = getInputX() * 3;
    var dy = getInputY() * 3;
    x = x + dx;
    y = y + dy;
    drawPlayerPlane(x, y);
}
```

When the player leaves the screen on the left-hand side, it means that its _x_ coordinate is less than the _x_ coordinate of the left-hand side of the screen, which is `0`. Let's fix that (you don't need to type in the comments, that is the lines that begin with `//`)

```Java
@Override
protected void update() {
    // The code to run repeatedly during the game goes here
    var dx = getInputX() * 3;
    var dy = getInputY() * 3;
    x = x + dx;
    y = y + dy;

    // start new code
    if (x < 0) {
        x = 0;
    }
    // end new code

    drawPlayerPlane(x, y);
}
```

When you run the game now, you'll see that the player planes stops half-way through leaving the screen on the left-hand side. We won't bother with it now, it's easily fixable (there will be hints at the end of this section on how to do it).

Now, we need to also fix the right-hand side of the screen. Remember that the right screen edge is at location `x = 599` (you can use `600` if you prefer round numbers). Change the code to:

```Java
@Override
protected void update() {
    // The code to run repeatedly during the game goes here
    var dx = getInputX() * 3;
    var dy = getInputY() * 3;
    x = x + dx;
    y = y + dy;

    // start new code
    if (x < 0) {
        x = 0;
    }
    if (x > 599) {
        x = 599;
    }
    // end new code

    drawPlayerPlane(x, y);
}
```

This covers side-to-side movement. We still need to fix up and down, though. This is an exercise for yourself. Couple of hints:
  * remember that this time you will be dealing with the `y` field instead of `x`
  * the bottom edge of the screen has the `y` coordinate equal to `0`
  * the top edge of the screen has the `y` coordinate equalt to `799`

As promised, here's a hint on how to fix the player being able to partially go off the screen. When we draw the player, we are specifying where the _center_ of the player should be. This means that the edges have different coordinates than the center. How can we calculate them? Player plane is `65` pixels wide and `65` pixels tall. We need to compensate for _half_ of that size. This is how you would fix the left-hand edge:

```Java
if (x < 0 + 32) {
    x = 0 + 32;
}
```

**Note:** technically, half the player plane's size is `32.5`, but we don't need to be _that_ precise.

Try to figure out the remaining sides yourself.


## Methods

In Java, all code is organized into _methods_. We've already seen that: in our game, we've been placing the code inside the `init()` and `update()` methods. We've been also using them a lot. Remember all those `System.out.println()` commands? Those are _method calls_ (that is, using a method). `drawPlayerPlane()` is another method that we've used.

More generally, _methods_ in Java consist of three parts:
  * a name
  * a _return type_
  * _method arguments_ enclosed in the parenteses

Let's look at some examples:

  1. `void drawPlayerPlane(float x, float y)`

      This method is named `drawPlayerPlane`; it returns nothing (`void` in Java means "nothing") and takes two arguments, `x` and `y`; both those arguments have type `float`.

      You could use this method for example like this:
      ```Java
      drawPlayerPlane(160, 380);
      ```

  2. `void sayHello(String name)`

      This method is named `sayHello`; again, it returns nothing (`void`) and takes a single argument `name` of type `String`.

      To use this method, you could write code like this:
      ```Java
      sayHello("Matthew");
      ```

  3. `int sum(int a, int b)`

      This is a bit more interesting. This method, named `sum`, takes two integer (`int`) arguments, `a` and `b`. It also returns another integer.

      Using this method would look something like:
      ```Java
      var result = sum(2, 5);
      ```

      Here, the `result` variable would hold the return value of the `sum(2, 5)` call.

**Note:** in other languages, methods might be also called _functions_. For all intents and purposes, those are the same things.


### Exercises

You can only go so far on theory alone. Fire up the `jshell` and let's write some methods.

  1. Define a simple method:

      ```Java
      void greeting() {
          System.out.println("Hello!");
      }
      ```

      This is as simple as it can get. The `greeting` method doesn't take any arguments (empty parentheses) and doesn't return any value (`void`).

      Run it in your `jshell` like this:
      ```Java
      greeting();
      ```
      (remember, in `jshell` the semicolon at the end is optional, but you might as well get into the habit of using it, since normally Java requires it).

      You should see the output:
      ```text
      Hello!
      ```

  2. Define a method with single argument:

      ```Java
      void sayHello(String name) {
          System.out.println("Hello, " + name);
      }
      ```

      Here, we've added a single parameter to the mix. Our `sayHello` method takes a single `name` argument of type `String`. As you can see from the _method body_ (that is, the commands that make up the method), we can use arguments exactly in the same way as if there were variables defined with the `var` keyword.

      To test out this new method, type in the following:
      ```Java
      sayHello("Fred")
      sayHello("Elma")
      ```

      Check what happens, if you pass in empty string (`""`) to the method.

  3. Define a method with single argument that returns a value:

      ```Java
      int negate(int number) {
        return -number;
      }
      ```

      Our new `negate` method takes a single `int` argument named `number` and returns an integer value (note the `int` before the method name). Methods that return a value normally are doing some sort of calculations on the provided arguments. Here, we simply negate the number (calculate its opposite).

      Test the method yourself:
      ```Java
      negate(5)
      negate(-1)
      ```

      As a good programmer, you should always be trying to break your code to see how good it is:
      ```Java
      negate(0)
      ```

      Fortunately for us, the method seems solid.

      If a method returns a value, we can assign that value to a variable to use it later in our code:
      ```Java
      var result = negate(-3);
      System.out.println(result * 5);
      ```

  4. Define a method with multiple arguments that returns a value:

      ```Java
      int sum(int a, int b) {
          return a + b;
      }
      ```

      This is just an expansion on what we've learned so far. The `sum` methods takes two `int` arguments, `a` and `b`. It also returns an integer.

      Using a method with multiple arguments is straight-forward:
      ```Java
      sum(2, 5)
      sum(-1, 4)
      sum(0, 0)
      ```

      Again, we can assign the return value of the method to a variable and use it later:
      ```Java
      var result = sum(17, -5);
      System.out.println(result * 2);
      ```

      You can also mix and match the methods to produce some complex calculations:
      ```Java
      var result = negate(1) * 3 + sum(8, -2);
      System.out.println("result = " + result);
      ```

**Extra Credit:** now that you know the basics of creating and using Java methods, try to experiment a little and write your own.
