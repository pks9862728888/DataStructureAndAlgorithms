#!/usr/bin/env bash
echo "start"
v1=$(date +%s);
sleep 2s
v2=$(date +%s);

diff="$(("$v2" - "$v1"))"
echo "Total time taken: $(date -d @$diff +"%H hours %M minutes %S seconds" -u)"
echo "end"
