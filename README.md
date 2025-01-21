# Spring JobRunr Example Application

## Setup Database
```shell
 docker run -e "ACCEPT_EULA=Y" -e "MSSQL_SA_PASSWORD=PKnxBcHkkCo8ADg8" --name mssql-2022 -h mssql-2022 -p 1433:1433 -d -v D:/docker-volumes/mssql/data:/var/opt/mssql/data -v D:/docker-volumes/mssql/log:/var/opt/mssql/log -v D:/docker-volumes/mssql/secrets:/var/opt/mssql/secrets mcr.microsoft.com/mssql/server:2022-CU16-ubuntu-22.04
```

## Schedule Jobs
```shell
curl --location --request POST 'localhost:8080/'
```