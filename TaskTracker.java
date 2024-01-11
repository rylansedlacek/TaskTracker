/**
 * TaskTracker.java
 * "Task Tracker"
 * @author Rylan Sedlacek
 * @version 1.5
 */

// I pledge that I wrote this code without using additional resources.

import java.util.*;
public class TaskTracker { // begin TaskTracker
    Scanner stdin = new Scanner(System.in); // scanner;
    private ArrayList<Task> taskList; // taskList array
    public TaskTracker () {
        taskList = new ArrayList<>();  //TaskTracker array
        stdin = new Scanner(System.in); // TaskTracker scanner
    }

    public void addTask () { // add task
        System.out.println(" ");
        System.out.println("enter task number:"); //prompt for task number
        int num = stdin.nextInt(); // input number
        stdin.nextLine();  // in case user hits space

        if (repeatNum(num)) { // check for repeat numbers
            System.out.print("task number already exists!"); //if repeat output...
            System.out.println(" ");
            return; //end method
        }

        System.out.println("enter task name:"); // if a new task number
        String title = stdin.nextLine(); // enter title
        System.out.println("enter task description:"); // prompt user
        String desc = stdin.nextLine(); // enter description
        taskList.add(new Task(num, title, desc)); // add the number, title, and description to the list
        System.out.println("task created!"); // assure user task has been made
    } // end add task

    public boolean repeatNum(int num) { // repeat number check
        for (int i = 0; i < taskList.size(); i++) { //for loop
            Task task = taskList.get(i); // get the list
            if (task.getNum() == num) { // check if the number is already found
                return true; // if so return true
            }
        } // end for loop
        return false; // else return false
    } // end repeat number

    public void displayTasks () { // display tasks
        System.out.println(" ");
        System.out.println("current tasks:"); //output
        for (int i = 0; i < taskList.size(); i++) { // for loop
            Task task = taskList.get(i); // get the taskList
            System.out.println("--------------------------"); //output
            System.out.printf("task:%2d | title: %-5s   %n", task.getNum(), task.getTitle()); // output number and title
            System.out.println("--------------------------"); //output
            System.out.printf("description: %-10s %n%n", task.getDesc()); //out the description
        } // end for loop
    } // end display tasks

    public void delete () { // delete a task
        System.out.println(" ");
        System.out.println("number of task to remove? "); //prompt
        int removal = stdin.nextInt(); // enter number
        stdin.nextLine(); // in case user hits space

        for (int i = 0; i < taskList.size(); i++) { //for loop
            Task task = taskList.get(i); // get the taskList
            if (task.getNum() == removal) { // if the number exists delete it
                taskList.remove(i); // remove it
                System.out.println("removed task " + removal); // tell user its removed
                break; // end loop
            }
        } // end for loop
    } // end delete a task

    public void setDesc () { // set a new description
        System.out.println(" ");
        System.out.println("number of task to edit? "); //prompt
        int removal = stdin.nextInt(); // enter number of task
        stdin.nextLine(); // in case user hits space

        for (int i = 0; i < taskList.size(); i++ ) { // for loop
            Task task = taskList.get(i); // get the task
            if (task.getNum() == removal) { // if the number exists change its description
                System.out.println("enter new description: "); //prompt
                String newDesc = stdin.nextLine(); // input
                task.setDesc(newDesc); // setter call
                System.out.println("updated"); // alert user of update
            } // end if
        } // end for loop
    } // end new description

    public void setTitle () { // set a new title
        System.out.println(" ");
        System.out.println("number of task to edit? "); //prompt
        int editor = stdin.nextInt(); // enter number of task
        stdin.nextLine(); // in case user hits space

        for (int i = 0; i < taskList.size(); i++) { // for loop
            Task task = taskList.get(i); // get the task
            if (task.getNum() == editor) { // if the number exists change its title
                System.out.println("enter a new title"); // prompt
                String newDesc = stdin.nextLine(); // input
                task.setTitle(newDesc); // setter call
                System.out.println("updated");  // alert user of update
            }
        } // end for loop
    } // end set a new title

    public void taskMenu () { // main menu
        System.out.println("welcome to the task tracker!"); // welcome
        int choice = 0; // choice to 0
        while (choice != -4) { // while the choice isn't 4 (exit)
            System.out.println(" ");
            System.out.println("options: ");
            System.out.println("press 1 - add a new task"); //option 1
            System.out.println("press 2 - view current tasks"); //option 2
            System.out.println("press 3 - additional options"); //option 3
            System.out.println("press 4 - exit application"); // option 4
            System.out.print("enter number: "); //prompt

            try { // begin try
                choice = stdin.nextInt(); // allow input, update choice
                stdin.nextLine(); // in case user hits space

                if (choice == 1) {  // if choice one
                    addTask();  // call addTask
                } else if (choice == 2) { // if choice two
                    displayTasks(); // call displayTasks
                } else if (choice == 3) { // if choice three
                    subOptions(); // call subOptions
                } else if (choice == 4) { // if choice four
                    System.out.println(" ");
                    System.out.println("goodbye"); // say goodbye
                    break; // end the while loop
                } else { // else
                    System.out.println("unknown choice"); //unknown choice here
                }

            } catch (InputMismatchException e) { // InputMismatch catch block
                System.out.println(" ");
                stdin.nextLine(); // allow for new input
                choice = -1; // cancel out choice
            } // end catch
        } // end while
    } // end main menu

    public void subOptions () { // subOptions
        int subChoice; // variable for sub choice
        System.out.println(" ");
        System.out.println("additional options: ");
        System.out.println("press 1 - delete a task"); // delete task
        System.out.println("press 2 - edit a task title"); // edit title
        System.out.println("press 3 - edit a task description"); // edit description
        System.out.println("press 4 - back to main menu"); // go back to menu
        System.out.print("enter number: "); //prompt

        subChoice = stdin.nextInt(); // allow for input to update subChoice
        stdin.nextLine(); // in case user hits space
        if (subChoice == 1) { // choice one
            delete(); // call delete
        } else if (subChoice == 2) { // choice two
            setTitle(); // call setTitle
        } else if (subChoice == 3) { // choice three
            setDesc(); // call setDesc
        } else if (subChoice == 4) { // choice four
            System.out.print("sending you to menu!"); // send back to menu
            System.out.println(" "); // do nothing
        } else {
            System.out.print("unknown choice"); // else unknown choice
        }
    } // end subOptions

    public static void main(String[] args) { // main class here
        TaskTracker taskTracker = new TaskTracker(); // new TaskTracker
        taskTracker.taskMenu(); // call main menu method
    }  // end main
} // end task tracker