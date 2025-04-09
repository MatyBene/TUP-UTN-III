-- MySQL dump 10.13  Distrib 8.0.36, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: guia1
-- ------------------------------------------------------
-- Server version	8.0.41-0ubuntu0.24.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Clientes`
--

DROP TABLE IF EXISTS `Clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Clientes` (
  `cliente_id` int NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `apellido` varchar(50) DEFAULT NULL,
  `ciudad` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cliente_id`),
  KEY `idx_ciudad` (`ciudad`),
  KEY `idx_email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Clientes`
--

LOCK TABLES `Clientes` WRITE;
/*!40000 ALTER TABLE `Clientes` DISABLE KEYS */;
INSERT INTO `Clientes` VALUES (1,'Ana','García','Madrid','ana.garcia@email.com'),(2,'Juan','Pérez','Barcelona','juan.perez@email.com'),(3,'María','López','Madrid','maria.lopez@email.com'),(4,'Carlos','Ruiz','Valencia','carlos.ruiz@email.com');
/*!40000 ALTER TABLE `Clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Detalle_Pedido`
--

DROP TABLE IF EXISTS `Detalle_Pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Detalle_Pedido` (
  `detalle_id` int NOT NULL,
  `pedido_id` int DEFAULT NULL,
  `producto_id` int DEFAULT NULL,
  `cantidad` int DEFAULT NULL,
  PRIMARY KEY (`detalle_id`),
  KEY `pedido_id` (`pedido_id`),
  KEY `producto_id` (`producto_id`),
  CONSTRAINT `Detalle_Pedido_ibfk_1` FOREIGN KEY (`pedido_id`) REFERENCES `Pedidos` (`pedido_id`),
  CONSTRAINT `Detalle_Pedido_ibfk_2` FOREIGN KEY (`producto_id`) REFERENCES `Productos` (`producto_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Detalle_Pedido`
--

LOCK TABLES `Detalle_Pedido` WRITE;
/*!40000 ALTER TABLE `Detalle_Pedido` DISABLE KEYS */;
INSERT INTO `Detalle_Pedido` VALUES (1,1,1,1),(2,1,2,2),(3,2,4,1),(4,3,3,3),(5,4,1,1),(6,5,2,2),(7,5,4,1);
/*!40000 ALTER TABLE `Detalle_Pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Pedidos`
--

DROP TABLE IF EXISTS `Pedidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Pedidos` (
  `pedido_id` int NOT NULL,
  `cliente_id` int DEFAULT NULL,
  `fecha_pedido` date DEFAULT NULL,
  PRIMARY KEY (`pedido_id`),
  KEY `idx_cliente_fecha` (`cliente_id`,`fecha_pedido`),
  CONSTRAINT `Pedidos_ibfk_1` FOREIGN KEY (`cliente_id`) REFERENCES `Clientes` (`cliente_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Pedidos`
--

LOCK TABLES `Pedidos` WRITE;
/*!40000 ALTER TABLE `Pedidos` DISABLE KEYS */;
INSERT INTO `Pedidos` VALUES (1,1,'2023-10-26'),(2,1,'2023-11-10'),(3,2,'2023-11-05'),(4,3,'2023-10-28'),(5,4,'2023-11-15');
/*!40000 ALTER TABLE `Pedidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Productos`
--

DROP TABLE IF EXISTS `Productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Productos` (
  `producto_id` int NOT NULL,
  `nombre_producto` varchar(50) DEFAULT NULL,
  `categoria` varchar(50) DEFAULT NULL,
  `precio` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`producto_id`),
  KEY `idx_codigo_producto` (`producto_id`),
  KEY `idx_precio` (`precio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Productos`
--

LOCK TABLES `Productos` WRITE;
/*!40000 ALTER TABLE `Productos` DISABLE KEYS */;
INSERT INTO `Productos` VALUES (1,'Laptop','Electrónicos',1200.00),(2,'Tablet','Electrónicos',300.00),(3,'Libro','Libros',25.00),(4,'Smartphone','Electrónicos',800.00);
/*!40000 ALTER TABLE `Productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `clientes_pedidos_recientes`
--

DROP TABLE IF EXISTS `clientes_pedidos_recientes`;
/*!50001 DROP VIEW IF EXISTS `clientes_pedidos_recientes`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `clientes_pedidos_recientes` AS SELECT 
 1 AS `nombre_completo`,
 1 AS `fecha_pedido`,
 1 AS `ultimo_producto`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `clientes_por_ciudad`
--

DROP TABLE IF EXISTS `clientes_por_ciudad`;
/*!50001 DROP VIEW IF EXISTS `clientes_por_ciudad`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `clientes_por_ciudad` AS SELECT 
 1 AS `nombre`,
 1 AS `apellido`,
 1 AS `email`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `clientes_productos_favoritos`
--

DROP TABLE IF EXISTS `clientes_productos_favoritos`;
/*!50001 DROP VIEW IF EXISTS `clientes_productos_favoritos`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `clientes_productos_favoritos` AS SELECT 
 1 AS `nombre_completo`,
 1 AS `producto_favorito`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `clientes_total_pedidos`
--

DROP TABLE IF EXISTS `clientes_total_pedidos`;
/*!50001 DROP VIEW IF EXISTS `clientes_total_pedidos`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `clientes_total_pedidos` AS SELECT 
 1 AS `nombre_completo`,
 1 AS `total_pedidos`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `ingresos_por_mes`
--

DROP TABLE IF EXISTS `ingresos_por_mes`;
/*!50001 DROP VIEW IF EXISTS `ingresos_por_mes`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `ingresos_por_mes` AS SELECT 
 1 AS `anio_mes`,
 1 AS `total_ingresos`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `productos_electronicos`
--

DROP TABLE IF EXISTS `productos_electronicos`;
/*!50001 DROP VIEW IF EXISTS `productos_electronicos`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `productos_electronicos` AS SELECT 
 1 AS `producto_id`,
 1 AS `nombre_producto`,
 1 AS `categoria`,
 1 AS `precio`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `productos_mas_vendidos_ciudad`
--

DROP TABLE IF EXISTS `productos_mas_vendidos_ciudad`;
/*!50001 DROP VIEW IF EXISTS `productos_mas_vendidos_ciudad`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `productos_mas_vendidos_ciudad` AS SELECT 
 1 AS `ciudad`,
 1 AS `nombre_producto`,
 1 AS `total_ventas`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `resumen_ventas_categoria`
--

DROP TABLE IF EXISTS `resumen_ventas_categoria`;
/*!50001 DROP VIEW IF EXISTS `resumen_ventas_categoria`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `resumen_ventas_categoria` AS SELECT 
 1 AS `categoria`,
 1 AS `SUM(d.cantidad)`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `ventas_electronicos`
--

DROP TABLE IF EXISTS `ventas_electronicos`;
/*!50001 DROP VIEW IF EXISTS `ventas_electronicos`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `ventas_electronicos` AS SELECT 
 1 AS `detalle_id`,
 1 AS `pedido_id`,
 1 AS `producto_id`,
 1 AS `cantidad`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `ventas_electronicos_7`
--

DROP TABLE IF EXISTS `ventas_electronicos_7`;
/*!50001 DROP VIEW IF EXISTS `ventas_electronicos_7`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `ventas_electronicos_7` AS SELECT 
 1 AS `detalle_id`,
 1 AS `pedido_id`,
 1 AS `producto_id`,
 1 AS `cantidad`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `clientes_pedidos_recientes`
--

/*!50001 DROP VIEW IF EXISTS `clientes_pedidos_recientes`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`admin`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `clientes_pedidos_recientes` AS select concat(`c`.`nombre`,' ',`c`.`apellido`) AS `nombre_completo`,(select max(`pe`.`fecha_pedido`) from `Pedidos` `pe` where (`pe`.`cliente_id` = `c`.`cliente_id`)) AS `fecha_pedido`,(select `pr`.`nombre_producto` from ((`Productos` `pr` join `Detalle_Pedido` `d` on((`pr`.`producto_id` = `d`.`producto_id`))) join `Pedidos` `pe` on((`d`.`pedido_id` = `pe`.`pedido_id`))) where (`pe`.`cliente_id` = `c`.`cliente_id`) order by `pe`.`fecha_pedido` desc limit 1) AS `ultimo_producto` from `Clientes` `c` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `clientes_por_ciudad`
--

/*!50001 DROP VIEW IF EXISTS `clientes_por_ciudad`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`admin`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `clientes_por_ciudad` AS select `Clientes`.`nombre` AS `nombre`,`Clientes`.`apellido` AS `apellido`,`Clientes`.`email` AS `email` from `Clientes` where (`Clientes`.`ciudad` = 'Madrid') */
/*!50002 WITH CASCADED CHECK OPTION */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `clientes_productos_favoritos`
--

