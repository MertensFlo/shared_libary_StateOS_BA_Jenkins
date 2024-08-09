#!/usr/bin/env shell
git --version
echo $1
echo $2
git_repo = "https://github.com/"$1"/"$2".git"
echo $git_repo
git clone $git_repo
cd $workingRepo
git remote
git submodule update --init --remote --recursive
