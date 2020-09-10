package br.com.cielo.linkdepagamentoandroid;

import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import br.com.cielo.librarycielolinkpagamentos.CieloPaymentsLinkCallbacks;
import br.com.cielo.librarycielolinkpagamentos.CieloPaymentsLinkClient;
import br.com.cielo.librarycielolinkpagamentos.models.CieloPaymentsLinkParameters;
import br.com.cielo.librarycielolinkpagamentos.models.SaleType;
import br.com.cielo.librarycielolinkpagamentos.models.Transaction;
import br.com.cielo.librarycielolinkpagamentos.models.paymentlink.shipping.ShippingType;
import br.com.cielo.librarycielolinkpagamentos.Environment;
import org.jetbrains.annotations.NotNull;

public class JavaMainActivity extends AppCompatActivity {

    private TextView txt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_main);
        txt1 = this.findViewById(R.id.txt1java);
        CieloPaymentsLinkClient paymentsLink = new CieloPaymentsLinkClient(Environment.SANDBOX, "YOUR-CLIENT-ID",
                "YOUR-CLIENT-SECRET");

        CieloPaymentsLinkParameters parameters = new CieloPaymentsLinkParameters(
                "ORDER", "4000", SaleType.DIGITAL, ShippingType.WITHOUTSHIPPING,
                "TEST", "1000000000");

        paymentsLink.generateLink(parameters, new CieloPaymentsLinkCallbacks() {
            @Override
            public void onGetLink(@NotNull Transaction link) {
                Transaction meuLink = link;
                txt1.setText(meuLink.getShortUrl());
            }

            @Override
            public void onError(@NotNull String error) {
                txt1.setText("link showing error " + error);
            }
        });
    }
}
