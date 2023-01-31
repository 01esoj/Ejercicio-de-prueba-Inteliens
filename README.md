# WebScraping Perfumería Douglas
Este algoritmo realiza la técnica del WebScraping (raspado de datos), consiste únicamente en la recogida de información de una página web de forma automatizada. 
## Ventajas
* Aumento de la velocidad de procesos.
* Disminución de la carga de trabajo.
* La capacidad de manejar grandes cantidades de datos.
* Elimina el fallo humano.
## Requisitos
Para poder ejecutar el siguiente algoritmo es necesario usar una librería capaz de analizar, recoger y manipular datos almacenados en documentos HTML. En mi caso, usé la 
librería Jsoup de Java. Esta se puede implementar al proyecto mediante dependencias o instalando un [archivo jar](https://jsoup.org/download) que incluya estas dependencias. Yo he optado por instalar 
un archivo jar, el cual podréis encontrar dentro del proyecto. Si debido al entorno de desarrollo por ejemplo se desaría añadir esta librería manualmente la dependencia 
sería la siguiente. 
### Dependencia
```
<dependency>
  <!-- jsoup HTML parser library @ https://jsoup.org/ -->
  <groupId>org.jsoup</groupId>
  <artifactId>jsoup</artifactId>
  <version>1.15.3</version>
</dependency>
```
