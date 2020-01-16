

function login() {

    $("#login-form").submit(function( event ) {
           // alert("start okk");
            var user_name = $('#user_name').text();
            var pass_word = $('#pass').text();
            var $form = $( this ),
                //id = $form.find( "input[name='bookId']" ).val(),
                user_name = $form.find( "input[name='username']" ).val(),
                pass_word = $form.find( "input[name='password']" ).val();

            // Compose the data in the format that the API is expecting
            var data = {  username: user_name, password: pass_word};


            // Send the data using post


            $.ajax({
                url: 'http://localhost:8085/backoffice/cms/login',
                type: 'POST',
                data: JSON.stringify(data),
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                success: function(data, textStatus, jQxhr){
                    //alert("success");
                    // alert("first-" + textStatus);
                    //if (data.true){
                        alert("ok");
                        top.location.href = 'backoffice.html';
                   // } else {
                       // top.location.href = 'login.html';
                  //  }
                },
                error: function( jqXhr, textStatus, errorThrown ){
                    //alert("error");
                   // alert("second-" + textStatus);
                    console.log( errorThrown );
                 }

                });

/*

success: function( data, textStatus, jQxhr ){
                    $('#response pre').html( data );
                },
                error: function( jqXhr, textStatus, errorThrown ){
                    console.log( errorThrown );
                }
then(function(data){
              authList.html('');
              $.each(data, function (id, option) {
                  authList.append('<option value="' + option.id + '">' +  option.lastName + '</option>');
                  u_authList.append('<option value="' + option.id + '">' +  option.lastName + '</option>');
               });
            });


         success: function(data, textStatus) {
                 if (data.redirect) {
                     // data.redirect contains the string URL to redirect to
                     window.location.href = data.redirect;
                 } else {
                     // data.form contains the HTML for the replacement form
                     $("#myform").replaceWith(data.form);
                 }
             }
*/



    });

}


$(document).ready(function() {

    login();
});