package com.example.capstone;

public class prodModel {
    String Name,Description,Price,Stocks;
    prodModel()
    {

    }


    public prodModel(String Name, String Description, String Price, String Stocks) {
        this.Name = Name;
        this.Description = Description;
        this.Price = Price;
        this.Stocks = Stocks;
    }

    public String getName() {
        return Name;
    }

        public void setName(String Name) {
            this.Name = Name;
    }
    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;

    }
    public String getPrice() {
        return Price;
    }

    public void setPrice(String Price) {
        this.Price = Price;
    }



    public String getStocks() {
            return Stocks;
        }

    public void setStocks(String Stocks) {
        this.Stocks = Stocks;
    }
}
