#!/bin/bash
javac *.java
jar cfe chore.jar Main *.class
mkdir -p ~/.local/lib/chore
mv chore.jar ~/.local/lib/chore/
cp chore ~/.local/bin/
cp chores.csv ~/.local/lib/chore/chores.csv
echo "Chore installed successfuly"
