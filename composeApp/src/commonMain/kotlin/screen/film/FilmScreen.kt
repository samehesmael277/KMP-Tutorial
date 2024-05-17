package screen.film

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import screen.details.DetailsScreen

data class FilmModel(
    val id: Int,
    val name: String,
)

data class FilmScreen(val filmModel: FilmModel) : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Film Screen")
            Text("You pass, ${filmModel.id}, ${filmModel.name}")
            Button(
                onClick = {
                    navigator?.pop()
                }
            ) {
                Text("back")
            }
            Button(
                onClick = {
                    navigator?.popUntil {
                        it::class.simpleName == DetailsScreen::class.simpleName
                    }
                }
            ) {
                Text("back to details")
            }
        }
    }
}
