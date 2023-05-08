package com.supportcenter.service;

import java.util.List;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supportcenter.DTO.OperatorDTO;
import com.supportcenter.exception.DepartmentException;
import com.supportcenter.exception.OperatorException;
import com.supportcenter.model.CurrentUserSession;
import com.supportcenter.model.Department;
import com.supportcenter.model.Operator;
import com.supportcenter.repository.AdminRepository;
import com.supportcenter.repository.CurrentUserSessionRepository;
import com.supportcenter.repository.DepartmentDao;
import com.supportcenter.repository.OperatorDao;

@Service
public class AdminServiceImp implements AdminService{
	
	@Autowired
	private AdminRepository adminRepo;
	
	@Autowired
	private DepartmentDao deptDao;
	
	
	@Autowired
	private OperatorDao optDao;
	
	@Autowired
	private CurrentUserSessionRepository cDao;
	
	

	@Override
	public Department addDepartment(Department d) throws LoginException {
		// Verifying login with given key 
//		CurrentUserSession cs =   cDao.findByUuid(key);
		Department d1 = deptDao.save(d);
		if(d1 != null ) {

			return d1;
		}else {
			 throw new LoginException("You are not authorized to add department");
		}
		
		
	}

	@Override
	public Department modifyDepartment(Department d,Integer deptId) throws DepartmentException, LoginException {
		           
		       // verifying login with given key 
//		CurrentUserSession cs =   cDao.findByUuid(key);
		Department d1 = deptDao.findById(deptId).orElseThrow(() -> new DepartmentException("There is not deparmtent with id "+deptId));
		if(d1 != null ) {

					  d1.setDeptName(d.getDeptName());
					  d1.getOperators().addAll(d.getOperators());
					return deptDao.save(d1);
				}else {
					 throw new LoginException("You are not authorized to update department");
				}
	}

	@Override
	public Department removeDepartment(Integer id) throws DepartmentException, LoginException {
		   // verifying login with given key 
//		CurrentUserSession cs =   cDao.findByUuid(key);
		Department d1 = deptDao.findById(id).orElseThrow(() -> new DepartmentException("There is not deparmtent with id "+id));
		if(d1 != null) {
			 
			 deptDao.delete(d1);
			 return d1;
		}else {
			 throw new LoginException("You are not authorized to update department");
		}
	}

	@Override
	public Department getDepartmentById(Integer id) throws DepartmentException, LoginException {
		   // verifying login with given key 
//		CurrentUserSession cs =   cDao.findByUuid(key);
		Department d1 = deptDao.findById(id).orElseThrow(() -> new DepartmentException("There is not deparmtent with id "+id));
		if(d1 != null) {
				 
				 return d1;
			}else {
				 throw new LoginException("You are not authorized to Admin to get department");
			}
	}

	@Override
	public Operator addOperator(Operator o) throws LoginException {
		   // verifying login with given key 
//		CurrentUserSession cs =   cDao.findByUuid(key);
		Operator o1 = optDao.save(o);
		return o1;
	}

	@Override
	public OperatorDTO assignDeptToOperator(Integer oid, Integer did)
			throws DepartmentException, OperatorException, LoginException {
//		CurrentUserSession cs =   cDao.findByUuid(key);
//		if(cs != null) {
		
			//find the department 
		      Department dept =	    deptDao.findById(did).orElseThrow(() -> new DepartmentException("There is no department with this id "+did));
			Operator  opt =		 optDao.findById(oid).orElseThrow(() -> new OperatorException("There is no operator with this  id "+oid));
						  
			      opt.setDepartment(dept);
			      dept.getOperators().add(opt);
			      
			      deptDao.save(dept);
			      optDao.save(opt);
			      
			      return new OperatorDTO(opt.getOperatorId(), dept.getDeptId());
//					}else {
//						 throw new LoginException("You are not authorized as Admin so you cannot add a operator");
//					}
	}

	@Override
	public Operator modifyOperator(Operator o,Integer operatorId) throws OperatorException, LoginException {
		 // verifying login with given key 
//		CurrentUserSession cs =   cDao.findByUuid(key);
//		if(cs != null) {
			  Operator opt =      optDao.findById(operatorId).orElseThrow(() -> new OperatorException("There is no operator associated with thid operatorId "+o.getOperatorId()));
			  
			  // update the first name 
			  if(o.getFirstName() != null) {
				   opt.setFirstName(o.getFirstName());
			  }
			  
			  //update the last name 
			  if(o.getLastName() != null) {
				   opt.setLastName(o.getLastName());
			  }
			  
			  // update department
			  if(o.getDepartment() != null) {
				   opt.setDepartment(o.getDepartment());
			  }
			  
			  
			  // update city 
			  if(o.getCity() != null) {
				   opt.setCity(o.getCity());
			  }
			  
			  // update email
			  if(o.getEmail() != null) {
				   opt.setEmail(o.getEmail());
			  }
			  
			  // update the password 
			  if(o.getPassword() != null) {
				    opt.setPassword(o.getPassword());
			  }
			  
			  //update the call list 
			  if(!o.getCall().isEmpty()) {
				     opt.getCall().clear();
				     opt.getCall().addAll(o.getCall());
			  }
			  
			  
			  
			         return  optDao.save(opt);
			 
//		}else {
//			 throw new LoginException("You are not authorized as Admin so you cannot update a operator");
//		}
	}

	@Override
	public Operator deleteOperator(Integer id) throws OperatorException, LoginException {
		// verify login with given key 
//		CurrentUserSession cs =   cDao.findByUuid(key);
//		if(cs != null) {
			Operator opt =     optDao.findById(id).orElseThrow(() -> new OperatorException("There is no operator with this id "+ id));
			 
			
		    	optDao.delete(opt);
		    	
		    	return opt;
			 
//		}else {
//			 throw new LoginException("You are not authorized as Admin so you cannot delete a operator");
//		}
		
	}

	@Override
	public List<Operator> getAllOperators(String key) throws LoginException {
		// verify login with given key 
//		CurrentUserSession cs =   cDao.findByUuid(key);
//		if(cs != null) {
			  
		   return	optDao.findAll();
			 
			 
//		}else 
//			 throw new LoginException("You are not authorized as Admin");
//	}
	}

	@Override
	public Operator getOperatorById(Integer id) throws OperatorException, LoginException {
		 // verify login with given key 
//		CurrentUserSession cs =   cDao.findByUuid(key);
//		if(cs != null) {
			  
		  return optDao.findById(id).orElseThrow(() -> new OperatorException("There is no operator with this id "+ id));
			 
			 
//		}else {
//			 throw new LoginException("You are not authorized as Admin");
//		}
		
	}

	@Override
	public List<Operator> getAllOperatorWithDeptId(Integer id) throws DepartmentException, LoginException {
		 // verify login with given key 
//		CurrentUserSession cs =   cDao.findByUuid(key);
//		if(cs != null) {
			
		   Department dept =	  deptDao.findById(id).orElseThrow(() -> new DepartmentException("There is no department with this id "+ id));
			 
		   
		   return dept.getOperators();
			 
//		}else {
//			 throw new LoginException("You are not authorized as Admin so you cannot add a operator");
//		}
	}
       
	
}
