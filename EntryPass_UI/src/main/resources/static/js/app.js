function yourFunction(){
        var action_src = "/rest/visitorui/find/" + document.getElementsByName("id")[0].value;
        var your_form = document.getElementById('your_form');
        visitorbyid.action = action_src ;
    }