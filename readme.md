# 🖥️ Remote Control Application (Java Socket)

A **Client–Server Remote Control** application written in **Java** using **TCP sockets** and **Java Swing GUI**, allowing users to remotely monitor and control another computer.  
This project was developed as part of the _Computer Networks_ course at **University of Science – VNUHCM**.

---

## 📚 Overview

The system consists of **two main components**:

- **Client:** Sends control commands and receives data from the server.
- **Server:** Executes system-level operations (list processes, kill/start apps, take screenshots, log keys, etc.) and returns results to the client.

Communication is handled over **TCP/IP (port 6000)** using Java’s `Socket` and `ServerSocket` APIs.

---

## 🧩 Features

| #   | Feature                            | Description                                                                |
| --- | ---------------------------------- | -------------------------------------------------------------------------- |
| 1️⃣  | **List Running Processes**         | Client requests and displays a list of all active processes on the server. |
| 2️⃣  | **Start / Kill Process**           | Remotely start or terminate an application or process by name/PID.         |
| 3️⃣  | **Screenshot Capture**             | Server captures the current screen and sends the image to the client.      |
| 4️⃣  | **Keylogger**                      | Records key presses on the server machine and streams them to the client.  |
| 5️⃣  | **Shutdown Command**               | Allows the client to remotely shut down the server machine.                |
| 6️⃣  | **Graphical User Interface (GUI)** | Built entirely with Java Swing (`JFrame`, `JPanel`, `JButton`, etc.).      |

---

## ⚙️ Technologies Used

- **Language:** Java
- **Core Libraries:** `java.net`, `java.io`, `java.awt`, `javax.swing`, `javax.imageio`
- **Architecture:** TCP Socket (Client–Server model)
- **GUI Framework:** Java Swing
- **Concurrency:** Multithreading for asynchronous I/O
- **IDE:** Visual Studio Code / IntelliJ IDEA

---

## 🧠 How It Works

1. The **server** starts and listens on a specific port (`6000`).
2. The **client** connects using an IP address and sends command codes (e.g., 1 = list process, 2 = kill process).
3. The server executes the command and sends back the result.
4. The client displays data in the GUI (text, image, log, etc.).
5. All operations are handled concurrently via threads to avoid UI blocking.

---

## 🚀 How to Run

### Prerequisites

- Java JDK 17 or higher
- IDE (e.g., IntelliJ IDEA, Eclipse, VS Code)

### Steps

```bash
# 1️⃣ Compile both server and client
javac server/src/*.java
javac client/src/*.java

# 2️⃣ Run the server first
java -cp server/src server

# 3️⃣ Run the client next
java -cp client/src client

```

---

## 🎬 Demo Video

🎥 **Demo Video (Google Drive or YouTube)**  
👉 _You can watch the full demo directly below:_

- [🔗 View in Google Drive](https://drive.google.com/drive/folders/19tJ0aabBa1-whbwIIW_lxe0Q0UPr2r5j?usp=drive_link)

---

## 📄 Report

📘 **Project Report (PDF)** — Click to view or read inline below

- [🔗 View in Google Drive](https://drive.google.com/drive/folders/1AfH1vzrIRBiWy_Q0PsqRDVOTqRrad0Nz?usp=drive_link)
