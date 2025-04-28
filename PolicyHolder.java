public class PolicyHolder
{  
   private String lastName;
   private int age;
   private String smokingStatus;
   private double height;
   private double weight;
   
   public Policy()
   {
      policyNumber = "";
      providerName = "";
      firstName = "";
      lastName = "";
      age = 0;
      smokingStatus = "";
      height = 0;
      weight = 0;
   }
   
   public Policy(String pNumber, String pName, String fName, String lName,int a, String sStatus, double h, double w)
   {
      policyNumber = pNumber;
      providerName = pName;
      firstName = fName;
      lastName = lName;
      age = a;
      smokingStatus = sStatus;
      height = h;
      weight = w;
   }

   public void setPolicyNumber(String pNumber)
   {
      policyNumber = pNumber;
   }
   
   public void setProviderName(String pName)
   {
      providerName = pName;
   }
   
   public void setFirstName(String fName)
   {
      firstName = fName;
   }
   
   public void setLastName(String lName)
   {
      lastName = lName;
   }
   
   public void setAge(int a)
   {
      age = a;
   }
   
   public void setSmokingStatus(String sStatus)
   {
      smokingStatus = sStatus;
   }
   
   public void setHeight(double h)
   {
      height = h;
   }
   
   public void setWeight(double w)
   {
      weight = w;
   }
   
   public String getPolicyNumber()
   {
      return policyNumber;
   }
   
   public String getProviderName()
   {
      return providerName;
   }
   
   public String getFirstName()
   {
      return firstName;
   }
   
   public String getLastName()
   {
      return lastName;
   }
   
   public int getAge()
   {
      return age;
   }
   
   public String getSmokingStatus()
   {
      return smokingStatus;
   }
   
   public double getHeight()
   {
      return height;
   }
   
   public double getWeight()
   {
      return weight;
   }
   
   public double getBMI()
   {
      final double CONVFACTOR = 703;
      
      return (weight * CONVFACTOR) / (height * height);
   }
   
   public double getPrice()
   {
      final double BASE_PRICE = 600;
      final double ADDITIONAL_FEE_AGE = 75;
      final double ADDITIONAL_FEE_SMOKING = 100;
      final double ADDITIONAL_FEE_PER_BMI = 20;
      
      final int AGE_THRESHOLD = 50;
      final int BMI_THRESHOLD = 35;
      
      double price = BASE_PRICE;
      
      if(age > AGE_THRESHOLD)
         price += ADDITIONAL_FEE_AGE;
         
      if(smokingStatus.equalsIgnoreCase("smoker")) 
         price += ADDITIONAL_FEE_SMOKING;
            
      if(getBMI() > BMI_THRESHOLD)
         price += ((getBMI() - BMI_THRESHOLD) * ADDITIONAL_FEE_PER_BMI); 
         
      return price;
   }
   public String toString()
   {
      return String.format("Policy Holder: " + getResidenceAddress() +
                           "\nOwner: " + getOwnerName() +
                           "\nNumber of Solar Panels: %d", getNumSolarPanels());
   }
}