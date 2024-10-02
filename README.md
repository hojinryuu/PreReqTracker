# README for Rutgers Computer Science Course Prerequisite Graph

## Overview

This project is designed to assist Rutgers Computer Science students in understanding and planning their course trajectory. It leverages the concept of a Directed Acyclic Graph (DAG) to map out the prerequisites for various computer science courses. This graph representation helps students to visualize and determine the courses they need to complete before enrolling in advanced classes.

## Project Description

The Rutgers Computer Science program offers numerous courses, each with its own set of prerequisites. These prerequisites can be complex to navigate, especially for students planning their academic journey. To address this challenge, we've created a DAG where each node represents a computer science course, and each directed edge signifies a prerequisite relationship.

### Key Features:

- Directed Edges: These represent the prerequisite requirement, pointing from an advanced course to its prerequisite.
- No Cycles: Ensures that there are no circular dependencies in course prerequisites.
- Prerequisite Paths: Helps in identifying both direct and indirect prerequisites for any given course.

### Understanding the Graph

- Direct Prerequisites: A direct edge from Course A to Course B indicates that Course B is a direct prerequisite for Course A.
- Indirect Prerequisites: If Course A requires Course B, and Course B requires Course C, then Course C is an indirect prerequisite for Course A. These relationships are implied and not explicitly represented in the graph to avoid redundancy.

### Example:
CS211 (Direct Prerequisite: CS112): To enroll in CS211, a student must have completed CS112. Since CS112 requires CS111 and MAT151, these courses are indirect prerequisites for CS211.

## Limitations and Assumptions

- Model Scope: The graph doesn’t encompass every CS course but focuses on many popular ones.
- Course Options: The model doesn’t account for alternative course options (e.g., taking MAT135 instead of MAT151).
- Corequisites: The model does not represent corequisites.

## Using the Project
### Clone the Repository
```bash
git clone https://github.com/hojinryuu/PreReqTracker.git
cd PreReqTracker
```

- Course Planning: Use the graph to plan your academic path, ensuring all prerequisites for a desired course are satisfied.
- Graph Navigation: Traverse the graph from a target course backwards to identify all necessary prerequisite courses.