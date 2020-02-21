const links     = document.querySelector('.links');
const addButton = document.querySelector('.add');
const resButton = document.querySelector('.reset');
const logo      = document.querySelector('.logo');
const alt       = document.querySelector('.alt');
const link      = document.querySelector('.link');
var prefs;
var i;

var validate_newLink = () =>
{
    if (logo.value == "")
    {
        return false;
    }
    if (alt.value == "")
    {
        return false;
    }
    if (link.value == "")
    {
        return false;
    }
    
    return true;
}

//SAVE-LOAD PREFS
function clear_prefs() 
{
    localStorage.clear();
    location.reload();
}

var check_for_prefs = () =>
{
    if(JSON.parse(localStorage.getItem('prefs')) != null)
    {
        return true;
    }
    else
    {
        return false;
    }
}

function load_prefs()
{
    //TODO: retrieve from localStorage
    prefs           = JSON.parse(localStorage.getItem('prefs'));
    links.innerHTML = prefs.layout;
}
function save_prefs(updated_prefs)
{
    //TODO: save to localStorage 
    prefs.layout = updated_prefs;
    
    localStorage.setItem('prefs',JSON.stringify(prefs));
    location.reload();
}

var format_button = () =>
{
    var str = "<button class='linkB' value="+link.value+"><img src="+logo.files[0]+" alt="+alt.value+"></button>";
    return str;
}

function add_new_link()
{
    //TODO: Add image, href & alt text
    var str = prefs.layout;
    
    if (validate_newLink())
    {
        str += format_button();
        links.innerHTML = str;
        save_prefs(str);
        var nl = newLink(link.value, logo.files[0], alt.value, 'newLink' + i);
    }
    else
    {
        alert("Please Fill in all fields to create new link");
    }
}

addButton.addEventListener('click', function(){add_new_link();});
resButton.addEventListener('click', function(){clear_prefs();});

window.onload = () =>
{
    if (check_for_prefs()) //if there is a prefs file load that
    {
        load_prefs();
    }
    else //if there is no default prefs class create a new one
    {
        prefs           = new page_prefs(links.innerHTML);
        prefs.layout    = links.innerHTML;
        i = 0;
    }
}

class newLink
{
    construct(link, logo, alt, id)
    {
        this.link   = link;
        this.logo   = logo;
        this.alt    = alt;
        this.id     = id;
    }
}

class page_prefs
{
    construct(layout)
    {
        this.layout = layout;
    }
}