/*!50001 DROP VIEW IF EXISTS `clientes_productos_favoritos`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`admin`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `clientes_productos_favoritos` AS select concat(`c`.`nombre`,' ',`c`.`apellido`) AS `nombre_completo`,(select `pr`.`nombre_producto` from ((`Pedidos` `pe` join `Detalle_Pedido` `d` on((`pe`.`pedido_id` = `d`.`pedido_id`))) join `Productos` `pr` on((`d`.`producto_id` = `pr`.`producto_id`))) where (`pe`.`cliente_id` = `c`.`cliente_id`) group by `pr`.`producto_id` order by sum(`d`.`cantidad`) desc limit 1) AS `producto_favorito` from `Clientes` `c` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `clientes_total_pedidos`
--

/*!50001 DROP VIEW IF EXISTS `clientes_total_pedidos`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`admin`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `clientes_total_pedidos` AS select concat(`c`.`nombre`,' ',`c`.`apellido`) AS `nombre_completo`,count(`pe`.`pedido_id`) AS `total_pedidos` from (`Clientes` `c` left join `Pedidos` `pe` on((`c`.`cliente_id` = `pe`.`cliente_id`))) group by `c`.`cliente_id` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `ingresos_por_mes`
--

/*!50001 DROP VIEW IF EXISTS `ingresos_por_mes`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`admin`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `ingresos_por_mes` AS select date_format(`pe`.`fecha_pedido`,'%Y-%m') AS `anio_mes`,sum((`pr`.`precio` * `d`.`cantidad`)) AS `total_ingresos` from ((`Pedidos` `pe` join `Detalle_Pedido` `d` on((`pe`.`pedido_id` = `d`.`pedido_id`))) join `Productos` `pr` on((`d`.`producto_id` = `pr`.`producto_id`))) group by `anio_mes` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `productos_electronicos`
--

/*!50001 DROP VIEW IF EXISTS `productos_electronicos`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`admin`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `productos_electronicos` AS select `Productos`.`producto_id` AS `producto_id`,`Productos`.`nombre_producto` AS `nombre_producto`,`Productos`.`categoria` AS `categoria`,`Productos`.`precio` AS `precio` from `Productos` where (`Productos`.`categoria` = 'Electrónicos') */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `productos_mas_vendidos_ciudad`
--

