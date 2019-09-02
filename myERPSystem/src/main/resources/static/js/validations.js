function field_focus(field, email)
  {
    if(field.value == email)
    {
      field.value = '';
    }
  }

  function field_blur(field, email)
  {
    if(field.value == '')
    {
      field.value = email;
    }
  }

//Fade in dashboard box
$(document).ready(function(){
    $('.box').hide().fadeIn(1000);
    });

//Stop click event
$('a').click(function(event){
    event.preventDefault(); 
	});

if ($('#remember').attr('checked')) 
	{
		var email = $('#email').attr("value");
		var password = $('#password').attr("value");

		// set cookies to expire in 14 days
		$.cookie('email', email, { expires: 14 });
		$.cookie('password', password, { expires: 14 });
		$.cookie('remember', true, { expires: 14 });                
	}
	else
	{
		// reset cookies
		$.cookie('email', null);
		$.cookie('password', null);
		$.cookie('remember', null);
	}

	var remember = $.cookie('remember');
	if (remember == 'true') 
	{
		var email = $.cookie('email');
		var password = $.cookie('password');
		// autofill the fields
		$('#email').attr("value", email);
		$('#password').attr("value", password);
	}