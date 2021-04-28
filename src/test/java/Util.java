import org.junit.Assert;
import org.junit.Test;

public class Util {

    @Test
    public void removeDuplicates() {
        int nums[] = new int[]{1,2,2,3};
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }

        Assert.assertEquals(new int[]{1,2,3}, nums);
    }

}
