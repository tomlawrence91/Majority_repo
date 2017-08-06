//---------------------------------------
//Firebase interaction
//---------------------------------------
$(function () {
    const config = {
        //Initialise Firebase
        apiKey: "AIzaSyDkoCXYDkvU0abL5nrx-GnIf6jpfKBxlyE",
        authDomain: "majorityweb.firebaseapp.com",
        databaseURL: "https://majorityweb.firebaseio.com",
        projectId: "majorityweb",
        storageBucket: "majorityweb.appspot.com",
        messagingSenderId: "1052849591343"
    };
    firebase.initializeApp(config);
    const database = firebase.database(); //Reference Database

//---------------------------------------
//User creation, login, logout
//---------------------------------------

//User Login
    $('.login-form').on('submit', event => {
        event.preventDefault();
        const email = $('#login-email').val();
        const password = $('#login-password').val();
        console.log(email, password);
        firebase.auth().signInWithEmailAndPassword(email, password).catch(function(error) {
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


//User Creation
    $('.register-form').on('submit', event => {
        event.preventDefault();
        const email = $('#reg-email').val();
        const password = $('#reg-password').val();
        const userName = $('#reg-name').val();
        //creates user in firebase authentication
        firebase.auth().createUserWithEmailAndPassword(email, password).catch(function(error) {
            var errorCode = error.code;
            var errorMessage = error.message;
        });

        //Creates user in realtime database
        firebase.auth().onAuthStateChanged(function(user) {
            if (user) {
                const dbRef = firebase.database().ref();
                var storesRef = dbRef.child('/users/');
                var newStoreRef = storesRef.push();
                newStoreRef.set({
                    "emailAddress": email,
                    "name": userName,
                    "userId": "temp",
                });
                window.location.href = "home.html";
            } else {
            }
        })
    })


//User Logout
    $('.logout').on('click', event => {
        event.preventDefault();
        firebase.auth().signOut().then(function() {
            window.location.href = "index.html";
        }).catch(function(error) {
          // An error happened.
        });
    })


//---------------------------------------
//Project creation, view, edit etc.
//---------------------------------------

//Add Project
    $('#submit-project').on('click', event => {
        event.preventDefault();
        const projectName = $('#project-name').val();
        const projectSummary = $('#project-summary').val();
        const projectDetail = $('#project-detail').val();
        const budgetEstimate = $('#budget-estimate').val();
        const dateAdded = Date.now();
        const image = "image";
        const votesYes = 0;
        const votesNo = 0;
        const dbRef = firebase.database().ref();
        var storesRef = dbRef.child('/project/');
        var newStoreRef = storesRef.push();
        newStoreRef.set({
            "projectName": projectName,
            "projectSummary": projectSummary,
            "projectDetail": projectDetail,
            "budgetEstimate": budgetEstimate,
            "dateAdded": dateAdded,
            "image": "temp",
            "votesYes": votesYes,
            "votesNo": votesNo,
            "projectProposer": "temp",
        });
        console.log(projectName, projectSummary, projectDetail, budgetEstimate, dateAdded );
    })


//View All Projects
    if (window.location.href.match('projects.html') != null) {
        var query = firebase.database().ref("/project/").orderByKey();
        query.once("value")
          .then(function(snapshot) {
            snapshot.forEach(function(childSnapshot) {
              // key will be "ada" the first time and "alan" the second time
              var key = childSnapshot.key;
              var projectName = snapshot.child(key + "/projectName").val();
              var budgetEstimate = snapshot.child(key + "/budgetEstimate").val();
              var projectDetail = snapshot.child(key + "/projectDetail").val();
              var projectSummary = snapshot.child(key + "/projectSummary").val();
              var image = snapshot.child(key + "/image").val();
              //var attr = snapshot.child(key).val(); // {first:"Ada",last:"Lovelace"}
              // childData will be the actual contents of the child

              console.log(key, projectName, budgetEstimate, projectDetail, projectSummary);
          });
      });
  }
});

//---------------------------
// Controller scripts
//---------------------------
function htmlbodyHeightUpdate() {
    var height3 = $(window).height();
    var height1 = $('.nav').height() + 50;
    var height2 = $('.container-main').height();
    if (height2 > height3) {
        $('html').height(Math.max(height1, height3, height2) + 10);
        $('body').height(Math.max(height1, height3, height2) + 10);
    } else
    {
        $('html').height(Math.max(height1, height3, height2));
        $('body').height(Math.max(height1, height3, height2));
    }

}
//document.ready
$(document).ready(function () {

    htmlbodyHeightUpdate();
    $(window).resize(function () {
        htmlbodyHeightUpdate();
    });
    $(window).scroll(function () {
        height2 = $('.container-main').height();
        htmlbodyHeightUpdate();
    });

    //toggles user login and create user
    $('.message a').click(function(){
        $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
    });

});
