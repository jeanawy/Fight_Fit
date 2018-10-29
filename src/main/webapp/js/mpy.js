$(document).ready(function () {
    $('#sidebarCollapse').on('click', function () {
        $('#sidebar-menu-responsive').toggleClass('active animated fadeInDown');
        $('#signout-box').hide();
        $('#noti-box').hide();
    });

    $('#signout').click(function (event) {
        event.stopPropagation();
        $('#signout-box').toggle();
        $('#signout-box').addClass('animated fadeInDown');
        $('#noti-box').hide();
        $('#sidebar-menu-responsive').removeClass('active animated fadeInDown');
    });

    $(document).click(function () {
        $('#signout-box').hide();
    });

    $('#noti').click(function (event) {
        event.stopPropagation();
        $('#noti-box').toggle();
        $('#noti-box').addClass('animated fadeInDown');
        $('.bell-circle').hide();
        $('#signout-box').hide();
        $('#sidebar-menu-responsive').removeClass('active animated fadeInDown');
    });

    $(document).click(function () {
        $('#noti-box').hide();
    });
});