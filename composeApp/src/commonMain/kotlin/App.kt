import androidx.compose.material.BottomNavigation
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import tab.home.HomeTab
import tab.profile.ProfileTab
import tab.setting.SettingTab

@Composable
fun App() {
    initKoin()
    MaterialTheme {
        TabNavigator(HomeTab) {
            Scaffold(
                bottomBar = {
                    BottomNavigation {
                        TabNavigationItem(HomeTab)
                        TabNavigationItem(ProfileTab)
                        TabNavigationItem(SettingTab)
                    }
                }
            ) {
                CurrentTab()
            }
        }
    }
}
