PARTE 1

1. hacer un trigger after insert en una tabla de auditoria de productos. 
Entonces cada vez que se crea un producto se registra automaticamente la insercion de nuevos productos.

2. Para devolver el total de ventas utilizaria una funcion, en esta caso se necesita que devuelva 
un unico valor

3. legibilidad 
permite dividir una consulta compleja en varias consultas simples
se puede reutilizar
reemplaza las subconsultas

5. auditar la insercion como en el punto uno y/o modificar otra tabla.

6. cumple la funcion de que las modificaciones a la vista cumplan con la condicion de la consulta select. que el stock sea positivo

7. un b-treep, tomando que el producto_id es un int, este tipo de indice esta
optimizado para la comparacion de valores exactos y ordenamiento rapido. 

8. full text, esta optimizado para la busqueda de palabras claves en texto largos.

```sql
-- PARTE 2

-- 2.1
with VentasPorCliente as(
	select cliente_id, sum(valor) as total_ventas
	from Ventas 
	group by cliente_id;
)
create view ClientesPremium as
select c.cliente_id, c.nombre, c.apellido, vc.total_ventas
from Clientes as c
join VentasPorClientes as vc on c.cliente_id = vc.cliente_id
where vc.total_ventas > 5000;

-- 2.2
create table AuditoriaVentas (
	auditoria_id int auto_increment primary key,
	venta_id int,
    	fecha_borrado timestamp default current_timestamp,
);

delimiter &&
create trigger after_delete_auditoria_ventas
after delete on Ventas
for each row
begin
	insert into AuditoriaVentas(venta_id, fecha_borrado) 
	values (old.venta_id, now());
end &&
delimiter ;

-- 2.3
create index idx_cliente on Ventas(cliente_id);

-- 2.4
delimiter &&
create function antiguedad_anios(fecha_contratacion date)
return anios_antiguedad int
deterministic
begin
	return timestampdiff(year, fecha, curdate());
end &&
delimiter ;

create view EmpleadosAntiguos as
select nombre, salario, antiguedad_anios(fecha_contratacion) as antiguedad_en_anios
from Empleados
where antiguedad_en_anios > 5;

```








