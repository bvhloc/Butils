package com.bvhloc.general.utils.file;

import android.os.Environment;

import java.io.File;
import java.io.IOException;

/**
 * Created by COVISOFT on 7/17/2017.
 */

public class LogFileWriter {

    /**
     *<uses-permission android:name="android.permission.READ_LOGS" />
     * */

    public static void writeTo(final String folderName) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                Process process = null;
                while (true) {
                    try {
                        File filename = new File(Environment.getExternalStorageDirectory() + "/" + folderName + "/" + System.currentTimeMillis() + ".log");
                        if (!filename.getParentFile().exists()) {
                            filename.getParentFile().mkdir();
                        }
                        filename.createNewFile();
                        String cmd = "logcat -f " + filename.getAbsolutePath();
                        process = Runtime.getRuntime().exec(cmd);
                        Thread.sleep(3600000);
                        process.destroy();
                        new ProcessBuilder()
                                .command("logcat", "-c")
                                .redirectErrorStream(true)
                                .start();
//                Thread.sleep(500);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        process.destroy();
                        try {
                            new ProcessBuilder()
                                    .command("logcat", "-c")
                                    .redirectErrorStream(true)
                                    .start();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                        writeTo(folderName);
                    }
                }
            }
        }).start();
    }
}
