package com.booker.service.file

import com.booker.domain.file.BookerFile
import com.booker.exception.BusinessException

import org.springframework.web.multipart.MultipartFile

import utils.date.DateUtils
import utils.filemanager.FileManager
import utils.filemanager.FileManagerResourceName
import utils.filemanager.LocalDiskManager

class BookerFileService {

    public BookerFile save(MultipartFile file) {
        validateSave(file)

        FileManager manager = new LocalDiskManager(FileManagerResourceName.BOOK_COVER)
        String fileName = DateUtils.toString(new Date(), "yyyy-MM-dd-HH:mm:ss:S") + file.originalFilename
        Boolean overrideIfExists = false
        manager.write(fileName, file.getInputStream(), overrideIfExists)

        BookerFile bookerFile = new BookerFile()
        bookerFile.name = fileName
        bookerFile.size = file.size

        return bookerFile.save(failOnError: true)
    }

    private void validateSave(MultipartFile file) {
        final List<String> acceptedDocumentTypes = ["jpg", "jpeg", "png"]

        String fileExtension = getExtension(file)
        if (!acceptedDocumentTypes.contains(fileExtension)) throw new BusinessException("Formato de arquivo não permitido")
    }

    public BookerFile update(BookerFile oldBookCover, MultipartFile newBookCover) {
        delete(oldBookCover)

        return save(newBookCover)
    }

    private void delete(BookerFile bookerFile) {
        FileManager manager = new LocalDiskManager(FileManagerResourceName.BOOK_COVER)
        manager.delete(bookerFile.name)

        bookerFile.delete(failOnError: true)
    }

    private String getExtension(MultipartFile file) {
        if (!file.originalFilename) return ""

        return file.originalFilename.split("\\.").last().toLowerCase()
    }
}
