Designing a Task Management System
Requirements
1. The task management system should allow users to create tasks.
2. Each task should have a title, description, due date and status (e.g., pending, in progress, completed).
3. Users should be able to assign tasks to other users tasks.
4. The system should support searching and filtering tasks based on various criteria.(taskId, status)
5. Users should be able to mark tasks as completed.
6. The system should handle concurrent access to tasks and ensure data consistency.
7. The system should be extensible to accommodate future enhancements and new features.


Models -
User
Task
UserTaskMapping(user,task)

Enumeration 
TaskStatus


1: T1, T2

createUser(User)
create(User, Task)
assignTask(CurrentUser, User, Task)
updateTask(Task, Status)

