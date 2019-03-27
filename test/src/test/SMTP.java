
package test;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;


public class SMTP {

    static PrintStream log_path;

    public static void main(String ss[]) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date currDate = new Date();
        String dateS = currDate.toString().replaceAll(":", "-");
        dateS = dateS.replaceAll(":", "");


        Properties prop = new Properties();
        prop.load(new FileInputStream(new File(ss[0])));

        log_path = new PrintStream(new FileOutputStream(prop.getProperty("LOG_PATH") + dateS + ".log"));
        log_path.println( "=========================================================================================");
        log_path.println("Utility Started at "+ new Date());

        File[] smtp_Folder_List = new File(prop.getProperty("SMTP_SOURCE_FOLDER_PATH")).listFiles();
        int count = 0;
        for (File smtp_Folder : smtp_Folder_List) {
            count++;
            log_path.println("-----------------------------------------------------------------");
            log_path.println("                " + smtp_Folder.getName());
            log_path.println("-----------------------------------------------------------------");

            if(!smtp_Folder.isDirectory()){
                continue;
            }
            if(!searchCompletedFile(prop.getProperty("SMTP_SOURCE_FOLDER_PATH"), smtp_Folder.getName())){
                continue;
            }

            SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
            Date date = new Date(sdf1.format(smtp_Folder.lastModified()));
            int thresholdTime = Integer.parseInt(prop.getProperty("RETENTION_HOURS"));
            long difference = new Date().getTime()- date.getTime();
            long diffHours = difference / (60 * 60 * 1000);
            System.out.println(diffHours);
            if(diffHours > thresholdTime) {
                log_path.println("Trying to move the folder and the complete file to the Backup folder");
                File completeFile = new File(prop.getProperty("SMTP_SOURCE_FOLDER_PATH") + smtp_Folder.getName() + ".complete");
                smtp_Folder.renameTo(new File(prop.getProperty("BACK_UP_FOLDER_PATH")+ smtp_Folder.getName()));
                completeFile.renameTo(new File(prop.getProperty("BACK_UP_FOLDER_PATH") + completeFile.getName()));
                log_path.println("Folder successfully moved");
            }
        }
        log_path.flush();
        log_path.close();
    }

    public static boolean searchCompletedFile(String path, String fileName) {
        File[] smtp_Folder_List = new File(path).listFiles();
        for (File smtp_CompletedFile : smtp_Folder_List) {
            if(smtp_CompletedFile.isDirectory()){
                continue;
            } else {
                if(smtp_CompletedFile.getName().equalsIgnoreCase(fileName + ".complete")) {
                    return true;
                }
            }
        }
        return false;
    }
}
