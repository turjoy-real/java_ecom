package org.turjoysaha.ecom.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.turjoysaha.ecom.demo.Author;
import org.turjoysaha.ecom.demo.AuthorRepo;
import org.turjoysaha.ecom.demo.Book;
import org.turjoysaha.ecom.model.Category;
import org.turjoysaha.ecom.model.Order;
import org.turjoysaha.ecom.model.Price;
import org.turjoysaha.ecom.model.Product;
import org.turjoysaha.ecom.repository.CategoryRepository;
import org.turjoysaha.ecom.repository.OrderRepository;
import org.turjoysaha.ecom.repository.PriceRepository;
import org.turjoysaha.ecom.repository.ProductRepository;

import java.util.List;

@Service
public class InitServiceImpl implements InitService {
    private ProductRepository productRepository;
    private PriceRepository priceRepository;
    private OrderRepository orderRepository;
    private CategoryRepository categoryRepository;

//  Demo
    private AuthorRepo authorRepo;

    public InitServiceImpl(ProductRepository productRepository, PriceRepository priceRepository,OrderRepository orderRepository, CategoryRepository categoryRepository, AuthorRepo authorRepo) {
        this.productRepository = productRepository;
        this.priceRepository = priceRepository;
        this.orderRepository = orderRepository;
        this.categoryRepository = categoryRepository;
        this.authorRepo = authorRepo;
    }

    @Transactional
    @Override
    public void initialize() {
        Category electronics = new Category();
        electronics.setCategoryName("Electronics");

        electronics = categoryRepository.save(electronics); // insert or update

        Price priceIphone = new Price();
        priceIphone.setCurrency("INR");
        priceIphone.setAmount(200000);
        priceIphone.setDiscount(0);

        Price priceMacbook = new Price();
        priceMacbook.setCurrency("INR");
        priceMacbook.setAmount(200000);
        priceMacbook.setDiscount(0);

        priceIphone = priceRepository.save(priceIphone);
        priceMacbook = priceRepository.save(priceMacbook);

        Product iphone = new Product();
        iphone.setCategory(electronics);
        iphone.setPrice(priceIphone);
        iphone.setTitle("iphone");
        iphone.setDescription("iphone description");
        iphone.setImage("...");
        iphone = productRepository.save(iphone);

        Product macbook = new Product();
        macbook.setCategory(electronics);
        macbook.setPrice(priceMacbook);
        macbook.setTitle("macbook");
        macbook.setDescription("macbook description");
        macbook.setImage("...");
        macbook = productRepository.save(macbook);

        Order order = new Order();
        order.setProduct(List.of(iphone, macbook));
        order = orderRepository.save(order);

        Author author = new Author("Ashok Kumar", null);

        Book book1 = new Book("Book1", author);
        Book book2 = new Book("Book2", author);
        Book book3 = new Book("Book3", author);
        author.setBooks(List.of(book1,book2,book3));

        authorRepo.save(author); // cascade ALL -> if we save author, all dependent objects should also get saved

        Author savedAuthor = authorRepo.findById(1).get();
//        List<Book> books = savedAuthor.getBooks();
        System.out.println(savedAuthor.getName());

    }
}
