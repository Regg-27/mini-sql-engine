# Learning Log

## Progress
Day 1: foundational data models and project setup
Day 2: implement parser to take raw SQL and turn it into a Query object
Day 3: executor implementation
Day 4: 

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


## Day 2
### What I built
Built the Parser class which takes a raw SQL string and returns a structured
Query object. Implemented tokenization using split(), keyword detection for
SELECT, FROM, and WHERE clauses, column extraction with comma cleanup, and
condition parsing. Also created the Query and QueryType classes in the parser
package.

### What confused me
- flagging concept for the loop in Parser
- parser class structure

### How I resolved it
Took a look at the bigger picture to better understand where things should go and why.

### Performance notes
N/A — no measurable performance work yet. Parser correctness will be
validated when the executor is wired up in Day 3.


---


## Day 3
### What I built
Built the Executor class which takes a parsed Query object and runs it against
the Database. Implemented row filtering logic with WHERE clause support using
a switch statement on the condition operator. The executor retrieves the target
table from the database, iterates through all rows, and returns only the rows
that match the query conditions.

### What confused me
- looping through each row in the table and deciding if the row belongs in the results or not

### How I resolved it
- created two conditions, if there is a where clause and if there isn't a where clause. If there is a where clause, 
compare the row's value and the query's condition value and see if its a match in order to filter the rows.

### Performance notes
N/A — no benchmarking yet. Performance will become measurable once we wire
up a main entry point and run queries against real data in Day 5+.


---


## Day 4
### What I built


### What confused me
- 

### How I resolved it


### Performance notes



---


## Day 5
### What I built


### What confused me
- 

### How I resolved it


### Performance notes



---