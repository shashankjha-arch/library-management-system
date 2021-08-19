
function searchBook(){
 
  var script = document.createElement('script');
script.src = "https://code.jquery.com/jquery-3.3.1.min.js";
script.type = 'text/javascript';
document.getElementsByTagName('head')[0].appendChild(script);

    var request = new XMLHttpRequest()
    var ubookname=document.getElementById("bookname").value;
    var data;
    var url="http://localhost:8080/LMS/searchBook?bookname=".concat(ubookname);
    request.open('GET', url, false);
    request.onload = function () {
      // Begin accessing JSON data here
       data = JSON.parse(this.response);
      console.log(data);
      
      
}
request.send();


optionText = "shashank";
     optionValue = "shashank";
    
$('#select1').append($('<option>').val(optionValue).text(optionText));





}

  