package utils.filemanager

import grails.io.IOUtils

abstract class FileManager {

    private static final Integer DEFAULT_MAX_UPLOAD_SIZE_IN_MEGABYTES = 10

    protected FileManagerResourceName resourceName

    private Integer maxUploadSizeInMegabytes

    FileManager(FileManagerResourceName resourceName) {
        this.resourceName = resourceName
        setMaxUploadSize(DEFAULT_MAX_UPLOAD_SIZE_IN_MEGABYTES)
    }

    public Boolean write(File file, String filename, Boolean deleteSourceFileOnSuccess, Boolean overrideIfExists) {
        Boolean wasSuccessfullySaved = write(filename, new FileInputStream(file), overrideIfExists)
        if (deleteSourceFileOnSuccess && wasSuccessfullySaved) file.delete()

        return wasSuccessfullySaved
    }

    public Boolean write(String filename, InputStream inputStream, Boolean overrideIfExists) {
        try {
            validateWrite(filename, inputStream, overrideIfExists)

            Boolean wasSuccessfullyUploaded = upload(filename, inputStream)
            inputStream.close()

            return wasSuccessfullyUploaded
        } catch (Exception exception) {
            return false
        } finally {
            IOUtils.closeQuietly(inputStream)
        }
    }

    public FileManager setMaxUploadSize(Integer megabytes) {
        this.maxUploadSizeInMegabytes = megabytes

        return this
    }

    public abstract void delete(String filename)

    public abstract Boolean exists(String filename)

    public abstract List<String> listFilename(String path)

    public abstract InputStream read(String filename)

    protected abstract Boolean upload(String filename, InputStream inputStream)

    protected abstract String getResourceDir()

    private void validateWrite(String filename, InputStream inputStream, Boolean overrideIfExists) {
        Boolean fileExistsAndMustNotBeOverwritten = !overrideIfExists && exists(filename)
        if (fileExistsAndMustNotBeOverwritten) throw new RuntimeException("O arquivo já existe e não pode ser sobrescrito")

        Boolean fileSizeIsBiggerThanAllowed = inputStream.available() > FileSizeUtils.megabytesToBytes(this.maxUploadSizeInMegabytes)
        if (fileSizeIsBiggerThanAllowed) throw new RuntimeException("O arquivo excede o tamanho máximo de ${this.maxUploadSizeInMegabytes}MB")
    }
}
