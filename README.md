# Vehicle Service Management System

A console-based Vehicle Service Management System built in Java as part of the **Data Structures & Algorithms (ICT 143-2)** module. The system demonstrates the practical use of core data structures to manage vehicle service operations.

---

## Data Structures Used

| Data Structure | Class | Purpose |
|---|---|---|
| **Queue** (Linked List) | `VehicleQueue.java` | Manages vehicles waiting for service (FIFO) |
| **Stack** (Linked List) | `VehicalStack.java` | Stores completed service history (LIFO) |
| **Binary Search Tree** | `VehicleTree.java` | Enables fast search of serviced vehicles by plate number |

---

## Features

- Register a new vehicle with owner name, service type, and priority level
- Service the next vehicle in the queue (moves to history)
- View all vehicles currently waiting for service
- View full service history (most recent first)
- Search any vehicle by plate number — shows live status (Waiting / Serviced)

---

## Project Structure

```
Vehicle-Service-System/
│
├── Main.java            # Entry point — console menu and user interaction
├── Vehical.java         # Vehicle data model (node used in Queue, Stack, BST)
├── VehicleQueue.java    # Queue implementation using Linked List
├── VehicalStack.java    # Stack implementation using Linked List
├── VehicleTree.java     # Binary Search Tree implementation
└── README.md
```

---

## How to Run

### Requirements
- Java JDK 8 or higher installed
- Command Prompt / Terminal

### Steps

**1. Clone the repository**
```bash
git clone https://github.com/sasindu-19/Vehicle-Service-System.git
cd Vehicle-Service-System
```

**2. Compile all Java files**
```bash
javac *.java
```

**3. Run the program**
```bash
java Main
```

---

## Menu Options

```
  MAIN MENU
  --------------------------------------------------
  [1]  Register New Vehicle
  [2]  Service Next Vehicle
  [3]  View Waiting Vehicles
  [4]  View Service History
  [5]  Search Vehicle by Plate Number
  [6]  Exit
  --------------------------------------------------
```

---

## Example Usage

1. Select **[1]** to register a vehicle — enter plate number, owner name, service type, and priority
2. Select **[2]** to service the next waiting vehicle — it moves to history
3. Select **[5]** to search any vehicle by plate — shows whether it is **Waiting** or **Serviced**

---

## Author

**Sasindu**  
Bachelor of Information and Communication Technology BICT (Hons)  
2nd Semester — Data Structures & Algorithms (ICT 143-2)
