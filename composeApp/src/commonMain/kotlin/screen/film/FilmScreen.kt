package screen.film

import ContentWithMessageBar
import MessageBarPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.lifecycle.JavaSerializable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import rememberMessageBarState
import screen.details.DetailsScreen

data class FilmModel(
    val id: Int,
    val name: String,
) : JavaSerializable

data class FilmScreen(val filmModel: FilmModel) : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        val state = rememberMessageBarState()
        ContentWithMessageBar(
            messageBarState = state,
            position = MessageBarPosition.TOP
        ) {
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

                Button(
                    onClick = {
                        state.addSuccess(message = "Successfully Updated.")
                    }
                ) {
                    Text("show successfully")
                }
                Button(
                    onClick = {
                        state.addError(exception = Exception("Internet Unavailable."))
                    }
                ) {
                    Text("show exception")
                }
            }
        }
    }
}
