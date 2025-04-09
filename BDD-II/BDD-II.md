# 14/03/2025

## Contraseñas

- General: BDD2utn
- Comision 7: BDD2com7


# Unidad IV - UDF y CTE

## Funcion en MySQL 

Bloque de codigo SQL que devuelve un valor. Recibe parametros y encapsula logica. Se puede reutilizar en consultas.

### Deterministicas

Devuelven el mismo resultado para los mismos parametros. Ej: ABS(), LENGTH()

### No deterministicas

Resultado puede varias (depende de variables externas). Ej: NOW()

### Sintaxis de funcion e invocacion

```sql
create function calcular_precio_final(venta_id int, descuento decimal(7,2), impuesto decimal(7,2))
returns decimal(7,2)
begin
    declare subtotal decimal(10,2);
    declare total decimal(10,2);
    select precio * cantidad into subtotal
    from ventas
    where venta_id = venta_id;
    set total = subtotal * (1 - descuento) * (1 + impuesto);
    return total;
end;
```

```sql
create procedure actualizar_precio_final(venta_id int, descuento decimal(7,2), impuesto decimal(7,2))
begin
    update ventas
    set precio = calcular_precio_final(venta_id, descuento, impuesto)
    where venta_id = venta_id;
end;
```

## CTE (common table expressions)

Definen tablas temporales para usar en una consulta. Ventajas: legibilidad, reutilizacion, recursividad.

### Tipos de CTE

- Simple: 

```sql
with mi_CTE as (...) select * from mi_cte;
```

- Recursiva:

```sql
with recursive nombre as (...) select * from nombre;
```

Ej:

```sql
with ventas_totales as (
    select cliente_id, sum(total) as total_ventas
    from ventas
    group by cliente_id
)
select *  ventas_totales;
```