/*!50001 DROP VIEW IF EXISTS `productos_mas_vendidos_ciudad`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`admin`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `productos_mas_vendidos_ciudad` AS select `c`.`ciudad` AS `ciudad`,`pr`.`nombre_producto` AS `nombre_producto`,sum(`d`.`cantidad`) AS `total_ventas` from (((`Clientes` `c` join `Pedidos` `pe` on((`c`.`cliente_id` = `pe`.`cliente_id`))) join `Detalle_Pedido` `d` on((`pe`.`pedido_id` = `d`.`pedido_id`))) join `Productos` `pr` on((`d`.`producto_id` = `pr`.`producto_id`))) group by `c`.`ciudad`,`pr`.`nombre_producto` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `resumen_ventas_categoria`
--

/*!50001 DROP VIEW IF EXISTS `resumen_ventas_categoria`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`admin`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `resumen_ventas_categoria` AS select `pr`.`categoria` AS `categoria`,sum(`d`.`cantidad`) AS `SUM(d.cantidad)` from (`Productos` `pr` join `Detalle_Pedido` `d` on((`pr`.`producto_id` = `d`.`producto_id`))) group by `pr`.`categoria` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `ventas_electronicos`
--

/*!50001 DROP VIEW IF EXISTS `ventas_electronicos`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`admin`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `ventas_electronicos` AS select `d`.`detalle_id` AS `detalle_id`,`d`.`pedido_id` AS `pedido_id`,`d`.`producto_id` AS `producto_id`,`d`.`cantidad` AS `cantidad` from (`Detalle_Pedido` `d` join `productos_electronicos` `pre` on((`d`.`producto_id` = `pre`.`producto_id`))) */
/*!50002 WITH LOCAL CHECK OPTION */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `ventas_electronicos_7`
--

/*!50001 DROP VIEW IF EXISTS `ventas_electronicos_7`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`admin`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `ventas_electronicos_7` AS select `d`.`detalle_id` AS `detalle_id`,`d`.`pedido_id` AS `pedido_id`,`d`.`producto_id` AS `producto_id`,`d`.`cantidad` AS `cantidad` from (`Detalle_Pedido` `d` join `productos_electronicos` `pre` on((`d`.`producto_id` = `pre`.`producto_id`))) */
/*!50002 WITH CASCADED CHECK OPTION */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-04-04 14:48:33
