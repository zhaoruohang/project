getToken();
function getToken(){
      var token=window.sessionStorage.getItem("uid");
	    if ( token == undefined) {
        location.href = 'login.html'; //登录界面
       }
	    var lastTime = new Date().getTime();
			var currentTime = new Date().getTime();
			var timeOut = 5*60 * 1000; //设置超时时间： 1分
 
window.onload = function () {
	
    window.document.onmousedown = function () {
        localStorage.setItem("lastTime", new Date().getTime());
    }
};
 
function checkTimeout() {
    currentTime = new Date().getTime(); //更新当前时间
    lastTime = localStorage.getItem("lastTime");
    // console.log(currentTime - lastTime);
    // console.log(timeOut);
    if (currentTime - lastTime > timeOut) { //判断是否超时
        // console.log("超时");
        location.href = 'login.html'; //登录页面
    }
}
 
/* 定时器 间隔30秒检测是否长时间未操作页面 */
window.setInterval(checkTimeout, 30000);


}