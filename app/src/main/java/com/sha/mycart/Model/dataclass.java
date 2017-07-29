package com.sha.mycart.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class dataclass {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("desc")
    @Expose
    private String desc;

    @SerializedName("total")
    @Expose
    private String total;
    @SerializedName("counter")
    @Expose
    private Integer counter;

    /**
     * No args constructor for use in serialization
     *
     */
    public dataclass() {
    }

    /**
     *
     * @param id
     * @param category
     * @param desc

     */
    public dataclass(Integer id, String category, String desc) {
        super();
        this.id = id;
        this.category = category;
        this.desc = desc;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


    public Integer getCounter() {
        return counter;
    }

    public void setCounter(Integer counter) {
        this.counter = counter;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}