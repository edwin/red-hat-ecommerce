# About this Repo
A backend app created with Spring Boot and Apache Camel. It display a basic functionality for a simple rest API.

## Table
```sql
create table t_product
(
	id int auto_increment,
	product_name varchar(50) not null,
	product_description text not null,
	product_image varchar(100) not null,
	product_price decimal(10,2) not null,
	constraint t_product_pk
		primary key (id)
);


```

## Libraries
- Java 11
- Spring Boot 2.6.7
- Apache Camel 3.17.0