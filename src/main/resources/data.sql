create database if not exists demo;
drop table if exists demo.users;
drop table if exists demo.users_queue;
drop view if exists demo.allUsers;

CREATE TABLE demo.users
(
    id        String,
    name      String,
    email     String,
    password  String
) ENGINE = MergeTree()
      ORDER BY id;

CREATE TABLE demo.users_queue
(
    id        String,
    name      String,
    email     String,
    password  String
) ENGINE = Kafka('kafka:9092', 'topic-clickhouse', 'clickHouseServers', 'JSONEachRow')
      settings kafka_num_consumers = 2;


CREATE MATERIALIZED VIEW demo.allUsers TO demo.users
AS
SELECT *
FROM demo.users_queue
    SETTINGS
    stream_like_engine_allow_direct_select = 1;

select count(*) as elements from demo.allUsers;

detach table demo.users_queue;
attach table demo.users_queue;
