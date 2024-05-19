package screen.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getNavigatorScreenModel
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import screen.show.ShowScreen

data class DetailsScreen(val name: String) : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        // todo without koin
        // val viewModel = rememberScreenModel { DetailsViewModel() }
        // val sharedViewModel = navigator?.rememberNavigatorScreenModel { DetailsViewModel() }

        // todo with koin
        val viewModel = getScreenModel<DetailsViewModel>()
        // val sharedViewModel = navigator?.getNavigatorScreenModel<DetailsViewModel>()

        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Details Screen")
            Text("view model number: ${viewModel.number.value}")
            Text("You pass: $name")
            Button(
                onClick = {
                    navigator?.pop()
                }
            ) {
                Text("back")
            }
            Button(
                onClick = {
                    navigator?.push(ShowScreen(7))
                }
            ) {
                Text("move to show screen")
            }
        }
    }
}