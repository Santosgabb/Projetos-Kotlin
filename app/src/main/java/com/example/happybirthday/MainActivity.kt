package com.example.happybirthday

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Define o conteúdo real que será exibido no aplicativo.
        setContent {
            HappyBirthdayTheme {

                // Surface funciona como um contêiner da tela,
                // utilizando a cor de fundo definida pelo tema.
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    // Chamada do componente GreetingText,
                    // exibindo a mensagem e a assinatura.
                    GreetingText(
                        message = stringResource(R.string.happy_birthday_gabriel),
                        from = stringResource(R.string.from_ryan),
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    }
}

/*
 * @Composable:
 * Indica que a função representa um componente da interface do usuário.
 * Funções Composable utilizam a nomenclatura PascalCase.
 */
@Composable
fun GreetingText(
    message: String,
    from: String,
    modifier: Modifier = Modifier
) {

    /*
     * Column:
     * Organiza os componentes verticalmente
     * (um abaixo do outro).
     */
    Column(

        // Centraliza os componentes verticalmente na Column.
        verticalArrangement = Arrangement.Center,

        // Recebe modificações externas (padding, tamanho, etc.).
        modifier = modifier
    ) {

        // Texto principal da mensagem de aniversário.
        Text(
            text = message,

            // Tamanho da fonte.
            fontSize = 100.sp,

            // Espaçamento entre linhas.
            lineHeight = 116.sp,

            // Centraliza o texto.
            textAlign = TextAlign.Center
        )

        // Texto da assinatura/remetente.
        Text(
            text = from,

            // Tamanho da fonte da assinatura.
            fontSize = 36.sp,

            modifier = Modifier

                // Adiciona espaçamento ao redor do texto.
                .padding(16.dp)

                // Alinha o texto ao final da Column (lado direito).
                .align(alignment = Alignment.CenterHorizontally)
        )
    }
}
//funcao que recebe uma img
@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {
    /* val que localiza img */
    val image = painterResource(R.drawable.androidparty)

    //Utilizacao do Box
    Box (modifier) {
        //Recurso da img
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,// preenchi a tela
            alpha = 0.5F
        )
        GreetingText(
            message = message,
            from = from,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }


}

/*
 * @Preview:
 * Permite visualizar o resultado do componente
 * diretamente no Android Studio, sem executar o APK.
 *3
 * É utilizada apenas durante o desenvolvimento
 * e não é exibida ao usuário final.
 */



@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    HappyBirthdayTheme {

        /* Exemplo utilizado para gerar a prévia na IDE.
        GreetingText(
            message = "Happy Birthday Gabriel",
            from = "From Ryan"
        )*/
        GreetingImage(
            message = stringResource(R.string.happy_birthday_gabriel),
            from = stringResource(R.string.from_ryan)
        )

    }



}

/*
*setContent {} → define a interface real do aplicativo.
@Composable → indica funções que criam componentes da interface.
Surface → funciona como um contêiner que aplica o tema e o fundo da tela.
Column → organiza os elementos verticalmente.
Text → exibe textos na tela.
Modifier → modifica componentes (padding, alinhamento, tamanho etc.).
Arrangement.Center → centraliza os filhos verticalmente.
Alignment.End → posiciona o componente no final da Column (direita).
@Preview → mostra uma prévia na IDE; não faz parte do APK.
 */