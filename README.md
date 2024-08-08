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

- **Registro de Usuario**: Realizar el registro de un nuevo usuario en la página Product Store.
- **Compra de Productos**: Realizar una compra, añadiendo productos al carrito.

### Nota Importante

La automatización debe ser genérica. El flujo funcional de realizar una compra tiene diferentes categorías (Phones, Laptops, Monitors) y dentro de estas categorías están los productos asociados.

La automatización debe ser capaz de:

1. Seleccionar una categoría y un producto, dependiendo de los datos de entrada.
2. Por ejemplo: Si se desea añadir un producto de la categoría "Phone" y que sea un producto "Samsung", la automatización debe ser capaz de seleccionar la categoría "Phone" y solamente productos "Samsung".
3. Del mismo modo, si se desea ejecutar la automatización para seleccionar la categoría "Laptops" y el producto "Sony", la automatización debe ir a esta categoría mencionada y seleccionar solamente productos "Sony".

Por lo tanto, la automatización del flujo de realizar una compra debe recibir datos de entrada, los cuales deben ser utilizados para seleccionar la categoría y el producto a elegir.