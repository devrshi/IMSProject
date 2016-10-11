<div class="screenlet">
  <div class="screenlet-title-bar">
    <ul>
       <div id='searchOpt'>Student Registration</div></h1>
    </ul>
    <br class="clear"/>
  </div>
  <div class="screenlet-body">
     <form method="post" name="stRegistration" action="<@ofbizUrl>CreateStudent</@ofbizUrl>"  class="basic-form">
        <table class="tableView" cellspacing="0">
               <tr>
                 <td class='tLabel'>Study Institute Code :</td>
                 <td><input class="form-control"  type='text' name='stName'></td>
                 <td class='tLabel'>Name of  Institute :</td>
                 <td><input class="form-control"  type='text' name='stName'></td>
               </tr>
               <tr>
                 <td class='tLabel'>Candidate Name :</td>
                 <td><input class="form-control"  type='text' name='stName'></td>
                 <td class='tLabel'>Course Name:</td>
                 <td><input class="form-control"  type='text' name='stRoll'></td>
               </tr>
               <tr>
                 <td class='tLabel'>Father's Name :</td>
                 <td><input class="form-control"  type='text' name='stName'></td>
                 <td class='tLabel'>Mother's Name:</td>
                 <td><input class="form-control"  type='text' name='stRoll'></td>
               </tr>
               <tr>
                 <td class='tLabel'>Husband's Name :</td>
                 <td><input class="form-control"  type='text' name='stName'></td>
                 <td class='tLabel'>Sex:</td>
                 <td><input type='radio' name='sex' value='M'>Male / <input type='radio' name="sex" value="Female">Female</td>
               </tr>
               <tr>
                 <td class='tLabel'>Religion:</td>
                 <td><select class="form-control" name='religion'>
                     <option value='HINDU'>Hindu</option>
                     <option value='MUSLIM'>MUSLIM</option>
                     <option value='CHRISTEN'>CHIRSTEN</option>
                     <option value='SIKH'>SIKH</option>
                     <option value='OTHER'>OTHER</option>
                     </select></td>
                 <td class='tLabel'>Caste :</td>
                 <td><select class="form-control" name='caste'>
                     <option value='SC'>SC</option>
                     <option value='ST'>ST</option>
                     <option value='OBC'>OBC</option>
                     <option value='GEN'>GEN</option>
                     </select></td>
                 
               </tr>
               <tr>
                 <td class='tLabel'>Nationality :</td>
                 <td><input type='radio' name='nationality' value='INDIAN'>Indian <input type='radio' name='nationality' value='OTHER'>Other </td>
                 <td class='tLabel'>If Other Please Specify :</td>
                 <td><input class="form-control" type='text' name="otherNationality" value=""></td>
               </tr>
         
            <tr>
             <td colspan='4'>
		         <table>
		              <tr>
		                <td colspan='5' >Particulars of the qualifying Examination: </td>
		              </tr>
		              <tr>
		                 <td>S.No</td>
		                 <td>Exam Passed</td>
		                 <td>Board / University</td>
		                 <td>Year of Passing</td>
		                 <td>Division / Percentage</td>
		              </tr>
		              <tr>
		                 <td>1.</td>
		                 <td></td>
		                 <td></td>
		                 <td></td>
		              </tr>
		         </table>
		      </td> 
		      </tr>
		     <tr>
		        <td class='tLabel'>Name of the School / College and place from where qualifying Exam was passed</td>
		        <td><textarea name='qualifyingExam'></textarea></td>
		     </tr>  
		     <tr>
		        <td class='tLabel'>Name of the school / College / Institute (Last Attended)</td>
		        <td><textarea name='qualifyingExam'></textarea></td>
		     </tr>
		     <tr>
		        <td class='tLabel'>Enrollment No. if already enrolled in this University</td>
		        <td><input type='text'></td>
		        <td class='tLabel'>Receipt No. of fees paid to the study centre / UTD for Enrollment</td>
		        <td><input type='text'></td>
		     </tr> 
		     <tr>
		        <td class='tLabel'>Complete Postal Address</td>
		        <td><textarea name='address'></textarea></td>
		        <td class='tLabel'>Pincode</td>
		        <td><input type='text'></td>
		     </tr> 
         </table>
      </form>
    </div>
    </div> 
    
    
    
    
   
  
