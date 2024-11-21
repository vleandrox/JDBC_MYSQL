use vivero;

/* PRUEBAS PARA ELIMINAR PRODUCTO EN CASCADA */
select * from producto;
INSERT INTO producto VALUES (51,'PR-001','Producto de Prueba',4,'05-10','Frutas SAC','',200,5.00,7.00);
select * from pedido;
insert into pedido(codigo_pedido,fecha_pedido,fecha_esperada,fecha_entrega,estado,comentarios,id_cliente) 
			values(35,'2007-06-20','2007-09-20','2007-09-20','Entregado',"Pagado",4);
select * from detalle_pedido;
INSERT INTO detalle_pedido VALUES (136,41,51,10,7,2);          

delete from producto
where id_producto = 51;
            
ALTER TABLE detalle_pedido DROP FOREIGN KEY fk_detalle_pedido_producto;
ALTER TABLE detalle_pedido DROP FOREIGN KEY detalle_pedido_ibfk_2;

ALTER TABLE detalle_pedido
ADD CONSTRAINT fk_detalle_pedido_producto
FOREIGN KEY (id_producto)
REFERENCES producto (id_producto)
ON DELETE CASCADE;