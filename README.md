# backend-server

docker run in development

run serveces manualy in order: config-registry-gateway-others

run cassandra server

execute in CQL shell queries:
create keyspace testkeyspace WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 3};
create table userfile(id uuid PRIMARY KEY, file_name text, extension text, size bigint, upload_time timestamp, content blob);

test with postman
    
or run front server:

https://github.com/apache888/frontend-server
    
