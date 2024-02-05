package utils.filemanager

import java.nio.file.Files
import java.nio.file.StandardCopyOption

class LocalDiskManager extends FileManager {

    LocalDiskManager(FileManagerResourceName resourceName) {
        super(resourceName)
    }

    public void delete(String filename) {
        File file = buildFile(filename)
        if (!file.exists()) throw new RuntimeException("Arquivo não encontrado")

        file.delete()
    }

    public Boolean exists(String filename) {
        return buildFile(filename).exists()
    }

    public List<String> listFilename(String path) {
        return buildFile(path).listFiles().collect { it.name }
    }

    public InputStream read(String filename) {
        File file = buildFile(filename)
        if (!file.exists()) return null

        return new FileInputStream(file)
    }

    protected Boolean upload(String filename, InputStream inputStream) {
        File file = buildFile(filename)

        File directory = file.getParentFile()
        if (!directory.exists()) {
            if (!directory.mkdirs()) throw new RuntimeException("Não foi possível criar os diretórios [${directory.name}]")
        }

        return Files.copy(inputStream, file.toPath(), StandardCopyOption.REPLACE_EXISTING).asBoolean()
    }

    protected String getResourceDir() {
        final String baseDir = "${System.properties["user.dir"]}/../files"

        return "${baseDir}/${this.resourceName.toString().toLowerCase()}"
    }

    private File buildFile(String filename) {
        final String fullPath = "${getResourceDir()}/${filename.replaceAll("^/", "")}"

        return new File(fullPath)
    }
}
