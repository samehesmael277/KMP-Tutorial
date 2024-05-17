package screen.show

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
import screen.film.FilmModel
import screen.film.FilmScreen

data class ShowScreen(val number: Int) : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Show Screen")
            Text("You pass: $number")
            Button(
                onClick = {
                    navigator?.pop()
                }
            ) {
                Text("back")
            }
            Button(
                onClick = {
                    navigator?.push(FilmScreen(FilmModel(1, "x-men")))
                }
            ) {
                Text("move to film screen")
            }
            Button(
                onClick = {
                    navigator?.popUntilRoot()
                }
            ) {
                Text("back to root")
            }
        }
    }
}
