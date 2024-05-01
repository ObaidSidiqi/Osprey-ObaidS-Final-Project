package tek.tdd.utilities;

import java.util.Random;

public class DataGen {
    public static String randomEmail(){
        String prefix = "TestObjOsprey";
        String emailProvider = "@tekSchool.us";
        Random random = new Random();
        int randomNumber = random.nextInt(5000000);

        return prefix + randomNumber + emailProvider;
    }
}
