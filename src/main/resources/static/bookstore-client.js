function updateBookStore() {
    $.ajax({
        url: "http://localhost:8085/backoffice/books"
    }).then(function(data) {
        // Cleans the form
        $("#attempt-form").find( "input[name='result-attempt']" ).val("");
        $("#attempt-form").find( "input[name='user-alias']" ).val("");
        // Gets a random challenge from API and loads the data in the HTML
        $('.multiplication-a').empty().append(data.factorA);
        $('.multiplication-b').empty().append(data.factorB);

    });

}


function loadCategories(){

        var catList = $('#cat');
        var bookTitle = $('.book')
        var bookTable = $('#bookitem')
        $.ajax({
            url: 'http://localhost:8085/backoffice/categories/list'
            }).then(function(data){
              //bookTitle.html(data);
              $.each(data, function (catId, option) {
                  catList.append('<option value="' + option.catId + '">' +  option.name + '</option>').on("change", function(){
                    });
               });
            });
}

function getBooks(){
   var bookTitle = $('.book')
   var bookTable = $('#bookitem')
   $('#cat').change( function(){
            var selectedOption = $('#cat option:selected');
            var selectedText = selectedOption.text();
            var selectedValue = selectedOption.val();
             bookTitle.html(selectedOption.val());
             bookTable.hide();
            //alert(selectedValue + " : " + selectedText);

            $.ajax({
                    url: "http://localhost:8085/bookstore/categories/{catId}/books",
                    data:{"catId":selectedValue}
                }).then(function(data) {
                    $('#booklist-body').empty();
                    data.forEach(function(row) {
                        var tr = $('<tr class=test><td>' + row.bookId +  '</td>' +
                                   '<td>' + row.title + '</td>' +
                                   '<td>' + row.price + '</td>' +
                                   '<td>' + row.catId + '</td>' +
                                   '<td>' + row.authorId + '</td>' +
                                   '<td> <input type="text" name="amount" id="amnt"> </td>' +
                                   '</tr>');
                                   var td_add_to_cart = $('<td><input type="submit" value="Add to Cart"></td>').on('click', function(){
                                                 var data = {  bookId: row.bookId, amount: $('#amnt').val(), price: row.price, date:'2020-01-14'};
                                                 $.ajax({
                                                     url: "http://localhost:8085/bookstore/cart/add",
                                                     type:'POST',
                                                     data: JSON.stringify(data),
                                                     contentType: "application/json; charset=utf-8",
                                                     dataType: "json",
                                                    success: function(){
                                                         alert("bookId=" + data.bookId + " - " +  "price=" + data.price + " - " + "amount=" + data.amount + " - " );
                                                         }
                                                     });
                                    });

                        $(tr).append(td_add_to_cart);
                    $('#booklist-body').append(tr);
                    });
                });

    });
}




$(document).ready(function() {

    loadCategories();
    getBooks();
});
