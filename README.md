# Prueba Técnica de Automatización de Pruebas (Web)

## Requisitos de Entrega

1. **Lenguaje**: Uso de Java.
2. **Framework**: Uso de Serenity BDD.
3. **Patrón de Diseño**: Uso de un patrón de diseño de automatización a su elección.
4. **Herramientas de Construcción**: Uso de Gradle o Maven a su elección.
5. **Integración con Cucumber**: Uso de la herramienta Cucumber.
6. **Compatibilidad con Navegadores**: La automatización debe ser capaz de ejecutarse en los navegadores Chrome y Firefox.
7. **Repositorio**: Subir la automatización a un repositorio de GitHub.

## Caso de Uso

- **Ingresar a la pagina**: Ingresar a la página https://www.demoblaze.com/
- **Registro de Usuario**: Realizar el registro de un nuevo usuario en la página Product Store.
- **Compra de Productos**: Realizar una compra, añadiendo productos al carrito.

### Nota Importante

La automatización debe ser genérica. El flujo funcional de realizar una compra tiene diferentes categorías (Phones, Laptops, Monitors) y dentro de estas categorías están los productos asociados.

La automatización debe ser capaz de:

1. Seleccionar una categoría y un producto, dependiendo de los datos de entrada.
2. Por ejemplo: Si se desea añadir un producto de la categoría "Phone" y que sea un producto "Samsung", la automatización debe ser capaz de seleccionar la categoría "Phone" y solamente productos "Samsung".
3. Del mismo modo, si se desea ejecutar la automatización para seleccionar la categoría "Laptops" y el producto "Sony", la automatización debe ir a esta categoría mencionada y seleccionar solamente productos "Sony".

Por lo tanto, la automatización del flujo de realizar una compra debe recibir datos de entrada, los cuales deben ser utilizados para seleccionar la categoría y el producto a elegir.

## Prerequisitos

Antes de ejecutar el proyecto, asegúrate de cumplir con los siguientes prerequisitos:

1. **Java**: Debe estar instalado Java JDK 20 o superior.
2. **Maven**: Debe estar instalado Maven 3.9.5 o superior.
3. **Navegadores**: Asegúrate de tener los navegadores Chrome y Firefox instalados.

## Archivos de Datos de Entrada

Para que la automatización funcione correctamente, debes modificar los siguientes archivos de datos de entrada:

- **`src/test/resources/data/input_data.csv`**: Archivo que contiene los datos de entrada necesarios para las pruebas, como el usuario y la clave para registrar un nuevo usuario e iniciar sesión con este mismo, las categorías de productos y nombres específicos de productos.
- **`src/test/resources/data/place_order_data.csv`**: Archivo que contiene los datos que se utilizaran para utilizar en el check'in de el articulo en el Place Order.
## Ejecución del Proyecto

Para ejecutar el proyecto, sigue estos pasos:

1. **Configura el entorno**: Asegúrate de que todos los prerequisitos están instalados.
2. **Construye el proyecto**: Usa Maven para construir el proyecto.
    - Ejecutar con el navegador chrome: `mvn clean verify -Denvironment=chrome`
    - Ejecutar con el navegador firefox: `mvn clean verify -Denvironment=firefox`
