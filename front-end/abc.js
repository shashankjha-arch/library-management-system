function addOption() {
    
       
        alert("Page is loaded"); 
       var request = new XMLHttpRequest();
       var ubookname=document.getElementById("bookname").value;
       var data;
       var url="http://localhost:8080/LMS/searchBook?bookname=".concat(ubookname);
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

function bookWithdraw(){
    var selectedBook = document.getElementById('select1').selectedOptions[0].value;
    var registrationnumber = document.getElementById('rnumber').value;
    var request = new XMLHttpRequest();
       var data;
       var url="http://localhost:8080/LMS//withdrawbook?bookname=".concat(selectedBook).concat('&registrationnumber=').concat(registrationnumber);
       request.open('GET', url, false);
   request.onload = function () {
     
      data = JSON.parse(this.response);
     console.log(data);
   

       
   }
   request.send();
   window.alert("Book withdrawal successful");
   window.location="withdraw-deposit.html";
}

  