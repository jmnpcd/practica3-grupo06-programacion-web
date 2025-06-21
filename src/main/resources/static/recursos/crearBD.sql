/*Se crea la base de datos */
DROP SCHEMA IF EXISTS practica;
CREATE SCHEMA practica;

/*Se crea un usuario para la base de datos llamado "usuario_practica" y tiene la contraseña "la_Clave"*/
CREATE USER 'usuario_practica'@'%' IDENTIFIED BY 'la_Clave';

/*Se asignan los privilegios sobre la base de datos practica al usuario creado */
GRANT ALL PRIVILEGES ON practica.* TO 'usuario_practica'@'%';
FLUSH PRIVILEGES;

USE practica;

/*Se crea la tabla arbol*/
CREATE TABLE arbol (
  id_arbol INT NOT NULL AUTO_INCREMENT,
  nombre_comun VARCHAR(50) NOT NULL,
  tipo_flor VARCHAR(50) NOT NULL,
  altura_promedio DOUBLE, 
  esperanza_vida INT,
  ruta_imagen VARCHAR(1024),
  PRIMARY KEY (id_arbol)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

/*Se insertan 3 registros en la tabla arbol como ejemplo */
INSERT INTO arbol (id_arbol, nombre_comun, tipo_flor, altura_promedio, esperanza_vida, ruta_imagen) VALUES 
(1, 'Arbol de Almendro', 'Flor blanca o rosada', 5.5, 20, 'https://www.museocostarica.go.cr/wp-content/uploads/Exhibici%C3%B3n_Jard%C3%ADn/Historia_Natural/Multimedia/Almendro_montana/Andira-inermis-arbol.jpg'),
(2, 'Arbol Duraznero', 'Rosada', 4.0, 36, 'https://jardineriapractica.com/wp-content/uploads/2022/04/arbol-de-durazno.png'),
(3, 'Manzano', 'Blanca o rosada clara', 5.0, 40, 'https://sembramos.com.co/wp-content/uploads/2021/07/Arbol-plantasyflores.pro_.jpg');
