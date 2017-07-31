#!/usr/bin/env bash

./mvnw -pl neverbounce-api-client clean javadoc:javadoc

APIDOCS="neverbounce-api-client/target/site/apidocs"
[ -d $APIDOCS ] && cd $APIDOCS || exit 1

git init
git remote add javadoc git@github.com:NeverBounce/NeverBounceApi-Java.git

git add --all
git commit -m "Regenerated Javadoc"
git push javadoc master:gh-pages -f

cd ../../../..
