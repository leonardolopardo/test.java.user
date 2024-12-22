#Conocimientos requeridos
Windows
Github
Maven
Web browser
ApiRest

#Guia de instalación

1. Clone el repositorio https://github.com/leonardolopardo/test.java.user
2. De no disponer de éste, descargue Maven de la siguiente ubicación
https://maven.apache.org/download.cgi por ejemplo, ésta versión apache-maven-3.9.9-bin.zip

3. Desde Windows abra una consola y dirijase donde clonó el repositorio.
En mi caso ... \workspace-spring-tool-suite-4-4.27.0.RELEASE\test
y ejecute el siguiente comando "mvn spring-boot:run"
 
Luego de varios minutos la aplicación estará desplegada.
Nota puede ser que Windows pida permiso a algunos accesos.

Vaya a la consola, busque el siguiente texto:
Using generated security password: 40a13814-3814-433d-a91b-07b6c3afcce3

Copie el valor detrás de los dos puntos llamado generated security password. En éste caso es 40a13814-3814-433d-a91b-07b6c3afcce3

4. Abra un navegador web e ingrese a http://localhost:8080/swagger-ui/index.html
Las credenciales para el Sign in son:
Username: user
Password: Copie el valor de la generated security password, en éste caso 40a13814-3814-433d-a91b-07b6c3afcce3

Aqui podrá ver la definión de los endpoints y DTOs.
