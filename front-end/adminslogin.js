
function checkLogin(){
    var request = new XMLHttpRequest()
    var email=document.getElementById("emailId").value; 
    var password=document.getElementById("passwordId").value; 
    if(email==""){

    }else{
    var url="http://localhost:8080/LMS/checkAdminLogin?email=".concat(email);
    request.open('GET', url, true);
    request.onload = function () {
      // Begin accessing JSON data here
      data = JSON.parse(this.response);
      console.log(data);
     
      
        var emailB = data.email;
        var passwordB = data.password;
        if(email==emailB&&password==passwordB){
          window.alert("Login successful");
          window.location="adminOperationtest.html";
         
        }else{
          window.alert("Login Failed");
        }
      
      
}

request.send();
}
}

function registerAdmin(){
  
  var ufname = document.getElementById("fname").value;
  var ulname = document.getElementById("lname").value;
  var uemail=document.getElementById("email").value; 
  var upassword=document.getElementById("password").value; 
  var ele = document.getElementsByName('gender');
              
            for(i = 0; i < ele.length; i++) {
                if(ele[i].checked)
                var ugender = ele[i].value;
            }
  var udob = document.getElementById("dob").value;
  var ueId = document.getElementById("eId").value;
  var ujstart = document.getElementById("jobstartingdate").value;
  var ucontact = document.getElementById("contact").value;
  var uaddress = document.getElementById("address").value;
  var ustatus = document.getElementById("status").value;

 /* if(passid_validation(upassword,7,12))
{
  if(ValidateEmail(uemail))
{
}
}
*/
// Creating a XHR object
let xhr = new XMLHttpRequest();
let url = "http://localhost:8080/LMS/registerstaff";

// open a connection
xhr.open("POST", url, true);

// Set the request header i.e. which type of content you are sending
xhr.setRequestHeader("Content-Type", "application/json");

// Create a state change callback
xhr.onreadystatechange = function () {
    if (xhr.status === 200) {
      window.location = "AdminLogin.html";

    }
};

// Converting JSON data to string
var data = JSON.stringify({
    "password": upassword,
    "email": uemail ,
    "firstname" : ufname,
    "lastname" : ulname,
    "gender" : ugender,
    "date_of_birth" : udob,
    "employeeId" : ueId,
    "job_Starting_date" : ujstart,
    "contact_number" : ucontact,
    "address" : uaddress,
    "isActive" : ustatus
  });
console.log(data)
// Sending data with the request
xhr.send(data);

window.alert("user registered");
}
