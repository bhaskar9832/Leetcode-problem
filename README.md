<!-- HEADER BANNER -->
<p align="center">
  <a href="https://github.com/bhaskar9832">
    <img src="https://readme-typing-svg.demolab.com?font=Orbitron&size=45&duration=3000&pause=500&color=FFD700&center=true&vCenter=true&width=900&height=80&lines=Solving+LeetCode+Problems+with+Java;Mastering+DSA+and+Algorithms" alt="Typing SVG" />
  </a>
</p>

---

# 🎯 LeetCode Problem Solutions

<p align="center">
  <strong>A dedicated journey of solving LeetCode problems with a focus on Java implementations</strong>
  <br/>
  <em>Mastering Data Structures, Algorithms, and Problem-Solving Techniques</em>
</p>

---

## 📌 About This Repository

This repository documents my **LeetCode problem-solving journey**, primarily using **Java**. Each solution includes:

✅ **Clean, optimized Java code**  
✅ **Time & Space complexity analysis**  
✅ **Multiple approaches** (brute force → optimal)  
✅ **Detailed explanations** and key insights  
✅ **Edge cases & test scenarios**  

### 🎓 Learning Objectives

- Master fundamental **Data Structures** (Arrays, LinkedLists, Trees, Graphs, etc.)
- Understand core **Algorithms** (Sorting, Searching, DP, Backtracking, etc.)
- Learn **Problem-Solving Patterns** (Two Pointers, Sliding Window, Binary Search, etc.)
- Build strong **coding interview** preparation skills

---

## 📂 Repository Structure

```
leetcode-problem/
├── README.md                          # Main documentation
├── CONTRIBUTING.md                    # How to contribute
├── LICENSE                            # MIT License
│
├── easy/                              # 🟢 Easy Problems
│   ├── 1-two-sum/
│   ├── 9-palindrome-number/
│   └── ...
│
├── medium/                            # 🟡 Medium Problems
│   ├── 2-add-two-numbers/
│   ├── 3-longest-substring/
│   └── ...
│
├── hard/                              # 🔴 Hard Problems
│   ├── 4-median-sorted-arrays/
│   └── ...
│
├── notes/                             # 📚 Learning Resources
│   ├── data-structures.md
│   ├── algorithms.md
│   ├── patterns.md
│   └── tips-and-tricks.md
│
└── utils/                             # 🛠️ Templates & Helpers
    ├── problem-template.md
    └── common-utilities.java
```

---

## 📊 Progress Tracker

| Difficulty | Count | Status |
|-----------|-------|--------|
| 🟢 Easy   | 0     | 🚀 In Progress |
| 🟡 Medium | 0     | 🚀 In Progress |
| 🔴 Hard   | 0     | 🚀 In Progress |
| **Total** | **0** | - |

---

## 🏆 Key Topics Covered

### Data Structures
- Arrays & Strings
- Linked Lists
- Stacks & Queues
- Trees & Graphs
- Hash Maps & Sets
- Heaps & Priority Queues

### Algorithms
- Sorting & Searching
- Dynamic Programming
- Backtracking
- Greedy Algorithms
- Graph Algorithms (BFS, DFS, Dijkstra)
- Bit Manipulation

### Problem-Solving Patterns
- Two Pointers
- Sliding Window
- Binary Search
- Divide & Conquer
- Top-K Elements
- Merge Intervals

---

## 💻 Solution Format

Each problem solution follows this structure:

```
problem-number-name/
├── Solution.java           # Main Java implementation
├── README.md               # Detailed explanation
└── Test.java               # Test cases
```

### README Template Includes:
- 📝 Problem Statement
- 🎯 Approach(es) with Trade-offs
- 💾 Time & Space Complexity
- 🔍 Code Walkthrough
- 💡 Key Insights & Lessons

---

## 🚀 How to Use This Repository

### 1️⃣ Browse Solutions
```
Navigate to easy/medium/hard folders to find problem solutions
```

### 2️⃣ Understand the Approach
```
Read the README for each problem to understand the solution
```

### 3️⃣ Study the Code
```
Examine the Java implementation with detailed comments
```

### 4️⃣ Run Test Cases
```
Execute the Test.java file to validate the solution
```

---

## 📖 Example Problem

### Two Sum (Easy)

**Problem**: Given an array of integers and an integer target, return the indices of two numbers that add up to the target.

**Approaches**:
1. **Brute Force**: O(n²) time, O(1) space
2. **Hash Map** (Optimal): O(n) time, O(n) space

**Best Solution**:
```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        return new int[] {};
    }
}
```

---

## 🤝 Contributing

Contributions are welcome! Please see [CONTRIBUTING.md](./CONTRIBUTING.md) for guidelines.

### How to Contribute:
- ✅ Add new problem solutions
- ✅ Optimize existing solutions
- ✅ Improve documentation
- ✅ Add alternative approaches
- ✅ Fix bugs or typos

---

## 🎓 Resources & References

- 📌 [LeetCode](https://leetcode.com) - Problem source
- 📚 [GeeksforGeeks](https://www.geeksforgeeks.org) - Data Structures & Algorithms
- 📖 [InterviewBit](https://www.interviewbit.com) - Coding interviews
- 🎥 [Abdul Bari - DSA](https://www.youtube.com/@abdul_bari) - Video tutorials

---

## 🔗 Connect With Me

[![LinkedIn](https://img.shields.io/badge/LinkedIn-%230077B5.svg?logo=linkedin&logoColor=white)](https://www.linkedin.com/in/bhaskarsarkar097)
[![GitHub](https://img.shields.io/badge/GitHub-black.svg?logo=github&logoColor=white)](https://github.com/bhaskar9832)
[![Email](https://img.shields.io/badge/Email-D14836?logo=gmail&logoColor=white)](mailto:bhaskarsarkar097@gmail.com)

---

## 📄 License

This project is licensed under the **MIT License** - see [LICENSE](./LICENSE) file for details.

---

## 🌟 Show Your Support

If you find this repository helpful, please ⭐ **star it** to show your support!

---

<p align="center">
  <strong>Made with 💻 and ☕ by Bhaskar Sarkar</strong>
  <br/>
  <em>Solving one problem at a time, one line of code at a time!</em>
</p>

```
      ___
     |  O|
     | /|\
     | / \
     |____|
    Coding mode: ON ✓
```
