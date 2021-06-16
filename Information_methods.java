import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Information_methods {

    // This method will ask all the questions for the project.
    // Project information method:

    public static void project_info() {

        // Questions for the Project information:
        // Using try / catch block to assure the inputs are correct.

        List<String> proj_line = new ArrayList<String>(); // Adding all the information to the arraylist so i can add it to the text file easier.
        try {

            Scanner proj_info = new Scanner(System.in);
            System.out.println("\nPROJECT INFORMATION QUESTIONS:\n");

            System.out.println("Please enter the project number: ");
            int prj_number = proj_info.nextInt();
            String str_prj_num = String.valueOf(prj_number); // Converts the integer to a string so i can add it to my array list.
            proj_line.add(str_prj_num);

            // If the user enters none , the project name will be given with is the building type with client surname.
            System.out.println("Please enter the project name (if you don't have one in mind enter 'none'): ");
            String prj_name = proj_info.next();
            proj_line.add(prj_name);

            System.out.println("Please enter the building type:" +
                    "\nh - House" +
                    "\nap - Apartment block" +
                    "\ns - Store" +
                    "\n Please enter your option now: ");
            String prj_select = proj_info.next();
            String prj_tpe = "";
            if (prj_select.equals("h")) {
                prj_tpe = "House";
            } else if (prj_select.equals("ap")) {
                prj_tpe = "Apartment block";
            } else if (prj_select.equals("s")) {
                prj_tpe = "Store";
            }
            proj_line.add(prj_tpe);

            System.out.println("Please enter the project street number: ");
            int prj_strnum = proj_info.nextInt();
            String str_prj_strnum = String.valueOf(prj_strnum);
            proj_line.add(str_prj_strnum);

            System.out.println("Please enter the project street name: ");
            String prj_strname = proj_info.next();
            proj_line.add(prj_strname);

            // BigInteger allows for long numbers. (Learned on //www.baeldung.com › java-bigdecimal-biginteger)
            System.out.println("Please enter the ERF number: ");
            BigInteger prj_erf_num = proj_info.nextBigInteger();
            String str_prj_erf_num = String.valueOf(prj_erf_num);
            proj_line.add(str_prj_erf_num);

            System.out.println("Please enter the total fee of the project: R");
            BigInteger prj_total = proj_info.nextBigInteger();
            String str_prj_total = String.valueOf(prj_total);
            proj_line.add(str_prj_total);

            System.out.println("Please enter the amount that is paid to date: R");
            BigInteger prj_ptd = proj_info.nextBigInteger();
            String str_prj_ptd = String.valueOf(prj_ptd);
            proj_line.add(str_prj_ptd);

            System.out.println("Please enter the project deadline(Enter format must be yyyy-mm-dd): ");
            String prj_deadline = proj_info.next();
            proj_line.add(prj_deadline);

            String complete = "No";
            proj_line.add(complete);

            // Questions for the Client information:

            Scanner client_info = new Scanner(System.in);
            System.out.println("\nCLIENT INFORMATION QUESTIONS:\n");

            System.out.println("Please enter the name of the client: ");
            String clnt_name = client_info.next();
            proj_line.add(clnt_name);

            System.out.println("Please enter the surname of the client: ");
            String clnt_surname = client_info.next();
            proj_line.add(clnt_surname);


            // BigInteger allows for long numbers. (Learned on //www.baeldung.com › java-bigdecimal-biginteger)
            System.out.println("Please enter the client's telephone number: ");
            BigInteger clnt_num = client_info.nextBigInteger();
            String str_clnt_num = String.valueOf(clnt_num);
            proj_line.add("0"+str_clnt_num);

            System.out.println("Please enter the email address of the client: ");
            String clnt_edress = client_info.next();
            proj_line.add(clnt_edress);

            System.out.println("Please enter the client street number: ");
            int clnt_str_num = client_info.nextInt();
            String str_clnt_strt_num = String.valueOf(clnt_str_num);
            proj_line.add(str_clnt_strt_num);

            System.out.println("Please enter the client street name: ");
            String clnt_str_name = client_info.next();
            proj_line.add(clnt_str_name);

            // Questions for the Architect information:

            Scanner arch_info = new Scanner(System.in);
            System.out.println("\nARCHITECT INFORMATION QUESTIONS:\n");

            System.out.println("Please enter the name of the architect: ");
            String arch_name = arch_info.next();
            proj_line.add(arch_name);

            // BigInteger allows for long numbers. (Learned on //www.baeldung.com › java-bigdecimal-biginteger)
            System.out.println("Please enter the architect telephone number: ");
            BigInteger arch_num = arch_info.nextBigInteger();
            String str_arch_num = String.valueOf(arch_num);
            proj_line.add("0"+str_arch_num);

            System.out.println("Please enter the email address of the architect: ");
            String arch_edress = arch_info.next();
            proj_line.add(arch_edress);

            System.out.println("Please enter the architect street number: ");
            int arch_str_num = arch_info.nextInt();
            String str_arch_str_num = String.valueOf(arch_str_num);
            proj_line.add(str_arch_str_num);

            System.out.println("Please enter the architect street name: ");
            String arch_str_name = arch_info.next();
            proj_line.add(arch_str_name);

            // Questions for the Contractor information:

            Scanner cont_info = new Scanner(System.in);
            System.out.println("\nCONTRACTOR INFORMATION QUESTIONS:\n");

            System.out.println("Please enter the name of the contractor: ");
            String cont_name = cont_info.next();
            proj_line.add(cont_name);

            // BigInteger allows for long numbers. (Learned on //www.baeldung.com › java-bigdecimal-biginteger)
            System.out.println("Please enter the contractor telephone number: ");
            BigInteger cont_num = cont_info.nextBigInteger();
            String str_cont_num = String.valueOf(cont_num);
            proj_line.add("0"+str_cont_num);

            System.out.println("Please enter the email address of the contractor: ");
            String cont_edress = cont_info.next();
            proj_line.add(cont_edress);

            System.out.println("Please enter the contractor street number: ");
            int cont_str_num = cont_info.nextInt();
            String str_cont_str_num = String.valueOf(cont_str_num);
            proj_line.add(str_cont_str_num);

            System.out.println("Please enter the contractor street name: ");
            String cont_str_name = cont_info.next();
            proj_line.add(cont_str_name);




            try {
                // Writing the new project to the text file.
                PrintWriter info_for_file = new PrintWriter(new FileWriter("src//Projects.txt",true));

                // This will initiate if the user cant think of a project name to enter and will make the project name the building type plus the client surname.
                if (prj_name.equals("none")) {
                   String line = proj_line.toString();
                   line = line.replace("[","");
                   line = line.replace("]","");
                   line = line.replace("none",prj_tpe+" "+clnt_surname);
                   // Converting the list to an array list so it can replace the proj_line array list with the correct information.
                   // Learned on (https://www.geeksforgeeks.org/arrays-aslist-method-in-java-with-examples/)
                   proj_line = Arrays.asList(line.split(", "));
                }
                info_for_file.println(proj_line);

                // Closing the text file.
                info_for_file.close();
                System.out.println("\nProject added successfully!\n");

                // Catch for if the file doesn't exist.
            }catch (FileNotFoundException r){
                System.out.println("Text file not created or found!");
            }catch (IOException e) {
                e.printStackTrace();
            }


            // Adding the information from the questions to the correct class:

            Project_Class created_proj = new Project_Class(prj_number, prj_name, prj_tpe, prj_strnum, prj_strname, prj_erf_num,
                    prj_total, prj_ptd, prj_deadline);

            Client_Class created_client = new Client_Class(clnt_name, clnt_surname, clnt_num, clnt_edress, clnt_str_num, clnt_str_name);

            Architect_Class created_architect = new Architect_Class(arch_name, arch_num, arch_edress, arch_str_num, arch_str_name);

            Contractor_Class created_contractor = new Contractor_Class(cont_name, cont_num, cont_edress, cont_str_num, cont_str_name);

            // Printing out all the information on the terminal:

            System.out.println("\nPROJECT INFORMATION\n");
            System.out.println(created_proj.toString());

            System.out.println("\nCLIENT INFORMATION\n");
            System.out.println(created_client.toString());

            System.out.println("\nARCHITECT INFORMATION\n");
            System.out.println(created_architect.toString());

            System.out.println("\nCONTRACTOR INFORMATION\n");
            System.out.println(created_contractor.toString());
        }catch (InputMismatchException e){
            System.out.println("\nPlease make sure you entered the information correctly in all fields!\n");
        }
    }
}
