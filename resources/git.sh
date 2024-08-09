#!/usr/bin/env bash
git --version
echo $1
echo $2
echo "https://github.com/"$1"/"$2".git"
git clone "https://github.com/"$1"/"$2".git"
cd $workingRepo
git remote
git submodule update --init --remote --recursive
