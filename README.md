This project solves both JSON testcases exactly as described in the assignment.

Features

✔ Reads JSON dynamically (no hardcoding)
✔ Decodes numbers from any base (2–16, etc.)
✔ Uses Newton Forward Interpolation
✔ Computes only the constant term C
✔ Works for both sample and large testcases
✔ Clean Java implementation

Project Structure
Placement Assigment/
│── Main.java        # Java code
│── input1.json      # Sample test case
│── input2.json      # Second test case
└── README.md        # Documentation

Input Format (Given in Assignment)

Each root is given as:

"i": {
    "base": "b",
    "value": "v"
}


Example:

"2": {
    "base": "2",
    "value": "111"
}


Interpretation:

x = 2

y = binary "111" = decimal 7

Logic Used
1. JSON Parsing

All the roots and keys (n, k) are read from input.json.

2. Decoding Y-values

Long.parseLong(value, base) converts values like:

"111" base 2 → 7

"213" base 4 → 39

3. Polynomial Constant Calculation

Using Newton’s Forward Difference Method:

Build forward difference table

Constant term = diff[0][0]

Print this as final result

This method works because the constant term is independent of x-spacing.

How to Run (With json-simple JAR)
1. Compile
javac -cp .;json-simple-1.1.1.jar Main.java

2. Run
java -cp .;json-simple-1.1.1.jar Main

Test Cases
Test Case 1 → use:
input1.json → rename to → input.json

Test Case 2 → use:
input2.json → rename to → input.json


Run the program for each case to obtain the constant value C.

Output

The program prints:

For Testcase 1 : 4

For Testcase 2 : 995085094601491



A single integer — the constant term of the polynomial.

Author


This project was developed as part of a backend coding assignment using Java.
