const rButtons      = document.querySelector('.buttons-right');
const lButtons      = document.querySelector('.buttons-left');
const rightButtons  = Array.from(rButtons.children);
const leftButtons   = Array.from(lButtons.children);
const navButtons    = leftButtons.concat(rightButtons);
const pageArea      = document.querySelector('.page-display');

var currentButton;
var nextButton;

const  getCurrentButton = () =>
{
    currentButton = document.querySelector('.navButton-selected');
}

const setCurButton = (nBtn) =>
{
    getCurrentButton();
    
    if (currentButton != null)
    {
        $(currentButton).removeClass('navButton-selected');
    }
    
    if (nBtn != null)
    {
        $(nBtn).addClass('navButton-selected');
        currentButton = nBtn;
    }
}

const loadPage = (page, button, title) =>
{
    $(pageArea).attr('src',page);
    setCurButton(button);
    document.title = title;
}



window.onload = () =>
{
    //loadPage("test.html",false);
}