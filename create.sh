#!/bin/sh

# set -xe

if [ $# -eq 0 ]
then
    echo "usage: ./create.sh [Year Number] [Day Number]"
    exit
fi


mkdir $1/day$2
touch $1/day$2/README.md
