$(function () {
    //Initialise firebase
    var config = {
      apiKey: "AIzaSyDkoCXYDkvU0abL5nrx-GnIf6jpfKBxlyE",
      authDomain: "majorityweb.firebaseapp.com",
      databaseURL: "https://majorityweb.firebaseio.com",
      projectId: "majorityweb",
      storageBucket: "majorityweb.appspot.com",
      messagingSenderId: "1052849591343"
    };
    firebase.initializeApp(config);
    //database ref
    var database = firebase.database();
    //Login user
    $('.login-form').on('submit', event => {
        event.preventDefault();
        const email = $('#login-email').val();
        const password = $('#login-password').val();
        console.log(email, password);
        firebase.auth().signInWithEmailAndPassword(email, password).catch(function(error) {
            // Handle Errors here.
            var errorCode = error.code;
            var errorMessage = error.message;

        });
        firebase.auth().onAuthStateChanged(function(user) {
              if (user) {
                window.location.href = "home.html";
              } else {

              }
        })
    })

    //Create user
    $('.register-form').on('submit', event => {
        event.preventDefault();
        const email = $('#reg-email').val();
        const password = $('#reg-password').val();
        firebase.auth().createUserWithEmailAndPassword(email, password).catch(function(error) {
          // Handle Errors here.
          var errorCode = error.code;
          var errorMessage = error.message;
          // ...
        });
        firebase.auth().onAuthStateChanged(function(user) {
              if (user) {
                window.location.href = "home.html";
              } else {

              }
        })
    })

})

//Logout user
$( ".logout" ).click(function(e) {
    e.preventDefault();
    firebase.auth().signOut().then(function() {
        alert("user out");
      window.location.href = "index.html";
    }).catch(function(error) {
      // An error happened.
    });
});




    /* Set the width of the side navigation to 0 and the left margin of the page content to 0 */

    function htmlbodyHeightUpdate() {
    var height3 = $(window).height();
    var height1 = $('.nav').height() + 50;
    height2 = $('.container-main').height();
    if (height2 > height3) {
        $('html').height(Math.max(height1, height3, height2) + 10);
        $('body').height(Math.max(height1, height3, height2) + 10);
    } else
    {
        $('html').height(Math.max(height1, height3, height2));
        $('body').height(Math.max(height1, height3, height2));
    }

}
$(document).ready(function () {
    htmlbodyHeightUpdate();
    $(window).resize(function () {
        htmlbodyHeightUpdate();
    });
    $(window).scroll(function () {
        height2 = $('.container-main').height();
        htmlbodyHeightUpdate();
    });


    $('.message a').click(function(){
       $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
    });

});
