# Práctica 1: Implementación y Pruebas de un Carrito de Compras

## Descripción del Proyecto

Este proyecto implementa un sistema básico de carrito de compras en Java. El objetivo principal es crear un conjunto de clases (`Product`, `ShoppingCartItem` y `ShoppingCart`) y probar su funcionalidad utilizando JUnit 5. El proyecto utiliza Gradle como herramienta de construcción.

## Funcionalidades

- **Product**: Representa un producto con un nombre y un precio.
- **ShoppingCartItem**: Representa un producto y su cantidad en el carrito de compras.
- **ShoppingCart**: Administra una colección de objetos `ShoppingCartItem`, permitiendo agregar, eliminar, modificar elementos y calcular el costo total.

## Pruebas

Se implementaron las siguientes pruebas para garantizar la correcta funcionalidad del sistema:

### `ProductTest`
- **`testProductCreation`**: Verifica que un `Product` se cree con el nombre y precio correctos.
- **`testProductPriceUpdate`**: Asegura que el precio de un `Product` se pueda actualizar correctamente.

### `ShoppingCartItemTest`
- **`testSubTotal`**: Comprueba que el subtotal de un `ShoppingCartItem` (precio * cantidad) se calcule correctamente.

### `ShoppingCartTest`
- **`testAddItem`**: Verifica que se puedan agregar elementos al carrito de compras.
- **`testRemoveItem`**: Asegura que se puedan eliminar elementos del carrito de compras.
- **`testModifyItem`**: Confirma que se pueda modificar la cantidad de un elemento en el carrito de compras.
- **`testGetTotal`**: Valida que el costo total de todos los elementos en el carrito de compras se calcule correctamente.

## Cómo Ejecutar las Pruebas

1. Abre el proyecto en IntelliJ IDEA.
2. Navega al directorio `src/test/java`.
3. Haz clic derecho en el paquete `model` y selecciona `Run 'All Tests in 'model''`.

# Proyecto: Carrito de Compras en Java

## Lo que se Hizo

- Se implementó la clase `Product` con atributos para el nombre y el precio, junto con métodos getter y setter.
- Se creó la clase `ShoppingCartItem` para representar un producto y su cantidad.
- Se desarrolló la clase `ShoppingCart` para administrar una colección de elementos y proporcionar operaciones como agregar, eliminar, modificar elementos y calcular el costo total.
- Se escribieron pruebas unitarias para todas las clases para garantizar su funcionalidad y corrección.
- Se verificaron las pruebas utilizando **JUnit 5** y **Gradle**.
