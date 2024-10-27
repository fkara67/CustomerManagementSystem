package business;

import core.Helper;
import dao.ProductDao;
import entity.Customer;
import entity.Product;

import java.util.ArrayList;

public class ProductController {
    private final ProductDao productDao = new ProductDao();

    public ArrayList<Product> findAll() {
        return this.productDao.findAll();
    }

    public boolean save(Product product) {
        return productDao.save(product);
    }

    public Product getById(int id) {
        return this.productDao.getById(id);
    }

    public boolean update(Product customer) {
        if (this.getById(customer.getId()) == null) {
            Helper.showMsg("There is no customer with ID " + customer.getId());
            return false;
        }
        return this.productDao.update(customer);
    }

    public boolean delete(int id) {
        if (this.getById(id) == null) {
            Helper.showMsg("There is no product with ID " + id);
            return false;
        }
        return this.productDao.delete(id);
    }

}
