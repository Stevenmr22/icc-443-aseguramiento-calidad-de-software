# Práctica 1: Implementación y Pruebas de un Carrito de Compras

## Descripción del Proyecto

Este proyecto implementa un sistema básico de carrito de compras en Java. El objetivo principal es crear un conjunto de clases (`Product`, `ShoppingCartItem` y `ShoppingCart`) y probar su funcionalidad utilizando JUnit 5. El proyecto utiliza Gradle como herramienta de construcción.

## Funcionalidades

- **Product**: Representa un producto con un ID, un nombre y un precio.
- **ShoppingCartItem**: Representa un producto y su cantidad en el carrito de compras, calculando el subtotal correspondiente.
- **ShoppingCart**: Administra una colección de objetos `ShoppingCartItem`, permitiendo agregar, eliminar, modificar elementos y calcular el costo total.

## Pruebas

Se implementaron las siguientes pruebas para garantizar la correcta funcionalidad del sistema:

### `ProductTest`
- **`testProductCreation`**: Verifica que un `Product` se cree con el ID, nombre y precio correctos.
- **`testCreateProductWithNullId`**: Asegura que no se pueda crear un `Product` con un ID nulo.
- **`testCreateProductWithEmptyName`**: Asegura que no se pueda crear un `Product` con un nombre nulo.
- **`testCreateProductWithNegativePrice`**: Asegura que no se pueda crear un `Product` con un precio negativo.
- **`testProductPriceUpdate`**: Verifica que el precio de un `Product` se pueda actualizar correctamente.

### `ShoppingCartItemTest`
- **`testShoppingCartItemCreation`**: Verifica que un `ShoppingCartItem` se cree correctamente con un producto y una cantidad.
- **`testShoppingCartItemCreationWithNullProduct`**: Asegura que no se pueda crear un `ShoppingCartItem` con un producto nulo.
- **`testShoppingCartItemCreationWithNegativeQuantity`**: Asegura que no se pueda crear un `ShoppingCartItem` con una cantidad negativa.
- **`testShoppingCartItemCreationWithZeroQuantity`**: Asegura que no se pueda crear un `ShoppingCartItem` con una cantidad igual a cero.
- **`testShoppingCartItemQuantityUpdate`**: Verifica que la cantidad de un `ShoppingCartItem` se pueda actualizar correctamente.

### `ShoppingCartTest`
- **`testAddItemValid`**: Verifica que se puedan agregar elementos válidos al carrito de compras.
- **`testAddItemWithNullProduct`**: Asegura que no se pueda agregar un producto nulo al carrito.
- **`testAddItemWithZeroQuantity`**: Asegura que no se pueda agregar un producto con cantidad igual a cero al carrito.
- **`testAddItemExistingProduct`**: Verifica que al agregar un producto existente, se actualice su cantidad en el carrito.
- **`testRemoveItemValid`**: Verifica que se puedan eliminar elementos válidos del carrito.
- **`testRemoveItemNonExistingProduct`**: Asegura que no se genere una excepción al intentar eliminar un producto que no existe en el carrito.
- **`testGetTotalWithMultipleItems`**: Valida que el costo total de todos los elementos en el carrito se calcule correctamente.

## Cómo Ejecutar las Pruebas

1. Abre el proyecto en IntelliJ IDEA.
2. Navega al directorio `src/test/java`.
3. Haz clic derecho en el paquete `model` y selecciona `Run 'All Tests in 'model''`.

## Lo que se Hizo

- Se implementó la clase `Product` con atributos para el ID, nombre y precio, junto con validaciones y métodos getter y setter.
- Se creó la clase `ShoppingCartItem` para representar un producto y su cantidad, calculando el subtotal correspondiente.
- Se desarrolló la clase `ShoppingCart` para administrar una colección de elementos y proporcionar operaciones como agregar, eliminar, modificar elementos y calcular el costo total.
- Se escribieron pruebas unitarias detalladas para todas las clases para garantizar su funcionalidad y corrección.
- Se verificaron las pruebas utilizando **JUnit 5** y **Gradle**.
