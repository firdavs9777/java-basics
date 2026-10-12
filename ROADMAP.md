# Java Basics in 7 Days

Goal: finish core Java this week (Mon Oct 12 – Sun Oct 18, 2026), then **DSA in Java**, then **Spring**.

## Project layout

```
src/
├── day1 … day7/      ← LESSONS: read, run, tweak. Reference material.
├── practice/         ← YOUR SOLUTIONS: one file per day with every exercise as an empty method.
└── playground/       ← SCRATCH: try anything, break things, no rules.
```

## Daily routine (~4–5 hours)

| Step | Time | What to do |
|------|------|------------|
| 1. Learn | 1–1.5 h | Open each lesson file, **run it**, read the output next to the code. |
| 2. Tinker | 30 min | In `playground/Playground.java`, change values, break things, and read the errors. |
| 3. Practice | 2 h | Solve that day's exercises in `practice/DayNPractice.java` **without looking at the lesson first**. |
| 4. Review | 30 min | Tick the checklist below, write down one thing that confused you, commit and push. |

**Rule:** type the code yourself. Don't copy and paste. Typing is how syntax sticks.

## Checklist

### Day 1 (Mon): Basics
- [x] `Variables`: types, naming, declare vs init, `final`, `var`, primitive vs reference, `null`, scope
- [ ] `TypesAndOperators`: 8 primitives, casting, integer division, `%`, overflow
- [ ] `Conditions`: if / else if / else, `&&` `||` `!`
- [ ] `SwitchAndTernary`: `? :`, old switch, new `->` switch
- [ ] `practice/Day1Practice` done

### Day 2 (Tue): Loops and input
- [ ] `Loops`: for, while, do-while, break, continue
- [ ] `NestedLoops`: patterns, tables, first taste of O(n²)
- [ ] `UserInput`: Scanner, printf
- [ ] `practice/Day2Practice` done

### Day 3 (Wed): Methods, arrays, strings ⭐ most important for DSA
- [ ] `Methods`: params, return, overloading, pass-by-value
- [ ] `Recursion`: base case, call stack
- [ ] `ArraysBasics`: 1D, 2D, `Arrays.sort/toString`
- [ ] `Strings`: `equals` vs `==`, `charAt`, `StringBuilder`, `c - 'a'`
- [ ] `practice/Day3Practice` done

### Day 4 (Thu): OOP 1
- [ ] `ClassesAndObjects`: constructors, `this`, references, null
- [ ] `Encapsulation`: private and getters/setters, access modifiers
- [ ] `StaticAndRecords`: static, `equals`/`hashCode`, records
- [ ] `practice/Day4Practice` done

### Day 5 (Fri): OOP 2 ⭐ most important for Spring
- [ ] `Inheritance`: extends, override, polymorphism
- [ ] `AbstractAndInterfaces`: abstract classes, interfaces, default methods
- [ ] `Enums`: enums with fields and methods
- [ ] `practice/Day5Practice` done

### Day 6 (Sat): Collections and generics ⭐ most important for DSA
- [ ] `WrappersAndGenerics`: Integer vs int, `<T>`
- [ ] `Lists`: ArrayList, iteration, removeIf
- [ ] `MapsAndSets`: HashMap counting pattern, TreeMap, HashSet
- [ ] `StacksAndQueues`: ArrayDeque, PriorityQueue
- [ ] `Sorting`: Comparable, Comparator
- [ ] `practice/Day6Practice` done

### Day 7 (Sun): Exceptions, lambdas, mini project
- [ ] `Exceptions`: try/catch, checked vs unchecked, custom exceptions
- [ ] `LambdasAndStreams`: lambdas, streams, Optional
- [ ] `practice/Day7Practice` done
- [ ] 🏁 `GasStationApp`: build the mini project, which uses everything from the week

Fell behind? Days 1–2 can be compressed if they feel easy. **Don't skip Days 3, 5 and 6.**

## After this week

**DSA (next 6–10 weeks):** Big-O, then arrays and two pointers, sliding window, hashing, stacks and queues, linked lists, recursion and backtracking, binary search, trees, heaps, graphs (BFS/DFS), and dynamic programming. Solve LeetCode Easy problems first, aiming for 2–3 a day.

**Spring:** Maven/Gradle, then more Java (interfaces, annotations, generics, streams), then Spring Boot, REST controllers, Spring Data JPA with PostgreSQL, validation, exception handling, testing (JUnit) and security.
