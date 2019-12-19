# Lesson 6

### Objectives

 * Learn about objects and classes

**Note:** be sure to test out all the code examples in `jshell`; also, don't be shy to experiment with modifying the examples to see what happens; only this way you can actually learn to program!


## Primitive Types and Strings

So far, we have mostly talked about _primitive types_ in Java: `int`, `float` and `double`. We have also talked about the `String` type, but we'll come back to it later.

Primitive types (sometimes called _simple types_) are the most basic building blocks of a Java application. We have a set of methods and operators we can use to manipulate them, for example:

```Java
Math.min(1.5, -3.0)
Math.max(132, 25)
0.1f + 0.3f
10 % 3
```

and so on.

> If you are wondering where does `Math` come from, we'll talk about _packages_ later; in `jshell`, you don't have to worry about it; you can just use it.

Let's now come back to strings. Strings are a bit weird in Java; they behave in some ways like primitive types, in that we can concatenate (or append) them together using the `+` operator:

```Java
"Hello, " + "Josh"
```

We can also create _instances_ of strings using a simple notation:

```Java
var obiWansGreeting = "Hello, there!";
```

Unlike the primitive types, however, you can also _call methods_ on the strings in Java:

```Java
"Hello".toLowerCase()
"Hello".toUpperCase()
"hey!".repeat(5)
```

That's because in Java, strings are actually _objects_. The concept of objects is so crucial to Java that it's called an _object-oriented programming language_.

> If you're curious what other methods you can call on strings, go here: https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html. Look under the _Method Summary_ section.


## Objects in Java

Instances of primitive types only have _state_, or in other words  _value_. For example:

```Java
var daysInWeek = 7;
var monthsInYear = 12;
```

`daysInWeek` and `monthsInYear` are both _instances_ of type `int`. They have different values, though.

Objects also have _state_: strings `"abc"` and `"What's up?"` obviously have different values. But objects also have _behavior_. By behavior we mean all the different methods you can call on the objects, like `toUpperCase()` in the strings example above.

Where do object behaviors come from? From their type! We already know that strings in Java are of type `String`. That's where all the string methods are defined. This is also why all the _instances_ of strings have the exact same behaviors (methods): they share the same type. To discuss objects in more detail, we need to first talk about their types first. In Java, we call them _classes_.


## Classes

You can think of classes as blueprints to create objects. Classes define what _fields_ and _methods_ an object will have, for example:

```Java
class Person {
    String firstName;
    String lastName;

    void print() {
        System.out.println(firstName + " " + lastName);
    }
}
```

Here, we have created a class named `Person`. This class has two string fields, `firstName` and `lastName`. It also has a single method, `print()`; we'll come back to this later.

To create an object of this type, we use the `new` operator like this:

```Java
remember the parentheses, even if there are no arguments!
                    |
                    V
var bob = new Person()
                 ^
                 |
         name of the class
```

After typing the above in `jshell`, you should see an output similar to this:

```text
bob ==> Person@6e06451e
```

> In your case, the string after the `@` sign almost certainly will be different; that's OK.

What this means is that `bob` is an instance of a `Person` class. You can think of the weird number and letter sequence after the `@` sign as a unique identifier of the instance (it's a hexadecimal number, but that's not really important at this moment). If you now create another instance of the `Person` class:

```Java
var kate = new Person()
```

you will notice that this time the sequence is different. No two objects in a Java program will have the same ID at the same time! We say that in Java, each object has its own _identity_. Even if they have the same value, they are _not the same object_!


### Using Fields and Methods

We have now created a `Person` class. We also have two instances of that class, assigned to the variables `bob` and `kate`. Let's see how we can assign values to the object's fields!

```Java
bob.firstName = "Bob";
bob.lastName = "Ross";
```

Of course, we can also read those values back:

```Java
System.out.println("First name: " + bob.firstName);
```

We've already seen this with strings, but calling a method on an object is also very simple:

```Java
bob.print()
```

Almost everything you do in Java will come down to manipulating objects, so make sure you understand the concepts behind them well!


### Intermission: Drawing Enemy Planes

How can we apply what we've learned to our game? I have prepared a new method you can call to show an enemy plane on the screen, `drawEnemyPlane()`. To spice things up, however, this method doesn't take an x- and y-coordinates as the `drawPlayerPlane()` did. It takes a `Vector2` object instead.

In order to use our new method, we need to create an instance of the `Vector2` class first. What does `Vector2` represent, you might ask? You can think of it as a position in 2D space. It has an `x` and a `y` coordinate inside.

> **Note:** the code below **will not work** in `jshell`. `jshell` doesn't know anything about our `Vector2` class, unfortunately.

Put this code inside the `update()` method in `MyGame.java`:

```Java
@Override
protected void update() {
    ... // previous code

    var position = new Vector2();
    position.x = 300;
    position.y = 600;

    drawEnemyPlane(position);
}
```

There are a couple things going on here:

  1. First, we are creating an instance of the `Vector2` class using the `new` operator
  2. Then, we assign the values to the `x` and `y` fields of the created object
  3. Finally, we use the newly-created object in the call to the `drawEnemyPlane()` method

When you run this code, you should see an enemy plane hanging out in the upper area of the screen.

What we did works, but there is a simpler way to go about the same thing. Most of the time, a class will allow you to specify parameters when you create an instance. For example, the `Vector2` class lets us to specify `x` and `y` coordinates that way. Change the previous code so it looks like this:

```Java
@Override
protected void update() {
    ... // previous code

    var position = new Vector2(300, 600);

    drawEnemyPlane(position);
}
```

Running the code again you should notice that nothing have really changed. It's just a shorter way of doing the same thing.


## Exercises

Do all the exercises below in `jshell.`

1. Create a new `Person` class with a `name` of type `String` and `age` field of type `int`
2. Add a `sayHello()` method to the `Person` class that prints `Hello, my name's {Fred} and I'm {23} years old`; use `name` and `age` fields in place of `{Fred}` and `{23}` in the example above
3. Create some instances of the `Person` class, assign the names and ages and call `sayHello()` method on them
