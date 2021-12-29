package com.home;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        try (Connection conn = ConnectionFactory.getConnection()) {
            try {
                try (Statement st = conn.createStatement()) {
                    st.execute("DROP TABLE IF EXISTS Files");

                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            File folder = new File("C:/Users/denis/IdeaProjects/FilesDAO/testing");
            ClientDAOImpl dao = new ClientDAOImpl(conn, "Files");

            Format dateFormat = new SimpleDateFormat();
            FilesInteraction interaction = new FilesInteraction();

            dao.createTable(Files.class);

            List<File> list = new ArrayList<>();
            interaction.getFiles(folder, list);
            for (File innerFile :
                    list) {
                Files files = new Files(innerFile.getName(), innerFile.length(), dateFormat.format(new Date(innerFile.lastModified())));
                dao.add(files);
            }
            List<Files> filesList = dao.getAll(Files.class);
            for (Files file : filesList) {
                System.out.println(file);
            }
            dao.delete(filesList.get(1), folder);
        }
    }
}