package com.inventory.demoproject.dao.impl;


import com.inventory.demoproject.dao.CustomerDao;
import com.inventory.demoproject.dto.CustomerDto;
import com.inventory.demoproject.model.CustomerModel;
import org.hibernate.*;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao {


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean insertCustomerService(CustomerModel customerModel)
    {
        Session session=null;
        try
        {
            session=sessionFactory.openSession();
            Transaction tr=session.beginTransaction();
            session.save(customerModel);

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
    public List getCustomerDao() {
        Session session=null;
        List list1=null;



        try
        {
            session=sessionFactory.openSession();
            Criteria criteria1=session.createCriteria(CustomerModel.class);
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
    public List getCustomernamesDao() {
        Session session=null;
        List list=null;
        try{
            session=sessionFactory.openSession();
            Query query=session.createQuery("select cm.customerId as customerId,cm.customerName as customerName from CustomerModel as cm ");
            query.setResultTransformer(Transformers.aliasToBean(CustomerModel.class));
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
    public List<CustomerModel> getcustomerWiseDaos(Integer customerId) {
        Session session=null;
        List list=null;

        try {
            session=sessionFactory.openSession();


            Query query=session.createQuery("select cm.customerId as customerId,cm.customerName as customerName,cm.customerAddress as customerAddress,cm.billingAddress as billingAddress,cm.contactNumber as contactNumber from CustomerModel as cm where cm.customerId=:customerId");

//            Query query=session.createQuery("select urm.userMaster as userMaster,urm.userTestMaster as userTestMaster,urm.questionMaster as questionMaster,urm.selectedAnswer as selectedAnswer from UserResultHead as urm where urm.userMaster.userId=:userId and urm.questionMaster.conceptMaster.chapterMaster.chapterId=:chapterId");
            query.setParameter("customerId",customerId);

            query.setResultTransformer(Transformers.aliasToBean(CustomerModel.class));
            list=query.list();
            System.out.println("Selected List is:    "+list.size());
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return list;
    }

    @Override
    public boolean updateCustomerService(CustomerModel customerModel) {
        Session session=null;
        try
        {
            session=sessionFactory.openSession();
            Transaction tr=session.beginTransaction();
            session.update(customerModel);

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
    public boolean deleteCustomerDao(Integer customerId) {
        Session session=null;

        try{
            session=sessionFactory.openSession();
            Transaction tr=session.beginTransaction();
            Query query=session.createQuery("delete from CustomerModel as cm where cm.customerId=:customerId ");
            query.setParameter("customerId",customerId);
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
    public CustomerDto getCustomerDaoid(Integer customerId) {
        Session session=null;
        CustomerDto customerDto=null;
        try
        {
            customerDto=new CustomerDto();
            session=sessionFactory.openSession();

            CustomerModel customerModel=session.load(CustomerModel.class,customerId);
            customerDto.setCustomerId(customerModel.getCustomerId());
            customerDto.setCustomerName(customerModel.getCustomerName());
//            customerDto.setBillDate(customerModel.getBillDate());
            customerDto.setCustomerAddress(customerModel.getCustomerAddress());

            customerDto.setBillingAddress(customerModel.getBillingAddress());

            customerDto.setContactNumber(customerModel.getContactNumber());

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return customerDto;
    }


    @Override
    public List getMobileDao(String contactNumber) {
        Session session=null;
        List list=null;
        try
        {
            session=sessionFactory.openSession();
            Query query=session.createQuery("select cm.customerId as customerId,cm.customerName as customerName,cm.customerAddress as customerAddress,cm.billingAddress as billingAddress,cm.contactNumber as contactNumber from CustomerModel as cm where cm.contactNumber=:contactNumber");
            query.setParameter("contactNumber",contactNumber);
            query.setResultTransformer(Transformers.aliasToBean(CustomerModel.class));
            list=query.list();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return list;
    }
}
