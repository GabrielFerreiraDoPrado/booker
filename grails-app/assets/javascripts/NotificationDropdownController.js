function NotificationDropdownController() {
    var _this = this;
    _this.reference = $(".js-main-container");
    _this.notification = _this.reference.find(".js-notification");
    _this.notificationContainer = _this.reference.find(".js-notification-container");
    _this.notificationDropdownMenu = _this.reference.find(".js-dropdown-menu");

    _this.init = function() {
        _this.getUserNotification();
        _this.bindNotificationContainer();
        _this.bindNotificationButton();
        _this.bindNotification();
    }

    _this.getUserNotification = function() {
        $.ajax({
            type: "GET",
            url: "/notification/listUnreadNotification",
            dataType: "json",
            success: (data) => {
                if (data.length < 1) {
                    return
                }

                _this.notification.attr("src", "/assets/bell-active.svg")
                for (const item of data) {
                    _this.setNotificationDropdownContent(item)
                }
            }
        });
    };

    _this.bindNotificationContainer = function() {
        _this.notificationContainer.addClass("dropdown");
    };

    _this.bindNotificationButton = function() {
        var notificationButton = _this.reference.find(".js-btn-notification")
        notificationButton.attr("data-mdb-toggle", "dropdown");
        notificationButton.attr("aria-expanded", false);
    };

    _this.setNotificationDropdownContent = function(notificationItem) {
        _this.notificationDropdownMenu.append(`
            <a class="text-decoration-none" href="/notification/read/${notificationItem.id}">
                <div class="d-flex flex-column px-2 mt-2 mb-3 bg-white rounded-lg mx-2" style="cursor: pointer">
                    <span class="font-weight-bold text-dark" style="font-size: 1rem;">
                        ${notificationItem.title}
                    </span>
                    <span class="text-dark" style="font-size: 1rem;">
                        ${notificationItem.message}
                    </span>
                </div>
            </a>
        `)
    };
}

$(document).ready(function(){
    var notificationDropdownController = new NotificationDropdownController();
    notificationDropdownController.init();
});