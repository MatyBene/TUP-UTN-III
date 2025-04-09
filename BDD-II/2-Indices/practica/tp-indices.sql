-- 1
create index idx_ciudad on Clientes(ciudad);

explain
select concat(nombre, ' ', apellido) as nombre_completo, email
from Clientes
where ciudad = 'Madrid';

-- 2
create index idx_cliente_fecha on Pedidos(cliente_id, fecha_pedido);

explain
select concat(c.nombre, ' ', c.apellido) as nombre_completo, count(p.pedido_id) as total_pedidos
from Clientes as c
join Pedidos as p on c.cliente_id = p.cliente_id
where p.fecha_pedido between '2023-10-01' and '2023-11-01'
group by c.cliente_id;

-- 3
alter table Productos add codigo_producto varchar(10);

update Productos 
set codigo_producto = concat('CP', producto_id)
where producto_id is not null;

create unique index idx_codigo_producto_unico on Productos(codigo_producto);

insert into Productos values (5, 'Monitor', 'Electrónicos', 500.00, 'CP1');
-- Error Code: 1062. Duplicate entry 'CP1' for key 'Productos.idx_codigo_producto_unico'

-- 4
alter table Productos add descripcion text;

update Productos 
set descripcion = 'Una laptop es una computadora portátil que te permite trabajar, estudiar o entretenerte desde cualquier lugar.'
where producto_id = 1;

update Productos 
set descripcion = 'Una tablet es un dispositivo táctil más liviano que una laptop, ideal para leer, navegar por internet o ver videos.'
where producto_id = 2;

update Productos 
set descripcion = 'Un libro es una colección de páginas escritas o impresas que transmiten conocimientos, historias o ideas.'
where producto_id = 3;

update Productos 
set descripcion = 'Un smartphone es un teléfono inteligente que combina funciones de comunicación, cámara, navegación web y aplicaciones en un solo dispositivo.'
where producto_id = 4;

create fulltext index idx_nombre_descripcion on Productos(nombre_producto, descripcion);

select *
from Productos
where match(nombre_producto, descripcion) against ('portátil');

-- 5

-- 6
create index idx_email on Clientes(email);

explain
select *
from Clientes
where email = 'ana.garcia@email.com';

-- 7
create index idx_precio on Productos(precio);

select *
from Productos 
where precio between 0 and 500;
