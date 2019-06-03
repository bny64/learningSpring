(function(){
	'use strcit';
	
	document.querySelector("#signupBtn").addEventListener('click', ()=>{
		
		const id = document.querySelector('#id').value;
		const name = document.querySelector('#name').value;
		const email = document.querySelector('#email').value;
		const password = document.querySelector('#password').value;
		const address = document.querySelector('#address').value;
		
		const result = validateCheck(id, name, email, password);
		if(!result) return;
		
		const sendData = {
			id : id,
			name : name,
			email : email,
			password : password,
			address : address
		};
		const xhr = new XMLHttpRequest();
		
		xhr.onload = () => {
			if(xhr.status==200){
				const response = JSON.parse(xhr.responseText);
				if(response.result){
					alert('가입에 성공했습니다.');
				}else{
					alert('가입에 실패했습니다.');
				}
				
			}else{
				console.error(xhr.responseText);
			}
		};
		
		xhr.open('POST', '/auth/insertUser');
		xhr.setRequestHeader('Content-type', "application/json");
        xhr.send(JSON.stringify(sendData));        
		
	});
	
	function validateCheck(id, name, email, pass){
		
		if(id.trim().length==0){
			alert('아이디를 입력해 주세요.');
			return false;
		}else if(id.trim().length>30){
			alert('아이디는 최대 30자 입니다.');
			return false;
		}
		
		if(name.trim().length==0){
			alert('이름을 입력해 주세요.');
			return false;
		}else if(name.trim().length>30){
			alert('이름은 최대 30자 입니다.');
			return false;
		}
		
		if(email.match(/^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{1,5}|[0-9]{1,3})(\]?)$/) == null) {
			alert('이메일 형식에 맞게 입력해 주세요.');
			return false;
		}
		
		if(pass.trim().length==0){
			alert('패스워드를 입력해 주세요.');
			return false;
		}else if(pass.trim().length>20 || pass.trim().length < 10){
			alert('패스워드는 10~20자 사이로 입력해 주세요.');
			return false;
		}
		
		return true;
		
	}
	
})();