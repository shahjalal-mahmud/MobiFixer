# 📱 Phone Servicing Management System  

A mobile repair management application built using **Java, SQLite, and Firebase Authentication**. This app allows users to manage customer details, including adding, editing, deleting, and viewing customer records.  

## ✨ Features  
✅ Firebase Authentication for secure login  
✅ Add, Edit, Delete, and View Customers  
✅ Unique Customer ID Generation  
✅ SQLite Database for local storage  
✅ Sorting customers by delivery date  
✅ RecyclerView for displaying customer details  
✅ Jetpack Navigation for smooth transitions  
✅ Notification system for delivery reminders (Upcoming feature 🚀)  

---

## 📌 Technologies Used  
- **Java** (for Android development)  
- **SQLite** (local database)  
- **Firebase Authentication** (user authentication)  
- **RecyclerView** (for displaying customers)  
- **Jetpack Navigation** (for managing fragments)  

---

## 📂 Project Structure  

```
📦 MobiFixer
│── 📂 app/src/main/java/com/example/mobifixer/
│   ├── 📂 ui/                  # UI Fragments & Adapters
│   │   ├── DashboardFragment.java
│   │   ├── AllCustomersFragment.java
│   │   ├── AddCustomerFragment.java
│   │   ├── CustomerAdapter.java
│   │   ├── Customer.java
|   |   ├── LoginFragment.java
|   |   ├── SplashFragment.java
│   ├── 📂 database/             # Database Management
│   │   ├── DatabaseHelper.java
│   ├── ├── SignupActivity.java
│   │   ├── LoginActivity.java
│   ├── ├── DashboardActivity.java
│   │   ├── MainActivity.java
│   │   ├── SplashActivity.java
│── 📂 res/layout/               # UI Layout Files
│   ├── activity_dashboard.xml
│   ├── activity_login.xml
│   ├── activity_signup.xml
│   ├── activity_main.xml
│   ├── activity_splash.xml
│   ├── fragment_dashboard.xml
│   ├── fragment_all_customers.xml
│   ├── fragment_add_customer.xml
│   ├── fragment_login.xml
│   ├── fragment_splash.xml
│   ├── item_customer.xml
│── 📂 res/drawable/             # Icons & UI Drawables
│── 📂 res/values/               # Strings, Colors, Themes
│── AndroidManifest.xml
│── build.gradle
│── README.md
```

---

## 🚀 How to Run the Project  

### ✅ 1. Clone the Repository  
```bash
git clone https://github.com/shahjalal-mahmud/MobiFixer.git
cd MobiFixer
```

### ✅ 2. Open in Android Studio  
1. Open **Android Studio**  
2. Click **"Open an existing project"**  
3. Select the project folder  

### ✅ 3. Configure Firebase Authentication  
1. **Go to** [Firebase Console](https://console.firebase.google.com/)  
2. **Create a new project** (if not already created)  
3. **Enable Email/Password Authentication** under Firebase Authentication  
4. **Download the `google-services.json`** file and place it in `app/` folder  

### ✅ 4. Run the Project  
- **Using Emulator:** Click **Run ▶** in Android Studio  
- **Using Physical Device:**  
  - Enable **Developer Mode & USB Debugging**  
  - Connect via USB & Click **Run ▶**  

---

## 🛠 Troubleshooting  
### 🔹 App Crashes on Start?  
- Check if `google-services.json` is properly added.  
- Ensure Firebase Authentication is set up correctly.  

### 🔹 Database Not Updating?  
- Try clearing app data:  
  ```bash
  adb shell pm clear com.example.mobifixer
  ```
- Check Logcat for SQL errors.  

---

## 📜 License  
This project is open-source under the **MIT License**. Feel free to modify and distribute.  

---

## ✉️ Contact  
📧 Email: mahmud.nubtk@gmail.com  
🔗 GitHub: https://github.com/shahjalal-mahmud  

---
