package in.purabtech.csvupload.service;

import in.purabtech.csvupload.helper.CSVHelper;
import in.purabtech.csvupload.model.Book;
import in.purabtech.csvupload.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;


@Service
public class CSVService {

    @Autowired
    BookRepository repository;

    public void save(MultipartFile file) {
        try {
            List<Book> books = CSVHelper.csvToBooks(file.getInputStream());
            repository.saveAll(books);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    public ByteArrayInputStream load() {
        List<Book> books = repository.findAll();

        ByteArrayInputStream in = CSVHelper.booksToCSV(books);
        return in;
    }
}
