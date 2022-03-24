package com.mytechexp.junittest;

public class Calculator {

DataSupplier supplier;
public void setSupplier(DataSupplier supplier)
    {
       this.supplier=supplier;
    }
    public int add(int data[])
    {
        int sum=0;
        for(int val:data)
        {
            sum+=val;
        }
        return sum;
    }
    public int addWithService()
    {
        int sum=0;
        for(int val:supplier.getData())
        {
            sum+=val;
        }
        return sum;
    }


}
