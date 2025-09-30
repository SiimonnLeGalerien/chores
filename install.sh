#!/bin/bash
mkdir -p build
javac *.java -d build
cd build
jar cfe chore.jar Main *.class
mkdir -p ~/.local/lib/chore
mv chore.jar ~/.local/lib/chore/
cd ..
cp chore ~/.local/bin/
cp chores.csv ~/.local/lib/chore/chores.csv
echo "Chore installed successfuly"
