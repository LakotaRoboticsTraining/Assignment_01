# Lesson 1: The Main Method and Print Statements

*Java to Robot Code — Student Training*

Goal: Write and run your first Java program. Know that every Java program starts in `main`, and learn how to print messages to the console.

Time: About 20-30 minutes

## You will learn

- That every Java program has a `main` method — that is where the program starts
- How to print text with `System.out.println`
- How to run a simple program and read the output

## Why this matters for robots

Later, when you write FRC robot code, your program still has to start somewhere. That starting place is the `main` method. Printing messages (`System.out.println`) is also how you debug — for example, printing sensor values or `"shooter started"` while testing.

Today you practice the same idea in a tiny program.

## The big idea

Every Java program has a `main` method.

When you click Run, Java looks for `main` and runs the code inside it, top to bottom. Your job in this lesson is to put print statements inside `main` and see what shows up.

You will also see a few lines around `main` (like `public class HelloRobot`). Treat those as required setup for now — you need them so the program can run. We will explain what they mean in a later lesson. Focus on `main` and printing.

Printing means sending text to the console (the output window). That is how you see what your program is doing.

## Your first program

Create a new file named `HelloRobot.java` and type this exactly:

```java
public class HelloRobot {
    public static void main(String[] args) {
        System.out.println("Hello, robot world!");
    }
}
```

### What each part means

```java
public class HelloRobot { ... }
```

Required setup around your program. Keep it as shown for now. The name `HelloRobot` should match the file name `HelloRobot.java`.

```java
public static void main(String[] args)
```

This is the start of your program. Java always looks for `main` first. Memorize this line for now.

`{` and `}`

Curly braces mark the start and end of a block of code. Your print statements go inside the braces that belong to `main`.

```java
System.out.println(...)
```

Prints a line of text to the console, then moves to the next line.

`"Hello, robot world!"`

A string — text in double quotes.

`;`

Ends a statement. Most Java lines end with a semicolon.

### Run it

1. Compile and run the file (in VS Code: Run, or use your teacher's preferred method).
2. You should see: `Hello, robot world!`

If you see an error, check:

- The name after `class` matches the file name (`HelloRobot`). Case matters!
- Quotes are straight double quotes
- Every opening brace has a matching closing brace
- `main` is spelled exactly right (lowercase `m`)

## Printing more than one line

You can call `println` as many times as you want inside `main`. Each call prints on its own line.

```java
public class HelloRobot {
    public static void main(String[] args) {
        System.out.println("Team check-in");
        System.out.println("Battery: charged");
        System.out.println("Ready to drive");
    }
}
```

**Output:**

```
Team check-in
Battery: charged
Ready to drive
```

## println vs print

- `System.out.println("text")` — prints the text, then goes to a new line
- `System.out.print("text")` — prints the text and stays on the same line

```java
public class HelloRobot {
    public static void main(String[] args) {
        System.out.print("Left motor: ");
        System.out.print("OK");
        System.out.println();
        System.out.println("Right motor: OK");
    }
}
```

**Output:**

```
Left motor: OK
Right motor: OK
```

An empty `System.out.println();` prints a blank line (it just moves to the next line).

## Common mistakes

1. Typo in `main` — `Main`, `mian`, or changing `String[] args` means Java may not find the starting point.
2. Code outside of `main` — Your print statements need to be inside the curly braces that belong to `main`.
3. Missing semicolon — `System.out.println("hi")` without a semicolon will not compile.
4. Using single quotes for a whole sentence — Strings use double quotes.
5. Mismatched braces — Count your braces — every opener needs a closer.
6. File name does not match — If the file is `HelloRobot.java`, keep the name `HelloRobot` in the setup line at the top.

## Try it yourself

Put all of your code inside `main`. Then complete the exercise repo from Classroom 50.

### Challenge 1 — Team intro

Print three lines: (1) your team number, (2) your name, (3) the word “Programming”.

### Challenge 2 — Robot status board

Print a mini status board like:

```
=== ROBOT STATUS ===
Drive: enabled
Intake: ready
Shooter: idle
====================
```

### Challenge 3 — Same line, two prints

Using both `print` and `println`, produce exactly: `Autonomous mode: starting...`

Do it with two print calls (not one).

## Check your understanding

1. <details>
     <summary>Where does a Java program start running?</summary>
     In the `main` method.
   </details>
2. <details>
     <summary>Does every Java program need a `main` method?</summary>
     Yes. Java looks for `main` to start the program.
   </details>
3. <details>
     <summary>What is the difference between `print` and `println`?</summary>
     `println` ends the line; `print` does not.
   </details>

## Looking ahead

In Lesson 2, you will store values in variables (numbers, text, true/false) and print them. That is the next step toward tracking motor speeds, sensor readings, and scores in robot code.

Lesson complete. When you can run a program that starts in `main` and print several lines confidently, you are ready for Lesson 2.
