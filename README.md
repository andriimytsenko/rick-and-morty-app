# Rick and Morty Android App
This is a native Android application to view some basic details about Rick and Morty show. It operate with pool of data available on [The Rick and Morty API](https://rickandmortyapi.com/about). The API has access to about hundreds of characters, images, locations and episodes, filled with canonical information as seen on the TV show.

## App Architecture
The project write with MVI architecture pattern in mind, with **Data** / **Domain** / **UI** layers. See more on the Google's Guide to app architecture [official page](https://developer.android.com/topic/architecture). Each feature has it own package with all of this layers. Shared logic could be found in the **core** package. There is a common package structure:
```
featurename
│   ├───data
│   │   ├───local
│   │   │   ├───entities
│   │   │   ├───dao
│   │   ├───remote
│   │   │   ├───model
│   │   │   └───response
│   │   └───repository
│   ├───di
│   ├───domain
│   │   ├───mappers
│   │   ├───model
│   │   └───usecase
│   └───ui
│       ├───components
│       ├───mappers
│       ├───model
```

## DI
This app use [Koin](https://insert-koin.io/docs/quickstart/android/) for dependency injection implementation. Each **feature** should has it own file with Koin module. Check out the ```DIConfigurator.kt``` class to see how the Koin will load modules.

## Network
To perform an API network requests this app use [Ktor](https://ktor.io/docs/client-create-new-application.html) client implementation, paired with Kotlin Serialization plugin.

## ImageLoader
All images in the app load via [Coil](https://coil-kt.github.io/coil/) library. Note that it use the same shared instanse of ```HttpClient``` from netwotk module. Use ```ImageLoaderBuilder.kt``` to configure ImageLoader and cache settings.

## UI and Navigation
App UI implemented via Jetpack Compose and for navigation it use [Navigation3](https://developer.android.com/guide/navigation/navigation-3) library. Here is a common example of how to declare a navigation entry in this app:
```
/* Define a navigation key. Note that it should be Serializable */
sealed interface NavRoute : NavKey

@Serializable
data class OrderDetailsRoute(val orderId: Int) : NavRoute

@Serializable
data class CheckoutRoute() : NavRoute

/* Define an Entry for added navigation key */
NavDisplay(
        backStack = navBackStack,
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ),
        entryProvider = entryProvider {
            ...
            entry<OrderDetailsRoute> { route ->
                OrderDetailsScreen(
                        viewModel = koinViewModel(
                        parameters = { parameterSetOf(route.orderId) }
                    ),
                    navigateToCheckOut = { navBackStack.add(CheckoutRoute) },
                    navigateBack = { navBackStack.removeLastOrNull() }
            }
            ...
        }
    )
)

/* Implement Composable screen */
@Composable
fun OrderDetailsScreen(
    viewModel: OrderDetailsViewModel,
    navigateToCheckOut: () -> Unit,
    navigateBack: () -> Unit
) {
    ...
}
```
