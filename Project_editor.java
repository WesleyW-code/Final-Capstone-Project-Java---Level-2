import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.lang.*;

public class Project_editor {

    public static void Editing_project() {

        // Asking user which of the tasks they would like to edit by requesting a project number:
        List<String> project_numbers = new ArrayList<String>();
        try {
            // Reading through the text file and getting all the project numbers:
            Scanner read_file = new Scanner(new File("src//Projects.txt"));

            while (read_file.hasNext()){

                String line = read_file.nextLine();

                String line_info[] = line.split(", ");

                project_numbers.add(line_info[0]);
            }

            // Getting just the project numbers so the user can enter one:
            String proj_nums = project_numbers.toString().replace("[","");
            proj_nums = proj_nums.replace("]","");
            proj_nums = proj_nums.replace(", ","\n");

            // Asking user to enter the specific project number so they can edit that project:
            Scanner input = new Scanner(System.in);
            System.out.println("Please enter one of the following project numbers to edit that project: \n" +
                    proj_nums +
                    "\nPlease enter the number now: ");
            String user_input = input.next();

            Scanner read_proj_file = new Scanner(new File("src//Projects.txt"));

            // The following code will take the user input and display a menu that asks what specific element of the project they want to change.
            // It will take the edited task and put it back in its original place in the text file.

            // Using the following list to index each project element in the source file:
            // Also using this to construct my editing menu.
            String project_indexes[]= new String[]{"n", "pn", "t", "ps", "psn", "en", "tf", "ap", "d", "c", "ctn", "cts", "ctt",
                    "cte", "cts", "ctsn", "an", "at", "ae", "as", "asn", "cn", "ct", "ce", "cs", "csn"};

            // Using the following list to create my menu for editing and making the code more efficient.
            String index_names[]= new String[]{"Project number", "Project name", "Building type", "Project street number",
                    "Project street name", "ERF number", "Total fee", "Amount paid", "Deadline", "Complete", "Client name",
                    "Client surname", "Client telephone number", "Client email address", "Client street number", "Client street name",
                    "Architect name", "Architect telephone number", "Architect email address",
                    "Architect street number", "Architect street name", "Contractor name", "Contractor telephone number",
                    "Contractor email address", "Contractor street number", "Contractor street name"};

            // Doing this to construct my selection menu to be efficient(this menu will allow the user to edit any element of the selected project).
            String menu = "";
            for (int i = 0; i < project_indexes.length; i++) {

                // The symbol "&&" is an and statement (Learned this on: Stackoverflow.com)
                if (i != 0&&i != 9) {
                    menu += project_indexes[i]+" - "+index_names[i]+"\n";
                }
            }

            // This is gonna be used to hold the updated text file so we can overwrite it with ease.
            String completed_file = "";
            String updated_file = "";

            while (read_proj_file.hasNext()) {

                String line = read_proj_file.nextLine();
                line = line.replace("[", "");
                line = line.replace("]", "");

                String line_info[] = line.split(", ");

                // User will edit the project here:
                if (user_input.equals(line_info[0].replace("[", ""))) {

                    // Asking user if they want to edit or complete the project:
                    Scanner option_edit = new Scanner(System.in);
                    System.out.println("Would you like to edit or finalise the project: " +
                            "\ne - Edit" +
                            "\nf - Finalise" +
                            "\nPlease enter your selection now: ");
                    String option_answer = option_edit.next();

                    // This is statement checks if the project is complete and if so gives and error to stop the user from editing a completed project.
                    if (line_info[9].equals("Finalised")) {
                        System.out.println("This project is finalised and can not be edited!\n");
                        updated_file += Arrays.toString(line_info)+"\n";
                    }

                    // This is the 'e' option that will allow for the selected project to be edited.
                    if (option_answer.equals("e")&&line_info[9].equals("No")) {

                        Scanner input_edit = new Scanner(System.in);

                        // The menu will prompt here with all the elements that can be changed.
                        // Project number is not shown as the user should not be able to change it (because it is basically my identifier for each project)
                        // Complete is also not shown to change because you can simply complete a project by selecting 'c' above.
                        System.out.println("What would you like to edit: \n" + menu + "\nPlease enter your selection now: ");

                        // Index for the project element that is being edited.
                        int edit_index = 0;
                        // What the user wants to edit.
                        String user_edit = input_edit.next();

                        // This for loop gets the location for the element that is going to be edited
                        for (int i = 0; i < project_indexes.length; i++) {

                            if (project_indexes[i].equals(user_edit)) {
                                edit_index = i;
                            }
                        }

                        // This will show what the current value of the element is and ask the user to change it.
                        Scanner editing_val = new Scanner(System.in);
                        System.out.println("The current " + index_names[edit_index] +
                                " is " + line_info[edit_index] + ".\nWhat would you like to change it to: ");

                        // This will only initiate if Building type is selected to change:
                        if (user_edit.equals("t")) {
                            System.out.println("\nPlease enter the building type:" +
                                    "\nh - House" +
                                    "\nap - Apartment block" +
                                    "\ns - Store" +
                                    "\nPlease enter your option now: ");
                        }
                        String edited_value = editing_val.next();
                        if (user_edit.equals("t")) {
                            if (edited_value.equals("h")) {
                                edited_value = "House";
                            } else if (edited_value.equals("ap")) {
                                edited_value = "Apartment block";
                            } else if (edited_value.equals("s")) {
                                edited_value = "Store";
                            }
                        }

                        // Replace the current value in the project with the edited value.
                        // Make the list (line_info) into a string with the correct formatting.
                        // Adding the string to the updated text file line.
                        line_info[edit_index] = edited_value;
                        updated_file += Arrays.toString(line_info) + "\n";
                        System.out.println("\nProject successfully changed!\n");
                    }

                    // This is the 'c' option that will complete the selected project.
                    else if (option_answer.equals("f")&&line_info[9].equals("No")){
                        line_info[9] = "Finalised";
                        updated_file += Arrays.toString(line_info) + "\n";

                        // This will be used to add the finalised project to the completed projects txt.
                        String line_for_complete [] = line_info;

                        // Adding today's date when the user finalises the project and then adding it to the text file.
                        line_for_complete[9] = line_for_complete[9] +" on "+ LocalDate.now();
                        completed_file += Arrays.toString(line_for_complete) + "\n";

                        System.out.println("\nProject successfully finalised!\n");

                        // Getting the amounts to check if there are payments outstanding.
                        String total = line_info[6];
                        String payed = line_info[7];
                        Integer total_int = Integer.parseInt(total);
                        Integer payed_int = Integer.parseInt(payed);
                        float outstanding = total_int - payed_int;

                        // The following will generate a invoice on the terminal if the client has an outstanding payment.
                        if (outstanding > 0) {
                            System.out.println("Customer Invoice: " +
                                    "\n\t Project number: "+ line_info[0].toString().replace("[","") +
                                    "\n\t Client name: "+ line_info[10].toString() +
                                    "\n\t Client contact number: 0"+ line_info[12].toString() +
                                    "\n\t Amount outstanding: R"+ outstanding +"\n");
                        }

                    }
                }
                // This else statement puts all projects that are not being edited as is back into the text file, in the correct order.
                else {
                    updated_file += "[" + line + "]\n";
                }

            }

            // The project that is being edited will be in the original place at this point as well.
            // Overwrite the original text file with the updated version.
            // Learned about writer on (https://www.javatpoint.com/java-writer-class#)
            Writer overwrite_file = new FileWriter("src//Projects.txt",false);
            overwrite_file.write(updated_file);

            // Writing to my completed projects text file and adding today's date as the completion date as requested:
            Writer completed_projects = new FileWriter("src//Completed projects.txt",true);
            completed_projects.write(completed_file);

            // Closing all the times i opened the text files:
            completed_projects.close();
            overwrite_file.close();
            read_file.close();
            read_proj_file.close();

        // Catch blocks will initiate if the text file is not found.
        } catch (FileNotFoundException x) {
            System.out.println("File not found!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
