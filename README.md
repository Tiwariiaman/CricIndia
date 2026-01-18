# Cric India 🏏  
### Live Cricket Scores & Match Center (Android App)

Cric India is a modern **Android application** that displays **live and upcoming cricket matches with scores**, built using **Kotlin, Jetpack Compose, and Clean Architecture**.  
The app demonstrates **real-world Android development skills** such as networking, threading, pagination, error handling, and modern UI design.

---

## 📱 Features

- 🏏 Live & upcoming cricket matches
- 📊 Live scores (runs / wickets / overs)
- 🔄 Pull to refresh
- ⚡ Smooth list rendering with Paging 3
- 🚫 Graceful error handling (network / API issues)
- 🎨 Material 3 modern UI
- 🔁 Lifecycle-aware data loading
- 🧠 Clean Architecture (UI → Domain → Data)

---

## 🛠️ Tech Stack

- **Language:** Kotlin  
- **UI:** Jetpack Compose + Material 3  
- **Architecture:** Clean Architecture + MVVM  
- **Networking:** Retrofit  
- **Asynchronous:** Coroutines & Flow  
- **Pagination:** Paging 3  
- **State Handling:** LoadState (Loading / Error / Success)  

---

## 🧩 Architecture Overview
UI (Compose Screens)
↓
ViewModel
↓
Repository (Interface)
↓
PagingSource
↓
Retrofit API
↓
Cricket REST API

This architecture ensures:
- Separation of concerns
- Testability
- Scalability
- Maintainability

---

## 🌐 API Used

- **Cricket API:** CricAPI  
