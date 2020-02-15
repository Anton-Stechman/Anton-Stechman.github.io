const rButtons      = document.querySelector('.buttons-right');
const lButtons      = document.querySelector('.buttons-left');
const rightButtons  = Array.from(rButtons.children);
const leftButtons   = Array.from(lButtons.children);
const navButtons    = leftButtons.concat(rightButtons);
const pageArea      = document.querySelector('.page-display');

var currentButton;
var nextButton;
var title;


var  getCurrentButton = () =>
{
   return document.querySelector('.navButton-selected');
}

const setCurButton = (nBtn) =>
{
    currentButton = getCurrentButton();
    
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

const loadPage = (page, button, inputTitle) =>
{   
    $(pageArea).attr('src',page);
    setCurButton(button);
    
    
    title           = inputTitle;
    document.title  = title;
}



window.onload = () =>
{
    if(getCurrentButton != null && title != null)
    {
        document.title = title;
    }
}