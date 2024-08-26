Feature: ProductStore

  @validacionPrecioProducto
  Scenario Outline: Validación del precio de un producto
    Given estoy en la página de la tienda
    When me logueo con mi usuario "<usuario>" y clave "<clave>"
    And navego a la categoria "<categoria>" y subcategoria "<subcategoria>"
    And agrego "<cantidad>" unidades del primer producto al carrito
    Then valido en el popup la confirmación del producto agregado
    And valido en el popup que el monto total sea calculado correctamente
    When finalizo la compra
    Then valido el titulo de la pagina del carrito
    And vuelvo a validar el calculo de precios en el carrito

    Examples:
      | usuario               | clave       | categoria | subcategoria | cantidad | descripcion              |
      | mrojasc7393@gmail.com | 12pass34#   | Clothes   | Men          | 2        | Usuario válido           |
      | inval@invalido.com    | novale      | Clothes   | Men          | 2        | Usuario inválido         |
      | mrojasc7393@gmail.com | 12pass34#   | Autos     | Sedan        | 2        | Categoría inexistente    |

