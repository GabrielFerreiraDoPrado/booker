function FlashMessageController() {
    var _this = this;
    _this.reference = $(".js-main-container");
    _this.feedbackToast = _this.reference.find(".js-flashmessage")

    _this.init = function() {
        _this.feedbackToast.toast('show')
    }

    _this.setFeedBackToast = function() {
        _this.feedbackToast.toast('show')
    }
}

$(document).ready(function() {
    var flashMessageController = new FlashMessageController();
    flashMessageController.init();
});