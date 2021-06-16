import java.io.*;
// To check how many days a project is overdue. Learned on (https://stackoverflow.com/questions/27005861/)
import java.time.temporal.ChronoUnit;
import java.util.*;
// To convert my dates into the correct format to compare them.
import java.time.*;

public class C_or_D_Methods {

    // This method will allow the user to see what projects still need to be completed.
    public static void incomplete_projects() {

        // This string will hold all my incomplete projects.
        String incomplete_projects = "";
        try {
            Scanner read_file = new Scanner(new File("src//Projects.txt"));

            while (read_file.hasNext()) {

                // For every line remove the square brackets to not make double brackets later.
                String line = read_file.nextLine();
                line = line.replace("[", "");
                line = line.replace("]", "");

                // Split the project into a list.
                String line_info[] = line.split(", ");

                // If the project is not completed it will be added to the incomplete project string above.
                // It will display the project number, project name and show that it is incomplete neatly.
                if (line_info[9].equals("No")) {

                    // Info that is going to be printed out / Converting it to strings.
                    String project_num = line_info[0].toString().replace("[", "");
                    String project_name = line_info[1].toString();
                    String complete = line_info[9].toString();

                    // How the info will be added to the incomplete projects string.
                    incomplete_projects += "\nProject number: " + project_num + "\n\tProject name: " + project_name + "\n\tCompleted: "
                             + complete + "\n";
                }
            }
            // Printing all the information so it can be displayed to the user.
            System.out.println(incomplete_projects);

            // Closing the text file.
            read_file.close();

        // Catch block in case there is an error with the text file.
        }catch (FileNotFoundException e){
            System.out.println("Text file error!");
        }
    }

    public static void Overdue() {

        // Learned how to compare dates on https://www.tutorialspoint.com/how-to-compare-two-dates-in-java#.
        // Learned how to get the current date on https://www.javatpoint.com/java-get-current-date.

        String overdue_projects = "";
        try {
            Scanner read_file = new Scanner(new File("src//Projects.txt"));

            while (read_file.hasNext()){

                // For every line remove the square brackets to not make double brackets later.
                String line = read_file.nextLine();
                line = line.replace("[", "");
                line = line.replace("]", "");

                // Split the project into a list.
                String line_info[] = line.split(", ");

                if (line_info[9].equals("No")) {

                    // Converting the due date to compare it to the current date.
                    LocalDate due_date = LocalDate.parse(line_info[8]);
                    LocalDate today_date = LocalDate.now();

                    // To check how many days a project is overdue. Learned on (https://stackoverflow.com/questions/27005861/)
                    long days_overdue = ChronoUnit.DAYS.between(due_date,today_date);

                    // If the days overdue variable is positive then the project is overdue and will be printed.
                    if (days_overdue > 0) {

                        // Info that is going to be printed out / Converting it to strings.
                        String project_num = line_info[0].toString().replace("[", "");
                        String project_name = line_info[1].toString();
                        String complete = line_info[9].toString();


                        // How the info will be added to the overdue_projects string.
                        overdue_projects += "\nProject number: " + project_num + "\n\tProject name: " + project_name + "\n\tCompleted: "
                                + complete + "\n\t" + "Days overdue: "+ days_overdue + "\n";
                    }
                }
            }
            // Printing the overdue projects to the terminal with the amount of days overdue.
            System.out.println(overdue_projects);

        } catch (FileNotFoundException e) {
            System.out.println("Text file error!");;
        }
    }
}
