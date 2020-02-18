var s1=s2=s3=s4=s5=false;
function dealUsername(){
	var v1=document.getElementById("username");
	var v2=document.getElementById("span01");
	if(v1.value==null||v1.value==""){
		v2.style.display="";
	}else{
		s1=true;
                v2.style.display="none";
        }
}
 
function dealAge(){
	var v1=document.getElementById("age");
	var v2=document.getElementById("span02");
	if(v1.value<17){
		v2.style.display="";
	}else{
		v2.style.display="none";
		s2=true;
	}
}
 
function dealPassword(){
	var v1=document.getElementById("password");
	var v2=document.getElementById("span03");
	if(v1.value.length<8){
		v2.style.display="";
	}else{
		v2.style.display="none";
		s3=true;
	}
}
 
function dealPassword01(){
	var v1=document.getElementById("password01");
	var v2=document.getElementById("span04");
	var v3=document.getElementById("password");
	if(v1.value!=v3.value){
		v2.style.display="";
	}else{
		v2.style.display="none";
		s4=true;
	}
}
 
function dealEmail(){
	var v1=document.getElementById("email");
	var v2=document.getElementById("span05");
	if(v1.value.indexOf("@")==-1){
		v2.style.display="";
	}else{
		v2.style.display="none";
		s5=true;
	}
}
 
function dealSubmit(){
	var v1=s1&&s2&&s3&&s4&&s5;
	if(!v1){
		alert("注册失败!");
		return false;//不会跳转
	}else{
		return true;
	}
}
