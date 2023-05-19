package dev.rt.projectcepapi.services.impl;

import dev.rt.projectcepapi.models.AddressModel;
import dev.rt.projectcepapi.models.DistributorModel;
import dev.rt.projectcepapi.models.ProductModel;
import dev.rt.projectcepapi.models.repository.AddressRepository;
import dev.rt.projectcepapi.models.repository.DistributorRepository;
import dev.rt.projectcepapi.models.repository.ProductRepository;
import dev.rt.projectcepapi.services.ProductService;
import dev.rt.projectcepapi.services.ViaCepService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private DistributorRepository distributorRepository;
    private AddressRepository addressRepository;
    private ViaCepService viaCepService;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository,
                              DistributorRepository distributorRepository,
                              AddressRepository addressRepository,
                              ViaCepService viaCepService
    ) {
        this.productRepository = productRepository;
        this.distributorRepository = distributorRepository;
        this.addressRepository = addressRepository;
        this.viaCepService = viaCepService;
    }

    @Override
    public Iterable<ProductModel> findAll() {
        return productRepository.findAll();
    }

    @Override
    public ProductModel findById(Long id) {
        Optional<ProductModel> product = productRepository.findById(id);
        return product.orElse(null);
    }

    @Override
    public void insert(ProductModel productModel) {
        insertProductWithDistributor(productModel);
    }

    @Override
    public void update(Long id, ProductModel productModel) {
        Optional<ProductModel> productDb = productRepository.findById(id);
        if (productDb.isPresent()) {
            insertProductWithDistributor(productModel);
        }
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    private void insertProductWithDistributor(ProductModel productModel) {
        List<DistributorModel> distributorsList = productModel.getDistributor();
        distributorsList.forEach(this::insertDistributorWithZipCod);
        productRepository.save(productModel);
    }

    private void insertDistributorWithZipCod(DistributorModel distributorModel) {
        String cep = distributorModel.getAddress().getCep();
        AddressModel address = addressRepository.findById(cep).orElseGet(() -> {
            AddressModel newAddress = viaCepService.consultarCep(cep);
            addressRepository.save(newAddress);
            return newAddress;
        });
        distributorModel.setAddress(address);
        distributorRepository.save(distributorModel);
    }
}
