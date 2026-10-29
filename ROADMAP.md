# Java Basics in 7 Modules

Goal: **Phase 1 (Java core)**: finish all 7 modules by **mid-December 2026**, then **DSA in Java**, then **Spring Boot**.

"Day N" in folder names means **module N**. Each one takes 2–4 days. Days 4–6 (classes, OOP, collections) are the big ones. Don't rush to match the labels.

## Project layout

```
src/
├── day1 … day7/      ← LESSONS: read, run, tweak. Reference material.
├── practice/         ← YOUR SOLUTIONS: one file per module with every exercise as an empty method.
└── playground/       ← SCRATCH: try anything, break things, no rules.
```

## Order from here (updated Oct 27, 2026)

1. ~~Finish the `Methods` TODOs~~ ✅
2. Go back to Module 2: `NestedLoops`, then `UserInput` (Scanner matters for Baekjoon-style tests that read their own input)
3. `Recursion`, then `Strings`, then Module 4
4. **Every day:** 2 LeetCode problems, plus extra reps from the matching `practice/DayNPractice` file

## Daily routine

| Step | What to do |
|------|------------|
| 1. Learn | Open the lesson file, **run it**, read the output next to the code. |
| 2. Tinker | In `playground/Playground.java`, change values, break things, and read the errors. |
| 3. Practice | Solve the exercises in `practice/DayNPractice.java` **without looking at the lesson first**. |
| 4. LeetCode | 2 problems. For each one, write down its Big-O and why. |
| 5. Review | Tick the checklist below, write down one thing that confused you, commit and push. |

**Rule:** type the code yourself. Don't copy and paste. Typing is how syntax sticks.

## Checklist

### Module 1: Basics ✅
- [x] `Variables`: types, naming, declare vs init, `final`, `var`, primitive vs reference, `null`, scope
- [x] `TypesAndOperators`: 8 primitives, casting, integer division, `%`, overflow
- [x] `Conditions`: if / else if / else, `&&` `||` `!`
- [x] `SwitchAndTernary`: `? :`, old switch, new `->` switch
- [x] `practice/Day1Practice` done

### Module 2: Loops and input
- [x] `Loops`: for, while, do-while, break, continue
- [ ] `NestedLoops`: patterns, tables, first taste of O(n²) ← **current**
- [ ] `UserInput`: Scanner, printf ⚠️ skipped, do after NestedLoops
- [ ] `practice/Day2Practice` done

### Module 3: Methods, arrays, strings ⭐ most important for DSA
- [x] `ArraysBasics`: 1D, 2D, `Arrays.sort/toString`
- [x] `Methods`: params, return, overloading, pass-by-value
- [ ] `Recursion`: base case, call stack
- [ ] `Strings`: `equals` vs `==`, `charAt`, `StringBuilder` (why `+=` in a loop is O(n²)), `c - 'a'`
- [ ] Big-O note: in your Recursion or Arrays practice, explain why a solution is O(n²) vs O(n) (e.g. Two Sum brute force vs HashMap)
- [ ] `practice/Day3Practice` done

### Module 4: OOP 1
- [ ] `ClassesAndObjects`: constructors, `this`, references, null
- [ ] `Encapsulation`: private and getters/setters, access modifiers
- [ ] `StaticAndRecords`: static, `equals`/`hashCode`, records
- [ ] `practice/Day4Practice` done

### Module 5: OOP 2 ⭐ most important for Spring
- [ ] `Inheritance`: extends, override, polymorphism
- [ ] `AbstractAndInterfaces`: abstract classes, interfaces, default methods
- [ ] `Enums`: enums with fields and methods
- [ ] `practice/Day5Practice` done

### Module 6: Collections and generics ⭐ most important for DSA
- [ ] `WrappersAndGenerics`: Integer vs int, `<T>`
- [ ] `Lists`: ArrayList, iteration, removeIf
- [ ] `MapsAndSets`: HashMap counting pattern, TreeMap, HashSet
- [ ] `StacksAndQueues`: ArrayDeque, PriorityQueue
- [ ] `Sorting`: Comparable, Comparator
- [ ] `practice/Day6Practice` done

### Module 7: Exceptions, lambdas, mini project
- [ ] `Exceptions`: try/catch, checked vs unchecked, custom exceptions
- [ ] `LambdasAndStreams`: lambdas, streams, Optional
- [ ] `practice/Day7Practice` done
- [ ] 🏁 `GasStationApp`: a console version of the real app idea. Do it well: this logic moves into Spring Boot later.

**Don't skip Modules 3, 5 and 6.**

## After Phase 1

**DSA:** Big-O, then arrays and two pointers, sliding window, hashing, stacks and queues, linked lists, recursion and backtracking, binary search, trees, heaps, graphs (BFS/DFS), and dynamic programming. Keep up the 2 LeetCode problems a day, and practise Baekjoon-style input/output for Korean coding tests (e.g. Coupang).

**Spring:** Maven/Gradle, then more Java (interfaces, annotations, generics, streams), then Spring Boot, REST controllers, Spring Data JPA with PostgreSQL, validation, exception handling, testing (JUnit) and security. Start by porting `GasStationApp`.
