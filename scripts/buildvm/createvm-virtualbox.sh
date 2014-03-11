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

    VBoxManage createvm --name "$NAME" --register
    VBoxManage modifyvm "$NAME" --memory 1024 --boot1 net --nic1 bridged --bridgeadapter1 en0
    VBoxManage startvm  "$NAME" --type gui
done
