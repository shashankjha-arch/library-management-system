function searchMember() {
    
       
    alert("Page is loaded"); 
   var request = new XMLHttpRequest();
   var uregistrationnumber=document.getElementById("registrationnumber").value;
   var data;
   var url="http://localhost:8080/LMS/searchUser?registrationnumber=".concat(uregistrationnumber);
   request.open('GET', url, false);
request.onload = function () {
 
  data = JSON.parse(this.response);
 console.log(data);


   
}
request.send();
   for(const i of data){
   optionText = String(i);;
        optionValue = String(i);
       
   $('#select1').append($('<option>').val(optionValue).text(optionText));
   }
   
}

function deleteMember(){
var selectedUser = document.getElementById('select1').selectedOptions[0].value;

var request = new XMLHttpRequest();
   var data;
   var url="http://localhost:8080/LMS/deactivatemember?registrationnumber=".concat(selectedUser);
   request.open('GET', url, false);
request.onload = function () {
 
  data = JSON.parse(this.response);
 console.log(data);


   
}
request.send();
window.alert("Member deleted successful");
window.location="adminOperationtest.html";
}

