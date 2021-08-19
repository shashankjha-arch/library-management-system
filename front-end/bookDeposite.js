
function depositeBook(){
  
    var ubname = document.getElementById("bname").value;
    var uauthor = document.getElementById("author").value;
    var upublisher = document.getElementById("publisher").value; 
    var uedition=document.getElementById("edition").value;
    var ubookid = document.getElementById("bookid").value; 
    var urnumber = document.getElementById("rnumber").value;
   /* if(passid_validation(upassword,7,12))
  {
    if(ValidateEmail(uemail))
  {
  }
  }
  */
  // Creating a XHR object
  let xhr = new XMLHttpRequest();
  let url = "http://localhost:8080/LMS/depositebook";
  
  // open a connection
  xhr.open("POST", url, true);
  
  // Set the request header i.e. which type of content you are sending
  xhr.setRequestHeader("Content-Type", "application/json");
  
  // Create a state change callback
  xhr.onreadystatechange = function () {
      if (xhr.status === 200) {
        window.location = "bookDeposite.html";
  
      }
  };
  
  // Converting JSON data to string
  var data = JSON.stringify({
      "bookName": ubname ,
      "bookAuthor": uauthor ,
      "publication" : upublisher,
      "edition" : uedition,
      "bookId" : ubookid,
      "registrationnumber" : urnumber
      
    });
  console.log(data)
  // Sending data with the request
  xhr.send(data);
  
  window.alert("Book Deposited");
  }
      
  
  
  