//
// function show() {
//
//     /* Access image by id and change
//     the display property to block*/
//     document.getElementById('image')
//         .style.display = "block";
//
//     document.getElementById('btnID')
//         .style.display = "none";
// }
//
// $(function(){
//     $('.minimized').click(function(event) {
//         var i_path = $(this).attr('src');
//         $('body').append('<div id="overlay"></div><div id="magnify"><img src="'+i_path+'"><div id="close-popup"><i></i></div></div>');
//         $('#magnify').css({
//             left: ($(document).width() - $('#magnify').outerWidth())/2,
//             // top: ($(document).height() - $('#magnify').outerHeight())/2 upd: 24.10.2016
//             top: ($(window).height() - $('#magnify').outerHeight())/2
//         });
//         $('#overlay, #magnify').fadeIn('fast');
//     });
//
//     $('body').on('click', '#close-popup, #overlay', function(event) {
//         event.preventDefault();
//         $('#overlay, #magnify').fadeOut('fast', function() {
//             $('#close-popup, #magnify, #overlay').remove();
//         });
//     });
// });

// (function ( $ ) {
//     $.fn.FormCache = function( options ) {
//         var settings = $.extend({
//         }, options );
//
//         return this.each(function() {
//             var element = $(this);
//         });
//     };
// }( jQuery ));

const save1 = document.getElementsByName('price');
for (var i = 0; i < save1.length; i++) {
    save1[i].onclick = function() {
        localStorage.setItem('Radio_1', this.value);
    }
}

let Radio1 = localStorage.getItem('Radio_1');
if (Radio1) {
    let inp = document.querySelector('input[name="price"][value="' + Radio1 + '"]');
    if (inp) {
        inp.checked = true;
    }
}

const save2 = document.getElementsByName('contact');
for (var i = 0; i < save2.length; i++) {
    save2[i].onclick = function() {
        localStorage.setItem('Radio_2', this.value);
    }
}

let Radio2 = localStorage.getItem('Radio_2');
if (Radio2) {
    let inp = document.querySelector('input[name="contact"][value="' + Radio2 + '"]');
    if (inp) {
        inp.checked = true;
    }
}



