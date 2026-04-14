# Learning Log

## Progress
Day 1: foundational data models and project setup
Day 2: implement parser to take raw SQL and turn it into a Query object
Day 3:


---


## Day 1
### What I built
Designed the full architecture of the database engine (Parser → Planner →
Executor → Storage + Index). Created four core data models in the storage
package: DataType (enum), Column, Row, and Table, and Database. Set up Maven
project, package structure, and connected to GitHub.

### What confused me
Minor Java Syntax and concepts resulting in overcomplicated implementation

### How I resolved it
resorted to simplest and most efficient way to get the things I needed done, done.

### Performance notes
N/A — no measurable performance work yet. Benchmarking begins once
query execution is implemented.

### If I restarted, I would
-

---


---


## Day 2
### What I built
Built the Parser class which takes a raw SQL string and returns a structured
Query object. Implemented tokenization using split(), keyword detection for
SELECT, FROM, and WHERE clauses, column extraction with comma cleanup, and
condition parsing. Also created the Query and QueryType classes in the parser
package.

### What confused me


### How I resolved it

### Performance notes
N/A — no measurable performance work yet. Parser correctness will be
validated when the executor is wired up in Day 3.


---