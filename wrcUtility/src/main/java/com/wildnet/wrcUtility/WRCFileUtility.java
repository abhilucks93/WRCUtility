package com.wildnet.wrcUtility;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class WRCFileUtility {
    public static boolean isFileExist(Context context, String file_name) {
        File file = new File(context.getFilesDir() + "/" + file_name);
        if (file.exists())
            return true;
        else
            return false;

    }

    public static boolean isAllFileExist(Context context, String[] file_names) {
        Boolean ret = false;
        for (int i = 0; i < file_names.length; i++) {
            File file = new File(context.getFilesDir() + "/" + file_names[i]);
            if (file.exists())
                ret = true;
            else {
                ret = false;
                break;
            }
        }
        return ret;
    }

    public static void trimCache(Context context) {
        try {
            File dir = context.getCacheDir();
            if (dir != null && dir.isDirectory()) {
                deleteDir(dir);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static boolean deleteDir(File dir) {
        if (dir != null && dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }

        // The directory is now empty so delete it
        return dir.delete();
    }

    // clear the cache data from call
    public static boolean deleteCacheDirectory(Context context) {
        final String sdState = android.os.Environment.getExternalStorageState();
        File cacheDir;

        if (sdState.equals(android.os.Environment.MEDIA_MOUNTED)) {
            final File sdDir = android.os.Environment.getExternalStorageDirectory();
            cacheDir = new File(sdDir, "data/tac/images");
        } else
            cacheDir = context.getCacheDir();
        return deleteDir2(cacheDir);
    }

    public static boolean deleteDir2(File dir) {
        if (dir != null && dir.isDirectory()) {
            final String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        // The directory is now empty so delete it
        return dir.delete();
    }

    public static void copyAssetsToFolder(AssetManager assetManager, String sourceFolder, String destinationFolder)
            throws IOException {
        final String[] assets = assetManager.list(sourceFolder);

        final File destFolderFile = new File(destinationFolder);
        if (!destFolderFile.exists()) {
            destFolderFile.mkdirs();
        }
        copyAsset(assetManager, sourceFolder, destinationFolder, assets);
    }


    public static void copyAsset(AssetManager assetManager, String sourceFolder, String destinationFolder,
                                 String... assetsNames) throws IOException {

        for (String assetName : assetsNames) {
            OutputStream destinationStream = new FileOutputStream(new File(destinationFolder + "/" + assetName));
            String[] files = assetManager.list(sourceFolder + "/" + assetName);
            if (files == null || files.length == 0) {

                InputStream asset = assetManager.open(sourceFolder + "/" + assetName);
                try {
                    byte[] buffer = new byte[0x1000];
                    int read;
                    while ((read = asset.read(buffer)) != -1) {
                        destinationStream.write(buffer, 0, read);
                    }
                } finally {
                    asset.close();
                    destinationStream.close();
                }
            }
        }
    }


    public static boolean appInstalledOrNot(Context context, String pkgName) {
        boolean app_installed = false;
        try {
            ApplicationInfo info = context.getPackageManager().getApplicationInfo("" + pkgName, 0);
            app_installed = true;
        } catch (PackageManager.NameNotFoundException e) {
            app_installed = false;
        }
        return app_installed;
    }
}
