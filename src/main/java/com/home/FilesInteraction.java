package com.home;

import java.io.File;
import java.util.List;

public class FilesInteraction {
    public void getFiles(File folder, List<File> files) {
        if (folder.isDirectory()) {
            File[] innerFiles = folder.listFiles();
            if (innerFiles != null) {
                for (File file :
                        innerFiles) {
                    if (file.isDirectory()) {
                        getFiles(file, files);
                    } else files.add(file);
                }
            }
        }
    }

    public void deleteFiles(File folder, String fileName) {
        if (folder.isDirectory()) {
            File[] innerFiles = folder.listFiles();
            if (innerFiles != null) {
                for (File file :
                        innerFiles) {
                    if (file.isDirectory()) {
                        deleteFiles(folder, fileName);
                    } else {
                        if (file.getName().equalsIgnoreCase(fileName)) {
                            file.delete();
                        }
                    }
                }
            }
        }
    }
}

