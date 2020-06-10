#!/usr/bin/env bash
rm -rf target/
mkdir -p target/native-image 2>/dev/null
mvn -ntp -Pnative package > target/native-image/output.txt
