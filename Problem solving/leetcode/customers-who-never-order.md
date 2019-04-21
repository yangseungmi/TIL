2019 4 21 

leetcode customers-who-never-order
easy sql problem

https://leetcode.com/problems/customers-who-never-order/

```mssql

select c.name as Customers from customers c

where c.id not in (select o.customerid from orders o)

```
