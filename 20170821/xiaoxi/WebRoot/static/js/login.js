$(function(){

   $("#loginform_submit").click(function(){

       if(checkInput()) {

           $("form").action("login.do");

       }else{

           return false;

       }

   });

 /*  $(".validationCode_img").click(function(){

       $(".validationCode_img").attr("src","/UserLogin/Sample1/validationCode?"+Math.random());

   });*/

    function checkInput(){

        //�ж��û���

        if($("input[name=username]").val() == null || $("input[name=username]").val() == ""){

            alert("�û�������Ϊ��123");

            $("input[name=username]").focus();

            return false;

        }

        //�ж�����

        if($("input[name=password]").val() == null || $("input[name=password]").val() == ""){

            alert("���벻��Ϊ��");

            $("input[name=password]").focus();

            return false;

        }

        //�ж���֤��

        if($("input[name=code]").val() == null || $("input[name=code]").val() == ""){

            alert("��֤�벻��Ϊ��");

            $("input[name=code]").focus();

            return false;

        }

        return true;

    }

});