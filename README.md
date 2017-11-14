# DASFinalApplication
Final assignment of the Software Architecture and Design course Aug-Dec 2017.

This project was developed as an Android application using Kotlin.

All Kotlin files can be found [here](https://github.com/juliannieb/DASFinalApplication/tree/master/app/src/main/java/com/example/juliannieb/dastodolistproject).
Layout files can be found [here](https://github.com/juliannieb/DASFinalApplication/tree/master/app/src/main/res/layout).

## Patterns used

### MVC
The nature of an Android application uses `MVC` as design pattern, having all the views as the layouts, the controllers as the activities and the models as the classes that manage the information of the application.

### Singleton
The [ToDoList](https://github.com/juliannieb/DASFinalApplication/blob/master/app/src/main/java/com/example/juliannieb/dastodolistproject/Classes/ToDoList.kt) class uses the `Singleton` pattern, so only one instance of this class is created. It manages all the tasks and their information. It is used to display them in the ToDoListActivity class and store the tasks persistently.

### Iterator
To present the tasks in the correspondent ListView android uses the Iterator pattern to access to each task and render them individually in the [TasksListAdapter](https://github.com/juliannieb/DASFinalApplication/blob/master/app/src/main/java/com/example/juliannieb/dastodolistproject/Adapters/TasksListAdapter.kt) class.

### Observer
This pattern is used for any user interaction with the system. Listeners are created for every button to manage the gestures applied to them (click, press and so on).

### State
The [TaskActivity](https://github.com/juliannieb/DASFinalApplication/blob/master/app/src/main/java/com/example/juliannieb/dastodolistproject/TaskActivity.kt) uses this pattern for it to be reused in different scenarios. The main interface [StateTaskActivity](https://github.com/juliannieb/DASFinalApplication/blob/master/app/src/main/java/com/example/juliannieb/dastodolistproject/Classes/StatesTaskActivity/StateTaskActivity.kt) has 3 methods to implement. There are 2 possible states:
* [Create](https://github.com/juliannieb/DASFinalApplication/blob/master/app/src/main/java/com/example/juliannieb/dastodolistproject/Classes/StatesTaskActivity/StateCreate.kt): In this state, some buttons are hidden because they don’t apply, when a task is saved it’s added to the tasks list and when the back button is pressed it saves the current draft.
* [Edit](https://github.com/juliannieb/DASFinalApplication/blob/master/app/src/main/java/com/example/juliannieb/dastodolistproject/Classes/StatesTaskActivity/StateEdit.kt): In this state, all the buttons are visible, when a task is saved it’s edited in the tasks list and when the back button is pressed we don’t have to save any draft.

### Memento
When the user is adding a new task and for some reason he has to go back before saving it this pattern acts, a `Memento` is saved for the new task, so when the user opens the add task view again this draft is restored and he can save or edit it as a new task.

### Strategy
To sort the tasks list we have a [Strategy](https://github.com/juliannieb/DASFinalApplication/blob/master/app/src/main/java/com/example/juliannieb/dastodolistproject/Classes/StrategiesToDoList/StrategyToDoList.kt) interface with a sort method. There are 3 possible strategies to use:
* [Priority](https://github.com/juliannieb/DASFinalApplication/blob/master/app/src/main/java/com/example/juliannieb/dastodolistproject/Classes/StrategiesToDoList/StrategyPriority.kt): Implements the sort method using the Priority as comparing value.
* [Alphabetically](https://github.com/juliannieb/DASFinalApplication/blob/master/app/src/main/java/com/example/juliannieb/dastodolistproject/Classes/StrategiesToDoList/StrategyAlphabetically.kt): Implements the sort method using the Title as comparing value.
* [Total time](https://github.com/juliannieb/DASFinalApplication/blob/master/app/src/main/java/com/example/juliannieb/dastodolistproject/Classes/StrategiesToDoList/StrategyTotalTime.kt): Implements the sort method using the TotalTime as comparing value.

### Builder
To create any new task a [TaskFactory](https://github.com/juliannieb/DASFinalApplication/blob/master/app/src/main/java/com/example/juliannieb/dastodolistproject/Classes/TaskFactory.kt) object is used, we can set any property of the Task in there and build it to create a [Task](https://github.com/juliannieb/DASFinalApplication/blob/master/app/src/main/java/com/example/juliannieb/dastodolistproject/Classes/Task.kt) object.
