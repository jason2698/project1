package Firstproject.eshop.Dao;

import java.util.List;

import Firstproject.eshop.Model.Supplier;

public interface SupplierDAO 
{
  public boolean addSupplier(Supplier supplier);
  public boolean deleteSupplier(Supplier supplier);
  public boolean updateSupplier(Supplier supplier);
  public Supplier getSupplier(int supplierId);
  public List<Supplier> listSuppliers();
}
