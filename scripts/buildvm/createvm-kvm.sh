#!/bin/bash -x
TOTAL=$1
COUNT=0

if [ -z "$1" ] || [ "X$1" == "X" ]; then
    echo "Usage $0 <amount>"
    exit 1
fi

while [ $COUNT -lt $TOTAL ];
do
    COUNT=$(( $COUNT +1 ))
    NAME="Testserver_${RANDOM}_$$"
    echo "Spawning node $NAME"
    virt-install --name=$NAME -r 1024 --vcpus=1 --os-type=linux --virt-type=kvm --pxe --network=bridge=br0 --vnc --nodisks --serial pty --serial null &
done
