# Tabla de contenidos
-  [Introducción](#introducción)
-  [API](#api-de-la-aplicación-bakery)
  - [Recurso Baker](#recurso-baker)
    - [GET /bakers](#GET-/bakers)
    - [GET /bakers/{id}](#GET-/bakers/{id})
    - [POST /bakers](#POST-/bakers)
    - [PUT /bakers/{id}](#PUT-/bakers/{id})
    - [DELETE /bakers/{id}](#DELETE-/bakers/{id})
    - [GET bakers/{bakersid}/contacts](#GET-bakers/{bakersid}/contacts)
    - [GET bakers/{bakersid}/contacts/{contactsid}](#GET-bakers/{bakersid}/contacts/{contactsid})
    - [POST bakers/{bakersid}/contacts/{contactsid}](#POST-bakers/{bakersid}/contacts/{contactsid})
    - [PUT bakers/{bakersid}/contacts](#PUT-bakers/{bakersid}/contacts)
    - [DELETE bakers/{bakersid}/contacts/{contactsid}](#DELETE-bakers/{bakersid}/contacts/{contactsid}])
    - [GET bakers/{bakersid}/products](#GET-bakers/{bakersid}/products)
    - [GET bakers/{bakersid}/products/{productsid}](#GET-bakers/{bakersid}/products/{productsid})
    - [POST bakers/{bakersid}/products/{productsid}](#POST-bakers/{bakersid}/products/{productsid})
    - [PUT bakers/{bakersid}/products](#PUT-bakers/{bakersid}/products)
    - [DELETE bakers/{bakersid}/products/{productsid}](#DELETE-bakers/{bakersid}/products/{productsid}])
  - [Recurso Category](#recurso-category)
    - [GET /categorys](#GET-/categorys)
    - [GET /categorys/{id}](#GET-/categorys/{id})
    - [POST /categorys](#POST-/categorys)
    - [PUT /categorys/{id}](#PUT-/categorys/{id})
    - [DELETE /categorys/{id}](#DELETE-/categorys/{id})
  - [Recurso Client](#recurso-client)
    - [GET /clients](#GET-/clients)
    - [GET /clients/{id}](#GET-/clients/{id})
    - [POST /clients](#POST-/clients)
    - [PUT /clients/{id}](#PUT-/clients/{id})
    - [DELETE /clients/{id}](#DELETE-/clients/{id})
    - [GET clients/{clientsid}/creditCard](#GET-clients/{clientsid}/creditCard)
    - [GET clients/{clientsid}/creditCard/{creditCardid}](#GET-clients/{clientsid}/creditCard/{creditCardid})
    - [POST clients/{clientsid}/creditCard/{creditCardid}](#POST-clients/{clientsid}/creditCard/{creditCardid})
    - [PUT clients/{clientsid}/creditCard](#PUT-clients/{clientsid}/creditCard)
    - [DELETE clients/{clientsid}/creditCard/{creditCardid}](#DELETE-clients/{clientsid}/creditCard/{creditCardid}])
    - [GET clients/{clientsid}/adresses](#GET-clients/{clientsid}/adresses)
    - [GET clients/{clientsid}/adresses/{adressesid}](#GET-clients/{clientsid}/adresses/{adressesid})
    - [POST clients/{clientsid}/adresses/{adressesid}](#POST-clients/{clientsid}/adresses/{adressesid})
    - [PUT clients/{clientsid}/adresses](#PUT-clients/{clientsid}/adresses)
    - [DELETE clients/{clientsid}/adresses/{adressesid}](#DELETE-clients/{clientsid}/adresses/{adressesid}])
  - [Recurso ShoppingCart](#recurso-shoppingcart)
    - [GET /shoppingCarts](#GET-/shoppingCarts)
    - [GET /shoppingCarts/{id}](#GET-/shoppingCarts/{id})
    - [POST /shoppingCarts](#POST-/shoppingCarts)
    - [PUT /shoppingCarts/{id}](#PUT-/shoppingCarts/{id})
    - [DELETE /shoppingCarts/{id}](#DELETE-/shoppingCarts/{id})
    - [GET shoppingCarts/{shoppingCartsid}/item](#GET-shoppingCarts/{shoppingCartsid}/item)
    - [GET shoppingCarts/{shoppingCartsid}/item/{itemid}](#GET-shoppingCarts/{shoppingCartsid}/item/{itemid})
    - [POST shoppingCarts/{shoppingCartsid}/item/{itemid}](#POST-shoppingCarts/{shoppingCartsid}/item/{itemid})
    - [PUT shoppingCarts/{shoppingCartsid}/item](#PUT-shoppingCarts/{shoppingCartsid}/item)
    - [DELETE shoppingCarts/{shoppingCartsid}/item/{itemid}](#DELETE-shoppingCarts/{shoppingCartsid}/item/{itemid}])
    - [GET shoppingCarts/{shoppingCartsid}/order](#GET-shoppingCarts/{shoppingCartsid}/order)
    - [GET shoppingCarts/{shoppingCartsid}/order/{orderid}](#GET-shoppingCarts/{shoppingCartsid}/order/{orderid})
    - [POST shoppingCarts/{shoppingCartsid}/order/{orderid}](#POST-shoppingCarts/{shoppingCartsid}/order/{orderid})
    - [PUT shoppingCarts/{shoppingCartsid}/order](#PUT-shoppingCarts/{shoppingCartsid}/order)
    - [DELETE shoppingCarts/{shoppingCartsid}/order/{orderid}](#DELETE-shoppingCarts/{shoppingCartsid}/order/{orderid}])
  - [Recurso SpecialOffer](#recurso-specialoffer)
    - [GET /specialOffers](#GET-/specialOffers)
    - [GET /specialOffers/{id}](#GET-/specialOffers/{id})
    - [POST /specialOffers](#POST-/specialOffers)
    - [PUT /specialOffers/{id}](#PUT-/specialOffers/{id})
    - [DELETE /specialOffers/{id}](#DELETE-/specialOffers/{id})
    - [GET specialOffers/{specialOffersid}/products](#GET-specialOffers/{specialOffersid}/products)
    - [GET specialOffers/{specialOffersid}/products/{productsid}](#GET-specialOffers/{specialOffersid}/products/{productsid})
    - [POST specialOffers/{specialOffersid}/products/{productsid}](#POST-specialOffers/{specialOffersid}/products/{productsid})
    - [PUT specialOffers/{specialOffersid}/products](#PUT-specialOffers/{specialOffersid}/products)
    - [DELETE specialOffers/{specialOffersid}/products/{productsid}](#DELETE-specialOffers/{specialOffersid}/products/{productsid}])
  - [Recurso Item](#recurso-item)
    - [GET /items](#GET-/items)
    - [GET /items/{id}](#GET-/items/{id})
    - [POST /items](#POST-/items)
    - [PUT /items/{id}](#PUT-/items/{id})
    - [DELETE /items/{id}](#DELETE-/items/{id})

# API Rest
## Introducción
La comunicación entre cliente y servidor se realiza intercambiando objetos JSON. Para cada entidad se hace un mapeo a JSON, donde cada uno de sus atributos se transforma en una propiedad de un objeto JSON. Todos los servicios se generan en la URL /Bakery.api/api/. Por defecto, todas las entidades tienen un atributo `id`, con el cual se identifica cada registro:

```javascript
{
    id: '',
    attribute_1: '',
    attribute_2: '',
    ...
    attribute_n: ''
}
```

Cuando se transmite información sobre un registro específico, se realiza enviando un objeto con la estructura mencionada en la sección anterior.
La única excepción se presenta al solicitar al servidor una lista de los registros en la base de datos, que incluye información adicional para manejar paginación de lado del servidor en el header `X-Total-Count` y los registros se envían en el cuerpo del mensaje como un arreglo.

La respuesta del servidor al solicitar una colección presenta el siguiente formato:

```javascript
[{}, {}, {}, {}, {}, {}]
```

## API de la aplicación Bakery
### Recurso Baker
El objeto Baker tiene 2 representaciones JSON:	

#### Representación Minimum
```javascript
{
    id: '' /*Tipo Long*/,
    name: '' /*Tipo String*/
}
```




#### GET /bakers

Retorna una colección de objetos Baker en representación Detail.

#### Parámetros

#### N/A

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de [representaciones Detail](#recurso-baker)
409|Un objeto relacionado no existe|Mensaje de error
500|Error interno|Mensaje de error

#### GET /bakers/{id}

Retorna una colección de objetos Baker en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Baker a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Baker en [representaciones Detail](#recurso-baker)
404|No existe un objeto Baker con el ID solicitado|Mensaje de error
500|Error interno|Mensaje de error

#### POST /bakers

Es el encargado de crear objetos Baker.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
body|body|Objeto Baker que será creado|Sí|[Representación Detail](#recurso-baker)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Baker ha sido creado|[Representación Detail](#recurso-baker)
409|Un objeto relacionado no existe|Mensaje de error
500|No se pudo crear el objeto Baker|Mensaje de error

#### PUT /bakers/{id}

Es el encargado de actualizar objetos Baker.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Baker a actualizar|Sí|Integer
body|body|Objeto Baker nuevo|Sí|[Representación Detail](#recurso-baker)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Baker actualizado|[Representación Detail](#recurso-baker)
409|Un objeto relacionado no existe|Mensaje de error
500|No se pudo actualizar el objeto Baker|Mensaje de error

#### DELETE /bakers/{id}

Elimina un objeto Baker.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Baker a eliminar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto eliminado|N/A
500|Error interno|Mensaje de error


#### GET bakers/{bakersid}/contacts

Retorna una colección de objetos Contact asociados a un objeto Baker en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Baker a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de objetos Contact en [representación Detail](#recurso-contact)
500|Error consultando contacts |Mensaje de error

#### GET bakers/{bakersid}/contacts/{contactsid}

Retorna un objeto Contact asociados a un objeto Baker en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
bakersid|Path|ID del objeto Baker a consultar|Sí|Integer
contactsid|Path|ID del objeto Contact a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Contact en [representación Detail](#recurso-contact)
404|No existe un objeto Contact con el ID solicitado asociado al objeto Baker indicado |Mensaje de error
500|Error interno|Mensaje de error

#### POST bakers/{bakersid}/contacts/{contactsid}

Asocia un objeto Contact a un objeto Baker.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
bakersid|PathParam|ID del objeto Baker al cual se asociará el objeto Contact|Sí|Integer
contactsid|PathParam|ID del objeto Contact a asociar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Objeto Contact asociado|[Representación Detail de Contact](#recurso-contact)
500|No se pudo asociar el objeto Contact|Mensaje de error

#### PUT bakers/{bakersid}/contacts

Es el encargado de actualizar un objeto Contact asociada a un objeto Baker.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
bakersid|Path|ID del objeto Baker cuya colección será remplazada|Sí|Integer
body|body|Colección de objetos Contact|Sí|[Representación Detail](#recurso-contact)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Se actualizo el objeto|Objeto Contact en [Representación Detail](#recurso-contact)
500|No se pudo actualizar|Mensaje de error

#### DELETE bakers/{bakersid}/contacts/{contactsid}

Remueve un objeto Contact asociado a un objeto Baker.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
bakersid|Path|ID del objeto Baker asociado al objeto Contact|Sí|Integer
contactsid|Path|ID del objeto Contact a remover|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto removido|N/A
500|Error interno|Mensaje de error

#### GET bakers/{bakersid}/products

Retorna una colección de objetos Product asociados a un objeto Baker en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Baker a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de objetos Product en [representación Detail](#recurso-product)
500|Error consultando products |Mensaje de error

#### GET bakers/{bakersid}/products/{productsid}

Retorna un objeto Product asociados a un objeto Baker en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
bakersid|Path|ID del objeto Baker a consultar|Sí|Integer
productsid|Path|ID del objeto Product a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Product en [representación Detail](#recurso-product)
404|No existe un objeto Product con el ID solicitado asociado al objeto Baker indicado |Mensaje de error
500|Error interno|Mensaje de error

#### POST bakers/{bakersid}/products/{productsid}

Asocia un objeto Product a un objeto Baker.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
bakersid|PathParam|ID del objeto Baker al cual se asociará el objeto Product|Sí|Integer
productsid|PathParam|ID del objeto Product a asociar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Objeto Product asociado|[Representación Detail de Product](#recurso-product)
500|No se pudo asociar el objeto Product|Mensaje de error

#### PUT bakers/{bakersid}/products

Es el encargado de actualizar un objeto Product asociada a un objeto Baker.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
bakersid|Path|ID del objeto Baker cuya colección será remplazada|Sí|Integer
body|body|Colección de objetos Product|Sí|[Representación Detail](#recurso-product)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Se actualizo el objeto|Objeto Product en [Representación Detail](#recurso-product)
500|No se pudo actualizar|Mensaje de error

#### DELETE bakers/{bakersid}/products/{productsid}

Remueve un objeto Product asociado a un objeto Baker.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
bakersid|Path|ID del objeto Baker asociado al objeto Product|Sí|Integer
productsid|Path|ID del objeto Product a remover|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto removido|N/A
500|Error interno|Mensaje de error


[Volver arriba](#tabla-de-contenidos)
### Recurso Category
El objeto Category tiene 2 representaciones JSON:	

#### Representación Minimum
```javascript
{
    id: '' /*Tipo Long*/,
    name: '' /*Tipo String*/
}
```

#### Representación Detail
```javascript
{
    // todo lo de la representación Minimum más los objetos Minimum con relación simple.
    parentCategory: {
    id: '' /*Tipo Long*/,
    name: '' /*Tipo String*/    }
}
```



#### GET /categorys

Retorna una colección de objetos Category en representación Detail.
Cada Category en la colección tiene embebidos los siguientes objetos: Category.

#### Parámetros

#### N/A

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de [representaciones Detail](#recurso-category)
409|Un objeto relacionado no existe|Mensaje de error
500|Error interno|Mensaje de error

#### GET /categorys/{id}

Retorna una colección de objetos Category en representación Detail.
Cada Category en la colección tiene los siguientes objetos: Category.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Category a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Category en [representaciones Detail](#recurso-category)
404|No existe un objeto Category con el ID solicitado|Mensaje de error
500|Error interno|Mensaje de error

#### POST /categorys

Es el encargado de crear objetos Category.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
body|body|Objeto Category que será creado|Sí|[Representación Detail](#recurso-category)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Category ha sido creado|[Representación Detail](#recurso-category)
409|Un objeto relacionado no existe|Mensaje de error
500|No se pudo crear el objeto Category|Mensaje de error

#### PUT /categorys/{id}

Es el encargado de actualizar objetos Category.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Category a actualizar|Sí|Integer
body|body|Objeto Category nuevo|Sí|[Representación Detail](#recurso-category)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Category actualizado|[Representación Detail](#recurso-category)
409|Un objeto relacionado no existe|Mensaje de error
500|No se pudo actualizar el objeto Category|Mensaje de error

#### DELETE /categorys/{id}

Elimina un objeto Category.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Category a eliminar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto eliminado|N/A
500|Error interno|Mensaje de error



[Volver arriba](#tabla-de-contenidos)
### Recurso Client
El objeto Client tiene 2 representaciones JSON:	

#### Representación Minimum
```javascript
{
    id: '' /*Tipo Long*/,
    name: '' /*Tipo String*/
}
```

#### Representación Detail
```javascript
{
    // todo lo de la representación Minimum más los objetos Minimum con relación simple.
    shoppingCart: {
    id: '' /*Tipo Long*/,
    name: '' /*Tipo String*/    }
}
```



#### GET /clients

Retorna una colección de objetos Client en representación Detail.
Cada Client en la colección tiene embebidos los siguientes objetos: ShoppingCart.

#### Parámetros

#### N/A

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de [representaciones Detail](#recurso-client)
409|Un objeto relacionado no existe|Mensaje de error
500|Error interno|Mensaje de error

#### GET /clients/{id}

Retorna una colección de objetos Client en representación Detail.
Cada Client en la colección tiene los siguientes objetos: ShoppingCart.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Client a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Client en [representaciones Detail](#recurso-client)
404|No existe un objeto Client con el ID solicitado|Mensaje de error
500|Error interno|Mensaje de error

#### POST /clients

Es el encargado de crear objetos Client.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
body|body|Objeto Client que será creado|Sí|[Representación Detail](#recurso-client)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Client ha sido creado|[Representación Detail](#recurso-client)
409|Un objeto relacionado no existe|Mensaje de error
500|No se pudo crear el objeto Client|Mensaje de error

#### PUT /clients/{id}

Es el encargado de actualizar objetos Client.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Client a actualizar|Sí|Integer
body|body|Objeto Client nuevo|Sí|[Representación Detail](#recurso-client)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Client actualizado|[Representación Detail](#recurso-client)
409|Un objeto relacionado no existe|Mensaje de error
500|No se pudo actualizar el objeto Client|Mensaje de error

#### DELETE /clients/{id}

Elimina un objeto Client.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Client a eliminar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto eliminado|N/A
500|Error interno|Mensaje de error


#### GET clients/{clientsid}/creditCard

Retorna una colección de objetos CreditCard asociados a un objeto Client en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Client a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de objetos CreditCard en [representación Detail](#recurso-creditcard)
500|Error consultando creditCard |Mensaje de error

#### GET clients/{clientsid}/creditCard/{creditCardid}

Retorna un objeto CreditCard asociados a un objeto Client en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
clientsid|Path|ID del objeto Client a consultar|Sí|Integer
creditCardid|Path|ID del objeto CreditCard a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto CreditCard en [representación Detail](#recurso-creditcard)
404|No existe un objeto CreditCard con el ID solicitado asociado al objeto Client indicado |Mensaje de error
500|Error interno|Mensaje de error

#### POST clients/{clientsid}/creditCard/{creditCardid}

Asocia un objeto CreditCard a un objeto Client.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
clientsid|PathParam|ID del objeto Client al cual se asociará el objeto CreditCard|Sí|Integer
creditCardid|PathParam|ID del objeto CreditCard a asociar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Objeto CreditCard asociado|[Representación Detail de CreditCard](#recurso-creditcard)
500|No se pudo asociar el objeto CreditCard|Mensaje de error

#### PUT clients/{clientsid}/creditCard

Es el encargado de actualizar un objeto CreditCard asociada a un objeto Client.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
clientsid|Path|ID del objeto Client cuya colección será remplazada|Sí|Integer
body|body|Colección de objetos CreditCard|Sí|[Representación Detail](#recurso-creditcard)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Se actualizo el objeto|Objeto CreditCard en [Representación Detail](#recurso-creditcard)
500|No se pudo actualizar|Mensaje de error

#### DELETE clients/{clientsid}/creditCard/{creditCardid}

Remueve un objeto CreditCard asociado a un objeto Client.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
clientsid|Path|ID del objeto Client asociado al objeto CreditCard|Sí|Integer
creditCardid|Path|ID del objeto CreditCard a remover|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto removido|N/A
500|Error interno|Mensaje de error

#### GET clients/{clientsid}/adresses

Retorna una colección de objetos Adress asociados a un objeto Client en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Client a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de objetos Adress en [representación Detail](#recurso-adress)
500|Error consultando adresses |Mensaje de error

#### GET clients/{clientsid}/adresses/{adressesid}

Retorna un objeto Adress asociados a un objeto Client en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
clientsid|Path|ID del objeto Client a consultar|Sí|Integer
adressesid|Path|ID del objeto Adress a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Adress en [representación Detail](#recurso-adress)
404|No existe un objeto Adress con el ID solicitado asociado al objeto Client indicado |Mensaje de error
500|Error interno|Mensaje de error

#### POST clients/{clientsid}/adresses/{adressesid}

Asocia un objeto Adress a un objeto Client.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
clientsid|PathParam|ID del objeto Client al cual se asociará el objeto Adress|Sí|Integer
adressesid|PathParam|ID del objeto Adress a asociar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Objeto Adress asociado|[Representación Detail de Adress](#recurso-adress)
500|No se pudo asociar el objeto Adress|Mensaje de error

#### PUT clients/{clientsid}/adresses

Es el encargado de actualizar un objeto Adress asociada a un objeto Client.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
clientsid|Path|ID del objeto Client cuya colección será remplazada|Sí|Integer
body|body|Colección de objetos Adress|Sí|[Representación Detail](#recurso-adress)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Se actualizo el objeto|Objeto Adress en [Representación Detail](#recurso-adress)
500|No se pudo actualizar|Mensaje de error

#### DELETE clients/{clientsid}/adresses/{adressesid}

Remueve un objeto Adress asociado a un objeto Client.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
clientsid|Path|ID del objeto Client asociado al objeto Adress|Sí|Integer
adressesid|Path|ID del objeto Adress a remover|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto removido|N/A
500|Error interno|Mensaje de error


[Volver arriba](#tabla-de-contenidos)
### Recurso ShoppingCart
El objeto ShoppingCart tiene 2 representaciones JSON:	

#### Representación Minimum
```javascript
{
    id: '' /*Tipo Long*/,
    name: '' /*Tipo String*/
}
```

#### Representación Detail
```javascript
{
    // todo lo de la representación Minimum más los objetos Minimum con relación simple.
    client: {
    id: '' /*Tipo Long*/,
    name: '' /*Tipo String*/    }
}
```



#### GET /shoppingCarts

Retorna una colección de objetos ShoppingCart en representación Detail.
Cada ShoppingCart en la colección tiene embebidos los siguientes objetos: Client.

#### Parámetros

#### N/A

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de [representaciones Detail](#recurso-shoppingcart)
409|Un objeto relacionado no existe|Mensaje de error
500|Error interno|Mensaje de error

#### GET /shoppingCarts/{id}

Retorna una colección de objetos ShoppingCart en representación Detail.
Cada ShoppingCart en la colección tiene los siguientes objetos: Client.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto ShoppingCart a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto ShoppingCart en [representaciones Detail](#recurso-shoppingcart)
404|No existe un objeto ShoppingCart con el ID solicitado|Mensaje de error
500|Error interno|Mensaje de error

#### POST /shoppingCarts

Es el encargado de crear objetos ShoppingCart.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
body|body|Objeto ShoppingCart que será creado|Sí|[Representación Detail](#recurso-shoppingcart)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto ShoppingCart ha sido creado|[Representación Detail](#recurso-shoppingcart)
409|Un objeto relacionado no existe|Mensaje de error
500|No se pudo crear el objeto ShoppingCart|Mensaje de error

#### PUT /shoppingCarts/{id}

Es el encargado de actualizar objetos ShoppingCart.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto ShoppingCart a actualizar|Sí|Integer
body|body|Objeto ShoppingCart nuevo|Sí|[Representación Detail](#recurso-shoppingcart)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto ShoppingCart actualizado|[Representación Detail](#recurso-shoppingcart)
409|Un objeto relacionado no existe|Mensaje de error
500|No se pudo actualizar el objeto ShoppingCart|Mensaje de error

#### DELETE /shoppingCarts/{id}

Elimina un objeto ShoppingCart.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto ShoppingCart a eliminar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto eliminado|N/A
500|Error interno|Mensaje de error

#### GET shoppingCarts/{shoppingCartsid}/item

Retorna una colección de objetos Item asociados a un objeto ShoppingCart en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto ShoppingCart a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de objetos Item en [representación Detail](#recurso-item)
500|Error consultando item |Mensaje de error

#### GET shoppingCarts/{shoppingCartsid}/item/{itemid}

Retorna un objeto Item asociados a un objeto ShoppingCart en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
shoppingCartsid|Path|ID del objeto ShoppingCart a consultar|Sí|Integer
itemid|Path|ID del objeto Item a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Item en [representación Detail](#recurso-item)
404|No existe un objeto Item con el ID solicitado asociado al objeto ShoppingCart indicado |Mensaje de error
500|Error interno|Mensaje de error

#### POST shoppingCarts/{shoppingCartsid}/item/{itemid}

Asocia un objeto Item a un objeto ShoppingCart.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
shoppingCartsid|PathParam|ID del objeto ShoppingCart al cual se asociará el objeto Item|Sí|Integer
itemid|PathParam|ID del objeto Item a asociar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Objeto Item asociado|[Representación Detail de Item](#recurso-item)
500|No se pudo asociar el objeto Item|Mensaje de error

#### PUT shoppingCarts/{shoppingCartsid}/item

Es el encargado de remplazar la colección de objetos Item asociada a un objeto ShoppingCart.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
shoppingCartsid|Path|ID del objeto ShoppingCart cuya colección será remplazada|Sí|Integer
body|body|Colección de objetos Item|Sí|[Representación Detail](#recurso-item)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Se remplazó la colección|Colección de objetos Item en [Representación Detail](#recurso-item)
500|No se pudo remplazar la colección|Mensaje de error

#### DELETE shoppingCarts/{shoppingCartsid}/item/{itemid}

Remueve un objeto Item de la colección en un objeto ShoppingCart.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
shoppingCartsid|Path|ID del objeto ShoppingCart asociado al objeto Item|Sí|Integer
itemid|Path|ID del objeto Item a remover|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto removido|N/A
500|Error interno|Mensaje de error


#### GET shoppingCarts/{shoppingCartsid}/order

Retorna una colección de objetos Order asociados a un objeto ShoppingCart en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto ShoppingCart a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de objetos Order en [representación Detail](#recurso-order)
500|Error consultando order |Mensaje de error

#### GET shoppingCarts/{shoppingCartsid}/order/{orderid}

Retorna un objeto Order asociados a un objeto ShoppingCart en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
shoppingCartsid|Path|ID del objeto ShoppingCart a consultar|Sí|Integer
orderid|Path|ID del objeto Order a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Order en [representación Detail](#recurso-order)
404|No existe un objeto Order con el ID solicitado asociado al objeto ShoppingCart indicado |Mensaje de error
500|Error interno|Mensaje de error

#### POST shoppingCarts/{shoppingCartsid}/order/{orderid}

Asocia un objeto Order a un objeto ShoppingCart.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
shoppingCartsid|PathParam|ID del objeto ShoppingCart al cual se asociará el objeto Order|Sí|Integer
orderid|PathParam|ID del objeto Order a asociar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Objeto Order asociado|[Representación Detail de Order](#recurso-order)
500|No se pudo asociar el objeto Order|Mensaje de error

#### PUT shoppingCarts/{shoppingCartsid}/order

Es el encargado de actualizar un objeto Order asociada a un objeto ShoppingCart.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
shoppingCartsid|Path|ID del objeto ShoppingCart cuya colección será remplazada|Sí|Integer
body|body|Colección de objetos Order|Sí|[Representación Detail](#recurso-order)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Se actualizo el objeto|Objeto Order en [Representación Detail](#recurso-order)
500|No se pudo actualizar|Mensaje de error

#### DELETE shoppingCarts/{shoppingCartsid}/order/{orderid}

Remueve un objeto Order asociado a un objeto ShoppingCart.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
shoppingCartsid|Path|ID del objeto ShoppingCart asociado al objeto Order|Sí|Integer
orderid|Path|ID del objeto Order a remover|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto removido|N/A
500|Error interno|Mensaje de error


[Volver arriba](#tabla-de-contenidos)
### Recurso SpecialOffer
El objeto SpecialOffer tiene 2 representaciones JSON:	

#### Representación Minimum
```javascript
{
    id: '' /*Tipo Long*/,
    name: '' /*Tipo String*/,
    description: '' /*Tipo String*/
}
```




#### GET /specialOffers

Retorna una colección de objetos SpecialOffer en representación Detail.

#### Parámetros

#### N/A

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de [representaciones Detail](#recurso-specialoffer)
409|Un objeto relacionado no existe|Mensaje de error
500|Error interno|Mensaje de error

#### GET /specialOffers/{id}

Retorna una colección de objetos SpecialOffer en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto SpecialOffer a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto SpecialOffer en [representaciones Detail](#recurso-specialoffer)
404|No existe un objeto SpecialOffer con el ID solicitado|Mensaje de error
500|Error interno|Mensaje de error

#### POST /specialOffers

Es el encargado de crear objetos SpecialOffer.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
body|body|Objeto SpecialOffer que será creado|Sí|[Representación Detail](#recurso-specialoffer)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto SpecialOffer ha sido creado|[Representación Detail](#recurso-specialoffer)
409|Un objeto relacionado no existe|Mensaje de error
500|No se pudo crear el objeto SpecialOffer|Mensaje de error

#### PUT /specialOffers/{id}

Es el encargado de actualizar objetos SpecialOffer.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto SpecialOffer a actualizar|Sí|Integer
body|body|Objeto SpecialOffer nuevo|Sí|[Representación Detail](#recurso-specialoffer)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto SpecialOffer actualizado|[Representación Detail](#recurso-specialoffer)
409|Un objeto relacionado no existe|Mensaje de error
500|No se pudo actualizar el objeto SpecialOffer|Mensaje de error

#### DELETE /specialOffers/{id}

Elimina un objeto SpecialOffer.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto SpecialOffer a eliminar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto eliminado|N/A
500|Error interno|Mensaje de error

#### GET specialOffers/{specialOffersid}/products

Retorna una colección de objetos Product asociados a un objeto SpecialOffer en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto SpecialOffer a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de objetos Product en [representación Detail](#recurso-product)
500|Error consultando products |Mensaje de error

#### GET specialOffers/{specialOffersid}/products/{productsid}

Retorna un objeto Product asociados a un objeto SpecialOffer en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
specialOffersid|Path|ID del objeto SpecialOffer a consultar|Sí|Integer
productsid|Path|ID del objeto Product a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Product en [representación Detail](#recurso-product)
404|No existe un objeto Product con el ID solicitado asociado al objeto SpecialOffer indicado |Mensaje de error
500|Error interno|Mensaje de error

#### POST specialOffers/{specialOffersid}/products/{productsid}

Asocia un objeto Product a un objeto SpecialOffer.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
specialOffersid|PathParam|ID del objeto SpecialOffer al cual se asociará el objeto Product|Sí|Integer
productsid|PathParam|ID del objeto Product a asociar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Objeto Product asociado|[Representación Detail de Product](#recurso-product)
500|No se pudo asociar el objeto Product|Mensaje de error

#### PUT specialOffers/{specialOffersid}/products

Es el encargado de remplazar la colección de objetos Product asociada a un objeto SpecialOffer.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
specialOffersid|Path|ID del objeto SpecialOffer cuya colección será remplazada|Sí|Integer
body|body|Colección de objetos Product|Sí|[Representación Detail](#recurso-product)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Se remplazó la colección|Colección de objetos Product en [Representación Detail](#recurso-product)
500|No se pudo remplazar la colección|Mensaje de error

#### DELETE specialOffers/{specialOffersid}/products/{productsid}

Remueve un objeto Product de la colección en un objeto SpecialOffer.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
specialOffersid|Path|ID del objeto SpecialOffer asociado al objeto Product|Sí|Integer
productsid|Path|ID del objeto Product a remover|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto removido|N/A
500|Error interno|Mensaje de error



[Volver arriba](#tabla-de-contenidos)
### Recurso Item
El objeto Item tiene 2 representaciones JSON:	

#### Representación Minimum
```javascript
{
    id: '' /*Tipo Long*/,
    name: '' /*Tipo String*/,
    image: '' /*Tipo String*/,
    price: '' /*Tipo Long*/
}
```

#### Representación Detail
```javascript
{
    // todo lo de la representación Minimum más los objetos Minimum con relación simple.
    shoppingCart: {
    id: '' /*Tipo Long*/,
    name: '' /*Tipo String*/    }
}
```



#### GET /items

Retorna una colección de objetos Item en representación Detail.
Cada Item en la colección tiene embebidos los siguientes objetos: ShoppingCart.

#### Parámetros

#### N/A

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de [representaciones Detail](#recurso-item)
409|Un objeto relacionado no existe|Mensaje de error
500|Error interno|Mensaje de error

#### GET /items/{id}

Retorna una colección de objetos Item en representación Detail.
Cada Item en la colección tiene los siguientes objetos: ShoppingCart.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Item a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Item en [representaciones Detail](#recurso-item)
404|No existe un objeto Item con el ID solicitado|Mensaje de error
500|Error interno|Mensaje de error

#### POST /items

Es el encargado de crear objetos Item.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
body|body|Objeto Item que será creado|Sí|[Representación Detail](#recurso-item)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Item ha sido creado|[Representación Detail](#recurso-item)
409|Un objeto relacionado no existe|Mensaje de error
500|No se pudo crear el objeto Item|Mensaje de error

#### PUT /items/{id}

Es el encargado de actualizar objetos Item.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Item a actualizar|Sí|Integer
body|body|Objeto Item nuevo|Sí|[Representación Detail](#recurso-item)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Item actualizado|[Representación Detail](#recurso-item)
409|Un objeto relacionado no existe|Mensaje de error
500|No se pudo actualizar el objeto Item|Mensaje de error

#### DELETE /items/{id}

Elimina un objeto Item.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Item a eliminar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto eliminado|N/A
500|Error interno|Mensaje de error



[Volver arriba](#tabla-de-contenidos)
