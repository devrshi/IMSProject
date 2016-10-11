package com.org.Admission;

import java.util.Locale;
import java.util.Map;

import org.ofbiz.base.util.UtilMisc;
import org.ofbiz.base.util.UtilProperties;
import org.ofbiz.entity.GenericDelegator;
import org.ofbiz.entity.GenericEntityException;
import org.ofbiz.entity.GenericValue;
import org.ofbiz.service.DispatchContext;
import org.ofbiz.service.ServiceUtil;

public class ImsCenter {
	  public static final  String resource = "imsCenterUiLabels";
	
	public static Map<String, Object> studentRegistration(DispatchContext dctx,
			Map<String, ? extends Object> context) {
			Map<String, Object> result = ServiceUtil.returnSuccess();
			GenericDelegator delegator = (GenericDelegator)dctx.getDelegator();
			GenericValue userLogin = (GenericValue) context.get("userLogin");
			Locale locale = (Locale) context.get("locale");
			String stName = (String) context.get("stName");
			String stRoll = (String) context.get("stRoll");
			
			
			System.out.println("========HI========="+stName);
			
			return result;
			
			
	}
	
		  
		  
		  public static Map<String, Object> createCourseMaster(DispatchContext dctx,Map<String, ? extends Object> context) {
			 Map<String, Object> result = ServiceUtil.returnSuccess();
		   GenericDelegator delegator = (GenericDelegator) dctx.getDelegator();
		   Locale locale = (Locale) context.get("locale");
		   String courseName = (String)context.get("courseName");
		   String courseDescription = (String)context.get("courseDescription");
		   String courseLevel = (String)context.get("courseLevel");
		   String courseYear = (String)context.get("courseYear");
		   Long noOfSemester = (Long) context.get("noOfSemester");
		   Long courseDuration = (Long) context.get("courseDuration");
		   Long noOfSeat = (Long) context.get("noOfSeat");
		   String courseMasterId = delegator.getNextSeqId("CourseMaster");
		   
		   try {
		   GenericValue courseSave = delegator.makeValue("CourseMaster", UtilMisc.toMap("courseMasterId",courseMasterId,"courseName", courseName, "courseDescription", courseDescription, "courseLevel", courseLevel, 
				   "courseYear", courseYear, "noOfSemester", noOfSemester,"courseDuration",courseDuration,"noOfSeat",noOfSeat));
		  
		   
		   delegator.create(courseSave);
		result.put("successMessage",
					UtilProperties.getMessage(resource, "Course Master Created Successfully "
							+ courseMasterId, locale));
		   } catch (Exception e) {
			}
		   
		return result;
		 }
	    
	    
	    public static Map<String, Object> createSubjectMaster(DispatchContext dctx, Map<String, ? extends Object> context)  {	
			 Map<String, Object> result = ServiceUtil.returnSuccess();
		   //LocalDispatcher dispatcher = dctx.getDispatcher();
		   GenericDelegator delegator = (GenericDelegator) dctx.getDelegator();
		   Locale locale = (Locale) context.get("locale");
		   String subjectName = (String)context.get("subjectName");
		   String subjectType = (String)context.get("subjectType");
		   String subjectNature = (String)context.get("subjectNature");
		   
		 
		   try {
			   
			   String subjectId = delegator.getNextSeqId("SubjectMaster");
			
			
		   GenericValue subjectSave = delegator.makeValue("SubjectMaster", 
				                                           UtilMisc.toMap("subjectId",subjectId,
				                                        		           "subjectName", subjectName,
				                                        		           "subjectNature",subjectNature,
				                                        		           "subjectType", subjectType));
		   delegator.create(subjectSave);	
		   
		   result.put("successMessage",
					UtilProperties.getMessage(resource, "Subject Master Created Successfully "+ subjectId, locale));
	     
		   } catch (GenericEntityException e) {
			
			}
		  
		return result;
		 }


}
