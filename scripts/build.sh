#!/bin/bash
cd $( dirname $0 ) || exit 1
./cleanup-chroot.sh
./mkinitrd.sh
./mkfs.sh linux 
./mkiso.sh linux
