#!/bin/bash
function die() { echo "Error in $0: $1"; exit 1; }
DIR="$( dirname $0 )/../chroot"
echo "Dir is $DIR"

test -d $DIR || die "$DIR not found"

echo "Removing logs"
rm -rvf $DIR/var/log/* 2>/dev/null

echo "Remove the udev persistent device rules."
test -f $DIR/etc/udev/rules.d/70* && rm -fv $DIR/etc/udev/rules.d/70* 2>/dev/null

echo "Cleaning tmp dirs"
rm -rvf $DIR/tmp/* 				2>/dev/null
rm -rvf $DIR/var/tmp/* 				2>/dev/null

echo "Cleaning ssh keys"
/bin/rm -fv $DIR/etc/ssh/*key*	2>/dev/null

echo "Cleaning up man pages and doc"
rm -rvf $DIR/usr/share/man/*			2>/dev/null
rm -rvf $DIR/usr/share/doc/*			2>/dev/null

echo "Remove the root user shell history"
rm -fv $DIR/root/.bash_history			2>/dev/null

