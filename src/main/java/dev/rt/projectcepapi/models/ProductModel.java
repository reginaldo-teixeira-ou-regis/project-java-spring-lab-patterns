package dev.rt.projectcepapi.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "ProductModel")
public class ProductModel {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long idProduct;
    private String name;
    private String ean;
    private String unity;
    @OneToMany(cascade={CascadeType.MERGE}, fetch = FetchType.LAZY)
    List<DistributorModel> distributor = new ArrayList<>();

    public Long getIdProduct() {

        return idProduct;

    }

    public void setIdProduct(Long idProduct) {

        this.idProduct = idProduct;

    }

    public String getName() {

        return name;

    }

    public void setName(String name) {

        this.name = name;

    }

    public String getEan() {

        return ean;

    }

    public void setEan(String ean) {

        this.ean = ean;

    }

    public String getUnity() {

        return unity;

    }

    public void setUnity(String unity) {

        this.unity = unity;

    }

    public List<DistributorModel> getDistributor() {

        return distributor;

    }

    public void setDistributor(List<DistributorModel> distributor) {

        this.distributor = distributor;

    }
}
