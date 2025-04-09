-- 1
with VentasAltas as(
	select *
    from Ventas
    where valor > 1000
)
select count(venta_id) as nro_total_ventas, avg(valor) as valor_promedio
from VentasAltas;

-- 2
with PromedioPorDepartamento as(
	select avg(salario) as salario_promedio, departamento_id
    from Empleados
    group by departamento_id
)
select ppd.salario_promedio, d.nombre_departamento
from PromedioPorDepartamento as ppd
join Departamentos as d on ppd.departamento_id = d.departamento_id
where salario_promedio > 4000;

-- 3
with AntiguedadEmpleados as(
	select empleado_id, nombre, fecha_contratacion, datediff(curdate(), fecha_contratacion) as dias_antiguedad
    from Empleados
)
select *
from AntiguedadEmpleados
where dias_antiguedad > (365*5);

-- 4
with VentasClientes as(
	select v.cliente_id, v.fecha_venta, v.venta_id, v.valor, c.apellido, c.nombre
    from Ventas as v
    join Clientes as c on v.cliente_id = c.cliente_id
)
select cliente_id, nombre, apellido, count(*) as cantidad_compras
from VentasClientes
where fecha_venta >= date_sub(curdate(), interval 1 year)
group by nombre, apellido, cliente_id
having count(*) > 3;

-- 5
with Top10Empleados as(
	select *
    from Empleados
    order by salario desc
    limit 10
)
select *
from Top10Empleados;

-- 6
with VentasPorMes as(
	select year(fecha_venta) as anio, month(fecha_venta) as mes, sum(valor) as total_ventas
    from Ventas
    group by anio, mes
)
select *
from VentasPorMes
where total_ventas > 5000;

-- 7

-- 8
with ClientesDuplicados as(
	select nombre, apellido, count(*) as cantidad
    from Clientes
    group by nombre, apellido
    having cantidad > 1
)
select *
from ClientesDuplicados;

-- 9
with TotalVentasPorCliente as(
	select cliente_id, sum(valor) as total_ventas
    from Ventas
    group by cliente_id
), Clientes10K as(
	select *
    from TotalVentasPorCliente
    where total_ventas > 1000
)
select *
from Clientes10K as c10
join Clientes as c on c10.cliente_id = c.cliente_id;

-- 10
with VentasUltimoMes as(
	
)














