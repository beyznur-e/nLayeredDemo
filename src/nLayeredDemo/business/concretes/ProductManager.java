package nLayeredDemo.business.concretes;

import nLayeredDemo.business.abstracts.ProductService;
import nLayeredDemo.core.LoggerService;
import nLayeredDemo.dataAccess.abstracts.ProductDao;
import nLayeredDemo.entities.concretes.Product;
import java.util.List;

public class ProductManager implements ProductService {

    private ProductDao productDao; //enjection step 1
    private LoggerService loggerService;

    public ProductManager(ProductDao productDao, LoggerService loggerService) { //enjection step 2
        this.productDao = productDao;
        this.loggerService = loggerService;
    }

    @Override
    public void add(Product product) {
        if(product.getCategoryId()==1){
            System.out.println("Bu kategoride ürün kabul edilmiyor.");
            return;
        }
        this.productDao.add(product);
        this.loggerService.logToSystem("Ürün eklendi "+product.getName());
    }

    @Override
    public List<Product> getAll() {
        return List.of();
    }



}
