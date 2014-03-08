#!/bin/bash
DIR="$( dirname $0 )/../initrd"
FILE="$( dirname $0 )/../binary/live/initrd"

cd "$DIR" || { echo "dir $DIR not accessible!" ;  exit 1; }
test -f "$FILE" && rm -v "$FILE"

echo "Creating initrd"
find . | cpio -H newc -o | gzip -9  > $FILE
echo "Created binary/live/initrd in $FILE"

