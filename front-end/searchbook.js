function searchBook(){
    var request = new XMLHttpRequest()

    var bookname=document.getElementById("bookname").value; 
   
    request.open('GET', 'http://localhost:8080/LMS/searchBook?bookname=abc', true)
    request.onload = function () {
      // Begin accessing JSON data here
      var data = JSON.parse(this.response);
      console.log(data);
     
      
        var booknameB = data.bookname;
       
        if(bookname==booknameB){
          window.alert("Book is available");
        }else{
          window.alert("Book unavailable");
        }
      
      
}
request.send();
}
