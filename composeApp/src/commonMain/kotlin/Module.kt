import data.ApiData
import org.koin.core.context.startKoin
import org.koin.dsl.module
import screen.details.DetailsViewModel

val myModule = module {
    factory { DetailsViewModel(ApiData()) }
}

fun initKoin() {
    startKoin {
        modules(myModule)
    }
}