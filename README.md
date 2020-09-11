# Link-de-Pagamento-Android [![Status](https://travis-ci.com/DeveloperCielo/Link-de-Pagamento-Android.svg?branch=master)](https://travis-ci.com/DeveloperCielo/Link-de-Pagamento-Android) [ ![Download](https://api.bintray.com/packages/braspag/cielo-payment-link/cielo-payment-link/images/download.svg) ](https://bintray.com/braspag/cielo-payment-link/cielo-payment-link/_latestVersion)

SDK do Link de Pagamento para Android, feito com Kotlin

## Principais recursos

* [x] Autenticação no oAuth
* [x] Crianção do link de pagamento
  * [x] De todos os tipos de produtos
  * [x] Com todos os tipos de entrega
  * [x] Com recorrência
  
## Instalação

É necessário a permissão de uso da internet no `Android Manifest.xml`:
```xml
    <uses-permission android:name="android.permission.INTERNET"/>
````

E para utilizar o SDK é necessário também implementar no `build.gradle(app:)`:
```groovy
dependencies {
    ...
    implementation 'br.com.braspag:cielo-payment-link:1.0.2'
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
            clientId = "YOUR-CLIENT-ID",
            clientSecret = "YOUR-CLIENT-SECRET"
        )
        val parameters = CieloPaymentsLinkParameters(
            "order_name", "400000", SaleType.DIGITAL, ShippingType.CORREIOS,
            "test_deliver", "10000", recurrentInterval = RecurrentInterval.MONTHLY
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

## Manual

Para mais informações sobre a integração com a API de Link de Pagamentos, vide o manual em: [Link de Pagamento] (https://developercielo.github.io/manual/linkdepagamentos5)
