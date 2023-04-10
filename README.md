# java-explore-with-me
Финальный пул-реквест:
https://github.com/Alechkasp/java-explore-with-me/pull/5 

Реализовано:
- Main service - основной сервис;
- Stat service - сервис статистики.

# Main service:
### Public: Подборки событий - Публичный API для работы с подборками событий
:large_blue_circle: **GET** 

/compilations - получение подборок событий

/compilations/{compId} - получение подборки событий по его id

### Admin: Категории - API для работы с категориями
:green_circle: **POST**

/admin/categories - добавление новой категории

:red_circle: **DELETE** 

/admin/categories/{catId} - удаление категории

:white_circle: **PATCH** 

/admin/categories/{catId} - изменение категории

### Private: События - Закрытый API для работы с событиями
:large_blue_circle: **GET** 

/users/{userId}/events - получение событий, добавленных текущим пользователем

/users/{userId}/events/{eventId} - получение полной информации о событии, добавленном текущим пользователем

/users/{userId}/events/{eventId}/requests - получение информации о запросах на участие в событии текущего пользователя

:green_circle: **POST** 

/users/{userId}/events - добавление нового события

:white_circle: **PATCH** 

/users/{userId}/events/{eventId} - изменение события, добавленного текущим пользователем

/users/{userId}/events/{eventId}/requests - изменение статуса (подтверждена, отменена) заявок на участие в событии текущего пользователя

### Public: Категории - Публичный API для работы с категориями
:large_blue_circle: **GET** 

/categories - получение категорий

/categories/{catId} - получение информации о категории по ее идентификатору

### Admin: События - API для работы с событиями
:large_blue_circle: **GET** 

/admin/events - поиск событий

:white_circle: **PATCH**

/admin/events/{eventId} - редактирование данных события и его статуса (отклонение/публикация)

### Public: События - Публичный API для работы с событиями
:large_blue_circle: **GET**

/events - получение событий с возможностью фильтрации

/events/{id} - получение подробной информации об опубликованном событии по его идентификатору

### Private: Запросы на участие - Закрытый API для работы с запросами текущего пользователя на участие в событиях
:large_blue_circle: **GET**

/users/{userId}/requests - получение информации о заявках текущего пользователя на участие в событиях

:green_circle: **POST** 

/users/{userId}/requests - добавление запроса от текущего пользователя на участие в событии

:white_circle: **PATCH**

/users/{userId}/requests/{requestId}/cancel - отмена своего запроса на участие в событии

### Admin: Пользователи - API для работы с пользователями
:large_blue_circle: **GET**

/admin/users - получение информации о пользователях

:green_circle: **POST** 

/admin/users - добавление нового пользователя

:red_circle: **DELETE** 

/admin/users/{userId} - удаление пользователя

### Admin: Подборки событий - API для работы с подборками событий
:green_circle: **POST**

/admin/compilations - добавление новой подборки (подборка может не содержать событий)

:red_circle: **DELETE** 

/admin/compilations/{compId} - удаление подборки

:white_circle: **PATCH**

/admin/compilations/{compId} - обновить информацию о подборке

# Stat service:
### StatsController - API для работы со статистикой посещений
:large_blue_circle: **GET** 

/stats - получение статистики по посещениям

:green_circle: **POST**

/hit - сохранение информации о том, что к эндпоинту был запрос
