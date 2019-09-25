# Link-de-Pagamento-Android

SDK do Link de Pagamento para Android, feito com Kotlin

## Principais recursos

* [x] Autenticação no oAuth
* [x] Crianção do link de pagamento
  * [x] De todos os tipos de produtos
  * [x] Com todos os tipos de entrega
  * [x] Com recorrência
  
## Instalação

Para instalar adicione a permissão de uso da internet no `Android Manifest.xml`:
```ruby
    <uses-permission android:name="android.permission.INTERNET"/>
````

Em seguida adicione no `build.gradle(Project:)`:
```ruby
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
````

E para utilizar o SDK é necessário implementar no `build.gradle(app:)`:
```ruby
dependencies {

    ...
    
    implementation 'com.github.DeveloperCielo:Link-de-Pagamento-Android:1.0'
}
````
## Uso

Para utilizar o SDK é necessário instanciar **CieloPaymentsLinkClient** e **CieloPaymentsLinkParameters**, chamar a função **generateLink**, 
passando os parametros e implementando **CieloPaymentsLinkCallbacks**, conforme o exemplo abaixo:

```kotlin

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val paymentsLink = CieloPaymentsLinkClient(
            environment= Environment.SANDBOX,
            clientID = "[CLIENT_ID]",
            clientSecret = "[CLIENT_SECRET]"
        )
        val parameters = CieloPaymentsLinkParameters(
            "nome_do_pedido", "400000", SaleType.DIGITAL, ShippingType.CORREIOS,
            "entrega_teste", "10000", recurrentInterval = RecurrentInterval.MONTHLY
        )

        paymentsLink.generateLink(parameters, object :
            CieloPaymentsLinkCallbacks {
            override fun onGetLink(response: Transaction) {
                txt1.text = response.shortUrl
            }

            override fun onError(error: String) {
                txt1.text = "error generating link, $error"
            }
        })
    }
}

```

O *Enum* de erro possui as seguintes opções:

* HttpStatusError(status: Int)
* BadRequest(error: String?)
* InternalError
* Unauthorized
* DecodingError
* EncodingError
* EmptyResponseBody

## Manual

Para mais informações sobre a integração com a API de Link de Pagamentos, vide o manual em: [Link de Pagamento] (https://developercielo.github.io/manual/linkdepagamentos5)
