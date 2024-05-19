package screen.details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import data.ApiData
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import utils.log

class DetailsViewModel(
    private val apiData: ApiData
) : ScreenModel {

    private val _number = mutableStateOf(1)
    val number: State<Int> = _number

    init {
        "init...".log()
        increaseNumber()
    }

    private fun increaseNumber() {
        screenModelScope.launch {
            apiData.getData().toString().log()
            while (true) {
                delay(1000)
                _number.value += 1
            }
        }
    }

    override fun onDispose() {
        super.onDispose()
        "onDispose...".log()
    }
}