package filters;

public class Validator {
    public boolean isEmpty(String text) {
        return text.isEmpty();
    }

    public boolean isDigit(String text) {

        try {

            Integer.parseInt(text);
            return true;


        } catch (Exception e) {

            return false;
        }
    }

    public boolean equalsNull(String text) {
        try {

            int num = Integer.parseInt(text);

            if (num == 0) {
                return true;
            } else {
                return false;
            }


        } catch (Exception e) {

            return false;
        }
    }


}
