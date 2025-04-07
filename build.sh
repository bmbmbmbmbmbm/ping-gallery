#!/bin/sh

cd client || exit
./build.sh
cd ..

cd server || exit
./build.sh
cd ..