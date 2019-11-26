

function updateBookList() {
    $.ajax({
        url: "http://localhost:8085/backoffice/books/list"
    }).then(function(data) {
        $('#booklist-body').empty();
        data.forEach(function(row) {
            var tr = $('<tr class=test><td>' + row.bookId +  '</td>' +
                       '<td>' + row.title + '</td>' +
                       '<td>' + row.price + '</td>' +
                       '<td>' + row.catId + '</td>' +
                       '<td>' + row.authorId + '</td>' +
                       '</tr>');
                       var td_update = $('<td><input type="submit" value="Update Book"></td>').on('click', function(){
                                 $("#u-id").val(row.bookId);
                                 $("#u-tit").val(row.title);
                                 $("#u-pr").val(row.price);
                                 $('#u-btn').on("click", function(){
                                 var data = {  bookId: id, title: bookTitle, price: bookPrice, authorId: authorId, catId: catId};
                                  $.ajax({
                                      url: "http://localhost:8085/backoffice/books/update",
                                      type: 'POST',
                                      data: JSON.stringify(data),
                                      contentType: "application/json; charset=utf-8",
                                      dataType: "json",
                                       success: function(){
                                                    $('.book').empty().append("The result is correct! Congratulations!");
                                                  }
                                  });
                                  updateBookList();
                                 });
                         });
                       var td_delete = $('<td><input type="submit" value="Delete Book"></td>').on('click', function(){
                               $.ajax({
                                   url : '/backoffice/books/delete/{id}',
                                    data :  {'id' :row.bookId},
                                   type: 'DELETE'
                               });
                               updateBookList();
                          });
                      $(tr).append(td_update);
                      $(tr).append(td_delete);
             $('#booklist-body').append(tr);
        });
    });
}

function updateBookForm(){
     $("#book-form-add").submit(function( event ) {

            // Don't submit the form normally
            //event.preventDefault();

            // Get some values from elements on the page
            //var id = $('.book_id').text();
            var title = $('.title').text();
            var price = $('.price').text();
            var auth_id  = $('#auth').children("option:selected").val();
            var cat_id  = $('#cat').children("option:selected").val();
            var $form = $( this ),
                //id = $form.find( "input[name='bookId']" ).val(),
                bookTitle = $form.find( "input[name='title']" ).val(),
                bookPrice = $form.find( "input[name='price']" ).val(),
                auth_id =  $form.find("select[name='auth-list']").children("option:selected").val(),
                cat_id =  $form.find("select[name='cat-list']").children("option:selected").val();


            // Compose the data in the format that the API is expecting
            var data = {  title: bookTitle, price: bookPrice, authId: auth_id, catId: cat_id };


            // Send the data using post


            $.ajax({
                url: 'http://localhost:8085/backoffice/books/add',
                type: 'POST',
                data: JSON.stringify(data),
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                success: function(){
                  $('.book').empty().append("The result is correct! Congratulations!");
                }
            });

            updateBookList();
        });
}


function updateBookUpdateForm(){
     $("#book-form-update").submit(function( event ) {

            // Don't submit the form normally
            //event.preventDefault();

            // Get some values from elements on the page
            //var id = $('.book_id').text();
            //var title = $('.title').text();
           // var price = $('.price').text();
            var cat_id  = $('#u-cat').children("option:selected").val();
            var auth_id  = $('#u-auth').children("option:selected").val();
            var $form = $( this ),
                id = $form.find( "input[name='bookId']" ).val(),
                bookTitle = $form.find( "input[name='title']" ).val(),
                bookPrice = $form.find( "input[name='price']" ).val(),
                auth_id =  $form.find("select[name='auth-list']").children("option:selected").val(),
                cat_id =  $form.find("select[name='cat-list']").children("option:selected").val();


            // Compose the data in the format that the API is expecting
            var data = {  bookId: id, title: bookTitle, price: bookPrice, authorId: auth_id, catId: cat_id };


            // Send the data using post


            $.ajax({
                url: 'http://localhost:8085/backoffice/books/update',
                type: 'POST',
                data: JSON.stringify(data),
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                success: function(){
                  $('.book').empty().append("The result is correct! Congratulations!");
                }
            });

            updateBookList();
        });
}
function updateCatForm(){
         $("#cat-form").submit(function( event ) {
            var id = $('#cat_id').text();
            var catName = $('.cat_name').text();
            var $form = $( this ),
                id = $form.find( "input[name='catId']" ).val(),
                catName = $form.find( "input[name='catName']" ).val();

            // Compose the data in the format that the API is expecting
            var data = {  catId: id, name: catName};

            // Send the data using post


            $.ajax({
                url: 'http://localhost:8085/backoffice/categories/add',
                type: 'POST',
                data: JSON.stringify(data),
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                success: function(){
                  $('.book').empty().append("The result is correct! Congratulations!");
                }
            });

            updateBookList();
         });
}

function updateAuthorForm(){
         $("#author-form-add").submit(function( event ) {
            var first_name = $('#first_name').text();
            var last_name = $('#last_name').text();
            var $form = $( this ),
                first_name = $form.find( "input[name='firstName']" ).val(),
                last_name = $form.find( "input[name='lastName']" ).val();

            // Compose the data in the format that the API is expecting
            var data = {  firstName: first_name, lastName: last_name};

            // Send the data using post


            $.ajax({
                url: 'http://localhost:8085/backoffice/authors/add',
                type: 'POST',
                data: JSON.stringify(data),
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                success: function(){
                  $('.book').empty().append("The result is correct! Congratulations!");
                }
            });

            updateBookList();
         });
}

function loadAuthors(){

        var authList = $('#auth');
        var u_authList = $('#u-auth');
        $.ajax({
            url: 'http://localhost:8085/backoffice/authors/list'
            }).then(function(data){
              authList.html('');
              $.each(data, function (id, option) {
                  authList.append('<option value="' + option.id + '">' +  option.lastName + '</option>');
                  u_authList.append('<option value="' + option.id + '">' +  option.lastName + '</option>');
               });
            });
}

function loadCategories(){

        var catList = $('#cat');
        var u_catList = $('#u-cat');
        $.ajax({
            url: 'http://localhost:8085/backoffice/categories/list'
            }).then(function(data){
              catList.html('');
              $.each(data, function (catId, option) {
                  //catList.append($('<option></option>').val(option.catId).html(option.name));
                  catList.append('<option value="' + option.catId + '">' +  option.name + '</option>');
                  u_catList.append('<option value="' + option.catId + '">' +  option.name + '</option>');
               });
            });
}

$(document).ready(function() {



    loadCategories();

    loadAuthors();

    updateBookList();

    updateBookForm();

    updateBookUpdateForm();

    updateCatForm();

    updateAuthorForm();





});
