#!/bin/sh

pnpm i
pnpm run build

docker build .