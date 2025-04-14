import java.util.*; 
import java.io.*;

public class PolicyDemo2_parsing
{   
   public static void main(String[] args)
   {  
      try {
         //Calling the PolicyInfo file
         File file = new File("PolicyInformation.txt");
         
         //Converting the file to scanner
         Scanner inputFile = new Scanner(file);
         
         //declare variables
         String policyNumber;
         String providerName;
         String firstName;
         String lastName;
         int age;
         String smokingStatus;
         double height;
         double weight;
         
         int smokerTotal = 0;
         int nonSmokerTotal = 0;
         
         //created to store objects
         ArrayList<Policy> policies = new ArrayList<Policy>();
      
         while (inputFile.hasNext()) {
            
             policyNumber = inputFile.nextLine();  
             providerName = inputFile.nextLine();
             firstName = inputFile.nextLine();
             lastName = inputFile.nextLine();
             age = Integer.parseInt(inputFile.nextLine());
             smokingStatus = inputFile.nextLine();
             height = Double.parseDouble(inputFile.nextLine());
             weight = Double.parseDouble(inputFile.nextLine());
            
             if (inputFile.hasNext()) { 
                inputFile.nextLine();
             }
               
             //Creating each policy object
             Policy p = new Policy(policyNumber, providerName, firstName, lastName, age, smokingStatus, height, weight); 
                        
             policies.add(p); 
            
         }//while loop
            
         //close the file
         inputFile.close();
         
         //display information for each policy
         for (int i =0; i < policies.size(); i++) {
            
            if (policies.get(i).getSmokingStatus().equalsIgnoreCase("smoker")) {
               smokerTotal++;
            } else {
               nonSmokerTotal++;
            }
            
            System.out.println("Policy Number: " + policies.get(i).getPolicyNumber());
            System.out.println("Provider Name: " + policies.get(i).getProviderName());
            System.out.println("Policyholder's First Name: " + policies.get(i).getFirstName());
            System.out.println("Policyholder's Last Name: " + policies.get(i).getLastName());
            System.out.println("Policyholder's Age: " + policies.get(i).getAge());
            System.out.println("Policyholder's Smoking Status: " + policies.get(i).getSmokingStatus());
            System.out.println("Policyholder's Height: " + policies.get(i).getHeight() + " inches");
            System.out.println("Policyholder's Weight: " + policies.get(i).getWeight() + " pounds");
            System.out.printf("Policyholder's BMI: %.2f\n", policies.get(i).getBMI());
            System.out.printf("Policy Price: $%.2f\n", policies.get(i).getPrice());
            System.out.println();
         }//for loop
         
         //Displaying total number of policy smokers
         System.out.printf("%nThe number of policies with a smoker is: %d", smokerTotal);
         System.out.printf("%nThe number of policies with a non-smoker is: %d", nonSmokerTotal);
         
      }//try
      
      //Attempting to catch any errors with reading the file
      catch (IOException ex) {
         System.out.println("Something went wrong reading the file: " + ex.getMessage());
      }//catch 
   }//class
}//main