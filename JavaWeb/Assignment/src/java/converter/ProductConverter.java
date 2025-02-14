package converter;

import controller.dto.Productdto;
import model.entity.Product;
import repository.repositoryimpl.categoryRepositoryImpl;

public class ProductConverter {

    categoryRepositoryImpl categoryRepository = new categoryRepositoryImpl();
    public Product convertDtoToEntity(Productdto productdto) {
        Product product = new Product();
        product.setIdProduct(productdto.getId());
        product.setName(productdto.getNameProduct());
        product.setUnit(productdto.getUnit());
        product.setPrice(productdto.getPriceProduct());
        String nameCategory = productdto.getNameCategory();
        int id = categoryRepository.FindTheCategoryByName(nameCategory);
        product.setIdCategory(id);
        return product;
    }

    public Productdto convertEntityToDto(Product product) {
        Productdto productdto = new Productdto();
        productdto.setId(product.getIdProduct());
        productdto.setNameProduct(product.getName());
        productdto.setUnit(product.getUnit());
        productdto.setPriceProduct(product.getPrice());
        int id = product.getIdCategory();
        String nameCategory = categoryRepository.findTheCategoryById(id);
        productdto.setNameCategory(nameCategory);
        return productdto;
    }
}
