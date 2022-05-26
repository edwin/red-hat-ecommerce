# About this Repo

A service app created with Spring Framework, JBoss EAP, MyBatis, Infinispan cache, and MySQL. It display a basic functionality for fetching list of store locations.

Tables
 ------------
```sql
create table t_location
(
	id int auto_increment,
	location_name varchar(60) null,
	constraint t_location_pk
		primary key (id)
);

INSERT INTO `db_test`.`t_location` (`location_name`) VALUES ('Jakarta')
INSERT INTO `db_test`.`t_location` (`location_name`) VALUES ('Kuala Lumpur')
INSERT INTO `db_test`.`t_location` (`location_name`) VALUES ('Singapore')
INSERT INTO `db_test`.`t_location` (`location_name`) VALUES ('Manila')
```

Libraries
------------
- Java 11
- Spring Framework 5.3.20
- MyBatis 3.5
- MyBatis EhCache
- JBoss EAP 7.4