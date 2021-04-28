import org.junit.Assert;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class StringDemoTest {

    public void summary(){

        //

    }

    @Test
    public void dateTime() {

        LocalDate date = LocalDate.now();
        date = LocalDate.parse("2018-05-28");

        Assert.assertEquals("2018-05-28", date.toString());
        DateTimeFormatter dateTimeFormatter =
                DateTimeFormatter.ofPattern("yyyy-MM-dd");
        dateTimeFormatter.parse("2018-05-20");

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        // String date date = formatter.parse()

        Calendar calendar = Calendar.getInstance();
        calendar.set(2018, 10, 25);
        calendar.getFirstDayOfWeek();
        StringBuilder sb = new StringBuilder();
        sb.append(1);
        sb.reverse();
    }

    @Test
    public void intToSting() {

        int i = 1;
        String str = String.valueOf(i);
        str = Integer.toString(i);

        Assert.assertEquals("1", str);
    }

    @Test
    public void charToSting() {

        char c = 'c';
        String str = String.valueOf(c);
        str = Character.toString(c);

        Assert.assertEquals("c", str);
    }

    @Test
    public void stringToCharArray() {

        String str = "ABC";
        char[] actualChars = str.toCharArray();

        char[] expectedChars = new char[]{'A', 'B', 'C'};

        Assert.assertArrayEquals(expectedChars, actualChars);

    }

    @Test
    public void charListToString() {
        List<Character> chars = new ArrayList<>(List.of('A', 'b'));
        String actualResult = chars.stream().map(x -> x.toString()).collect(Collectors.joining(""));
        Assert.assertEquals("Ab", actualResult);
    }

    //String to List of Chars
    @Test
    public void strToListOfCharsUsingStream() {
        String str = "ab";
        List<Character> expected = new ArrayList<>(List.of('a', 'b'));
        List<Character> actual = str
                .chars()
                .mapToObj(x -> (char) x)
                .collect(Collectors.toList());
        Assert.assertEquals(expected, actual);
    }

    //String to List of Chars
    @Test
    public void strToListOfChars() {
        String str = "ab";
        List<Character> expected = new ArrayList<>(List.of('a', 'b'));
        List<Character> actual = new ArrayList<>();


        for (int i = 0; i < str.length(); i++) {
            actual.add(str.charAt(i));
        }
        Assert.assertEquals(expected, actual);

        //or
        actual = new ArrayList<>();
        for (char ch : str.toCharArray()) {
            actual.add(ch);
        }

        Assert.assertEquals(expected, actual);
    } //String to List of Chars

    @Test
    public void strToListOfCharsAbstractList() {
        String str = "ab";
        List<Character> expected = new ArrayList<>(List.of('a', 'b'));

        List<Character> actual = new AbstractList<>() {
            @Override
            public Character get(int index) {
                return str.charAt(index);
            }

            @Override
            public int size() {
                return str.length();
            }
        };

        Assert.assertEquals(expected, actual);
    }

    /**
     * Reversing a String
     */
    @Test
    public void reverseString() {
        String str = "abc";
        String expectedStr = "cba";

        //using StringBuilder
        StringBuffer sb = new StringBuffer(str); // or StringBuilder
        sb.reverse();
        String actualStr = sb.toString();
        Assert.assertEquals(expectedStr, actualStr);

        //using  char array
        char[] characters = str.toCharArray();
        int start = 0;
        int finish = characters.length - 1;
        char temp;

        while (finish > start) {
            temp = characters[start];
            characters[start] = characters[finish];
            characters[finish] = temp;
            finish--;
            start++;
        }
        String actualStr2 = new String(characters);
        Assert.assertEquals(expectedStr, actualStr2);

        //using char stacking
        String actualStr3 = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            actualStr3 = actualStr3 + str.charAt(i);
        }

        Assert.assertEquals(expectedStr, actualStr3);

    }

    /**
     * Checking if String Contains Only Digits
     */
    @Test
    public void checkIfStringContainsOnlyDigits() {

        String str = "12233333";
        String str2 = "afdsfsf122";

        Assert.assertTrue(str.matches("[0-9]+"));
        Assert.assertFalse(str2.matches("[0-9]+"));

    }

    @Test
    public void convertToInteger() {

        String str = "1234";
        int strNumber = Integer.parseInt(str);
        int strNumber2 = Integer.valueOf(str);
        int strNumber3 = Integer.decode(str);

        Assert.assertEquals(1234, strNumber);
        Assert.assertEquals(1234, strNumber2);
        Assert.assertEquals(1234, strNumber3);

    }


    /**
     * Removing Duplicate Characters in a String
     */
    @Test
    public void removeDuplicateCharsFromString() {
        String str = "shahdat hosain";
        String expectedResult = "shadt oin";
        //String to List of Chars
       // List<Character> characters = new ArrayList<Character>( List.of(str.toCharArray()));

        List<Character>  characters =new AbstractList<Character>() {
            @Override
            public Character get(int index) {
                return str.charAt(index);
            }

            @Override
            public int size() {
                return str.length();
            }
        } ;

        //Stream
        String actualResult = characters
                .stream()
                .distinct()
                .map(x -> x.toString())
                .collect(Collectors.joining(""));

        Assert.assertEquals(expectedResult, actualResult);

        //standard
        actualResult = "";
        for (char ch : str.toCharArray()) {
            if (!actualResult.contains(String.valueOf(ch))) {
                actualResult = actualResult.concat(String.valueOf(ch));
            }
        }

        Assert.assertEquals(expectedResult, actualResult);

    }

    /**
     * Finding the Maximum Occurring Character in a String
     */
    @Test
    public void findMaxOccurrence() {
        String input = "shahdat hosain";
        int charCount = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        char[] inputChar = input.toCharArray();

        for (int i = 0; i < inputChar.length; i++) {
            char c = inputChar[i];

            if (map.containsKey(c)) {
                int count = map.get(c);
                count++;

                if (charCount < count) {
                    charCount++;
                }

                map.put(c, count);
            } else {
                map.put(c, 1);
            }
        }

        Set set = map.keySet();
        Iterator<Character> iterator = set.iterator();
        while (iterator.hasNext()) {
            char key = iterator.next();

            if (map.get(key) == charCount) {
                System.out.println("Character '" + key + "' has the max occurrence: " + charCount + " times!");
            }
        }
    }


}
