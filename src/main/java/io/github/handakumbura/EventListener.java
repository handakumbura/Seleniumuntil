package io.github.handakumbura;

/***
 * The list is implemented based on https://www.w3schools.com/jsref/dom_obj_event.asp
 */
public enum EventListener {

    ABORT("abort"),
    AFTERPRINT("afterprint"),
    ANIMATIONEND("animationend"),
    ANIMATIONITERATION("animationiteration"),
    ANIMATIONSTART("animationstart"),
    BEFOREPRINT("beforeprint"),
    BEFOREUNLOAD("beforeunload"),
    BLUR("blur"),
    CANPLAY("canplay"),
    CANPLAYTHROUGH("canplaythrough"),
    CHANGE("change"),
    CLICK("click"),
    CONTEXTMENU("contextmenu"),
    COPY("copy"),
    CUT("cut"),
    DBLCLICK("dblclick"),
    DRAG("drag"),
    DRAGEND("dragend"),
    DRAGENTER("dragenter"),
    DRAGLEAVE("dragleave"),
    DRAGOVER("dragover"),
    DRAGSTART("dragstart"),
    DROP("drop"),
    DURATIONCHANGE("durationchange"),
    ENDED("ended"),
    ERROR("error"),
    FOCUS("focus"),
    FOCUSIN("focusin"),
    FOCUSOUT("focusout"),
    FULLSCREENCHANGE("fullscreenchange"),
    FULLSCREENERROR("fullscreenerror"),
    HASHCHANGE("hashchange"),
    INPUT("input"),
    INVALID("invalid"),
    KEYDOWN("keydown"),
    KEYPRESS("keypress"),
    KEYUP("keyup"),
    LOAD("load"),
    LOADEDDATA("loadeddata"),
    LOADEDMETADATA("loadedmetadata"),
    LOADSTART("loadstart"),
    MESSAGE("message"),
    MOUSEDOWN("mousedown"),
    MOUSEENTER("mouseenter"),
    MOUSELEAVE("mouseleave"),
    MOUSEMOVE("mousemove"),
    MOUSEOVER("mouseover"),
    MOUSEOUT("mouseout"),
    MOUSEUP("mouseup"),
    MOUSEWHEEL("mousewheel"),
    OFFLINE("offline"),
    ONLINE("online"),
    OPEN("open"),
    PAGEHIDE("pagehide"),
    PAGESHOW("pageshow"),
    PASTE("paste"),
    PAUSE("pause"),
    PLAY("play"),
    PLAYING("playing"),
    POPSTATE("popstate"),
    PROGRESS("progress"),
    RATECHANGE("ratechange"),
    RESIZE("resize"),
    RESET("reset"),
    SCROLL("scroll"),
    SEARCH("search"),
    SEEKED("seeked"),
    SEEKING("seeking"),
    SELECT("select"),
    SHOW("show"),
    STALLED("stalled"),
    STORAGE("storage"),
    SUBMIT("submit"),
    SUSPEND("suspend"),
    TIMEUPDATE("timeupdate"),
    TOGGLE("toggle"),
    TOUCHCANCEL("touchcancel"),
    TOUCHEND("touchend"),
    TOUCHMOVE("touchmove"),
    TOUCHSTART("touchstart"),
    TRANSITIONEND("transitionend"),
    UNLOAD("unload"),
    VOLUMECHANGE("volumechange"),
    WAITING("waiting"),
    WHEEL("wheel"),
    ALTKEY("altKey"),
    ANIMATIONNAME("animationName"),
    BUBBLES("bubbles"),
    BUTTON("button"),
    BUTTONS("buttons"),
    CANCELABLE("cancelable"),
    CHARCODE("charCode"),
    CHANGETOUCHES("changeTouches"),
    CLIENTX("clientX"),
    CLIENTY("clientY"),
    CLIPBOARDDATA("clipboardData"),
    CODE("code"),
    COMPOSED("composed"),
    CTRLKEY("ctrlKey"),
    CURRENTTARGET("currentTarget"),
    DATA("data"),
    DATATRANSFER("dataTransfer"),
    DEFAULTPREVENTED("defaultPrevented"),
    DELTAX("deltaX"),
    DELTAY("deltaY"),
    DELTAZ("deltaZ"),
    DELTAMODE("deltaMode"),
    DETAIL("detail"),
    ELAPSEDTIME("elapsedTime"),
    EVENTPHASE("eventPhase"),
    GETTARGETRANGES("getTargetRanges"),
    GETMODIFIERSTATE("getModifierState"),
    INPUTTYPE("inputType"),
    ISCOMPOSING("isComposing"),
    ISTRUSTED("isTrusted"),
    KEY("key"),
    KEYCODE("keyCode"),
    LOCATION("location"),
    LENGTHCOMPUTABLE("lengthComputable"),
    LOADED("loaded"),
    METAKEY("metaKey"),
    MOVEMENTX("MovementX"),
    MOVEMENTY("MovementY"),
    NEWVALUE("newValue"),
    NEWURL("newURL"),
    OFFSETX("offsetX"),
    OFFSETY("offsetY"),
    OLDVALUE("oldValue"),
    OLDURL("oldURL"),
    ONEMPTIED("onemptied"),
    PAGEX("pageX"),
    PAGEY("pageY"),
    PERSISTED("persisted"),
    PREVENTDEFAULT("preventDefault"),
    PROPERTYNAME("propertyName"),
    PSEUDOELEMENT("pseudoElement"),
    REGION("region"),
    RELATEDTARGET("relatedTarget"),
    REPEAT("repeat"),
    SCREENX("screenX"),
    SCREENY("screenY"),
    SHIFTKEY("shiftKey"),
    STATE("state"),
    STOPIMMEDIATEPROPAGATION("stopImmediatePropagation"),
    STOPPROPAGATION("stopPropagation"),
    STORAGEAREA("storageArea"),
    TARGET("target"),
    TARGETTOUCHES("targetTouches"),
    TIMESTAMP("timeStamp"),
    TOTAL("total"),
    TOUCHES("touches"),
    TYPE("type"),
    URL("url"),
    WHICH("which"),
    VIEW("view");

    private final String event;

    EventListener(String event) {
        this.event = event;
    }

    public String toString() {
        return event;
    }
}
