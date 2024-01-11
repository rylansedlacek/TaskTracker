/**
 * Task.java (helper class)
 * "Task Tracker"
 * @author Rylan Sedlacek
 * @version 1.5
 */

// I pledge that I wrote this code without using additional resources.

public class Task {

    private String title; // task title
    private String desc; // task description
    private Integer num; // task number


    /**
     * Initializes all fields for task tracker
     * @param num - task number
     * @param title - task title
     * @param desc - task description
     */
    public Task (int num, String title, String desc) { //constructor method
        this.num = num; // task number
        this.title = title; // task title
        this.desc = desc; // task description
    }

    /**
     * new description setter
     * @param newDesc - sets new description
     */
    public void setDesc (String newDesc) { // setter for new description
        this.desc = newDesc;
    }

    /**
     * new title setter
     * @param newTitle - sets new title
     */
    public void setTitle (String newTitle) { // setter for new title
        this.title = newTitle;
    }

    /**
     * task number getter
     * returns number
     */
    public Integer getNum () { //getter for getting task number
        return num;
    }

    /**
     * task title getter
     * returns title
     */
    public String getTitle () { //getter for getting task title
        return title;
    }

    /**
     * task description getter
     * returns description
     */
    public String getDesc () { //getter for getting task description
        return desc;
    }
}