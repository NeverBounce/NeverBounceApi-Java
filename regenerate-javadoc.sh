#!/usr/bin/env bash

./mvnw -pl neverbounce-api-client clean javadoc:javadoc

OLD_PWD=$(pwd)
API_DOCS="${OLD_PWD}/neverbounce-api-client/target/site/apidocs"
[ -d ${API_DOCS} ] && cd ${API_DOCS} || exit 1

TMP_API_DOCS=$(mktemp -d)
cd ${TMP_API_DOCS}

git init
git remote add upstream git@github.com:NeverBounce/NeverBounceApi-Java.git
git remote add origin git@github.com:laszlocsontosuw/NeverBounceApi-Java.git

git fetch upstream gh-pages:gh-pages
git checkout gh-pages

cp -R ${API_DOCS}/* ${TMP_API_DOCS}
git add --all
git commit -m "Regenerated Javadoc"
git push origin gh-pages:gh-pages -f

cd $OLD_PWD
