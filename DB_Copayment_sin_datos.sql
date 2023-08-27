-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.11.3-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.3.0.6589
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para DB_Copayment
CREATE DATABASE IF NOT EXISTS `db_copayment` /*!40100 DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci */;
USE `DB_Copayment`;

-- Volcando estructura para procedimiento DB_Copayment.ConsultarSalarioDiarioPorEmpleado
DELIMITER //
CREATE PROCEDURE `ConsultarSalarioDiarioPorEmpleado`()
BEGIN
    -- Crear tabla temporal
    CREATE TEMPORARY TABLE IF NOT EXISTS  tempsalarioDiarioPorEmpleado (
         id INT NOT NULL,
         id_empleado int,
			nombre VARCHAR(50),
			departamento VARCHAR(50),
			dia DATETIME,
			horas_trabajadas INT,
			pago_por_hora DECIMAL(10,2),
			media_pago_por_hora DECIMAL(10,2)
    );
			 -- salario_por_media_pago_por_hora  DECIMAL(10,2),
		   -- 	salario_por_horas_trabajadas DECIMAL(10,2),
      SET @contador := 0;
    -- Insertar datos en la tabla temporal
    -- COALESCE es el homologo de isNULL EN SQL SERVER/.
      INSERT INTO tempsalarioDiarioPorEmpleado (id, id_empleado, nombre, departamento, dia, pago_por_hora,media_pago_por_hora,horas_trabajadas)
		SELECT  (@contador := @contador + 1),
		       T1.id_empleado,
		       T1.Nombre,
		       T1.departamento,
				 DATE(fecha) AS Dia, 
				 T1.pago_por_hora,                              
		        (SELECT AVG(pago_por_hora)  -- Obtenemos el la media el pago por hora por departamento
				     FROM erca_empleados  
					  WHERE departamento = T1.departamento 
					  GROUP BY Departamento) AS media_pago_por_hora,
				   /* (SELECT COALESCE(TIMEDIFF(MAX(fecha), MIN(fecha)),0)
						FROM erdo_entradas_salidas
						WHERE id_empleado = t1.id_empleado
						AND fecha >= Dia
						AND fecha < DATE_ADD(Dia, INTERVAL 1 DAY)
						GROUP BY DATE(fecha)) AS horas_trabajadas*/
					(SELECT COALESCE(TIMESTAMPDIFF(HOUR,MIN(fecha),MAX(fecha) ),0)
						FROM erdo_entradas_salidas
						WHERE id_empleado = t1.id_empleado
						AND fecha >= Dia
						AND fecha < DATE_ADD(Dia, INTERVAL 1 DAY)
						GROUP BY DATE(fecha)) AS horas_trabajadas
		FROM erca_empleados T1 
		INNER JOIN  erdo_entradas_salidas T2 ON T1.id_empleado = T2.id_empleado
		GROUP BY T1.id_empleado,  T1.Nombre,T1.departamento, Dia;

    -- Realizar calculo de horas trabajadas en base a la media de pago por hora y calculo de salario por horas trabajadas.
    
      SELECT *, COALESCE((media_pago_por_hora * horas_trabajadas ),0) AS salario_diario_por_media_de_pago_por_hora, -- Optenemos el salario diario por media de pago por hora.
		          COALESCE((pago_por_hora * horas_trabajadas ),0) AS salario_diario_por_horas_trabajadas   -- calculamos el salario por horas trabajas.
		FROM tempsalarioDiarioPorEmpleado ORDER BY dia desc;

    -- Eliminar la tabla temporal al terminar el proceso
    DROP TEMPORARY TABLE IF EXISTS tempsalarioDiarioPorEmpleado;
END//
DELIMITER ;

-- Volcando estructura para tabla DB_Copayment.erca_empleados
CREATE TABLE IF NOT EXISTS `erca_empleados` (
  `id_empleado` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `apellido_materno` varchar(50) DEFAULT NULL,
  `apellido_paterno` varchar(50) DEFAULT NULL,
  `departamento` enum('Desarrollo','Infraestructura','Proyectos','Operaciones') NOT NULL,
  `pago_por_hora` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id_empleado`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla DB_Copayment.erca_usuarios
CREATE TABLE IF NOT EXISTS `erca_usuarios` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `password` varchar(500) NOT NULL,
  PRIMARY KEY (`id_usuario`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla DB_Copayment.erdo_entradas_salidas
CREATE TABLE IF NOT EXISTS `erdo_entradas_salidas` (
  `id_entrada_salida` int(11) NOT NULL AUTO_INCREMENT,
  `id_empleado` int(11) NOT NULL,
  `fecha` datetime NOT NULL,
  `tipo_registro` enum('entrada','salida') NOT NULL,
  PRIMARY KEY (`id_entrada_salida`),
  KEY `id_empleado` (`id_empleado`),
  CONSTRAINT `erdo_entradas_salidas_ibfk_1` FOREIGN KEY (`id_empleado`) REFERENCES `erca_empleados` (`id_empleado`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- La exportación de datos fue deseleccionada.

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
