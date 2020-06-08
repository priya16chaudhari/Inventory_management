package com.inventory.demoproject.dao.impl;


import com.inventory.demoproject.dao.InventoryDao;
import com.inventory.demoproject.dto.InventoryDto;
import com.inventory.demoproject.model.InventoryModel;
import org.hibernate.*;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class InventoryDaoImpl implements InventoryDao {


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean insertService(InventoryModel inventoryModel)
    {
        Session session=null;
        try
        {
            session=sessionFactory.openSession();
            Transaction tr=session.beginTransaction();
            session.save(inventoryModel);

            tr.commit();
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
        finally
        {
            session.close();
        }
    }

    @Override
    public List getInventoryDao() {

        Session session=null;
        List list1=null;



        try
        {
            session=sessionFactory.openSession();
            Criteria criteria1=session.createCriteria(InventoryModel.class);
            list1=criteria1.list();
            System.out.println("list1 is"+list1.size());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            session.close();
        }
        return list1;
    }


    @Override
    public List getInventoryDaoProductName() {
        Session session=null;
        List list=null;
        try{
            session=sessionFactory.openSession();
            Query query=session.createQuery("select cm.productId as productId,cm.productName as productName from InventoryModel as cm ");
            query.setResultTransformer(Transformers.aliasToBean(InventoryModel.class));
            list=query.list();
            return list;
        }
        catch(Exception e){
            e.printStackTrace();
            return list;

        }
        finally {
            session.close();
        }
    }

    @Override
    public InventoryDto getInventoryProductDaoid(Integer productId) {
        Session session=null;
        InventoryDto inventoryDto=null;
        try
        {
            inventoryDto=new InventoryDto();
            session=sessionFactory.openSession();

            InventoryModel inventoryModel=session.load(InventoryModel.class,productId);
            inventoryDto.setProductId(inventoryModel.getProductId());
            inventoryDto.setProductName(inventoryModel.getProductName());
            inventoryDto.setProductSpecification(inventoryModel.getProductSpecification());
            inventoryDto.setProductUnit(inventoryModel.getProductUnit());
            inventoryDto.setProductHSN(inventoryModel.getProductHSN());
            inventoryDto.setProductPrice(inventoryModel.getProductPrice());

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return inventoryDto;
    }

    @Override
    public boolean updateService(InventoryModel inventoryModel) {
        Session session=null;
        try
        {
            session=sessionFactory.openSession();
            Transaction tr=session.beginTransaction();
            session.update(inventoryModel);

            tr.commit();
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
        finally
        {
            session.close();
        }
    }

    @Override
    public boolean deleteInventoryProductDao(Integer productId) {
        Session session=null;

        try{
            session=sessionFactory.openSession();
            Transaction tr=session.beginTransaction();
            Query query=session.createQuery("delete from InventoryModel as cm where cm.productId=:productId ");
            query.setParameter("productId",productId);
            query.executeUpdate();
            tr.commit();
            return true;

        }
        catch(Exception e){
            e.printStackTrace();

        return false;
        }
        finally {
            session.close();
        }
    }

    @Override
    public InventoryDto getproductWiseDaos(Integer productId){
        Session session=null;
        List list=null;
        InventoryDto inventoryDto=new InventoryDto();
        try {

            session=sessionFactory.openSession();

//            Query query=session.createQuery("select cm.productId as productId,cm.productName as productName,cm.productSpecification as productSpecification,cm.productUnit as productUnit,cm.productHSN as productHSN,cm.productPrice as productPrice from InventoryModel as cm where cm.productId=:productId");
//            query.setParameter("productId",productId);
//            query.setResultTransformer(Transformers.aliasToBean(InventoryModel.class));
//            list=query.list();
//            System.out.println("Selected List is:    "+list.size());


            Query query5 = session.createQuery("select cm.productId as productId from InventoryModel as cm where cm.productId=:productId");
            query5.setParameter("productId", productId);
            Integer pid = (Integer) query5.uniqueResult();

            inventoryDto.setProductId(pid);


            Query query = session.createQuery("select cm.productName as productName from InventoryModel as cm where cm.productId=:productId");
            query.setParameter("productId", productId);
            String pname = (String) query.uniqueResult();

            inventoryDto.setProductName(pname);

            Query query1 = session.createQuery("select cm.productSpecification as productSpecification from InventoryModel as cm where cm.productId=:productId");
            query1.setParameter("productId", productId);
            String productSpecification1 = (String) query1.uniqueResult();

            inventoryDto.setProductSpecification(productSpecification1);


            Query query2 = session.createQuery("select cm.productUnit as productUnit from InventoryModel as cm where cm.productId=:productId");
            query2.setParameter("productId", productId);
          Integer productUnit1 = (Integer) query2.uniqueResult();

            inventoryDto.setProductUnit(productUnit1);

            Query query3 = session.createQuery("select cm.productHSN as productHSN from InventoryModel as cm where cm.productId=:productId");
            query3.setParameter("productId", productId);
            Integer productHsn = (Integer) query3.uniqueResult();

            inventoryDto.setProductHSN(productHsn);

            Query query4 = session.createQuery("select cm.productPrice as productPrice from InventoryModel as cm where cm.productId=:productId");
            query4.setParameter("productId", productId);
            long productPrice = (long) query4.uniqueResult();

          inventoryDto.setProductPrice(productPrice);

            return inventoryDto;
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return inventoryDto;
    }

    @Override
    public InventoryDto getInventoryProductDaoidDao(Integer productId) {
        Session session=null;
        List list=null;
        InventoryDto inventoryDto=new InventoryDto();
        try {

            session=sessionFactory.openSession();

//            Query query=session.createQuery("select cm.productId as productId,cm.productName as productName,cm.productSpecification as productSpecification,cm.productUnit as productUnit,cm.productHSN as productHSN,cm.productPrice as productPrice from InventoryModel as cm where cm.productId=:productId");
//            query.setParameter("productId",productId);
//            query.setResultTransformer(Transformers.aliasToBean(InventoryModel.class));
//            list=query.list();
//            System.out.println("Selected List is:    "+list.size());

            Query query = session.createQuery("select cm.productName as productName from InventoryModel as cm where cm.productId=:productId");
            query.setParameter("productId", productId);
            String pname = (String) query.uniqueResult();

            inventoryDto.setProductName(pname);

            Query query1 = session.createQuery("select cm.productSpecification as productSpecification from InventoryModel as cm where cm.productId=:productId");
            query1.setParameter("productId", productId);
            String productSpecification1 = (String) query1.uniqueResult();

            inventoryDto.setProductSpecification(productSpecification1);


            return inventoryDto;
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return inventoryDto;
    }


}
