# CourseApp

Дизайн-макет в Figma - [макет](https://www.figma.com/design/QXrKYWsCf6cwXTj8rDfTMD/Тестовое-задание-IT-курсы?node-id=0-1&t=kpw92aQ0tvmWPYYh-1)

## Модули

*   **`app`**: Отвечает за сборку всех модулей, навигацию и запуск приложения
*   **`core`**: Содержит общие для всех модулей компоненты
*   **`data`**: Включает реализацию репозиториев, работу с базой данных (Room) и загрузку данных из локального `courses.json`
*   **`domain`**: Содержит модели данных, интерфейсы репозиториев и Use-case
*   **`feature`**: Модули, представляющие отдельные экраны
    *   **`login`**: Экран входа
    *   **`home`**: Главный экран со списком всех курсов
    *   **`favorites`**: Экран со списком избранных курсов
    *   **`account`**: Экран профиля пользователя (заглушка)

## Cтек

*   **Язык**: Kotlin
*   **Архитектура**: Clean Architecture, MVVM
*   **UI**: XML, ViewBinding, Material Design
*   **Асинхронность**: Kotlin Coroutines, Flow
*   [**Dagger Hilt**](https://dagger.dev/hilt/)
*   [**Навигация**](https://developer.android.com/guide/navigation)
*   [**Room**](https://developer.android.com/training/data-storage/room)
*   [**AdapterDelegates**](https://github.com/sockeqwe/AdapterDelegates)
*   [**Работа с сетью**](https://square.github.io/retrofit/) (для возможности интеграции с API)
