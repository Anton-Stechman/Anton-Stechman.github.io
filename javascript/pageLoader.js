const pageArea      = document.querySelector('.page-display');
const loadingScreen = document.querySelector('.loadingScreen');

function loadPage(page, button)
{
    $(pageArea).attr('src', page);
    console.log(button);
}
