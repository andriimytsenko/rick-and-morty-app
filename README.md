# Rick and Morty Android App
This is a native Android application to view some basic details about Rick and Morty show. It operate with pool of data available on [The Rick and Morty API](https://rickandmortyapi.com/about). The API has access to about hundreds of characters, images, locations and episodes, filled with canonical information as seen on the TV show.

## App Architecture
The project write with MVI architecture pattern in mind, with **Data** / **Domain** / **UI** layers. See more on the Google's Guide to app architecture [official page](https://developer.android.com/topic/architecture). Each feature has it own package with all of this layers. Shared logic could be found in the **core** package.
