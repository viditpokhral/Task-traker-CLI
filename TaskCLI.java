
public class TaskCLI {

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        if (args.length < 1) {
            System.out.println("Usage: TaskCLI <command> [arguments]");
            return;
        }
        String command = args[0];

        switch (command) {
            case "add":
                if (args.length < 2) {
                    System.out.println("Usage: TaskCLI add <description>");
                    return;
                }
                taskManager.addTask(args[1]);
                break;
            case "update":
                if (args.length < 3) {
                    System.out.println("Usage: TaskCLI update <id> <new description>");
                    return;
                }
                taskManager.updateTask(args[1], args[2]);
                System.out.println("Task updated successfully (ID: " + args[1] + ")");
                break;

            case "delete":
                if (args.length < 2) {
                    System.out.println("Usage: TaskCLI delete <id>");
                    return;
                }
                taskManager.deleteTask(args[1]);
                System.out.println("Task deleted successfully (ID: " + args[1] + ")");
                break;
            case "mark-in-progress":
                if (args.length < 2) {
                    System.out.println("Usage: TaskCLI mark-in-progress <ID>");
                    return;
                }
                taskManager.markInProgress(args[1]);
                System.out.println("Your Task is marked in Progress (ID: " + args[1] + ")");
                break;
            case "mark-done":
                if (args.length < 2) {
                    System.out.println("Usage: TaskCLI mark-done <ID>");
                    return;
                }
                taskManager.markDone(args[1]);
                System.out.println("Your Task is marked Done (ID: )" + args[1] + ")");
                break;
            case "list":
                if (args.length < 2) {
                    taskManager.listTasks("All");
                } else {
                    Status filterStatus;
                    try {
                        filterStatus = Status.valueOf(args[1].toUpperCase().replace("-", "_"));
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid status: " + args[1]);
                        return;
                    }
                    taskManager.listTasks(filterStatus.toString());
                }
                break;

            default:
                System.out.println("Unknown command: " + command);
                break;
        }
        taskManager.saveTasks();

    }
}
