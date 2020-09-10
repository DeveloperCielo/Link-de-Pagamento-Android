package br.com.cielo.linkdepagamentoandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.cielo.librarycielolinkpagamentos.CieloPaymentsLinkCallbacks
import br.com.cielo.librarycielolinkpagamentos.CieloPaymentsLinkClient
import br.com.cielo.librarycielolinkpagamentos.models.CieloPaymentsLinkParameters
import br.com.cielo.librarycielolinkpagamentos.models.SaleType
import br.com.cielo.librarycielolinkpagamentos.models.Transaction
import br.com.cielo.librarycielolinkpagamentos.models.paymentlink.recurrent.RecurrentInterval
import br.com.cielo.librarycielolinkpagamentos.models.paymentlink.shipping.ShippingType
import br.com.cielo.librarycielolinkpagamentos.Environment
import kotlinx.android.synthetic.main.activity_kotlin_main.*

class KotlinMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_main)
        val paymentsLink = CieloPaymentsLinkClient(
            environment = Environment.SANDBOX,
            clientId = "YOUR-CLIENT-ID",
            clientSecret = "YOUR-CLIENT-SECRET"
        )
        val parameters = CieloPaymentsLinkParameters(
            "ORDER", "4000", SaleType.DIGITAL, ShippingType.WITHOUTSHIPPING, recurrentInterval = RecurrentInterval.MONTHLY
        )

        paymentsLink.generateLink(parameters, object :
            CieloPaymentsLinkCallbacks {
            override fun onGetLink(link: Transaction) {
                txt1kotlin.text = link.shortUrl
            }

            override fun onError(error: String) {
                txt1kotlin.text = "link showing error $error"
            }
        })
    }
}
