package com.example1.service;

import java.util.ArrayList;

import java.util.HashMap;


import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.example1.model.Customer;
import com.example1.model.Mobile;
import com.example1.repository.MobileRepository;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import com.example1.model.Mobile;
import com.example1.repository.MobileRepository;

public class MobileService implements MobileRepository
{
HashMap<Integer,Mobile> hmap=new HashMap<>();
int mid=4;
public MobileService()
{
	Mobile m1=new Mobile(1,"realme","realme.jpg", null);
	Mobile m2=new Mobile(2,"iphone","iphone.jpg", null);
	Mobile m3=new Mobile(3,"vivo","vivo.jpg", null);
	hmap.put(m1.getId(),m1);
	hmap.put(m2.getId(),m2);
	hmap.put(m3.getId(),m3);
}
@Override
public ArrayList<Mobile> getMobiles()
{
 ArrayList<Mobile> mobiles=new ArrayList<>(hmap.values());
 return mobiles;
}
@Override
public Mobile getMobileById(int mobileId)
{
	Mobile mobile=hmap.get(mobileId);
	if(mobile==null)
	{
		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}
	return mobile;
}

@Override
public Mobile addMobile(Mobile mobile)
{
	mobile.setId(mid);
	hmap.put(mid, mobile);
	mid=mid+1;
	return mobile;
}


@Override
public Mobile updateMobile(int mobileId, Mobile mobile) {
  
	Mobile existingMobile=hmap.get(mobileId); 
	if(mobile==null)
	{
		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}
	if(mobile.getName()!=null)
	{
		existingMobile.setName(mobile.getName());
	}
	if(mobile.getImage()!=null)
	{
		existingMobile.setImage(mobile.getImage());
	}
	return existingMobile;
}


@Override
public void deleteMobile(int mobileId)
{
	Mobile mobile=hmap.get(mobileId); 
	if(mobile==null)
	{
		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}
	else 
	{
		hmap.remove(mobileId);
	}
}
@Override
public Customer getMobileCustomer(int mobileId) {
	// TODO Auto-generated method stub
	return null;
}


}
	