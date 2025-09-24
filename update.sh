#!/bin/bash
git pull
javac *.java
jar cfe chore.jar Main *.class
mkdir -p ~/.local/lib/chore
mv chore.jar ~/.local/lib/chore/
cp chore ~/.local/bin/
echo "Chore updated successfuly"
