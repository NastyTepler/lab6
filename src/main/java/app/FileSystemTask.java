package app;

import java.io.IOException;
import java.nio.file.*;
import java.util.Comparator;
import java.util.stream.Stream;

public class FileSystemTask {

    public static void run() throws IOException {
        System.out.println("\n=== Задание 2: Работа с файловой системой ===");

        Path surnameDir = Paths.get("Теплякова");
        Files.createDirectories(surnameDir);

        Path nameFile = surnameDir.resolve("Анастасия.txt");
        Files.createFile(nameFile);

        Path nestedDir = surnameDir.resolve("dir1/dir2/dir3");
        Files.createDirectories(nestedDir);
        Path copiedFile = nestedDir.resolve("Анастасия.txt");
        Files.copy(nameFile, copiedFile, StandardCopyOption.REPLACE_EXISTING);

        Path file1 = surnameDir.resolve("dir1/file1.txt");
        Files.createFile(file1);

        Path file2 = surnameDir.resolve("dir1/dir2/file2.txt");
        Files.createFile(file2);

        System.out.println("\n--- Обход директории ---");
        try (Stream<Path> paths = Files.walk(surnameDir)) {
            paths.forEach(path -> {
                String prefix = Files.isDirectory(path) ? "D: " : "F: ";
                System.out.println(prefix + path.getFileName());
            });
        }

        Path dirToDelete = surnameDir.resolve("dir1");
        System.out.println("\n--- Удаление папки dir1 ---");

        try (Stream<Path> paths = Files.walk(dirToDelete)) {
            paths.sorted(Comparator.reverseOrder())
                    .forEach(p -> {
                        try {
                            Files.delete(p);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        }
        System.out.println("Папка dir1 успешно удалена!");
    }
}