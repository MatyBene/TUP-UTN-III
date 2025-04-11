-- 1
create table AuditoriaClientes (
	AuditoriaID int auto_increment primary key,
    Accion varchar(10),
    Fecha timestamp default current_timestamp,
    ClienteID int,
    Nombre VARCHAR(50),
	Apellido VARCHAR(50),
	Email VARCHAR(100),
	Telefono VARCHAR(15)
);

delimiter &&
create trigger after_insert_auditoria_clientes
after insert on Clientes
for each row
begin
	insert into AuditoriaClientes (Accion, ClienteID, Nombre, Apellido, Email, Telefono) 
	values ('INSERT', new.ClienteID, new.Nombre, new.Apellido, new.Email, new.Telefono);
end &&
delimiter ;

-- 2
delimiter &&
create trigger after_update_auditoria_clientes
after update on Clientes
for each row
begin
	insert into AuditoriaClientes (Accion, ClienteID, Nombre, Apellido, Email, Telefono) 
	values ('UPDATE', new.ClienteID, new.Nombre, new.Apellido, new.Email, new.Telefono);
end &&
delimiter ;

-- 3
delimiter &&
create trigger after_delete_auditoria_clientes
after delete on Clientes
for each row
begin
	insert into AuditoriaClientes (Accion, ClienteID, Nombre, Apellido, Email, Telefono) 
	values ('DELETE', old.ClienteID, old.Nombre, old.Apellido, old.Email, old.Telefono);
end &&
delimiter ;

-- Probando Triggers AuditoriaClientes
-- Insertar cliente
insert into Clientes
values (6, 'Matias', 'Benedetti', 'mb@gmail.com', '1234567890');
-- Actualizar cliente
update Clientes
set Nombre = 'Maty'
where ClienteId = 6;
-- Eliminar cliente
delete from Clientes
where ClienteID = 6;

-- 4
-- DROP TRIGGER IF EXISTS after_update_precio_total;
delimiter &&
create trigger after_update_precio_total
after insert on DetallesPedido
for each row
begin
	update Pedidos
    set PrecioTotal = (
		select sum(pr.Precio * dp.Cantidad) 
        from DetallesPedido as dp
        join Productos as pr on dp.ProductoID = pr.ProductoID
        where dp.PedidoID = new.PedidoID
    )
    where PedidoID = new.PedidoID;
end &&
delimiter ;

-- Probando Trigger after_update_precio_total
-- Insertar cliente
insert into Clientes
values (6, 'Matias', 'Benedetti', 'mb@gmail.com', '1234567890');
-- Insertar producto
insert into Productos
values (101, 'P1', 12);
-- Insertar pedido
insert into Pedidos
values (1001, '2025-04-11', 6, 0);
-- Insertar detalle pedido
insert into DetallesPedido
values (2001, 1001, 101, 2);

-- 5
delimiter &&
create trigger before_insert_cantidad_producto
before insert on DetallesPedido
for each row
begin
	if new.Cantidad <= 0 then
		signal sqlstate '45000'
        set message_text = 'La cantidad debe ser mayor a 0.';
	end if;
end &&
delimiter ;

-- Probando Trigger before_insert_cantidad_producto
-- Insertando detalle pedido con cantidad menor a 0
insert into DetallesPedido
values (2001, 1001, 101, -1);
-- Insertando detalle pedido con cantidad igual a 0
insert into DetallesPedido
values (2001, 1001, 101, 0);

-- 6

-- 7

-- 8

-- 9

-- 10

-- 11

-- 12

-- 13

-- 14

-- 15