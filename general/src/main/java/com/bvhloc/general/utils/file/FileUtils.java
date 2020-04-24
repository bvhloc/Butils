package com.bvhloc.general.utils.file;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by TuanAnh on 5/31/2017.
 */

public class FileUtils {
    private static final String TAG = FileUtils.class.getSimpleName();

    public static void generateFile(String filePath, String body) {
        try {
            generateFileDir(filePath);
            File gpxfile = new File(filePath);
            Log.d(TAG, "generateFile: " + gpxfile.getAbsolutePath());
            FileWriter writer = new FileWriter(gpxfile);
            writer.append(body);
            writer.flush();
            writer.close();
            Log.d(TAG, "generateFile: " + gpxfile.getAbsolutePath() + " successfully");
//            Toast.makeText(context, "Saved", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "generateFile: " + getFileBody(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getFileBody(String filePath) {

        File file = new File(filePath);

        StringBuilder text = new StringBuilder();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {
                text.append(line);
                text.append('\n');
            }
            br.close();
        } catch (IOException e) {
            //You'll need to add proper error handling here
            return null;
        }
        return text.toString();
    }

    public static void generateFileDir(String filePath){

        File dir = new File(new File(filePath).getParent());
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }

    public static void copyFile(String sourceFilePath, String destinationFilePath, final CopyFileCallback callback) {

        generateFileDir(destinationFilePath);

        new AsyncTask<File, Integer, Boolean>() {
            private boolean success = true;
            private int count = 0;

            @Override
            protected void onPreExecute() {
                callback.onCopyStart();
            }

            @Override
            protected Boolean doInBackground(File... params) {
                if (removeUpenFile()) {
                    copy(params[0], params[1]);
                    return success;
                }
                return false;
            }


            @Override
            protected void onProgressUpdate(Integer... values) {
                super.onProgressUpdate(values);
                callback.onCopyProgressUpdate(values[0]);
            }

            @Override
            protected void onPostExecute(Boolean result) {
                if (success)
                    callback.onCopyFinish();
                else callback.onCopyFail();
            }


            private boolean removeUpenFile() {
//                try {
//                    File file = new File(Constant.UPEND_FILE_PATH);
//                    if (file.exists()) {
//                        file.delete();
//                        Log.d(TAG, "removeUpenFile:");
//                        return true;
//                    }
//                    return true;
//                } catch (Exception e) {
//                    return false;
//                }
                return true;
            }

            private void copy(File sourceLocation, File targetLocation) {
                try {
                    if (sourceLocation.isDirectory()) {
                        String[] children = sourceLocation.list();
                        for (int i = 0; i < children.length; i++) {
                            File target = new File(targetLocation, children[i]);
                            if (target.exists())
                                target.delete();
                            copy(new File(sourceLocation, children[i]), target);
                        }
                    } else {
                        try {
                            InputStream in = new FileInputStream(sourceLocation);
                            OutputStream out = new FileOutputStream(targetLocation);

                            // Copy the bits from instream to outstream
                            byte[] buf = new byte[1024];
                            int len;
                            while ((len = in.read(buf)) > 0) {
                                out.write(buf, 0, len);
                            }
                            in.close();
                            out.close();

                            count = count - 1;
                            publishProgress(count);
                        } catch (Exception e) {
                            success = false;
                            return;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    success = false;
                    return;
                }
            }
        }.execute(new File(sourceFilePath), new File(destinationFilePath));
    }

    public interface CopyFileCallback {

        void onCopyStart();

        void onCopyProgressUpdate(int position);

        void onCopyFail();

        void onCopyFinish();
    }
}
