var showing = false;

const handleHomeClick = (test) => {
  if (showing) {
    $(".popup").css({'display':'none'});
    showing = false;
    return
  }
  $('.popup').fadeIn(500);
  showing = true;
  $('#items').append("<h1>" + test.childNodes[3].innerText + "</h1> <br> <img src='" + test.children[0].src + "' style='width:100%;'><br> <p>This is our current project </p>");
}

const hidePopupOnX = (test) => {
  showing = false;
  $(".popup").css({'display':'none'});
  $('#items').empty();
};

//calculator
const display = (val) => {
  document.getElementById("display").value += val
}

const solve = () => {
  let x = document.getElementById("display").value
  let y = eval(x)
  document.getElementById("display").value = y
}

const exit = () => {
  if (confirm('Are you sure you want to Exit?')) {
    window.location.href = "http://p3me2020.c1.biz/"
  }
}
const clean = () => {
  document.getElementById("display").value = "";
}

$('#test-form').submit((e) => {
  e.preventDefault();
  let backup = $('#contact-body').html()
  $('#contact-body').empty();
  $('#contact-body').append(
     `  <div class="container">
           <div class"shadow pt-5 pb-5" style="text-align:center;height:680px;">
              <h1 style="padding-top:20%;"> Thank You!</h1>
              <h6 class ="p-2"> We will get back to you as soon as possible.</h6> 
              <p style="color:green;">
                 <svg width="5em" height="5em" viewBox="0 0 16 16" class="bi bi-check-circle-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                 <path fill-rule="evenodd" d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
                 </svg>
              </p>
           </div>
        </div>
     `
  );
  setTimeout(() => {
     $('#contact-body').empty();
     $('#contact-body').append(backup);
  }, 3000);
});
$('#home').fadeIn(1000);
$('#calc').fadeIn(1000);
$('#about').fadeIn(1000);
$('#contact').fadeIn(1000);
$('#staff').fadeIn(2000);
$('.footer').fadeIn(1000);