# About this Repo
A backend app created with Spring Boot. It display a basic functionality for a simple rest API to manage product's stock.

## Table
```sql
create table t_stock
(
	id int auto_increment,
	product_id int not null,
	stock_number int not null,
	constraint t_stock_pk
		primary key (id)
);
```

## Libraries
- Java 11
- Snowdrop 2.5.12