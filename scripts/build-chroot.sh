#!/bin/bash
DIR="$(dirname)/../chroot"
test -d $DIR &&  { echo 'Dir allready exists!'; exit 1; }

echo "Creating wheezy amd64 chroot! This will take some time :P"
debootstrap --arch=amd64 wheezy $DIR
