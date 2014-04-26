#!/bin/bash 
NAME=$1

if [ -z "$NAME" ] || [ "$NAME" = "" ] ;
then 
    echo "Usage $0 NAME"
    exit 0
fi

FILE="../${NAME}.iso"
DIR="$( dirname $0 )/../binary"
test -d $DIR || { echo "$DIR dir not found!"; exit 1; }

echo "Cleaning up"
test -f $FILE && rm $FILE

echo "Creating image"
xorriso -as mkisofs -r -J -joliet-long -l -cache-inodes -isohybrid-mbr /usr/lib/syslinux/isohdpfx.bin -partition_offset 16 -A "Superserver live runner"  -b isolinux/isolinux.bin -c \
isolinux/boot.cat -no-emul-boot -boot-load-size 4 -boot-info-table -o $FILE $DIR

echo "Created $FILE"

