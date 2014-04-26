#!/bin/bash
NAME=$1
FILE="../${NAME}.fs.squashfs"

if [ -z "$NAME" ] || [ "$NAME" = "" ] ;
then
    echo "Usage $0 NAME"
    exit 0
fi

DIR="$( dirname $0 )/../chroot"
test -d $DIR || { echo "Error in $0: $DIR not found!"; exit 1; }

echo "Cleaning up"
test -f $FILE && rm $FILE

echo "Creating squash fs"
mksquashfs $DIR $FILE -comp xz -e boot

echo "Created $FILE from $DIR"
