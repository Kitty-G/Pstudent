
jQuery(document).ready(function() {

    $('.page-container form').submit(function(){
        var username = $(this).find('.username').val();
        var password = $(this).find('.password').val();

        if(username == '') {
            $(this).find('.error').fadeOut('fast', function(){
                $(this).css('top', '27px');
            });
            $(this).find('.error').fadeIn('fast', function(){
                $(this).parent().find('.username').focus();
            });
            return false;
        }
		
        if(password == '') {
            $(this).find('.error').fadeOut('fast', function(){
                $(this).css('top', '96px');
            });
            $(this).find('.error').fadeIn('fast', function(){
                $(this).parent().find('.password').focus();
            });
            return false;
        }
        alert("start");
        $.post(
        "../../CaptchaCheckServlet",
        {captcha:$('#Captcha').val()},
        function(){
            alert("bingo");
            return false;
//            if(result==="1"){
//                return false;
//            }else if(result==="0"){
//                $("#Captcha").find('.error').fadeOut('fast', function(){
//                     $("#Captcha").css('top', '27px');
//                });
//                $("#Captcha").find('.error').fadeIn('fast', function(){
//                $("#Captcha").parent().find('.Captcha').focus();
//                });
//                return false;
//            }else{
//                $("#Captcha").find('.error').fadeOut('fast', function(){
//                $("#Captcha").css('top', '27px');
//                });
//                $("#Captcha").find('.error').fadeIn('fast', function(){
//                $("#Captcha").parent().find('.Captcha').focus();
//                });
//                return false;
//            }
        }
        );
            alert("end");
//            return false;
    });

    $('.page-container form .username, .page-container form .password').keyup(function(){
        $(this).parent().find('.error').fadeOut('fast');
    });

});