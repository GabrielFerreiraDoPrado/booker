<%@ page import="utils.flashmessage.FlashMessageType" %>
<div class="flashMessage js-flashmessage ${flash.type == FlashMessageType.SUCCESS ? 'bg-success' : 'bg-danger'} col-6"
     style="position: absolute; top: 1.5rem; right: 25%; text-align: center; z-index: 1" role="alert" aria-live="assertive" aria-atomic="true" data-delay="2000">
    <div class="toast-body text-white font-weight-bold">
      ${flash.message}
    </div>
</div>