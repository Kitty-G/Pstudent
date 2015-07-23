
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
    });
    $("#Captcha").blur(function(){
        $.post(
        "../../CaptchaCheckServlet",
        {captcha:$('#Captcha').val()},
        function(result){
            if(result!=="1"){                               //form submit
                alert("验证码错误！");
                $("#submit").hide();
                $("#captchaimg").attr('src','/project/Kaptcha.jpg?a'+Math.random() + 10);
            }else if(result==="1"){
                $("#submit").show();
            }

        }
        );
    });
    $('.page-container form .username, .page-container form .password').keyup(function(){
        $(this).parent().find('.error').fadeOut('fast');
    });

});