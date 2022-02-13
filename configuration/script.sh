#!/bin/bash
cd /home/ubuntu/java/project/covid19/data/COVID-19
git pull https://github.com/pcm-dpc/COVID-19.git
cd /home/ubuntu/java/project/covid19/data
mongo covid19 --eval "printjson(db.dropDatabase())"
mongoimport --host localhost --db covid19 --collection nazionale --type json --file /home/ubuntu/java/project/covid19/data/COVID-19/dati-json/dpc-covid19-ita-andamento-nazionale.json --jsonArray
mongoimport --host localhost --db covid19 --collection province --type json --file /home/ubuntu/java/project/covid19/data/COVID-19/dati-json/dpc-covid19-ita-province.json --jsonArray
mongoimport --host localhost --db covid19 --collection regioni --type json --file /home/ubuntu/java/project/covid19/data/COVID-19/dati-json/dpc-covid19-ita-regioni.json --jsonArray

