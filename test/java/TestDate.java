package tests;

import org.junit.Test;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by shefenfei on 2017/8/14.
 */
public class TestDate {

    @Test
    public void compare() {
//        1995-11-12 15:21", "1999-12-11 09:59

        String date1 = "1995-11-12 15:21";
        String date2 = "1999-12-11 09:59";

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        try {
            Date dt1 = df.parse(date1);
            Date dt2 = df.parse(date2);

            if (!date1.equals(date2) && dt1.before(dt2)) { //可以请假
                //不一样
                boolean isAfter = dt1.before(dt2);
                System.out.println(isAfter);
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void testUpload() {
        //1 ,类似于你要上传的文件
        ArrayList<File> images = new ArrayList();
        int count = images.size();

        int uploadCount = 0;

        for (int i = 0; i < count; i++) {
//            if (isOk) {
            uploadCount++;
            if (uploadCount == count) { //证明已经上传完成
//                    apiService.uploadToRemote(images) ;
            } else {
                //请求七牛 上传图片
            }
        }
    }


}
