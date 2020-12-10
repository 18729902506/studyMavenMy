package com.ziptest;

import java.io.File;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/***
 * @author S
 * @date 2019/09/22
 */
public class TestMain1 {
    public static void main(String[] args) {
        String fileName = "D:\\test1.zip";
        new TestMain1().readZipEntry(fileName);
    }

    public void readZipEntry(String fileName){
        try {
            ZipFile zip = new ZipFile(new File(fileName));
            Enumeration enumeration = zip.entries();
            while (enumeration.hasMoreElements()){
                ZipEntry zipEntry = (ZipEntry) enumeration.nextElement();
                /***
                 * UnlimitedJCEPolicyJDK8/-----
                 * UnlimitedJCEPolicyJDK8/local_policy.jar-----
                 * UnlimitedJCEPolicyJDK8/README.txt-----
                 * UnlimitedJCEPolicyJDK8/US_export_policy.jar-----
                 */
                System.out.println(zipEntry.getName()+"-----");
            }
            System.out.println("也可以通过文件名来得到zipEntry对象");
            ZipEntry zipEntry = zip.getEntry("UnlimitedJCEPolicyJDK8/README.txt");
            if (zipEntry != null){
                //已发现该文件：UnlimitedJCEPolicyJDK8/README.txt
                System.out.println("已发现该文件："+zipEntry.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
