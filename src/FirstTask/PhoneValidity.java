package FirstTask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PhoneValidity {
    public static void phoneValidity(List<String> phones){
        List <String> result = new ArrayList<>();
        for (String phone:phones) {
            if(phone.matches("[\\d\\(\\)\\-\\s]+")){ //first check, if it consists only of numbers and valid characters;
                if(checkFormatValidity(phone)){
                    result.add(phone);
                }
            }
        }
        System.out.println("result = " + result);

    }
    public static boolean checkFormatValidity(String phone){
        boolean result = false;
        boolean firstCheck = phone.charAt(3) == 45 && phone.charAt(7)==45
        && phone.substring(0,3).matches("\\d+") && phone.substring(4,7).matches("\\d+")
        &&phone.substring(8,11).matches("\\d+");

        boolean secondCheck = phone.charAt(0) == 40 && phone.charAt(4) == 41 && phone.charAt(5) == 32
        && phone.charAt(9) == 45 && phone.substring(1,4).matches("\\d+")
        && phone.substring(6,9).matches("\\d+")&&phone.substring(10,13).matches("\\d+");

        if( firstCheck || secondCheck ){
            result = true;
        }
        return result;
    }

}
